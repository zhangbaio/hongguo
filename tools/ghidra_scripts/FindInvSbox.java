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
import java.util.LinkedHashSet;
import java.util.Set;

// 找引用 AES 逆S-box(52 09 6a d5..) 的函数及其调用者并反编译 => AES-decrypt(疑spade解包核心)
public class FindInvSbox extends GhidraScript {
    public void run() throws Exception {
        String[] a = getScriptArgs();
        String out = (a.length > 0) ? a[0] : "invsbox.c";
        byte[] inv = new byte[]{0x52,0x09,0x6a,(byte)0xd5,0x30,0x36,(byte)0xa5,0x38,
                                (byte)0xbf,0x40,(byte)0xa3,(byte)0x9e,(byte)0x81,(byte)0xf3,(byte)0xd7,(byte)0xfb};
        Memory mem = currentProgram.getMemory();
        Address found = mem.findBytes(currentProgram.getMinAddress(), inv, null, true, monitor);
        PrintWriter w = new PrintWriter(new FileWriter(out));
        if (found == null) { w.println("// InvSbox NOT found"); w.close(); println("INVSBOX_NOT_FOUND"); return; }
        w.println("// InvSbox @ " + found);
        println("InvSbox @ " + found);
        ReferenceManager rm = currentProgram.getReferenceManager();
        Set<Function> funcs = new LinkedHashSet<>();
        for (Reference r : rm.getReferencesTo(found)) {
            Function f = getFunctionContaining(r.getFromAddress());
            if (f != null) funcs.add(f);
        }
        Address page = found.getNewAddress(found.getOffset() & ~0xFFFL);
        for (long off = 0; off < 0x1000; off += 4) {
            for (Reference r : rm.getReferencesTo(page.add(off))) {
                Function f = getFunctionContaining(r.getFromAddress());
                if (f != null) funcs.add(f);
            }
        }
        ConsoleTaskMonitor mon = new ConsoleTaskMonitor();
        Set<Function> all = new LinkedHashSet<>(funcs);
        for (Function f : funcs) for (Function c : f.getCallingFunctions(mon)) all.add(c);
        w.println("// xref funcs=" + funcs.size() + " +callers=" + all.size());
        println("xref=" + funcs.size() + " +callers=" + all.size());
        DecompInterface di = new DecompInterface(); di.openProgram(currentProgram);
        for (Function f : all) {
            try {
                DecompileResults res = di.decompileFunction(f, 90, mon);
                w.println("\n// ===== " + f.getName() + " @ " + f.getEntryPoint()
                          + " size=" + f.getBody().getNumAddresses() + " callers="
                          + f.getCallingFunctions(mon).size() + " =====");
                w.println(res != null && res.decompileCompleted() ? res.getDecompiledFunction().getC() : "// (decompile failed)");
            } catch (Exception e) {}
        }
        w.close();
        println("INVSBOX_DONE -> " + out);
    }
}
