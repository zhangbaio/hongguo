package com.dragon.read.kmp.reader.font;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.u1;
import androidx.compose.material.a6;
import androidx.compose.material.h1;
import androidx.compose.material.n2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import com.dragon.read.reader.f1;
import com.dragon.read.reader.m3;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import w0.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FontItemMultiTypeKt {
    static {
        Covode.recordClassIndex(608431);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function0 function0, n2 n2Var, int i, Composer composer, int i2) {
        i(function0, n2Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(a0 a0Var, w0 w0Var, n2 n2Var, Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        m(a0Var, w0Var, n2Var, function0, function02, function03, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(androidx.compose.foundation.layout.r rVar, DownloadStatus downloadStatus, int i, float f, int i2, Composer composer, int i3) {
        p(rVar, downloadStatus, i, f, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(androidx.compose.foundation.layout.r rVar, boolean z, Modifier modifier, int i, Composer composer, int i2) {
        r(rVar, z, modifier, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(androidx.compose.foundation.layout.r rVar, int i, Composer composer, int i2) {
        t(rVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function0 function0, androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(CoroutineScope coroutineScope, n2 n2Var) {
        kotlinx.coroutines.i.e(coroutineScope, null, null, new FontItemMultiTypeKt$FontDeleteBottomDialog$1$2$1$1(n2Var, null), 3, null);
        return Unit.INSTANCE;
    }

    public static final void t(final androidx.compose.foundation.layout.r rVar, Composer composer, final int i) {
        int i2;
        boolean z;
        List listOf;
        int i3;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Composer startRestartGroup = composer.startRestartGroup(1952788075);
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
                ComposerKt.traceEventStart(1952788075, i2, -1, "com.dragon.read.kmp.reader.font.GradientArea2 (FontItemMultiType.kt:244)");
            }
            long p = ((zl4.b) startRestartGroup.consume(zl4.r.w())).p();
            long d = com.dragon.read.kmp.reader.ui.d0.d(p, 0.8f);
            long d2 = com.dragon.read.kmp.reader.ui.d0.d(p, 0.01f);
            float f = 48;
            float M0 = ((x0.e) startRestartGroup.consume(CompositionLocalsKt.f())).M0(x0.i.g(f));
            c0.a aVar = androidx.compose.ui.graphics.c0.b;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(d), androidx.compose.ui.graphics.l0.j(d2)});
            androidx.compose.ui.graphics.c0 k = c0.a.k(aVar, listOf, 0L, M0, 0, 10, (Object) null);
            Modifier.a aVar2 = Modifier.Companion;
            e.a aVar3 = androidx.compose.ui.e.a;
            float f2 = -48;
            Modifier e = u1.e(rVar.b(aVar2, aVar3.o()), x0.i.g(f2), x0.i.g(f2));
            float f3 = 96;
            androidx.compose.foundation.layout.m.b(BackgroundKt.b(SizeKt.s(e, x0.i.g(f3)), k, k.g.f(), 0.0f, 4, (Object) null), startRestartGroup, 0);
            androidx.compose.foundation.layout.m.b(BackgroundKt.b(SizeKt.s(u1.e(rVar.b(aVar2, aVar3.c()), x0.i.g(f), x0.i.g(f)), x0.i.g(f3)), k, k.g.f(), 0.0f, 4, (Object) null), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.font.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u;
                    u = FontItemMultiTypeKt.u(rVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return u;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(com.dragon.read.kmp.i iVar, Function0 function0, CoroutineScope coroutineScope, n2 n2Var) {
        iVar.a("【点击事件】删除面板点击删除字体");
        function0.invoke();
        kotlinx.coroutines.i.e(coroutineScope, null, null, new FontItemMultiTypeKt$FontDeleteBottomDialog$1$1$1$1(n2Var, null), 3, null);
        return Unit.INSTANCE;
    }

    public static final void i(final Function0<Unit> onDeleteClick, final n2 sheetState, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        boolean z3;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onDeleteClick, "onDeleteClick");
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        Composer startRestartGroup = composer.startRestartGroup(74654028);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(onDeleteClick)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(sheetState);
            } else {
                changedInstance = startRestartGroup.changedInstance(sheetState);
            }
            if (changedInstance) {
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
                ComposerKt.traceEventStart(74654028, i5, -1, "com.dragon.read.kmp.reader.font.FontDeleteBottomDialog (FontItemMultiType.kt:193)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
            long D = ((qg4.n) startRestartGroup.consume(zl4.r.s())).D();
            final com.dragon.read.kmp.i iVar = new com.dragon.read.kmp.i(com.dragon.read.kmp.reader.utils.p.o("Font", "Delete"));
            iVar.a("删除面板渲染");
            Modifier.a aVar = Modifier.Companion;
            float f = 12;
            Modifier v = f2.v(BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.h(aVar, 0.0f, 1, (Object) null), k.g.e(x0.i.g(f), x0.i.g(f), 0.0f, 0.0f, 12, (Object) null)), D, (androidx.compose.ui.graphics.f2) null, 2, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(20), 7, (Object) null);
            androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.g(), startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, v);
            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
            Function0 a3 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a3);
            } else {
                startRestartGroup.useNode();
            }
            Composer b = g5.b(startRestartGroup);
            g5.e(b, a, companion2.c());
            g5.e(b, currentCompositionLocalMap, companion2.e());
            Function2 b2 = companion2.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e, companion2.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            float f2 = 19;
            Modifier t = f2.t(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, x0.i.g(f2), 1, (Object) null);
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changedInstance2 = startRestartGroup.changedInstance(iVar);
            if ((i5 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean changedInstance3 = changedInstance2 | z2 | startRestartGroup.changedInstance(coroutineScope);
            int i6 = i5 & 112;
            if (i6 != 32 && ((i5 & 64) == 0 || !startRestartGroup.changedInstance(sheetState))) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean z4 = changedInstance3 | z3;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.font.v
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit j;
                        j = FontItemMultiTypeKt.j(iVar, onDeleteClick, coroutineScope, sheetState);
                        return j;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(t, true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 14, (Object) null);
            long h = x0.x.h(16);
            c0.a aVar2 = androidx.compose.ui.text.font.c0.b;
            androidx.compose.ui.text.font.c0 h2 = aVar2.h();
            long f3 = ((qg4.n) startRestartGroup.consume(zl4.r.s())).f();
            h.a aVar3 = w0.h.b;
            boolean z5 = false;
            a6.j("删除字体", modifier, f3, h, (androidx.compose.ui.text.font.y) null, h2, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar3.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 130512);
            Modifier t2 = f2.t(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, x0.i.g(f2), 1, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance4 = startRestartGroup.changedInstance(coroutineScope);
            if (i6 == 32 || ((i5 & 64) != 0 && startRestartGroup.changedInstance(sheetState))) {
                z5 = true;
            }
            boolean z6 = changedInstance4 | z5;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.reader.font.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit k;
                        k = FontItemMultiTypeKt.k(CoroutineScope.this, sheetState);
                        return k;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            a6.j("取消", ClickableKt.clickable-oSLSa3U$default(t2, true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 14, (Object) null), ((qg4.n) startRestartGroup.consume(zl4.r.s())).k(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, aVar2.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar3.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199686, 0, 130512);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.font.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l;
                    l = FontItemMultiTypeKt.l(Function0.this, sheetState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return l;
                }
            });
        }
    }

    public static final void r(final androidx.compose.foundation.layout.r rVar, final boolean z, final Modifier modifier, Composer composer, final int i) {
        int i2;
        boolean z2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-1836452410);
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & 145) != 144) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1836452410, i2, -1, "com.dragon.read.kmp.reader.font.FontSelectButton (FontItemMultiType.kt:177)");
            }
            if (z) {
                h1.d(org.jetbrains.compose.resources.c.b(f1.f(m3.a), startRestartGroup, 0), "选中", modifier, ((zl4.b) startRestartGroup.consume(zl4.r.w())).b(), startRestartGroup, (i2 & 896) | 48, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.font.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit s;
                    s = FontItemMultiTypeKt.s(rVar, z, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                    return s;
                }
            });
        }
    }

    public static final void p(final androidx.compose.foundation.layout.r FontProgressArea, final DownloadStatus downloadStatus, final int i, final float f, Composer composer, final int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(FontProgressArea, "$this$FontProgressArea");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Composer startRestartGroup = composer.startRestartGroup(-857636766);
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(downloadStatus.ordinal())) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i3 = i6 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(i)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changed(f)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        if ((i3 & 1169) != 1168) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-857636766, i3, -1, "com.dragon.read.kmp.reader.font.FontProgressArea (FontItemMultiType.kt:153)");
            }
            Modifier f2 = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
            androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, f2);
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
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i7, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            startRestartGroup.startReplaceGroup(1018582239);
            if (downloadStatus == DownloadStatus.STATUS_DOWNLOADING) {
                com.dragon.read.kmp.reader.ui.y.b(f, i / 100.0f, null, androidx.compose.ui.graphics.n0.b(0), com.dragon.read.kmp.reader.ui.d0.c(((zl4.b) startRestartGroup.consume(zl4.r.w())).o(), 0.06d), x0.i.g(6), g.a.a(), startRestartGroup, ((i3 >> 9) & 14) | 1772544, 4);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.font.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit q;
                    q = FontItemMultiTypeKt.q(FontProgressArea, downloadStatus, i, f, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return q;
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v8 */
    public static final void m(final a0 uiState, final w0 uiConfig, final n2 sheetState, final Function0<Unit> onFontClick, final Function0<Boolean> onFontLongClick, final Function0<Unit> onGloballyPositioned, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        ?? r8;
        Modifier modifier;
        boolean z6;
        int i4;
        int i5;
        int i6;
        boolean changedInstance;
        int i7;
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        Intrinsics.checkNotNullParameter(onFontClick, "onFontClick");
        Intrinsics.checkNotNullParameter(onFontLongClick, "onFontLongClick");
        Intrinsics.checkNotNullParameter(onGloballyPositioned, "onGloballyPositioned");
        Composer startRestartGroup = composer.startRestartGroup(427926328);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(uiState)) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i2 = i9 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(uiConfig)) {
                i8 = 32;
            } else {
                i8 = 16;
            }
            i2 |= i8;
        }
        if ((i & 384) == 0) {
            if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance = startRestartGroup.changed(sheetState);
            } else {
                changedInstance = startRestartGroup.changedInstance(sheetState);
            }
            if (changedInstance) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i2 |= i7;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(onFontClick)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i2 |= i6;
        }
        if ((i & 24576) == 0) {
            if (startRestartGroup.changedInstance(onFontLongClick)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i2 |= i5;
        }
        if ((196608 & i) == 0) {
            if (startRestartGroup.changedInstance(onGloballyPositioned)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i2 |= i4;
        }
        int i10 = i2;
        if ((74899 & i10) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(427926328, i10, -1, "com.dragon.read.kmp.reader.font.FontItemMultiType (FontItemMultiType.kt:63)");
            }
            com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
            String o = com.dragon.read.kmp.reader.utils.p.o("Font-FontItem");
            StringBuilder sb = new StringBuilder();
            sb.append("[render]");
            sb.append(uiState.a);
            sb.append(", isSelected:");
            sb.append(uiState.e);
            sb.append(", downloadStatus:");
            sb.append(uiState.f);
            sb.append(", ");
            if (uiState.f == DownloadStatus.STATUS_DOWNLOADING) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(uiState.g);
                sb2.append('%');
                str = sb2.toString();
            } else {
                str = "";
            }
            sb.append(str);
            jVar.a(o, sb.toString());
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
            long v = ((zl4.b) startRestartGroup.consume(zl4.r.w())).v((ReaderBgColorType) startRestartGroup.consume(zl4.r.u()));
            Modifier modifier2 = Modifier.Companion;
            float f = 5;
            float f2 = 6;
            Modifier a = androidx.compose.ui.draw.e.a(BackgroundKt.c(f2.v(SizeKt.B(SizeKt.h(modifier2, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), x0.i.g(f), 0.0f, x0.i.g(f), x0.i.g(9), 2, (Object) null), v, k.g.c(x0.i.g(f2))), k.g.c(x0.i.g(f2)));
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changedInstance2 = startRestartGroup.changedInstance(coroutineScope);
            if ((i10 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z7 = changedInstance2 | z2;
            if ((57344 & i10) == 16384) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z8 = z7 | z3;
            if ((i10 & 896) != 256 && ((i10 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0 || !startRestartGroup.changedInstance(sheetState))) {
                z4 = false;
            } else {
                z4 = true;
            }
            boolean z9 = z8 | z4;
            if ((i10 & 7168) == 2048) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean z10 = z9 | z5;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z10 && rememberedValue2 != companion.getEmpty()) {
                i3 = i10;
                modifier = modifier2;
                r8 = 0;
            } else {
                i3 = i10;
                r8 = 0;
                modifier = modifier2;
                FontItemMultiTypeKt$FontItemMultiType$1$1 fontItemMultiTypeKt$FontItemMultiType$1$1 = new FontItemMultiTypeKt$FontItemMultiType$1$1(coroutineScope, uiState, onFontLongClick, sheetState, onFontClick);
                startRestartGroup.updateRememberedValue(fontItemMultiTypeKt$FontItemMultiType$1$1);
                rememberedValue2 = fontItemMultiTypeKt$FontItemMultiType$1$1;
            }
            startRestartGroup.endReplaceGroup();
            Modifier c = androidx.compose.ui.input.pointer.m0.c(a, unit, (PointerInputEventHandler) rememberedValue2);
            startRestartGroup.startReplaceGroup(5004770);
            if ((i3 & 458752) == 131072) {
                z6 = true;
            } else {
                z6 = false;
            }
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.reader.font.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit n;
                        n = FontItemMultiTypeKt.n(Function0.this, (androidx.compose.ui.layout.w) obj);
                        return n;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Modifier a2 = d1.a(c, (Function1) rememberedValue3);
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 i11 = androidx.compose.foundation.layout.m.i(aVar.o(), (boolean) r8);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, (int) r8));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, a2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
            Function0 a4 = companion2.a();
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
            g5.e(b, i11, companion2.c());
            g5.e(b, currentCompositionLocalMap, companion2.e());
            Function2 b2 = companion2.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                b.updateRememberedValue(Integer.valueOf(a3));
                b.apply(Integer.valueOf(a3), b2);
            }
            g5.e(b, e, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier modifier3 = modifier;
            Modifier i12 = SizeKt.i(SizeKt.h(modifier3, 0.0f, 1, (Object) null), x0.i.g(uiConfig.a));
            androidx.compose.ui.layout.p0 i13 = androidx.compose.foundation.layout.m.i(aVar.e(), (boolean) r8);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, (int) r8));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, i12);
            Function0 a6 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a6);
            } else {
                startRestartGroup.useNode();
            }
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, i13, companion2.c());
            g5.e(b3, currentCompositionLocalMap2, companion2.e());
            Function2 b4 = companion2.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                b3.updateRememberedValue(Integer.valueOf(a5));
                b3.apply(Integer.valueOf(a5), b4);
            }
            g5.e(b3, e2, companion2.d());
            startRestartGroup.startReplaceGroup(-255447349);
            if (uiState.e) {
                t(boxScopeInstance, startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            p.n(boxScopeInstance, uiState.a, uiState.b, uiConfig.b, uiConfig.c, uiConfig.d, uiState.d, uiState.e, false, boxScopeInstance.b(modifier3, aVar.e()), startRestartGroup, 6, 128);
            boolean z11 = uiState.e;
            Modifier s = SizeKt.s(boxScopeInstance.b(modifier3, aVar.n()), x0.i.g(16));
            float f3 = 4;
            composer2 = startRestartGroup;
            r(boxScopeInstance, z11, f2.v(s, 0.0f, x0.i.g(f3), x0.i.g(f3), 0.0f, 9, (Object) null), composer2, 6);
            p(boxScopeInstance, uiState.f, uiState.g, x0.i.g(uiConfig.a), composer2, 6);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.font.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o2;
                    o2 = FontItemMultiTypeKt.o(a0.this, uiConfig, sheetState, onFontClick, onFontLongClick, onGloballyPositioned, i, (Composer) obj, ((Integer) obj2).intValue());
                    return o2;
                }
            });
        }
    }
}
