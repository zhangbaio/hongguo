import ghidra.app.script.GhidraScript;
import ghidra.app.decompiler.DecompInterface;
import ghidra.app.decompiler.DecompileResults;
import ghidra.program.model.address.Address;
import ghidra.program.model.listing.Function;
import ghidra.program.model.symbol.Reference;
import ghidra.program.model.symbol.ReferenceManager;
import ghidra.util.task.ConsoleTaskMonitor;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

// args: <out.c> <hexaddr1> [hexaddr2 ...]  找这些地址(函数)的调用者并反编译(含目标自身)
public class FindCallers extends GhidraScript {
    public void run() throws Exception {
        String[] a = getScriptArgs();
        String out = a[0];
        PrintWriter w = new PrintWriter(new FileWriter(out));
        DecompInterface di = new DecompInterface(); di.openProgram(currentProgram);
        ConsoleTaskMonitor mon = new ConsoleTaskMonitor();
        ReferenceManager rm = currentProgram.getReferenceManager();
        Set<Function> toDump = new HashSet<>();
        for (int i = 1; i < a.length; i++) {
            Address ta = currentProgram.getAddressFactory().getAddress(a[i]);
            Function target = getFunctionAt(ta);
            if (target != null) toDump.add(target);
            for (Reference r : rm.getReferencesTo(ta)) {
                Function c = getFunctionContaining(r.getFromAddress());
                if (c != null) toDump.add(c);
            }
            w.println("// target " + a[i] + " callers found");
        }
        println("callers+targets: " + toDump.size());
        for (Function f : toDump) {
            try {
                DecompileResults res = di.decompileFunction(f, 120, mon);
                w.println("\n// ===== " + f.getName() + " @ " + f.getEntryPoint()
                          + " size=" + f.getBody().getNumAddresses() + " =====");
                w.println(res != null && res.decompileCompleted() ? res.getDecompiledFunction().getC() : "// decompile failed");
            } catch (Exception e) {}
        }
        w.close();
        println("CALLERS_DONE n=" + toDump.size() + " -> " + out);
    }
}
