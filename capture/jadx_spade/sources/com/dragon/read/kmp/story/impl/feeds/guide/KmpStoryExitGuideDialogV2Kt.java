package com.dragon.read.kmp.story.impl.feeds.guide;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.f1;
import androidx.compose.animation.core.m0;
import androidx.compose.animation.core.s2;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.y2;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.image.options.i;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.story.impl.feeds.guide.KmpBaseStoryExitAlertHelper;
import com.dragon.read.kmp.story.impl.feeds.guide.KmpStoryExitGuideDialogV2Kt;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpStoryExitGuideDialogV2Kt {
    static {
        Covode.recordClassIndex(609293);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(kp4.b bVar, long j, Function1 function1, int i, Composer composer, int i2) {
        l(bVar, j, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(w wVar, kp4.b bVar, int i, Composer composer, int i2) {
        o(wVar, bVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(kp4.b bVar, w wVar, Function1 function1, int i, Composer composer, int i2) {
        t(bVar, wVar, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final class a implements com.bytedance.kmp.image.options.i {
        final /* synthetic */ Ref$ObjectRef<MutableState<Boolean>> a;

        public void onLoadStart() {
            i.a.b(this);
        }

        a(Ref$ObjectRef<MutableState<Boolean>> ref$ObjectRef) {
            this.a = ref$ObjectRef;
        }

        public void onFail(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            i.a.a(this, error);
        }

        public void a(i.c successResult) {
            Intrinsics.checkNotNullParameter(successResult, "successResult");
            i.a.c(this, successResult);
            this.a.element.setValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1) {
        function1.invoke(KmpBaseStoryExitAlertHelper.DialogEvent.CLOSE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function1 function1) {
        function1.invoke(KmpBaseStoryExitAlertHelper.DialogEvent.GO_TO_READ);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function1 function1) {
        function1.invoke(KmpBaseStoryExitAlertHelper.DialogEvent.EXIT);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function1 function1) {
        function1.invoke(KmpBaseStoryExitAlertHelper.DialogEvent.GO_TO_READ);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Ref$ObjectRef ref$ObjectRef, y2 layoutResult) {
        Intrinsics.checkNotNullParameter(layoutResult, "layoutResult");
        if (layoutResult.k() >= 2) {
            ((MutableState) ref$ObjectRef.element).setValue(4);
        }
        return Unit.INSTANCE;
    }

    static final class b implements Function3<androidx.compose.animation.e, Composer, Integer, Unit> {
        final /* synthetic */ kp4.b a;
        final /* synthetic */ w b;
        final /* synthetic */ f1<Boolean> c;
        final /* synthetic */ MutableState<KmpBaseStoryExitAlertHelper.DialogEvent> d;

        b(kp4.b bVar, w wVar, f1<Boolean> f1Var, MutableState<KmpBaseStoryExitAlertHelper.DialogEvent> mutableState) {
            this.a = bVar;
            this.b = wVar;
            this.c = f1Var;
            this.d = mutableState;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(MutableState mutableState, f1 f1Var, KmpBaseStoryExitAlertHelper.DialogEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            mutableState.setValue(event);
            f1Var.i(Boolean.FALSE);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.animation.e eVar, Composer composer, Integer num) {
            b(eVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(androidx.compose.animation.e AnimatedVisibility, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(176296038, i, -1, "com.dragon.read.kmp.story.impl.feeds.guide.KmpStoryExitGuideDialogV2.<anonymous>.<anonymous> (KmpStoryExitGuideDialogV2.kt:95)");
            }
            kp4.b bVar = this.a;
            w wVar = this.b;
            composer.startReplaceGroup(-1633490746);
            boolean changedInstance = composer.changedInstance(this.c);
            final MutableState<KmpBaseStoryExitAlertHelper.DialogEvent> mutableState = this.d;
            final f1<Boolean> f1Var = this.c;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit c;
                        c = KmpStoryExitGuideDialogV2Kt.b.c(mutableState, f1Var, (KmpBaseStoryExitAlertHelper.DialogEvent) obj);
                        return c;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            KmpStoryExitGuideDialogV2Kt.t(bVar, wVar, (Function1) rememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final void o(final w agent, final kp4.b bVar, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        Boolean bool;
        MutableState mutableState;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(agent, "agent");
        Composer startRestartGroup = composer.startRestartGroup(-1209480531);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(agent)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(bVar)) {
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
                ComposerKt.traceEventStart(-1209480531, i2, -1, "com.dragon.read.kmp.story.impl.feeds.guide.KmpStoryExitGuideDialogV2 (KmpStoryExitGuideDialogV2.kt:67)");
            }
            if (bVar != null) {
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                Object obj = rememberedValue;
                if (rememberedValue == companion.getEmpty()) {
                    f1 f1Var = new f1(Boolean.FALSE);
                    f1Var.i(Boolean.TRUE);
                    startRestartGroup.updateRememberedValue(f1Var);
                    obj = f1Var;
                }
                f1 f1Var2 = (f1) obj;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt.mutableStateOf$default(KmpBaseStoryExitAlertHelper.DialogEvent.NONE, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                MutableState mutableState2 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                Boolean valueOf = Boolean.valueOf(f1Var2.h());
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changedInstance = startRestartGroup.changedInstance(f1Var2) | startRestartGroup.changedInstance(agent) | startRestartGroup.changedInstance(bVar);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changedInstance && rememberedValue3 != companion.getEmpty()) {
                    bool = valueOf;
                    mutableState = mutableState2;
                } else {
                    bool = valueOf;
                    mutableState = mutableState2;
                    KmpStoryExitGuideDialogV2Kt$KmpStoryExitGuideDialogV2$1$1 kmpStoryExitGuideDialogV2Kt$KmpStoryExitGuideDialogV2$1$1 = new KmpStoryExitGuideDialogV2Kt$KmpStoryExitGuideDialogV2$1$1(f1Var2, agent, mutableState2, bVar, null);
                    startRestartGroup.updateRememberedValue(kmpStoryExitGuideDialogV2Kt$KmpStoryExitGuideDialogV2$1$1);
                    rememberedValue3 = kmpStoryExitGuideDialogV2Kt$KmpStoryExitGuideDialogV2$1$1;
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(bool, (Function2) rememberedValue3, startRestartGroup, 0);
                Modifier d = BackgroundKt.d(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), l0.n(l0.b.a(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (f2) null, 2, (Object) null);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.k
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit s;
                            s = KmpStoryExitGuideDialogV2Kt.s();
                            return s;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue4, 15, (Object) null);
                p0 i5 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.b(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
                g5.e(b2, i5, companion2.c());
                g5.e(b2, currentCompositionLocalMap, companion2.e());
                Function2 b3 = companion2.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                    b2.updateRememberedValue(Integer.valueOf(a2));
                    b2.apply(Integer.valueOf(a2), b3);
                }
                g5.e(b2, e, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                s2 n = androidx.compose.animation.core.j.n(300, 0, m0.c(), 2, (Object) null);
                s2 n2 = androidx.compose.animation.core.j.n(300, 0, m0.c(), 2, (Object) null);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            int p;
                            p = KmpStoryExitGuideDialogV2Kt.p(((Integer) obj2).intValue());
                            return Integer.valueOf(p);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                androidx.compose.animation.q c = EnterExitTransitionKt.D(n, (Function1) rememberedValue5).c(EnterExitTransitionKt.n(n2, 0.0f));
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == companion.getEmpty()) {
                    rememberedValue6 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            int q;
                            q = KmpStoryExitGuideDialogV2Kt.q(((Integer) obj2).intValue());
                            return Integer.valueOf(q);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                AnimatedVisibilityKt.d(f1Var2, (Modifier) null, c, EnterExitTransitionKt.H(n, (Function1) rememberedValue6).c(EnterExitTransitionKt.p(n2, 0.0f)), (String) null, androidx.compose.runtime.internal.t.e(176296038, true, new b(bVar, agent, f1Var2, mutableState), startRestartGroup, 54), startRestartGroup, f1.d | 196608, 18);
                composer2.endNode();
            } else {
                composer2 = startRestartGroup;
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit r;
                    r = KmpStoryExitGuideDialogV2Kt.r(w.this, bVar, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return r;
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r6v15, types: [T, androidx.compose.runtime.MutableState] */
    private static final void l(final kp4.b bVar, final long j, final Function1<? super KmpBaseStoryExitAlertHelper.DialogEvent, Unit> function1, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(570723708);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(bVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(j)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        int i6 = i2;
        if ((i6 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(570723708, i6, -1, "com.dragon.read.kmp.story.impl.feeds.guide.CoverContent (KmpStoryExitGuideDialogV2.kt:242)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i7 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, h);
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
            g5.e(b2, i7, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.Companion;
            if (rememberedValue == companion2.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            ref$ObjectRef.element = (MutableState) rememberedValue;
            float f = 166;
            LoadImageKt.g(bVar.d().n, (String) null, (com.dragon.read.kmp.compose.common.image.n) null, aq4.d.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f)), false, 0.0f, 0.0f, 0.0f, x0.i.g(40), 0.0f, 0.0f, 0.0f, 0.0f, 495, null), new a(ref$ObjectRef), (kg4.b) null, (kg4.a) null, startRestartGroup, 0, 102);
            startRestartGroup.startReplaceGroup(-801769417);
            if (!((Boolean) ((MutableState) ref$ObjectRef.element).getValue()).booleanValue()) {
                Modifier i8 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f));
                p0 i9 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, i8);
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
                Composer b4 = g5.b(startRestartGroup);
                g5.e(b4, i9, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                    b4.updateRememberedValue(Integer.valueOf(a4));
                    b4.apply(Integer.valueOf(a4), b5);
                }
                g5.e(b4, e2, companion.d());
                z2 = true;
                z0.g(org.jetbrains.compose.resources.c.a(sk5.n.h(sk5.p.a), startRestartGroup, 0), "兜底图", SizeKt.i(SizeKt.x(aVar, x0.i.g(60)), x0.i.g(34)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 432, 248);
                startRestartGroup.endNode();
            } else {
                z2 = true;
            }
            startRestartGroup.endReplaceGroup();
            float f2 = 20;
            float f3 = 75;
            Modifier b6 = boxScopeInstance.b(SizeKt.i(SizeKt.x(androidx.compose.foundation.layout.f2.v(aVar, x0.i.g(f2), 0.0f, 0.0f, 0.0f, 14, (Object) null), x0.i.g(f3)), x0.i.g(f2)), aVar2.d());
            p0 i10 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, b6);
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
            Composer b7 = g5.b(startRestartGroup);
            g5.e(b7, i10, companion.c());
            g5.e(b7, currentCompositionLocalMap3, companion.e());
            Function2 b8 = companion.b();
            if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a6))) {
                b7.updateRememberedValue(Integer.valueOf(a6));
                b7.apply(Integer.valueOf(a6), b8);
            }
            g5.e(b7, e3, companion.d());
            Modifier i11 = SizeKt.i(SizeKt.x(boxScopeInstance.b(aVar, aVar2.e()), x0.i.g(f3)), x0.i.g(f2));
            sk5.p pVar = sk5.p.a;
            z0.g(org.jetbrains.compose.resources.c.a(sk5.n.i(pVar), startRestartGroup, 0), "下篇更精彩", i11, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 48, 248);
            a6.j("下篇更精彩", boxScopeInstance.b(aVar, aVar2.e()), j, x.h(12), (y) null, c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, ((i6 << 3) & 896) | 199686, 0, 131024);
            startRestartGroup.endNode();
            e1 a8 = org.jetbrains.compose.resources.c.a(sk5.n.b(pVar), startRestartGroup, 0);
            float f4 = 16;
            Modifier s = SizeKt.s(androidx.compose.foundation.layout.f2.v(aVar, x0.i.g(f4), x0.i.g(f4), 0.0f, 0.0f, 12, (Object) null), x0.i.g(24));
            startRestartGroup.startReplaceGroup(5004770);
            if ((i6 & 896) != 256) {
                z2 = false;
            }
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == companion2.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit m;
                        m = KmpStoryExitGuideDialogV2Kt.m(Function1.this);
                        return m;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            z0.g(a8, "关闭按钮", ClickableKt.clickable-oSLSa3U$default(s, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 48, 248);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n;
                    n = KmpStoryExitGuideDialogV2Kt.n(kp4.b.this, j, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return n;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x036f, code lost:
    
        r22 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r16, "￼", "", false, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0380, code lost:
    
        r5 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r22, "[^\\p{Print}\\p{Space}]", "", false, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Type inference failed for: r3v12, types: [T, androidx.compose.runtime.MutableState] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void t(final kp4.b r72, final com.dragon.read.kmp.story.impl.feeds.guide.w r73, final kotlin.jvm.functions.Function1<? super com.dragon.read.kmp.story.impl.feeds.guide.KmpBaseStoryExitAlertHelper.DialogEvent, kotlin.Unit> r74, androidx.compose.runtime.Composer r75, final int r76) {
        /*
            Method dump skipped, instructions count: 1684
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.guide.KmpStoryExitGuideDialogV2Kt.t(kp4.b, com.dragon.read.kmp.story.impl.feeds.guide.w, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }
}
