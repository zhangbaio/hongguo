package com.dragon.read.kmp.profile.component;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.layout.b2;
import androidx.compose.ui.layout.n0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.layout.p1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.y2;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v {
    static {
        Covode.recordClassIndex(608041);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(String str, Modifier modifier, float f, float f2, Function2 function2, Function2 function22, g3 g3Var, int i, int i2, Composer composer, int i3) {
        d(str, modifier, f, f2, function2, function22, g3Var, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> a;
        final /* synthetic */ float b;
        final /* synthetic */ String c;
        final /* synthetic */ g3 d;
        final /* synthetic */ boolean e;
        final /* synthetic */ Function2<Composer, Integer, Unit> f;
        final /* synthetic */ float g;

        a(Function2<? super Composer, ? super Integer, Unit> function2, float f, String str, g3 g3Var, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, float f2) {
            this.a = function2;
            this.b = f;
            this.c = str;
            this.d = g3Var;
            this.e = z;
            this.f = function22;
            this.g = f2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            boolean z2;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1593415625, i, -1, "com.dragon.read.kmp.profile.component.StrictTagTitleIcon2Lines.<anonymous>.<anonymous>.<anonymous> (TagTitleIconLayout.kt:128)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier i2 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(20));
                e.c i3 = androidx.compose.ui.e.a.i();
                Function2<Composer, Integer, Unit> function2 = this.a;
                float f = this.b;
                String str = this.c;
                g3 g3Var = this.d;
                boolean z3 = this.e;
                Function2<Composer, Integer, Unit> function22 = this.f;
                float f2 = this.g;
                p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), i3, composer, 48);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, i2);
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
                Composer b2 = g5.b(composer);
                g5.e(b2, b, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                    b2.updateRememberedValue(Integer.valueOf(a));
                    b2.apply(Integer.valueOf(a), b3);
                }
                g5.e(b2, e, companion.d());
                w2 w2Var = w2.b;
                composer.startReplaceGroup(-682177981);
                if (function2 != null) {
                    function2.invoke(composer, 0);
                }
                composer.endReplaceGroup();
                composer.startReplaceGroup(-682176702);
                if (function2 != null) {
                    z2 = false;
                    a3.a(SizeKt.x(aVar, f), composer, 0);
                } else {
                    z2 = false;
                }
                composer.endReplaceGroup();
                a6.j(str, w2Var.a(aVar, 1.0f, z2), 0L, 0L, (y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.e(), false, 1, 0, (Function1) null, g3Var, composer, 0, 3120, 55292);
                composer.startReplaceGroup(-682165674);
                if (z3 && function22 != null) {
                    a3.a(SizeKt.x(aVar, f2), composer, 0);
                    function22.invoke(composer, 0);
                }
                composer.endReplaceGroup();
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

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ g3 b;
        final /* synthetic */ boolean c;
        final /* synthetic */ Function2<Composer, Integer, Unit> d;
        final /* synthetic */ float e;

        b(String str, g3 g3Var, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, float f) {
            this.a = str;
            this.b = g3Var;
            this.c = z;
            this.d = function2;
            this.e = f;
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
                    ComposerKt.traceEventStart(1157052036, i, -1, "com.dragon.read.kmp.profile.component.StrictTagTitleIcon2Lines.<anonymous>.<anonymous>.<anonymous> (TagTitleIconLayout.kt:157)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier i2 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(20));
                e.c i3 = androidx.compose.ui.e.a.i();
                String str = this.a;
                g3 g3Var = this.b;
                boolean z2 = this.c;
                Function2<Composer, Integer, Unit> function2 = this.d;
                float f = this.e;
                p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), i3, composer, 48);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, i2);
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
                Composer b2 = g5.b(composer);
                g5.e(b2, b, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                    b2.updateRememberedValue(Integer.valueOf(a));
                    b2.apply(Integer.valueOf(a), b3);
                }
                g5.e(b2, e, companion.d());
                a6.j(str, w2.b.a(aVar, 1.0f, false), 0L, 0L, (y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, g3Var, composer, 0, 3120, 55292);
                composer.startReplaceGroup(-2002072811);
                if (z2 && function2 != null) {
                    a3.a(SizeKt.x(aVar, f), composer, 0);
                    function2.invoke(composer, 0);
                }
                composer.endReplaceGroup();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(p1 p1Var, p1 p1Var2, p1.a layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        p1.a.N(layout, p1Var, 0, 0, 0.0f, 4, (Object) null);
        if (p1Var2 != null) {
            p1.a.N(layout, p1Var2, 0, p1Var.b, 0.0f, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private static final p1 h(b2 b2Var, long j, String str, Function2<? super Composer, ? super Integer, Unit> function2) {
        Object firstOrNull;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) b2Var.I1(str, function2));
        n0 n0Var = (n0) firstOrNull;
        if (n0Var != null) {
            return n0Var.L(j);
        }
        return null;
    }

    private static final int g(androidx.compose.ui.text.a3 a3Var, g3 g3Var, String str, int i) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z || i <= 0) {
            return 0;
        }
        try {
            y2 d = androidx.compose.ui.text.a3.d(a3Var, new androidx.compose.ui.text.e(str, (List) null, 2, (DefaultConstructorMarker) null), g3Var, 0, false, 1, (List) null, x0.c.b(0, i, 0, 0, 13, (Object) null), (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1964, (Object) null);
            if (d.k() <= 0) {
                return 0;
            }
            return d.l(0, true);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.layout.r0 e(kotlin.jvm.functions.Function2 r19, kotlin.jvm.functions.Function2 r20, float r21, float r22, java.lang.String r23, androidx.compose.ui.text.a3 r24, androidx.compose.ui.text.g3 r25, androidx.compose.ui.layout.b2 r26, x0.b r27) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.component.v.e(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, float, float, java.lang.String, androidx.compose.ui.text.a3, androidx.compose.ui.text.g3, androidx.compose.ui.layout.b2, x0.b):androidx.compose.ui.layout.r0");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(final java.lang.String r21, androidx.compose.ui.Modifier r22, float r23, float r24, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, final androidx.compose.ui.text.g3 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.component.v.d(java.lang.String, androidx.compose.ui.Modifier, float, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.text.g3, androidx.compose.runtime.Composer, int, int):void");
    }
}
