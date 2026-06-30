import ghidra.app.script.GhidraScript;
import ghidra.program.model.address.Address;
import ghidra.program.model.symbol.*;
import ghidra.program.model.listing.*;

public class find_xref extends GhidraScript {
  public void run() throws Exception {
    String t = "ML_DoHttpReqSignIT";
    Address s = find(t);
    println("STR_ADDR=" + s);
    if (s == null) { println("string not found"); return; }
    long base = currentProgram.getImageBase().getOffset();
    println("IMAGE_BASE=0x" + Long.toHexString(base));
    ReferenceManager rm = currentProgram.getReferenceManager();
    ReferenceIterator it = rm.getReferencesTo(s);
    int n = 0;
    while (it.hasNext()) {
      Reference r = it.next();
      Address from = r.getFromAddress();
      Function f = getFunctionContaining(from);
      String fe = (f != null) ? ("0x" + Long.toHexString(f.getEntryPoint().getOffset() - base)) : "?";
      println("XREF from=" + from + " func_off=" + fe + " name=" + (f!=null?f.getName():"?"));
      n++;
    }
    println("TOTAL_XREFS=" + n);
  }
}
