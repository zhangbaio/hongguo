package com.dragon.read.leftslidepage;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static Function2<Composer, Integer, Unit> b;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    static {
        Covode.recordClassIndex(611239);
        a = new a();
        b = androidx.compose.runtime.internal.t.c(-1867746975, false, C0086a.a);
    }

    /* renamed from: com.dragon.read.leftslidepage.a$a, reason: collision with other inner class name */
    static final class C0086a implements Function2<Composer, Integer, Unit> {
        public static final C0086a a = new C0086a();

        C0086a() {
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            long l;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1867746975, i, -1, "com.dragon.read.leftslidepage.ComposableSingletons$VideoFeedTabLeftSlidePageKt.lambda$-1867746975.<anonymous> (VideoFeedTabLeftSlidePage.kt:76)");
                }
                boolean d = com.dragon.read.kmp.service.d1.d((Theme) composer.consume(rg4.e.l()));
                float max = Math.max(0.0f, com.dragon.read.kmp.service.b1.a.s()) + 16;
                Modifier f = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                if (d) {
                    composer.startReplaceGroup(391496937);
                    l = og4.a.a.h(composer, og4.a.b).w();
                } else {
                    composer.startReplaceGroup(391498053);
                    l = og4.a.a.h(composer, og4.a.b).l();
                }
                composer.endReplaceGroup();
                Modifier v = androidx.compose.foundation.layout.f2.v(BackgroundKt.d(f, l, (androidx.compose.ui.graphics.f2) null, 2, (Object) null), 0.0f, x0.i.g(max), 0.0f, 0.0f, 13, (Object) null);
                androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), composer, 0);
                int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, v);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a4 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a4);
                } else {
                    composer.useNode();
                }
                Composer b = g5.b(composer);
                g5.e(b, a2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                    b.updateRememberedValue(Integer.valueOf(a3));
                    b.apply(Integer.valueOf(a3), b2);
                }
                g5.e(b, e, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                VideoFeedTabLeftSlidePageKt.R(composer, 0);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }
}
