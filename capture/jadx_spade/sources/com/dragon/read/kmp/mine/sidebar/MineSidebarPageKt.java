package com.dragon.read.kmp.mine.sidebar;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.lazy.y0;
import androidx.compose.foundation.y1;
import androidx.compose.foundation.z0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.mine.o1;
import com.dragon.read.component.biz.impl.mine.w6;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.mine.model.j;
import com.dragon.read.kmp.mine.model.k;
import com.dragon.read.kmp.mine.model.l;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.service.d1;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.StateFlow;
import pg4.p;
import x0.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MineSidebarPageKt {
    static {
        Covode.recordClassIndex(607785);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(StateFlow stateFlow, fk4.a aVar, int i, Composer composer, int i2) {
        g(stateFlow, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(l lVar, int i, int i2, Composer composer, int i3) {
        j(lVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(List list, int i, Composer composer, int i2) {
        m(list, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final class b implements DisposableEffectResult {
        final /* synthetic */ j a;

        public void dispose() {
            this.a.L0();
        }

        public b(j jVar) {
            this.a = jVar;
        }
    }

    public static final class c implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public c(List list) {
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

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ State<fk4.c> a;

        a(State<fk4.c> state) {
            this.a = state;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            float max;
            org.jetbrains.compose.resources.b e;
            boolean z2 = true;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1717299902, i, -1, "com.dragon.read.kmp.mine.sidebar.MineSidebarPage.<anonymous> (MineSidebarPage.kt:80)");
                }
                float s = b1.a.s();
                Modifier.a aVar = Modifier.Companion;
                Modifier f = SizeKt.f(MineSidebarPageKt.s(aVar, composer, 6), 0.0f, 1, (Object) null);
                if (s > 6.0f) {
                    max = s - 6;
                } else {
                    max = Math.max(0.0f, s);
                }
                Modifier v = f2.v(f, 0.0f, i.g(max), 0.0f, 0.0f, 13, (Object) null);
                androidx.compose.ui.e b = androidx.compose.ui.e.a.b();
                State<fk4.c> state = this.a;
                p0 i2 = m.i(b, false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, v);
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
                Composer b2 = g5.b(composer);
                g5.e(b2, i2, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                    b2.updateRememberedValue(Integer.valueOf(a));
                    b2.apply(Integer.valueOf(a), b3);
                }
                g5.e(b2, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                composer.startReplaceGroup(-1554413244);
                List<l> list = ((fk4.c) state.getValue()).a;
                if (list != null && !list.isEmpty()) {
                    z2 = false;
                }
                if (z2) {
                    com.dragon.read.kmp.j.a.d("MineSidebarPage", "MineSidebarPage itemModels is empty");
                    composer.endReplaceGroup();
                } else {
                    MineSidebarPageKt.m(list, composer, 0);
                    if (d1.d((Theme) composer.consume(rg4.e.l()))) {
                        e = o1.d(w6.a);
                    } else {
                        e = o1.e(w6.a);
                    }
                    z0.g(com.dragon.read.kmp.compose.common.image.e.a(e, composer, 0), "hong_tag_text_icon", SizeKt.u(f2.v(aVar, 0.0f, 0.0f, 0.0f, i.g(27), 7, (Object) null), i.g(88), i.g(20)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, composer, 432, 248);
                    composer.endReplaceGroup();
                }
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
    public static final DisposableEffectResult h(j jVar, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        jVar.K0();
        return new b(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(List list, o0 LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyColumn.f(list.size(), (Function1) null, new c(list), t.c(2039820996, true, new d(list)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(j jVar, l lVar, int i) {
        jVar.M0(lVar, i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier s(Modifier modifier, Composer composer, int i) {
        c0 p;
        composer.startReplaceGroup(885322948);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885322948, i, -1, "com.dragon.read.kmp.mine.sidebar.bgLinerGradient (MineSidebarPage.kt:197)");
        }
        if (d1.d((Theme) composer.consume(rg4.e.l()))) {
            p = c0.a.p(c0.b, ek4.c.b.d2(), 0.0f, 0.0f, 0, 14, (Object) null);
        } else {
            p = c0.a.p(c0.b, ek4.c.b.Q1(), 0.0f, 0.0f, 0, 14, (Object) null);
        }
        Modifier b2 = BackgroundKt.b(modifier, p, (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final List<l> list, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1275842511);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(list)) {
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
                ComposerKt.traceEventStart(1275842511, i2, -1, "com.dragon.read.kmp.mine.sidebar.SideBarFunctionItemGroup (MineSidebarPage.kt:105)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                j jVar = (j) f2.d.c(Reflection.getOrCreateKotlinClass(j.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                LazyListState c3 = y0.c(0, 0, startRestartGroup, 0, 3);
                jVar.d = c3;
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changed = startRestartGroup.changed(c3) | startRestartGroup.changedInstance(jVar) | startRestartGroup.changedInstance(list);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new MineSidebarPageKt$SideBarFunctionItemGroup$1$1(c3, jVar, list, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(c3, (Function2) rememberedValue, startRestartGroup, 0);
                Modifier f = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                e.b k = androidx.compose.ui.e.a.k();
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(list);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.mine.sidebar.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit n;
                            n = MineSidebarPageKt.n(list, (o0) obj);
                            return n;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                androidx.compose.foundation.lazy.d.c(f, c3, (i2) null, false, (e.m) null, k, (l1) null, false, (y1) null, (Function1) rememberedValue2, startRestartGroup, 196614, 476);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.sidebar.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = MineSidebarPageKt.o(list, i, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }

    public static final class d implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;

        public d(List list) {
            this.a = list;
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
                int i6 = (i3 & 112) | (i3 & 14);
                l lVar = (l) this.a.get(i);
                composer.startReplaceGroup(-374336001);
                MineSidebarPageKt.j(lVar, i, composer, (i6 & 112) | ((i6 >> 6) & 14));
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

    public static final void g(final StateFlow<fk4.c> sidebarPageParams, final fk4.a iFunctionDepend, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(sidebarPageParams, "sidebarPageParams");
        Intrinsics.checkNotNullParameter(iFunctionDepend, "iFunctionDepend");
        Composer startRestartGroup = composer.startRestartGroup(391532177);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(sidebarPageParams)) {
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
                changedInstance = startRestartGroup.changed(iFunctionDepend);
            } else {
                changedInstance = startRestartGroup.changedInstance(iFunctionDepend);
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
                ComposerKt.traceEventStart(391532177, i5, -1, "com.dragon.read.kmp.mine.sidebar.MineSidebarPage (MineSidebarPage.kt:69)");
            }
            k kVar = new k(iFunctionDepend, sidebarPageParams);
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final j jVar = (j) f2.d.c(Reflection.getOrCreateKotlinClass(j.class), c2, (String) null, kVar, creationExtras, startRestartGroup, 0, 0);
                State collectAsState = SnapshotStateKt.collectAsState(sidebarPageParams, (CoroutineContext) null, startRestartGroup, i5 & 14, 1);
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance2 = startRestartGroup.changedInstance(jVar);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.mine.sidebar.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            DisposableEffectResult h;
                            h = MineSidebarPageKt.h(j.this, (DisposableEffectScope) obj);
                            return h;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(unit, (Function1) rememberedValue, startRestartGroup, 6);
                p.f((pg4.i) null, t.e(-1717299902, true, new a(collectAsState), startRestartGroup, 54), startRestartGroup, 48, 1);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.sidebar.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i6;
                    i6 = MineSidebarPageKt.i(StateFlow.this, iFunctionDepend, i, (Composer) obj, ((Integer) obj2).intValue());
                    return i6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(final com.dragon.read.kmp.mine.model.l r40, final int r41, androidx.compose.runtime.Composer r42, final int r43) {
        /*
            Method dump skipped, instructions count: 924
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.sidebar.MineSidebarPageKt.j(com.dragon.read.kmp.mine.model.l, int, androidx.compose.runtime.Composer, int):void");
    }
}
