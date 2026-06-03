package yk4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.c7;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    static {
        Covode.recordClassIndex(608017);
    }

    public static final boolean a(c7 c7Var) {
        String str;
        Intrinsics.checkNotNullParameter(c7Var, "<this>");
        Map map = c7Var.h;
        if (map != null) {
            if (map != null) {
                str = (String) map.get("celebrity_works_tab_type");
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "double_col")) {
                return true;
            }
        }
        return false;
    }
}
