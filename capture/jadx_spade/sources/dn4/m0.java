package dn4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sh3.l1;
import sh3.m1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m0 {
    static {
        Covode.recordClassIndex(608755);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(n0 n0Var, int i, Composer composer, int i2) {
        b(n0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ n0 a;

        a(n0 n0Var) {
            this.a = n0Var;
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
                    ComposerKt.traceEventStart(664685281, i, -1, "com.dragon.read.kmp.search.card.ResultTestKmpCard.<anonymous> (ResultTestKmpCard.kt:32)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier i2 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(100));
                og4.a aVar2 = og4.a.a;
                int i3 = og4.a.b;
                Modifier d = BackgroundKt.d(i2, aVar2.h(composer, i3).w(), (f2) null, 2, (Object) null);
                n0 n0Var = this.a;
                e.a aVar3 = androidx.compose.ui.e.a;
                p0 i4 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, d);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a2 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a2);
                } else {
                    composer.useNode();
                }
                Composer b = g5.b(composer);
                g5.e(b, i4, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                a6.j(org.jetbrains.compose.resources.j.c(m1.h(l1.a), composer, 0) + '_' + n0Var.a + '_' + kn4.d.b.getDesc(), BoxScopeInstance.a.b(SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar3.e()), aVar2.h(composer, i3).k(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 131024);
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

    public static final void b(final n0 model, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(model, "model");
        Composer startRestartGroup = composer.startRestartGroup(52177906);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(model)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(52177906, i2, -1, "com.dragon.read.kmp.search.card.ResultTestKmpCard (ResultTestKmpCard.kt:30)");
            }
            pg4.p.f((pg4.i) null, androidx.compose.runtime.internal.t.e(664685281, true, new a(model), startRestartGroup, 54), startRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: dn4.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = m0.c(n0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}
