# Ghidra postScript:反编译指定模块偏移的函数 + 列其调用,定位红果签名函数
# args: 偏移列表(hex),如 0x26e684
from ghidra.app.decompiler import DecompInterface
from ghidra.util.task import ConsoleTaskMonitor

base = currentProgram.getImageBase()
fm = currentProgram.getFunctionManager()
ifc = DecompInterface(); ifc.openProgram(currentProgram)
mon = ConsoleTaskMonitor()

args = getScriptArgs()
offs = args if args else ["0x26e684"]
for off in offs:
    a = base.add(int(off, 16))
    f = fm.getFunctionContaining(a)
    print("==================== off=%s addr=%s func=%s ====================" % (off, a, f))
    if f is None:
        # 强制反汇编+建函数
        print("  (无函数,尝试反汇编)")
        continue
    res = ifc.decompileFunction(f, 90, mon)
    if res and res.getDecompiledFunction():
        c = res.getDecompiledFunction().getC()
        print(c[:6000])
    print("---- callees ----")
    for cf in f.getCalledFunctions(mon):
        print("  CALL %s @ +0x%x" % (cf.getName(), cf.getEntryPoint().subtract(base)))
