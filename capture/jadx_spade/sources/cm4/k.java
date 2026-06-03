package cm4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k implements a {
    public static final int b;
    private final a a;

    static {
        Covode.recordClassIndex(608295);
        b = 8;
    }

    @Override // cm4.a
    public boolean a() {
        return this.a.a();
    }

    @Override // cm4.a
    public String b() {
        return this.a.b();
    }

    @Override // cm4.a
    public im4.d c() {
        return this.a.c();
    }

    public k(a impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.a = impl;
    }
}
