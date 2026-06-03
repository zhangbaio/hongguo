package com.dragon.read.kmp.widget;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
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
public final class q {
    public static final q a;

    static {
        Covode.recordClassIndex(609630);
        a = new q();
    }

    private q() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(q qVar, boolean z, String str, int i, boolean z2, boolean z3, Modifier modifier, int i2, Composer composer, int i3) {
        qVar.h(z, str, i, z2, z3, modifier, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(q qVar, State state, State state2, State state3, boolean z, boolean z2, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        qVar.j(state, state2, state3, z, z2, function0, function02, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(q qVar, State state, State state2, State state3, boolean z, boolean z2, float f, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        qVar.l(state, state2, state3, z, z2, f, function0, function02, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(q qVar, boolean z, boolean z2, boolean z3, float f, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        qVar.p(z, z2, z3, f, function0, function02, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private static final gk4.l m(State<gk4.l> state) {
        return (gk4.l) state.getValue();
    }

    private static final gk4.m n(State<gk4.m> state) {
        return (gk4.m) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean d;
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ float h;
        final /* synthetic */ Function0<Unit> i;
        final /* synthetic */ Function0<Unit> j;

        a(boolean z, String str, int i, boolean z2, boolean z3, boolean z4, boolean z5, float f, Function0<Unit> function0, Function0<Unit> function02) {
            this.a = z;
            this.b = str;
            this.c = i;
            this.d = z2;
            this.e = z3;
            this.f = z4;
            this.g = z5;
            this.h = f;
            this.i = function0;
            this.j = function02;
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
                    ComposerKt.traceEventStart(1518028589, i, -1, "com.dragon.read.kmp.widget.BookshelfTopBar.getBookshelfTopBar.<anonymous> (BookshelfTopBar.kt:86)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier d = BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(48)), og4.a.a.h(composer, og4.a.b).b(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                boolean z2 = this.a;
                String str = this.b;
                int i2 = this.c;
                boolean z3 = this.d;
                boolean z4 = this.e;
                boolean z5 = this.f;
                boolean z6 = this.g;
                float f = this.h;
                Function0<Unit> function0 = this.i;
                Function0<Unit> function02 = this.j;
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
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
                g5.e(b, i3, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                q qVar = q.a;
                qVar.h(z2, str, i2, z3, z4, boxScopeInstance.b(aVar, aVar2.e()), composer, 1572864);
                qVar.p(z2, z5, z6, f, function0, function02, composer, 1572864);
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

    private final Modifier r(Modifier modifier, final Function0<Unit> function0, Composer composer, int i) {
        boolean z;
        composer.startReplaceGroup(2123974261);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2123974261, i, -1, "com.dragon.read.kmp.widget.BookshelfTopBar.noRippleClickable (BookshelfTopBar.kt:212)");
        }
        composer.startReplaceGroup(1849434622);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = androidx.compose.foundation.interaction.h.a();
            composer.updateRememberedValue(rememberedValue);
        }
        androidx.compose.foundation.interaction.i iVar = (androidx.compose.foundation.interaction.i) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(5004770);
        if ((((i & 112) ^ 48) > 32 && composer.changed(function0)) || (i & 48) == 32) {
            z = true;
        } else {
            z = false;
        }
        Object rememberedValue2 = composer.rememberedValue();
        if (z || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.widget.p
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit s;
                    s = q.s(Function0.this);
                    return s;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Modifier modifier2 = ClickableKt.clickable-O2vRcR0$default(modifier, iVar, (androidx.compose.foundation.b1) null, false, (String) null, (Role) null, (Function0) rememberedValue2, 28, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifier2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(final boolean z, final String str, final int i, final boolean z2, final boolean z3, final Modifier modifier, Composer composer, final int i2) {
        int i3;
        boolean z4;
        String str2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1819119080);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(z)) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i3 = i9 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(str)) {
                i8 = 32;
            } else {
                i8 = 16;
            }
            i3 |= i8;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(i)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i3 |= i7;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changed(z2)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i2 & 24576) == 0) {
            if (startRestartGroup.changed(z3)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i3 |= i5;
        }
        if ((196608 & i2) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i3 |= i4;
        }
        if ((74899 & i3) != 74898) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (startRestartGroup.shouldExecute(z4, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1819119080, i3, -1, "com.dragon.read.kmp.widget.BookshelfTopBar.getBarTitle (BookshelfTopBar.kt:171)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(-520567750);
                Modifier d = SizeKt.d(modifier, 0.0f, 1, (Object) null);
                androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.g(), startRestartGroup, 48);
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, d);
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
                Composer b = g5.b(startRestartGroup);
                g5.e(b, a2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                    b.updateRememberedValue(Integer.valueOf(a3));
                    b.apply(Integer.valueOf(a3), b2);
                }
                g5.e(b, e, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                long h = x0.x.h(18);
                androidx.compose.ui.text.font.c0 a5 = androidx.compose.ui.text.font.c0.b.a();
                int b3 = w0.s.b.b();
                og4.a aVar = og4.a.a;
                int i10 = og4.a.b;
                a6.j(str, (Modifier) null, aVar.h(startRestartGroup, i10).k(), h, (androidx.compose.ui.text.font.y) null, a5, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b3, false, 1, 0, (Function1) null, (g3) null, startRestartGroup, ((i3 >> 3) & 14) | 199680, 3120, 120786);
                a3.a(SizeKt.i(Modifier.Companion, x0.i.g(2)), startRestartGroup, 6);
                if (z3) {
                    str2 = "已选择 " + i + " 个";
                } else if (z2) {
                    str2 = "已选择 " + i + " 本书";
                } else {
                    str2 = "已选择 " + i + " 部剧";
                }
                a6.j(str2, (Modifier) null, aVar.h(startRestartGroup, i10).j(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 3072, 0, 131058);
                startRestartGroup.endNode();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-519628667);
                a6.j(str, SizeKt.B(modifier, (e.c) null, false, 3, (Object) null), og4.a.a.h(startRestartGroup, og4.a.b).k(), x0.x.h(18), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, ((i3 >> 3) & 14) | 199680, 3120, 120784);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.widget.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i11;
                    i11 = q.i(q.this, z, str, i, z2, z3, modifier, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return i11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(final boolean z, final boolean z2, final boolean z3, final float f, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        boolean z4;
        int i3;
        int i4;
        String str;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-1505073056);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(z)) {
                i10 = 4;
            } else {
                i10 = 2;
            }
            i2 = i10 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(z2)) {
                i9 = 32;
            } else {
                i9 = 16;
            }
            i2 |= i9;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(z3)) {
                i8 = 256;
            } else {
                i8 = 128;
            }
            i2 |= i8;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changed(f)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i2 |= i7;
        }
        if ((i & 24576) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i2 |= i6;
        }
        if ((196608 & i) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                i5 = 131072;
            } else {
                i5 = 65536;
            }
            i2 |= i5;
        }
        if ((74899 & i2) != 74898) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (startRestartGroup.shouldExecute(z4, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1505073056, i2, -1, "com.dragon.read.kmp.widget.BookshelfTopBar.getLeftAndRightBtn (BookshelfTopBar.kt:113)");
            }
            Modifier modifier = Modifier.Companion;
            Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.h(SizeKt.i(modifier, x0.i.g(48)), 0.0f, 1, (Object) null), f, 0.0f, 2, (Object) null);
            androidx.compose.ui.layout.p0 b = r2.b(androidx.compose.foundation.layout.e.a.f(), androidx.compose.ui.e.a.i(), startRestartGroup, 54);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, t);
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
            if (z) {
                startRestartGroup.startReplaceGroup(-1616822549);
                if (z2) {
                    str = "取消全选";
                } else {
                    str = "全选";
                }
                i4 = 0;
                i3 = i2;
                a6.j(str, a.r(modifier, function0, startRestartGroup, ((i2 >> 9) & 112) | 390), og4.a.a.h(startRestartGroup, og4.a.b).k(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 3072, 0, 131056);
                startRestartGroup.endReplaceGroup();
            } else {
                i3 = i2;
                i4 = 0;
                startRestartGroup.startReplaceGroup(-1616540077);
                float f2 = 24;
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(w53.p.g(w53.r.a), startRestartGroup, 0), "返回", a.r(SizeKt.u(modifier, x0.i.g(f2), x0.i.g(f2)), function0, startRestartGroup, ((i3 >> 9) & 112) | 390), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(og4.a.a.h(startRestartGroup, og4.a.b).k()), 0, startRestartGroup, 48, 184);
                startRestartGroup.endReplaceGroup();
            }
            if (z) {
                startRestartGroup.startReplaceGroup(-1616105116);
                a6.j("完成", a.r(modifier, function02, startRestartGroup, ((i3 >> 12) & 112) | 390), og4.a.a.h(startRestartGroup, og4.a.b).k(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 3078, 0, 131056);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1615843476);
                if (!z3) {
                    float f3 = 24;
                    androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(w53.p.h(w53.r.a), startRestartGroup, i4), "more", a.r(SizeKt.u(modifier, x0.i.g(f3), x0.i.g(f3)), function02, startRestartGroup, ((i3 >> 12) & 112) | 390), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(og4.a.a.h(startRestartGroup, og4.a.b).k()), 0, startRestartGroup, 48, 184);
                }
                startRestartGroup.endReplaceGroup();
            }
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.widget.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit q;
                    q = q.q(q.this, z, z2, z3, f, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                    return q;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(final androidx.compose.runtime.State<gk4.l> r22, final androidx.compose.runtime.State<gk4.m> r23, final androidx.compose.runtime.State<java.lang.String> r24, boolean r25, boolean r26, final kotlin.jvm.functions.Function0<kotlin.Unit> r27, final kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.q.j(androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.runtime.State, boolean, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(final androidx.compose.runtime.State<gk4.l> r28, final androidx.compose.runtime.State<gk4.m> r29, final androidx.compose.runtime.State<java.lang.String> r30, boolean r31, boolean r32, float r33, final kotlin.jvm.functions.Function0<kotlin.Unit> r34, final kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.q.l(androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.runtime.State, boolean, boolean, float, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
