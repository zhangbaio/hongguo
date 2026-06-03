package com.dragon.read.kmp.shortvideo.distribution.page.search;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.gestures.s2;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.lazy.y0;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.v2;
import androidx.compose.foundation.y1;
import androidx.compose.foundation.z0;
import androidx.compose.material.a3;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.g2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.u2;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.input.b1;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.ui.util.ScreenUtils;
import com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchPageKt;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesRankSearchPageKt {
    static {
        Covode.recordClassIndex(609066);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function0 function0, Function1 function1, Function0 function02, int i, Composer composer, int i2) {
        y(function0, function1, function02, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(d0 d0Var, com.dragon.read.kmp.service.g gVar, int i, int i2, Composer composer, int i3) {
        I(d0Var, gVar, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(boolean z, int i, Composer composer, int i2) {
        K(z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Modifier modifier, int i, int i2, Composer composer, int i3) {
        o(modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(int i, Composer composer, int i2) {
        q(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(int i, Composer composer, int i2) {
        s(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(List list, int i, Function2 function2, Function2 function22, Function0 function0, Function1 function1, int i2, Composer composer, int i3) {
        u(list, i, function2, function22, function0, function1, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    static final class b implements Function0<Unit> {
        final /* synthetic */ Function2<io4.a, Integer, Unit> a;
        final /* synthetic */ io4.a b;
        final /* synthetic */ int c;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super io4.a, ? super Integer, Unit> function2, io4.a aVar, int i) {
            this.a = function2;
            this.b = aVar;
            this.c = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            this.a.invoke(this.b, Integer.valueOf(this.c));
        }
    }

    static final class c implements Function0<Unit> {
        final /* synthetic */ Function2<io4.a, Integer, Unit> a;
        final /* synthetic */ io4.a b;
        final /* synthetic */ int c;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function2<? super io4.a, ? super Integer, Unit> function2, io4.a aVar, int i) {
            this.a = function2;
            this.b = aVar;
            this.c = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            this.a.invoke(this.b, Integer.valueOf(this.c));
        }
    }

    static final class a implements Function0<Boolean> {
        final /* synthetic */ io4.a a;

        a(io4.a aVar) {
            this.a = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(this.a.a());
        }
    }

    public static final class e implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public e(List list) {
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

    static final class h implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ float a;
        final /* synthetic */ androidx.compose.ui.focus.n b;
        final /* synthetic */ u2 c;
        final /* synthetic */ d0 d;
        final /* synthetic */ SeriesRankSearchViewModel e;
        final /* synthetic */ com.dragon.read.kmp.service.g f;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[SeriesRankSearchUiState.values().length];
                try {
                    iArr[SeriesRankSearchUiState.Ready.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SeriesRankSearchUiState.Loading.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SeriesRankSearchUiState.Empty.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[SeriesRankSearchUiState.Error.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[SeriesRankSearchUiState.Data.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                a = iArr;
            }
        }

        h(float f, androidx.compose.ui.focus.n nVar, u2 u2Var, d0 d0Var, SeriesRankSearchViewModel seriesRankSearchViewModel, com.dragon.read.kmp.service.g gVar) {
            this.a = f;
            this.b = nVar;
            this.c = u2Var;
            this.d = d0Var;
            this.e = seriesRankSearchViewModel;
            this.f = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit k(SeriesRankSearchViewModel seriesRankSearchViewModel) {
            seriesRankSearchViewModel.P0();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit p(d0 d0Var) {
            d0Var.a.invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit r(SeriesRankSearchViewModel seriesRankSearchViewModel) {
            seriesRankSearchViewModel.O0("");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit n(androidx.compose.ui.focus.n nVar, u2 u2Var) {
            androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
            if (u2Var != null) {
                u2Var.hide();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit o(com.dragon.read.kmp.service.g gVar, s2 it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            if (gVar != null) {
                gVar.c(it2);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit q(SeriesRankSearchViewModel seriesRankSearchViewModel, String it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            seriesRankSearchViewModel.O0(it2);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit s(androidx.compose.ui.focus.n nVar, u2 u2Var) {
            androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
            if (u2Var != null) {
                u2Var.hide();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            j(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void j(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1820427613, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchPage.<anonymous> (SeriesRankSearchPage.kt:101)");
                }
                Modifier.a aVar = Modifier.Companion;
                float f = 16;
                Modifier b = BackgroundKt.b(androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), this.a), k.g.e(x0.i.g(f), x0.i.g(f), 0.0f, 0.0f, 12, (Object) null)), c0.a.q(androidx.compose.ui.graphics.c0.b, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), l0.j(n0.d(4293523199L))), TuplesKt.to(Float.valueOf(0.0163f), l0.j(n0.d(4293523199L))), TuplesKt.to(Float.valueOf(0.2653f), l0.j(n0.d(4293850107L))), TuplesKt.to(Float.valueOf(0.5081f), l0.j(n0.d(4294569202L))), TuplesKt.to(Float.valueOf(0.7541f), l0.j(n0.d(4294962412L))), TuplesKt.to(Float.valueOf(1.0f), l0.j(n0.d(4294964201L)))}, 0.0f, 0.0f, 0, 14, (Object) null), (f2) null, 0.0f, 6, (Object) null);
                final androidx.compose.ui.focus.n nVar = this.b;
                final u2 u2Var = this.c;
                final d0 d0Var = this.d;
                final SeriesRankSearchViewModel seriesRankSearchViewModel = this.e;
                final com.dragon.read.kmp.service.g gVar = this.f;
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                e.m i2 = eVar.i();
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 a2 = androidx.compose.foundation.layout.x.a(i2, aVar2.k(), composer, 0);
                int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, b);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
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
                Composer b2 = g5.b(composer);
                g5.e(b2, a2, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                    b2.updateRememberedValue(Integer.valueOf(a3));
                    b2.apply(Integer.valueOf(a3), b3);
                }
                g5.e(b2, e, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, h);
                Function0 a6 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a6);
                } else {
                    composer.useNode();
                }
                Composer b4 = g5.b(composer);
                g5.e(b4, i3, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                    b4.updateRememberedValue(Integer.valueOf(a5));
                    b4.apply(Integer.valueOf(a5), b5);
                }
                g5.e(b4, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                z0.g(org.jetbrains.compose.resources.c.a(u75.r.c(u75.t.a), composer, 0), (String) null, SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(48)), (androidx.compose.ui.e) null, androidx.compose.ui.layout.i.a.a(), 0.0f, (m0) null, 0, composer, 25008, 232);
                Modifier h2 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                p0 a7 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar2.k(), composer, 0);
                int a8 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, h2);
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
                Composer b6 = g5.b(composer);
                g5.e(b6, a7, companion.c());
                g5.e(b6, currentCompositionLocalMap3, companion.e());
                Function2 b7 = companion.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a8))) {
                    b6.updateRememberedValue(Integer.valueOf(a8));
                    b6.apply(Integer.valueOf(a8), b7);
                }
                g5.e(b6, e3, companion.d());
                SeriesRankSearchPageKt.o(c0Var.b(aVar, aVar2.g()), composer, 0, 0);
                composer.startReplaceGroup(5004770);
                boolean changed = composer.changed(d0Var);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.u
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit p;
                            p = SeriesRankSearchPageKt.h.p(d0.this);
                            return p;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(seriesRankSearchViewModel);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.v
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit q;
                            q = SeriesRankSearchPageKt.h.q(SeriesRankSearchViewModel.this, (String) obj);
                            return q;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                Function1 function1 = (Function1) rememberedValue2;
                composer.endReplaceGroup();
                composer.startReplaceGroup(5004770);
                boolean changedInstance2 = composer.changedInstance(seriesRankSearchViewModel);
                Object rememberedValue3 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.w
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit r;
                            r = SeriesRankSearchPageKt.h.r(SeriesRankSearchViewModel.this);
                            return r;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                SeriesRankSearchPageKt.y(function0, function1, (Function0) rememberedValue3, composer, 0);
                composer.endNode();
                composer.endNode();
                Modifier f2 = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changedInstance3 = composer.changedInstance(nVar) | composer.changed(u2Var);
                Object rememberedValue4 = composer.rememberedValue();
                if (changedInstance3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.x
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit s;
                            s = SeriesRankSearchPageKt.h.s(nVar, u2Var);
                            return s;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue4);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(f2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue4, 15, (Object) null);
                p0 i4 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a10 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                Modifier e4 = ComposedModifierKt.e(composer, modifier);
                Function0 a11 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a11);
                } else {
                    composer.useNode();
                }
                Composer b8 = g5.b(composer);
                g5.e(b8, i4, companion.c());
                g5.e(b8, currentCompositionLocalMap4, companion.e());
                Function2 b9 = companion.b();
                if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a10))) {
                    b8.updateRememberedValue(Integer.valueOf(a10));
                    b8.apply(Integer.valueOf(a10), b9);
                }
                g5.e(b8, e4, companion.d());
                int i5 = a.a[((SeriesRankSearchUiState) seriesRankSearchViewModel.b.getValue()).ordinal()];
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 != 4) {
                                if (i5 == 5) {
                                    composer.startReplaceGroup(-1217919285);
                                    List list = (List) seriesRankSearchViewModel.c.getValue();
                                    int intValue = ((Number) seriesRankSearchViewModel.d.getValue()).intValue();
                                    composer.startReplaceGroup(5004770);
                                    boolean changed2 = composer.changed(d0Var);
                                    Object rememberedValue5 = composer.rememberedValue();
                                    if (changed2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                        rememberedValue5 = new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.z
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                Unit l;
                                                l = SeriesRankSearchPageKt.h.l(d0.this, (io4.a) obj, ((Integer) obj2).intValue());
                                                return l;
                                            }
                                        };
                                        composer.updateRememberedValue(rememberedValue5);
                                    }
                                    Function2 function2 = (Function2) rememberedValue5;
                                    composer.endReplaceGroup();
                                    composer.startReplaceGroup(-1746271574);
                                    boolean changedInstance4 = composer.changedInstance(nVar) | composer.changed(u2Var) | composer.changed(d0Var);
                                    Object rememberedValue6 = composer.rememberedValue();
                                    if (changedInstance4 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                        rememberedValue6 = new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.r
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                Unit m;
                                                m = SeriesRankSearchPageKt.h.m(nVar, u2Var, d0Var, (io4.a) obj, ((Integer) obj2).intValue());
                                                return m;
                                            }
                                        };
                                        composer.updateRememberedValue(rememberedValue6);
                                    }
                                    Function2 function22 = (Function2) rememberedValue6;
                                    composer.endReplaceGroup();
                                    composer.startReplaceGroup(-1633490746);
                                    boolean changedInstance5 = composer.changedInstance(nVar) | composer.changed(u2Var);
                                    Object rememberedValue7 = composer.rememberedValue();
                                    if (changedInstance5 || rememberedValue7 == Composer.Companion.getEmpty()) {
                                        rememberedValue7 = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.s
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                Unit n;
                                                n = SeriesRankSearchPageKt.h.n(nVar, u2Var);
                                                return n;
                                            }
                                        };
                                        composer.updateRememberedValue(rememberedValue7);
                                    }
                                    Function0 function02 = (Function0) rememberedValue7;
                                    composer.endReplaceGroup();
                                    composer.startReplaceGroup(5004770);
                                    boolean changedInstance6 = composer.changedInstance(gVar);
                                    Object rememberedValue8 = composer.rememberedValue();
                                    if (changedInstance6 || rememberedValue8 == Composer.Companion.getEmpty()) {
                                        rememberedValue8 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.t
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                Unit o;
                                                o = SeriesRankSearchPageKt.h.o(com.dragon.read.kmp.service.g.this, (s2) obj);
                                                return o;
                                            }
                                        };
                                        composer.updateRememberedValue(rememberedValue8);
                                    }
                                    composer.endReplaceGroup();
                                    SeriesRankSearchPageKt.u(list, intValue, function2, function22, function02, (Function1) rememberedValue8, composer, 0);
                                    composer.endReplaceGroup();
                                    Unit unit = Unit.INSTANCE;
                                } else {
                                    composer.startReplaceGroup(-1217936317);
                                    composer.endReplaceGroup();
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                composer.startReplaceGroup(-1217926621);
                                composer.startReplaceGroup(5004770);
                                boolean changedInstance7 = composer.changedInstance(seriesRankSearchViewModel);
                                Object rememberedValue9 = composer.rememberedValue();
                                if (changedInstance7 || rememberedValue9 == Composer.Companion.getEmpty()) {
                                    rememberedValue9 = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.y
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            Unit k;
                                            k = SeriesRankSearchPageKt.h.k(SeriesRankSearchViewModel.this);
                                            return k;
                                        }
                                    };
                                    composer.updateRememberedValue(rememberedValue9);
                                }
                                composer.endReplaceGroup();
                                mg4.k.k(new mg4.b((String) null, (Function0) rememberedValue9, (String) null, (Function0) null, (l0) null, 29, (DefaultConstructorMarker) null), true, composer, 48, 0);
                                composer.endReplaceGroup();
                                Unit unit2 = Unit.INSTANCE;
                            }
                        } else {
                            composer.startReplaceGroup(-1217928905);
                            SeriesRankSearchPageKt.q(composer, 0);
                            composer.endReplaceGroup();
                            Unit unit3 = Unit.INSTANCE;
                        }
                    } else {
                        composer.startReplaceGroup(-1217931111);
                        SeriesRankSearchPageKt.s(composer, 0);
                        composer.endReplaceGroup();
                        Unit unit4 = Unit.INSTANCE;
                    }
                } else {
                    composer.startReplaceGroup(898721782);
                    composer.endReplaceGroup();
                    Unit unit5 = Unit.INSTANCE;
                }
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
        public static final Unit l(d0 d0Var, io4.a model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            d0Var.c.invoke(model, Integer.valueOf(i));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit m(androidx.compose.ui.focus.n nVar, u2 u2Var, d0 d0Var, io4.a model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
            if (u2Var != null) {
                u2Var.hide();
            }
            d0Var.b.invoke(model, Integer.valueOf(i));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String z(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    public static final class d implements Function1<Integer, Object> {
        final /* synthetic */ Function2 a;
        final /* synthetic */ List b;

        public d(Function2 function2, List list) {
            this.a = function2;
            this.b = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }

        public final Object a(int i) {
            return this.a.invoke(Integer.valueOf(i), this.b.get(i));
        }
    }

    private static final void A(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    private static final void B(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(MutableState mutableState, androidx.compose.ui.focus.c0 it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        B(mutableState, it2.isFocused());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(u2 u2Var, androidx.compose.foundation.text.u2 KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (u2Var != null) {
            u2Var.hide();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Function0 function0, MutableState mutableState) {
        A(mutableState, "");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object w(int i, io4.a item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.c(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Composer composer, final int i) {
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(1129629694);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1129629694, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.search.SearchLoading (SeriesRankSearchPage.kt:190)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.f(aVar, 0.0f, 1, (Object) null), 0.0f, x0.i.g(150), 0.0f, 0.0f, 13, (Object) null);
            p0 i2 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.m(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, v);
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
            g5.e(b2, i2, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            a3.m(SizeKt.s(aVar, x0.i.g(32)), n0.d(4290298060L), x0.i.g(3), 0L, 0, startRestartGroup, 438, 24);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t;
                    t = SeriesRankSearchPageKt.t(i, (Composer) obj, ((Integer) obj2).intValue());
                    return t;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1923122328);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1923122328, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.search.EmptyResult (SeriesRankSearchPage.kt:206)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.f(aVar, 0.0f, 1, (Object) null), 0.0f, x0.i.g(150), 0.0f, 0.0f, 13, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i2 = androidx.compose.foundation.layout.m.i(aVar2.m(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, v);
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
            g5.e(b2, i2, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            p0 a4 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), aVar2.g(), startRestartGroup, 48);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, aVar);
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
            Composer b4 = g5.b(startRestartGroup);
            g5.e(b4, a4, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                b4.updateRememberedValue(Integer.valueOf(a5));
                b4.apply(Integer.valueOf(a5), b5);
            }
            g5.e(b4, e3, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            com.dragon.read.kmp.compose.common.b.E("empty", startRestartGroup, 6);
            composer2 = startRestartGroup;
            a6.j("暂无搜索结果", androidx.compose.foundation.layout.f2.v(aVar, 0.0f, x0.i.g(8), 0.0f, 0.0f, 13, (Object) null), og4.a.a.h(startRestartGroup, og4.a.b).n1(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3126, 0, 131056);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit r;
                    r = SeriesRankSearchPageKt.r(i, (Composer) obj, ((Integer) obj2).intValue());
                    return r;
                }
            });
        }
    }

    static final class g implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
        final /* synthetic */ long a;
        final /* synthetic */ MutableState<String> b;

        g(long j, MutableState<String> mutableState) {
            this.a = j;
            this.b = mutableState;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
            a(function2, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            int i4;
            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
            if ((i & 6) == 0) {
                if (composer.changedInstance(innerTextField)) {
                    i4 = 4;
                } else {
                    i4 = 2;
                }
                i2 = i | i4;
            } else {
                i2 = i;
            }
            boolean z2 = false;
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2144004180, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.search.SearchTopBar.<anonymous>.<anonymous>.<anonymous> (SeriesRankSearchPage.kt:369)");
                }
                composer.startReplaceGroup(-1196283574);
                if (SeriesRankSearchPageKt.z(this.b).length() == 0) {
                    z2 = true;
                }
                if (z2) {
                    i3 = i2;
                    a6.j("搜索演员名字", (Modifier) null, this.a, x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3462, 0, 131058);
                } else {
                    i3 = i2;
                }
                composer.endReplaceGroup();
                innerTextField.invoke(composer, Integer.valueOf(i3 & 14));
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
    public static final Unit E(Function1 function1, MutableState mutableState, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        A(mutableState, value);
        function1.invoke(value);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        float f2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-99529037);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(z)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-99529037, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.search.Top50Divider (SeriesRankSearchPage.kt:279)");
            }
            if (z) {
                f2 = 20;
            } else {
                f2 = 28;
            }
            float g2 = x0.i.g(f2);
            Modifier.a aVar = Modifier.Companion;
            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, g2, 0.0f, x0.i.g(28), 5, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i4 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, v);
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
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            p0 b4 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.i(), startRestartGroup, 48);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, aVar);
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
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, b4, companion.c());
            g5.e(b5, currentCompositionLocalMap2, companion.e());
            Function2 b6 = companion.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a4))) {
                b5.updateRememberedValue(Integer.valueOf(a4));
                b5.apply(Integer.valueOf(a4), b6);
            }
            g5.e(b5, e3, companion.d());
            w2 w2Var = w2.b;
            float f3 = 8;
            float f4 = 12;
            Modifier x = SizeKt.x(androidx.compose.foundation.layout.f2.v(aVar, 0.0f, 0.0f, x0.i.g(f3), 0.0f, 11, (Object) null), x0.i.g(f4));
            og4.a aVar3 = og4.a.a;
            int i5 = og4.a.b;
            float f5 = (float) 0.5d;
            androidx.compose.material.p0.b(x, aVar3.h(startRestartGroup, i5).E(), x0.i.g(f5), 0.0f, startRestartGroup, 390, 8);
            a6.j("以下演员排名在TOP50之外", (Modifier) null, aVar3.h(startRestartGroup, i5).n1(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 3078, 0, 131058);
            Modifier x2 = SizeKt.x(androidx.compose.foundation.layout.f2.v(aVar, x0.i.g(f3), 0.0f, 0.0f, 0.0f, 14, (Object) null), x0.i.g(f4));
            composer2 = startRestartGroup;
            androidx.compose.material.p0.b(x2, aVar3.h(composer2, i5).E(), x0.i.g(f5), 0.0f, composer2, 390, 8);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit L;
                    L = SeriesRankSearchPageKt.L(z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return L;
                }
            });
        }
    }

    public static final class f implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ int b;
        final /* synthetic */ Function2 c;
        final /* synthetic */ Function2 d;

        public f(List list, int i, Function2 function2, Function2 function22) {
            this.a = list;
            this.b = i;
            this.c = function2;
            this.d = function22;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            a(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f fVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            boolean z2;
            boolean z3;
            float f;
            boolean z4;
            int i4;
            int i5;
            if ((i2 & 6) == 0) {
                if (composer.changed(fVar)) {
                    i5 = 4;
                } else {
                    i5 = 2;
                }
                i3 = i2 | i5;
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
            boolean z5 = true;
            if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                int i6 = (i3 & 112) | (i3 & 14);
                io4.a aVar = (io4.a) this.a.get(i);
                composer.startReplaceGroup(740770325);
                composer.startReplaceGroup(1270820908);
                if (i == this.b) {
                    if (i == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    SeriesRankSearchPageKt.K(z4, composer, 0);
                }
                composer.endReplaceGroup();
                int i7 = this.b;
                if (i7 > 0 && i == i7 - 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Modifier.a aVar2 = Modifier.Companion;
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(aVar);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new a(aVar);
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(-1746271574);
                boolean changed = composer.changed(this.c) | composer.changedInstance(aVar);
                int i8 = i6 & 112;
                int i9 = i8 ^ 48;
                if ((i9 > 32 && composer.changed(i)) || (i6 & 48) == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z6 = changed | z3;
                Object rememberedValue2 = composer.rememberedValue();
                if (z6 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new b(this.c, aVar, i);
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                Modifier c = tc4.i.c(aVar2, function0, (Function0) rememberedValue2);
                List<? extends List<Integer>> list = aVar.f;
                if (z2) {
                    f = 0;
                } else {
                    f = 20;
                }
                x0.i d = x0.i.d(x0.i.g(f));
                composer.startReplaceGroup(-1746271574);
                boolean changed2 = composer.changed(this.d) | composer.changedInstance(aVar);
                if ((i9 <= 32 || !composer.changed(i)) && (i6 & 48) != 32) {
                    z5 = false;
                }
                boolean z7 = changed2 | z5;
                Object rememberedValue3 = composer.rememberedValue();
                if (z7 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new c(this.d, aVar, i);
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                com.dragon.read.kmp.shortvideo.distribution.page.tab.item.m.r(c, i, aVar, true, false, list, false, true, d, 0.0f, (Function0) rememberedValue3, composer, 12610560 | i8 | (i6 & 896), 0, TTVideoEngineInterface.PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Modifier modifier, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        boolean z;
        final Modifier modifier3;
        Composer startRestartGroup = composer.startRestartGroup(2114248465);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i3 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i5 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2114248465, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.page.search.DragHandle (SeriesRankSearchPage.kt:179)");
            }
            float f2 = 8;
            androidx.compose.foundation.layout.m.b(BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.u(androidx.compose.foundation.layout.f2.v(modifier3, 0.0f, x0.i.g(f2), 0.0f, x0.i.g(f2), 5, (Object) null), x0.i.g(36), x0.i.g(4)), k.g.c(x0.i.g(2))), og4.a.a.h(startRestartGroup, og4.a.b).i(), (f2) null, 2, (Object) null), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit p;
                    p = SeriesRankSearchPageKt.p(modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return p;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(List list, int i, Function2 function2, Function2 function22, o0 LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyColumn.f(list.size(), new d(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.e
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Object w;
                w = SeriesRankSearchPageKt.w(((Integer) obj).intValue(), (io4.a) obj2);
                return w;
            }
        }, list), new e(list), androidx.compose.runtime.internal.t.c(2039820996, true, new f(list, i, function2, function22)));
        return Unit.INSTANCE;
    }

    public static final void I(final d0 params, com.dragon.read.kmp.service.g gVar, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean changedInstance;
        int i5;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        final com.dragon.read.kmp.service.g gVar2 = gVar;
        Intrinsics.checkNotNullParameter(params, "params");
        Composer startRestartGroup = composer.startRestartGroup(2096383148);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            if (startRestartGroup.changed(params)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(gVar2);
            } else {
                changedInstance = startRestartGroup.changedInstance(gVar2);
            }
            if (changedInstance) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i6 != 0) {
                gVar2 = null;
            }
            com.dragon.read.kmp.service.g gVar3 = gVar2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2096383148, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchPage (SeriesRankSearchPage.kt:85)");
            }
            i0 i0Var = new i0(params);
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                SeriesRankSearchViewModel seriesRankSearchViewModel = (SeriesRankSearchViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankSearchViewModel.class), c2, (String) null, i0Var, creationExtras, startRestartGroup, 0, 0);
                u2 u2Var = (u2) startRestartGroup.consume(CompositionLocalsKt.p());
                androidx.compose.ui.focus.n nVar = (androidx.compose.ui.focus.n) startRestartGroup.consume(CompositionLocalsKt.g());
                Context b2 = ig4.f.b();
                Intrinsics.checkNotNull(b2);
                composer2 = startRestartGroup;
                pg4.p.e(new pg4.h(tg4.e.a.b(), qg4.m.b, (List) null, 4, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(1820427613, true, new h(x0.i.g(((x0.e) startRestartGroup.consume(CompositionLocalsKt.f())).v1(ScreenUtils.a.a(b2)) - x0.i.g(44)), nVar, u2Var, params, seriesRankSearchViewModel, gVar3), composer2, 54), composer2, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                gVar2 = gVar3;
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit J;
                    J = SeriesRankSearchPageKt.J(d0.this, gVar2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return J;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function0<Unit> function0, final Function1<? super String, Unit> function1, Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        boolean z;
        final Function0<Unit> function03;
        Composer composer2;
        boolean z2;
        final MutableState mutableState;
        boolean z3;
        Composer composer3;
        int i3;
        int i4;
        int i5;
        boolean z4;
        boolean z5;
        Composer composer4;
        int i6;
        int i7;
        int i8;
        final Function0<Unit> function04 = function02;
        Composer startRestartGroup = composer.startRestartGroup(-325035463);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i8 = 4;
            } else {
                i8 = 2;
            }
            i2 = i8 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i7 = 32;
            } else {
                i7 = 16;
            }
            i2 |= i7;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(function04)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i2 |= i6;
        }
        int i9 = i2;
        if ((i9 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i9 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-325035463, i9, -1, "com.dragon.read.kmp.shortvideo.distribution.page.search.SearchTopBar (SeriesRankSearchPage.kt:319)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState2 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FocusRequester();
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            FocusRequester focusRequester = (FocusRequester) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            final u2 u2Var = (u2) startRestartGroup.consume(CompositionLocalsKt.p());
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            long d2 = n0.d(4279966491L);
            long b2 = n0.b(1291845632);
            long d3 = n0.d(4294600485L);
            og4.a aVar = og4.a.a;
            int i10 = og4.a.b;
            long n1 = aVar.h(startRestartGroup, i10).n1();
            Modifier.a aVar2 = Modifier.Companion;
            float f2 = 16;
            float f3 = 8;
            Modifier s = androidx.compose.foundation.layout.f2.s(SizeKt.h(aVar2, 0.0f, 1, (Object) null), x0.i.g(f2), x0.i.g(f3));
            e.a aVar3 = androidx.compose.ui.e.a;
            e.c i11 = aVar3.i();
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            p0 b3 = r2.b(eVar.h(), i11, startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, s);
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
            Composer b4 = g5.b(startRestartGroup);
            g5.e(b4, b3, companion2.c());
            g5.e(b4, currentCompositionLocalMap, companion2.e());
            Function2 b5 = companion2.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a2))) {
                b4.updateRememberedValue(Integer.valueOf(a2));
                b4.apply(Integer.valueOf(a2), b5);
            }
            g5.e(b4, e2, companion2.d());
            w2 w2Var = w2.b;
            Modifier d4 = BackgroundKt.d(androidx.compose.ui.draw.e.a(androidx.compose.foundation.layout.u2.a(w2Var, SizeKt.i(aVar2, x0.i.g(36)), 1.0f, false, 2, (Object) null), k.g.c(x0.i.g(6))), aVar.h(startRestartGroup, i10).L2(), (f2) null, 2, (Object) null);
            p0 b6 = r2.b(eVar.h(), aVar3.i(), startRestartGroup, 48);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, d4);
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
            Composer b7 = g5.b(startRestartGroup);
            g5.e(b7, b6, companion2.c());
            g5.e(b7, currentCompositionLocalMap2, companion2.e());
            Function2 b8 = companion2.b();
            if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a4))) {
                b7.updateRememberedValue(Integer.valueOf(a4));
                b7.apply(Integer.valueOf(a4), b8);
            }
            g5.e(b7, e3, companion2.d());
            float g2 = x0.i.g(f3);
            startRestartGroup.startReplaceGroup(-344996060);
            androidx.compose.foundation.layout.a3.a(SizeKt.x(aVar2, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            f2.a aVar4 = f2.a.a;
            e1 a6 = org.jetbrains.compose.resources.c.a(d2.j(aVar4), startRestartGroup, 0);
            Modifier s2 = SizeKt.s(aVar2, x0.i.g(f2));
            m0.a aVar5 = m0.b;
            z0.g(a6, "search", s2, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(aVar5, n1, 0, 2, (Object) null), 0, startRestartGroup, 432, 184);
            float f4 = 4;
            float g3 = x0.i.g(f4);
            startRestartGroup.startReplaceGroup(-344996060);
            androidx.compose.foundation.layout.a3.a(SizeKt.x(aVar2, g3), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            String z6 = z(mutableState2);
            g3 g3Var = new g3(d2, x0.x.h(14), androidx.compose.ui.text.font.c0.b.h(), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777208, (DefaultConstructorMarker) null);
            Modifier a7 = androidx.compose.ui.focus.y.a(androidx.compose.foundation.layout.u2.a(w2Var, aVar2, 1.0f, false, 2, (Object) null), focusRequester);
            startRestartGroup.startReplaceGroup(5004770);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit C;
                        C = SeriesRankSearchPageKt.C(mutableState3, (androidx.compose.ui.focus.c0) obj);
                        return C;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Modifier a8 = androidx.compose.ui.focus.c.a(a7, (Function1) rememberedValue4);
            g2 g2Var = new g2(d3, (DefaultConstructorMarker) null);
            androidx.compose.foundation.text.w2 w2Var2 = new androidx.compose.foundation.text.w2(0, (Boolean) null, 0, androidx.compose.ui.text.input.s.b.g(), (androidx.compose.ui.text.input.i0) null, (Boolean) null, (s0.f) null, 119, (DefaultConstructorMarker) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(u2Var);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit D;
                        D = SeriesRankSearchPageKt.D(u2Var, (androidx.compose.foundation.text.u2) obj);
                        return D;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            v2 v2Var = new v2((Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) rememberedValue5, (Function1) null, 47, (DefaultConstructorMarker) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i9 & 112) == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (!z2 && rememberedValue6 != companion.getEmpty()) {
                mutableState = mutableState2;
            } else {
                mutableState = mutableState2;
                rememberedValue6 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit E;
                        E = SeriesRankSearchPageKt.E(Function1.this, mutableState, (String) obj);
                        return E;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState4 = mutableState;
            BasicTextFieldKt.s(z6, (Function1) rememberedValue6, a8, false, false, g3Var, w2Var2, v2Var, true, 0, 0, (b1) null, (Function1) null, (androidx.compose.foundation.interaction.i) null, g2Var, androidx.compose.runtime.internal.t.e(2144004180, true, new g(b2, mutableState), startRestartGroup, 54), startRestartGroup, 102236160, 221184, 15896);
            startRestartGroup.startReplaceGroup(-118486983);
            if (z(mutableState4).length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                e1 a9 = org.jetbrains.compose.resources.c.a(d2.q(aVar4), startRestartGroup, 0);
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.s(aVar2, x0.i.g(20)), 0.0f, 0.0f, x0.i.g(f4), 0.0f, 11, (Object) null);
                i5 = -1633490746;
                startRestartGroup.startReplaceGroup(-1633490746);
                if ((i9 & 896) == 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (!z5 && rememberedValue7 != companion.getEmpty()) {
                    composer4 = startRestartGroup;
                    function04 = function02;
                } else {
                    composer4 = startRestartGroup;
                    function04 = function02;
                    rememberedValue7 = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.l
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit F;
                            F = SeriesRankSearchPageKt.F(Function0.this, mutableState4);
                            return F;
                        }
                    };
                    composer4.updateRememberedValue(rememberedValue7);
                }
                composer4.endReplaceGroup();
                composer3 = composer4;
                i3 = i9;
                i4 = 0;
                z0.g(a9, "clear", ClickableKt.clickable-oSLSa3U$default(v, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue7, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(aVar5, n1, 0, 2, (Object) null), 0, composer4, 48, 184);
            } else {
                composer3 = startRestartGroup;
                i3 = i9;
                i4 = 0;
                i5 = -1633490746;
                function04 = function02;
            }
            composer3.endReplaceGroup();
            float g4 = x0.i.g(f4);
            Composer composer5 = composer3;
            composer5.startReplaceGroup(-344996060);
            androidx.compose.foundation.layout.a3.a(SizeKt.x(aVar2, g4), composer5, i4);
            composer5.endReplaceGroup();
            composer5.endNode();
            long h2 = x0.x.h(14);
            Modifier v2 = androidx.compose.foundation.layout.f2.v(aVar2, x0.i.g(f2), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            composer5.startReplaceGroup(5004770);
            if ((i3 & 14) == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
            Object rememberedValue8 = composer5.rememberedValue();
            if (!z4 && rememberedValue8 != companion.getEmpty()) {
                function03 = function0;
            } else {
                function03 = function0;
                rememberedValue8 = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit G;
                        G = SeriesRankSearchPageKt.G(Function0.this);
                        return G;
                    }
                };
                composer5.updateRememberedValue(rememberedValue8);
            }
            composer5.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(v2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue8, 15, (Object) null);
            composer2 = composer5;
            a6.j("取消", modifier, n1, h2, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3078, 0, 131056);
            composer2.endNode();
            Unit unit = Unit.INSTANCE;
            composer2.startReplaceGroup(i5);
            boolean changed2 = composer2.changed(u2Var);
            Object rememberedValue9 = composer2.rememberedValue();
            if (changed2 || rememberedValue9 == companion.getEmpty()) {
                rememberedValue9 = new SeriesRankSearchPageKt$SearchTopBar$2$1(focusRequester, u2Var, null);
                composer2.updateRememberedValue(rememberedValue9);
            }
            composer2.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue9, composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function03 = function0;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit H;
                    H = SeriesRankSearchPageKt.H(Function0.this, function1, function04, i, (Composer) obj, ((Integer) obj2).intValue());
                    return H;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(final List<io4.a> list, final int i, final Function2<? super io4.a, ? super Integer, Unit> function2, final Function2<? super io4.a, ? super Integer, Unit> function22, final Function0<Unit> function0, final Function1<? super s2, Unit> function1, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-545992599);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(list)) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i3 = i9 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(i)) {
                i8 = 32;
            } else {
                i8 = 16;
            }
            i3 |= i8;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changedInstance(function2)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i3 |= i7;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changedInstance(function22)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i2 & 24576) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i3 |= i5;
        }
        if ((196608 & i2) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i3 |= i4;
        }
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-545992599, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.page.search.SearchResultList (SeriesRankSearchPage.kt:233)");
            }
            LazyListState c2 = y0.c(0, 0, startRestartGroup, 0, 3);
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((458752 & i3) == 131072) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean changed = z2 | startRestartGroup.changed(c2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SeriesRankSearchPageKt$SearchResultList$1$1(function1, c2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(c2, (Function2) rememberedValue, startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changed2 = startRestartGroup.changed(c2);
            if ((57344 & i3) == 16384) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z7 = changed2 | z3;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SeriesRankSearchPageKt$SearchResultList$2$1(c2, function0, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(c2, (Function2) rememberedValue2, startRestartGroup, 0);
            Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(9), 0.0f, 2, (Object) null);
            i2 j = androidx.compose.foundation.layout.f2.j(0.0f, x0.i.g(16), 0.0f, 0.0f, 13, (Object) null);
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changedInstance = startRestartGroup.changedInstance(list);
            if ((i3 & 112) == 32) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z8 = z4 | changedInstance;
            if ((i3 & 896) == 256) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean z9 = z8 | z5;
            if ((i3 & 7168) == 2048) {
                z6 = true;
            } else {
                z6 = false;
            }
            boolean z10 = z9 | z6;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z10 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit v;
                        v = SeriesRankSearchPageKt.v(list, i, function2, function22, (o0) obj);
                        return v;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            androidx.compose.foundation.lazy.d.c(t, c2, j, false, (e.m) null, (e.b) null, (l1) null, false, (y1) null, (Function1) rememberedValue3, composer2, 390, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit x;
                    x = SeriesRankSearchPageKt.x(list, i, function2, function22, function0, function1, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return x;
                }
            });
        }
    }
}
