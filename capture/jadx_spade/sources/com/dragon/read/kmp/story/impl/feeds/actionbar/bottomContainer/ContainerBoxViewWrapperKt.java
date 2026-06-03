package com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.d0;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.layout.x;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import com.dragon.read.kmp.story.impl.feeds.container.n;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ContainerBoxViewWrapperKt {
    static {
        Covode.recordClassIndex(609230);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Modifier modifier, int i, int i2, Composer composer, int i3) {
        e(modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tp4.b f() {
        return new tp4.b("ContainerBoxViewWrapper");
    }

    private static final tp4.b k(Lazy<tp4.b> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kp4.b l(State<kp4.b> state) {
        return (kp4.b) state.getValue();
    }

    private static final n m(State<n> state) {
        return (n) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(State state) {
        return !m(state).g;
    }

    private static final boolean i(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    static final class a implements Function3<androidx.compose.animation.e, Composer, Integer, Unit> {
        final /* synthetic */ State<kp4.b> a;
        final /* synthetic */ KmpStoryFeedsVM b;

        a(State<kp4.b> state, KmpStoryFeedsVM kmpStoryFeedsVM) {
            this.a = state;
            this.b = kmpStoryFeedsVM;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(State state, KmpStoryFeedsVM kmpStoryFeedsVM) {
            kp4.b l = ContainerBoxViewWrapperKt.l(state);
            if (l != null) {
                kmpStoryFeedsVM.t1(l);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.animation.e eVar, Composer composer, Integer num) {
            b(eVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0152, code lost:
        
            if (((java.lang.Boolean) r0.getValue()).booleanValue() == true) goto L39;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(androidx.compose.animation.e r13, androidx.compose.runtime.Composer r14, int r15) {
            /*
                Method dump skipped, instructions count: 415
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.ContainerBoxViewWrapperKt.a.b(androidx.compose.animation.e, androidx.compose.runtime.Composer, int):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(State state, KmpStoryFeedsVM kmpStoryFeedsVM) {
        kp4.b l = l(state);
        if (l != null) {
            l.f.a.j();
            kmpStoryFeedsVM.q1(l);
        }
        return Unit.INSTANCE;
    }

    public static final void e(Modifier modifier, Composer composer, final int i, final int i2) {
        final Modifier modifier2;
        int i3;
        int i4;
        boolean z;
        Modifier modifier3;
        Lazy lazy;
        CreationExtras creationExtras;
        String str;
        boolean z2;
        boolean z3;
        Modifier modifier4;
        com.dragon.read.kmp.story.impl.feeds.data.d dVar;
        com.dragon.read.kmp.story.impl.feeds.data.d dVar2;
        Composer startRestartGroup = composer.startRestartGroup(1051147234);
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
                ComposerKt.traceEventStart(1051147234, i3, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.ContainerBoxViewWrapper (ContainerBoxViewWrapper.kt:31)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        tp4.b f;
                        f = ContainerBoxViewWrapperKt.f();
                        return f;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            lazy = LazyKt__LazyJVMKt.lazy((Function0) rememberedValue);
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                Modifier modifier5 = modifier3;
                final KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final State collectAsState = SnapshotStateKt.collectAsState(kmpStoryFeedsVM.m, (CoroutineContext) null, startRestartGroup, 0, 1);
                final State collectAsState2 = SnapshotStateKt.collectAsState(kmpStoryFeedsVM.j, (CoroutineContext) null, startRestartGroup, 0, 1);
                int i6 = i3 & 14;
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                e.m i7 = eVar.i();
                e.a aVar = androidx.compose.ui.e.a;
                int i8 = i6 >> 3;
                p0 a2 = x.a(i7, aVar.k(), startRestartGroup, (i8 & 112) | (i8 & 14));
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, modifier5);
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
                g5.e(b, a2, companion2.c());
                g5.e(b, currentCompositionLocalMap, companion2.e());
                Function2 b2 = companion2.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                    b.updateRememberedValue(Integer.valueOf(a3));
                    b.apply(Integer.valueOf(a3), b2);
                }
                g5.e(b, e, companion2.d());
                c0 c0Var = c0.b;
                int i9 = ((i6 >> 6) & 112) | 6;
                tp4.b k = k(lazy);
                StringBuilder sb = new StringBuilder();
                sb.append("Column recomposed, story: ");
                kp4.b l = l(collectAsState);
                if (l != null) {
                    str = l.j();
                } else {
                    str = null;
                }
                sb.append(str);
                sb.append(", isExpanded: ");
                kp4.b l2 = l(collectAsState);
                if (l2 != null && (dVar2 = l2.e) != null && dVar2.e()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                sb.append(z2);
                k.a(sb.toString());
                startRestartGroup.startReplaceGroup(-1536532210);
                kp4.b l3 = l(collectAsState);
                if (l3 != null && (dVar = l3.e) != null && dVar.e()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    Unit unit = Unit.INSTANCE;
                    startRestartGroup.startReplaceGroup(5004770);
                    boolean changed = startRestartGroup.changed(collectAsState);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new ContainerBoxViewWrapperKt$ContainerBoxViewWrapper$1$1$1(collectAsState, null);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue2, startRestartGroup, 6);
                    startRestartGroup.startReplaceGroup(1849434622);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.b
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                boolean h;
                                h = ContainerBoxViewWrapperKt.h(collectAsState2);
                                return Boolean.valueOf(h);
                            }
                        });
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceGroup();
                    boolean z4 = !i((State) rememberedValue3);
                    Modifier.a aVar2 = Modifier.Companion;
                    modifier4 = modifier5;
                    AnimatedVisibilityKt.g(c0Var, z4, SizeKt.D(aVar2, (androidx.compose.ui.e) null, false, 3, (Object) null), EnterExitTransitionKt.o(androidx.compose.animation.core.j.n(200, 0, (d0) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.q(androidx.compose.animation.core.j.n(200, 0, (d0) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, t.e(-2086123111, true, new a(collectAsState, kmpStoryFeedsVM), startRestartGroup, 54), startRestartGroup, 1600896 | (i9 & 14), 16);
                    Modifier t = f2.t(aVar2, x0.i.g(16), 0.0f, 2, (Object) null);
                    p0 b3 = r2.b(eVar.h(), aVar.l(), startRestartGroup, 0);
                    int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                    e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(startRestartGroup, t);
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
                    Composer b4 = g5.b(startRestartGroup);
                    g5.e(b4, b3, companion2.c());
                    g5.e(b4, currentCompositionLocalMap2, companion2.e());
                    Function2 b5 = companion2.b();
                    if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                        b4.updateRememberedValue(Integer.valueOf(a5));
                        b4.apply(Integer.valueOf(a5), b5);
                    }
                    g5.e(b4, e2, companion2.d());
                    w2 w2Var = w2.b;
                    startRestartGroup.startReplaceGroup(-1633490746);
                    boolean changed2 = startRestartGroup.changed(collectAsState) | startRestartGroup.changedInstance(kmpStoryFeedsVM);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.c
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit g;
                                g = ContainerBoxViewWrapperKt.g(collectAsState, kmpStoryFeedsVM);
                                return g;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    startRestartGroup.endReplaceGroup();
                    hp4.b.b("收起", true, (Function0) rememberedValue4, startRestartGroup, 54, 0);
                    startRestartGroup.endNode();
                } else {
                    modifier4 = modifier5;
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j;
                    j = ContainerBoxViewWrapperKt.j(modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return j;
                }
            });
        }
    }
}
