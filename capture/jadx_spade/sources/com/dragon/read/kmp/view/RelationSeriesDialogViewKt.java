package com.dragon.read.kmp.view;

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
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.y1;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.view.RelationSeriesDialogViewKt;
import com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel;
import com.dragon.read.kmp.widget.CommonLayoutKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import jd4.c;
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
public final class RelationSeriesDialogViewKt {
    static {
        Covode.recordClassIndex(609593);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(int i, Composer composer, int i2) {
        A(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(int i, Composer composer, int i2) {
        A(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(gk4.e0 e0Var, xm4.a aVar, int i, Composer composer, int i2) {
        G(e0Var, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(gk4.e0 e0Var, xm4.a aVar, int i, Composer composer, int i2) {
        G(e0Var, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(int i, Composer composer, int i2) {
        J(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(c.a aVar, int i, Composer composer, int i2) {
        p(aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(int i, Composer composer, int i2) {
        s(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(int i, Composer composer, int i2) {
        u(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(int i, Composer composer, int i2) {
        w(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(LazyListState lazyListState, int i, Composer composer, int i2) {
        y(lazyListState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function3<gk4.f0, Composer, Integer, Unit> {
        final /* synthetic */ RelationSeriesSingleViewModel a;
        final /* synthetic */ gk4.g0 b;

        a(RelationSeriesSingleViewModel relationSeriesSingleViewModel, gk4.g0 g0Var) {
            this.a = relationSeriesSingleViewModel;
            this.b = g0Var;
        }

        /* renamed from: com.dragon.read.kmp.view.RelationSeriesDialogViewKt$a$a, reason: collision with other inner class name */
        public static final class C0077a implements Function1<Integer, Object> {
            final /* synthetic */ List a;

            public C0077a(List list) {
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

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(gk4.f0 f0Var, Composer composer, Integer num) {
            c(f0Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(RelationSeriesSingleViewModel relationSeriesSingleViewModel, gk4.g0 g0Var, androidx.compose.ui.layout.w it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            relationSeriesSingleViewModel.e = g0Var;
            relationSeriesSingleViewModel.L0(true);
            com.dragon.read.kmp.j.a.a("RelationSeriesDialogView", "RelationSeriesDialogView onGloballyPositioned");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(gk4.f0 f0Var, RelationSeriesSingleViewModel relationSeriesSingleViewModel, androidx.compose.foundation.lazy.o0 LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            com.dragon.read.kmp.j.a.d("RelationSeriesDialogView", "RelationSeriesDialogView itemsIndexed size = " + f0Var.c.size());
            List<gk4.h0> list = f0Var.c;
            LazyColumn.f(list.size(), (Function1) null, new C0077a(list), androidx.compose.runtime.internal.t.c(2039820996, true, new b(list, relationSeriesSingleViewModel)));
            return Unit.INSTANCE;
        }

        public final void c(final gk4.f0 model, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2007300161, i, -1, "com.dragon.read.kmp.view.RelationSeriesCommonLayout.<anonymous> (RelationSeriesDialogView.kt:256)");
            }
            LazyListState c = androidx.compose.foundation.lazy.y0.c(0, 0, composer, 0, 3);
            RelationSeriesDialogViewKt.y(c, composer, 0);
            float f = 16;
            Modifier v = f2.v(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(f), x0.i.g(f), 0.0f, 8, (Object) null);
            composer.startReplaceGroup(-1633490746);
            boolean changedInstance = composer.changedInstance(this.a) | composer.changedInstance(this.b);
            final RelationSeriesSingleViewModel relationSeriesSingleViewModel = this.a;
            final gk4.g0 g0Var = this.b;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.view.u0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit d;
                        d = RelationSeriesDialogViewKt.a.d(RelationSeriesSingleViewModel.this, g0Var, (androidx.compose.ui.layout.w) obj);
                        return d;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            Modifier a = androidx.compose.ui.layout.d1.a(v, (Function1) rememberedValue);
            composer.startReplaceGroup(-1633490746);
            boolean changedInstance2 = composer.changedInstance(model) | composer.changedInstance(this.a);
            final RelationSeriesSingleViewModel relationSeriesSingleViewModel2 = this.a;
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.view.v0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit e;
                        e = RelationSeriesDialogViewKt.a.e(gk4.f0.this, relationSeriesSingleViewModel2, (androidx.compose.foundation.lazy.o0) obj);
                        return e;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            androidx.compose.foundation.lazy.d.c(a, c, (i2) null, false, (e.m) null, (e.b) null, (l1) null, false, (y1) null, (Function1) rememberedValue2, composer, 0, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        public static final class b implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
            final /* synthetic */ List a;
            final /* synthetic */ RelationSeriesSingleViewModel b;

            public b(List list, RelationSeriesSingleViewModel relationSeriesSingleViewModel) {
                this.a = list;
                this.b = relationSeriesSingleViewModel;
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
                    gk4.h0 h0Var = (gk4.h0) this.a.get(i);
                    composer.startReplaceGroup(2001511585);
                    int i6 = ((i3 & 112) | (i3 & 14)) >> 3;
                    c0.K(i, h0Var, this.b, composer, (i6 & 112) | (i6 & 14));
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(RelationSeriesSingleViewModel relationSeriesSingleViewModel) {
        relationSeriesSingleViewModel.a.dismissDialog();
        return Unit.INSTANCE;
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Modifier a;
        final /* synthetic */ float b;
        final /* synthetic */ gk4.e0 c;

        b(Modifier modifier, float f, gk4.e0 e0Var) {
            this.a = modifier;
            this.b = f;
            this.c = e0Var;
        }

        static final class a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ Modifier a;
            final /* synthetic */ float b;
            final /* synthetic */ gk4.e0 c;

            a(Modifier modifier, float f, gk4.e0 e0Var) {
                this.a = modifier;
                this.b = f;
                this.c = e0Var;
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
                        ComposerKt.traceEventStart(-1893331988, i, -1, "com.dragon.read.kmp.view.RelationSeriesDialogView.<anonymous>.<anonymous> (RelationSeriesDialogView.kt:94)");
                    }
                    Modifier modifier = this.a;
                    og4.a aVar = og4.a.a;
                    int i2 = og4.a.b;
                    Modifier d = BackgroundKt.d(modifier, aVar.h(composer, i2).D(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                    float f = this.b;
                    gk4.e0 e0Var = this.c;
                    androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), composer, 0);
                    int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer, d);
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
                    com.dragon.read.kmp.j.a.a("RelationSeriesDialogView", "RelationSeriesDialogView maxHeightDp = " + ((Object) x0.i.l(f)));
                    if (e0Var.b) {
                        composer.startReplaceGroup(1906546593);
                        RelationSeriesDialogViewKt.J(composer, 0);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(1906614762);
                        RelationSeriesDialogViewKt.w(composer, 0);
                        composer.endReplaceGroup();
                    }
                    RelationSeriesDialogViewKt.u(composer, 0);
                    float f2 = 16;
                    a6.j("系列剧", f2.v(Modifier.Companion, x0.i.g(f2), 0.0f, x0.i.g(f2), 0.0f, 10, (Object) null), aVar.h(composer, i2).k(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199734, 0, 131024);
                    RelationSeriesDialogViewKt.s(composer, 0);
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
                    ComposerKt.traceEventStart(-151051587, i, -1, "com.dragon.read.kmp.view.RelationSeriesDialogView.<anonymous> (RelationSeriesDialogView.kt:93)");
                }
                pg4.p.e(new pg4.h((pg4.t) null, (pg4.t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(-1893331988, true, new a(this.a, this.b, this.c), composer, 54), composer, 48);
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
    public static final Unit D(Function1 function1, gk4.f0 model) {
        Intrinsics.checkNotNullParameter(model, "model");
        function1.invoke(model);
        com.dragon.read.kmp.j.a.a("RelationSeriesDialogView", "RelationSeriesDialogView loadData success");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Function1 function1, Throwable it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        function1.invoke(new com.dragon.read.kmp.widget.w(-1, "加载失败"));
        com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "RelationSeriesDialogView", "RelationSeriesDialogView loadData error " + it2, (Throwable) null, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(RelationSeriesSingleViewModel relationSeriesSingleViewModel, c.a aVar) {
        ym4.a aVar2;
        ym4.s sVar;
        ym4.s sVar2;
        gk4.g0 E0 = relationSeriesSingleViewModel.E0();
        if (E0 == null || (sVar2 = E0.e) == null || (aVar2 = ym4.t.a(sVar2)) == null) {
            aVar2 = new ym4.a();
        }
        ym4.m mVar = ym4.m.a;
        gk4.g0 E02 = relationSeriesSingleViewModel.E0();
        if (E02 != null) {
            sVar = E02.e;
        } else {
            sVar = null;
        }
        mVar.g(false, aVar, sVar);
        cd4.a aVar3 = cd4.a.a;
        String str = aVar.b;
        ym4.k b2 = com.dragon.read.kmp.utils.k0.a.b();
        mVar.e(aVar2, aVar);
        b2.g(aVar2);
        Unit unit = Unit.INSTANCE;
        aVar3.a(str, b2);
        return Unit.INSTANCE;
    }

    public static final void s(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(-534807984);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-534807984, i, -1, "com.dragon.read.kmp.view.ContentLayout (RelationSeriesDialogView.kt:212)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                RelationSeriesSingleViewModel relationSeriesSingleViewModel = (RelationSeriesSingleViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(RelationSeriesSingleViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                com.dragon.read.kmp.j.a.a("RelationSeriesDialogView", "RelationSeriesDialogView ContentLayout " + relationSeriesSingleViewModel + ' ' + relationSeriesSingleViewModel.F0());
                startRestartGroup.startMovableGroup(1445609256, startRestartGroup.joinKey(relationSeriesSingleViewModel.E0(), Long.valueOf(relationSeriesSingleViewModel.F0())));
                A(startRestartGroup, 0);
                startRestartGroup.endMovableGroup();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t;
                    t = RelationSeriesDialogViewKt.t(i, (Composer) obj, ((Integer) obj2).intValue());
                    return t;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(1948473673);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1948473673, i, -1, "com.dragon.read.kmp.view.HeaderBookLayout (RelationSeriesDialogView.kt:151)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                c.a V0 = ((RelationSeriesSingleViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(RelationSeriesSingleViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0)).V0();
                if (V0 != null) {
                    float g = x0.i.g(8);
                    startRestartGroup.startReplaceGroup(-1814856593);
                    Modifier.a aVar = Modifier.Companion;
                    a3.a(SizeKt.i(aVar, g), startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                    p(V0, startRestartGroup, c.a.e);
                    float g2 = x0.i.g(16);
                    startRestartGroup.startReplaceGroup(-1814856593);
                    a3.a(SizeKt.i(aVar, g2), startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                }
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.s0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit v;
                    v = RelationSeriesDialogViewKt.v(i, (Composer) obj, ((Integer) obj2).intValue());
                    return v;
                }
            });
        }
    }

    public static final void A(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        Modifier f;
        Composer startRestartGroup = composer.startRestartGroup(-612635119);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-612635119, i, -1, "com.dragon.read.kmp.view.RelationSeriesCommonLayout (RelationSeriesDialogView.kt:221)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final RelationSeriesSingleViewModel relationSeriesSingleViewModel = (RelationSeriesSingleViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(RelationSeriesSingleViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final gk4.g0 E0 = relationSeriesSingleViewModel.E0();
                if (E0 == null) {
                    com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "RelationSeriesDialogView", "RelationSeriesCommonLayout params is null", (Throwable) null, 4, (Object) null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    t3 endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.h0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit B;
                                B = RelationSeriesDialogViewKt.B(i, (Composer) obj, ((Integer) obj2).intValue());
                                return B;
                            }
                        });
                        return;
                    }
                    return;
                }
                com.dragon.read.kmp.j.a.a("RelationSeriesDialogView", "RelationSeriesCommonLayout params = " + E0 + ' ' + relationSeriesSingleViewModel.G0());
                if (relationSeriesSingleViewModel.G0()) {
                    f = SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null);
                } else {
                    f = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                }
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance = startRestartGroup.changedInstance(relationSeriesSingleViewModel) | startRestartGroup.changedInstance(E0);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function2() { // from class: com.dragon.read.kmp.view.i0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit C;
                            C = RelationSeriesDialogViewKt.C(RelationSeriesSingleViewModel.this, E0, (Function1) obj, (Function1) obj2);
                            return C;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                c cVar = c.a;
                CommonLayoutKt.i((Function2) rememberedValue, f, null, cVar.a(), null, cVar.b(), androidx.compose.runtime.internal.t.e(2007300161, true, new a(relationSeriesSingleViewModel, E0), startRestartGroup, 54), startRestartGroup, 1772544, 20);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.view.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit F;
                    F = RelationSeriesDialogViewKt.F(i, (Composer) obj, ((Integer) obj2).intValue());
                    return F;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(1749482337);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1749482337, i, -1, "com.dragon.read.kmp.view.SplitModeHeaderLayout (RelationSeriesDialogView.kt:119)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final RelationSeriesSingleViewModel relationSeriesSingleViewModel = (RelationSeriesSingleViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(RelationSeriesSingleViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                float g = x0.i.g(24);
                startRestartGroup.startReplaceGroup(-1814856593);
                Modifier.a aVar = Modifier.Companion;
                a3.a(SizeKt.i(aVar, g), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                Modifier v = f2.v(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(52)), x0.i.g(16), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                androidx.compose.ui.layout.p0 i2 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.h(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
                g5.e(b2, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier s = SizeKt.s(aVar, x0.i.g(28));
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(relationSeriesSingleViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.view.p0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit K;
                            K = RelationSeriesDialogViewKt.K(RelationSeriesSingleViewModel.this);
                            return K;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(b4.p(d4.a), startRestartGroup, 0), "返回icon", ClickableKt.clickable-oSLSa3U$default(s, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(og4.a.a.h(startRestartGroup, og4.a.b).k()), 0, startRestartGroup, 48, 184);
                startRestartGroup.endNode();
                float g2 = x0.i.g(8);
                startRestartGroup.startReplaceGroup(-1814856593);
                a3.a(SizeKt.i(aVar, g2), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit L;
                    L = RelationSeriesDialogViewKt.L(i, (Composer) obj, ((Integer) obj2).intValue());
                    return L;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Composer composer, final int i) {
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(-564273408);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-564273408, i, -1, "com.dragon.read.kmp.view.HeaderLayout (RelationSeriesDialogView.kt:144)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier i2 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(20));
            androidx.compose.ui.layout.p0 b2 = r2.b(androidx.compose.foundation.layout.e.a.d(), androidx.compose.ui.e.a.i(), startRestartGroup, 54);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, i2);
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
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, b2, companion.c());
            g5.e(b3, currentCompositionLocalMap, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                b3.updateRememberedValue(Integer.valueOf(a2));
                b3.apply(Integer.valueOf(a2), b4);
            }
            g5.e(b3, e, companion.d());
            w2 w2Var = w2.b;
            androidx.compose.foundation.layout.m.b(BackgroundKt.d(ig4.i.c(SizeKt.i(SizeKt.x(aVar, x0.i.g(36)), x0.i.g(4)), x0.i.d(x0.i.g(2)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), og4.a.a.h(startRestartGroup, og4.a.b).o(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit x;
                    x = RelationSeriesDialogViewKt.x(i, (Composer) obj, ((Integer) obj2).intValue());
                    return x;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final LazyListState lazyListState, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1478243368);
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
        boolean z2 = true;
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1478243368, i2, -1, "com.dragon.read.kmp.view.PanelScrollEffect (RelationSeriesDialogView.kt:275)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                RelationSeriesSingleViewModel relationSeriesSingleViewModel = (RelationSeriesSingleViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(RelationSeriesSingleViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(-1633490746);
                if ((i2 & 14) != 4) {
                    z2 = false;
                }
                boolean changedInstance = startRestartGroup.changedInstance(relationSeriesSingleViewModel) | z2;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new RelationSeriesDialogViewKt$PanelScrollEffect$1$1(lazyListState, relationSeriesSingleViewModel, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue, startRestartGroup, 6);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit z3;
                    z3 = RelationSeriesDialogViewKt.z(lazyListState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return z3;
                }
            });
        }
    }

    private static final void p(final c.a aVar, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        boolean z2;
        boolean changedInstance;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(949176914);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(aVar);
            } else {
                changedInstance = startRestartGroup.changedInstance(aVar);
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
                ComposerKt.traceEventStart(949176914, i2, -1, "com.dragon.read.kmp.view.BookNavigatorLayout (RelationSeriesDialogView.kt:162)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final RelationSeriesSingleViewModel relationSeriesSingleViewModel = (RelationSeriesSingleViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(RelationSeriesSingleViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                Modifier.a aVar2 = Modifier.Companion;
                float f = 16;
                Modifier c2 = ig4.i.c(f2.t(SizeKt.i(SizeKt.h(aVar2, 0.0f, 1, (Object) null), x0.i.g(36)), x0.i.g(f), 0.0f, 2, (Object) null), x0.i.d(x0.i.g(8)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null);
                og4.a aVar3 = og4.a.a;
                int i4 = og4.a.b;
                Modifier d = BackgroundKt.d(c2, aVar3.h(startRestartGroup, i4).o(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance2 = startRestartGroup.changedInstance(relationSeriesSingleViewModel);
                if ((i2 & 14) != 4 && ((8 & i2) == 0 || !startRestartGroup.changedInstance(aVar))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                boolean z3 = z2 | changedInstance2;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.view.f0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit q;
                            q = RelationSeriesDialogViewKt.q(RelationSeriesSingleViewModel.this, aVar);
                            return q;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                e.a aVar4 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar4.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
                g5.e(b2, i5, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                    b2.updateRememberedValue(Integer.valueOf(a2));
                    b2.apply(Integer.valueOf(a2), b3);
                }
                g5.e(b2, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                float f2 = 12;
                Modifier t = f2.t(SizeKt.f(aVar2, 0.0f, 1, (Object) null), x0.i.g(f2), 0.0f, 2, (Object) null);
                androidx.compose.ui.layout.p0 b4 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar4.i(), startRestartGroup, 54);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, t);
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
                g5.e(b5, e2, companion.d());
                w2 w2Var = w2.b;
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(b4.z(d4.a), startRestartGroup, 0), "书籍icon", SizeKt.s(aVar2, x0.i.g(f)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(aVar3.h(startRestartGroup, i4).k()), 0, startRestartGroup, 432, 184);
                float g = x0.i.g(4);
                startRestartGroup.startReplaceGroup(-344996060);
                a3.a(SizeKt.x(aVar2, g), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                a6.j("原著小说《" + aVar.c + (char) 12299, (Modifier) null, aVar3.h(startRestartGroup, i4).k(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 3072, 0, 131058);
                composer2 = startRestartGroup;
                a3.a(u2.a(w2Var, aVar2, 1.0f, false, 2, (Object) null), composer2, 0);
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(d2.E(f2.a.a), composer2, 0), "引导icon", SizeKt.s(aVar2, x0.i.g(f2)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(aVar3.h(composer2, i4).k()), 0, composer2, 432, 184);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit r;
                    r = RelationSeriesDialogViewKt.r(aVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return r;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(RelationSeriesSingleViewModel relationSeriesSingleViewModel, gk4.g0 g0Var, final Function1 resolve, final Function1 reject) {
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        com.dragon.read.kmp.j.a.d("RelationSeriesDialogView", "RelationSeriesDialogView loadData");
        relationSeriesSingleViewModel.J0(g0Var, new Function1() { // from class: com.dragon.read.kmp.view.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit D;
                D = RelationSeriesDialogViewKt.D(Function1.this, (gk4.f0) obj);
                return D;
            }
        }, new Function1() { // from class: com.dragon.read.kmp.view.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit E;
                E = RelationSeriesDialogViewKt.E(Function1.this, (Throwable) obj);
                return E;
            }
        });
        return Unit.INSTANCE;
    }

    public static final void G(final gk4.e0 data, final xm4.a depend, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        Modifier a2;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(depend, "depend");
        Composer startRestartGroup = composer.startRestartGroup(396641490);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(data)) {
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
                changedInstance = startRestartGroup.changed(depend);
            } else {
                changedInstance = startRestartGroup.changedInstance(depend);
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
                ComposerKt.traceEventStart(396641490, i2, -1, "com.dragon.read.kmp.view.RelationSeriesDialogView (RelationSeriesDialogView.kt:80)");
            }
            com.dragon.read.kmp.viewmodel.s sVar = new com.dragon.read.kmp.viewmodel.s(data, depend);
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                RelationSeriesSingleViewModel relationSeriesSingleViewModel = (RelationSeriesSingleViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(RelationSeriesSingleViewModel.class), c, (String) null, sVar, creationExtras, startRestartGroup, 0, 0);
                com.dragon.read.kmp.j.a.a("RelationSeriesDialogView", "RelationSeriesDialogView data = " + data);
                gk4.g0 E0 = relationSeriesSingleViewModel.E0();
                if (E0 == null) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    t3 endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.m0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit H;
                                H = RelationSeriesDialogViewKt.H(gk4.e0.this, depend, i, (Composer) obj, ((Integer) obj2).intValue());
                                return H;
                            }
                        });
                        return;
                    }
                    return;
                }
                float v1 = ((x0.e) startRestartGroup.consume(CompositionLocalsKt.f())).v1(data.c);
                if (data.b) {
                    float f = 12;
                    a2 = androidx.compose.ui.draw.e.a(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), k.g.e(x0.i.g(f), x0.i.g(f), 0.0f, x0.i.g(f), 4, (Object) null));
                } else {
                    float f2 = 12;
                    a2 = androidx.compose.ui.draw.e.a(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), k.g.e(x0.i.g(f2), x0.i.g(f2), 0.0f, 0.0f, 12, (Object) null));
                }
                ym4.f.c("RelationSeriesDialogView", E0, androidx.compose.runtime.internal.t.e(-151051587, true, new b(a2, v1, data), startRestartGroup, 54), startRestartGroup, 390);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.view.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit I;
                    I = RelationSeriesDialogViewKt.I(gk4.e0.this, depend, i, (Composer) obj, ((Integer) obj2).intValue());
                    return I;
                }
            });
        }
    }
}
