package bm4;

import android.content.Context;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.g2;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.state.BookCoverViewModelKt;
import com.dragon.read.reader.f1;
import com.dragon.read.reader.m3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r0 {
    static {
        Covode.recordClassIndex(608285);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(int i, Composer composer, int i2) {
        c(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(com.dragon.read.kmp.reader.state.a aVar) {
        Context a = com.dragon.read.kmp.utils.l.a();
        String str = aVar.a;
        if (str == null) {
            str = "";
        }
        pm4.i.a(a, str);
        return Unit.INSTANCE;
    }

    public static final void c(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        String str;
        org.jetbrains.compose.resources.b k;
        long n;
        Composer startRestartGroup = composer.startRestartGroup(-222836730);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-222836730, i, -1, "com.dragon.read.kmp.reader.bookcover.view.StartReadHintView (StartReadHintView.kt:34)");
            }
            com.dragon.read.kmp.reader.state.b b = BookCoverViewModelKt.b(startRestartGroup, 0);
            final com.dragon.read.kmp.reader.state.a aVar = (com.dragon.read.kmp.reader.state.a) b.b.getValue();
            long x = ((androidx.compose.ui.graphics.l0) b.d.getValue()).x();
            boolean z2 = aVar.y;
            if (z2) {
                str = "上滑开始阅读";
            } else {
                str = "左滑开始阅读";
            }
            String str2 = str;
            if (z2) {
                k = f1.l(m3.a);
            } else {
                k = f1.k(m3.a);
            }
            boolean a = pm4.r.a(zl4.s.a.c(startRestartGroup, zl4.s.b));
            startRestartGroup.startReplaceGroup(602286178);
            if (a) {
                n = ((zl4.b) startRestartGroup.consume(zl4.r.w())).k();
            } else {
                n = androidx.compose.ui.graphics.l0.n(x, 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            }
            startRestartGroup.endReplaceGroup();
            e.c i2 = androidx.compose.ui.e.a.i();
            Modifier.a aVar2 = Modifier.Companion;
            float f = (float) 0.5d;
            Modifier g = androidx.compose.foundation.o.g(aVar2, new androidx.compose.foundation.w(x0.i.g(f), new g2(n, (DefaultConstructorMarker) null), (DefaultConstructorMarker) null), k.g.c(x0.i.g(18)));
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance = startRestartGroup.changedInstance(aVar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: bm4.p0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit d;
                        d = r0.d(com.dragon.read.kmp.reader.state.a.this);
                        return d;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier s = f2.s(ClickableKt.clickable-oSLSa3U$default(g, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), x0.i.g(16), x0.i.g(8));
            androidx.compose.ui.layout.p0 b2 = r2.b(androidx.compose.foundation.layout.e.a.h(), i2, startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, s);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a3 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a3);
            } else {
                startRestartGroup.useNode();
            }
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, b2, companion.c());
            g5.e(b3, currentCompositionLocalMap, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                b3.updateRememberedValue(Integer.valueOf(a2));
                b3.apply(Integer.valueOf(a2), b4);
            }
            g5.e(b3, e, companion.d());
            w2 w2Var = w2.b;
            z0.c(org.jetbrains.compose.resources.c.b(k, startRestartGroup, 0), (String) null, (Modifier) null, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, x, 0, 2, (Object) null), startRestartGroup, 48, 60);
            a3.a(SizeKt.x(aVar2, x0.i.g(f)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            a6.j(str2, (Modifier) null, androidx.compose.ui.graphics.l0.n(x, 0.75f, 0.0f, 0.0f, 0.0f, 14, (Object) null), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3072, 0, 131058);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bm4.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e2;
                    e2 = r0.e(i, (Composer) obj, ((Integer) obj2).intValue());
                    return e2;
                }
            });
        }
    }
}
