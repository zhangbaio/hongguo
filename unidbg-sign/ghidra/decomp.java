import ghidra.app.script.GhidraScript;
import ghidra.app.decompiler.*;
import ghidra.program.model.address.Address;
import ghidra.program.model.listing.Function;
import ghidra.program.model.symbol.Reference;
import ghidra.util.task.ConsoleTaskMonitor;

public class decomp extends GhidraScript {
    public void run() throws Exception {
        String[] args = getScriptArgs();
        Address base = currentProgram.getImageBase();
        DecompInterface ifc = new DecompInterface();
        ifc.openProgram(currentProgram);
        ConsoleTaskMonitor mon = new ConsoleTaskMonitor();
        for (String off : args) {
            long o = Long.parseLong(off.replace("0x",""),16);
            Address a = base.add(o);
            Function f = getFunctionContaining(a);
            println("==== off="+off+" func="+f+" entry=+0x"+(f!=null?Long.toHexString(f.getEntryPoint().subtract(base)):"?"));
            if (f==null) continue;
            DecompileResults r = ifc.decompileFunction(f, 120, mon);
            if (r!=null && r.getDecompiledFunction()!=null) println(r.getDecompiledFunction().getC());
            for (Function cf : f.getCalledFunctions(mon))
                println("CALL "+cf.getName()+" +0x"+Long.toHexString(cf.getEntryPoint().subtract(base)));
            println("---- XREFS (谁调用本函数) ----");
            for (Reference ref : getReferencesTo(f.getEntryPoint())) {
                Function cf = getFunctionContaining(ref.getFromAddress());
                println("  FROM "+(cf!=null?cf.getName()+" +0x"+Long.toHexString(cf.getEntryPoint().subtract(base)):ref.getFromAddress()));
            }
        }
    }
}
