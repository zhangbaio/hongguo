package com.dragon.read.kmp.shortvideo.distribution.page.conent;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s {
    public static final s a;
    private static final Lazy b;
    private static final Lazy c;
    private static final Lazy d;
    public static final int e;

    private s() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x0.i e() {
        return x0.i.d(x0.i.g(9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x0.i f() {
        return x0.i.d(x0.i.g(14));
    }

    public final float g() {
        return ((x0.i) b.getValue()).m();
    }

    public final float h() {
        return ((x0.i) d.getValue()).m();
    }

    public final float i() {
        return ((x0.i) c.getValue()).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x0.i d() {
        return x0.i.d(x0.i.g(SeriesNormalRankPageKt.u0() + x0.i.g(48)));
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Covode.recordClassIndex(609056);
        a = new s();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                x0.i d2;
                d2 = s.d();
                return d2;
            }
        });
        b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                x0.i f;
                f = s.f();
                return f;
            }
        });
        c = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                x0.i e2;
                e2 = s.e();
                return e2;
            }
        });
        d = lazy3;
        e = 8;
    }

    public final float j(Composer composer, int i) {
        composer.startReplaceGroup(2021109977);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2021109977, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.NewHeaderCoverUiDimen.getTabTitleHeight (NewHeaderCoverUiDimne.kt:20)");
        }
        float c2 = pg4.j.c(22, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return c2;
    }
}
