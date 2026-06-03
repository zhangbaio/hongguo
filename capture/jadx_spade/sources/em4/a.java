package em4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    static {
        Covode.recordClassIndex(608423);
    }

    public static final String a(String prefixFamous, String suffixFamous) {
        Intrinsics.checkNotNullParameter(prefixFamous, "prefixFamous");
        Intrinsics.checkNotNullParameter(suffixFamous, "suffixFamous");
        return prefixFamous + "名场面" + suffixFamous;
    }

    public static /* synthetic */ String b(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        return a(str, str2);
    }
}
