package cl4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import c54.b4;
import c54.d4;
import c54.e4;
import c54.f4;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UseStatus;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt;
import com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPagerKt;
import com.dragon.read.rpc.kmp.community.model.r4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n1 {
    static {
        Covode.recordClassIndex(608069);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(com.dragon.read.rpc.kmp.community.model.l1 l1Var, int i, Composer composer, int i2) {
        j(l1Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(androidx.compose.foundation.layout.r rVar, com.dragon.read.rpc.kmp.community.model.l1 l1Var, int i, Composer composer, int i2) {
        l(rVar, l1Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(ll4.d dVar, int i, Function0 function0, Function0 function02, Function0 function03, int i2, Composer composer, int i3) {
        n(dVar, i, function0, function02, function03, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final class b implements jd4.b {
        private boolean a;

        b() {
        }

        public boolean isShown() {
            return this.a;
        }

        public void setShown(boolean z) {
            this.a = z;
        }
    }

    public static final void n(final ll4.d model, final int i, final Function0<Unit> onFirstVisible, final Function0<Unit> goDetail, final Function0<Unit> onClick, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        String K;
        org.jetbrains.compose.resources.b V;
        final MutableState mutableState;
        androidx.compose.foundation.layout.b0 b0Var;
        int i4;
        og4.a aVar;
        Modifier modifier;
        int i5;
        float g;
        long r;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(onFirstVisible, "onFirstVisible");
        Intrinsics.checkNotNullParameter(goDetail, "goDetail");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-2041482825);
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(model) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(onFirstVisible) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(goDetail) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(onClick) ? 16384 : 8192;
        }
        int i6 = i3;
        if (startRestartGroup.shouldExecute((i6 & 9363) != 9362, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2041482825, i6, -1, "com.dragon.read.kmp.profile.container.double_column.VideoListItemReservation2Col (VideoListItemReservation2Col.kt:70)");
            }
            final tl4.l lVar = (tl4.l) startRestartGroup.consume(ProfileTabPagerKt.E());
            og4.a aVar2 = og4.a.a;
            int i7 = og4.a.b;
            boolean d = com.dragon.read.kmp.service.d1.d(aVar2.e(startRestartGroup, i7));
            xl4.a aVar3 = xl4.a.a;
            r4 r4Var = model.h.m;
            final long b2 = xl4.a.b(aVar3, (r4Var == null || (str2 = r4Var.h) == null) ? "" : str2, aVar2.h(startRestartGroup, i7).a0(), d, 0.0f, 0.0f, 0.0f, 56, null);
            MutableState<Boolean> R = model.R();
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(model);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                if (model.H().getValue() == UseStatus.OfflineStatus.getValue()) {
                    K = "****";
                } else {
                    K = model.K();
                    if (K == null) {
                        rememberedValue = "";
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                }
                rememberedValue = K;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            String str3 = (String) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            r4 r4Var2 = model.h.m;
            String str4 = (r4Var2 == null || (str = r4Var2.l) == null) ? "" : str;
            Boolean bool = r4Var2 != null ? r4Var2.n : null;
            com.dragon.read.rpc.kmp.community.model.l1 l1Var = r4Var2 != null ? r4Var2.m : null;
            com.dragon.read.rpc.kmp.community.model.l1 l1Var2 = r4Var2 != null ? r4Var2.e : null;
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new b();
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            b bVar = (b) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            Modifier modifier2 = Modifier.Companion;
            com.dragon.read.rpc.kmp.community.model.l1 l1Var3 = l1Var;
            com.dragon.read.rpc.kmp.community.model.l1 l1Var4 = l1Var2;
            float f = 12;
            Boolean bool2 = bool;
            Modifier modifier3 = ClickableKt.clickable-oSLSa3U$default(ig4.i.c(AspectRatioKt.b(SizeKt.h(modifier2, 0.0f, 1, (Object) null), 0.57507986f, false, 2, (Object) null), x0.i.d(x0.i.g(f)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, onClick, 15, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean z = (i6 & 896) == 256;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: cl4.e1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit x;
                        x = n1.x(Function0.this);
                        return x;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Modifier i0 = GuestProfileOneTabContentKt.i0(modifier3, bVar, (Function0) rememberedValue4);
            e.a aVar4 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 i8 = androidx.compose.foundation.layout.m.i(aVar4.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, i0);
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
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, i8, companion2.c());
            g5.e(b3, currentCompositionLocalMap, companion2.e());
            Function2 b4 = companion2.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                b3.updateRememberedValue(Integer.valueOf(a2));
                b3.apply(Integer.valueOf(a2), b4);
            }
            g5.e(b3, e, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier c = ig4.i.c(AspectRatioKt.b(SizeKt.h(modifier2, 0.0f, 1, (Object) null), 0.7171315f, false, 2, (Object) null), x0.i.d(x0.i.g(f)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null);
            androidx.compose.ui.layout.p0 i9 = androidx.compose.foundation.layout.m.i(aVar4.o(), false);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, c);
            Function0 a5 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a5);
            } else {
                startRestartGroup.useNode();
            }
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, i9, companion2.c());
            g5.e(b5, currentCompositionLocalMap2, companion2.e());
            Function2 b6 = companion2.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a4))) {
                b5.updateRememberedValue(Integer.valueOf(a4));
                b5.apply(Integer.valueOf(a4), b6);
            }
            g5.e(b5, e2, companion2.d());
            String y = model.y();
            Modifier a6 = boxScopeInstance.a(modifier2);
            com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
            if (d) {
                V = d2.U(f2.a.a);
            } else {
                V = d2.V(f2.a.a);
            }
            nVar.e = V;
            composer2 = startRestartGroup;
            LoadImageKt.g(y, (String) null, nVar, a6, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, composer2, 0, 114);
            composer2.startReplaceGroup(-1696132523);
            if (Intrinsics.areEqual(bool2, Boolean.TRUE)) {
                androidx.compose.foundation.z0.c(org.jetbrains.compose.resources.c.b(b4.O(d4.a), composer2, 0), (String) null, SizeKt.s(boxScopeInstance.b(modifier2, aVar4.e()), x0.i.g(24)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, composer2, 48, 120);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.startReplaceGroup(-121944835);
            if (l1Var4 != null) {
                l(boxScopeInstance, l1Var4, composer2, 6);
            }
            composer2.endReplaceGroup();
            Modifier a7 = boxScopeInstance.a(modifier2);
            composer2.startReplaceGroup(-1633490746);
            boolean changed2 = composer2.changed(b2);
            Object rememberedValue5 = composer2.rememberedValue();
            if (changed2 || rememberedValue5 == companion.getEmpty()) {
                mutableState = mutableState2;
                rememberedValue5 = new Function1() { // from class: cl4.g1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        androidx.compose.ui.draw.j p;
                        p = n1.p(b2, mutableState, (CacheDrawScope) obj);
                        return p;
                    }
                };
                composer2.updateRememberedValue(rememberedValue5);
            } else {
                mutableState = mutableState2;
            }
            composer2.endReplaceGroup();
            Modifier c2 = androidx.compose.ui.draw.i.c(a7, (Function1) rememberedValue5);
            androidx.compose.ui.layout.p0 i10 = androidx.compose.foundation.layout.m.i(aVar4.o(), false);
            int a8 = j.a(androidx.compose.runtime.i.b(composer2, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(composer2, c2);
            Function0 a9 = companion2.a();
            if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(a9);
            } else {
                composer2.useNode();
            }
            Composer b7 = g5.b(composer2);
            g5.e(b7, i10, companion2.c());
            g5.e(b7, currentCompositionLocalMap3, companion2.e());
            Function2 b8 = companion2.b();
            if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a8))) {
                b7.updateRememberedValue(Integer.valueOf(a8));
                b7.apply(Integer.valueOf(a8), b8);
            }
            g5.e(b7, e3, companion2.d());
            Modifier v = androidx.compose.foundation.layout.f2.v(androidx.compose.foundation.layout.f2.t(SizeKt.h(boxScopeInstance.b(modifier2, aVar4.b()), 0.0f, 1, (Object) null), x0.i.g(f), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(f), 7, (Object) null);
            composer2.startReplaceGroup(5004770);
            Object rememberedValue6 = composer2.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: cl4.h1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit r2;
                        r2 = n1.r(mutableState, (androidx.compose.ui.layout.w) obj);
                        return r2;
                    }
                };
                composer2.updateRememberedValue(rememberedValue6);
            }
            composer2.endReplaceGroup();
            Modifier a10 = androidx.compose.ui.layout.d1.a(v, (Function1) rememberedValue6);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            androidx.compose.ui.layout.p0 a11 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar4.k(), composer2, 0);
            int a12 = j.a(androidx.compose.runtime.i.b(composer2, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier e4 = ComposedModifierKt.e(composer2, a10);
            Function0 a13 = companion2.a();
            if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(a13);
            } else {
                composer2.useNode();
            }
            Composer b9 = g5.b(composer2);
            g5.e(b9, a11, companion2.c());
            g5.e(b9, currentCompositionLocalMap4, companion2.e());
            Function2 b10 = companion2.b();
            if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a12))) {
                b9.updateRememberedValue(Integer.valueOf(a12));
                b9.apply(Integer.valueOf(a12), b10);
            }
            g5.e(b9, e4, companion2.d());
            androidx.compose.foundation.layout.b0 b0Var2 = androidx.compose.foundation.layout.c0.b;
            composer2.startReplaceGroup(5004770);
            boolean z2 = (i6 & 7168) == 2048;
            Object rememberedValue7 = composer2.rememberedValue();
            if (z2 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: cl4.i1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit s;
                        s = n1.s(Function0.this);
                        return s;
                    }
                };
                composer2.updateRememberedValue(rememberedValue7);
            }
            composer2.endReplaceGroup();
            com.dragon.read.kmp.profile.component.v.d(str3, ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue7, 15, (Object) null), 0.0f, 0.0f, androidx.compose.runtime.internal.t.e(-721615282, true, new a(l1Var3), composer2, 54), t.a.a(), new g3(aVar2.h(composer2, i7).r(), x0.x.h(14), new androidx.compose.ui.text.font.c0(400), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777208, (DefaultConstructorMarker) null), composer2, 221184, 12);
            List<String> J = model.J();
            composer2.startReplaceGroup(721669394);
            if (!J.isEmpty()) {
                i4 = i7;
                aVar = aVar2;
                b0Var = b0Var2;
                modifier = modifier2;
                i5 = 0;
                bl4.g0.h(J, aVar2.d().G(), composer2, 0, 0);
            } else {
                b0Var = b0Var2;
                i4 = i7;
                aVar = aVar2;
                modifier = modifier2;
                i5 = 0;
            }
            composer2.endReplaceGroup();
            a3.a(SizeKt.i(modifier, x0.i.g(10)), composer2, 6);
            Modifier d2 = BackgroundKt.d(ig4.i.c(SizeKt.h(modifier, 0.0f, 1, (Object) null), x0.i.d(x0.i.g(8)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), aVar.h(composer2, i4).I(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            if (str4.length() > 0) {
                g = x0.i.g(7);
            } else {
                g = x0.i.g((float) 5.5d);
            }
            Modifier t = androidx.compose.foundation.layout.f2.t(d2, 0.0f, g, 1, (Object) null);
            composer2.startReplaceGroup(-1746271574);
            boolean changed3 = composer2.changed(lVar) | composer2.changedInstance(model) | ((i6 & 112) == 32);
            Object rememberedValue8 = composer2.rememberedValue();
            if (changed3 || rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new Function0() { // from class: cl4.j1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit t2;
                        t2 = n1.t(tl4.l.this, model, i);
                        return t2;
                    }
                };
                composer2.updateRememberedValue(rememberedValue8);
            }
            composer2.endReplaceGroup();
            Modifier modifier4 = ClickableKt.clickable-oSLSa3U$default(t, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue8, 15, (Object) null);
            androidx.compose.ui.layout.p0 a14 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar4.k(), composer2, i5);
            int a15 = j.a(androidx.compose.runtime.i.b(composer2, i5));
            androidx.compose.runtime.e0 currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
            Modifier e5 = ComposedModifierKt.e(composer2, modifier4);
            Function0 a16 = companion2.a();
            if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(a16);
            } else {
                composer2.useNode();
            }
            Composer b11 = g5.b(composer2);
            g5.e(b11, a14, companion2.c());
            g5.e(b11, currentCompositionLocalMap5, companion2.e());
            Function2 b12 = companion2.b();
            if (b11.getInserting() || !Intrinsics.areEqual(b11.rememberedValue(), Integer.valueOf(a15))) {
                b11.updateRememberedValue(Integer.valueOf(a15));
                b11.apply(Integer.valueOf(a15), b12);
            }
            g5.e(b11, e5, companion2.d());
            String c3 = org.jetbrains.compose.resources.j.c(o(R) ? f4.w(e4.a) : f4.v(e4.a), composer2, i5);
            androidx.compose.foundation.layout.b0 b0Var3 = b0Var;
            Modifier b13 = b0Var3.b(modifier, aVar4.g());
            if (o(R)) {
                composer2.startReplaceGroup(793359894);
                r = aVar.h(composer2, i4).g0();
            } else {
                composer2.startReplaceGroup(793361259);
                r = aVar.h(composer2, i4).r();
            }
            composer2.endReplaceGroup();
            og4.a aVar5 = aVar;
            a6.j(c3, b13, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, new g3(r, x0.x.h(12), new androidx.compose.ui.text.font.c0(500), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777208, (DefaultConstructorMarker) null), composer2, 0, 0, 65532);
            composer2.startReplaceGroup(793367545);
            if (str4.length() > 0) {
                a6.j(str4, androidx.compose.foundation.layout.f2.v(b0Var3.b(modifier, aVar4.g()), 0.0f, x0.i.g(4), 0.0f, 0.0f, 13, (Object) null), 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, new g3(aVar5.h(composer2, i4).G(), x0.x.h(12), new androidx.compose.ui.text.font.c0(400), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777208, (DefaultConstructorMarker) null), composer2, 0, 0, 65532);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
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
            endRestartGroup.a(new Function2() { // from class: cl4.f1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u;
                    u = n1.u(ll4.d.this, i, onFirstVisible, goDetail, onClick, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return u;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final Float v(MutableState<Float> mutableState) {
        return (Float) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final boolean o(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void w(MutableState<Float> mutableState, Float f) {
        mutableState.setValue(f);
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.rpc.kmp.community.model.l1 a;

        a(com.dragon.read.rpc.kmp.community.model.l1 l1Var) {
            this.a = l1Var;
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
                    ComposerKt.traceEventStart(-721615282, i, -1, "com.dragon.read.kmp.profile.container.double_column.VideoListItemReservation2Col.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoListItemReservation2Col.kt:191)");
                }
                com.dragon.read.rpc.kmp.community.model.l1 l1Var = this.a;
                if (l1Var != null) {
                    n1.j(l1Var, composer, 0);
                }
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
    public static final Unit q(androidx.compose.ui.graphics.c0 c0Var, androidx.compose.ui.graphics.drawscope.f onDrawBehind) {
        Intrinsics.checkNotNullParameter(onDrawBehind, "$this$onDrawBehind");
        DrawScope.-CC.o(onDrawBehind, c0Var, 0L, 0L, 0.0f, (androidx.compose.ui.graphics.drawscope.g) null, (androidx.compose.ui.graphics.m0) null, 0, 126, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(MutableState mutableState, androidx.compose.ui.layout.w coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        w(mutableState, Float.valueOf(Float.intBitsToFloat((int) (androidx.compose.ui.layout.x.e(coords) & 4294967295L))));
        return Unit.INSTANCE;
    }

    private static final List<androidx.compose.ui.graphics.l0> y(List<androidx.compose.ui.graphics.l0> list, long j) {
        List<androidx.compose.ui.graphics.l0> list2;
        List<androidx.compose.ui.graphics.l0> listOf;
        List<androidx.compose.ui.graphics.l0> listOf2;
        if (list != null) {
            list2 = CollectionsKt___CollectionsKt.filterNotNull(list);
        } else {
            list2 = null;
        }
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        if (list2.isEmpty()) {
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(j), androidx.compose.ui.graphics.l0.j(j)});
            return listOf2;
        }
        if (list2.size() == 1) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{list2.get(0), list2.get(0)});
            return listOf;
        }
        return list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(tl4.l lVar, ll4.d dVar, int i) {
        lVar.v(dVar, i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.draw.j p(long j, MutableState mutableState, CacheDrawScope drawWithCache) {
        float coerceAtLeast;
        float f;
        float f2;
        float coerceIn;
        float coerceIn2;
        Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Float.intBitsToFloat((int) (drawWithCache.e() & 4294967295L)), 1.0f);
        Float v = v(mutableState);
        if (v != null) {
            f = v.floatValue();
        } else {
            f = 0.3f * coerceAtLeast;
        }
        float M0 = f - drawWithCache.M0(x0.i.g(60));
        Float v2 = v(mutableState);
        if (v2 != null) {
            f2 = v2.floatValue();
        } else {
            f2 = 0.7f * coerceAtLeast;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(M0 / coerceAtLeast, 0.0f, 1.0f);
        coerceIn2 = RangesKt___RangesKt.coerceIn(f2 / coerceAtLeast, 0.0f, 1.0f);
        final androidx.compose.ui.graphics.c0 q = c0.a.q(androidx.compose.ui.graphics.c0.b, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(j, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), TuplesKt.to(Float.valueOf(coerceIn), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(j, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), TuplesKt.to(Float.valueOf(coerceIn2), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(j, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), TuplesKt.to(Float.valueOf(1.0f), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(j, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null)))}, 0.0f, 0.0f, 0, 14, (Object) null);
        return drawWithCache.q(new Function1() { // from class: cl4.k1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q2;
                q2 = n1.q(q, (androidx.compose.ui.graphics.drawscope.f) obj);
                return q2;
            }
        });
    }

    public static final void j(final com.dragon.read.rpc.kmp.community.model.l1 tag, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        ArrayList arrayList;
        ArrayList arrayList2;
        androidx.compose.ui.graphics.l0 j;
        long x;
        long x2;
        List<androidx.compose.ui.graphics.l0> y;
        long j2;
        int i3;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Composer startRestartGroup = composer.startRestartGroup(204803520);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(tag)) {
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
                ComposerKt.traceEventStart(204803520, i2, -1, "com.dragon.read.kmp.profile.container.double_column.Tag (VideoListItemReservation2Col.kt:248)");
            }
            String str = tag.b;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            List list = tag.c;
            androidx.compose.ui.graphics.l0 l0Var = null;
            if (list != null) {
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(androidx.compose.ui.graphics.l0.j(com.dragon.read.kmp.utils.j.b((String) it2.next(), og4.a.a.d().N0())));
                }
            } else {
                arrayList = null;
            }
            List list2 = tag.d;
            if (list2 != null) {
                arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                Iterator it4 = list2.iterator();
                while (it4.hasNext()) {
                    arrayList2.add(androidx.compose.ui.graphics.l0.j(com.dragon.read.kmp.utils.j.b((String) it4.next(), og4.a.a.d().N0())));
                }
            } else {
                arrayList2 = null;
            }
            String str3 = tag.e;
            startRestartGroup.startReplaceGroup(-752302649);
            if (str3 == null) {
                j = null;
            } else {
                j = androidx.compose.ui.graphics.l0.j(com.dragon.read.kmp.utils.j.b(str3, og4.a.a.h(startRestartGroup, og4.a.b).r()));
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-752303084);
            if (j == null) {
                x = og4.a.a.h(startRestartGroup, og4.a.b).r();
            } else {
                x = j.x();
            }
            startRestartGroup.endReplaceGroup();
            String str4 = tag.f;
            startRestartGroup.startReplaceGroup(-752299033);
            if (str4 != null) {
                l0Var = androidx.compose.ui.graphics.l0.j(com.dragon.read.kmp.utils.j.b(str4, og4.a.a.h(startRestartGroup, og4.a.b).r()));
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-752299592);
            if (l0Var == null) {
                x2 = og4.a.a.h(startRestartGroup, og4.a.b).r();
            } else {
                x2 = l0Var.x();
            }
            startRestartGroup.endReplaceGroup();
            og4.a aVar = og4.a.a;
            boolean d = com.dragon.read.kmp.service.d1.d(aVar.e(startRestartGroup, og4.a.b));
            long N0 = aVar.d().N0();
            if (d) {
                y = y(arrayList2, N0);
            } else {
                y = y(arrayList, N0);
            }
            float f = 4;
            Modifier s = androidx.compose.foundation.layout.f2.s(BackgroundKt.b(androidx.compose.ui.draw.e.a(SizeKt.i(Modifier.Companion, x0.i.g(16)), k.g.c(x0.i.g(f))), c0.a.d(androidx.compose.ui.graphics.c0.b, y, 0.0f, 0.0f, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null), x0.i.g(f), x0.i.g((float) 2.5d));
            androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
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
            g5.e(b2, i4, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            long h = x0.x.h(10);
            if (d) {
                j2 = x2;
            } else {
                j2 = x;
            }
            composer2 = startRestartGroup;
            a6.j(str2, (Modifier) null, j2, h, (androidx.compose.ui.text.font.y) null, new androidx.compose.ui.text.font.c0(500), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131026);
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
            endRestartGroup.a(new Function2() { // from class: cl4.l1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = n1.k(tag, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }

    public static final void l(final androidx.compose.foundation.layout.r rVar, final com.dragon.read.rpc.kmp.community.model.l1 tag, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        List list;
        List y;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Composer startRestartGroup = composer.startRestartGroup(-1913785456);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(tag)) {
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
                ComposerKt.traceEventStart(-1913785456, i2, -1, "com.dragon.read.kmp.profile.container.double_column.TopTag (VideoListItemReservation2Col.kt:284)");
            }
            og4.a aVar = og4.a.a;
            boolean d = com.dragon.read.kmp.service.d1.d(aVar.e(startRestartGroup, og4.a.b));
            float f = 8;
            float f2 = 0;
            Modifier a2 = androidx.compose.ui.draw.e.a(SizeKt.u(Modifier.Companion, x0.i.g(64), x0.i.g(20)), k.g.d(x0.i.g(f), x0.i.g(f2), x0.i.g(f), x0.i.g(f2)));
            c0.a aVar2 = androidx.compose.ui.graphics.c0.b;
            if (d) {
                list = tag.d;
            } else {
                list = tag.c;
            }
            if (list != null) {
                y = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    y.add(androidx.compose.ui.graphics.l0.j(com.dragon.read.kmp.utils.j.b((String) it2.next(), og4.a.a.d().N0())));
                }
            } else {
                y = y(CollectionsKt__CollectionsKt.emptyList(), aVar.d().N0());
            }
            Modifier s = androidx.compose.foundation.layout.f2.s(BackgroundKt.b(a2, c0.a.h(aVar2, y, 0L, 0L, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null), x0.i.g(f), x0.i.g(2));
            e.a aVar3 = androidx.compose.ui.e.a;
            Modifier b2 = rVar.b(s, aVar3.o());
            androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, b2);
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
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, i5, companion.c());
            g5.e(b3, currentCompositionLocalMap, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                b3.updateRememberedValue(Integer.valueOf(a3));
                b3.apply(Integer.valueOf(a3), b4);
            }
            g5.e(b3, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            String str = tag.b;
            if (str == null) {
                str = "";
            }
            composer2 = startRestartGroup;
            a6.j(str, boxScopeInstance.b(Modifier.Companion, aVar3.e()), og4.a.a.d().r(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, new androidx.compose.ui.text.font.c0(500), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131024);
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
            endRestartGroup.a(new Function2() { // from class: cl4.m1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m;
                    m = n1.m(rVar, tag, i, (Composer) obj, ((Integer) obj2).intValue());
                    return m;
                }
            });
        }
    }
}
