// Ghidra headless: 找 libsscronet 里引用 x-argus/x-gorgon/x-ladon 头名字符串的函数
// = 构建签名头、调用 metasec sign 的编排函数
import ghidra.app.script.GhidraScript;
import ghidra.program.model.address.Address;
import ghidra.program.model.listing.*;
import ghidra.program.model.symbol.*;

public class GhidraFindXargus extends GhidraScript {
    long[] STR_VAS = { 0x7337cL, 0x7a210L, 0x7a219L, 0x74785L }; // x-argus,x-gorgon,x-ladon,x-khronos
    public void run() throws Exception {
        long imageBase = currentProgram.getImageBase().getOffset();
        println("imageBase=0x" + Long.toHexString(imageBase));
        ReferenceManager rm = currentProgram.getReferenceManager();
        FunctionManager fm = currentProgram.getFunctionManager();
        for (long sv : STR_VAS) {
            Address sa = currentProgram.getImageBase().getNewAddress(imageBase + sv);
            println("\n==== 字符串 VA(文件偏移近似)=0x" + Long.toHexString(sv) + " -> addr " + sa + " ====");
            ReferenceIterator it = rm.getReferencesTo(sa);
            int c = 0;
            while (it.hasNext()) {
                Reference r = it.next();
                Address from = r.getFromAddress();
                Function f = fm.getFunctionContaining(from);
                println("  xref from " + from + (f != null ? "  in FUNC " + f.getName() + " @ " + f.getEntryPoint() : "  (no func)"));
                c++;
            }
            if (c == 0) println("  (无直接xref, 试探周边)");
        }
        // 列出 0x7b000-0x83000 区的函数(签名编排候选, 类比抖音 0x7d3f0)
        println("\n==== 0x7b000-0x83000 区函数 ====");
        FunctionIterator fit = fm.getFunctions(true);
        while (fit.hasNext()) {
            Function f = fit.next();
            long off = f.getEntryPoint().getOffset() - imageBase;
            if (off >= 0x7b000 && off <= 0x83000)
                println("  FUNC " + f.getName() + " off=0x" + Long.toHexString(off) + " size=" + f.getBody().getNumAddresses());
        }
    }
}
