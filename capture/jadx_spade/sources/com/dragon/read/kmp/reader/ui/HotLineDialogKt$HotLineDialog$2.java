package com.dragon.read.kmp.reader.ui;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.k2;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.material.h1;
import androidx.compose.material.k4;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.b1;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.graphics.n2;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import com.dragon.read.kmp.base.ui.util.ScreenUtils;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import com.dragon.read.kmp.reader.font.Font;
import com.dragon.read.kmp.reader.ui.HotLineDialogKt$HotLineDialog$2;
import com.dragon.read.kmp.service.KmpFontServiceKt;
import com.dragon.read.reader.f1;
import com.dragon.read.reader.m3;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class HotLineDialogKt$HotLineDialog$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ n a;

    HotLineDialogKt$HotLineDialog$2(n nVar) {
        this.a = nVar;
    }

    private static final boolean e(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final float h(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float i(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ boolean a;
        final /* synthetic */ n b;
        final /* synthetic */ long c;

        a(boolean z, n nVar, long j) {
            this.a = z;
            this.b = nVar;
            this.c = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(n nVar) {
            dm4.j reporterDepend = xf4.d.o3.a().reporterDepend();
            if (reporterDepend != null) {
                reporterDepend.a("click_more_quote", new ym4.a().g("book_id", nVar.a.a).g("quote_item_id", String.valueOf(nVar.a.c)).g("enter_type", "click").g("position", "reader"));
            }
            nVar.e.invoke();
            HotLineDialogKt.j().a("点击更多热门划线");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(n nVar) {
            dm4.j reporterDepend = xf4.d.o3.a().reporterDepend();
            if (reporterDepend != null) {
                reporterDepend.a("add_quote", new ym4.a().g("book_id", nVar.a.a).g("hot_line_id", String.valueOf(nVar.a.b)).g("quote_item_id", String.valueOf(nVar.a.c)));
            }
            nVar.d.invoke();
            HotLineDialogKt.j().a("点击添加划线");
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            c(composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference failed for: r12v14 */
        /* JADX WARN: Type inference failed for: r12v7 */
        /* JADX WARN: Type inference failed for: r12v8, types: [boolean, int] */
        public final void c(Composer composer, int i) {
            boolean z;
            float f;
            Composer composer2;
            n nVar;
            zl4.s sVar;
            int i2;
            Modifier modifier;
            ?? r12;
            List listOf;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-90903870, i, -1, "com.dragon.read.kmp.reader.ui.HotLineDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HotLineDialog.kt:141)");
                }
                Modifier modifier2 = Modifier.Companion;
                Modifier h = SizeKt.h(modifier2, 0.0f, 1, (Object) null);
                boolean z2 = this.a;
                final n nVar2 = this.b;
                long j = this.c;
                e.a aVar = androidx.compose.ui.e.a;
                p0 i3 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, h);
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
                m3 m3Var = m3.a;
                Painter b3 = org.jetbrains.compose.resources.c.b(f1.d(m3Var), composer, 0);
                Modifier i4 = SizeKt.i(SizeKt.h(modifier2, 0.0f, 1, (Object) null), x0.i.g(120));
                androidx.compose.ui.layout.i b4 = androidx.compose.ui.layout.i.a.b();
                if (z2) {
                    f = 0.4f;
                } else {
                    f = 1.0f;
                }
                z0.c(b3, (String) null, i4, (androidx.compose.ui.e) null, b4, f, (m0) null, composer, 25008, 72);
                float f2 = 14;
                Modifier s = f2.s(SizeKt.h(modifier2, 0.0f, 1, (Object) null), x0.i.g(16), x0.i.g(f2));
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                p0 a3 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar.k(), composer, 0);
                int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, s);
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
                Composer b5 = g5.b(composer);
                g5.e(b5, a3, companion.c());
                g5.e(b5, currentCompositionLocalMap2, companion.e());
                Function2 b6 = companion.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a4))) {
                    b5.updateRememberedValue(Integer.valueOf(a4));
                    b5.apply(Integer.valueOf(a4), b6);
                }
                g5.e(b5, e2, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                Modifier h2 = SizeKt.h(modifier2, 0.0f, 1, (Object) null);
                p0 b7 = r2.b(eVar.f(), aVar.i(), composer, 54);
                int a6 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, h2);
                Function0 a7 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a7);
                } else {
                    composer.useNode();
                }
                Composer b8 = g5.b(composer);
                g5.e(b8, b7, companion.c());
                g5.e(b8, currentCompositionLocalMap3, companion.e());
                Function2 b9 = companion.b();
                if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a6))) {
                    b8.updateRememberedValue(Integer.valueOf(a6));
                    b8.apply(Integer.valueOf(a6), b9);
                }
                g5.e(b8, e3, companion.d());
                w2 w2Var = w2.b;
                zl4.s sVar2 = zl4.s.a;
                int i5 = zl4.s.b;
                long o = sVar2.b(composer, i5).o();
                long h3 = x0.x.h(16);
                c0.a aVar2 = androidx.compose.ui.text.font.c0.b;
                a6.j("热门划线", (Modifier) null, o, h3, (androidx.compose.ui.text.font.y) null, aVar2.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199686, 0, 131026);
                composer.startReplaceGroup(1931556570);
                if (nVar2.a.f > 0) {
                    composer.startReplaceGroup(5004770);
                    boolean changed = composer.changed(nVar2);
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.ui.k
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit d;
                                d = HotLineDialogKt$HotLineDialog$2.a.d(n.this);
                                return d;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    Modifier modifier3 = ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                    p0 b10 = r2.b(eVar.h(), aVar.i(), composer, 48);
                    int a8 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                    Modifier e4 = ComposedModifierKt.e(composer, modifier3);
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
                    Composer b11 = g5.b(composer);
                    g5.e(b11, b10, companion.c());
                    g5.e(b11, currentCompositionLocalMap4, companion.e());
                    Function2 b12 = companion.b();
                    if (b11.getInserting() || !Intrinsics.areEqual(b11.rememberedValue(), Integer.valueOf(a8))) {
                        b11.updateRememberedValue(Integer.valueOf(a8));
                        b11.apply(Integer.valueOf(a8), b12);
                    }
                    g5.e(b11, e4, companion.d());
                    StringBuilder sb = new StringBuilder();
                    sb.append(nVar2.a.f);
                    sb.append((char) 26465);
                    nVar = nVar2;
                    a6.j(sb.toString(), (Modifier) null, sVar2.b(composer, i5).q(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131058);
                    composer2 = composer;
                    r12 = 0;
                    modifier = modifier2;
                    i2 = i5;
                    sVar = sVar2;
                    h1.c(org.jetbrains.compose.resources.c.a(com.dragon.read.base.i.a.a(), composer2, 0), (String) null, SizeKt.s(modifier, x0.i.g(f2)), sVar.b(composer2, i2).q(), composer, 432, 0);
                    composer.endNode();
                } else {
                    composer2 = composer;
                    nVar = nVar2;
                    sVar = sVar2;
                    i2 = i5;
                    modifier = modifier2;
                    r12 = 0;
                }
                composer.endReplaceGroup();
                composer.endNode();
                a3.a(SizeKt.i(modifier, x0.i.g(12)), composer2, 6);
                Modifier a10 = c0Var.a(SizeKt.h(modifier, 0.0f, 1, (Object) null), 1.0f, (boolean) r12);
                p0 i6 = androidx.compose.foundation.layout.m.i(aVar.o(), (boolean) r12);
                int a11 = j.a(androidx.compose.runtime.i.b(composer2, (int) r12));
                e0 currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
                Modifier e5 = ComposedModifierKt.e(composer2, a10);
                Function0 a12 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer2.createNode(a12);
                } else {
                    composer.useNode();
                }
                Composer b13 = g5.b(composer);
                g5.e(b13, i6, companion.c());
                g5.e(b13, currentCompositionLocalMap5, companion.e());
                Function2 b14 = companion.b();
                if (b13.getInserting() || !Intrinsics.areEqual(b13.rememberedValue(), Integer.valueOf(a11))) {
                    b13.updateRememberedValue(Integer.valueOf(a11));
                    b13.apply(Integer.valueOf(a11), b14);
                }
                g5.e(b13, e5, companion.d());
                final n nVar3 = nVar;
                zl4.s sVar3 = sVar;
                int i7 = i2;
                Modifier modifier4 = modifier;
                a6.j(nVar3.a.d, k2.i(modifier, k2.d((int) r12, composer2, (int) r12, 1), false, (l1) null, false, 14, (Object) null), sVar.b(composer2, i2).o(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) KmpFontServiceKt.a(Font.HYXinRenWenSong.getFontFamily(), composer2, r12).getValue(), 0L, (w0.i) null, w0.h.h(w0.h.b.c()), x0.x.h(24), 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 6, 129456);
                Modifier b15 = boxScopeInstance.b(SizeKt.i(SizeKt.h(modifier4, 0.0f, 1, (Object) null), x0.i.g(6)), aVar.b());
                c0.a aVar3 = androidx.compose.ui.graphics.c0.b;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(l0.n(j, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), l0.j(j)});
                androidx.compose.foundation.layout.m.b(BackgroundKt.b(b15, c0.a.p(aVar3, listOf, 0.0f, 0.0f, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null), composer, 0);
                composer.endNode();
                a3.a(SizeKt.i(modifier4, x0.i.g(10)), composer, 6);
                Modifier h4 = SizeKt.h(modifier4, 0.0f, 1, (Object) null);
                p0 b16 = r2.b(eVar.h(), aVar.i(), composer, 48);
                int a13 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
                Modifier e6 = ComposedModifierKt.e(composer, h4);
                Function0 a14 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a14);
                } else {
                    composer.useNode();
                }
                Composer b17 = g5.b(composer);
                g5.e(b17, b16, companion.c());
                g5.e(b17, currentCompositionLocalMap6, companion.e());
                Function2 b18 = companion.b();
                if (b17.getInserting() || !Intrinsics.areEqual(b17.rememberedValue(), Integer.valueOf(a13))) {
                    b17.updateRememberedValue(Integer.valueOf(a13));
                    b17.apply(Integer.valueOf(a13), b18);
                }
                g5.e(b17, e6, companion.d());
                a6.j(nVar3.a.e + "人划过", (Modifier) null, sVar3.b(composer, i7).q(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131058);
                a3.a(u2.a(w2Var, modifier4, 1.0f, false, 2, (Object) null), composer, 0);
                composer.startReplaceGroup(5004770);
                boolean changed2 = composer.changed(nVar3);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.ui.l
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit e7;
                            e7 = HotLineDialogKt$HotLineDialog$2.a.e(n.this);
                            return e7;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                Modifier modifier5 = ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null);
                p0 b19 = r2.b(eVar.h(), aVar.i(), composer, 48);
                int a15 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
                Modifier e7 = ComposedModifierKt.e(composer, modifier5);
                Function0 a16 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a16);
                } else {
                    composer.useNode();
                }
                Composer b20 = g5.b(composer);
                g5.e(b20, b19, companion.c());
                g5.e(b20, currentCompositionLocalMap7, companion.e());
                Function2 b21 = companion.b();
                if (b20.getInserting() || !Intrinsics.areEqual(b20.rememberedValue(), Integer.valueOf(a15))) {
                    b20.updateRememberedValue(Integer.valueOf(a15));
                    b20.apply(Integer.valueOf(a15), b21);
                }
                g5.e(b20, e7, companion.d());
                h1.d(org.jetbrains.compose.resources.c.b(f1.e(m3Var), composer, 0), (String) null, SizeKt.s(modifier4, x0.i.g(20)), 0L, composer, 432, 8);
                a6.j("加入划线", f2.t(modifier4, x0.i.g(4), 0.0f, 2, (Object) null), sVar3.b(composer, i7).q(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, aVar2.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199734, 0, 131024);
                composer.endNode();
                composer.endNode();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        d(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(n nVar, c1 graphicsLayer) {
        float f;
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        float f2 = 0.0f;
        if (Float.intBitsToFloat((int) (graphicsLayer.e() >> 32)) > 0.0f) {
            f = (nVar.c + graphicsLayer.M0(x0.i.g(16))) / Float.intBitsToFloat((int) (graphicsLayer.e() >> 32));
        } else {
            f = 0.5f;
        }
        if (nVar.b) {
            f2 = 1.0f;
        }
        graphicsLayer.i1(n2.a(f, f2));
        return Unit.INSTANCE;
    }

    public final void d(Composer composer, int i) {
        boolean z;
        float f;
        float f2;
        n nVar;
        if ((i & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (composer.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(540973306, i, -1, "com.dragon.read.kmp.reader.ui.HotLineDialog.<anonymous> (HotLineDialog.kt:83)");
            }
            zl4.s sVar = zl4.s.a;
            int i2 = zl4.s.b;
            boolean a2 = pm4.q.a.a(sVar.c(composer, i2));
            composer.startReplaceGroup(1849434622);
            Object rememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            composer.endReplaceGroup();
            Unit unit = Unit.INSTANCE;
            composer.startReplaceGroup(5004770);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new HotLineDialogKt$HotLineDialog$2$1$1(mutableState, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue2, composer, 6);
            if (e(mutableState)) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            final State e = AnimateAsStateKt.e(f, androidx.compose.animation.core.j.n(300, 0, (androidx.compose.animation.core.d0) null, 6, (Object) null), 0.0f, (String) null, (Function1) null, composer, 48, 28);
            if (e(mutableState)) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            final State e2 = AnimateAsStateKt.e(f2, androidx.compose.animation.core.j.n(300, 0, (androidx.compose.animation.core.d0) null, 6, (Object) null), 0.0f, (String) null, (Function1) null, composer, 48, 28);
            long v = sVar.b(composer, i2).v(ReaderBgColorType.STANDARD);
            composer.startReplaceGroup(184326797);
            float w1 = ((x0.e) composer.consume(CompositionLocalsKt.f())).w1(ScreenUtils.a.f(ig4.f.a(composer, 0)) * 0.4f);
            composer.endReplaceGroup();
            Modifier.a aVar = Modifier.Companion;
            Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            composer.startReplaceGroup(-1633490746);
            boolean changed = composer.changed(e) | composer.changed(e2);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.reader.ui.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit j;
                        j = HotLineDialogKt$HotLineDialog$2.j(e, e2, (c1) obj);
                        return j;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceGroup();
            Modifier a3 = b1.a(h, (Function1) rememberedValue3);
            final n nVar2 = this.a;
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
            e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(composer, a3);
            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
            Function0 a5 = companion2.a();
            if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(a5);
            } else {
                composer.useNode();
            }
            Composer b = g5.b(composer);
            g5.e(b, i3, companion2.c());
            g5.e(b, currentCompositionLocalMap, companion2.e());
            Function2 b2 = companion2.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a4))) {
                b.updateRememberedValue(Integer.valueOf(a4));
                b.apply(Integer.valueOf(a4), b2);
            }
            g5.e(b, e3, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            float f3 = 16;
            Modifier s = f2.s(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f3), x0.i.g(f3));
            composer.startReplaceGroup(5004770);
            boolean changed2 = composer.changed(nVar2);
            Object rememberedValue4 = composer.rememberedValue();
            if (changed2 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.reader.ui.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit f4;
                        f4 = HotLineDialogKt$HotLineDialog$2.f(n.this, (c1) obj);
                        return f4;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            composer.endReplaceGroup();
            Modifier a6 = b1.a(s, (Function1) rememberedValue4);
            p0 a7 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), aVar2.k(), composer, 0);
            int a8 = j.a(androidx.compose.runtime.i.b(composer, 0));
            e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier e4 = ComposedModifierKt.e(composer, a6);
            Function0 a9 = companion2.a();
            if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(a9);
            } else {
                composer.useNode();
            }
            Composer b3 = g5.b(composer);
            g5.e(b3, a7, companion2.c());
            g5.e(b3, currentCompositionLocalMap2, companion2.e());
            Function2 b4 = companion2.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a8))) {
                b3.updateRememberedValue(Integer.valueOf(a8));
                b3.apply(Integer.valueOf(a8), b4);
            }
            g5.e(b3, e4, companion2.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            composer.startReplaceGroup(-1760372036);
            if (!nVar2.b) {
                nVar = nVar2;
                HotLineDialogKt.d(true, nVar2.c, v, composer, 6);
            } else {
                nVar = nVar2;
            }
            composer.endReplaceGroup();
            k4.c(SizeKt.k(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, w1, 1, (Object) null), k.g.c(x0.i.g(12)), v, 0L, (androidx.compose.foundation.w) null, x0.i.g(8), androidx.compose.runtime.internal.t.e(-90903870, true, new a(a2, nVar, v), composer, 54), composer, 1769472, 24);
            composer.startReplaceGroup(-1760097092);
            if (nVar.b) {
                HotLineDialogKt.d(false, nVar.c, v, composer, 6);
            }
            composer.endReplaceGroup();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(State state, State state2, c1 graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.n(h(state));
        graphicsLayer.o(h(state));
        graphicsLayer.c(i(state2));
        return Unit.INSTANCE;
    }
}
