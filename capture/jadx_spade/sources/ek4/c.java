package ek4;

import androidx.compose.ui.graphics.l0;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements a {
    public static final c b;
    public static final int c;
    private final /* synthetic */ a a;

    static {
        Covode.recordClassIndex(607784);
        b = new c();
        c = 8;
    }

    @Override // ek4.a
    public List<l0> Q1() {
        return this.a.Q1();
    }

    @Override // ek4.a
    public List<l0> d2() {
        return this.a.d2();
    }

    @Override // ek4.a
    public String o5() {
        return this.a.o5();
    }

    @Override // ek4.a
    public String u5(boolean z) {
        return this.a.u5(z);
    }

    private c() {
        eo0.a a = eo0.c.a.a(Reflection.getOrCreateKotlinClass(a.class));
        Intrinsics.checkNotNull(a);
        this.a = (a) a;
    }
}
