import ghidra.app.script.GhidraScript;
import ghidra.app.decompiler.DecompInterface;
import ghidra.app.decompiler.DecompileResults;
import ghidra.program.model.address.Address;
import ghidra.program.model.listing.Function;
import ghidra.program.model.mem.Memory;
import ghidra.program.model.symbol.Reference;
import ghidra.program.model.symbol.ReferenceManager;
import ghidra.util.task.ConsoleTaskMonitor;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

// 找引用指定ASCII字符串的函数及其调用者并反编译。
// args: <out.c> <str1> [str2] [str3] ...
public class FindStrXref extends GhidraScript {
    public void run() throws Exception {
        String[] a = getScriptArgs();
        String out = (a.length > 0) ? a[0] : "strxref.c";
        Memory mem = currentProgram.getMemory();
        ReferenceManager rm = currentProgram.getReferenceManager();
        PrintWriter w = new PrintWriter(new FileWriter(out));
        Set<Function> funcs = new LinkedHashSet<>();
        ConsoleTaskMonitor mon = new ConsoleTaskMonitor();

        for (int si = 1; si < a.length; si++) {
            String s = a[si];
            byte[] pat = s.getBytes("US-ASCII");
            Address at = currentProgram.getMinAddress();
            int found = 0;
            while (at != null) {
                Address hit = mem.findBytes(at, pat, null, true, mon);
                if (hit == null) break;
                found++;
                w.println("// STR \"" + s + "\" @ " + hit);
                println("STR \"" + s + "\" @ " + hit);
                // 直接引用 + 页基址引用(ADRP)
                addRefs(rm, hit, funcs);
                Address page = hit.getNewAddress(hit.getOffset() & ~0xFFFL);
                for (long off = 0; off < 0x1000; off += 4)
                    addRefs(rm, page.add(off), funcs);
                at = hit.add(1);
                if (found > 8) break;
            }
            if (found == 0) { w.println("// STR \"" + s + "\" NOT FOUND"); println("NOTFOUND: " + s); }
        }

        // 加入直接调用者(一层)
        Set<Function> withCallers = new LinkedHashSet<>(funcs);
        for (Function f : funcs) {
            for (Function c : f.getCallingFunctions(mon)) withCallers.add(c);
        }
        w.println("// xref funcs=" + funcs.size() + " +callers total=" + withCallers.size());
        println("xref=" + funcs.size() + " total=" + withCallers.size());

        DecompInterface di = new DecompInterface(); di.openProgram(currentProgram);
        for (Function f : withCallers) {
            try {
                DecompileResults res = di.decompileFunction(f, 90, mon);
                w.println("\n// ===== " + f.getName() + " @ " + f.getEntryPoint()
                          + " size=" + f.getBody().getNumAddresses() + " =====");
                if (res != null && res.decompileCompleted())
                    w.println(res.getDecompiledFunction().getC());
                else w.println("// (decompile failed)");
            } catch (Exception e) {}
        }
        w.close();
        println("STRXREF_DONE -> " + out);
    }

    void addRefs(ReferenceManager rm, Address tgt, Set<Function> funcs) {
        for (Reference r : rm.getReferencesTo(tgt)) {
            Function f = getFunctionContaining(r.getFromAddress());
            if (f != null) funcs.add(f);
        }
    }
}
