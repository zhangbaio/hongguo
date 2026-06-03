package com.dragon.read.kmp.reader.ui.menu.moresettings;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.s2;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.n0;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.b1;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.ui.menu.moresettings.LockTimePickerPanelKt;
import com.dragon.read.kmp.reader.ui.menu.ui.PullDownBoxKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class LockTimePickerPanelKt {
    static {
        Covode.recordClassIndex(608617);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(List list, int i, LazyListState lazyListState, Function2 function2, Function0 function0, int i2, int i3, Composer composer, int i4) {
        h(list, i, lazyListState, function2, function0, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(o oVar, Function2 function2, Function0 function0, int i, Composer composer, int i2) {
        l(oVar, function2, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function0 function0, Function0 function02, long j, long j2, int i, Composer composer, int i2) {
        n(function0, function02, j, j2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(List list, int i, Function1 function1, int i2, float f, long j, long j2, long j3, LazyListState lazyListState, int i3, int i4, Composer composer, int i5) {
        p(list, i, function1, i2, f, j, j2, j3, lazyListState, composer, x2.a(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ o a;
        final /* synthetic */ Function2<String, Integer, Unit> b;
        final /* synthetic */ Function0<Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        a(o oVar, Function2<? super String, ? super Integer, Unit> function2, Function0<Unit> function0) {
            this.a = oVar;
            this.b = function2;
            this.c = function0;
        }

        /* renamed from: com.dragon.read.kmp.reader.ui.menu.moresettings.LockTimePickerPanelKt$a$a, reason: collision with other inner class name */
        static final class C0051a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ o a;
            final /* synthetic */ Function2<String, Integer, Unit> b;
            final /* synthetic */ Function0<Unit> c;

            /* JADX WARN: Multi-variable type inference failed */
            C0051a(o oVar, Function2<? super String, ? super Integer, Unit> function2, Function0<Unit> function0) {
                this.a = oVar;
                this.b = function2;
                this.c = function0;
            }

            /* renamed from: com.dragon.read.kmp.reader.ui.menu.moresettings.LockTimePickerPanelKt$a$a$a, reason: collision with other inner class name */
            static final class C0052a implements Function4<androidx.compose.foundation.layout.r, s2, Composer, Integer, Unit> {
                final /* synthetic */ o a;
                final /* synthetic */ Function2<String, Integer, Unit> b;
                final /* synthetic */ Function0<Unit> c;

                /* JADX WARN: Multi-variable type inference failed */
                C0052a(o oVar, Function2<? super String, ? super Integer, Unit> function2, Function0<Unit> function0) {
                    this.a = oVar;
                    this.b = function2;
                    this.c = function0;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit e(Function0 function0) {
                    function0.invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit d(Function2 function2, String text, int i) {
                    Intrinsics.checkNotNullParameter(text, "text");
                    function2.invoke(text, Integer.valueOf(i));
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, s2 s2Var, Composer composer, Integer num) {
                    c(rVar, s2Var, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void c(androidx.compose.foundation.layout.r PullDownBox, s2 s2Var, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(PullDownBox, "$this$PullDownBox");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-523353152, i, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.LockTimePickerPanel.<anonymous>.<anonymous>.<anonymous> (LockTimePickerPanel.kt:72)");
                    }
                    o oVar = this.a;
                    List<String> list = oVar.j;
                    int i2 = oVar.f;
                    Intrinsics.checkNotNull(s2Var, "null cannot be cast to non-null type androidx.compose.foundation.lazy.LazyListState");
                    LazyListState lazyListState = (LazyListState) s2Var;
                    composer.startReplaceGroup(5004770);
                    boolean changed = composer.changed(this.b);
                    final Function2<String, Integer, Unit> function2 = this.b;
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.h
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit d;
                                d = LockTimePickerPanelKt.a.C0051a.C0052a.d(Function2.this, (String) obj, ((Integer) obj2).intValue());
                                return d;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    Function2 function22 = (Function2) rememberedValue;
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(5004770);
                    boolean changed2 = composer.changed(this.c);
                    final Function0<Unit> function0 = this.c;
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.i
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit e;
                                e = LockTimePickerPanelKt.a.C0051a.C0052a.e(Function0.this);
                                return e;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceGroup();
                    LockTimePickerPanelKt.h(list, i2, lazyListState, function22, (Function0) rememberedValue2, composer, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
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
                        ComposerKt.traceEventStart(1094789601, i, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.LockTimePickerPanel.<anonymous>.<anonymous> (LockTimePickerPanel.kt:68)");
                    }
                    PullDownBoxKt.l(this.a, null, new com.dragon.read.kmp.reader.ui.menu.ui.b(this.a.f, 0, 2, null), androidx.compose.runtime.internal.t.e(-523353152, true, new C0052a(this.a, this.b, this.c), composer, 54), composer, 3072, 2);
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
                    ComposerKt.traceEventStart(-1419945680, i, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.LockTimePickerPanel.<anonymous> (LockTimePickerPanel.kt:67)");
                }
                com.dragon.read.kmp.reader.state.t.f(androidx.compose.runtime.internal.t.e(1094789601, true, new C0051a(this.a, this.b, this.c), composer, 54), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List<String> a;
        final /* synthetic */ float b;
        final /* synthetic */ LazyListState c;
        final /* synthetic */ float d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;

        b(List<String> list, float f, LazyListState lazyListState, float f2, long j, long j2) {
            this.a = list;
            this.b = f;
            this.c = lazyListState;
            this.d = f2;
            this.e = j;
            this.f = j2;
        }

        private static final float g(State<Float> state) {
            return ((Number) state.getValue()).floatValue();
        }

        private static final float j(State<Float> state) {
            return ((Number) state.getValue()).floatValue();
        }

        private static final float l(State<Float> state) {
            return ((Number) state.getValue()).floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float f(LazyListState lazyListState, int i) {
            Object obj;
            float coerceIn;
            boolean z;
            Iterator it2 = lazyListState.x().h().iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (((androidx.compose.foundation.lazy.o) obj).getIndex() == i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((androidx.compose.foundation.lazy.o) obj) == null) {
                return 1.0f;
            }
            coerceIn = RangesKt___RangesKt.coerceIn(1.0f - ((Math.abs((r1.getOffset() + (r1.getSize() / 2)) - ((r3.b() + r3.c()) / 2)) / ((r3.c() - r3.b()) / 2.0f)) * 0.7f), 0.3f, 1.0f);
            return coerceIn;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float k(LazyListState lazyListState, int i) {
            Object obj;
            boolean z;
            Iterator it2 = lazyListState.x().h().iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (((androidx.compose.foundation.lazy.o) obj).getIndex() == i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((androidx.compose.foundation.lazy.o) obj) == null) {
                return 1.0f;
            }
            return 1.0f - ((Math.abs((r1.getOffset() + (r1.getSize() / 2)) - ((r3.b() + r3.c()) / 2)) / ((r3.c() - r3.b()) / 2.0f)) * 0.3f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float i(LazyListState lazyListState, float f, int i) {
            Object obj;
            boolean z;
            Iterator it2 = lazyListState.x().h().iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (((androidx.compose.foundation.lazy.o) obj).getIndex() == i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((androidx.compose.foundation.lazy.o) obj) != null) {
                return (((r1.getOffset() + (r1.getSize() / 2)) - ((r3.b() + r3.c()) / 2)) / f) * (-20.0f);
            }
            return 0.0f;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            e(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(State state, State state2, State state3, c1 graphicsLayer) {
            Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
            graphicsLayer.g(j(state));
            graphicsLayer.n(l(state2));
            graphicsLayer.o(l(state2));
            graphicsLayer.c(g(state3));
            return Unit.INSTANCE;
        }

        public final void e(androidx.compose.foundation.lazy.f items, final int i, Composer composer, int i2) {
            int i3;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            long j;
            int i4;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            if ((i2 & 48) == 0) {
                if (composer.changed(i)) {
                    i4 = 32;
                } else {
                    i4 = 16;
                }
                i3 = i2 | i4;
            } else {
                i3 = i2;
            }
            if ((i3 & 145) != 144) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2097811280, i3, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.WheelPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LockTimePickerPanel.kt:272)");
                }
                String str = this.a.get(i);
                composer.startReplaceGroup(5004770);
                int i5 = i3 & 112;
                if (i5 == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                final LazyListState lazyListState = this.c;
                final float f = this.d;
                Object rememberedValue = composer.rememberedValue();
                if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.k
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            float i6;
                            i6 = LockTimePickerPanelKt.b.i(lazyListState, f, i);
                            return Float.valueOf(i6);
                        }
                    });
                    composer.updateRememberedValue(rememberedValue);
                }
                final State state = (State) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(5004770);
                if (i5 == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                final LazyListState lazyListState2 = this.c;
                Object rememberedValue2 = composer.rememberedValue();
                if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.l
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            float k;
                            k = LockTimePickerPanelKt.b.k(lazyListState2, i);
                            return Float.valueOf(k);
                        }
                    });
                    composer.updateRememberedValue(rememberedValue2);
                }
                final State state2 = (State) rememberedValue2;
                composer.endReplaceGroup();
                composer.startReplaceGroup(5004770);
                if (i5 == 32) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                final LazyListState lazyListState3 = this.c;
                Object rememberedValue3 = composer.rememberedValue();
                if (z4 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.m
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            float f2;
                            f2 = LockTimePickerPanelKt.b.f(lazyListState3, i);
                            return Float.valueOf(f2);
                        }
                    });
                    composer.updateRememberedValue(rememberedValue3);
                }
                final State state3 = (State) rememberedValue3;
                composer.endReplaceGroup();
                Modifier h = SizeKt.h(SizeKt.i(Modifier.Companion, this.b), 0.0f, 1, (Object) null);
                composer.startReplaceGroup(-1746271574);
                boolean changed = composer.changed(state) | composer.changed(state2) | composer.changed(state3);
                Object rememberedValue4 = composer.rememberedValue();
                if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit h2;
                            h2 = LockTimePickerPanelKt.b.h(state, state2, state3, (c1) obj);
                            return h2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue4);
                }
                composer.endReplaceGroup();
                Modifier a = b1.a(h, (Function1) rememberedValue4);
                androidx.compose.ui.e e = androidx.compose.ui.e.a.e();
                long j2 = this.e;
                long j3 = this.f;
                p0 i6 = androidx.compose.foundation.layout.m.i(e, false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, a);
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
                g5.e(b, i6, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                long h2 = x0.x.h(18);
                if (Math.abs(j(state)) < 10.0f) {
                    j = j2;
                } else {
                    j = j3;
                }
                long j4 = j;
                a6.j(str, (Modifier) null, j4, h2, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer, 3072, 3120, 120306);
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
    public static final Unit j(Ref$IntRef ref$IntRef, int i) {
        ref$IntRef.element = i;
        com.dragon.read.kmp.k.c("LockTime", "当前选中index：" + i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(List list, Ref$IntRef ref$IntRef, Function2 function2) {
        function2.invoke((String) list.get(ref$IntRef.element), Integer.valueOf(ref$IntRef.element));
        return Unit.INSTANCE;
    }

    public static final void l(final o params, final Function2<? super String, ? super Integer, Unit> onConfirm, final Function0<Unit> onCancel, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Composer startRestartGroup = composer.startRestartGroup(-1755474363);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(params)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(onConfirm)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(onCancel)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1755474363, i2, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.LockTimePickerPanel (LockTimePickerPanel.kt:65)");
            }
            ym4.f.c("LockTimePickerPanel", params, androidx.compose.runtime.internal.t.e(-1419945680, true, new a(params, onConfirm, onCancel), startRestartGroup, 54), startRestartGroup, ((i2 << 3) & 112) | 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m;
                    m = LockTimePickerPanelKt.m(o.this, onConfirm, onCancel, i, (Composer) obj, ((Integer) obj2).intValue());
                    return m;
                }
            });
        }
    }

    private static final void n(final Function0<Unit> function0, final Function0<Unit> function02, final long j, final long j2, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1975271971);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i2 = i6 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i2 |= i5;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(j)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i2 |= i4;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changed(j2)) {
                i3 = 2048;
            } else {
                i3 = 1024;
            }
            i2 |= i3;
        }
        if ((i2 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1975271971, i2, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.PickerToolbar (LockTimePickerPanel.kt:166)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier t = f2.t(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(45)), x0.i.g(15), 0.0f, 2, (Object) null);
            p0 b2 = r2.b(androidx.compose.foundation.layout.e.a.f(), androidx.compose.ui.e.a.i(), startRestartGroup, 54);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, t);
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
            a6.j("取消", ClickableKt.clickable-oSLSa3U$default(aVar, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, function0, 15, (Object) null), j2, x0.x.h(17), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, ((i2 >> 3) & 896) | 3078, 0, 131056);
            a6.j("完成", ClickableKt.clickable-oSLSa3U$default(aVar, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, function02, 15, (Object) null), j, x0.x.h(17), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, (i2 & 896) | 3078, 0, 131056);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = LockTimePickerPanelKt.o(Function0.this, function02, j, j2, i, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(List list, float f, LazyListState lazyListState, float f2, long j, long j2, o0 LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        n0.b(LazyColumn, list.size(), (Function1) null, (Function1) null, androidx.compose.runtime.internal.t.c(-2097811280, true, new b(list, f, lazyListState, f2, j, j2)), 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(final java.util.List<java.lang.String> r39, int r40, final androidx.compose.foundation.lazy.LazyListState r41, final kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> r42, final kotlin.jvm.functions.Function0<kotlin.Unit> r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instructions count: 931
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.ui.menu.moresettings.LockTimePickerPanelKt.h(java.util.List, int, androidx.compose.foundation.lazy.LazyListState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void p(final java.util.List<java.lang.String> r34, final int r35, final kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r36, int r37, float r38, long r39, long r41, long r43, final androidx.compose.foundation.lazy.LazyListState r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 1122
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.ui.menu.moresettings.LockTimePickerPanelKt.p(java.util.List, int, kotlin.jvm.functions.Function1, int, float, long, long, long, androidx.compose.foundation.lazy.LazyListState, androidx.compose.runtime.Composer, int, int):void");
    }
}
