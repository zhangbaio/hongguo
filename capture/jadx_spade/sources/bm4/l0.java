package bm4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l0 {
    static {
        Covode.recordClassIndex(608283);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Modifier modifier, com.dragon.read.kmp.reader.bookcover.epub.e eVar, int i, int i2, Composer composer, int i3) {
        c(modifier, eVar, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(com.dragon.read.kmp.reader.bookcover.epub.e eVar) {
        eVar.b();
        return Unit.INSTANCE;
    }

    public static final void c(Modifier modifier, final com.dragon.read.kmp.reader.bookcover.epub.e event, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        boolean changedInstance;
        int i5;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        Modifier modifier4;
        long n;
        Intrinsics.checkNotNullParameter(event, "event");
        Composer startRestartGroup = composer.startRestartGroup(-1064384981);
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(event);
            } else {
                changedInstance = startRestartGroup.changedInstance(event);
            }
            if (changedInstance) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        boolean z2 = true;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i6 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1064384981, i3, -1, "com.dragon.read.kmp.reader.bookcover.view.ListenEntranceView (KmpListenEntranceView.kt:28)");
            }
            zl4.s sVar = zl4.s.a;
            int i7 = zl4.s.b;
            boolean a = pm4.r.a(sVar.c(startRestartGroup, i7));
            Modifier a2 = androidx.compose.ui.draw.e.a(modifier4, k.g.c(x0.i.g(16)));
            startRestartGroup.startReplaceGroup(-671741601);
            if (a) {
                n = sVar.b(startRestartGroup, i7).c(startRestartGroup, 0);
            } else {
                n = androidx.compose.ui.graphics.l0.n(androidx.compose.ui.graphics.l0.b.i(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            }
            startRestartGroup.endReplaceGroup();
            Modifier d = BackgroundKt.d(a2, n, (f2) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            if ((i3 & 112) != 32 && ((i3 & 64) == 0 || !startRestartGroup.changedInstance(event))) {
                z2 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: bm4.j0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit d2;
                        d2 = l0.d(com.dragon.read.kmp.reader.bookcover.epub.e.this);
                        return d2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier s = androidx.compose.foundation.layout.f2.s(ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), x0.i.g(8), x0.i.g(4));
            androidx.compose.ui.layout.p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), startRestartGroup, 48);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, s);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a4 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a4);
            } else {
                startRestartGroup.useNode();
            }
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, b, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion.d());
            w2 w2Var = w2.b;
            long h = x0.x.h(12);
            androidx.compose.ui.text.font.c0 d2 = androidx.compose.ui.text.font.c0.b.d();
            long q = sVar.b(startRestartGroup, i7).q();
            modifier3 = modifier4;
            composer2 = startRestartGroup;
            a6.j("听书", (Modifier) null, q, h, (androidx.compose.ui.text.font.y) null, d2, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199686, 0, 131026);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bm4.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e2;
                    e2 = l0.e(modifier3, event, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return e2;
                }
            });
        }
    }
}
