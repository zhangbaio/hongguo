package kn4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e implements b {
    public static final e b;
    public static final int c;
    private final /* synthetic */ b a;

    static {
        Covode.recordClassIndex(608800);
        b = new e();
        c = 8;
    }

    @Override // kn4.b
    public float i9() {
        return this.a.i9();
    }

    private e() {
        eo0.a a = eo0.c.a.a(Reflection.getOrCreateKotlinClass(b.class));
        Intrinsics.checkNotNull(a);
        this.a = (b) a;
    }
}
