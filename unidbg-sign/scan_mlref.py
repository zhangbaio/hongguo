#!/usr/bin/env python3
# 找红果 libmetasec 里对 ML_DoHttpReqSignIT 字符串的引用(破静态xref死局)
import sys, struct, zlib, binascii
from elftools.elf.elffile import ELFFile
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM, CS_OPT_DETAIL
from capstone.arm64 import ARM64_OP_REG, ARM64_OP_IMM, ARM64_INS_ADRP, ARM64_INS_ADD, ARM64_INS_LDR

PATH = sys.argv[1] if len(sys.argv) > 1 else "../capture/so/libmetasec_ml.so"
NEEDLE = b"ML_DoHttpReqSignIT"
data = open(PATH, "rb").read()
elf = ELFFile(open(PATH, "rb"))

# 段映射: file off <-> vaddr
segs = []
for s in elf.iter_segments():
    if s["p_type"] == "PT_LOAD":
        segs.append((s["p_offset"], s["p_vaddr"], s["p_filesz"]))
def foff_to_va(fo):
    for off, va, sz in segs:
        if off <= fo < off + sz: return va + (fo - off)
    return None

# 定位字符串
str_fo = data.find(NEEDLE)
str_va = foff_to_va(str_fo)
print(f"[*] 字符串 file=0x{str_fo:x} VA=0x{str_va:x}")
# 列出该串前后的命令名簇(rodata里相邻命令)
ctx = data[str_fo-200:str_fo+400]
names = [t.decode('latin1') for t in __import__('re').findall(rb'[ -~]{6,}', ctx)]
print("[*] 邻近字符串:", names[:25])

# .text 范围
text = next(s for s in elf.iter_sections() if s.name == ".text")
tva, tsz, tfo = text["sh_addr"], text["sh_size"], text["sh_offset"]
print(f"[*] .text VA=0x{tva:x}..0x{tva+tsz:x} size=0x{tsz:x}")
code = data[tfo:tfo+tsz]

md = Cs(CS_ARCH_ARM64, CS_MODE_ARM); md.detail = True

# ---- 1) ADRP(+ADD/LDR) 配对解析到 str_va ----
print("\n==== [1] ADRP+ADD/LDR 解析 ====")
adrp_val = {}   # reg -> (page_base, pc)
hits = 0
for insn in md.disasm(code, tva):
    m = insn.mnemonic
    if m == "adrp":
        ops = insn.operands
        rd = ops[0].reg; page = ops[1].imm
        adrp_val[rd] = (page, insn.address)
    elif m == "add" and len(insn.operands) == 3:
        ops = insn.operands
        if ops[1].type == ARM64_OP_REG and ops[2].type == ARM64_OP_IMM:
            base_reg = ops[1].reg
            if base_reg in adrp_val:
                page, _ = adrp_val[base_reg]
                target = page + ops[2].imm
                if str_va - 4 <= target <= str_va + 4:
                    print(f"  ADRP+ADD -> 0x{target:x}  @ 0x{insn.address:x}  {insn.mnemonic} {insn.op_str}")
                    hits += 1
    elif m in ("ldr","ldrb","ldrsw") and len(insn.operands) == 2:
        ops = insn.operands
        if ops[1].type == 3:  # mem
            base_reg = ops[1].mem.base; disp = ops[1].mem.disp
            if base_reg in adrp_val:
                page, _ = adrp_val[base_reg]
                target = page + disp
                if str_va - 8 <= target <= str_va + 8:
                    print(f"  ADRP+LDR -> 0x{target:x}  @ 0x{insn.address:x}  {insn.mnemonic} {insn.op_str}")
                    hits += 1
    # 任何寄存器被非ADRP写就失效(粗略: add/ldr到该寄存器已处理; 简化不清栈)
print(f"  命中 {hits}")

# ---- 2) 全文件搜 8字节/4字节字面指针 + 32位相对偏移表 ----
print("\n==== [2] 指针/偏移表 ====")
le64 = struct.pack("<Q", str_va)
print("  8字节字面指针 str_va:", [hex(i) for i in find_all(data, le64)] if (find_all:=lambda d,n:[i for i in range(0,len(d)-len(n)) if d[i:i+len(n)]==n]) else [])
for delta_name, base in [("str_va", str_va), ("str_start_aligned", str_va & ~3)]:
    le32 = struct.pack("<I", base & 0xffffffff)
    locs = [i for i in range(0, len(data)-4) if data[i:i+4] == le32]
    if locs: print(f"  4字节 {delta_name}=0x{base:x}: {[hex(x) for x in locs[:10]]}")
# 32位"相对自身位置"偏移表: data[i:i+4] (signed) + va(i) == str_va
print("  扫 int32 相对偏移表(off+self_va==str_va)...")
rel_hits = []
for off, va, sz in segs:
    seg = data[off:off+sz]
    for i in range(0, len(seg)-4, 4):
        v = struct.unpack_from("<i", seg, i)[0]
        self_va = va + i
        if self_va + v == str_va:
            rel_hits.append(self_va)
print("   命中:", [hex(x) for x in rel_hits[:20]], "..." if len(rel_hits)>20 else "", f"(共{len(rel_hits)})")

# ---- 3) 命令名 hash 常量 ----
print("\n==== [3] hash 常量搜索 ====")
def djb2(s):
    h=5381
    for c in s: h=((h*33)+c)&0xffffffff
    return h
def sdbm(s):
    h=0
    for c in s: h=(c+(h<<6)+(h<<16)-h)&0xffffffff
    return h
def fnv1a32(s):
    h=0x811c9dc5
    for c in s: h=((h^c)*0x01000193)&0xffffffff
    return h
def fnv1a64(s):
    h=0xcbf29ce484222325
    for c in s: h=((h^c)*0x100000001b3)&0xffffffffffffffff
    return h
S = NEEDLE
cands = {
  "crc32": zlib.crc32(S)&0xffffffff,
  "djb2": djb2(S), "sdbm": sdbm(S),
  "fnv1a32": fnv1a32(S), "fnv1a64": fnv1a64(S),
}
for name,h in cands.items():
    for width in (4,8):
        if width==8 and h<=0xffffffff and name!="fnv1a64": continue
        pk = struct.pack("<I",h) if width==4 else struct.pack("<Q",h)
        locs=[i for i in range(0,len(data)-width) if data[i:i+width]==pk]
        tag = f"0x{h:x}"
        if locs: print(f"  {name}({width}B)={tag} 命中 @ {[hex(x) for x in locs[:8]]}")
        else: print(f"  {name}({width}B)={tag} 无")
