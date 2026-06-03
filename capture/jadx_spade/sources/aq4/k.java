package aq4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k implements j {
    public static final k b;
    public static final int c;
    private final /* synthetic */ j a;

    static {
        Covode.recordClassIndex(609422);
        b = new k();
        c = 8;
    }

    @Override // aq4.j
    public g W0(e params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return this.a.W0(params);
    }

    private k() {
        j jVar = (j) eo0.c.a.a(Reflection.getOrCreateKotlinClass(j.class));
        jVar = jVar == null ? a.a : jVar;
        Intrinsics.checkNotNull(jVar, "null cannot be cast to non-null type com.dragon.read.kmp.story.impl.ui.IKmpGradientMaskService");
        this.a = jVar;
    }
}
