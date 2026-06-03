package fm4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e implements i35.d {
    public static final int b;
    private final b a;

    static {
        Covode.recordClassIndex(608457);
        b = 8;
    }

    public i35.b create() {
        return new f(this.a.create());
    }

    public e(b impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.a = impl;
    }
}
