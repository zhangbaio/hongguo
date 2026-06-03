package cl4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class u {
    public static final u a;
    private static p b;
    public static final int c;

    static {
        Covode.recordClassIndex(608058);
        a = new u();
        c = 8;
    }

    private u() {
    }

    public final p a() {
        p pVar = b;
        b = null;
        return pVar;
    }

    public final void b(p info) {
        Intrinsics.checkNotNullParameter(info, "info");
        b = info;
    }
}
