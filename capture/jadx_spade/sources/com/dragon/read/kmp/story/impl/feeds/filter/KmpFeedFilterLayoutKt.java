package com.dragon.read.kmp.story.impl.feeds.filter;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.b;
import androidx.compose.foundation.lazy.grid.w0;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.y1;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.snapshots.e0;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.j1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.KmpDialogServiceKt;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.service.g1;
import com.dragon.read.kmp.service.h;
import com.dragon.read.story.impl.tab.page.bookmall.f1;
import com.ss.ttm.player.MediaPlayer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import w0.h;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpFeedFilterLayoutKt {
    private static final Lazy a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(List list, String str, Function1 function1, Function0 function0, Function0 function02, Function0 function03, LazyGridState lazyGridState, ym4.a aVar, String str2, int i2, Composer composer, int i3) {
        x(list, str, function1, function0, function02, function03, lazyGridState, aVar, str2, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Modifier modifier, List list, String str, Function1 function1, Map map, String str2, boolean z, Function0 function0, int i2, int i3, Composer composer, int i4) {
        F(modifier, list, str, function1, map, str2, z, function0, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(Modifier modifier, List list, String str, Function1 function1, Map map, String str2, boolean z, Function0 function0, int i2, int i3, Composer composer, int i4) {
        F(modifier, list, str, function1, map, str2, z, function0, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(Modifier modifier, float f2, int i2, int i3, Composer composer, int i4) {
        R(modifier, f2, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Modifier modifier, Function0 function0, int i2, int i3, Composer composer, int i4) {
        T(modifier, function0, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(Modifier modifier, float f2, int i2, int i3, Composer composer, int i4) {
        W(modifier, f2, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(String str, boolean z, Function0 function0, int i2, Composer composer, int i3) {
        t(str, z, function0, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Modifier modifier, String str, boolean z, Function0 function0, int i2, int i3, Composer composer, int i4) {
        v(modifier, str, z, function0, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y() {
        return Unit.INSTANCE;
    }

    static final class a implements Function0<Unit> {
        final /* synthetic */ boolean a;
        final /* synthetic */ Function1<String, Unit> b;
        final /* synthetic */ String c;

        /* JADX WARN: Multi-variable type inference failed */
        a(boolean z, Function1<? super String, Unit> function1, String str) {
            this.a = z;
            this.b = function1;
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            if (this.a) {
                this.b.invoke(null);
            } else {
                this.b.invoke(this.c);
            }
        }
    }

    static final class f implements Function0<Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ ym4.a c;
        final /* synthetic */ Function1<String, Unit> d;

        /* JADX WARN: Multi-variable type inference failed */
        f(String str, String str2, ym4.a aVar, Function1<? super String, Unit> function1) {
            this.a = str;
            this.b = str2;
            this.c = aVar;
            this.d = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            new vc4.a().m(this.a).n(this.b).h("1").f(true).j(this.c).b();
            this.d.invoke(this.a);
        }
    }

    static final class j implements com.dragon.read.kmp.service.h {
        final /* synthetic */ MutableState<String> a;

        j(MutableState<String> mutableState) {
            this.a = mutableState;
        }

        @Override // com.dragon.read.kmp.service.h
        public boolean a() {
            return h.a.a(this);
        }

        @Override // com.dragon.read.kmp.service.h
        public final void onDismiss() {
            KmpFeedFilterLayoutKt.P(this.a, "");
        }
    }

    private static final float e0() {
        return ((x0.i) a.getValue()).m();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(609282);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                x0.i f0;
                f0 = KmpFeedFilterLayoutKt.f0();
                return f0;
            }
        });
        a = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x0.i f0() {
        float g2;
        int o = b1.a.o();
        if (o > 0) {
            g2 = x0.i.g(x0.i.g(o) - x0.i.g(98));
        } else {
            g2 = x0.i.g(749);
        }
        return x0.i.d(g2);
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

    public static final class h implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public h(List list) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final String H(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final class b implements Function1<Integer, Object> {
        final /* synthetic */ Function2 a;
        final /* synthetic */ List b;

        public b(Function2 function2, List list) {
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

    static final class e implements Function1<x0.t, Unit> {
        final /* synthetic */ e0<Integer, Integer> a;
        final /* synthetic */ int b;

        e(e0<Integer, Integer> e0Var, int i) {
            this.a = e0Var;
            this.b = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(x0.t tVar) {
            a(tVar.j());
            return Unit.INSTANCE;
        }

        public final void a(long j) {
            this.a.put(Integer.valueOf(this.b), Integer.valueOf((int) (j >> 32)));
        }
    }

    public static final class g implements Function1<Integer, Object> {
        final /* synthetic */ Function2 a;
        final /* synthetic */ List b;

        public g(Function2 function2, List list) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void G(MutableState<String> mutableState) {
        if (StringsKt__StringsKt.isBlank(H(mutableState))) {
            return;
        }
        KmpDialogServiceKt.h(H(mutableState));
        P(mutableState, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object B(int i2, f1 item) {
        Intrinsics.checkNotNullParameter(item, "item");
        StringBuilder sb = new StringBuilder();
        String str = item.a;
        if (str == null && (str = item.c) == null) {
            str = "idx";
        }
        sb.append(str);
        sb.append('_');
        sb.append(i2);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object L(int i2, f1 item) {
        Intrinsics.checkNotNullParameter(item, "item");
        StringBuilder sb = new StringBuilder();
        String str = item.a;
        if (str == null && (str = item.c) == null) {
            str = "idx";
        }
        sb.append(str);
        sb.append('_');
        sb.append(i2);
        return sb.toString();
    }

    public static final class d implements Function4<androidx.compose.foundation.lazy.grid.w, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ String b;
        final /* synthetic */ Function1 c;

        public d(List list, String str, Function1 function1) {
            this.a = list;
            this.b = str;
            this.c = function1;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.grid.w wVar, Integer num, Composer composer, Integer num2) {
            a(wVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.grid.w wVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            int i4;
            int i5;
            if ((i2 & 6) == 0) {
                if (composer.changed(wVar)) {
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
                    ComposerKt.traceEventStart(-1942245546, i3, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:576)");
                }
                f1 f1Var = (f1) this.a.get(i);
                composer.startReplaceGroup(1965583390);
                String str = f1Var.c;
                boolean areEqual = Intrinsics.areEqual(this.b, str);
                String str2 = f1Var.b;
                if (str2 == null) {
                    if (str == null) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                }
                composer.startReplaceGroup(-1746271574);
                boolean changed = composer.changed(areEqual) | composer.changed(this.c) | composer.changed(str);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new a(areEqual, this.c, str);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                KmpFeedFilterLayoutKt.t(str2, areEqual, (Function0) rememberedValue, composer, 0);
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

    public static final class i implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ ym4.a d;
        final /* synthetic */ Function1 e;
        final /* synthetic */ e0 f;

        public i(List list, String str, String str2, ym4.a aVar, Function1 function1, e0 e0Var) {
            this.a = list;
            this.b = str;
            this.c = str2;
            this.d = aVar;
            this.e = function1;
            this.f = e0Var;
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
            boolean z2 = false;
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
                f1 f1Var = (f1) this.a.get(i);
                composer.startReplaceGroup(-1497777569);
                String str = f1Var.c;
                boolean areEqual = Intrinsics.areEqual(str, this.b);
                Modifier.a aVar = Modifier.Companion;
                composer.startReplaceGroup(-1633490746);
                if ((((i6 & 112) ^ 48) > 32 && composer.changed(i)) || (i6 & 48) == 32) {
                    z2 = true;
                }
                Object rememberedValue = composer.rememberedValue();
                if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new e(this.f, i);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier a = j1.a(aVar, (Function1) rememberedValue);
                String str2 = f1Var.b;
                if (str2 == null) {
                    if (str == null) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                }
                composer.startReplaceGroup(-1224400529);
                boolean changed = composer.changed(str) | composer.changed(this.c) | composer.changedInstance(this.d) | composer.changed(this.e);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new f(str, this.c, this.d, this.e);
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                KmpFeedFilterLayoutKt.v(a, str2, areEqual, (Function0) rememberedValue2, composer, 0, 0);
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
    public static final Unit A(List list, String str, Function1 function1, w0 LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyVerticalGrid.d(list.size(), new b(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.k
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Object B;
                B = KmpFeedFilterLayoutKt.B(((Integer) obj).intValue(), (f1) obj2);
                return B;
            }
        }, list), (Function2) null, new c(list), androidx.compose.runtime.internal.t.c(-1942245546, true, new d(list, str, function1)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void R(androidx.compose.ui.Modifier r24, float r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.filter.KmpFeedFilterLayoutKt.R(androidx.compose.ui.Modifier, float, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void T(Modifier modifier, final Function0<Unit> function0, Composer composer, final int i2, final int i3) {
        final Modifier modifier2;
        int i4;
        int i5;
        int i6;
        boolean z;
        Modifier modifier3;
        boolean z2;
        Composer startRestartGroup = composer.startRestartGroup(1294526734);
        int i7 = i3 & 1;
        if (i7 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i4 = i5 | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i4 |= i6;
        }
        boolean z3 = true;
        if ((i4 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i4 & 1)) {
            if (i7 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1294526734, i4, -1, "com.dragon.read.kmp.story.impl.feeds.filter.MoreButton (KmpFeedFilterLayout.kt:530)");
            }
            if (function0 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            startRestartGroup.startReplaceGroup(5004770);
            if ((i4 & 112) != 32) {
                z3 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit U;
                        U = KmpFeedFilterLayoutKt.U(Function0.this);
                        return U;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier4 = ClickableKt.clickable-oSLSa3U$default(modifier3, z2, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 14, (Object) null);
            e.a aVar = androidx.compose.ui.e.a;
            p0 i8 = androidx.compose.foundation.layout.m.i(aVar.e(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier4);
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
            g5.e(b2, i8, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e2, companion.d());
            float f2 = 12;
            z0.c(org.jetbrains.compose.resources.c.b(sk5.n.j(sk5.p.a), startRestartGroup, 0), "more", BoxScopeInstance.a.b(SizeKt.i(SizeKt.x(Modifier.Companion, x0.i.g(f2)), x0.i.g(f2)), aVar.f()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(m0.b, og4.a.a.h(startRestartGroup, og4.a.b).k(), 0, 2, (Object) null), startRestartGroup, 48, 56);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit V;
                    V = KmpFeedFilterLayoutKt.V(modifier2, function0, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return V;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void W(androidx.compose.ui.Modifier r24, float r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.filter.KmpFeedFilterLayoutKt.W(androidx.compose.ui.Modifier, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final String str, final boolean z, final Function0<Unit> function0, Composer composer, final int i2) {
        int i3;
        boolean z2;
        Composer composer2;
        long o;
        long j2;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1401149604);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i3 = i6 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        int i7 = i3;
        if ((i7 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i7 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1401149604, i7, -1, "com.dragon.read.kmp.story.impl.feeds.filter.DialogFilterItem (KmpFeedFilterLayout.kt:427)");
            }
            float f2 = 12;
            float f3 = 8;
            Modifier h2 = SizeKt.h(androidx.compose.ui.draw.e.a(f2.v(Modifier.Companion, 0.0f, 0.0f, 0.0f, x0.i.g(f2), 7, (Object) null), k.g.c(x0.i.g(f3))), 0.0f, 1, (Object) null);
            if (z) {
                startRestartGroup.startReplaceGroup(-2114952783);
                o = og4.a.a.h(startRestartGroup, og4.a.b).x();
            } else {
                startRestartGroup.startReplaceGroup(-2114951510);
                o = og4.a.a.h(startRestartGroup, og4.a.b).o();
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(f2.s(BackgroundKt.d(h2, o, (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f2), x0.i.g(f3)), false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, function0, 15, (Object) null);
            p0 i8 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier);
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
            g5.e(b2, i8, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            if (z) {
                startRestartGroup.startReplaceGroup(-1960652503);
                j2 = og4.a.a.h(startRestartGroup, og4.a.b).f();
            } else {
                startRestartGroup.startReplaceGroup(-1960651292);
                j2 = og4.a.a.h(startRestartGroup, og4.a.b).j();
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            a6.j(str, (Modifier) null, j2, x0.x.h(14), (androidx.compose.ui.text.font.y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, (i7 & 14) | 3072, 3120, 120818);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u;
                    u = KmpFeedFilterLayoutKt.u(str, z, function0, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return u;
                }
            });
        }
    }

    private static final void Q(MutableState<String> mutableState, String str, List<f1> list, String str2, ym4.a aVar, Function1<? super String, Unit> function1) {
        G(mutableState);
        P(mutableState, KmpDialogServiceKt.l(new g1(false, false, new j(mutableState), true, 3, null), androidx.compose.runtime.internal.t.c(824819987, true, new KmpFeedFilterLayoutKt$KmpFeedFilterLayout$showDialog$1(str, list, str2, aVar, function1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Function0 function0, ym4.a aVar, MutableState mutableState, String str, List list, String str2, Function1 function1) {
        if (function0 != null) {
            function0.invoke();
        }
        Q(mutableState, str, list, str2, aVar, function1);
        ym4.o.a.d("enter_filter_panel", aVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(List list, String str, String str2, ym4.a aVar, Function1 function1, e0 e0Var, o0 LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyRow.f(list.size(), new g(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Object L;
                L = KmpFeedFilterLayoutKt.L(((Integer) obj).intValue(), (f1) obj2);
                return L;
            }
        }, list), new h(list), androidx.compose.runtime.internal.t.c(2039820996, true, new i(list, str, str2, aVar, function1, e0Var)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Modifier modifier, final String str, final boolean z, final Function0<Unit> function0, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        Modifier modifier3;
        long o;
        c0 c0Var;
        long k;
        Composer startRestartGroup = composer.startRestartGroup(-42345959);
        int i9 = i3 & 1;
        if (i9 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i4 = i5 | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(str)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i4 |= i6;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i4 |= i7;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i2 & 3072) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i8 = 2048;
            } else {
                i8 = 1024;
            }
            i4 |= i8;
        }
        if ((i4 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i4 & 1)) {
            if (i9 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-42345959, i4, -1, "com.dragon.read.kmp.story.impl.feeds.filter.FilterItemChip (KmpFeedFilterLayout.kt:456)");
            }
            qg4.n h2 = og4.a.a.h(startRestartGroup, og4.a.b);
            Modifier a2 = androidx.compose.ui.draw.e.a(modifier3, k.g.c(x0.i.g(8)));
            if (z) {
                o = h2.x();
            } else {
                o = h2.o();
            }
            Modifier s = f2.s(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.d(a2, o, (androidx.compose.ui.graphics.f2) null, 2, (Object) null), false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, function0, 15, (Object) null), x0.i.g(14), x0.i.g(5));
            p0 i10 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, s);
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
            g5.e(b2, i10, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            long h3 = x0.x.h(14);
            if (z) {
                c0Var = c0.b.a();
            } else {
                c0Var = null;
            }
            long h4 = x0.x.h(20);
            if (z) {
                k = h2.f();
            } else {
                k = h2.k();
            }
            a6.j(str, (Modifier) null, k, h3, (androidx.compose.ui.text.font.y) null, c0Var, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, h4, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, ((i4 >> 3) & 14) | 3072, 3126, 119762);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit w;
                    w = KmpFeedFilterLayoutKt.w(modifier4, str, z, function0, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return w;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x0742  */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void F(androidx.compose.ui.Modifier r46, final java.util.List<com.dragon.read.story.impl.tab.page.bookmall.f1> r47, final java.lang.String r48, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r49, java.util.Map<java.lang.String, ? extends java.lang.Object> r50, java.lang.String r51, boolean r52, kotlin.jvm.functions.Function0<kotlin.Unit> r53, androidx.compose.runtime.Composer r54, final int r55, final int r56) {
        /*
            Method dump skipped, instructions count: 1878
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.filter.KmpFeedFilterLayoutKt.F(androidx.compose.ui.Modifier, java.util.List, java.lang.String, kotlin.jvm.functions.Function1, java.util.Map, java.lang.String, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final List<f1> list, final String str, final Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final LazyGridState lazyGridState, final ym4.a aVar, final String str2, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i5;
        boolean changedInstance;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-640577086);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(list)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i3 = i13 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(str)) {
                i12 = 32;
            } else {
                i12 = 16;
            }
            i3 |= i12;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i11 = 256;
            } else {
                i11 = 128;
            }
            i3 |= i11;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i10 = 2048;
            } else {
                i10 = 1024;
            }
            i3 |= i10;
        }
        if ((i2 & 24576) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i3 |= i9;
        }
        if ((196608 & i2) == 0) {
            if (startRestartGroup.changedInstance(function03)) {
                i8 = 131072;
            } else {
                i8 = 65536;
            }
            i3 |= i8;
        }
        if ((1572864 & i2) == 0) {
            if (startRestartGroup.changed(lazyGridState)) {
                i7 = 1048576;
            } else {
                i7 = 524288;
            }
            i3 |= i7;
        }
        if ((12582912 & i2) == 0) {
            if ((i2 & 16777216) == 0) {
                changedInstance = startRestartGroup.changed(aVar);
            } else {
                changedInstance = startRestartGroup.changedInstance(aVar);
            }
            if (changedInstance) {
                i6 = 8388608;
            } else {
                i6 = 4194304;
            }
            i3 |= i6;
        }
        if ((100663296 & i2) == 0) {
            if (startRestartGroup.changed(str2)) {
                i5 = 67108864;
            } else {
                i5 = 33554432;
            }
            i3 |= i5;
        }
        if ((i3 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-640577086, i3, -1, "com.dragon.read.kmp.story.impl.feeds.filter.KmpFeedFilterDialogContent (KmpFeedFilterLayout.kt:291)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new LinkedHashSet();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Set set = (Set) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1224400529);
            if ((3670016 & i3) == 1048576) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean changedInstance2 = z2 | startRestartGroup.changedInstance(list) | startRestartGroup.changedInstance(set);
            if ((234881024 & i3) == 67108864) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z9 = changedInstance2 | z3;
            if ((29360128 & i3) != 8388608 && ((i3 & 16777216) == 0 || !startRestartGroup.changedInstance(aVar))) {
                z4 = false;
            } else {
                z4 = true;
            }
            boolean z10 = z9 | z4;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z10 && rememberedValue2 != companion.getEmpty()) {
                i4 = i3;
                composer2 = startRestartGroup;
            } else {
                i4 = i3;
                composer2 = startRestartGroup;
                KmpFeedFilterLayoutKt$KmpFeedFilterDialogContent$1$1 kmpFeedFilterLayoutKt$KmpFeedFilterDialogContent$1$1 = new KmpFeedFilterLayoutKt$KmpFeedFilterDialogContent$1$1(lazyGridState, list, set, str2, aVar, null);
                composer2.updateRememberedValue(kmpFeedFilterLayoutKt$KmpFeedFilterDialogContent$1$1);
                rememberedValue2 = kmpFeedFilterLayoutKt$KmpFeedFilterDialogContent$1$1;
            }
            composer2.endReplaceGroup();
            EffectsKt.LaunchedEffect(lazyGridState, list, (Function2) rememberedValue2, composer2, ((i4 >> 18) & 14) | ((i4 << 3) & 112));
            Modifier.a aVar2 = Modifier.Companion;
            float f2 = 12;
            Modifier a2 = androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.h(aVar2, 0.0f, 1, (Object) null), e0()), k.g.e(x0.i.g(f2), x0.i.g(f2), 0.0f, 0.0f, 12, (Object) null));
            og4.a aVar3 = og4.a.a;
            int i14 = og4.a.b;
            Modifier d2 = BackgroundKt.d(a2, aVar3.h(composer2, i14).b(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            composer2.startReplaceGroup(1849434622);
            Object rememberedValue3 = composer2.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit y;
                        y = KmpFeedFilterLayoutKt.y();
                        return y;
                    }
                };
                composer2.updateRememberedValue(rememberedValue3);
            }
            composer2.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.m i15 = eVar.i();
            e.a aVar4 = androidx.compose.ui.e.a;
            p0 a3 = androidx.compose.foundation.layout.x.a(i15, aVar4.k(), composer2, 0);
            int a4 = j.a(androidx.compose.runtime.i.b(composer2, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(composer2, modifier);
            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
            Function0 a5 = companion2.a();
            if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(a5);
            } else {
                composer2.useNode();
            }
            Composer b2 = g5.b(composer2);
            g5.e(b2, a3, companion2.c());
            g5.e(b2, currentCompositionLocalMap, companion2.e());
            Function2 b3 = companion2.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a4))) {
                b2.updateRememberedValue(Integer.valueOf(a4));
                b2.apply(Integer.valueOf(a4), b3);
            }
            g5.e(b2, e2, companion2.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            float f3 = 16;
            Modifier t = f2.t(SizeKt.i(SizeKt.h(aVar2, 0.0f, 1, (Object) null), x0.i.g(56)), x0.i.g(f3), 0.0f, 2, (Object) null);
            p0 b4 = r2.b(eVar.h(), aVar4.i(), composer2, 54);
            int a6 = j.a(androidx.compose.runtime.i.b(composer2, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(composer2, t);
            Function0 a7 = companion2.a();
            if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(a7);
            } else {
                composer2.useNode();
            }
            Composer b5 = g5.b(composer2);
            g5.e(b5, b4, companion2.c());
            g5.e(b5, currentCompositionLocalMap2, companion2.e());
            Function2 b6 = companion2.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a6))) {
                b5.updateRememberedValue(Integer.valueOf(a6));
                b5.apply(Integer.valueOf(a6), b6);
            }
            g5.e(b5, e3, companion2.d());
            w2 w2Var = w2.b;
            e1 a8 = org.jetbrains.compose.resources.c.a(d2.w(f2.a.a), composer2, 0);
            float f4 = 24;
            Modifier s = SizeKt.s(aVar2, x0.i.g(f4));
            composer2.startReplaceGroup(5004770);
            if ((458752 & i4) == 131072) {
                z5 = true;
            } else {
                z5 = false;
            }
            Object rememberedValue4 = composer2.rememberedValue();
            if (z5 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit z11;
                        z11 = KmpFeedFilterLayoutKt.z(Function0.this);
                        return z11;
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            composer2.endReplaceGroup();
            z0.g(a8, "close", ClickableKt.clickable-oSLSa3U$default(s, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue4, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(aVar3.h(composer2, i14).k()), 0, composer2, 48, 184);
            a3.a(u2.a(w2Var, aVar2, 1.0f, false, 2, (Object) null), composer2, 0);
            long k = aVar3.h(composer2, i14).k();
            long h2 = x0.x.h(18);
            c0.a aVar5 = c0.b;
            a6.j("筛选", (Modifier) null, k, h2, (androidx.compose.ui.text.font.y) null, aVar5.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199686, 0, 131026);
            a3.a(u2.a(w2Var, aVar2, 1.0f, false, 2, (Object) null), composer2, 0);
            a3.a(SizeKt.x(aVar2, x0.i.g(f4)), composer2, 6);
            composer2.endNode();
            b.a aVar6 = new b.a(3);
            Modifier t2 = androidx.compose.foundation.layout.f2.t(a0.a(c0Var, SizeKt.h(aVar2, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), x0.i.g(f3), 0.0f, 2, (Object) null);
            e.f p = eVar.p(x0.i.g(14));
            i2 j2 = androidx.compose.foundation.layout.f2.j(0.0f, x0.i.g(10), 0.0f, 0.0f, 13, (Object) null);
            composer2.startReplaceGroup(-1746271574);
            boolean changedInstance3 = composer2.changedInstance(list);
            if ((i4 & 112) == 32) {
                z6 = true;
            } else {
                z6 = false;
            }
            boolean z11 = changedInstance3 | z6;
            if ((i4 & 896) == 256) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean z12 = z11 | z7;
            Object rememberedValue5 = composer2.rememberedValue();
            if (z12 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit A;
                        A = KmpFeedFilterLayoutKt.A(list, str, function1, (w0) obj);
                        return A;
                    }
                };
                composer2.updateRememberedValue(rememberedValue5);
            }
            composer2.endReplaceGroup();
            androidx.compose.foundation.lazy.grid.i.c(aVar6, t2, lazyGridState, j2, false, (e.m) null, p, (l1) null, false, (y1) null, (Function1) rememberedValue5, composer2, ((i4 >> 12) & 896) | 1575936, 0, 944);
            Modifier t3 = androidx.compose.foundation.layout.f2.t(SizeKt.i(androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar2, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(8), 7, (Object) null), x0.i.g(50)), x0.i.g(f3), 0.0f, 2, (Object) null);
            p0 b7 = r2.b(eVar.d(), aVar4.i(), composer2, 54);
            int a9 = j.a(androidx.compose.runtime.i.b(composer2, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier e4 = ComposedModifierKt.e(composer2, t3);
            Function0 a10 = companion2.a();
            if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(a10);
            } else {
                composer2.useNode();
            }
            Composer b8 = g5.b(composer2);
            g5.e(b8, b7, companion2.c());
            g5.e(b8, currentCompositionLocalMap3, companion2.e());
            Function2 b9 = companion2.b();
            if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a9))) {
                b8.updateRememberedValue(Integer.valueOf(a9));
                b8.apply(Integer.valueOf(a9), b9);
            }
            g5.e(b8, e4, companion2.d());
            long k2 = aVar3.h(composer2, i14).k();
            long h3 = x0.x.h(15);
            h.a aVar7 = w0.h.b;
            int a11 = aVar7.a();
            c0 a12 = aVar5.a();
            Modifier a13 = u2.a(w2Var, aVar2, 1.0f, false, 2, (Object) null);
            composer2.startReplaceGroup(5004770);
            if ((i4 & 7168) == 2048) {
                z8 = true;
            } else {
                z8 = false;
            }
            Object rememberedValue6 = composer2.rememberedValue();
            if (z8 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit C;
                        C = KmpFeedFilterLayoutKt.C(Function0.this);
                        return C;
                    }
                };
                composer2.updateRememberedValue(rememberedValue6);
            }
            composer2.endReplaceGroup();
            Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(a13, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue6, 15, (Object) null);
            w0.h h4 = w0.h.h(a11);
            boolean z13 = true;
            a6.j("清除", modifier2, k2, h3, (androidx.compose.ui.text.font.y) null, a12, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, h4, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199686, 0, 130512);
            e.c i16 = aVar4.i();
            e.f d3 = eVar.d();
            Modifier a14 = u2.a(w2Var, SizeKt.i(BackgroundKt.b(androidx.compose.ui.draw.e.a(aVar2, k.g.c(x0.i.g(18))), c0.a.d(androidx.compose.ui.graphics.c0.b, aVar3.h(composer2, i14).d3(), 0.0f, 0.0f, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null), x0.i.g(36)), 1.0f, false, 2, (Object) null);
            composer2.startReplaceGroup(5004770);
            if ((57344 & i4) != 16384) {
                z13 = false;
            }
            Object rememberedValue7 = composer2.rememberedValue();
            if (z13 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit D;
                        D = KmpFeedFilterLayoutKt.D(Function0.this);
                        return D;
                    }
                };
                composer2.updateRememberedValue(rememberedValue7);
            }
            composer2.endReplaceGroup();
            Modifier modifier3 = ClickableKt.clickable-oSLSa3U$default(a14, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue7, 15, (Object) null);
            p0 b10 = r2.b(d3, i16, composer2, 54);
            int a15 = j.a(androidx.compose.runtime.i.b(composer2, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier e5 = ComposedModifierKt.e(composer2, modifier3);
            Function0 a16 = companion2.a();
            if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(a16);
            } else {
                composer2.useNode();
            }
            Composer b11 = g5.b(composer2);
            g5.e(b11, b10, companion2.c());
            g5.e(b11, currentCompositionLocalMap4, companion2.e());
            Function2 b12 = companion2.b();
            if (b11.getInserting() || !Intrinsics.areEqual(b11.rememberedValue(), Integer.valueOf(a15))) {
                b11.updateRememberedValue(Integer.valueOf(a15));
                b11.apply(Integer.valueOf(a15), b12);
            }
            g5.e(b11, e5, companion2.d());
            a6.j("确定", (Modifier) null, aVar3.h(composer2, i14).r(), x0.x.h(15), (androidx.compose.ui.text.font.y) null, aVar5.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar7.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199686, 0, 130514);
            composer2.endNode();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.filter.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit E;
                    E = KmpFeedFilterLayoutKt.E(list, str, function1, function0, function02, function03, lazyGridState, aVar, str2, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return E;
                }
            });
        }
    }
}
