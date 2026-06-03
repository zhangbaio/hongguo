package hp4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.material.w;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.i;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import k.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import pm4.q;
import w0.h;
import x0.x;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    static {
        Covode.recordClassIndex(609250);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(boolean z, Function0 function0, int i, Composer composer, int i2) {
        b(z, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            long g;
            float f;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1852437111, i, -1, "com.dragon.read.kmp.story.impl.feeds.boxview.ListenBoxView.<anonymous> (ListenBoxView.kt:45)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier f2 = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                q qVar = q.a;
                com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a;
                if (qVar.a(cVar.a(composer, 6))) {
                    g = n0.b(268435455);
                } else {
                    g = l0.b.g();
                }
                Modifier d = BackgroundKt.d(f2, g, (f2) null, 2, (Object) null);
                e.a aVar2 = e.a;
                e e = aVar2.e();
                boolean z2 = this.a;
                p0 i2 = m.i(e, false);
                int a = j.a(i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, d);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a2 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a2);
                } else {
                    composer.useNode();
                }
                Composer b = g5.b(composer);
                g5.e(b, i2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                if (z2) {
                    f = 1.0f;
                } else {
                    f = 0.3f;
                }
                Modifier a3 = androidx.compose.ui.draw.a.a(aVar, f);
                p0 b3 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.i(), composer, 48);
                int a4 = j.a(i.b(composer, 0));
                e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, a3);
                Function0 a5 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a5);
                } else {
                    composer.useNode();
                }
                Composer b4 = g5.b(composer);
                g5.e(b4, b3, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                    b4.updateRememberedValue(Integer.valueOf(a4));
                    b4.apply(Integer.valueOf(a4), b5);
                }
                g5.e(b4, e3, companion.d());
                w2 w2Var = w2.b;
                float f3 = 16;
                a3.a(SizeKt.x(aVar, x0.i.g(f3)), composer, 6);
                a6.j("听书", (Modifier) null, cVar.b(composer, 6).g(), x.h(14), (y) null, c0.b.f(), (j) null, 0L, (w0.i) null, (h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199686, 0, 131026);
                a3.a(SizeKt.x(aVar, x0.i.g(4)), composer, 6);
                z0.c(org.jetbrains.compose.resources.c.b(d2.x(f2.a.a), composer, 0), "听书图标", SizeKt.s(aVar, x0.i.g(f3)), (e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(m0.b, cVar.b(composer, 6).g(), 0, 2, (Object) null), composer, 432, 56);
                a3.a(SizeKt.x(aVar, x0.i.g(12)), composer, 6);
                composer.endNode();
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

    public static final void b(final boolean z, final Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1311425126);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(z)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(onClick)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1311425126, i2, -1, "com.dragon.read.kmp.story.impl.feeds.boxview.ListenBoxView (ListenBoxView.kt:36)");
            }
            composer2 = startRestartGroup;
            w.a(ClickableKt.clickable-oSLSa3U$default(SizeKt.u(Modifier.Companion, x0.i.g(76), x0.i.g(40)), false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, onClick, 15, (Object) null), g.c(x0.i.g(20)), com.dragon.read.kmp.story.impl.feeds.uicontext.c.a.b(startRestartGroup, 6).m(), 0L, (androidx.compose.foundation.w) null, x0.i.g(12), t.e(-1852437111, true, new a(z), startRestartGroup, 54), composer2, 1769472, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: hp4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = d.c(z, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}
