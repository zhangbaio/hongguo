package com.dragon.read.kmp.shortvideo.distribution.page;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.material.n2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesNormalRankPageKt;
import com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesTopicRankPageKt;
import com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel;
import com.dragon.read.kmp.utils.q;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import x0.x;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesRankPageContainerKt {
    static {
        Covode.recordClassIndex(609049);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(ko4.b bVar, int i, Composer composer, int i2) {
        h(bVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(ko4.b bVar, int i, Composer composer, int i2) {
        h(bVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(int i, Composer composer, int i2) {
        l(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j() {
        zm4.d.a.b();
        return Unit.INSTANCE;
    }

    private static final ko4.b m(MutableState<ko4.b> mutableState) {
        return (ko4.b) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(SeriesRankViewModel seriesRankViewModel) {
        seriesRankViewModel.T0();
        return Unit.INSTANCE;
    }

    public static final void l(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(800100968);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(800100968, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.SeriesRankPageContainer (SeriesRankPageContainer.kt:49)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = seriesRankViewModel.d;
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.j
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit n;
                            n = SeriesRankPageContainerKt.n(SeriesRankViewModel.this, coroutineScope, mutableState);
                            return n;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                Function0 function0 = (Function0) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.k
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            boolean o;
                            o = SeriesRankPageContainerKt.o();
                            return Boolean.valueOf(o);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                ig4.e.e((Function0) rememberedValue4, function0, startRestartGroup, 54);
                Modifier.a aVar = Modifier.Companion;
                Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                og4.a aVar2 = og4.a.a;
                int i2 = og4.a.b;
                Modifier d = BackgroundKt.d(f, aVar2.h(startRestartGroup, i2).b(), (f2) null, 2, (Object) null);
                p0 i3 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, d);
                ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                Function0 a2 = companion2.a();
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
                g5.e(b, i3, companion2.c());
                g5.e(b, currentCompositionLocalMap, companion2.e());
                Function2 b2 = companion2.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                if (mg4.c.a(m(mutableState).a)) {
                    startRestartGroup.startReplaceGroup(-652794825);
                    if (seriesRankViewModel.a.c()) {
                        startRestartGroup.startReplaceGroup(-652734189);
                        SeriesTopicRankPageKt.f(startRestartGroup, 0);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-652653868);
                        SeriesNormalRankPageKt.e0(startRestartGroup, 0);
                        startRestartGroup.endReplaceGroup();
                    }
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-652563100);
                    LoadStatus loadStatus = m(mutableState).a;
                    startRestartGroup.startReplaceGroup(5004770);
                    boolean changedInstance = startRestartGroup.changedInstance(seriesRankViewModel);
                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue5 == companion.getEmpty()) {
                        rememberedValue5 = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.l
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit p;
                                p = SeriesRankPageContainerKt.p(SeriesRankViewModel.this);
                                return p;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    startRestartGroup.endReplaceGroup();
                    e.c(loadStatus, (Function0) rememberedValue5, startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                }
                h(m(mutableState), startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(671691854);
                if (q.a.a()) {
                    composer2 = startRestartGroup;
                    a6.j("kmp page", androidx.compose.foundation.layout.f2.v(aVar, 0.0f, x0.i.g(30), 0.0f, 0.0f, 13, (Object) null), aVar2.h(startRestartGroup, i2).M(), x.h(12), (y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3126, 0, 131056);
                } else {
                    composer2 = startRestartGroup;
                }
                composer2.endReplaceGroup();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit q;
                    q = SeriesRankPageContainerKt.q(i, (Composer) obj, ((Integer) obj2).intValue());
                    return q;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(SeriesRankViewModel seriesRankViewModel, CoroutineScope coroutineScope, MutableState mutableState) {
        boolean z = true;
        if (((Boolean) m(mutableState).e.getValue()).booleanValue()) {
            m(mutableState).e.setValue(Boolean.FALSE);
            return Unit.INSTANCE;
        }
        n2 n2Var = seriesRankViewModel.l;
        if (n2Var == null || !n2Var.m()) {
            z = false;
        }
        if (!z) {
            zm4.d.a.b();
            return Unit.INSTANCE;
        }
        kotlinx.coroutines.i.e(coroutineScope, null, null, new SeriesRankPageContainerKt$SeriesRankPageContainer$onBack$1$1$1(seriesRankViewModel, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final void h(final ko4.b bVar, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(613007423);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(bVar)) {
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
                ComposerKt.traceEventStart(613007423, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.PageTopBar (SeriesRankPageContainer.kt:104)");
            }
            if (mg4.c.c(bVar.a)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.n
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit i4;
                            i4 = SeriesRankPageContainerKt.i(ko4.b.this, i, (Composer) obj, ((Integer) obj2).intValue());
                            return i4;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier i4 = SizeKt.i(SizeKt.F(androidx.compose.foundation.layout.f2.v(aVar, x0.i.g(10), x0.i.g(b1.a.s()), 0.0f, 0.0f, 12, (Object) null), (e.b) null, false, 3, (Object) null), po4.b.d());
            p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), startRestartGroup, 54);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, i4);
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
            w2 w2Var = w2.b;
            e1 a3 = org.jetbrains.compose.resources.c.a(d2.N(f2.a.a), startRestartGroup, 0);
            m0 d = ig4.i.d(og4.a.a.h(startRestartGroup, og4.a.b).k());
            Modifier s = SizeKt.s(aVar, x0.i.g(24));
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit j;
                        j = SeriesRankPageContainerKt.j();
                        return j;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            z0.g(a3, "返回键", ClickableKt.clickable-oSLSa3U$default(s, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, d, 0, startRestartGroup, 48, 184);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = SeriesRankPageContainerKt.k(ko4.b.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }
}
