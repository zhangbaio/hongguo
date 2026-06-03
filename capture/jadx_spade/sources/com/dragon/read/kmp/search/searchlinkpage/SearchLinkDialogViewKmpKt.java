package com.dragon.read.kmp.search.searchlinkpage;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.v2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.lazy.y0;
import androidx.compose.foundation.y1;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.e;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.k0;
import androidx.compose.ui.text.m2;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.CandidateDataType;
import com.bytedance.kmp.reading.model.a80;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.om0;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.search.searchlinkpage.SearchLinkDialogViewKmpKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import sh3.i1;
import sh3.k1;
import w0.s;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SearchLinkDialogViewKmpKt {
    static {
        Covode.recordClassIndex(608791);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Modifier modifier, com.dragon.read.kmp.search.searchlinkpage.a aVar, com.dragon.read.kmp.search.searchlinkpage.e eVar, int i, Composer composer, int i2) {
        A(modifier, aVar, eVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Modifier modifier, com.dragon.read.kmp.search.searchlinkpage.a aVar, com.dragon.read.kmp.search.searchlinkpage.e eVar, int i, Composer composer, int i2) {
        D(modifier, aVar, eVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(LazyListState lazyListState, com.dragon.read.kmp.search.searchlinkpage.d dVar, int i, int i2, Composer composer, int i3) {
        H(lazyListState, dVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(com.dragon.read.kmp.search.searchlinkpage.e eVar, int i, Composer composer, int i2) {
        L(eVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(LazyListState lazyListState, List list, com.dragon.read.kmp.search.searchlinkpage.e eVar, int i, Composer composer, int i2) {
        O(lazyListState, list, eVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(com.dragon.read.kmp.search.searchlinkpage.c cVar, com.dragon.read.kmp.search.searchlinkpage.e eVar, int i, Composer composer, int i2) {
        R(cVar, eVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(e0 e0Var, com.dragon.read.kmp.search.searchlinkpage.e eVar, int i, Composer composer, int i2) {
        V(e0Var, eVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(e90 e90Var, int i, Composer composer, int i2) {
        Y(e90Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(LazyListState lazyListState, int i, Composer composer, int i2) {
        a0(lazyListState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(Modifier modifier, f0 f0Var, com.dragon.read.kmp.search.searchlinkpage.e eVar, int i, Composer composer, int i2) {
        e0(modifier, f0Var, eVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Modifier modifier, f0 f0Var, com.dragon.read.kmp.search.searchlinkpage.e eVar, int i, Composer composer, int i2) {
        x(modifier, f0Var, eVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0499, code lost:
    
        if ((r9.floatValue() > 0.0f) != false) goto L144;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void D(final androidx.compose.ui.Modifier r52, final com.dragon.read.kmp.search.searchlinkpage.a r53, final com.dragon.read.kmp.search.searchlinkpage.e r54, androidx.compose.runtime.Composer r55, final int r56) {
        /*
            Method dump skipped, instructions count: 2315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.search.searchlinkpage.SearchLinkDialogViewKmpKt.D(androidx.compose.ui.Modifier, com.dragon.read.kmp.search.searchlinkpage.a, com.dragon.read.kmp.search.searchlinkpage.e, androidx.compose.runtime.Composer, int):void");
    }

    public static final void e0(final Modifier modifier, final f0 model, final com.dragon.read.kmp.search.searchlinkpage.e listener, Composer composer, final int i) {
        int i2;
        Composer composer2;
        String str;
        List arrayList;
        v2 v2Var;
        int i3;
        og4.a aVar;
        om0 om0Var;
        om0 om0Var2;
        a80 a80Var;
        om0 om0Var3;
        String str2;
        om0 om0Var4;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Composer startRestartGroup = composer.startRestartGroup(453218);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(model) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0 ? startRestartGroup.changed(listener) : startRestartGroup.changedInstance(listener) ? 256 : 128;
        }
        int i4 = i2;
        if (startRestartGroup.shouldExecute((i4 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(453218, i4, -1, "com.dragon.read.kmp.search.searchlinkpage.VideoCard (SearchLinkDialogViewKmp.kt:360)");
            }
            Modifier h = SizeKt.h(modifier, 0.0f, 1, (Object) null);
            zl4.s sVar = zl4.s.a;
            int i5 = zl4.s.b;
            long c2 = sVar.b(startRestartGroup, i5).c(startRestartGroup, 0);
            float f = 8;
            float f2 = 12;
            float f3 = 16;
            Modifier s = f2.s(BackgroundKt.c(h, c2, k.g.c(x0.i.g(f))), x0.i.g(f2), x0.i.g(f3));
            startRestartGroup.startReplaceGroup(-1633490746);
            int i6 = i4 & 896;
            boolean changedInstance = (i6 == 256 || ((i4 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 && startRestartGroup.changedInstance(listener))) | startRestartGroup.changedInstance(model);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.search.searchlinkpage.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit f0;
                        f0 = SearchLinkDialogViewKmpKt.f0(e.this, model);
                        return f0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(s, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance2 = startRestartGroup.changedInstance(model) | (i6 == 256 || ((i4 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 && startRestartGroup.changedInstance(listener)));
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.search.searchlinkpage.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit g0;
                        g0 = SearchLinkDialogViewKmpKt.g0(f0.this, listener, (androidx.compose.ui.layout.w) obj);
                        return g0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier a2 = d1.a(modifier2, (Function1) rememberedValue2);
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i7 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, a2);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i7, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier.a aVar3 = Modifier.Companion;
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            p0 a5 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar2.k(), startRestartGroup, 0);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, aVar3);
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
            g5.e(b4, a5, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a6))) {
                b4.updateRememberedValue(Integer.valueOf(a6));
                b4.apply(Integer.valueOf(a6), b5);
            }
            g5.e(b4, e3, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            p0 b6 = r2.b(eVar.d(), aVar2.l(), startRestartGroup, 6);
            int a8 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e4 = ComposedModifierKt.e(startRestartGroup, aVar3);
            Function0 a9 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a9);
            } else {
                startRestartGroup.useNode();
            }
            Composer b7 = g5.b(startRestartGroup);
            g5.e(b7, b6, companion.c());
            g5.e(b7, currentCompositionLocalMap3, companion.e());
            Function2 b8 = companion.b();
            if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a8))) {
                b7.updateRememberedValue(Integer.valueOf(a8));
                b7.apply(Integer.valueOf(a8), b8);
            }
            g5.e(b7, e4, companion.d());
            v2 v2Var2 = w2.b;
            float f4 = 4;
            Modifier a10 = androidx.compose.ui.draw.e.a(SizeKt.x(SizeKt.i(aVar3, x0.i.g(80)), x0.i.g(56)), k.g.c(x0.i.g(f4)));
            p0 i8 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a11 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e5 = ComposedModifierKt.e(startRestartGroup, a10);
            Function0 a12 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a12);
            } else {
                startRestartGroup.useNode();
            }
            Composer b9 = g5.b(startRestartGroup);
            g5.e(b9, i8, companion.c());
            g5.e(b9, currentCompositionLocalMap4, companion.e());
            Function2 b10 = companion.b();
            if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a11))) {
                b9.updateRememberedValue(Integer.valueOf(a11));
                b9.apply(Integer.valueOf(a11), b10);
            }
            g5.e(b9, e5, companion.d());
            List list = model.e.v;
            LoadImageKt.g((list == null || (om0Var4 = (om0) list.get(0)) == null) ? null : om0Var4.b, (String) null, (com.dragon.read.kmp.compose.common.image.n) null, boxScopeInstance.a(aVar3), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 0, 118);
            z0.g(org.jetbrains.compose.resources.c.a(i1.t(k1.a), startRestartGroup, 0), "短剧封面按钮", boxScopeInstance.b(SizeKt.s(aVar3, x0.i.g(14)), aVar2.e()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, startRestartGroup, 48, 248);
            startRestartGroup.endNode();
            a3.a(SizeKt.x(aVar3, x0.i.g(f2)), startRestartGroup, 6);
            Modifier a13 = u2.a(v2Var2, aVar3, 1.0f, false, 2, (Object) null);
            p0 a14 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar2.k(), startRestartGroup, 0);
            int a15 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e6 = ComposedModifierKt.e(startRestartGroup, a13);
            Function0 a16 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a16);
            } else {
                startRestartGroup.useNode();
            }
            Composer b11 = g5.b(startRestartGroup);
            g5.e(b11, a14, companion.c());
            g5.e(b11, currentCompositionLocalMap5, companion.e());
            Function2 b12 = companion.b();
            if (b11.getInserting() || !Intrinsics.areEqual(b11.rememberedValue(), Integer.valueOf(a15))) {
                b11.updateRememberedValue(Integer.valueOf(a15));
                b11.apply(Integer.valueOf(a15), b12);
            }
            g5.e(b11, e6, companion.d());
            Modifier h2 = SizeKt.h(aVar3, 0.0f, 1, (Object) null);
            p0 b13 = r2.b(eVar.h(), aVar2.i(), startRestartGroup, 48);
            int a17 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e7 = ComposedModifierKt.e(startRestartGroup, h2);
            Function0 a18 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a18);
            } else {
                startRestartGroup.useNode();
            }
            Composer b14 = g5.b(startRestartGroup);
            g5.e(b14, b13, companion.c());
            g5.e(b14, currentCompositionLocalMap6, companion.e());
            Function2 b15 = companion.b();
            if (b14.getInserting() || !Intrinsics.areEqual(b14.rememberedValue(), Integer.valueOf(a17))) {
                b14.updateRememberedValue(Integer.valueOf(a17));
                b14.apply(Integer.valueOf(a17), b15);
            }
            g5.e(b14, e7, companion.d());
            List list2 = model.e.v;
            String str3 = (list2 == null || (om0Var3 = (om0) list2.get(0)) == null || (str2 = om0Var3.e) == null) ? "" : str2;
            Map map = model.e.m;
            List list3 = (map == null || (a80Var = (a80) map.get("title")) == null) ? null : a80Var.c;
            long u = sVar.b(startRestartGroup, i5).u();
            long o = sVar.b(startRestartGroup, i5).o();
            float f5 = 6;
            Modifier v = f2.v(v2Var2.a(aVar3, 1.0f, false), 0.0f, 0.0f, x0.i.g(f5), 0.0f, 11, (Object) null);
            androidx.compose.ui.text.e m0 = m0(str3, list3, u, o);
            long h3 = x0.x.h(16);
            s.a aVar4 = w0.s.b;
            a6.k(m0, v, 0L, h3, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Map) null, (Function1) null, (g3) null, startRestartGroup, 3072, 3120, 251892);
            og4.a aVar5 = og4.a.a;
            int i9 = og4.a.b;
            Modifier c3 = BackgroundKt.c(aVar3, aVar5.h(startRestartGroup, i9).o(), k.g.c(x0.i.g(f4)));
            p0 i10 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a19 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e8 = ComposedModifierKt.e(startRestartGroup, c3);
            Function0 a20 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a20);
            } else {
                startRestartGroup.useNode();
            }
            Composer b16 = g5.b(startRestartGroup);
            g5.e(b16, i10, companion.c());
            g5.e(b16, currentCompositionLocalMap7, companion.e());
            Function2 b17 = companion.b();
            if (b16.getInserting() || !Intrinsics.areEqual(b16.rememberedValue(), Integer.valueOf(a19))) {
                b16.updateRememberedValue(Integer.valueOf(a19));
                b16.apply(Integer.valueOf(a19), b17);
            }
            g5.e(b16, e8, companion.d());
            Modifier s2 = f2.s(aVar3, x0.i.g(f4), x0.i.g(1));
            Integer num = model.e.G0;
            a6.j((num != null && num.intValue() == CandidateDataType.DynamicComic.getValue()) ? "漫剧" : "短剧", s2, sVar.b(startRestartGroup, i5).q(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 3072, 0, 131056);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            a3.a(SizeKt.i(aVar3, x0.i.g(2)), startRestartGroup, 6);
            Modifier h4 = SizeKt.h(aVar3, 0.0f, 1, (Object) null);
            List list4 = model.e.v;
            if (list4 == null || (om0Var2 = (om0) list4.get(0)) == null || (str = om0Var2.j) == null) {
                str = "";
            }
            a6.j(str, h4, sVar.b(startRestartGroup, i5).q(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 2, 0, (Function1) null, (g3) null, startRestartGroup, 3120, 3120, 120816);
            a3.a(SizeKt.i(aVar3, x0.i.g(f5)), startRestartGroup, 6);
            List list5 = model.e.v;
            if (list5 == null || (om0Var = (om0) list5.get(0)) == null || (arrayList = om0Var.t0) == null) {
                arrayList = new ArrayList();
            }
            List list6 = arrayList;
            com.dragon.read.kmp.search.searchlinkpage.b bVar = com.dragon.read.kmp.search.searchlinkpage.b.a;
            com.dragon.read.kmp.basenovel.ui.widget.s.b(aVar3, list6, 0, 0.0f, bVar.f(), bVar.a(), startRestartGroup, 221190, 12);
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(392795243);
            if (model.a) {
                v2Var = v2Var2;
                i3 = i9;
                aVar = aVar5;
            } else {
                a3.a(SizeKt.x(aVar3, x0.i.g(f2)), startRestartGroup, 6);
                i3 = i9;
                aVar = aVar5;
                v2Var = v2Var2;
                x(v2Var.b(BackgroundKt.c(SizeKt.x(SizeKt.i(aVar3, x0.i.g(30)), x0.i.g(72)), aVar.h(startRestartGroup, i3).o(), k.g.c(x0.i.g(22))), aVar2.i()), model, listener, startRestartGroup, (i4 & 112) | i6);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(683724870);
            if (model.a) {
                a3.a(SizeKt.i(aVar3, x0.i.g(f3)), startRestartGroup, 6);
                Modifier h5 = SizeKt.h(aVar3, 0.0f, 1, (Object) null);
                p0 b18 = r2.b(eVar.f(), aVar2.l(), startRestartGroup, 6);
                int a21 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e9 = ComposedModifierKt.e(startRestartGroup, h5);
                Function0 a22 = companion.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a22);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b19 = g5.b(startRestartGroup);
                g5.e(b19, b18, companion.c());
                g5.e(b19, currentCompositionLocalMap8, companion.e());
                Function2 b20 = companion.b();
                if (b19.getInserting() || !Intrinsics.areEqual(b19.rememberedValue(), Integer.valueOf(a21))) {
                    b19.updateRememberedValue(Integer.valueOf(a21));
                    b19.apply(Integer.valueOf(a21), b20);
                }
                g5.e(b19, e9, companion.d());
                float f6 = 36;
                v2 v2Var3 = v2Var;
                float f7 = 22;
                Modifier t = f2.t(BackgroundKt.c(SizeKt.i(u2.a(v2Var, aVar3, 1.0f, false, 2, (Object) null), x0.i.g(f6)), aVar.h(startRestartGroup, i3).o(), k.g.c(x0.i.g(f7))), 0.0f, x0.i.g(f), 1, (Object) null);
                p0 i11 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
                int a23 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap9 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e10 = ComposedModifierKt.e(startRestartGroup, t);
                Function0 a24 = companion.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a24);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b21 = g5.b(startRestartGroup);
                g5.e(b21, i11, companion.c());
                g5.e(b21, currentCompositionLocalMap9, companion.e());
                Function2 b22 = companion.b();
                if (b21.getInserting() || !Intrinsics.areEqual(b21.rememberedValue(), Integer.valueOf(a23))) {
                    b21.updateRememberedValue(Integer.valueOf(a23));
                    b21.apply(Integer.valueOf(a23), b22);
                }
                g5.e(b21, e10, companion.d());
                a6.j("立即观看", (Modifier) null, sVar.b(startRestartGroup, i5).o(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 131026);
                startRestartGroup.endNode();
                composer2 = startRestartGroup;
                a3.a(SizeKt.x(aVar3, x0.i.g(f2)), composer2, 6);
                x(BackgroundKt.c(SizeKt.i(u2.a(v2Var3, aVar3, 1.0f, false, 2, (Object) null), x0.i.g(f6)), aVar.h(composer2, i3).o(), k.g.c(x0.i.g(f7))), model, listener, composer2, (i4 & 112) | i6);
                composer2.endNode();
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.search.searchlinkpage.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h0;
                    h0 = SearchLinkDialogViewKmpKt.h0(modifier, model, listener, i, (Composer) obj, ((Integer) obj2).intValue());
                    return h0;
                }
            });
        }
    }

    public static final class b implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public b(List list) {
            this.a = list;
        }

        public final Object a(int i) {
            this.a.get(i);
            return null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }
    }

    static final class d implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.search.searchlinkpage.e a;
        final /* synthetic */ State<com.dragon.read.kmp.search.searchlinkpage.d> b;

        d(com.dragon.read.kmp.search.searchlinkpage.e eVar, State<com.dragon.read.kmp.search.searchlinkpage.d> state) {
            this.a = eVar;
            this.b = state;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(com.dragon.read.kmp.search.searchlinkpage.e eVar) {
            eVar.g();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            b(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1760415035, i, -1, "com.dragon.read.kmp.search.searchlinkpage.SearchLinkDialogViewKmp.<anonymous> (SearchLinkDialogViewKmp.kt:127)");
                }
                com.dragon.read.kmp.j.a.d("SearchLinkDialogKmp", "SearchLinkDialogKmp: 创建NovelUiStyle完成，创建box");
                LazyListState c = y0.c(0, 0, composer, 0, 3);
                Modifier.a aVar = Modifier.Companion;
                Modifier d = BackgroundKt.d(SizeKt.d(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, 1, (Object) null), n0.d(2147483648L), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(this.a);
                final com.dragon.read.kmp.search.searchlinkpage.e eVar = this.a;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.search.searchlinkpage.c0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c2;
                            c2 = SearchLinkDialogViewKmpKt.d.c(e.this);
                            return c2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                com.dragon.read.kmp.search.searchlinkpage.e eVar2 = this.a;
                State<com.dragon.read.kmp.search.searchlinkpage.d> state = this.b;
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i2 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, modifier);
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
                g5.e(b, i2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier v = f2.v(SizeKt.d(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, 1, (Object) null), 0.0f, x0.i.g(52), 0.0f, 0.0f, 13, (Object) null);
                p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, v);
                Function0 a4 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a4);
                } else {
                    composer.useNode();
                }
                Composer b3 = g5.b(composer);
                g5.e(b3, i3, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                    b3.updateRememberedValue(Integer.valueOf(a3));
                    b3.apply(Integer.valueOf(a3), b4);
                }
                g5.e(b3, e2, companion.d());
                SearchLinkDialogViewKmpKt.O(c, SearchLinkDialogViewKmpKt.W(state).a, eVar2, composer, 0);
                SearchLinkDialogViewKmpKt.a0(c, composer, 0);
                SearchLinkDialogViewKmpKt.H(c, SearchLinkDialogViewKmpKt.W(state), 136, composer, 384);
                SearchLinkDialogViewKmpKt.L(eVar2, composer, 0);
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
    public static final Unit M(com.dragon.read.kmp.search.searchlinkpage.e eVar) {
        eVar.a();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.dragon.read.kmp.search.searchlinkpage.d W(State<com.dragon.read.kmp.search.searchlinkpage.d> state) {
        return (com.dragon.read.kmp.search.searchlinkpage.d) state.getValue();
    }

    private static final boolean J(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final boolean c0(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b0(LazyListState lazyListState) {
        Object obj;
        boolean z;
        Iterator it2 = lazyListState.x().h().iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (((androidx.compose.foundation.lazy.o) obj).getIndex() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((androidx.compose.foundation.lazy.o) obj) == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(com.dragon.read.kmp.search.searchlinkpage.e eVar, com.dragon.read.kmp.search.searchlinkpage.a aVar) {
        eVar.f(1, aVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(com.dragon.read.kmp.search.searchlinkpage.e eVar, com.dragon.read.kmp.search.searchlinkpage.c cVar) {
        eVar.e(cVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(com.dragon.read.kmp.search.searchlinkpage.e eVar, f0 f0Var) {
        eVar.d(1, f0Var);
        return Unit.INSTANCE;
    }

    public static final class e<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((Long) ((List) t).get(0), (Long) ((List) t2).get(0));
            return compareValues;
        }
    }

    static final class a implements Function3<androidx.compose.animation.e, Composer, Integer, Unit> {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.animation.e eVar, Composer composer, Integer num) {
            a(eVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.animation.e AnimatedVisibility, Composer composer, int i) {
            List listOf;
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1117383649, i, -1, "com.dragon.read.kmp.search.searchlinkpage.BottomOverlay.<anonymous> (SearchLinkDialogViewKmp.kt:753)");
            }
            long g = l0.b.g();
            long d = n0.d(2147483648L);
            Modifier i2 = SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(this.a));
            c0.a aVar = androidx.compose.ui.graphics.c0.b;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(g), l0.j(d)});
            androidx.compose.foundation.layout.m.b(BackgroundKt.b(i2, c0.a.p(aVar, listOf, 0.0f, 0.0f, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(com.dragon.read.kmp.search.searchlinkpage.a aVar, com.dragon.read.kmp.search.searchlinkpage.e eVar, androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        if (!aVar.c) {
            eVar.h(aVar);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(com.dragon.read.kmp.search.searchlinkpage.c cVar, com.dragon.read.kmp.search.searchlinkpage.e eVar, androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        if (!cVar.c) {
            eVar.i(cVar);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(f0 f0Var, com.dragon.read.kmp.search.searchlinkpage.e eVar, androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        if (!f0Var.c) {
            eVar.j(f0Var);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(State state, com.dragon.read.kmp.search.searchlinkpage.a aVar, com.dragon.read.kmp.search.searchlinkpage.e eVar) {
        Boolean value;
        boolean booleanValue = ((Boolean) state.getValue()).booleanValue();
        MutableStateFlow<Boolean> mutableStateFlow = aVar.b;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.valueOf(!booleanValue)));
        eVar.b(aVar, !booleanValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(List list, com.dragon.read.kmp.search.searchlinkpage.e eVar, o0 LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        com.dragon.read.kmp.search.searchlinkpage.b bVar = com.dragon.read.kmp.search.searchlinkpage.b.a;
        androidx.compose.foundation.lazy.n0.a(LazyColumn, (Object) null, (Object) null, bVar.e(), 3, (Object) null);
        LazyColumn.f(list.size(), (Function1) null, new b(list), androidx.compose.runtime.internal.t.c(2039820996, true, new c(list, eVar)));
        androidx.compose.foundation.lazy.n0.a(LazyColumn, (Object) null, (Object) null, bVar.d(), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(State state, f0 f0Var, com.dragon.read.kmp.search.searchlinkpage.e eVar) {
        Boolean value;
        boolean booleanValue = ((Boolean) state.getValue()).booleanValue();
        MutableStateFlow<Boolean> mutableStateFlow = f0Var.b;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.valueOf(!booleanValue)));
        eVar.c(f0Var, !booleanValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I(LazyListState lazyListState, int i, int i2) {
        boolean z;
        Object obj;
        boolean z2;
        androidx.compose.foundation.lazy.x x = lazyListState.x();
        Iterator it2 = x.h().iterator();
        while (true) {
            z = false;
            if (it2.hasNext()) {
                obj = it2.next();
                if (((androidx.compose.foundation.lazy.o) obj).getIndex() == i - 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        androidx.compose.foundation.lazy.o oVar = (androidx.compose.foundation.lazy.o) obj;
        if (oVar == null) {
            return true;
        }
        int c2 = x.c() - (oVar.getOffset() + oVar.getSize());
        if (c2 <= com.dragon.read.kmp.service.d1.b(i2)) {
            z = true;
        }
        com.dragon.read.kmp.j.a.d("SearchLinkDialogKmp", "distanceToBottom:" + c2 + " item.offset:" + oVar.getOffset() + ", item.height:" + oVar.getSize());
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(final com.dragon.read.kmp.search.searchlinkpage.e eVar, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean changedInstance;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1565639558);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(eVar);
            } else {
                changedInstance = startRestartGroup.changedInstance(eVar);
            }
            if (changedInstance) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        boolean z2 = true;
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1565639558, i2, -1, "com.dragon.read.kmp.search.searchlinkpage.CloseButton (SearchLinkDialogViewKmp.kt:769)");
            }
            e1 a2 = org.jetbrains.compose.resources.c.a(i1.h(k1.a), startRestartGroup, 0);
            Modifier b2 = BoxScopeInstance.a.b(SizeKt.s(f2.v(Modifier.Companion, 0.0f, 0.0f, 0.0f, x0.i.g(44), 7, (Object) null), x0.i.g(48)), androidx.compose.ui.e.a.b());
            startRestartGroup.startReplaceGroup(5004770);
            if ((i2 & 14) != 4 && ((i2 & 8) == 0 || !startRestartGroup.changedInstance(eVar))) {
                z2 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.search.searchlinkpage.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit M;
                        M = SearchLinkDialogViewKmpKt.M(e.this);
                        return M;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            z0.g(a2, "关闭按钮", ClickableKt.clickable-oSLSa3U$default(b2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, startRestartGroup, 48, 248);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.search.searchlinkpage.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit N;
                    N = SearchLinkDialogViewKmpKt.N(e.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return N;
                }
            });
        }
    }

    public static final void Y(final e90 tagInfo, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        long q;
        int i3;
        Intrinsics.checkNotNullParameter(tagInfo, "tagInfo");
        Composer startRestartGroup = composer.startRestartGroup(-2137563842);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(tagInfo)) {
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
                ComposerKt.traceEventStart(-2137563842, i2, -1, "com.dragon.read.kmp.search.searchlinkpage.Tag (SearchLinkDialogViewKmp.kt:558)");
            }
            String str = tagInfo.a;
            if (str == null) {
                composer2 = startRestartGroup;
            } else {
                if (Intrinsics.areEqual(tagInfo.c, Boolean.TRUE)) {
                    startRestartGroup.startReplaceGroup(-1486563309);
                    q = og4.a.a.h(startRestartGroup, og4.a.b).p();
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1486503448);
                    q = zl4.s.a.b(startRestartGroup, zl4.s.b).q();
                    startRestartGroup.endReplaceGroup();
                }
                composer2 = startRestartGroup;
                a6.j(str, (Modifier) null, q, x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3072, 0, 131058);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.search.searchlinkpage.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Z;
                    Z = SearchLinkDialogViewKmpKt.Z(tagInfo, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Z;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(final LazyListState lazyListState, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-401951676);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(lazyListState)) {
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
                ComposerKt.traceEventStart(-401951676, i2, -1, "com.dragon.read.kmp.search.searchlinkpage.TopOverlay (SearchLinkDialogViewKmp.kt:694)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.search.searchlinkpage.v
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean b0;
                        b0 = SearchLinkDialogViewKmpKt.b0(lazyListState);
                        return Boolean.valueOf(b0);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            AnimatedVisibilityKt.j(c0((State) rememberedValue), BoxScopeInstance.a.b(Modifier.Companion, androidx.compose.ui.e.a.o()), EnterExitTransitionKt.o((androidx.compose.animation.core.n0) null, 0.0f, 3, (Object) null), EnterExitTransitionKt.q((androidx.compose.animation.core.n0) null, 0.0f, 3, (Object) null), (String) null, com.dragon.read.kmp.search.searchlinkpage.b.a.b(), startRestartGroup, 200112, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.search.searchlinkpage.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit d0;
                    d0 = SearchLinkDialogViewKmpKt.d0(lazyListState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return d0;
                }
            });
        }
    }

    public static final class c implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ com.dragon.read.kmp.search.searchlinkpage.e b;

        public c(List list, com.dragon.read.kmp.search.searchlinkpage.e eVar) {
            this.a = list;
            this.b = eVar;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            a(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f fVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            int i4;
            int i5;
            if ((i2 & 6) == 0) {
                if (composer.changed(fVar)) {
                    i5 = 4;
                } else {
                    i5 = 2;
                }
                i3 = i5 | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composer.changed(i)) {
                    i4 = 32;
                } else {
                    i4 = 16;
                }
                i3 |= i4;
            }
            if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                d0 d0Var = (d0) this.a.get(i);
                composer.startReplaceGroup(1956451174);
                if (d0Var instanceof com.dragon.read.kmp.search.searchlinkpage.a) {
                    composer.startReplaceGroup(1956491876);
                    SearchLinkDialogViewKmpKt.D(Modifier.Companion, (com.dragon.read.kmp.search.searchlinkpage.a) d0Var, this.b, composer, 6);
                    composer.endReplaceGroup();
                } else if (d0Var instanceof f0) {
                    composer.startReplaceGroup(1956603011);
                    SearchLinkDialogViewKmpKt.e0(Modifier.Companion, (f0) d0Var, this.b, composer, 6);
                    composer.endReplaceGroup();
                } else if (d0Var instanceof com.dragon.read.kmp.search.searchlinkpage.c) {
                    composer.startReplaceGroup(1956715944);
                    SearchLinkDialogViewKmpKt.R((com.dragon.read.kmp.search.searchlinkpage.c) d0Var, this.b, composer, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1956798094);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final void V(final e0 viewModel, final com.dragon.read.kmp.search.searchlinkpage.e listener, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Composer startRestartGroup = composer.startRestartGroup(-1659797942);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(viewModel)) {
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
                changedInstance = startRestartGroup.changed(listener);
            } else {
                changedInstance = startRestartGroup.changedInstance(listener);
            }
            if (changedInstance) {
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
                ComposerKt.traceEventStart(-1659797942, i2, -1, "com.dragon.read.kmp.search.searchlinkpage.SearchLinkDialogViewKmp (SearchLinkDialogViewKmp.kt:95)");
            }
            com.dragon.read.kmp.j.a.d("SearchLinkDialogKmp", "创建SearchLinkDialogViewKmp");
            State collectAsState = SnapshotStateKt.collectAsState(viewModel.a, (CoroutineContext) null, startRestartGroup, 0, 1);
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(collectAsState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SearchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1(collectAsState, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            if (!((Boolean) mutableState.getValue()).booleanValue()) {
                mutableState.setValue(Boolean.TRUE);
            }
            com.dragon.read.kmp.reader.state.t.f(androidx.compose.runtime.internal.t.e(1760415035, true, new d(listener, collectAsState), startRestartGroup, 54), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.search.searchlinkpage.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit X;
                    X = SearchLinkDialogViewKmpKt.X(e0.this, listener, i, (Composer) obj, ((Integer) obj2).intValue());
                    return X;
                }
            });
        }
    }

    private static final androidx.compose.ui.text.e m0(String str, List<? extends List<Long>> list, long j, long j2) {
        e.b bVar;
        int o;
        boolean z;
        if (list == null) {
            bVar = new e.b(0, 1, (DefaultConstructorMarker) null);
            o = bVar.o(new m2(j2, 0L, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (k0) null, (androidx.compose.ui.graphics.drawscope.g) null, 65534, (DefaultConstructorMarker) null));
            try {
                bVar.h(str);
                Unit unit = Unit.INSTANCE;
                bVar.m(o);
                return bVar.q();
            } finally {
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            List list2 = (List) obj;
            if (list2.size() >= 2 && ((Number) list2.get(0)).longValue() >= 0 && ((Number) list2.get(1)).longValue() > 0 && ((Number) list2.get(0)).longValue() + ((Number) list2.get(1)).longValue() <= str.length()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        List<List> sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new e());
        bVar = new e.b(0, 1, (DefaultConstructorMarker) null);
        int i = 0;
        for (List list3 : sortedWith) {
            long longValue = ((Number) list3.get(0)).longValue();
            long longValue2 = ((Number) list3.get(1)).longValue() + longValue;
            if (longValue > i) {
                o = bVar.o(new m2(j2, 0L, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (k0) null, (androidx.compose.ui.graphics.drawscope.g) null, 65534, (DefaultConstructorMarker) null));
                try {
                    String substring = str.substring(i, (int) longValue);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    bVar.h(substring);
                    Unit unit2 = Unit.INSTANCE;
                    bVar.m(o);
                } finally {
                }
            }
            o = bVar.o(new m2(j, 0L, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (k0) null, (androidx.compose.ui.graphics.drawscope.g) null, 65534, (DefaultConstructorMarker) null));
            int i2 = (int) longValue;
            int i3 = (int) longValue2;
            try {
                String substring2 = str.substring(i2, i3);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                bVar.h(substring2);
                Unit unit3 = Unit.INSTANCE;
                bVar.m(o);
                i = i3;
            } finally {
            }
        }
        if (i < str.length()) {
            o = bVar.o(new m2(j2, 0L, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (k0) null, (androidx.compose.ui.graphics.drawscope.g) null, 65534, (DefaultConstructorMarker) null));
            try {
                String substring3 = str.substring(i);
                Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                bVar.h(substring3);
                Unit unit4 = Unit.INSTANCE;
            } finally {
            }
        }
        return bVar.q();
    }

    public static final void R(final com.dragon.read.kmp.search.searchlinkpage.c data, final com.dragon.read.kmp.search.searchlinkpage.e listener, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Composer startRestartGroup = composer.startRestartGroup(1567768089);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(data)) {
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
                changedInstance = startRestartGroup.changed(listener);
            } else {
                changedInstance = startRestartGroup.changedInstance(listener);
            }
            if (changedInstance) {
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
                ComposerKt.traceEventStart(1567768089, i2, -1, "com.dragon.read.kmp.search.searchlinkpage.SearchItemCard (SearchLinkDialogViewKmp.kt:574)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier i5 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(52));
            zl4.s sVar = zl4.s.a;
            int i6 = zl4.s.b;
            Modifier c2 = BackgroundKt.c(i5, sVar.b(startRestartGroup, i6).c(startRestartGroup, 0), k.g.c(x0.i.g(8)));
            float f = 16;
            Modifier v = f2.v(c2, x0.i.g(f), 0.0f, x0.i.g(18), 0.0f, 10, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            int i7 = i2 & 112;
            if (i7 != 32 && ((i2 & 64) == 0 || !startRestartGroup.changedInstance(listener))) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean changedInstance2 = z2 | startRestartGroup.changedInstance(data);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.search.searchlinkpage.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit S;
                        S = SearchLinkDialogViewKmpKt.S(e.this, data);
                        return S;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(v, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance3 = startRestartGroup.changedInstance(data);
            if (i7 != 32 && ((i2 & 64) == 0 || !startRestartGroup.changedInstance(listener))) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean z4 = z3 | changedInstance3;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.search.searchlinkpage.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit T;
                        T = SearchLinkDialogViewKmpKt.T(c.this, listener, (androidx.compose.ui.layout.w) obj);
                        return T;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier a2 = d1.a(modifier, (Function1) rememberedValue2);
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i8 = androidx.compose.foundation.layout.m.i(aVar2.h(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, a2);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i8, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            e.c i9 = aVar2.i();
            Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            p0 b4 = r2.b(androidx.compose.foundation.layout.e.a.h(), i9, startRestartGroup, 48);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, h);
            Function0 a6 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a6);
            } else {
                startRestartGroup.useNode();
            }
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, b4, companion.c());
            g5.e(b5, currentCompositionLocalMap2, companion.e());
            Function2 b6 = companion.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a5))) {
                b5.updateRememberedValue(Integer.valueOf(a5));
                b5.apply(Integer.valueOf(a5), b6);
            }
            g5.e(b5, e3, companion.d());
            w2 w2Var = w2.b;
            k1 k1Var = k1.a;
            e1 a7 = org.jetbrains.compose.resources.c.a(i1.l(k1Var), startRestartGroup, 0);
            m0.a aVar3 = m0.b;
            z0.g(a7, "搜索放大镜", SizeKt.s(aVar, x0.i.g(20)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(aVar3, sVar.b(startRestartGroup, i6).o(), 0, 2, (Object) null), 0, startRestartGroup, 432, 184);
            a6.k(m0(data.e, data.f, sVar.b(startRestartGroup, i6).u(), sVar.b(startRestartGroup, i6).o()), f2.v(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), x0.i.g(4), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, x0.x.h(16), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Map) null, (Function1) null, (g3) null, startRestartGroup, 3072, 3120, 251892);
            startRestartGroup = startRestartGroup;
            z0.g(org.jetbrains.compose.resources.c.a(i1.k(k1Var), startRestartGroup, 0), "前往搜索", SizeKt.s(aVar, x0.i.g(f)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(aVar3, sVar.b(startRestartGroup, i6).o(), 0, 2, (Object) null), 0, startRestartGroup, 432, 184);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.search.searchlinkpage.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit U;
                    U = SearchLinkDialogViewKmpKt.U(c.this, listener, i, (Composer) obj, ((Integer) obj2).intValue());
                    return U;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(final LazyListState lazyListState, final com.dragon.read.kmp.search.searchlinkpage.d dVar, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(76498759);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(lazyListState)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i3 = i6 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(dVar)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(i)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(76498759, i3, -1, "com.dragon.read.kmp.search.searchlinkpage.BottomOverlay (SearchLinkDialogViewKmp.kt:726)");
            }
            final int size = dVar.a.size() + 2;
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                final int i7 = 136;
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.search.searchlinkpage.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean I;
                        I = SearchLinkDialogViewKmpKt.I(lazyListState, size, i7);
                        return Boolean.valueOf(I);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            AnimatedVisibilityKt.j(J((State) rememberedValue), BoxScopeInstance.a.b(Modifier.Companion, androidx.compose.ui.e.a.b()), EnterExitTransitionKt.o((androidx.compose.animation.core.n0) null, 0.0f, 3, (Object) null), EnterExitTransitionKt.q((androidx.compose.animation.core.n0) null, 0.0f, 3, (Object) null), (String) null, androidx.compose.runtime.internal.t.e(-1117383649, true, new a(i), startRestartGroup, 54), startRestartGroup, 200112, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.search.searchlinkpage.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit K;
                    K = SearchLinkDialogViewKmpKt.K(lazyListState, dVar, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return K;
                }
            });
        }
    }

    public static final void A(final Modifier modifier, final com.dragon.read.kmp.search.searchlinkpage.a model, final com.dragon.read.kmp.search.searchlinkpage.e listener, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        String str;
        long o;
        boolean changedInstance;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Composer startRestartGroup = composer.startRestartGroup(-1908989100);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(model)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance = startRestartGroup.changed(listener);
            } else {
                changedInstance = startRestartGroup.changedInstance(listener);
            }
            if (changedInstance) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        boolean z2 = true;
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1908989100, i2, -1, "com.dragon.read.kmp.search.searchlinkpage.AddShelfButton (SearchLinkDialogViewKmp.kt:518)");
            }
            final State collectAsState = SnapshotStateKt.collectAsState(model.b, (CoroutineContext) null, startRestartGroup, 0, 1);
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changed = startRestartGroup.changed(collectAsState) | startRestartGroup.changedInstance(model);
            if ((i2 & 896) != 256 && ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0 || !startRestartGroup.changedInstance(listener))) {
                z2 = false;
            }
            boolean z3 = changed | z2;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.search.searchlinkpage.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit B;
                        B = SearchLinkDialogViewKmpKt.B(collectAsState, model, listener);
                        return B;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            p0 i6 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier2);
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
            g5.e(b2, i6, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            if (((Boolean) collectAsState.getValue()).booleanValue()) {
                str = "已加书架";
            } else {
                str = "加入书架";
            }
            String str2 = str;
            if (((Boolean) collectAsState.getValue()).booleanValue()) {
                startRestartGroup.startReplaceGroup(-2016770656);
                o = og4.a.a.h(startRestartGroup, og4.a.b).h();
            } else {
                startRestartGroup.startReplaceGroup(-2016769495);
                o = zl4.s.a.b(startRestartGroup, zl4.s.b).o();
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            long j = o;
            a6.j(str2, (Modifier) null, j, x0.x.h(12), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131026);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.search.searchlinkpage.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit C;
                    C = SearchLinkDialogViewKmpKt.C(modifier, model, listener, i, (Composer) obj, ((Integer) obj2).intValue());
                    return C;
                }
            });
        }
    }

    public static final void O(final LazyListState lazyListState, final List<d0> contentList, final com.dragon.read.kmp.search.searchlinkpage.e listener, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        boolean changedInstance;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(contentList, "contentList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Composer startRestartGroup = composer.startRestartGroup(-918371086);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(lazyListState)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(contentList)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance = startRestartGroup.changed(listener);
            } else {
                changedInstance = startRestartGroup.changedInstance(listener);
            }
            if (changedInstance) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-918371086, i2, -1, "com.dragon.read.kmp.search.searchlinkpage.ContentList (SearchLinkDialogViewKmp.kt:163)");
            }
            float g = x0.i.g(16);
            float f = 20;
            Modifier v = f2.v(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null);
            e.f p = androidx.compose.foundation.layout.e.a.p(g);
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance2 = startRestartGroup.changedInstance(contentList);
            if ((i2 & 896) != 256 && ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0 || !startRestartGroup.changedInstance(listener))) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z3 = changedInstance2 | z2;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.search.searchlinkpage.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit P;
                        P = SearchLinkDialogViewKmpKt.P(contentList, listener, (o0) obj);
                        return P;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            androidx.compose.foundation.lazy.d.c(v, lazyListState, (i2) null, false, p, (e.b) null, (l1) null, false, (y1) null, (Function1) rememberedValue, startRestartGroup, ((i2 << 3) & 112) | 24582, 492);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.search.searchlinkpage.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Q;
                    Q = SearchLinkDialogViewKmpKt.Q(lazyListState, contentList, listener, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Q;
                }
            });
        }
    }

    public static final void x(final Modifier modifier, final f0 model, final com.dragon.read.kmp.search.searchlinkpage.e listener, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        String str;
        long o;
        boolean changedInstance;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Composer startRestartGroup = composer.startRestartGroup(1166136750);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(model)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance = startRestartGroup.changed(listener);
            } else {
                changedInstance = startRestartGroup.changedInstance(listener);
            }
            if (changedInstance) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        boolean z2 = true;
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1166136750, i2, -1, "com.dragon.read.kmp.search.searchlinkpage.AddCollectButton (SearchLinkDialogViewKmp.kt:538)");
            }
            final State collectAsState = SnapshotStateKt.collectAsState(model.b, (CoroutineContext) null, startRestartGroup, 0, 1);
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changed = startRestartGroup.changed(collectAsState) | startRestartGroup.changedInstance(model);
            if ((i2 & 896) != 256 && ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0 || !startRestartGroup.changedInstance(listener))) {
                z2 = false;
            }
            boolean z3 = changed | z2;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.search.searchlinkpage.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit y;
                        y = SearchLinkDialogViewKmpKt.y(collectAsState, model, listener);
                        return y;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            p0 i6 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier2);
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
            g5.e(b2, i6, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            if (((Boolean) collectAsState.getValue()).booleanValue()) {
                str = "已加收藏";
            } else {
                str = "加入收藏";
            }
            String str2 = str;
            if (((Boolean) collectAsState.getValue()).booleanValue()) {
                startRestartGroup.startReplaceGroup(140084910);
                o = og4.a.a.h(startRestartGroup, og4.a.b).h();
            } else {
                startRestartGroup.startReplaceGroup(140086071);
                o = zl4.s.a.b(startRestartGroup, zl4.s.b).o();
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            long j = o;
            a6.j(str2, (Modifier) null, j, x0.x.h(12), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131026);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.search.searchlinkpage.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit z4;
                    z4 = SearchLinkDialogViewKmpKt.z(modifier, model, listener, i, (Composer) obj, ((Integer) obj2).intValue());
                    return z4;
                }
            });
        }
    }
}
