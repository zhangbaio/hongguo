package cl4;

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
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class y {
    static {
        Covode.recordClassIndex(608059);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(androidx.compose.foundation.layout.r rVar, String str, boolean z, int i, Composer composer, int i2) {
        d(rVar, str, z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(gk4.w wVar, Function3 function3, boolean z, String str, boolean z2, int i, int i2, Composer composer, int i3) {
        f(wVar, function3, z, str, z2, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(androidx.compose.foundation.layout.r rVar, String str, boolean z, int i, Composer composer, int i2) {
        h(rVar, str, z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private static final void d(final androidx.compose.foundation.layout.r rVar, final String str, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        List listOf;
        long H2;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-129349054);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(str)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        int i6 = i2;
        if ((i6 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-129349054, i6, -1, "com.dragon.read.kmp.profile.container.double_column.BottomTypeTag (CoverInfo.kt:111)");
            }
            Modifier.a aVar = Modifier.Companion;
            e.a aVar2 = androidx.compose.ui.e.a;
            Modifier h = SizeKt.h(rVar.b(aVar, aVar2.b()), 0.0f, 1, (Object) null);
            c0.a aVar3 = androidx.compose.ui.graphics.c0.b;
            l0.a aVar4 = androidx.compose.ui.graphics.l0.b;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(aVar4.g()), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(aVar4.a(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null))});
            Modifier b = BackgroundKt.b(h, c0.a.p(aVar3, listOf, 0.0f, 0.0f, 0, 14, (Object) null), (f2) null, 0.0f, 6, (Object) null);
            androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, b);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a2 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a2);
            } else {
                startRestartGroup.useNode();
            }
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i7, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                b2.updateRememberedValue(Integer.valueOf(a));
                b2.apply(Integer.valueOf(a), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            long h2 = x0.x.h(12);
            androidx.compose.ui.text.font.c0 i8 = androidx.compose.ui.text.font.c0.b.i();
            long h3 = x0.x.h(16);
            if (z) {
                startRestartGroup.startReplaceGroup(-959549812);
                H2 = og4.a.a.h(startRestartGroup, og4.a.b).r();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-959485890);
                H2 = og4.a.a.h(startRestartGroup, og4.a.b).H2();
                startRestartGroup.endReplaceGroup();
            }
            composer2 = startRestartGroup;
            a6.j(str, androidx.compose.foundation.layout.f2.v(boxScopeInstance.b(aVar, aVar2.c()), 0.0f, 0.0f, x0.i.g(8), x0.i.g(6), 3, (Object) null), H2, h2, (androidx.compose.ui.text.font.y) null, i8, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, h3, 0, false, 1, 0, (Function1) null, (g3) null, composer2, ((i6 >> 3) & 14) | 199680, 3078, 121808);
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
            endRestartGroup.a(new Function2() { // from class: cl4.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e2;
                    e2 = y.e(rVar, str, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e2;
                }
            });
        }
    }

    private static final void h(final androidx.compose.foundation.layout.r rVar, final String str, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        long H2;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(1012772973);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(str)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        int i6 = i2;
        if ((i6 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1012772973, i6, -1, "com.dragon.read.kmp.profile.container.double_column.TypeTag (CoverInfo.kt:82)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier B = SizeKt.B(SizeKt.F(aVar, (e.b) null, false, 3, (Object) null), (e.c) null, false, 3, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            Modifier b = rVar.b(B, aVar2.o());
            float f = 8;
            Modifier c = ig4.i.c(b, (x0.i) null, x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 21, (Object) null);
            og4.a aVar3 = og4.a.a;
            int i7 = og4.a.b;
            Modifier d = BackgroundKt.d(c, aVar3.h(startRestartGroup, i7).K(), (f2) null, 2, (Object) null);
            androidx.compose.ui.layout.p0 i8 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, d);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a2 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a2);
            } else {
                startRestartGroup.useNode();
            }
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i8, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                b2.updateRememberedValue(Integer.valueOf(a));
                b2.apply(Integer.valueOf(a), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            int b4 = w0.s.b.b();
            long h = x0.x.h(12);
            androidx.compose.ui.text.font.c0 i9 = androidx.compose.ui.text.font.c0.b.i();
            long h2 = x0.x.h(16);
            if (z) {
                startRestartGroup.startReplaceGroup(-1903549631);
                H2 = aVar3.h(startRestartGroup, i7).r();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1903485709);
                H2 = aVar3.h(startRestartGroup, i7).H2();
                startRestartGroup.endReplaceGroup();
            }
            float f2 = 2;
            composer2 = startRestartGroup;
            a6.j(str, boxScopeInstance.b(androidx.compose.foundation.layout.f2.u(aVar, x0.i.g(f), x0.i.g(f2), x0.i.g(f), x0.i.g(f2)), aVar2.e()), H2, h, (androidx.compose.ui.text.font.y) null, i9, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, h2, b4, false, 1, 0, (Function1) null, (g3) null, composer2, ((i6 >> 3) & 14) | 199680, 3126, 119760);
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
            endRestartGroup.a(new Function2() { // from class: cl4.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i10;
                    i10 = y.i(rVar, str, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return i10;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(final gk4.w r28, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.r, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, boolean r30, java.lang.String r31, boolean r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cl4.y.f(gk4.w, kotlin.jvm.functions.Function3, boolean, java.lang.String, boolean, androidx.compose.runtime.Composer, int, int):void");
    }
}
