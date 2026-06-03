package hq4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import hq4.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import w0.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    static {
        Covode.recordClassIndex(609668);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(String str, String str2, String str3, boolean z, Function0 function0, Function0 function02, Function0 function03, Function0 function04, f0 f0Var, int i, int i2, Composer composer, int i3) {
        f(str, str2, str3, z, function0, function02, function03, function04, f0Var, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(String str, String str2, String str3, boolean z, Function0 function0, Function0 function02, Function0 function03, f0 f0Var, int i, int i2, Composer composer, int i3) {
        j(str, str2, str3, z, function0, function02, function03, f0Var, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.INSTANCE;
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ f0 a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;
        final /* synthetic */ Function0<Unit> d;
        final /* synthetic */ Function0<Unit> e;
        final /* synthetic */ String f;
        final /* synthetic */ Function0<Unit> g;
        final /* synthetic */ String h;

        b(f0 f0Var, String str, boolean z, Function0<Unit> function0, Function0<Unit> function02, String str2, Function0<Unit> function03, String str3) {
            this.a = f0Var;
            this.b = str;
            this.c = z;
            this.d = function0;
            this.e = function02;
            this.f = str2;
            this.g = function03;
            this.h = str3;
        }

        static final class a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ String a;
            final /* synthetic */ boolean b;
            final /* synthetic */ f0 c;
            final /* synthetic */ Function0<Unit> d;
            final /* synthetic */ Function0<Unit> e;
            final /* synthetic */ String f;
            final /* synthetic */ Function0<Unit> g;
            final /* synthetic */ String h;

            a(String str, boolean z, f0 f0Var, Function0<Unit> function0, Function0<Unit> function02, String str2, Function0<Unit> function03, String str3) {
                this.a = str;
                this.b = z;
                this.c = f0Var;
                this.d = function0;
                this.e = function02;
                this.f = str2;
                this.g = function03;
                this.h = str3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit e(Function0 function0) {
                function0.invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit f(Function0 function0) {
                function0.invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit g(Function0 function0) {
                function0.invoke();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                d(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void d(Composer composer, int i) {
                boolean z;
                og4.a aVar;
                int i2;
                int i3;
                if ((i & 3) != 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1158395903, i, -1, "com.dragon.read.kmp.widget.dialog.CommonDialogView.<anonymous>.<anonymous> (CommonDialog.kt:82)");
                    }
                    Modifier.a aVar2 = Modifier.Companion;
                    Modifier h = SizeKt.h(aVar2, 0.0f, 1, (Object) null);
                    String str = this.a;
                    boolean z2 = this.b;
                    f0 f0Var = this.c;
                    final Function0<Unit> function0 = this.d;
                    final Function0<Unit> function02 = this.e;
                    String str2 = this.f;
                    final Function0<Unit> function03 = this.g;
                    String str3 = this.h;
                    androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                    e.m i4 = eVar.i();
                    e.a aVar3 = androidx.compose.ui.e.a;
                    p0 a = androidx.compose.foundation.layout.x.a(i4, aVar3.k(), composer, 0);
                    int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer, h);
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
                    g5.e(b, a, companion.c());
                    g5.e(b, currentCompositionLocalMap, companion.e());
                    Function2 b2 = companion.b();
                    if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                        b.updateRememberedValue(Integer.valueOf(a2));
                        b.apply(Integer.valueOf(a2), b2);
                    }
                    g5.e(b, e, companion.d());
                    androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                    Modifier h2 = SizeKt.h(aVar2, 0.0f, 1, (Object) null);
                    p0 i5 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                    int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(composer, h2);
                    Function0 a5 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a5);
                    } else {
                        composer.useNode();
                    }
                    Composer b3 = g5.b(composer);
                    g5.e(b3, i5, companion.c());
                    g5.e(b3, currentCompositionLocalMap2, companion.e());
                    Function2 b4 = companion.b();
                    if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                        b3.updateRememberedValue(Integer.valueOf(a4));
                        b3.apply(Integer.valueOf(a4), b4);
                    }
                    g5.e(b3, e2, companion.d());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                    Modifier t = f2.t(boxScopeInstance.b(SizeKt.h(aVar2, 0.0f, 1, (Object) null), aVar3.e()), 0.0f, x0.i.g(32), 1, (Object) null);
                    h.a aVar4 = w0.h.b;
                    int a6 = aVar4.a();
                    og4.a aVar5 = og4.a.a;
                    long k = aVar5.h(composer, 6).k();
                    long h3 = x0.x.h(16);
                    c0.a aVar6 = androidx.compose.ui.text.font.c0.b;
                    a6.j(str, t, k, h3, (androidx.compose.ui.text.font.y) null, aVar6.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(a6), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 130512);
                    composer.startReplaceGroup(1009395512);
                    if (!z2) {
                        i3 = 0;
                        e1 a7 = org.jetbrains.compose.resources.c.a(f0Var.c, composer, 0);
                        float f = 12;
                        Modifier b5 = boxScopeInstance.b(SizeKt.s(f2.v(aVar2, 0.0f, x0.i.g(f), x0.i.g(f), 0.0f, 9, (Object) null), x0.i.g(16)), aVar3.n());
                        composer.startReplaceGroup(5004770);
                        boolean changed = composer.changed(function0);
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function0() { // from class: hq4.g
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit e3;
                                    e3 = f.b.a.e(Function0.this);
                                    return e3;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceGroup();
                        aVar = aVar5;
                        i2 = 6;
                        z0.g(a7, "关闭弹窗", ClickableKt.clickable-oSLSa3U$default(b5, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(m0.b, aVar.h(composer, 6).C(), 0, 2, (Object) null), 0, composer, 48, 184);
                    } else {
                        aVar = aVar5;
                        i2 = 6;
                        i3 = 0;
                    }
                    composer.endReplaceGroup();
                    composer.endNode();
                    a3.a(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar2, 0.0f, 1, (Object) null), x0.i.g(0.5f)), aVar.h(composer, i2).t(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, i3);
                    Modifier i6 = SizeKt.i(SizeKt.h(aVar2, 0.0f, 1, (Object) null), x0.i.g(54));
                    p0 b6 = r2.b(eVar.h(), aVar3.i(), composer, 48);
                    int a8 = j.a(androidx.compose.runtime.i.b(composer, i3));
                    androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                    Modifier e3 = ComposedModifierKt.e(composer, i6);
                    Function0 a9 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a9);
                    } else {
                        composer.useNode();
                    }
                    Composer b7 = g5.b(composer);
                    g5.e(b7, b6, companion.c());
                    g5.e(b7, currentCompositionLocalMap3, companion.e());
                    Function2 b8 = companion.b();
                    if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a8))) {
                        b7.updateRememberedValue(Integer.valueOf(a8));
                        b7.apply(Integer.valueOf(a8), b8);
                    }
                    g5.e(b7, e3, companion.d());
                    w2 w2Var = w2.b;
                    Modifier a10 = u2.a(w2Var, aVar2, 1.0f, false, 2, (Object) null);
                    composer.startReplaceGroup(5004770);
                    boolean changed2 = composer.changed(function02);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: hq4.h
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit f2;
                                f2 = f.b.a.f(Function0.this);
                                return f2;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceGroup();
                    a6.j(str2, ClickableKt.clickable-oSLSa3U$default(a10, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), aVar.h(composer, i2).k(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, aVar6.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar4.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 130512);
                    a3.a(BackgroundKt.d(SizeKt.u(aVar2, x0.i.g(0.5f), x0.i.g(16)), aVar.h(composer, 6).E(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
                    Modifier a11 = u2.a(w2Var, aVar2, 1.0f, false, 2, (Object) null);
                    composer.startReplaceGroup(5004770);
                    boolean changed3 = composer.changed(function03);
                    Object rememberedValue3 = composer.rememberedValue();
                    if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: hq4.i
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit g;
                                g = f.b.a.g(Function0.this);
                                return g;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    composer.endReplaceGroup();
                    a6.j(str3, ClickableKt.clickable-oSLSa3U$default(a11, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null), aVar.h(composer, 6).f(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, aVar6.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar4.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 130512);
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
                    ComposerKt.traceEventStart(192903836, i, -1, "com.dragon.read.kmp.widget.dialog.CommonDialogView.<anonymous> (CommonDialog.kt:79)");
                }
                f0 f0Var = this.a;
                androidx.compose.material.w.a(f0Var.a, f0Var.b, og4.a.a.h(composer, 6).D(), 0L, (androidx.compose.foundation.w) null, 0.0f, androidx.compose.runtime.internal.t.e(1158395903, true, new a(this.b, this.c, this.a, this.d, this.e, this.f, this.g, this.h), composer, 54), composer, 1572864, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ boolean d;
        final /* synthetic */ Function0<Unit> e;
        final /* synthetic */ Function0<Unit> f;
        final /* synthetic */ Function0<Unit> g;
        final /* synthetic */ f0 h;

        a(String str, String str2, String str3, boolean z, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, f0 f0Var) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = function0;
            this.f = function02;
            this.g = function03;
            this.h = f0Var;
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
                    ComposerKt.traceEventStart(330707893, i, -1, "com.dragon.read.kmp.widget.dialog.CommonDialog.<anonymous> (CommonDialog.kt:54)");
                }
                f.j(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(final java.lang.String r23, final java.lang.String r24, final java.lang.String r25, boolean r26, final kotlin.jvm.functions.Function0<kotlin.Unit> r27, final kotlin.jvm.functions.Function0<kotlin.Unit> r28, kotlin.jvm.functions.Function0<kotlin.Unit> r29, hq4.f0 r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hq4.f.j(java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, hq4.f0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(final java.lang.String r25, final java.lang.String r26, final java.lang.String r27, boolean r28, final kotlin.jvm.functions.Function0<kotlin.Unit> r29, final kotlin.jvm.functions.Function0<kotlin.Unit> r30, kotlin.jvm.functions.Function0<kotlin.Unit> r31, kotlin.jvm.functions.Function0<kotlin.Unit> r32, hq4.f0 r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hq4.f.f(java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, hq4.f0, androidx.compose.runtime.Composer, int, int):void");
    }
}
