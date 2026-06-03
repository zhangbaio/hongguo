package com.dragon.read.leftslidepage;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.y2;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.VideoContentType;
import com.dragon.read.component.biz.impl.bookmall.l5;
import com.dragon.read.component.biz.impl.bookmall.m5;
import com.dragon.read.component.biz.impl.bookmall.r4;
import com.dragon.read.component.biz.impl.bookmall.s5;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.utils.StringUtilsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import w0.s;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s0 {
    static {
        Covode.recordClassIndex(611274);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(int i, p pVar, int i2, int i3, Composer composer, int i4) {
        z(i, pVar, i2, composer, x2.a(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(int i, r rVar, String str, int i2, int i3, Composer composer, int i4) {
        D(i, rVar, str, i2, composer, x2.a(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(int i, k kVar, String str, int i2, int i3, Composer composer, int i4) {
        H(i, kVar, str, i2, composer, x2.a(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(int i, t tVar, int i2, Composer composer, int i3) {
        K(i, tVar, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(int i, k kVar, String str, int i2, int i3, Composer composer, int i4) {
        N(i, kVar, str, i2, composer, x2.a(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(int i, Composer composer, int i2) {
        Q(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(String str, String str2, String str3, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        u(str, str2, str3, z, function0, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x026d, code lost:
    
        if (r3 == r17.getEmpty()) goto L60;
     */
    /* JADX WARN: Type inference failed for: r2v30, types: [T, androidx.compose.runtime.MutableState] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Q(androidx.compose.runtime.Composer r45, final int r46) {
        /*
            Method dump skipped, instructions count: 1291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.s0.Q(androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(MutableState mutableState, e2 e2Var, String str) {
        if (!((v) mutableState.getValue()).a) {
            e2.m1(e2Var, true, str, 0, null, 8, null);
            e2Var.a1();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(MutableState mutableState, int i, androidx.compose.ui.layout.w coordinates) {
        boolean z;
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            return Unit.INSTANCE;
        }
        long g = androidx.compose.ui.layout.x.g(coordinates);
        long a = coordinates.a();
        int i2 = (int) (g & 4294967295L);
        if (Float.intBitsToFloat(i2) < i && Float.intBitsToFloat(i2) + ((int) (a & 4294967295L)) > 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            mutableState.setValue(Boolean.TRUE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(e2 e2Var, p pVar, int i, int i2) {
        e2Var.l1(true, pVar.b, i, pVar.e);
        e2Var.Y0(i2, pVar);
        return Unit.INSTANCE;
    }

    public static final void K(final int i, final t msg, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        int i4;
        Intrinsics.checkNotNullParameter(msg, "msg");
        Composer startRestartGroup = composer.startRestartGroup(1846090573);
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(msg)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i3 = i4 | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 17) != 16) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1846090573, i3, -1, "com.dragon.read.leftslidepage.MsgItem (VideoFeedTabLeftSlideItem.kt:204)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(24)), x0.i.g(12), 0.0f, 2, (Object) null);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.leftslidepage.b0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit L;
                            L = s0.L((androidx.compose.ui.layout.w) obj);
                            return L;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a = androidx.compose.ui.layout.d1.a(t, (Function1) rememberedValue);
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.i(), startRestartGroup, 48);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, a);
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
                float f = 16;
                LoadImageKt.g(msg.b, (String) null, (com.dragon.read.kmp.compose.common.image.n) null, SizeKt.s(aVar, x0.i.g(f)), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 3072, 118);
                a3.a(SizeKt.x(aVar, x0.i.g(8)), startRestartGroup, 6);
                Modifier B = SizeKt.B(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), aVar2.i(), false, 2, (Object) null);
                String str = msg.a;
                long h = x0.x.h(14);
                int b4 = w0.s.b.b();
                og4.a aVar3 = og4.a.a;
                int i5 = og4.a.b;
                a6.j(str, B, aVar3.h(startRestartGroup, i5).C(), h, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b4, false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 3072, 3120, 120816);
                Modifier B2 = SizeKt.B(androidx.compose.foundation.layout.f2.v(aVar, x0.i.g(f), 0.0f, 0.0f, 0.0f, 14, (Object) null), aVar2.i(), false, 2, (Object) null);
                composer2 = startRestartGroup;
                a6.j(msg.c, B2, aVar3.h(composer2, i5).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer2, 199728, 3072, 122832);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit M;
                    M = s0.M(i, msg, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return M;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(e2 e2Var, String str, int i, r rVar, int i2) {
        e2.m1(e2Var, true, str, i, null, 8, null);
        e2Var.j1(true, str, rVar);
        e2Var.Z0(i2, rVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(e2 e2Var, String str, int i, int i2, k kVar) {
        e2.m1(e2Var, true, str, i, null, 8, null);
        e2Var.o1(true, i2 + 1, kVar, str);
        e2Var.d1(kVar, str, i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(e2 e2Var, String str, int i, int i2, k kVar) {
        e2.m1(e2Var, true, str, i, null, 8, null);
        e2Var.o1(true, i2 + 1, kVar, str);
        e2Var.d1(kVar, str, i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(MutableState mutableState, Ref$ObjectRef ref$ObjectRef, MutableState mutableState2, String str, y2 it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        if (!((v) mutableState.getValue()).a && !((Boolean) ((MutableState) ref$ObjectRef.element).getValue()).booleanValue()) {
            ((MutableState) ref$ObjectRef.element).setValue(Boolean.TRUE);
            if (it2.h()) {
                mutableState2.setValue(str);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x038a, code lost:
    
        if (r9 != false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x036d, code lost:
    
        if (r9 == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x038c, code lost:
    
        r4 = r11;
        r39 = r7;
        r33 = r15;
        r40 = r10;
        androidx.compose.material.a6.j(r42.e, androidx.compose.foundation.layout.SizeKt.B(androidx.compose.foundation.layout.SizeKt.F(r10, (androidx.compose.ui.e.b) null, false, 3, (java.lang.Object) null), r31.i(), false, 2, (java.lang.Object) null), r4.h(r15, r7).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0, (w0.i) null, (w0.h) null, 0, r30.b(), false, 1, 0, (kotlin.jvm.functions.Function1) null, (androidx.compose.ui.text.g3) null, r33, 3120, 3120, 120816);
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0433  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void z(final int r41, final com.dragon.read.leftslidepage.p r42, final int r43, androidx.compose.runtime.Composer r44, final int r45) {
        /*
            Method dump skipped, instructions count: 1111
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.s0.z(int, com.dragon.read.leftslidepage.p, int, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [boolean, int] */
    public static final void D(final int i, final r game, final String areaTitle, final int i2, Composer composer, final int i3) {
        int i4;
        boolean z;
        CreationExtras creationExtras;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ?? r12;
        Composer composer2;
        org.jetbrains.compose.resources.b n;
        int i5;
        String c;
        int i6;
        int i7;
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(game, "game");
        Intrinsics.checkNotNullParameter(areaTitle, "areaTitle");
        Composer startRestartGroup = composer.startRestartGroup(2126149171);
        if ((i3 & 6) == 0) {
            if (startRestartGroup.changed(i)) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i4 = i9 | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            if (startRestartGroup.changed(game)) {
                i8 = 32;
            } else {
                i8 = 16;
            }
            i4 |= i8;
        }
        if ((i3 & 384) == 0) {
            if (startRestartGroup.changed(areaTitle)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i4 |= i7;
        }
        if ((i3 & 3072) == 0) {
            if (startRestartGroup.changed(i2)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i4 |= i6;
        }
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2126149171, i4, -1, "com.dragon.read.leftslidepage.GameItem (VideoFeedTabLeftSlideItem.kt:362)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final e2 e2Var = (e2) f2.d.c(Reflection.getOrCreateKotlinClass(e2.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                e2Var.j1(false, areaTitle, game);
                Modifier.a aVar = Modifier.Companion;
                Modifier i10 = SizeKt.i(SizeKt.x(aVar, x0.i.g(58)), x0.i.g(71));
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.leftslidepage.m0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit E;
                            E = s0.E((androidx.compose.ui.layout.w) obj);
                            return E;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a = androidx.compose.ui.layout.d1.a(i10, (Function1) rememberedValue);
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changedInstance = startRestartGroup.changedInstance(e2Var);
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z6 = changedInstance | z2;
                if ((i4 & 7168) == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z7 = z6 | z3;
                if ((i4 & 112) == 32) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z8 = z7 | z4;
                if ((i4 & 14) == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean z9 = z8 | z5;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z9 && rememberedValue2 != companion.getEmpty()) {
                    composer2 = startRestartGroup;
                    r12 = 0;
                } else {
                    r12 = 0;
                    composer2 = startRestartGroup;
                    Function0 function0 = new Function0() { // from class: com.dragon.read.leftslidepage.n0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit F;
                            F = s0.F(e2.this, areaTitle, i2, game, i);
                            return F;
                        }
                    };
                    composer2.updateRememberedValue(function0);
                    rememberedValue2 = function0;
                }
                composer2.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(a, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), aVar2.g(), composer2, 48);
                int a3 = j.a(androidx.compose.runtime.i.b(composer2, (int) r12));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer2, modifier);
                ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                Function0 a4 = companion2.a();
                if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(a4);
                } else {
                    composer2.useNode();
                }
                Composer b = g5.b(composer2);
                g5.e(b, a2, companion2.c());
                g5.e(b, currentCompositionLocalMap, companion2.e());
                Function2 b2 = companion2.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                    b.updateRememberedValue(Integer.valueOf(a3));
                    b.apply(Integer.valueOf(a3), b2);
                }
                g5.e(b, e, companion2.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                if (com.dragon.read.kmp.service.d1.d((Theme) composer2.consume(rg4.e.l()))) {
                    n = r4.m(l5.a);
                } else {
                    n = r4.n(l5.a);
                }
                float f = 48;
                Modifier s = SizeKt.s(aVar, x0.i.g(f));
                androidx.compose.ui.layout.p0 i11 = androidx.compose.foundation.layout.m.i(aVar2.o(), (boolean) r12);
                int a5 = j.a(androidx.compose.runtime.i.b(composer2, (int) r12));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer2, s);
                Function0 a6 = companion2.a();
                if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(a6);
                } else {
                    composer2.useNode();
                }
                Composer b3 = g5.b(composer2);
                g5.e(b3, i11, companion2.c());
                g5.e(b3, currentCompositionLocalMap2, companion2.e());
                Function2 b4 = companion2.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                    b3.updateRememberedValue(Integer.valueOf(a5));
                    b3.apply(Integer.valueOf(a5), b4);
                }
                g5.e(b3, e2, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                String str = game.c;
                Modifier a7 = androidx.compose.ui.draw.e.a(SizeKt.s(aVar, x0.i.g(f)), k.g.c(pg4.j.c(10, composer2, 6)));
                com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                nVar.e = n;
                Composer composer3 = composer2;
                LoadImageKt.g(str, (String) null, nVar, a7, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, composer3, 0, 114);
                composer3.startReplaceGroup(-336349576);
                if (!game.e && !game.f) {
                    startRestartGroup = composer3;
                    i5 = 0;
                } else {
                    Modifier b5 = boxScopeInstance.b(aVar, aVar2.o());
                    og4.a aVar3 = og4.a.a;
                    int i12 = og4.a.b;
                    Modifier s2 = androidx.compose.foundation.layout.f2.s(BackgroundKt.c(b5, aVar3.h(composer3, i12).m2(), k.g.e(pg4.j.c(10, composer3, 6), 0.0f, pg4.j.c(8, composer3, 6), 0.0f, 10, (Object) null)), x0.i.g(4), x0.i.g(2));
                    i5 = 0;
                    androidx.compose.ui.layout.p0 i13 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                    int a8 = j.a(androidx.compose.runtime.i.b(composer3, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                    Modifier e3 = ComposedModifierKt.e(composer3, s2);
                    Function0 a9 = companion2.a();
                    if (!(composer3.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(a9);
                    } else {
                        composer3.useNode();
                    }
                    Composer b6 = g5.b(composer3);
                    g5.e(b6, i13, companion2.c());
                    g5.e(b6, currentCompositionLocalMap3, companion2.e());
                    Function2 b7 = companion2.b();
                    if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a8))) {
                        b6.updateRememberedValue(Integer.valueOf(a8));
                        b6.apply(Integer.valueOf(a8), b7);
                    }
                    g5.e(b6, e3, companion2.d());
                    if (game.e) {
                        composer3.startReplaceGroup(-1252864171);
                        c = org.jetbrains.compose.resources.j.c(s5.d(m5.a), composer3, 0);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-1252771822);
                        c = org.jetbrains.compose.resources.j.c(s5.e(m5.a), composer3, 0);
                        composer3.endReplaceGroup();
                    }
                    startRestartGroup = composer3;
                    a6.j(c, (Modifier) null, aVar3.h(composer3, i12).R(), x0.x.h(9), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 0, 131026);
                    startRestartGroup.endNode();
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                a3.a(androidx.compose.foundation.layout.a0.a(c0Var, aVar, 1.0f, false, 2, (Object) null), startRestartGroup, i5);
                a6.j(game.b, SizeKt.h(aVar, 0.0f, 1, (Object) null), og4.a.a.h(startRestartGroup, og4.a.b).C(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199728, 3120, 120272);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit G;
                    G = s0.G(i, game, areaTitle, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return G;
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v38 */
    public static final void H(final int i, final k data, final String areaTitle, final int i2, Composer composer, final int i3) {
        int i4;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        boolean z2;
        boolean z3;
        boolean z4;
        ?? r10;
        Composer composer3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(areaTitle, "areaTitle");
        Composer startRestartGroup = composer.startRestartGroup(-914265343);
        if ((i3 & 6) == 0) {
            if (startRestartGroup.changed(i)) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i4 = i9 | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            if (startRestartGroup.changed(data)) {
                i8 = 32;
            } else {
                i8 = 16;
            }
            i4 |= i8;
        }
        if ((i3 & 384) == 0) {
            if (startRestartGroup.changed(areaTitle)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i4 |= i7;
        }
        if ((i3 & 3072) == 0) {
            if (startRestartGroup.changed(i2)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i4 |= i6;
        }
        boolean z5 = true;
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-914265343, i4, -1, "com.dragon.read.leftslidepage.GridRecentWatchItem (VideoFeedTabLeftSlideItem.kt:238)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final e2 e2Var = (e2) f2.d.c(Reflection.getOrCreateKotlinClass(e2.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                e2Var.o1(false, i + 1, data, areaTitle);
                Modifier.a aVar = Modifier.Companion;
                Modifier B = SizeKt.B(SizeKt.F(aVar, (e.b) null, false, 3, (Object) null), (e.c) null, false, 3, (Object) null);
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changedInstance = startRestartGroup.changedInstance(e2Var);
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z6 = z2 | changedInstance;
                if ((i4 & 7168) == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z7 = z3 | z6;
                if ((i4 & 14) == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z8 = z7 | z4;
                if ((i4 & 112) != 32) {
                    z5 = false;
                }
                boolean z9 = z8 | z5;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (!z9 && rememberedValue != Composer.Companion.getEmpty()) {
                    composer3 = startRestartGroup;
                    r10 = 0;
                } else {
                    r10 = 0;
                    composer3 = startRestartGroup;
                    Function0 function0 = new Function0() { // from class: com.dragon.read.leftslidepage.h0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit I;
                            I = s0.I(e2.this, areaTitle, i2, i, data);
                            return I;
                        }
                    };
                    composer3.updateRememberedValue(function0);
                    rememberedValue = function0;
                }
                composer3.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(B, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                e.m i10 = androidx.compose.foundation.layout.e.a.i();
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(i10, aVar2.k(), composer3, (int) r10);
                int a2 = j.a(androidx.compose.runtime.i.b(composer3, (int) r10));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer3, modifier);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a3 = companion.a();
                if (!(composer3.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(a3);
                } else {
                    composer3.useNode();
                }
                Composer b = g5.b(composer3);
                g5.e(b, a, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                float f = 72;
                float f2 = 102;
                Modifier i11 = SizeKt.i(SizeKt.x(aVar, x0.i.g(f)), x0.i.g(f2));
                androidx.compose.ui.layout.p0 i12 = androidx.compose.foundation.layout.m.i(aVar2.o(), (boolean) r10);
                int a4 = j.a(androidx.compose.runtime.i.b(composer3, (int) r10));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer3, i11);
                Function0 a5 = companion.a();
                if (!(composer3.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(a5);
                } else {
                    composer3.useNode();
                }
                Composer b3 = g5.b(composer3);
                g5.e(b3, i12, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                    b3.updateRememberedValue(Integer.valueOf(a4));
                    b3.apply(Integer.valueOf(a4), b4);
                }
                g5.e(b3, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier a6 = androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.x(aVar, x0.i.g(f)), x0.i.g(f2)), k.g.c(pg4.j.c(8, composer3, 6)));
                composer2 = composer3;
                LoadImageKt.g(data.h, (String) null, (com.dragon.read.kmp.compose.common.image.n) null, a6, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, composer2, 0, 118);
                composer2.startReplaceGroup(-160848946);
                if (data.l == VideoContentType.Album.getValue()) {
                    Modifier r = androidx.compose.foundation.layout.f2.r(boxScopeInstance.b(aVar, aVar2.o()), x0.i.g(4));
                    androidx.compose.ui.layout.p0 i13 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                    int a7 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier e3 = ComposedModifierKt.e(composer2, r);
                    Function0 a8 = companion.a();
                    if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(a8);
                    } else {
                        composer2.useNode();
                    }
                    Composer b5 = g5.b(composer2);
                    g5.e(b5, i13, companion.c());
                    g5.e(b5, currentCompositionLocalMap3, companion.e());
                    Function2 b6 = companion.b();
                    if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a7))) {
                        b5.updateRememberedValue(Integer.valueOf(a7));
                        b5.apply(Integer.valueOf(a7), b6);
                    }
                    g5.e(b5, e3, companion.d());
                    String c2 = org.jetbrains.compose.resources.j.c(s5.i(m5.a), composer2, 0);
                    i5 = 6;
                    Modifier u = SizeKt.u(aVar, pg4.j.c(26, composer2, 6), pg4.j.c(16, composer2, 6));
                    og4.a aVar3 = og4.a.a;
                    int i14 = og4.a.b;
                    a6.j(c2, SizeKt.D(BackgroundKt.c(u, aVar3.h(composer2, i14).m2(), k.g.c(pg4.j.c(4, composer2, 6))), aVar2.e(), false, 2, (Object) null), aVar3.h(composer2, i14).R(), x0.x.h(9), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131024);
                    composer2.endNode();
                } else {
                    i5 = 6;
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                a3.a(SizeKt.i(SizeKt.x(aVar, x0.i.g(f)), x0.i.g(8)), composer2, i5);
                Modifier x = SizeKt.x(SizeKt.B(aVar, (e.c) null, false, 3, (Object) null), x0.i.g(f));
                String str = data.i;
                s.a aVar4 = w0.s.b;
                int b7 = aVar4.b();
                c0.a aVar5 = androidx.compose.ui.text.font.c0.b;
                androidx.compose.ui.text.font.c0 h = aVar5.h();
                long h2 = x0.x.h(12);
                og4.a aVar6 = og4.a.a;
                int i15 = og4.a.b;
                a6.j(str, x, aVar6.h(composer2, i15).C(), h2, (androidx.compose.ui.text.font.y) null, h, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b7, false, 1, 0, (Function1) null, (g3) null, composer2, 199728, 3120, 120784);
                a3.a(SizeKt.i(aVar, x0.i.g(4)), composer2, i5);
                Modifier x2 = SizeKt.x(SizeKt.B(aVar, (e.c) null, false, 3, (Object) null), x0.i.g(f));
                String str2 = data.j;
                int b8 = aVar4.b();
                a6.j(str2, x2, aVar6.h(composer2, i15).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, aVar5.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b8, false, 1, 0, (Function1) null, (g3) null, composer2, 199728, 3120, 120784);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit J;
                    J = s0.J(i, data, areaTitle, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return J;
                }
            });
        }
    }

    public static final void N(final int i, final k data, final String areaTitle, final int i2, Composer composer, final int i3) {
        int i4;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i5;
        int i6;
        Composer composer3;
        boolean z6;
        String c;
        int i7;
        int i8;
        int i9;
        int i10;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(areaTitle, "areaTitle");
        Composer startRestartGroup = composer.startRestartGroup(-1092558565);
        if ((i3 & 6) == 0) {
            if (startRestartGroup.changed(i)) {
                i10 = 4;
            } else {
                i10 = 2;
            }
            i4 = i10 | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            if (startRestartGroup.changed(data)) {
                i9 = 32;
            } else {
                i9 = 16;
            }
            i4 |= i9;
        }
        if ((i3 & 384) == 0) {
            if (startRestartGroup.changed(areaTitle)) {
                i8 = 256;
            } else {
                i8 = 128;
            }
            i4 |= i8;
        }
        if ((i3 & 3072) == 0) {
            if (startRestartGroup.changed(i2)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i4 |= i7;
        }
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1092558565, i4, -1, "com.dragon.read.leftslidepage.RecentWatchItem (VideoFeedTabLeftSlideItem.kt:297)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final e2 e2Var = (e2) f2.d.c(Reflection.getOrCreateKotlinClass(e2.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                e2Var.o1(false, i + 1, data, areaTitle);
                Modifier.a aVar = Modifier.Companion;
                Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), pg4.j.c(50, startRestartGroup, 6)), x0.i.g(12), 0.0f, 2, (Object) null);
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changedInstance = startRestartGroup.changedInstance(e2Var);
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z7 = changedInstance | z2;
                if ((i4 & 7168) == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z8 = z7 | z3;
                if ((i4 & 14) == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z9 = z8 | z4;
                if ((i4 & 112) == 32) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean z10 = z9 | z5;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (!z10 && rememberedValue != Composer.Companion.getEmpty()) {
                    composer3 = startRestartGroup;
                    i5 = 6;
                    i6 = 0;
                } else {
                    i5 = 6;
                    i6 = 0;
                    composer3 = startRestartGroup;
                    Function0 function0 = new Function0() { // from class: com.dragon.read.leftslidepage.z
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit O;
                            O = s0.O(e2.this, areaTitle, i2, i, data);
                            return O;
                        }
                    };
                    composer3.updateRememberedValue(function0);
                    rememberedValue = function0;
                }
                composer3.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(t, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                e.c i11 = aVar2.i();
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                androidx.compose.ui.layout.p0 b = r2.b(eVar.h(), i11, composer3, 48);
                int a = j.a(androidx.compose.runtime.i.b(composer3, i6));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer3, modifier);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a2 = companion.a();
                if (!(composer3.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(a2);
                } else {
                    composer3.useNode();
                }
                Composer b2 = g5.b(composer3);
                g5.e(b2, b, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                    b2.updateRememberedValue(Integer.valueOf(a));
                    b2.apply(Integer.valueOf(a), b3);
                }
                g5.e(b2, e, companion.d());
                w2 w2Var = w2.b;
                Composer composer4 = composer3;
                LoadImageKt.g(data.h, (String) null, (com.dragon.read.kmp.compose.common.image.n) null, androidx.compose.ui.draw.e.a(SizeKt.d(SizeKt.x(aVar, pg4.j.c(36, composer3, i5)), 0.0f, 1, (Object) null), k.g.c(pg4.j.c(i5, composer3, i5))), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, composer4, 0, 118);
                float f = 8;
                a3.a(SizeKt.x(aVar, x0.i.g(f)), composer4, 6);
                Modifier a3 = u2.a(w2Var, SizeKt.B(aVar, (e.c) null, false, 3, (Object) null), 1.0f, false, 2, (Object) null);
                androidx.compose.ui.layout.p0 a4 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar2.k(), composer4, 0);
                int a5 = j.a(androidx.compose.runtime.i.b(composer4, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer4, a3);
                Function0 a6 = companion.a();
                if (!(composer4.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(a6);
                } else {
                    composer4.useNode();
                }
                Composer b4 = g5.b(composer4);
                g5.e(b4, a4, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                    b4.updateRememberedValue(Integer.valueOf(a5));
                    b4.apply(Integer.valueOf(a5), b5);
                }
                g5.e(b4, e2, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                Modifier h = SizeKt.h(SizeKt.B(aVar, (e.c) null, false, 3, (Object) null), 0.0f, 1, (Object) null);
                String str = data.i;
                s.a aVar3 = w0.s.b;
                int b6 = aVar3.b();
                c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
                androidx.compose.ui.text.font.c0 h2 = aVar4.h();
                long h3 = x0.x.h(14);
                og4.a aVar5 = og4.a.a;
                int i12 = og4.a.b;
                a6.j(str, h, aVar5.h(composer4, i12).C(), h3, (androidx.compose.ui.text.font.y) null, h2, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b6, false, 1, 0, (Function1) null, (g3) null, composer4, 199728, 3120, 120784);
                a3.a(SizeKt.i(aVar, x0.i.g(4)), composer4, 6);
                Modifier h4 = SizeKt.h(SizeKt.B(aVar, (e.c) null, false, 3, (Object) null), 0.0f, 1, (Object) null);
                String str2 = data.j;
                int b7 = aVar3.b();
                a6.j(str2, h4, aVar5.h(composer4, i12).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, aVar4.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b7, false, 1, 0, (Function1) null, (g3) null, composer4, 199728, 3120, 120784);
                composer4.endNode();
                a3.a(SizeKt.x(aVar, x0.i.g(f)), composer4, 6);
                Modifier c3 = BackgroundKt.c(SizeKt.i(SizeKt.x(aVar, pg4.j.c(52, composer4, 6)), pg4.j.c(24, composer4, 6)), aVar5.h(composer4, i12).o(), k.g.c(x0.i.g(6)));
                androidx.compose.ui.layout.p0 i13 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a7 = j.a(androidx.compose.runtime.i.b(composer4, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer4, c3);
                Function0 a8 = companion.a();
                if (!(composer4.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(a8);
                } else {
                    composer4.useNode();
                }
                Composer b8 = g5.b(composer4);
                g5.e(b8, i13, companion.c());
                g5.e(b8, currentCompositionLocalMap3, companion.e());
                Function2 b9 = companion.b();
                if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a7))) {
                    b8.updateRememberedValue(Integer.valueOf(a7));
                    b8.apply(Integer.valueOf(a7), b9);
                }
                g5.e(b8, e3, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                composer4.startReplaceGroup(205287719);
                if (StringUtilsKt.a(data.k)) {
                    c = data.k;
                    z6 = false;
                } else {
                    z6 = false;
                    c = org.jetbrains.compose.resources.j.c(s5.s(m5.a), composer4, 0);
                }
                composer4.endReplaceGroup();
                Modifier b10 = boxScopeInstance.b(SizeKt.D(aVar, (androidx.compose.ui.e) null, z6, 3, (Object) null), aVar2.e());
                int b11 = aVar3.b();
                composer2 = composer4;
                a6.j(c, b10, aVar5.h(composer4, i12).J(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, aVar4.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b11, false, 1, 0, (Function1) null, (g3) null, composer2, 199680, 3120, 120784);
                composer2.endNode();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit P;
                    P = s0.P(i, data, areaTitle, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return P;
                }
            });
        }
    }

    public static final void u(final String title, final String moreText, String str, final boolean z, final Function0<Unit> onClick, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        Composer composer2;
        final String str2;
        String str3;
        boolean z3;
        boolean z4;
        final Function0<Unit> function0;
        boolean z5;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(moreText, "moreText");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1493040162);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            if (startRestartGroup.changed(title)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changed(moreText)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (startRestartGroup.changed(z)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            if (startRestartGroup.changedInstance(onClick)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i3 |= i7;
        }
        int i8 = i3;
        if ((i8 & 9235) != 9234) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i8 & 1)) {
            if ((i2 & 4) != 0) {
                str3 = "";
            } else {
                str3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1493040162, i8, -1, "com.dragon.read.leftslidepage.CommonTitle (VideoFeedTabLeftSlideItem.kt:164)");
            }
            Modifier.a aVar = Modifier.Companion;
            float f = 12;
            Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.B(SizeKt.h(aVar, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), x0.i.g(f), 0.0f, 2, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.i(), startRestartGroup, 48);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, t);
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
            Modifier B = SizeKt.B(u2.a(w2.b, aVar, 1.0f, false, 2, (Object) null), aVar2.i(), false, 2, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            int i9 = i8 & 57344;
            if (i9 == 16384) {
                z3 = true;
            } else {
                z3 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.leftslidepage.d0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit v;
                        v = s0.v(Function0.this);
                        return v;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(B, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            s.a aVar3 = w0.s.b;
            int b4 = aVar3.b();
            androidx.compose.ui.text.font.c0 i10 = androidx.compose.ui.text.font.c0.b.i();
            long h = x0.x.h(14);
            og4.a aVar4 = og4.a.a;
            int i11 = og4.a.b;
            a6.j(title, modifier, aVar4.h(startRestartGroup, i11).J(), h, (androidx.compose.ui.text.font.y) null, i10, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b4, false, 1, 0, (Function1) null, (g3) null, startRestartGroup, (i8 & 14) | 199680, 3120, 120784);
            Modifier B2 = SizeKt.B(SizeKt.F(aVar, (e.b) null, false, 3, (Object) null), aVar2.i(), false, 2, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            if (i9 == 16384) {
                z4 = true;
            } else {
                z4 = false;
            }
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z4 && rememberedValue2 != Composer.Companion.getEmpty()) {
                function0 = onClick;
            } else {
                function0 = onClick;
                rememberedValue2 = new Function0() { // from class: com.dragon.read.leftslidepage.e0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit w;
                        w = s0.w(Function0.this);
                        return w;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            a6.j(moreText, ClickableKt.clickable-oSLSa3U$default(B2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), aVar4.h(startRestartGroup, i11).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar3.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, ((i8 >> 3) & 14) | 3072, 3120, 120816);
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(-1632457018);
            if (z) {
                androidx.compose.ui.graphics.e1 a3 = com.dragon.read.kmp.compose.common.image.e.a(yo2.d2.F(f2.a.a), composer2, 0);
                Modifier s = SizeKt.s(aVar, x0.i.g(f));
                composer2.startReplaceGroup(5004770);
                if (i9 == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Object rememberedValue3 = composer2.rememberedValue();
                if (z5 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.dragon.read.leftslidepage.f0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit x;
                            x = s0.x(Function0.this);
                            return x;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                composer2.endReplaceGroup();
                androidx.compose.foundation.z0.g(a3, "global_next", ClickableKt.clickable-oSLSa3U$default(s, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, aVar4.h(composer2, i11).d(), 0, 2, (Object) null), 0, composer2, 48, 184);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str2 = str3;
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
            str2 = str;
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit y;
                    y = s0.y(title, moreText, str2, z, onClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return y;
                }
            });
        }
    }
}
