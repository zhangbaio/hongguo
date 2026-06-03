package hp4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.i;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import pm4.q;
import sk5.n;
import sk5.p;
import w0.h;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(609249);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(String str, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        b(str, z, function0, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;

        a(String str, boolean z) {
            this.a = str;
            this.b = z;
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
                    ComposerKt.traceEventStart(2120280520, i, -1, "com.dragon.read.kmp.story.impl.feeds.boxview.ExpandBoxView.<anonymous> (ExpandBoxView.kt:46)");
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
                String str = this.a;
                boolean z2 = this.b;
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
                p0 b3 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.i(), composer, 48);
                int a3 = j.a(i.b(composer, 0));
                e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, aVar);
                Function0 a4 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a4);
                } else {
                    composer.useNode();
                }
                Composer b4 = g5.b(composer);
                g5.e(b4, b3, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a3))) {
                    b4.updateRememberedValue(Integer.valueOf(a3));
                    b4.apply(Integer.valueOf(a3), b5);
                }
                g5.e(b4, e3, companion.d());
                w2 w2Var = w2.b;
                float f3 = 16;
                a3.a(SizeKt.x(aVar, x0.i.g(f3)), composer, 6);
                a6.j(str, (Modifier) null, cVar.b(composer, 6).g(), x.h(14), (y) null, c0.b.f(), (j) null, 0L, (w0.i) null, (h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 131026);
                a3.a(SizeKt.x(aVar, x0.i.g(4)), composer, 6);
                Painter b6 = org.jetbrains.compose.resources.c.b(n.j(p.a), composer, 0);
                m0 c = m0.a.c(m0.b, cVar.b(composer, 6).g(), 0, 2, (Object) null);
                Modifier s = SizeKt.s(aVar, x0.i.g(f3));
                if (!z2) {
                    f = 0.0f;
                } else {
                    f = 180.0f;
                }
                z0.c(b6, "展开箭头", androidx.compose.ui.draw.n.a(s, f), aVar2.e(), (androidx.compose.ui.layout.i) null, 0.0f, c, composer, 3120, 48);
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final java.lang.String r24, boolean r25, final kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hp4.b.b(java.lang.String, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
