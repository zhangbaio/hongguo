import capstone
FQ="/tmp/fqu/src/main/resources/com/dragon/read/oversea/gp/lib/libmetasec_ml.so"
HG="/Users/zhangbiao/Documents/编程/ai/claude/hongguo/capture/so/libmetasec_ml.so"
fq=open(FQ,'rb').read(); hg=open(HG,'rb').read()
md=capstone.Cs(capstone.CS_ARCH_ARM64,capstone.CS_MODE_ARM); md.detail=False

def consts_at(buf, start, n=400):
    """收集函数内 movz/movk 组成的64位常量(按寄存器累积)"""
    regacc={}; out=set()
    for ins in md.disasm(buf[start:start+n*4], start):
        m=ins.mnemonic; op=ins.op_str
        if m in("movz","mov") and "#" in op:
            try:
                parts=op.split(", #"); reg=parts[0]; val=int(parts[1].split(",")[0],0)
                sh=0
                if "lsl" in op: sh=int(op.split("lsl #")[1])
                regacc[reg]=val<<sh; 
                if regacc[reg]>0xffff: out.add(regacc[reg])
            except: pass
        elif m=="movk":
            try:
                parts=op.split(", #"); reg=parts[0]; val=int(parts[1].split(",")[0],0)
                sh=int(op.split("lsl #")[1]) if "lsl" in op else 0
                regacc[reg]=regacc.get(reg,0)|(val<<sh); out.add(regacc[reg])
            except: pass
        if m in("ret",): break
    return out

fqc=consts_at(fq,0x168c80)
# 取"稀有"常量(大、非对齐、非小整数)
rare=sorted(c for c in fqc if c>0x100000 and c!=0xffffffff)
print("番茄海外 sign 函数大常量(%d个):"%len(rare), [hex(c) for c in rare[:15]])

# 在红果全 .text 反汇编,记录每个常量出现的地址簇
# 简化:对每个 rare 常量,搜其 movk 低16位字节出现处太泛;改为反汇编红果找加载这些常量的指令地址
hgconst={}  # const -> [addr...]
regacc={}
for ins in md.disasm(hg, 0):
    m=ins.mnemonic; op=ins.op_str
    if m in("movz","mov","movk") and "#" in op:
        try:
            reg=op.split(", #")[0]; val=int(op.split(", #")[1].split(",")[0],0)
            sh=int(op.split("lsl #")[1]) if "lsl" in op else 0
            if m=="movk": regacc[reg]=regacc.get(reg,0)|(val<<sh)
            else: regacc[reg]=val<<sh
            v=regacc[reg]
            if v in fqc and v>0x100000:
                hgconst.setdefault(v,[]).append(ins.address)
        except: pass
# 找红果里这些常量聚集的区域(滑窗)
allhits=sorted((a,c) for c,addrs in hgconst.items() for a in addrs)
print("红果中命中这些常量的点数:", len(allhits))
# 聚类:窗口 0x800 内不同常量数最多的中心
best=None
for i,(a,c) in enumerate(allhits):
    win=[x for x in allhits if a<=x[0]<a+0x1000]
    distinct=len(set(x[1] for x in win))
    if best is None or distinct>best[0]: best=(distinct,a,win)
print("最佳簇: 不同常量数=%d 起点=0x%x"%(best[0],best[1]))
print("  簇内常量:", [hex(c) for _,c in best[2]][:12])
