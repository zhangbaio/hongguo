package xr3;

import android.view.ViewGroup;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(598837);
    }

    public static final boolean a(ViewGroup.LayoutParams params) {
        int i;
        Intrinsics.checkNotNullParameter(params, "params");
        int i2 = params.width;
        if (i2 != -1 && (i = params.height) != -1 && i2 != -2 && i != -2) {
            return true;
        }
        return false;
    }
}
