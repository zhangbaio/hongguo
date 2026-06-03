package com.dragon.read.kmp.reader.font;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.u1;
import androidx.compose.foundation.layout.v2;
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
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    static {
        Covode.recordClassIndex(608430);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(androidx.compose.foundation.layout.r rVar, DownloadStatus downloadStatus, int i, boolean z, boolean z2, boolean z3, boolean z4, Function0 function0, int i2, int i3, Composer composer, int i4) {
        h(rVar, downloadStatus, i, z, z2, z3, z4, function0, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(a0 a0Var, w0 w0Var, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        j(a0Var, w0Var, function0, function02, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(androidx.compose.foundation.layout.r rVar, String str, String str2, int i, int i2, int i3, boolean z, boolean z2, boolean z3, Modifier modifier, int i4, int i5, Composer composer, int i6) {
        n(rVar, str, str2, i, i2, i3, z, z2, z3, modifier, composer, x2.a(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(androidx.compose.foundation.layout.r rVar, int i, Composer composer, int i2) {
        p(rVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(androidx.compose.foundation.layout.r rVar, String str, String str2, DownloadStatus downloadStatus, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Composer composer, int i3) {
        r(rVar, str, str2, downloadStatus, z, z2, z3, z4, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function0 function0, androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
        final /* synthetic */ Ref$ObjectRef<String> a;
        final /* synthetic */ long b;

        a(Ref$ObjectRef<String> ref$ObjectRef, long j) {
            this.a = ref$ObjectRef;
            this.b = j;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
            a(rVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r RatioProgressBar, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            Intrinsics.checkNotNullParameter(RatioProgressBar, "$this$RatioProgressBar");
            if ((i & 6) == 0) {
                if (composer.changed(RatioProgressBar)) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
                i2 = i | i3;
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-827392991, i2, -1, "com.dragon.read.kmp.reader.font.FontButtonArea.<anonymous>.<anonymous> (FontItem.kt:346)");
                }
                a6.j(this.a.element, RatioProgressBar.b(Modifier.Companion, androidx.compose.ui.e.a.e()), this.b, x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 130544);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function3<v2, Composer, Integer, Unit> {
        final /* synthetic */ Ref$ObjectRef<String> a;
        final /* synthetic */ long b;

        b(Ref$ObjectRef<String> ref$ObjectRef, long j) {
            this.a = ref$ObjectRef;
            this.b = j;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(v2 v2Var, Composer composer, Integer num) {
            a(v2Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(v2 Button, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 6) == 0) {
                if (composer.changed(Button)) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
                i2 = i | i3;
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1218685783, i2, -1, "com.dragon.read.kmp.reader.font.FontButtonArea.<anonymous>.<anonymous> (FontItem.kt:367)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                Modifier b = Button.b(h, aVar2.i());
                Ref$ObjectRef<String> ref$ObjectRef = this.a;
                long j = this.b;
                androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, b);
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
                g5.e(b2, i4, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                    b2.updateRememberedValue(Integer.valueOf(a));
                    b2.apply(Integer.valueOf(a), b3);
                }
                g5.e(b2, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                a6.j(ref$ObjectRef.element, boxScopeInstance.b(aVar, aVar2.e()), j, x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 130544);
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

    public static final void p(final androidx.compose.foundation.layout.r rVar, Composer composer, final int i) {
        int i2;
        boolean z;
        List listOf;
        int i3;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Composer startRestartGroup = composer.startRestartGroup(1452280026);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
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
                ComposerKt.traceEventStart(1452280026, i2, -1, "com.dragon.read.kmp.reader.font.GradientArea (FontItem.kt:150)");
            }
            long p = ((zl4.b) startRestartGroup.consume(zl4.r.w())).p();
            long d = com.dragon.read.kmp.reader.ui.d0.d(p, 0.4f);
            long d2 = com.dragon.read.kmp.reader.ui.d0.d(p, 0.01f);
            float M0 = ((x0.e) startRestartGroup.consume(CompositionLocalsKt.f())).M0(x0.i.g(32));
            c0.a aVar = androidx.compose.ui.graphics.c0.b;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(d), androidx.compose.ui.graphics.l0.j(d2)});
            androidx.compose.ui.graphics.c0 k = c0.a.k(aVar, listOf, 0L, M0, 0, 10, (Object) null);
            Modifier.a aVar2 = Modifier.Companion;
            e.a aVar3 = androidx.compose.ui.e.a;
            float f = -36;
            Modifier e = u1.e(rVar.b(aVar2, aVar3.o()), x0.i.g(f), x0.i.g(f));
            float f2 = 72;
            androidx.compose.foundation.layout.m.b(BackgroundKt.b(SizeKt.s(e, x0.i.g(f2)), k, k.g.f(), 0.0f, 4, (Object) null), startRestartGroup, 0);
            Modifier b2 = rVar.b(aVar2, aVar3.c());
            float f3 = 36;
            androidx.compose.foundation.layout.m.b(BackgroundKt.b(SizeKt.s(u1.e(b2, x0.i.g(f3), x0.i.g(f3)), x0.i.g(f2)), k, k.g.f(), 0.0f, 4, (Object) null), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.font.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit q;
                    q = p.q(rVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return q;
                }
            });
        }
    }

    public static final void j(final a0 uiState, final w0 uiConfig, final Function0<Unit> onFontClick, final Function0<Unit> onGloballyPositioned, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        Intrinsics.checkNotNullParameter(onFontClick, "onFontClick");
        Intrinsics.checkNotNullParameter(onGloballyPositioned, "onGloballyPositioned");
        Composer startRestartGroup = composer.startRestartGroup(1689021324);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(uiState)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i2 = i6 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(uiConfig)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i2 |= i5;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(onFontClick)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i2 |= i4;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(onGloballyPositioned)) {
                i3 = 2048;
            } else {
                i3 = 1024;
            }
            i2 |= i3;
        }
        if ((i2 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1689021324, i2, -1, "com.dragon.read.kmp.reader.font.FontItem (FontItem.kt:86)");
            }
            long v = ((zl4.b) startRestartGroup.consume(zl4.r.w())).v((ReaderBgColorType) startRestartGroup.consume(zl4.r.u()));
            Modifier.a aVar = Modifier.Companion;
            float f = 5;
            float f2 = 6;
            Modifier a2 = androidx.compose.ui.draw.e.a(BackgroundKt.c(f2.v(SizeKt.B(SizeKt.h(aVar, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), x0.i.g(f), 0.0f, x0.i.g(f), x0.i.g(9), 2, (Object) null), v, k.g.c(x0.i.g(f2))), k.g.c(x0.i.g(f2)));
            startRestartGroup.startReplaceGroup(5004770);
            if ((i2 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.font.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit k;
                        k = p.k(Function0.this);
                        return k;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(a2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            if ((i2 & 7168) == 2048) {
                z3 = true;
            } else {
                z3 = false;
            }
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.reader.font.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit l;
                        l = p.l(Function0.this, (androidx.compose.ui.layout.w) obj);
                        return l;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier a3 = d1.a(modifier, (Function1) rememberedValue2);
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, a3);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a5 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a5);
            } else {
                startRestartGroup.useNode();
            }
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i7, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a4))) {
                b2.updateRememberedValue(Integer.valueOf(a4));
                b2.apply(Integer.valueOf(a4), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier i8 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(uiConfig.a));
            androidx.compose.ui.layout.p0 i9 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, i8);
            Function0 a7 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a7);
            } else {
                startRestartGroup.useNode();
            }
            Composer b4 = g5.b(startRestartGroup);
            g5.e(b4, i9, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a6))) {
                b4.updateRememberedValue(Integer.valueOf(a6));
                b4.apply(Integer.valueOf(a6), b5);
            }
            g5.e(b4, e2, companion.d());
            startRestartGroup.startReplaceGroup(-1765429986);
            if (uiState.e) {
                p(boxScopeInstance, startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            n(boxScopeInstance, uiState.a, uiState.b, uiConfig.b, uiConfig.c, uiConfig.d, uiState.d, uiState.e, false, boxScopeInstance.b(f2.v(aVar, x0.i.g(12), x0.i.g(17), 0.0f, 0.0f, 12, (Object) null), aVar2.o()), startRestartGroup, 6, 128);
            r(boxScopeInstance, uiState.a, uiState.c, uiState.f, uiState.d, uiState.e, false, false, startRestartGroup, 6, 96);
            composer2 = startRestartGroup;
            h(boxScopeInstance, uiState.f, uiState.g, uiState.d, uiState.e, false, false, onFontClick, startRestartGroup, 6 | ((i2 << 15) & 29360128), 48);
            composer2.endNode();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.font.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m;
                    m = p.m(a0.this, uiConfig, onFontClick, onGloballyPositioned, i, (Composer) obj, ((Integer) obj2).intValue());
                    return m;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0303  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void r(final androidx.compose.foundation.layout.r r37, final java.lang.String r38, final java.lang.String r39, final com.dragon.read.kmp.reader.font.DownloadStatus r40, final boolean r41, final boolean r42, boolean r43, boolean r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instructions count: 808
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.font.p.r(androidx.compose.foundation.layout.r, java.lang.String, java.lang.String, com.dragon.read.kmp.reader.font.DownloadStatus, boolean, boolean, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01fc  */
    /* JADX WARN: Type inference failed for: r6v11, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v13, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v21, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v23, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(final androidx.compose.foundation.layout.r r38, final com.dragon.read.kmp.reader.font.DownloadStatus r39, final int r40, final boolean r41, final boolean r42, boolean r43, boolean r44, final kotlin.jvm.functions.Function0<kotlin.Unit> r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.font.p.h(androidx.compose.foundation.layout.r, com.dragon.read.kmp.reader.font.DownloadStatus, int, boolean, boolean, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void n(final androidx.compose.foundation.layout.r r31, final java.lang.String r32, final java.lang.String r33, final int r34, int r35, int r36, final boolean r37, final boolean r38, boolean r39, androidx.compose.ui.Modifier r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 749
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.font.p.n(androidx.compose.foundation.layout.r, java.lang.String, java.lang.String, int, int, int, boolean, boolean, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
