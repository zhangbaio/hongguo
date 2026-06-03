# Ghidra Jython postScript: 反编译所有函数到文件。用法 -postScript DecompAll.py <out.c>
from ghidra.app.decompiler import DecompInterface
from ghidra.util.task import ConsoleTaskMonitor

args = getScriptArgs()
out = args[0] if args else "decomp.c"
fm = currentProgram.getFunctionManager()
di = DecompInterface()
di.openProgram(currentProgram)
mon = ConsoleTaskMonitor()
f = open(out, "w")
n = 0
for fn in fm.getFunctions(True):
    try:
        res = di.decompileFunction(fn, 60, mon)
        if res and res.decompileCompleted():
            f.write("// ===== %s @ %s  size=%d =====\n" % (fn.getName(), fn.getEntryPoint(), fn.getBody().getNumAddresses()))
            f.write(res.getDecompiledFunction().getC())
            f.write("\n\n")
            n += 1
    except Exception as e:
        pass
f.close()
print("DECOMP_DONE functions=%d -> %s" % (n, out))
