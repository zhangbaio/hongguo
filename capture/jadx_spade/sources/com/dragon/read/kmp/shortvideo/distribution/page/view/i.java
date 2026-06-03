package com.dragon.read.kmp.shortvideo.distribution.page.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.e90;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.compose.common.image.n;
import com.dragon.read.kmp.utils.StringUtilsKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w0.s;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    static {
        Covode.recordClassIndex(609086);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(List list, long j, float f, int i, int i2, Composer composer, int i3) {
        e(list, j, f, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(List list, long j, float f, int i, int i2, Composer composer, int i3) {
        e(list, j, f, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(e90 e90Var, long j, int i, Composer composer, int i2) {
        h(e90Var, j, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(String str, long j, int i, Composer composer, int i2) {
        j(str, j, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final class a extends com.dragon.read.kmp.basenovel.ui.widget.f<e90> {
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j) {
            super(j, (DefaultConstructorMarker) null);
            this.d = j;
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(int i, e90 info, Composer composer, int i2) {
            Intrinsics.checkNotNullParameter(info, "info");
            composer.startReplaceGroup(-1448770879);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1448770879, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.view.SecondaryInfoList.<no name provided>.createTagView (SecondaryInfoList.kt:38)");
            }
            if (StringUtilsKt.a(info.k)) {
                composer.startReplaceGroup(-206755749);
                i.h(info, this.d, composer, (i2 >> 3) & 14);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-206680233);
                String str = info.a;
                if (str == null) {
                    str = "";
                }
                i.j(str, this.d, composer, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final String str, final long j, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        float g;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(1322651648);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(j)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        int i5 = i2;
        if ((i5 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1322651648, i5, -1, "com.dragon.read.kmp.shortvideo.distribution.page.view.TagView (SecondaryInfoList.kt:50)");
            }
            long h = x.h(16);
            og4.a aVar = og4.a.a;
            long p = aVar.d().p();
            int b = s.b.b();
            Modifier.a aVar2 = Modifier.Companion;
            wc4.a c = wc4.c.c();
            if (c != null) {
                g = c.t4();
            } else {
                g = x0.i.g(4);
            }
            composer2 = startRestartGroup;
            a6.j(str, f2.s(BackgroundKt.d(ig4.i.c(aVar2, x0.i.d(g), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), aVar.d().t0(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(4), x0.i.g(1)), p, j, (y) null, (c0) null, (j) null, 0L, (w0.i) null, (w0.h) null, h, b, false, 1, 0, (Function1) null, (g3) null, composer2, (i5 & 14) | ((i5 << 6) & 7168), 3126, 119792);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.view.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = i.k(str, j, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }

    public static final void h(final e90 info, final long j, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        float g;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(info, "info");
        Composer startRestartGroup = composer.startRestartGroup(-898676855);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(info)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(j)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-898676855, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.view.TagTextIconView (SecondaryInfoList.kt:68)");
            }
            Modifier.a aVar = Modifier.Companion;
            wc4.a c = wc4.c.c();
            if (c != null) {
                g = c.t4();
            } else {
                g = x0.i.g(4);
            }
            Modifier c2 = ig4.i.c(aVar, x0.i.d(g), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null);
            og4.a aVar2 = og4.a.a;
            Modifier s = f2.s(BackgroundKt.d(c2, aVar2.d().f1(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(4), x0.i.g(1));
            p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, b, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            w2 w2Var = w2.b;
            float f = 12;
            LoadImageKt.g(info.k, (String) null, (n) null, SizeKt.x(SizeKt.i(aVar, x0.i.g(f)), x0.i.g(f)), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 3072, 118);
            float g2 = x0.i.g(3);
            startRestartGroup.startReplaceGroup(-344996060);
            a3.a(SizeKt.x(aVar, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            String str = info.a;
            if (str == null) {
                str = "";
            }
            composer2 = startRestartGroup;
            a6.j(str, (Modifier) null, aVar2.h(startRestartGroup, og4.a.b).c(), j, (y) null, (c0) null, (j) null, 0L, (w0.i) null, (w0.h) null, x.h(16), s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, (i2 << 6) & 7168, 3126, 119794);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.view.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i5;
                    i5 = i.i(info, j, i, (Composer) obj, ((Integer) obj2).intValue());
                    return i5;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final java.util.List<com.bytedance.kmp.reading.model.e90> r22, long r23, float r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.view.i.e(java.util.List, long, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
