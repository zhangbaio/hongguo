// 反编译 libsscronet 的签名编排函数 FUN_0050c07c, 找它对 metasec 的调用
import ghidra.app.script.GhidraScript;
import ghidra.app.decompiler.*;
import ghidra.program.model.address.Address;
import ghidra.program.model.listing.*;
import ghidra.program.model.symbol.*;
import ghidra.program.model.pcode.*;

public class GhidraDecompSign extends GhidraScript {
    public void run() throws Exception {
        long imageBase = currentProgram.getImageBase().getOffset();
        Address fa = currentProgram.getImageBase().getNewAddress(0x50c07cL);
        FunctionManager fm = currentProgram.getFunctionManager();
        Function f = fm.getFunctionContaining(fa);
        if (f == null) { println("函数未找到"); return; }
        println("=== 函数 " + f.getName() + " @ " + f.getEntryPoint() + " size=" + f.getBody().getNumAddresses() + " ===");

        // 1) 列出函数体内所有 call / blr(直接+间接)指令及目标
        println("\n=== 调用指令 (BL/BLR) ===");
        Listing lst = currentProgram.getListing();
        InstructionIterator ii = lst.getInstructions(f.getBody(), true);
        while (ii.hasNext()) {
            Instruction in = ii.next();
            String mn = in.getMnemonicString();
            if (mn.equals("bl") || mn.equals("blr") || mn.equals("br")) {
                long off = in.getAddress().getOffset() - imageBase;
                Reference[] refs = in.getReferencesFrom();
                StringBuilder sb = new StringBuilder();
                for (Reference r : refs) {
                    Address to = r.getToAddress();
                    Function tf = fm.getFunctionContaining(to);
                    sb.append(" -> ").append(to).append(tf != null ? "(" + tf.getName() + ")" : "");
                }
                println("  +0x" + Long.toHexString(off) + "  " + in.toString() + sb);
            }
        }

        // 2) 反编译为 C 伪代码
        println("\n=== 反编译 ===");
        DecompInterface di = new DecompInterface();
        di.openProgram(currentProgram);
        DecompileResults dr = di.decompileFunction(f, 120, monitor);
        if (dr.decompileCompleted()) {
            String c = dr.getDecompiledFunction().getC();
            // 太长则截断
            if (c.length() > 16000) c = c.substring(0, 16000) + "\n...(截断)";
            println(c);
        } else println("反编译失败: " + dr.getErrorMessage());
    }
}
