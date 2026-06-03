package com.dragon.read.kmp.share.view;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.d0;
import androidx.compose.animation.core.s2;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.k2;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.v2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.b1;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.share.view.PostShareFullscreenPanelKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PostShareFullscreenPanelKt {
    private static final float a;
    private static final float b;
    private static final float c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function0 function0, Function0 function02, Modifier modifier, Function4 function4, Function3 function3, int i, int i2, Composer composer, int i3) {
        c(function0, function02, modifier, function4, function3, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ x0.e a;
        final /* synthetic */ v2 b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;
        final /* synthetic */ MutableState<Integer> e;
        final /* synthetic */ State<Float> f;
        final /* synthetic */ Function4<Modifier, x0.i, Composer, Integer, Unit> g;
        final /* synthetic */ MutableState<Boolean> h;
        final /* synthetic */ Function3<Function0<Unit>, Composer, Integer, Unit> i;
        final /* synthetic */ Function0<Unit> j;
        final /* synthetic */ MutableState<Function0<Unit>> k;

        /* JADX WARN: Multi-variable type inference failed */
        a(x0.e eVar, v2 v2Var, long j, long j2, MutableState<Integer> mutableState, State<Float> state, Function4<? super Modifier, ? super x0.i, ? super Composer, ? super Integer, Unit> function4, MutableState<Boolean> mutableState2, Function3<? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function3, Function0<Unit> function0, MutableState<Function0<Unit>> mutableState3) {
            this.a = eVar;
            this.b = v2Var;
            this.c = j;
            this.d = j2;
            this.e = mutableState;
            this.f = state;
            this.g = function4;
            this.h = mutableState2;
            this.i = function3;
            this.j = function0;
            this.k = mutableState3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int j(int i) {
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int k(int i) {
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h() {
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit i(State state, c1 graphicsLayer) {
            Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
            graphicsLayer.c(PostShareFullscreenPanelKt.d(state));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(MutableState mutableState, androidx.compose.ui.layout.w coordinates) {
            Intrinsics.checkNotNullParameter(coordinates, "coordinates");
            PostShareFullscreenPanelKt.j(mutableState, (int) (coordinates.a() & 4294967295L));
            return Unit.INSTANCE;
        }

        /* renamed from: com.dragon.read.kmp.share.view.PostShareFullscreenPanelKt$a$a, reason: collision with other inner class name */
        static final class C0060a implements Function3<androidx.compose.animation.e, Composer, Integer, Unit> {
            final /* synthetic */ Function3<Function0<Unit>, Composer, Integer, Unit> a;
            final /* synthetic */ Function0<Unit> b;
            final /* synthetic */ MutableState<Function0<Unit>> c;
            final /* synthetic */ MutableState<Boolean> d;

            /* JADX WARN: Multi-variable type inference failed */
            C0060a(Function3<? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function3, Function0<Unit> function0, MutableState<Function0<Unit>> mutableState, MutableState<Boolean> mutableState2) {
                this.a = function3;
                this.b = function0;
                this.c = mutableState;
                this.d = mutableState2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit c(Function0 function0, MutableState mutableState, MutableState mutableState2) {
                PostShareFullscreenPanelKt.m(mutableState, mutableState2, function0);
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
                    ComposerKt.traceEventStart(715925068, i, -1, "com.dragon.read.kmp.share.view.PostShareFullscreenPanel.<anonymous>.<anonymous> (PostShareFullscreenPanel.kt:134)");
                }
                Function3<Function0<Unit>, Composer, Integer, Unit> function3 = this.a;
                composer.startReplaceGroup(-1746271574);
                boolean changed = composer.changed(this.b);
                final Function0<Unit> function0 = this.b;
                final MutableState<Function0<Unit>> mutableState = this.c;
                final MutableState<Boolean> mutableState2 = this.d;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.share.view.j
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = PostShareFullscreenPanelKt.a.C0060a.c(Function0.this, mutableState, mutableState2);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                function3.invoke((Function0) rememberedValue, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            f(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void f(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
            int i2;
            boolean z;
            x0.i coerceAtLeast;
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
                    ComposerKt.traceEventStart(1387082788, i2, -1, "com.dragon.read.kmp.share.view.PostShareFullscreenPanel.<anonymous> (PostShareFullscreenPanel.kt:87)");
                }
                float g = BoxWithConstraints.g();
                float v1 = this.a.v1(PostShareFullscreenPanelKt.i(this.e));
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(x0.i.d(x0.i.g(x0.i.g(x0.i.g(BoxWithConstraints.f() - v1) - PostShareFullscreenPanelKt.b) - PostShareFullscreenPanelKt.c)), x0.i.d(x0.i.g(0)));
                float m = coerceAtLeast.m();
                float g2 = x0.i.g(v1 + PostShareFullscreenPanelKt.c);
                Modifier.a aVar = Modifier.Companion;
                Modifier i4 = k2.i(f2.v(SizeKt.f(aVar, 0.0f, 1, (Object) null), PostShareFullscreenPanelKt.a, 0.0f, PostShareFullscreenPanelKt.a, 0.0f, 10, (Object) null), this.b, false, (l1) null, false, 14, (Object) null);
                final State<Float> state = this.f;
                Function4<Modifier, x0.i, Composer, Integer, Unit> function4 = this.g;
                e.m i5 = androidx.compose.foundation.layout.e.a.i();
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 a = androidx.compose.foundation.layout.x.a(i5, aVar2.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, i4);
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
                c0 c0Var = c0.b;
                a3.a(SizeKt.k(aVar, PostShareFullscreenPanelKt.b, 0.0f, 2, (Object) null), composer, 6);
                Modifier k = SizeKt.k(SizeKt.h(aVar, 0.0f, 1, (Object) null), m, 0.0f, 2, (Object) null);
                p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, k);
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
                Composer b3 = g5.b(composer);
                g5.e(b3, i6, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                    b3.updateRememberedValue(Integer.valueOf(a4));
                    b3.apply(Integer.valueOf(a4), b4);
                }
                g5.e(b3, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                composer.startReplaceGroup(5004770);
                boolean changed = composer.changed(state);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.share.view.e
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit i7;
                            i7 = PostShareFullscreenPanelKt.a.i(state, (c1) obj);
                            return i7;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier a6 = b1.a(aVar, (Function1) rememberedValue);
                p0 i7 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a7 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, a6);
                Function0 a8 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a8);
                } else {
                    composer.useNode();
                }
                Composer b5 = g5.b(composer);
                g5.e(b5, i7, companion.c());
                g5.e(b5, currentCompositionLocalMap3, companion.e());
                Function2 b6 = companion.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a7))) {
                    b5.updateRememberedValue(Integer.valueOf(a7));
                    b5.apply(Integer.valueOf(a7), b6);
                }
                g5.e(b5, e3, companion.d());
                function4.invoke(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.d(g), composer, 6);
                composer.endNode();
                composer.endNode();
                a3.a(SizeKt.k(aVar, g2, 0.0f, 2, (Object) null), composer, 0);
                composer.endNode();
                boolean g3 = PostShareFullscreenPanelKt.g(this.h);
                s2 n = androidx.compose.animation.core.j.n((int) this.c, 0, (d0) null, 6, (Object) null);
                composer.startReplaceGroup(1849434622);
                Object rememberedValue2 = composer.rememberedValue();
                Composer.Companion companion2 = Composer.Companion;
                if (rememberedValue2 == companion2.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.share.view.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            int j;
                            j = PostShareFullscreenPanelKt.a.j(((Integer) obj).intValue());
                            return Integer.valueOf(j);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                androidx.compose.animation.q c = EnterExitTransitionKt.D(n, (Function1) rememberedValue2).c(EnterExitTransitionKt.o(androidx.compose.animation.core.j.n((int) this.c, 0, (d0) null, 6, (Object) null), 0.0f, 2, (Object) null));
                s2 n2 = androidx.compose.animation.core.j.n((int) this.d, 0, (d0) null, 6, (Object) null);
                composer.startReplaceGroup(1849434622);
                Object rememberedValue3 = composer.rememberedValue();
                if (rememberedValue3 == companion2.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.share.view.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            int k2;
                            k2 = PostShareFullscreenPanelKt.a.k(((Integer) obj).intValue());
                            return Integer.valueOf(k2);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                androidx.compose.animation.s c2 = EnterExitTransitionKt.H(n2, (Function1) rememberedValue3).c(EnterExitTransitionKt.q(androidx.compose.animation.core.j.n((int) this.d, 0, (d0) null, 6, (Object) null), 0.0f, 2, (Object) null));
                Modifier b7 = BoxWithConstraints.b(aVar, aVar2.b());
                composer.startReplaceGroup(5004770);
                final MutableState<Integer> mutableState = this.e;
                Object rememberedValue4 = composer.rememberedValue();
                if (rememberedValue4 == companion2.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.share.view.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit g4;
                            g4 = PostShareFullscreenPanelKt.a.g(mutableState, (androidx.compose.ui.layout.w) obj);
                            return g4;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue4);
                }
                composer.endReplaceGroup();
                Modifier a9 = d1.a(b7, (Function1) rememberedValue4);
                composer.startReplaceGroup(1849434622);
                Object rememberedValue5 = composer.rememberedValue();
                if (rememberedValue5 == companion2.getEmpty()) {
                    rememberedValue5 = androidx.compose.foundation.interaction.h.a();
                    composer.updateRememberedValue(rememberedValue5);
                }
                androidx.compose.foundation.interaction.i iVar = (androidx.compose.foundation.interaction.i) rememberedValue5;
                composer.endReplaceGroup();
                composer.startReplaceGroup(1849434622);
                Object rememberedValue6 = composer.rememberedValue();
                if (rememberedValue6 == companion2.getEmpty()) {
                    rememberedValue6 = new Function0() { // from class: com.dragon.read.kmp.share.view.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit h;
                            h = PostShareFullscreenPanelKt.a.h();
                            return h;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue6);
                }
                composer.endReplaceGroup();
                AnimatedVisibilityKt.j(g3, ClickableKt.clickable-O2vRcR0$default(a9, iVar, (androidx.compose.foundation.b1) null, false, (String) null, (Role) null, (Function0) rememberedValue6, 28, (Object) null), c, c2, (String) null, androidx.compose.runtime.internal.t.e(715925068, true, new C0060a(this.i, this.j, this.k, this.h), composer, 54), composer, 196608, 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static {
        Covode.recordClassIndex(608986);
        float f = 50;
        a = x0.i.g(f);
        b = x0.i.g(f);
        c = x0.i.g(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> k(MutableState<Function0<Unit>> mutableState) {
        return (Function0) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float d(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(MutableState<Function0<Unit>> mutableState, Function0<Unit> function0) {
        mutableState.setValue(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function0 function0, MutableState mutableState, MutableState mutableState2) {
        m(mutableState, mutableState2, function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MutableState<Function0<Unit>> mutableState, MutableState<Boolean> mutableState2, Function0<Unit> function0) {
        if (k(mutableState) != null) {
            return;
        }
        l(mutableState, function0);
        h(mutableState2, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(final kotlin.jvm.functions.Function0<kotlin.Unit> r33, final kotlin.jvm.functions.Function0<kotlin.Unit> r34, androidx.compose.ui.Modifier r35, final kotlin.jvm.functions.Function4<? super androidx.compose.ui.Modifier, ? super x0.i, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, final kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function0<kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instructions count: 657
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.share.view.PostShareFullscreenPanelKt.c(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function4, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
