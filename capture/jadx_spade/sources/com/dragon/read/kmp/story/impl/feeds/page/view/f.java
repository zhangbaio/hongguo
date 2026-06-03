package com.dragon.read.kmp.story.impl.feeds.page.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.us;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final f a;
    private static Function3<us, Composer, Integer, Unit> b;
    private static Function2<Composer, Integer, Unit> c;

    public final Function2<Composer, Integer, Unit> a() {
        return c;
    }

    public final Function3<us, Composer, Integer, Unit> b() {
        return b;
    }

    static {
        Covode.recordClassIndex(609323);
        a = new f();
        b = androidx.compose.runtime.internal.t.c(455422973, false, b.a);
        c = androidx.compose.runtime.internal.t.c(-1807085488, false, a.a);
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1807085488, i, -1, "com.dragon.read.kmp.story.impl.feeds.page.view.ComposableSingletons$ContentTitlePageViewKt.lambda$-1807085488.<anonymous> (ContentTitlePageView.kt:106)");
                }
                a3.a(SizeKt.x(Modifier.Companion, x0.i.g(6)), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function3<us, Composer, Integer, Unit> {
        public static final b a = new b();

        b() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(us usVar, Composer composer, Integer num) {
            a(usVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(us tagInfo, Composer composer, int i) {
            long o;
            g3 e;
            Intrinsics.checkNotNullParameter(tagInfo, "tagInfo");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(455422973, i, -1, "com.dragon.read.kmp.story.impl.feeds.page.view.ComposableSingletons$ContentTitlePageViewKt.lambda$455422973.<anonymous> (ContentTitlePageView.kt:86)");
            }
            boolean areEqual = Intrinsics.areEqual(tagInfo.c, Boolean.TRUE);
            Modifier i2 = SizeKt.i(Modifier.Companion, x0.i.g(18));
            if (areEqual) {
                composer.startReplaceGroup(-425176344);
                o = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a.b(composer, 6).n();
            } else {
                composer.startReplaceGroup(-425174973);
                o = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a.b(composer, 6).o();
            }
            composer.endReplaceGroup();
            float f = 4;
            Modifier t = f2.t(BackgroundKt.c(i2, o, k.g.c(x0.i.g(f))), x0.i.g(f), 0.0f, 2, (Object) null);
            p0 i3 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
            e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(composer, t);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a3 = companion.a();
            if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(a3);
            } else {
                composer.useNode();
            }
            Composer b = g5.b(composer);
            g5.e(b, i3, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            String str = tagInfo.a;
            if (str == null) {
                str = "";
            }
            int b3 = w0.s.b.b();
            e = r.e(areEqual, composer, 0, 0);
            a6.j(str, (Modifier) null, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b3, false, 1, 0, (Function1) null, e, composer, 0, 3120, 55294);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
