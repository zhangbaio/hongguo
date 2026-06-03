package nr4;

import com.bytedance.covode.number.Covode;
import java.util.LinkedHashMap;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t3 {
    static {
        Covode.recordClassIndex(611767);
    }

    private static final String c(lr4.e1 e1Var) {
        return e1Var.a + '|' + e1Var.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LinkedHashMap<String, lr4.e1> linkedHashMap, lr4.e1 e1Var) {
        String c = c(e1Var);
        if (!linkedHashMap.containsKey(c)) {
            linkedHashMap.put(c, e1Var);
        }
    }
}
