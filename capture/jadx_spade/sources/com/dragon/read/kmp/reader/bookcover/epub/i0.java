package com.dragon.read.kmp.reader.bookcover.epub;

import android.content.Context;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t2;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.ui.util.ScreenUtils;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.reader.bookcover.InsertState;
import com.dragon.read.kmp.reader.bookcover.epub.i0;
import com.dragon.read.kmp.reader.font.Font;
import com.dragon.read.kmp.reader.state.BookCoverViewModelKt;
import com.dragon.read.kmp.service.KmpFontServiceKt;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w0.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i0 {
    private static final com.dragon.read.kmp.i a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(e eVar, Function1 function1, int i, Composer composer, int i2) {
        j(eVar, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(e eVar, Function1 function1, int i, Composer composer, int i2) {
        j(eVar, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(e eVar, Function1 function1, int i, Composer composer, int i2) {
        j(eVar, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(e eVar, Function1 function1, int i, Composer composer, int i2) {
        j(eVar, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(e eVar, int i, Composer composer, int i2) {
        q(eVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(e eVar, Function1 function1, Function3 function3, int i, Composer composer, int i2) {
        s(eVar, function1, function3, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(608274);
        a = new com.dragon.read.kmp.i("BookCover-UI");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(e eVar) {
        eVar.c();
        return Unit.INSTANCE;
    }

    static final class c implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Context a;
        final /* synthetic */ com.dragon.read.kmp.reader.state.a b;
        final /* synthetic */ com.dragon.read.kmp.reader.state.b c;
        final /* synthetic */ e d;
        final /* synthetic */ MutableState<Float> e;
        final /* synthetic */ MutableState<Float> f;

        c(Context context, com.dragon.read.kmp.reader.state.a aVar, com.dragon.read.kmp.reader.state.b bVar, e eVar, MutableState<Float> mutableState, MutableState<Float> mutableState2) {
            this.a = context;
            this.b = aVar;
            this.c = bVar;
            this.d = eVar;
            this.e = mutableState;
            this.f = mutableState2;
        }

        static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
            final /* synthetic */ boolean a;
            final /* synthetic */ Context b;
            final /* synthetic */ com.dragon.read.kmp.reader.state.a c;
            final /* synthetic */ com.dragon.read.kmp.reader.state.b d;
            final /* synthetic */ e e;
            final /* synthetic */ MutableState<Float> f;
            final /* synthetic */ MutableState<Float> g;

            a(boolean z, Context context, com.dragon.read.kmp.reader.state.a aVar, com.dragon.read.kmp.reader.state.b bVar, e eVar, MutableState<Float> mutableState, MutableState<Float> mutableState2) {
                this.a = z;
                this.b = context;
                this.c = aVar;
                this.d = bVar;
                this.e = eVar;
                this.f = mutableState;
                this.g = mutableState2;
            }

            /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.i0$c$a$a, reason: collision with other inner class name */
            static final class C0041a implements Function2<Composer, Integer, Unit> {
                final /* synthetic */ com.dragon.read.kmp.reader.state.b a;
                final /* synthetic */ com.dragon.read.kmp.reader.state.a b;
                final /* synthetic */ androidx.compose.foundation.layout.v c;
                final /* synthetic */ boolean d;
                final /* synthetic */ am4.c e;
                final /* synthetic */ e f;
                final /* synthetic */ long g;
                final /* synthetic */ MutableState<Float> h;
                final /* synthetic */ MutableState<Float> i;

                C0041a(com.dragon.read.kmp.reader.state.b bVar, com.dragon.read.kmp.reader.state.a aVar, androidx.compose.foundation.layout.v vVar, boolean z, am4.c cVar, e eVar, long j, MutableState<Float> mutableState, MutableState<Float> mutableState2) {
                    this.a = bVar;
                    this.b = aVar;
                    this.c = vVar;
                    this.d = z;
                    this.e = cVar;
                    this.f = eVar;
                    this.g = j;
                    this.h = mutableState;
                    this.i = mutableState2;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit i(com.dragon.read.kmp.reader.state.a aVar) {
                    boolean z;
                    dm4.h navigatorDepend;
                    s0.a.c(aVar.a, "author_profile", "book_cover_page");
                    String str = aVar.d;
                    if (str != null && str.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z && (navigatorDepend = xf4.d.o3.a().navigatorDepend()) != null) {
                        navigatorDepend.b("dragon1967://profile?user_id=" + str);
                    }
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit h(e eVar, boolean z) {
                    eVar.f(z);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit g(e eVar, a0.h rect) {
                    Intrinsics.checkNotNullParameter(rect, "rect");
                    eVar.h(rect);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit j(MutableState mutableState, float f) {
                    mutableState.setValue(Float.valueOf(f));
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    f(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit k(MutableState mutableState, androidx.compose.ui.layout.w coordinates) {
                    Intrinsics.checkNotNullParameter(coordinates, "coordinates");
                    mutableState.setValue(Float.valueOf(Float.intBitsToFloat((int) (androidx.compose.ui.layout.x.g(coordinates) & 4294967295L))));
                    return Unit.INSTANCE;
                }

                public final void f(Composer composer, int i) {
                    boolean z;
                    boolean z2;
                    x0.i iVar;
                    float f;
                    int i2;
                    int i3;
                    boolean z3;
                    float g;
                    x0.i d;
                    float g2;
                    if ((i & 3) != 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composer.shouldExecute(z, i & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1824569918, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.FirstBookCoverKmpView.<anonymous>.<anonymous>.<anonymous> (FirstBookCoverKmpView.kt:145)");
                        }
                        long x = ((androidx.compose.ui.graphics.l0) this.a.d.getValue()).x();
                        long x2 = ((androidx.compose.ui.graphics.l0) this.a.f.getValue()).x();
                        Modifier.a aVar = Modifier.Companion;
                        androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.f(aVar, 0.0f, 1, (Object) null), x2, (f2) null, 2, (Object) null), composer, 0);
                        composer.startReplaceGroup(-1065022731);
                        if (this.b.s.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            String str = this.b.s;
                            com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                            nVar.c = 200;
                            nVar.a(com.bytedance.kmp.image.options.l.b.a());
                            Unit unit = Unit.INSTANCE;
                            iVar = null;
                            f = 0.0f;
                            LoadImageKt.g(str, "cover-bg-texture", nVar, this.c.b(AspectRatioKt.b(SizeKt.h(aVar, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), androidx.compose.ui.e.a.m()), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, composer, 48, 112);
                        } else {
                            iVar = null;
                            f = 0.0f;
                        }
                        composer.endReplaceGroup();
                        Modifier f2 = SizeKt.f(aVar, f, 1, iVar);
                        e.a aVar2 = androidx.compose.ui.e.a;
                        e.b g3 = aVar2.g();
                        am4.c cVar = this.e;
                        final com.dragon.read.kmp.reader.state.a aVar3 = this.b;
                        long j = this.g;
                        final e eVar = this.f;
                        final MutableState<Float> mutableState = this.h;
                        androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), g3, composer, 48);
                        int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                        androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                        Modifier e = ComposedModifierKt.e(composer, f2);
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
                        a3.a(SizeKt.i(aVar, cVar.h), composer, 0);
                        String str2 = aVar3.f;
                        Modifier b3 = AspectRatioKt.b(SizeKt.i(SizeKt.x(aVar, x0.l.h(j)), x0.i.g(x0.l.g(j) + x0.i.g(20))), 0.6796875f, false, 2, iVar);
                        composer.startReplaceGroup(5004770);
                        boolean changedInstance = composer.changedInstance(eVar);
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function1() { // from class: com.dragon.read.kmp.reader.bookcover.epub.j0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit g4;
                                    g4 = i0.c.a.C0041a.g(e.this, (a0.h) obj);
                                    return g4;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        Function1 function1 = (Function1) rememberedValue;
                        composer.endReplaceGroup();
                        composer.startReplaceGroup(5004770);
                        boolean changedInstance2 = composer.changedInstance(eVar);
                        Object rememberedValue2 = composer.rememberedValue();
                        if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.reader.bookcover.epub.k0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit h;
                                    h = i0.c.a.C0041a.h(e.this, ((Boolean) obj).booleanValue());
                                    return h;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue2);
                        }
                        composer.endReplaceGroup();
                        bm4.h0.c(str2, b3, function1, (Function1) rememberedValue2, composer, 0, 0);
                        Modifier g4 = SizeKt.g(aVar, 0.7f);
                        androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
                        int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                        androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                        Modifier e2 = ComposedModifierKt.e(composer, g4);
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
                        Composer b4 = g5.b(composer);
                        g5.e(b4, i4, companion.c());
                        g5.e(b4, currentCompositionLocalMap2, companion.e());
                        Function2 b5 = companion.b();
                        if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                            b4.updateRememberedValue(Integer.valueOf(a4));
                            b4.apply(Integer.valueOf(a4), b5);
                        }
                        g5.e(b4, e2, companion.d());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                        String str3 = aVar3.b;
                        String str4 = "";
                        if (str3 == null) {
                            str3 = "";
                        }
                        long j2 = cVar.v;
                        long h = x0.x.h(32);
                        androidx.compose.ui.text.font.c0 d2 = androidx.compose.ui.text.font.c0.b.d();
                        int b6 = w0.s.b.b();
                        h.a aVar4 = w0.h.b;
                        int a6 = aVar4.a();
                        androidx.compose.ui.text.font.j jVar = (androidx.compose.ui.text.font.j) KmpFontServiceKt.a(Font.HUIWEN_MINCHO.getFontFamily(), composer, 0).getValue();
                        String str5 = aVar3.b;
                        if (str5 != null) {
                            i2 = str5.length();
                        } else {
                            i2 = 0;
                        }
                        if (i2 <= 4) {
                            i3 = 8;
                        } else {
                            i3 = 2;
                        }
                        x0.i iVar2 = iVar;
                        a6.j(str3, (Modifier) null, x, j2, (androidx.compose.ui.text.font.y) null, d2, jVar, 0L, (w0.i) null, w0.h.h(a6), h, b6, false, 2, 0, (Function1) null, new g3(0L, 0L, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, x0.x.h(i3), (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777087, (DefaultConstructorMarker) null), composer, 196608, 3126, 53650);
                        composer.endNode();
                        a3.a(SizeKt.i(aVar, cVar.u), composer, 0);
                        if (StringUtilsKt.a(aVar3.c)) {
                            str4 = aVar3.c + " 著";
                        }
                        long h2 = x0.x.h(16);
                        long n = androidx.compose.ui.graphics.l0.n(x, 0.75f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        int a7 = aVar4.a();
                        Modifier a8 = androidx.compose.ui.draw.a.a(aVar, 0.6f);
                        String str6 = aVar3.c;
                        if (str6 != null && str6.length() != 0) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        boolean z4 = !z3;
                        composer.startReplaceGroup(5004770);
                        boolean changedInstance3 = composer.changedInstance(aVar3);
                        Object rememberedValue3 = composer.rememberedValue();
                        if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.l0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit i5;
                                    i5 = i0.c.a.C0041a.i(com.dragon.read.kmp.reader.state.a.this);
                                    return i5;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue3);
                        }
                        composer.endReplaceGroup();
                        a6.j(str4, ClickableKt.clickable-oSLSa3U$default(a8, z4, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 14, (Object) null), n, h2, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) KmpFontServiceKt.a(Font.FZShengShiKaiShuS_DB_GB.getFontFamily(), composer, 0).getValue(), 0L, (w0.i) null, w0.h.h(a7), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 130480);
                        a3.a(SizeKt.i(aVar, cVar.i), composer, 0);
                        w.h(eVar, composer, 0);
                        a3.a(SizeKt.i(aVar, cVar.j), composer, 0);
                        composer.startReplaceGroup(5004770);
                        Object rememberedValue4 = composer.rememberedValue();
                        Composer.Companion companion2 = Composer.Companion;
                        if (rememberedValue4 == companion2.getEmpty()) {
                            rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.reader.bookcover.epub.m0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit j3;
                                    j3 = i0.c.a.C0041a.j(mutableState, ((Float) obj).floatValue());
                                    return j3;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue4);
                        }
                        composer.endReplaceGroup();
                        i0.j(eVar, (Function1) rememberedValue4, composer, 48);
                        composer.endNode();
                        Context a9 = com.dragon.read.kmp.util.kotlin.b.a();
                        composer.startReplaceGroup(-1064884710);
                        if (a9 == null) {
                            d = iVar2;
                        } else {
                            ScreenUtils screenUtils = ScreenUtils.a;
                            int c = screenUtils.c(a9);
                            composer.startReplaceGroup(-1064881008);
                            if (c > 0) {
                                g = screenUtils.j(c, composer, ScreenUtils.b << 3);
                            } else {
                                g = x0.i.g(12);
                            }
                            composer.endReplaceGroup();
                            d = x0.i.d(g);
                        }
                        composer.endReplaceGroup();
                        if (d != null) {
                            g2 = d.m();
                        } else {
                            g2 = x0.i.g(12);
                        }
                        Modifier v = androidx.compose.foundation.layout.f2.v(this.c.b(aVar, aVar2.b()), 0.0f, 0.0f, 0.0f, g2, 7, (Object) null);
                        composer.startReplaceGroup(5004770);
                        final MutableState<Float> mutableState2 = this.i;
                        Object rememberedValue5 = composer.rememberedValue();
                        if (rememberedValue5 == companion2.getEmpty()) {
                            rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.reader.bookcover.epub.n0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit k;
                                    k = i0.c.a.C0041a.k(mutableState2, (androidx.compose.ui.layout.w) obj);
                                    return k;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue5);
                        }
                        composer.endReplaceGroup();
                        Modifier a10 = androidx.compose.ui.layout.d1.a(v, (Function1) rememberedValue5);
                        androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                        int a11 = j.a(androidx.compose.runtime.i.b(composer, 0));
                        androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                        Modifier e3 = ComposedModifierKt.e(composer, a10);
                        Function0 a12 = companion.a();
                        if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                            androidx.compose.runtime.i.d();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(a12);
                        } else {
                            composer.useNode();
                        }
                        Composer b7 = g5.b(composer);
                        g5.e(b7, i5, companion.c());
                        g5.e(b7, currentCompositionLocalMap3, companion.e());
                        Function2 b8 = companion.b();
                        if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a11))) {
                            b7.updateRememberedValue(Integer.valueOf(a11));
                            b7.apply(Integer.valueOf(a11), b8);
                        }
                        g5.e(b7, e3, companion.d());
                        bm4.r0.c(composer, 0);
                        composer.endNode();
                        composer.startReplaceGroup(-1064862301);
                        if (this.d) {
                            bm4.o0.c(x2, this.c.b(aVar, aVar2.f()), false, composer, 384, 0);
                        }
                        composer.endReplaceGroup();
                        Modifier b9 = this.c.b(aVar, aVar2.n());
                        am4.c cVar2 = this.e;
                        bm4.l0.c(androidx.compose.foundation.layout.f2.v(b9, 0.0f, cVar2.l, cVar2.k, 0.0f, 9, (Object) null), this.f, composer, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
                a(vVar, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void a(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
                int i2;
                boolean z;
                boolean z2;
                int i3;
                Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                if ((i & 6) == 0) {
                    if (composer.changed(BoxWithConstraints)) {
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
                        ComposerKt.traceEventStart(1071915266, i2, -1, "com.dragon.read.kmp.reader.bookcover.epub.FirstBookCoverKmpView.<anonymous>.<anonymous> (FirstBookCoverKmpView.kt:125)");
                    }
                    Pair<Boolean, x0.l> x = i0.x(BoxWithConstraints.g(), BoxWithConstraints.f(), composer, 0);
                    boolean booleanValue = x.component1().booleanValue();
                    long l = x.component2().l();
                    float g = BoxWithConstraints.g();
                    float f = BoxWithConstraints.f();
                    composer.startReplaceGroup(-1224400529);
                    boolean changed = composer.changed(g) | composer.changed(this.a) | composer.changed(booleanValue) | composer.changed(f);
                    Context context = this.b;
                    boolean z3 = this.a;
                    com.dragon.read.kmp.reader.state.a aVar = this.c;
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        if (z3 && !aVar.y) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        rememberedValue = new am4.c(context, z2, BoxWithConstraints.g(), BoxWithConstraints.f(), booleanValue, false, false, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, 0L, 0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0.0f, 8388576, null);
                        i0.a.a("刷新间距参数 isMiniScreen=" + booleanValue + ", isInSplitMode=" + z3 + " space:" + rememberedValue);
                        composer.updateRememberedValue(rememberedValue);
                    }
                    am4.c cVar = (am4.c) rememberedValue;
                    composer.endReplaceGroup();
                    androidx.compose.runtime.d0.c(zl4.r.x().provides(cVar), androidx.compose.runtime.internal.t.e(-1824569918, true, new C0041a(this.d, this.c, BoxWithConstraints, this.a, cVar, this.e, l, this.f, this.g), composer, 54), composer, t2.i | 48);
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
                    ComposerKt.traceEventStart(154954540, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.FirstBookCoverKmpView.<anonymous> (FirstBookCoverKmpView.kt:122)");
                }
                androidx.compose.foundation.layout.u.c(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), (androidx.compose.ui.e) null, false, androidx.compose.runtime.internal.t.e(1071915266, true, new a(((Boolean) composer.consume(zl4.r.z())).booleanValue(), this.a, this.b, this.c, this.d, this.e, this.f), composer, 54), composer, 3078, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class a implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
        final /* synthetic */ e a;

        a(e eVar) {
            this.a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(e eVar, com.dragon.read.kmp.reader.state.i item) {
            Intrinsics.checkNotNullParameter(item, "item");
            eVar.g(item);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(e eVar, com.dragon.read.kmp.reader.state.i item) {
            Intrinsics.checkNotNullParameter(item, "item");
            eVar.e(item);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
            c(rVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void c(androidx.compose.foundation.layout.r PagerBox, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(PagerBox, "$this$PagerBox");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1842004436, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.BookCoverPager.<anonymous> (FirstBookCoverKmpView.kt:343)");
                }
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(this.a);
                final e eVar = this.a;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.reader.bookcover.epub.g0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit d;
                            d = i0.a.d(e.this, (com.dragon.read.kmp.reader.state.i) obj);
                            return d;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function1 function1 = (Function1) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(5004770);
                boolean changedInstance2 = composer.changedInstance(this.a);
                final e eVar2 = this.a;
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.reader.bookcover.epub.h0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit e;
                            e = i0.a.e(e.this, (com.dragon.read.kmp.reader.state.i) obj);
                            return e;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                HotlinePagerKt.d(function1, (Function1) rememberedValue2, composer, 0);
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
    public static final Unit l(Function1 function1, androidx.compose.ui.layout.w coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        function1.invoke(Float.valueOf(Float.intBitsToFloat((int) (androidx.compose.ui.layout.x.g(coordinates) & 4294967295L)) + ((int) (coordinates.a() & 4294967295L))));
        return Unit.INSTANCE;
    }

    static final class b implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> a;

        b(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.a = function2;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
            a(rVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r PagerBox, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(PagerBox, "$this$PagerBox");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2089496362, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.BookCoverPager.<anonymous> (FirstBookCoverKmpView.kt:360)");
                }
                Function2<Composer, Integer, Unit> function2 = this.a;
                if (function2 != null) {
                    function2.invoke(composer, 0);
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
    public static final Unit t(e eVar, Function1 function1, androidx.compose.ui.layout.w coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        long e = androidx.compose.ui.layout.x.e(coordinates);
        int i = (int) (e >> 32);
        int i2 = (int) (e & 4294967295L);
        a0.h hVar = new a0.h(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat(i) + ((int) (coordinates.a() >> 32)), Float.intBitsToFloat(i2) + ((int) (coordinates.a() & 4294967295L)));
        for (androidx.compose.ui.layout.w W = coordinates.W(); W != null && W.W() != null; W = W.W()) {
            long e2 = androidx.compose.ui.layout.x.e(W);
            hVar = hVar.s(Float.intBitsToFloat((int) (e2 >> 32)), Float.intBitsToFloat((int) (e2 & 4294967295L)));
        }
        eVar.a(hVar);
        function1.invoke(Float.valueOf(Float.intBitsToFloat((int) (androidx.compose.ui.layout.x.g(coordinates) & 4294967295L)) + ((int) (coordinates.a() & 4294967295L))));
        return Unit.INSTANCE;
    }

    public static final void q(final e event, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean changedInstance;
        int i3;
        Intrinsics.checkNotNullParameter(event, "event");
        Composer startRestartGroup = composer.startRestartGroup(-169279747);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(event);
            } else {
                changedInstance = startRestartGroup.changedInstance(event);
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
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-169279747, i2, -1, "com.dragon.read.kmp.reader.bookcover.epub.FirstBookCoverKmpView (FirstBookCoverKmpView.kt:114)");
            }
            com.dragon.read.kmp.reader.state.b b2 = BookCoverViewModelKt.b(startRestartGroup, 0);
            com.dragon.read.kmp.reader.state.a aVar = (com.dragon.read.kmp.reader.state.a) b2.b.getValue();
            Context a2 = com.dragon.read.kmp.util.kotlin.b.a();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            com.dragon.read.kmp.reader.state.t.f(androidx.compose.runtime.internal.t.e(154954540, true, new c(a2, aVar, b2, event, (MutableState) rememberedValue2, mutableState), startRestartGroup, 54), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.bookcover.epub.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit r;
                    r = i0.r(e.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return r;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final e eVar, final Function1<? super Float, Unit> function1, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        boolean changedInstance;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(1234306900);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(eVar);
            } else {
                changedInstance = startRestartGroup.changedInstance(eVar);
            }
            if (changedInstance) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        boolean z3 = false;
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1234306900, i2, -1, "com.dragon.read.kmp.reader.bookcover.epub.BookCoverPager (FirstBookCoverKmpView.kt:329)");
            }
            com.dragon.read.kmp.reader.state.a aVar = (com.dragon.read.kmp.reader.state.a) BookCoverViewModelKt.c(startRestartGroup, 0).getValue();
            String str = aVar.a;
            if (str == null) {
                str = "";
            }
            if (!am4.b.a(aVar.u)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.bookcover.epub.y
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit o;
                            o = i0.o(e.this, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                            return o;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(757968240);
            if (aVar.c()) {
                eVar.d();
                s(eVar, function1, androidx.compose.runtime.internal.t.e(1842004436, true, new a(eVar), startRestartGroup, 54), startRestartGroup, (i2 & 112) | (i2 & 14) | 384);
                startRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.reader.bookcover.epub.z
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit p;
                            p = i0.p(e.this, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                            return p;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.endReplaceGroup();
            Pair<Function2<Composer, Integer, Unit>, State<InsertState>> c2 = cm4.m.a(startRestartGroup, 0).c(str);
            Function2<Composer, Integer, Unit> component1 = c2.component1();
            State<InsertState> component2 = c2.component2();
            if (component2.getValue() == InsertState.LOADING) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup3 = startRestartGroup.endRestartGroup();
                if (endRestartGroup3 != null) {
                    endRestartGroup3.a(new Function2() { // from class: com.dragon.read.kmp.reader.bookcover.epub.a0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit k;
                            k = i0.k(e.this, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                            return k;
                        }
                    });
                    return;
                }
                return;
            }
            if (component2.getValue() == InsertState.INSERT) {
                startRestartGroup.startReplaceGroup(2022712565);
                eVar.d();
                s(eVar, function1, androidx.compose.runtime.internal.t.e(-2089496362, true, new b(component1), startRestartGroup, 54), startRestartGroup, (i2 & 112) | (i2 & 14) | 384);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(2022853150);
                eVar.d();
                Modifier b2 = SizeKt.b(androidx.compose.foundation.layout.f2.v(androidx.compose.foundation.layout.f2.t(Modifier.Companion, x0.i.g(20), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(60), 7, (Object) null), 0.0f, x0.i.g(156), 1, (Object) null);
                startRestartGroup.startReplaceGroup(5004770);
                if ((i2 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.reader.bookcover.epub.b0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit l;
                            l = i0.l(Function1.this, (androidx.compose.ui.layout.w) obj);
                            return l;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a2 = androidx.compose.ui.layout.d1.a(b2, (Function1) rememberedValue);
                startRestartGroup.startReplaceGroup(5004770);
                if ((i2 & 14) == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(eVar))) {
                    z3 = true;
                }
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.c0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit m;
                            m = i0.m(e.this);
                            return m;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                bm4.o.n(a2, "book_cover_page", (Function0) rememberedValue2, false, null, startRestartGroup, 48, 24);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup4 = startRestartGroup.endRestartGroup();
        if (endRestartGroup4 != null) {
            endRestartGroup4.a(new Function2() { // from class: com.dragon.read.kmp.reader.bookcover.epub.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n;
                    n = i0.n(e.this, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return n;
                }
            });
        }
    }

    public static final Pair<Boolean, x0.l> x(float f, float f2, Composer composer, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        x0.i maxOf;
        x0.i maxOf2;
        long j;
        composer.startReplaceGroup(-559793276);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-559793276, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.rememberIsMiniScreen (FirstBookCoverKmpView.kt:70)");
        }
        Context a2 = ig4.f.a(composer, 0);
        boolean booleanValue = ((Boolean) composer.consume(zl4.r.z())).booleanValue();
        composer.startReplaceGroup(-1746271574);
        if ((((i & 112) ^ 48) > 32 && composer.changed(f2)) || (i & 48) == 32) {
            z = true;
        } else {
            z = false;
        }
        if ((((i & 14) ^ 6) > 4 && composer.changed(f)) || (i & 6) == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean changed = z2 | z | composer.changed(booleanValue);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            am4.c cVar = new am4.c(a2, booleanValue, f, f2, false, false, false, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, 0L, 0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0.0f, 8388576, null);
            float g = x0.i.g(x0.i.g(x0.i.g(x0.i.g(x0.i.g(x0.i.g(x0.i.g(x0.i.g(x0.i.g(cVar.h + x0.l.g(cVar.a())) + x0.i.g(20)) + x0.i.g(102)) + cVar.i) + x0.i.g(53)) + cVar.j) + cVar.r) + x0.i.g(12)) + x0.i.g(55));
            if (x0.i.f(f2, g) < 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                j = cVar.a();
            } else {
                long a3 = cVar.a();
                maxOf = ComparisonsKt___ComparisonsJvmKt.maxOf(x0.i.d(x0.i.g(x0.i.g(g - f2) - x0.i.g(x0.i.g(x0.i.g(cVar.i + cVar.j) + cVar.r) / 2))), x0.i.d(x0.i.g(0)));
                maxOf2 = ComparisonsKt___ComparisonsJvmKt.maxOf(x0.i.d(x0.i.g(x0.l.g(a3) - maxOf.m())), x0.i.d(x0.i.g(x0.l.g(a3) * 0.4f)));
                float m = maxOf2.m() / x0.l.g(a3);
                a.a("封面缩放比例：ratio：" + m);
                j = x0.l.j(cVar.a(), m);
            }
            a.a("容器框高变化，重新计算是否为小屏模式, contentHeight=" + ((Object) x0.i.l(g)) + ", containerHeight=" + ((Object) x0.i.l(f2)) + " isMiniScreen=" + z3);
            Pair pair = new Pair(Boolean.valueOf(z3), x0.l.c(j));
            composer.updateRememberedValue(pair);
            rememberedValue = pair;
        }
        Pair<Boolean, x0.l> pair2 = (Pair) rememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return pair2;
    }

    private static final void s(final e eVar, final Function1<? super Float, Unit> function1, final Function3<? super androidx.compose.foundation.layout.r, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        boolean changedInstance;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(713732545);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(eVar);
            } else {
                changedInstance = startRestartGroup.changedInstance(eVar);
            }
            if (changedInstance) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(function3)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        boolean z3 = true;
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(713732545, i2, -1, "com.dragon.read.kmp.reader.bookcover.epub.PagerBox (FirstBookCoverKmpView.kt:294)");
            }
            Modifier h = SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i2 & 14) != 4 && ((i2 & 8) == 0 || !startRestartGroup.changedInstance(eVar))) {
                z2 = false;
            } else {
                z2 = true;
            }
            if ((i2 & 112) != 32) {
                z3 = false;
            }
            boolean z4 = z2 | z3;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.reader.bookcover.epub.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit t;
                        t = i0.t(e.this, function1, (androidx.compose.ui.layout.w) obj);
                        return t;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier a2 = androidx.compose.ui.layout.d1.a(h, (Function1) rememberedValue);
            androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, a2);
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
            g5.e(b2, i6, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion.d());
            function3.invoke(BoxScopeInstance.a, startRestartGroup, Integer.valueOf(((i2 >> 3) & 112) | 6));
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.bookcover.epub.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u;
                    u = i0.u(e.this, function1, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                    return u;
                }
            });
        }
    }
}
