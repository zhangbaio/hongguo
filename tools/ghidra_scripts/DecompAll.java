import ghidra.app.script.GhidraScript;
import ghidra.app.decompiler.DecompInterface;
import ghidra.app.decompiler.DecompileResults;
import ghidra.program.model.listing.Function;
import ghidra.program.model.listing.FunctionIterator;
import ghidra.util.task.ConsoleTaskMonitor;
import java.io.PrintWriter;
import java.io.FileWriter;

public class DecompAll extends GhidraScript {
    public void run() throws Exception {
        String[] args = getScriptArgs();
        String out = (args.length > 0) ? args[0] : "decomp.c";
        DecompInterface di = new DecompInterface();
        di.openProgram(currentProgram);
        PrintWriter w = new PrintWriter(new FileWriter(out));
        int n = 0;
        ConsoleTaskMonitor mon = new ConsoleTaskMonitor();
        FunctionIterator it = currentProgram.getFunctionManager().getFunctions(true);
        while (it.hasNext()) {
            Function fn = it.next();
            try {
                DecompileResults res = di.decompileFunction(fn, 60, mon);
                if (res != null && res.decompileCompleted()) {
                    w.println("// ===== " + fn.getName() + " @ " + fn.getEntryPoint()
                              + " size=" + fn.getBody().getNumAddresses() + " =====");
                    w.println(res.getDecompiledFunction().getC());
                    w.println();
                    n++;
                }
            } catch (Exception e) { /* skip */ }
        }
        w.close();
        println("DECOMP_DONE functions=" + n + " -> " + out);
    }
}
