package com.dragon.read.kmp.reader.bookcover.epub;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u1;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
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
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.ui.util.ScreenUtils;
import com.dragon.read.kmp.reader.font.Font;
import com.dragon.read.kmp.reader.state.BookCoverViewModelKt;
import com.dragon.read.kmp.service.KmpFontServiceKt;
import com.dragon.read.reader.f1;
import com.dragon.read.reader.m3;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w {
    static {
        Covode.recordClassIndex(608273);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(e eVar, int i, Composer composer, int i2) {
        h(eVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(MutableState mutableState) {
        r(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final float B(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    private static final float i(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    private static final float j(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    private static final float l(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    private static final float n(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    private static final boolean p(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final float z(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    private static final void A(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    private static final void C(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    private static final void k(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    private static final void m(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    private static final void o(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    private static final void q(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    private static final void r(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(com.dragon.read.kmp.reader.state.a aVar, MutableState mutableState) {
        s0.a.c(aVar.a, "publishing_info_popup", "book_cover_page");
        r(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(com.dragon.read.kmp.reader.state.a aVar, MutableState mutableState) {
        s0.a.c(aVar.a, "author_profile", "copyright_info_page");
        r(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(com.dragon.read.kmp.reader.state.a aVar, MutableState mutableState) {
        s0.a.c(aVar.a, "publishing_house", "copyright_info_page");
        r(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MutableState mutableState, MutableState mutableState2, androidx.compose.ui.layout.w coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        long f = androidx.compose.ui.layout.x.f(coords);
        m(mutableState, Float.intBitsToFloat((int) (f >> 32)));
        o(mutableState2, Float.intBitsToFloat((int) (f & 4294967295L)));
        return Unit.INSTANCE;
    }

    public static final void h(final e event, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        MutableState mutableState;
        androidx.compose.ui.e o;
        int i3;
        String str;
        e.b k;
        final MutableState mutableState2;
        int i4;
        int i5;
        float g;
        int i6;
        final MutableState mutableState3;
        boolean z3;
        boolean changedInstance;
        int i7;
        Intrinsics.checkNotNullParameter(event, "event");
        Composer startRestartGroup = composer.startRestartGroup(815302755);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(event);
            } else {
                changedInstance = startRestartGroup.changedInstance(event);
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
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(815302755, i2, -1, "com.dragon.read.kmp.reader.bookcover.epub.EpubBookCoverBasicInfo (EpubBookCoverBasicInfo.kt:54)");
            }
            com.dragon.read.kmp.reader.state.b b = BookCoverViewModelKt.b(startRestartGroup, 0);
            final com.dragon.read.kmp.reader.state.a aVar = (com.dragon.read.kmp.reader.state.a) b.b.getValue();
            long x = ((androidx.compose.ui.graphics.l0) b.d.getValue()).x();
            am4.c cVar = (am4.c) startRestartGroup.consume(zl4.r.x());
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState5 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState8 = (MutableState) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
                MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue6 = mutableStateOf$default;
            }
            final MutableState mutableState9 = (MutableState) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == companion.getEmpty()) {
                MutableState mutableStateOf$default2 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default2);
                rememberedValue7 = mutableStateOf$default2;
            }
            MutableState mutableState10 = (MutableState) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            String str2 = aVar.o;
            if (str2 != null) {
                if (str2.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z2 = z3;
            } else {
                z2 = false;
            }
            Modifier.a aVar2 = Modifier.Companion;
            Modifier t = f2.t(IntrinsicKt.a(SizeKt.h(aVar2, 0.0f, 1, (Object) null), IntrinsicSize.Min), cVar.m, 0.0f, 2, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new Function1() { // from class: com.dragon.read.kmp.reader.bookcover.epub.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit s;
                        s = w.s(mutableState8, mutableState9, (androidx.compose.ui.layout.w) obj);
                        return s;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceGroup();
            Modifier a = androidx.compose.ui.layout.d1.a(t, (Function1) rememberedValue8);
            e.a aVar3 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 i8 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, a);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i8, companion2.c());
            g5.e(b2, currentCompositionLocalMap, companion2.e());
            Function2 b3 = companion2.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier h = SizeKt.h(aVar2, 0.0f, 1, (Object) null);
            androidx.compose.ui.layout.p0 b4 = r2.b(androidx.compose.foundation.layout.e.a.f(), aVar3.a(), startRestartGroup, 54);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, h);
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
            g5.e(b5, b4, companion2.c());
            g5.e(b5, currentCompositionLocalMap2, companion2.e());
            Function2 b6 = companion2.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a4))) {
                b5.updateRememberedValue(Integer.valueOf(a4));
                b5.apply(Integer.valueOf(a4), b6);
            }
            g5.e(b5, e2, companion2.d());
            w2 w2Var = w2.b;
            Modifier a6 = u2.a(w2Var, aVar2, 1.0f, false, 2, (Object) null);
            long j = cVar.p;
            long j2 = cVar.q;
            String d = am4.a.d(aVar);
            String c = am4.a.c(aVar);
            String b7 = am4.a.b(aVar);
            Font font = Font.FZShengShiKaiShuS_DB_GB;
            int i9 = i2;
            wg4.c.c(a6, j, j2, d, c, b7, x, (androidx.compose.ui.text.font.j) KmpFontServiceKt.a(font.getFontFamily(), startRestartGroup, 0).getValue(), aVar3.k(), (Function0) null, startRestartGroup, 100663296, MediaPlayer.MEDIA_PLAYER_OPTION_APPID);
            startRestartGroup.startReplaceGroup(-682839573);
            ScreenUtils screenUtils = ScreenUtils.a;
            if (!screenUtils.i(ig4.f.a(startRestartGroup, 0))) {
                androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.x(SizeKt.d(f2.v(aVar2, 0.0f, 0.0f, x0.i.g(10), 0.0f, 11, (Object) null), 0.0f, 1, (Object) null), x0.i.g((float) 0.5d)), androidx.compose.ui.graphics.l0.n(x, 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            String str3 = "";
            if (z2) {
                startRestartGroup.startReplaceGroup(307180324);
                Modifier d2 = SizeKt.d(u2.a(w2Var, aVar2, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
                String str4 = aVar.o;
                if (str4 == null) {
                    str4 = "";
                }
                String str5 = aVar.p;
                if (str5 == null) {
                    str5 = "";
                }
                boolean i10 = screenUtils.i(ig4.f.a(startRestartGroup, 0));
                startRestartGroup.startReplaceGroup(-1224400529);
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (rememberedValue9 == companion.getEmpty()) {
                    mutableState3 = mutableState5;
                    rememberedValue9 = new Function4() { // from class: com.dragon.read.kmp.reader.bookcover.epub.q
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            Unit t2;
                            t2 = w.t(mutableState4, mutableState3, mutableState6, mutableState7, ((Float) obj).floatValue(), ((Float) obj2).floatValue(), ((Float) obj3).floatValue(), ((Float) obj4).floatValue());
                            return t2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                } else {
                    mutableState3 = mutableState5;
                }
                startRestartGroup.endReplaceGroup();
                mutableState = mutableState3;
                c.c(d2, str4, str5, i10, (Function4) rememberedValue9, startRestartGroup, 24576, 0);
                startRestartGroup.endReplaceGroup();
                i3 = 0;
            } else {
                mutableState = mutableState5;
                startRestartGroup.startReplaceGroup(307757730);
                qm4.a a7 = cm4.m.a(startRestartGroup, 0);
                String str6 = aVar.a;
                if (str6 == null) {
                    str6 = "";
                }
                Function2<Composer, Integer, Unit> b8 = a7.b(str6);
                Modifier a8 = u2.a(w2Var, aVar2, 1.0f, false, 2, (Object) null);
                if (cVar.f) {
                    o = aVar3.e();
                } else {
                    o = aVar3.o();
                }
                androidx.compose.ui.layout.p0 i11 = androidx.compose.foundation.layout.m.i(o, false);
                int a9 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(startRestartGroup, a8);
                Function0 a10 = companion2.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a10);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b9 = g5.b(startRestartGroup);
                g5.e(b9, i11, companion2.c());
                g5.e(b9, currentCompositionLocalMap3, companion2.e());
                Function2 b10 = companion2.b();
                if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a9))) {
                    b9.updateRememberedValue(Integer.valueOf(a9));
                    b9.apply(Integer.valueOf(a9), b10);
                }
                g5.e(b9, e3, companion2.d());
                startRestartGroup.startReplaceGroup(-1088908896);
                i3 = 0;
                if (b8 != null) {
                    b8.invoke(startRestartGroup, 0);
                    Unit unit = Unit.INSTANCE;
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceGroup();
            }
            startRestartGroup.startReplaceGroup(-682795093);
            if (!screenUtils.i(ig4.f.a(startRestartGroup, i3))) {
                androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.x(SizeKt.d(f2.v(aVar2, 0.0f, 0.0f, x0.i.g(10), 0.0f, 11, (Object) null), 0.0f, 1, (Object) null), x0.i.g((float) 0.5d)), androidx.compose.ui.graphics.l0.n(x, 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            Modifier a11 = u2.a(w2Var, aVar2, 1.0f, false, 2, (Object) null);
            long j3 = cVar.p;
            long j4 = cVar.q;
            String f = am4.a.f(aVar);
            String e4 = am4.a.e(aVar);
            String str7 = aVar.n;
            if (StringsKt__StringsKt.isBlank(str7)) {
                String str8 = aVar.j;
                if (str8 != null) {
                    str3 = str8;
                }
                str = str3;
            } else {
                str = str7;
            }
            long x2 = ((androidx.compose.ui.graphics.l0) b.d.getValue()).x();
            androidx.compose.ui.text.font.j jVar = (androidx.compose.ui.text.font.j) KmpFontServiceKt.a(font.getFontFamily(), startRestartGroup, 0).getValue();
            if (screenUtils.i(ig4.f.a(startRestartGroup, 0))) {
                k = aVar3.j();
            } else {
                k = aVar3.k();
            }
            e.b bVar = k;
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance2 = startRestartGroup.changedInstance(aVar);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (!changedInstance2 && rememberedValue10 != companion.getEmpty()) {
                mutableState2 = mutableState10;
            } else {
                mutableState2 = mutableState10;
                rememberedValue10 = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit u;
                        u = w.u(com.dragon.read.kmp.reader.state.a.this, mutableState2);
                        return u;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            startRestartGroup.endReplaceGroup();
            wg4.c.c(a11, j3, j4, f, e4, str, x2, jVar, bVar, (Function0) rememberedValue10, startRestartGroup, 0, 0);
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(209295623);
            if (z2 && i(mutableState4) > 0.0f) {
                x0.e eVar = (x0.e) startRestartGroup.consume(CompositionLocalsKt.f());
                float w1 = eVar.w1((i(mutableState4) - l(mutableState8)) + B(mutableState6));
                if (cVar.f) {
                    i4 = -7;
                } else {
                    i4 = -10;
                }
                float g2 = x0.i.g(w1 + x0.i.g(i4));
                float w12 = eVar.w1((z(mutableState) - n(mutableState9)) + j(mutableState7));
                if (cVar.f) {
                    i5 = 38;
                } else {
                    i5 = 32;
                }
                float g3 = x0.i.g(w12 - x0.i.g(i5));
                if (cVar.f) {
                    g = x0.i.g(24);
                    i6 = 40;
                } else {
                    g = x0.i.g(20);
                    i6 = 34;
                }
                androidx.compose.foundation.z0.c(org.jetbrains.compose.resources.c.b(f1.g(m3.a), startRestartGroup, 0), (String) null, SizeKt.t(u1.e(boxScopeInstance.b(aVar2, aVar3.o()), g2, g3), x0.j.a(g, x0.i.g(i6))), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, startRestartGroup, 48, 120);
            }
            startRestartGroup.endReplaceGroup();
            boolean p = p(mutableState2);
            startRestartGroup.startReplaceGroup(5004770);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == companion.getEmpty()) {
                rememberedValue11 = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit v;
                        v = w.v(mutableState2);
                        return v;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            Function0 function0 = (Function0) rememberedValue11;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance3 = startRestartGroup.changedInstance(aVar);
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue12 == companion.getEmpty()) {
                rememberedValue12 = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit w;
                        w = w.w(com.dragon.read.kmp.reader.state.a.this, mutableState2);
                        return w;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            Function0 function02 = (Function0) rememberedValue12;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance4 = startRestartGroup.changedInstance(aVar);
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue13 == companion.getEmpty()) {
                rememberedValue13 = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit x3;
                        x3 = w.x(com.dragon.read.kmp.reader.state.a.this, mutableState2);
                        return x3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            o.e(p, function0, function02, (Function0) rememberedValue13, event, startRestartGroup, ((i9 << 12) & 57344) | 48, 0);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.bookcover.epub.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit y;
                    y = w.y(e.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return y;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, float f, float f2, float f3, float f4) {
        q(mutableState, f);
        A(mutableState2, f2);
        C(mutableState3, f3);
        k(mutableState4, f4);
        return Unit.INSTANCE;
    }
}
