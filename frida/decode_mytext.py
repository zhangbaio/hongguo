# -*- coding: utf-8 -*-
"""解析 libEncryptor.so 的 .mytext 段(344B), 提取 ARM64 MOV/MOVK 立即数序列
-> 可能是 128bit 包装密钥"""
import struct

data = open("capture/so/libEncryptor.so","rb").read()
# .mytext: off=0x7d8c, size=344
off = 0x7d8c; size = 344
code = data[off:off+size]
print(f".mytext @ file {off:#x}, {size} bytes, {size//4} instructions")
print(f"hex: {code.hex()}")
print()

# ARM64 指令解码 MOV/MOVK/LDR
def decode_arm64(instr):
    """简单解码: MOVZ/MOVK/LDR"""
    # MOVZ: bits[30:29]=10, bits[28:23]=100101, bits[20:5]=imm16, bits[4:0]=Rd
    # MOVK: bits[30:29]=11, bits[28:23]=100101
    op = instr & 0xFFE00000
    rd = instr & 0x1F
    imm16 = (instr >> 5) & 0xFFFF
    shift = (instr >> 21) & 0x3
    # MOVZ x/w: 0xD2800000 (x) 0x52800000 (w) - sf=1, opc=10
    if (instr & 0xFF800000) == 0xD2800000:
        return f"MOVZ X{rd}, #{imm16:#06x}, LSL#{shift*16}"
    if (instr & 0xFF800000) == 0x52800000:
        return f"MOVZ W{rd}, #{imm16:#06x}, LSL#{shift*16}"
    # MOVK x/w: 0xF2800000 (x) 0x72800000 (w)
    if (instr & 0xFF800000) == 0xF2800000:
        return f"MOVK X{rd}, #{imm16:#06x}, LSL#{shift*16}"
    if (instr & 0xFF800000) == 0x72800000:
        return f"MOVK W{rd}, #{imm16:#06x}, LSL#{shift*16}"
    # LDR: 0xF9400000 (64bit) 0xB9400000 (32bit)
    if (instr & 0xFFC00000) == 0xF9400000:
        off2=((instr>>10)&0xFFF)*8; rn=(instr>>5)&0x1F
        return f"LDR X{rd}, [X{rn}, #{off2}]"
    if (instr & 0xFFC00000) == 0xB9400000:
        off2=((instr>>10)&0xFFF)*4; rn=(instr>>5)&0x1F
        return f"LDR W{rd}, [X{rn}, #{off2}]"
    # ADRP
    if (instr & 0x9F000000) == 0x90000000:
        rd2=instr&0x1F; imm=((instr>>5)&0x7FFFF)|((instr>>29)&0x3)<<19
        return f"ADRP X{rd2}, #{imm:#06x}"
    # RET / BR / BLR
    if instr == 0xD65F03C0: return "RET"
    if (instr & 0xFFFFFC1F) == 0xD61F0000: return f"BR X{(instr>>5)&0x1F}"
    if (instr & 0xFFFFFC1F) == 0xD63F0000: return f"BLR X{(instr>>5)&0x1F}"
    return f".word {instr:#010x}"

print("=== ARM64 disasm ===")
regs = {}
movk_groups = {}  # reg -> {shift: imm16}
for i in range(0, len(code), 4):
    instr = struct.unpack("<I", code[i:i+4])[0]
    dis = decode_arm64(instr)
    print(f"  {off+i:#06x}: {code[i:i+4].hex()} | {dis}")
    # 追踪 MOVZ/MOVK 给寄存器赋值
    if "MOVZ" in dis or "MOVK" in dis:
        parts = dis.split()
        reg = parts[1].rstrip(",")
        imm = int(parts[2].split(",")[0].rstrip(","), 16)
        shift = int(parts[-1].replace("LSL#","")) if "LSL#" in dis else 0
        if "MOVZ" in dis:
            movk_groups[reg] = {shift: imm}
        elif reg in movk_groups:
            movk_groups[reg][shift] = imm

print("\n=== 寄存器构造值(MOVZ/MOVK 序列) ===")
for reg, parts in movk_groups.items():
    val = 0
    for sh, imm in sorted(parts.items()):
        val |= imm << sh
    print(f"  {reg} = {val:#034x}  ({val.to_bytes(16,'big').hex() if val < 2**128 else 'too large'})")
