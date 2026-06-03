package bm4;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.b1;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
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
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e0 {
    static {
        Covode.recordClassIndex(608281);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(com.dragon.read.kmp.reader.state.h hVar, long j, long j2, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        g(hVar, j, j2, function0, function02, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        j(function0, function02, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0189, code lost:
    
        if (r0 == true) goto L117;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List<com.dragon.read.kmp.reader.state.h> n(com.dragon.read.kmp.reader.state.a r18) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bm4.e0.n(com.dragon.read.kmp.reader.state.a):java.util.List");
    }

    private static final Modifier o(Modifier modifier, final Function0<Unit> function0) {
        return ClickableKt.clickable-O2vRcR0$default(modifier, androidx.compose.foundation.interaction.h.a(), (b1) null, false, (String) null, (Role) null, new Function0() { // from class: bm4.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit p;
                p = e0.p(Function0.this);
                return p;
            }
        }, 28, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(com.dragon.read.kmp.reader.state.h hVar, Function0 function0, Function0 function02) {
        dm4.h navigatorDepend;
        if (StringsKt__StringsJVMKt.startsWith$default(hVar.a, "作者", false, 2, null)) {
            function0.invoke();
        } else if (StringsKt__StringsJVMKt.startsWith$default(hVar.a, "版权方", false, 2, null)) {
            function02.invoke();
        }
        String str = hVar.d;
        if (str != null && (navigatorDepend = xf4.d.o3.a().navigatorDepend()) != null) {
            navigatorDepend.b(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(kotlin.jvm.functions.Function0<kotlin.Unit> r39, kotlin.jvm.functions.Function0<kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 757
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bm4.e0.j(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void g(final com.dragon.read.kmp.reader.state.h hVar, final long j, final long j2, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean changedInstance;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-290290646);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(hVar);
            } else {
                changedInstance = startRestartGroup.changedInstance(hVar);
            }
            if (changedInstance) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i2 = i7 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(j)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i2 |= i6;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(j2)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i2 |= i5;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i2 |= i4;
        }
        if ((i & 24576) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                i3 = 16384;
            } else {
                i3 = 8192;
            }
            i2 |= i3;
        }
        if ((i2 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290290646, i2, -1, "com.dragon.read.kmp.reader.bookcover.view.KmpCopyrightItemRow (KmpCopyrightSourceInfo.kt:96)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier v = f2.v(f2.t(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, x0.i.g(4), 1, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(20), 7, (Object) null);
            androidx.compose.ui.layout.p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.l(), startRestartGroup, 48);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
            g5.e(b2, b, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                b2.updateRememberedValue(Integer.valueOf(a));
                b2.apply(Integer.valueOf(a), b3);
            }
            g5.e(b2, e, companion.d());
            w2 w2Var = w2.b;
            int i8 = ((i2 << 3) & 896) | 3072;
            a6.j(hVar.a, f2.v(w2Var.c(aVar), 0.0f, 0.0f, x0.i.g(8), 0.0f, 11, (Object) null), j, x0.x.h(17), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, i8, 0, 131056);
            if (hVar.c) {
                startRestartGroup.startReplaceGroup(-1160230978);
                String str = hVar.b;
                long h = x0.x.h(17);
                Modifier a3 = w2Var.a(w2Var.c(aVar), 1.0f, false);
                startRestartGroup.startReplaceGroup(-1746271574);
                if ((i2 & 14) != 4 && ((i2 & 8) == 0 || !startRestartGroup.changedInstance(hVar))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if ((i2 & 7168) == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z5 = z3 | z2;
                if ((57344 & i2) == 16384) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z6 = z5 | z4;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: bm4.b0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit h2;
                            h2 = e0.h(com.dragon.read.kmp.reader.state.h.this, function0, function02);
                            return h2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                a6.j(str, o(a3, (Function0) rememberedValue), j2, h, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, (i2 & 896) | 3072, 0, 131056);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1159513328);
                a6.j(hVar.b, w2Var.a(w2Var.c(aVar), 1.0f, false), j, x0.x.h(17), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, i8, 0, 131056);
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
            endRestartGroup.a(new Function2() { // from class: bm4.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i9;
                    i9 = e0.i(com.dragon.read.kmp.reader.state.h.this, j, j2, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                    return i9;
                }
            });
        }
    }
}
