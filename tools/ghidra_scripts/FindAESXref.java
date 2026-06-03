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
import java.util.Set;

// 找引用 AES S-box 的函数并反编译。args: <out.c>
public class FindAESXref extends GhidraScript {
    public void run() throws Exception {
        String[] a = getScriptArgs();
        String out = (a.length > 0) ? a[0] : "aes_xref.c";
        // AES forward S-box 前16字节
        byte[] sbox = new byte[]{0x63,0x7c,0x77,0x7b,(byte)0xf2,0x6b,0x6f,(byte)0xc5,0x30,0x01,0x67,0x2b,(byte)0xfe,(byte)0xd7,(byte)0xab,0x76};
        Memory mem = currentProgram.getMemory();
        Address found = mem.findBytes(currentProgram.getMinAddress(), sbox, null, true, monitor);
        PrintWriter w = new PrintWriter(new FileWriter(out));
        if (found == null) { w.println("// S-box NOT found"); w.close(); println("SBOX_NOT_FOUND"); return; }
        w.println("// S-box @ " + found);
        println("SBOX @ " + found);
        // 找引用该地址的函数(扫描周围±0x400也算, 因为可能ADRP到页基址)
        ReferenceManager rm = currentProgram.getReferenceManager();
        Set<Function> funcs = new HashSet<>();
        // 直接引用
        for (Reference r : rm.getReferencesTo(found)) {
            Function f = getFunctionContaining(r.getFromAddress());
            if (f != null) funcs.add(f);
        }
        // 页对齐基址的引用(ADRP常指向页基址)
        Address page = found.getNewAddress(found.getOffset() & ~0xFFFL);
        for (long off=0; off<0x1000; off+=4) {
            Address pa = page.add(off);
            for (Reference r : rm.getReferencesTo(pa)) {
                Function f = getFunctionContaining(r.getFromAddress());
                if (f != null) funcs.add(f);
            }
        }
        w.println("// referencing functions: " + funcs.size());
        println("ref funcs: " + funcs.size());
        DecompInterface di = new DecompInterface(); di.openProgram(currentProgram);
        ConsoleTaskMonitor mon = new ConsoleTaskMonitor();
        for (Function f : funcs) {
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
        println("AESXREF_DONE funcs=" + funcs.size() + " -> " + out);
    }
}
