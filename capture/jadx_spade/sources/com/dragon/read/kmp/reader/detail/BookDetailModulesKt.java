package com.dragon.read.kmp.reader.detail;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.t3;
import com.bytedance.kmp.ugc.model.xy;
import com.dragon.read.base.ui.Drawable0_commonMainKt;
import com.dragon.read.base.ui.Res;
import com.dragon.read.kmp.base.ui.util.ScreenUtils;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import com.dragon.read.kmp.reader.detail.BookDetailModulesKt;
import com.dragon.read.kmp.reader.detail.b;
import com.dragon.read.kmp.reader.detail.viewmodel.BookDetailViewModel;
import com.dragon.read.kmp.reader.detail.widget.BookDetailHorizontalCoverListKt;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.dragon.read.kmp.widget.expandableText.ExtandableTextKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import w0.s;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookDetailModulesKt {
    private static final float a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(u2 u2Var, int i, Composer composer, int i2) {
        z0(u2Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(String str, boolean z, int i, Composer composer, int i2) {
        B0(str, z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(String str, String str2, String str3, String str4, String str5, List list, int i, Integer num, String str6, int i2, Composer composer, int i3) {
        D0(str, str2, str3, str4, str5, list, i, num, str6, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(String str, String str2, String str3, String str4, String str5, List list, int i, Integer num, String str6, int i2, Composer composer, int i3) {
        D0(str, str2, str3, str4, str5, list, i, num, str6, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(String str, String str2, String str3, String str4, String str5, List list, int i, Integer num, String str6, int i2, Composer composer, int i3) {
        D0(str, str2, str3, str4, str5, list, i, num, str6, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(List list, Function1 function1, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        K0(list, function1, modifier, f, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(List list, Function1 function1, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        K0(list, function1, modifier, f, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(String str, List list, boolean z, Function0 function0, Function0 function02, Function4 function4, int i, Composer composer, int i2) {
        Q(str, list, z, function0, function02, function4, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(String str, List list, boolean z, Function0 function0, Function0 function02, Function4 function4, int i, Composer composer, int i2) {
        Q(str, list, z, function0, function02, function4, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(String str, boolean z, long j, boolean z2, String str2, xy xyVar, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Composer composer, int i2) {
        P0(str, z, j, z2, str2, xyVar, function0, function02, function03, function04, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        V(j, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(Modifier modifier, Function0 function0, boolean z, boolean z2, Function0 function02, String str, Function0 function03, int i, int i2, Composer composer, int i3) {
        Z(modifier, function0, z, z2, function02, str, function03, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(Modifier modifier, org.jetbrains.compose.resources.b bVar, String str, Function0 function0, int i, int i2, Composer composer, int i3) {
        c0(modifier, bVar, str, function0, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(String str, String str2, int i, Composer composer, int i2) {
        f0(str, str2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(String str, String str2, int i, Composer composer, int i2) {
        f0(str, str2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Composer composer, int i2) {
        i0(str, str2, str3, str4, str5, str6, str7, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(List list, String str, boolean z, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        l0(list, str, z, function0, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(c cVar, Function0 function0, int i, Composer composer, int i2) {
        n0(cVar, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(String str, s2 s2Var, Function1 function1, int i, Composer composer, int i2) {
        q0(str, s2Var, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(t3 t3Var, s2 s2Var, u2 u2Var, t2 t2Var, int i, int i2, Composer composer, int i3) {
        u0(t3Var, s2Var, u2Var, t2Var, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(t3 t3Var, s2 s2Var, u2 u2Var, t2 t2Var, int i, int i2, Composer composer, int i3) {
        u0(t3Var, s2Var, u2Var, t2Var, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(t3 t3Var, t2 t2Var, Function0 function0, int i, Composer composer, int i2) {
        x0(t3Var, t2Var, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(608364);
        a = x0.i.g(44);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState r0() {
        return SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(androidx.compose.ui.graphics.c1 graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.c(0.99f);
        return Unit.INSTANCE;
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ c a;
        final /* synthetic */ Function1<String, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        b(c cVar, Function1<? super String, Unit> function1) {
            this.a = cVar;
            this.b = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(Function1 function1, String str) {
            function1.invoke(str);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            b(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-256619364, i, -1, "com.dragon.read.kmp.reader.detail.TagRowSingleLine.<anonymous>.<anonymous>.<anonymous> (BookDetailModules.kt:647)");
                }
                c cVar = this.a;
                final String str = cVar.b;
                Function0 function0 = null;
                if (str == null || !(true ^ StringsKt__StringsKt.isBlank(str))) {
                    str = null;
                }
                composer.startReplaceGroup(-1798068592);
                if (str != null) {
                    final Function1<String, Unit> function1 = this.b;
                    composer.startReplaceGroup(-1633490746);
                    boolean changed = composer.changed(function1) | composer.changed(str);
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.detail.z0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit c;
                                c = BookDetailModulesKt.b.c(Function1.this, str);
                                return c;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    function0 = (Function0) rememberedValue;
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
                BookDetailModulesKt.n0(cVar, function0, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ u2 c;
        final /* synthetic */ t2 d;
        final /* synthetic */ s2 e;
        final /* synthetic */ t3 f;
        final /* synthetic */ BookDetailViewModel g;
        final /* synthetic */ p2 h;

        a(boolean z, boolean z2, u2 u2Var, t2 t2Var, s2 s2Var, t3 t3Var, BookDetailViewModel bookDetailViewModel, p2 p2Var) {
            this.a = z;
            this.b = z2;
            this.c = u2Var;
            this.d = t2Var;
            this.e = s2Var;
            this.f = t3Var;
            this.g = bookDetailViewModel;
            this.h = p2Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(p2 p2Var, t3 t3Var) {
            p2.e(p2Var, t3Var.e, "view_more_comment", null, 4, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(BookDetailViewModel bookDetailViewModel, s2 it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            bookDetailViewModel.K0(b.i.a);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit i(BookDetailViewModel bookDetailViewModel, s2 it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            bookDetailViewModel.K0(b.i.a);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit j(p2 p2Var, t3 t3Var) {
            p2.e(p2Var, t3Var.e, "view_more_comment", null, 4, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit k(p2 p2Var, t3 t3Var) {
            p2.e(p2Var, t3Var.e, "view_more_comment", null, 4, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            f(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void f(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-83782118, i, -1, "com.dragon.read.kmp.reader.detail.MetaRow.<anonymous> (BookDetailModules.kt:344)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier s = androidx.compose.foundation.layout.f2.s(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(16), x0.i.g(8));
                boolean z2 = this.a;
                boolean z3 = this.b;
                u2 u2Var = this.c;
                t2 t2Var = this.d;
                s2 s2Var = this.e;
                final t3 t3Var = this.f;
                final BookDetailViewModel bookDetailViewModel = this.g;
                final p2 p2Var = this.h;
                e.e h = androidx.compose.foundation.layout.e.a.h();
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 b = androidx.compose.foundation.layout.r2.b(h, aVar2.l(), composer, 0);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, s);
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
                g5.e(b2, b, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                    b2.updateRememberedValue(Integer.valueOf(a));
                    b2.apply(Integer.valueOf(a), b3);
                }
                g5.e(b2, e, companion.d());
                w2 w2Var = w2.b;
                if (z2) {
                    composer.startReplaceGroup(1942606397);
                    if (z3) {
                        composer.startReplaceGroup(1942618704);
                        Modifier a3 = androidx.compose.foundation.layout.u2.a(w2Var, aVar, 0.4f, false, 2, (Object) null);
                        androidx.compose.ui.layout.p0 i2 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                        int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                        androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                        Modifier e2 = ComposedModifierKt.e(composer, a3);
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
                        g5.e(b4, i2, companion.c());
                        g5.e(b4, currentCompositionLocalMap2, companion.e());
                        Function2 b5 = companion.b();
                        if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                            b4.updateRememberedValue(Integer.valueOf(a4));
                            b4.apply(Integer.valueOf(a4), b5);
                        }
                        g5.e(b4, e2, companion.d());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                        String str = t3Var.e;
                        Intrinsics.checkNotNull(str);
                        composer.startReplaceGroup(5004770);
                        boolean changedInstance = composer.changedInstance(bookDetailViewModel);
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function1() { // from class: com.dragon.read.kmp.reader.detail.w0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit i3;
                                    i3 = BookDetailModulesKt.a.i(BookDetailViewModel.this, (s2) obj);
                                    return i3;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceGroup();
                        BookDetailModulesKt.q0(str, s2Var, (Function1) rememberedValue, composer, 0);
                        composer.endNode();
                        composer.startReplaceGroup(-1461346444);
                        if (u2Var != null) {
                            Modifier a6 = androidx.compose.foundation.layout.u2.a(w2Var, aVar, 0.3f, false, 2, (Object) null);
                            androidx.compose.ui.layout.p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.m(), false);
                            int a7 = j.a(androidx.compose.runtime.i.b(composer, 0));
                            androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
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
                            Composer b6 = g5.b(composer);
                            g5.e(b6, i3, companion.c());
                            g5.e(b6, currentCompositionLocalMap3, companion.e());
                            Function2 b7 = companion.b();
                            if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a7))) {
                                b6.updateRememberedValue(Integer.valueOf(a7));
                                b6.apply(Integer.valueOf(a7), b7);
                            }
                            g5.e(b6, e3, companion.d());
                            BookDetailModulesKt.z0(u2Var, composer, 0);
                            composer.endNode();
                        }
                        composer.endReplaceGroup();
                        if (t2Var != null) {
                            Modifier a9 = androidx.compose.foundation.layout.u2.a(w2Var, aVar, 0.3f, false, 2, (Object) null);
                            androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(aVar2.n(), false);
                            int a10 = j.a(androidx.compose.runtime.i.b(composer, 0));
                            androidx.compose.runtime.e0 currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                            Modifier e4 = ComposedModifierKt.e(composer, a9);
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
                            composer.startReplaceGroup(-1633490746);
                            boolean changedInstance2 = composer.changedInstance(p2Var) | composer.changedInstance(t3Var);
                            Object rememberedValue2 = composer.rememberedValue();
                            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.detail.x0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit j;
                                        j = BookDetailModulesKt.a.j(p2.this, t3Var);
                                        return j;
                                    }
                                };
                                composer.updateRememberedValue(rememberedValue2);
                            }
                            composer.endReplaceGroup();
                            BookDetailModulesKt.x0(t3Var, t2Var, (Function0) rememberedValue2, composer, 0);
                            composer.endNode();
                        }
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(1943532367);
                        composer.startReplaceGroup(-1461325637);
                        if (t2Var != null) {
                            Modifier a12 = androidx.compose.foundation.layout.u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null);
                            androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                            int a13 = j.a(androidx.compose.runtime.i.b(composer, 0));
                            androidx.compose.runtime.e0 currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
                            Modifier e5 = ComposedModifierKt.e(composer, a12);
                            Function0 a14 = companion.a();
                            if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                                androidx.compose.runtime.i.d();
                            }
                            composer.startReusableNode();
                            if (composer.getInserting()) {
                                composer.createNode(a14);
                            } else {
                                composer.useNode();
                            }
                            Composer b10 = g5.b(composer);
                            g5.e(b10, i5, companion.c());
                            g5.e(b10, currentCompositionLocalMap5, companion.e());
                            Function2 b11 = companion.b();
                            if (b10.getInserting() || !Intrinsics.areEqual(b10.rememberedValue(), Integer.valueOf(a13))) {
                                b10.updateRememberedValue(Integer.valueOf(a13));
                                b10.apply(Integer.valueOf(a13), b11);
                            }
                            g5.e(b10, e5, companion.d());
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.a;
                            composer.startReplaceGroup(-1633490746);
                            boolean changedInstance3 = composer.changedInstance(p2Var) | composer.changedInstance(t3Var);
                            Object rememberedValue3 = composer.rememberedValue();
                            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.reader.detail.y0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit k;
                                        k = BookDetailModulesKt.a.k(p2.this, t3Var);
                                        return k;
                                    }
                                };
                                composer.updateRememberedValue(rememberedValue3);
                            }
                            composer.endReplaceGroup();
                            BookDetailModulesKt.x0(t3Var, t2Var, (Function0) rememberedValue3, composer, 0);
                            composer.endNode();
                        }
                        composer.endReplaceGroup();
                        if (u2Var != null) {
                            Modifier a15 = androidx.compose.foundation.layout.u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null);
                            androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                            int a16 = j.a(androidx.compose.runtime.i.b(composer, 0));
                            androidx.compose.runtime.e0 currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
                            Modifier e6 = ComposedModifierKt.e(composer, a15);
                            Function0 a17 = companion.a();
                            if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                                androidx.compose.runtime.i.d();
                            }
                            composer.startReusableNode();
                            if (composer.getInserting()) {
                                composer.createNode(a17);
                            } else {
                                composer.useNode();
                            }
                            Composer b12 = g5.b(composer);
                            g5.e(b12, i6, companion.c());
                            g5.e(b12, currentCompositionLocalMap6, companion.e());
                            Function2 b13 = companion.b();
                            if (b12.getInserting() || !Intrinsics.areEqual(b12.rememberedValue(), Integer.valueOf(a16))) {
                                b12.updateRememberedValue(Integer.valueOf(a16));
                                b12.apply(Integer.valueOf(a16), b13);
                            }
                            g5.e(b12, e6, companion.d());
                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.a;
                            BookDetailModulesKt.z0(u2Var, composer, 0);
                            composer.endNode();
                        }
                        composer.endReplaceGroup();
                    }
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1944186126);
                    composer.startReplaceGroup(-1461304765);
                    if (t2Var != null) {
                        Modifier a18 = androidx.compose.foundation.layout.u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null);
                        androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                        int a19 = j.a(androidx.compose.runtime.i.b(composer, 0));
                        androidx.compose.runtime.e0 currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
                        Modifier e7 = ComposedModifierKt.e(composer, a18);
                        Function0 a20 = companion.a();
                        if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                            androidx.compose.runtime.i.d();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(a20);
                        } else {
                            composer.useNode();
                        }
                        Composer b14 = g5.b(composer);
                        g5.e(b14, i7, companion.c());
                        g5.e(b14, currentCompositionLocalMap7, companion.e());
                        Function2 b15 = companion.b();
                        if (b14.getInserting() || !Intrinsics.areEqual(b14.rememberedValue(), Integer.valueOf(a19))) {
                            b14.updateRememberedValue(Integer.valueOf(a19));
                            b14.apply(Integer.valueOf(a19), b15);
                        }
                        g5.e(b14, e7, companion.d());
                        BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.a;
                        composer.startReplaceGroup(-1633490746);
                        boolean changedInstance4 = composer.changedInstance(p2Var) | composer.changedInstance(t3Var);
                        Object rememberedValue4 = composer.rememberedValue();
                        if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.reader.detail.u0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit g;
                                    g = BookDetailModulesKt.a.g(p2.this, t3Var);
                                    return g;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue4);
                        }
                        composer.endReplaceGroup();
                        BookDetailModulesKt.x0(t3Var, t2Var, (Function0) rememberedValue4, composer, 0);
                        composer.endNode();
                    }
                    composer.endReplaceGroup();
                    if (s2Var != null) {
                        Modifier a21 = androidx.compose.foundation.layout.u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null);
                        androidx.compose.ui.layout.p0 i8 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                        int a22 = j.a(androidx.compose.runtime.i.b(composer, 0));
                        androidx.compose.runtime.e0 currentCompositionLocalMap8 = composer.getCurrentCompositionLocalMap();
                        Modifier e8 = ComposedModifierKt.e(composer, a21);
                        Function0 a23 = companion.a();
                        if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                            androidx.compose.runtime.i.d();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(a23);
                        } else {
                            composer.useNode();
                        }
                        Composer b16 = g5.b(composer);
                        g5.e(b16, i8, companion.c());
                        g5.e(b16, currentCompositionLocalMap8, companion.e());
                        Function2 b17 = companion.b();
                        if (b16.getInserting() || !Intrinsics.areEqual(b16.rememberedValue(), Integer.valueOf(a22))) {
                            b16.updateRememberedValue(Integer.valueOf(a22));
                            b16.apply(Integer.valueOf(a22), b17);
                        }
                        g5.e(b16, e8, companion.d());
                        BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.a;
                        String str2 = t3Var.e;
                        Intrinsics.checkNotNull(str2);
                        composer.startReplaceGroup(5004770);
                        boolean changedInstance5 = composer.changedInstance(bookDetailViewModel);
                        Object rememberedValue5 = composer.rememberedValue();
                        if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.reader.detail.v0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit h2;
                                    h2 = BookDetailModulesKt.a.h(BookDetailViewModel.this, (s2) obj);
                                    return h2;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue5);
                        }
                        composer.endReplaceGroup();
                        BookDetailModulesKt.q0(str2, s2Var, (Function1) rememberedValue5, composer, 0);
                        composer.endNode();
                    }
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
    public static final Unit I0(p2 p2Var, String str) {
        p2.e(p2Var, str, "view_more_comment", null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(p2 p2Var, String str) {
        p2.e(p2Var, str, "profile", null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(String str, ym4.a it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        it2.g("position", "page").g("book_id", str).g("digg_source", "card").g("type", "book_comment");
        return Unit.INSTANCE;
    }

    public static final float a1(Composer composer, int i) {
        composer.startReplaceGroup(-1305676216);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1305676216, i, -1, "com.dragon.read.kmp.reader.detail.bookDetailTopBarHeight (BookDetailModules.kt:123)");
        }
        float g = x0.i.g(x0.i.g(com.dragon.read.kmp.service.d1.g(ScreenUtils.a.h(ig4.f.a(composer, 0)))) + a);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(long j, androidx.compose.ui.graphics.drawscope.c drawWithContent) {
        List listOf;
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        androidx.compose.ui.graphics.f0 b2 = drawWithContent.j0().b();
        float[] b3 = androidx.compose.ui.graphics.o0.b((float[]) null, 1, (DefaultConstructorMarker) null);
        androidx.compose.ui.graphics.o0.d(b3, 0.0f);
        androidx.compose.ui.graphics.n1 a2 = androidx.compose.ui.graphics.m.a();
        a2.f(androidx.compose.ui.graphics.m0.b.a(b3));
        b2.p(a0.m.c(drawWithContent.e()), a2);
        drawWithContent.E1();
        b2.d();
        DrawScope.-CC.p(drawWithContent, androidx.compose.ui.graphics.l0.n(j, 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0L, 0.0f, (androidx.compose.ui.graphics.drawscope.g) null, (androidx.compose.ui.graphics.m0) null, 0, 126, (Object) null);
        c0.a aVar = androidx.compose.ui.graphics.c0.b;
        l0.a aVar2 = androidx.compose.ui.graphics.l0.b;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(aVar2.a()), androidx.compose.ui.graphics.l0.j(aVar2.g())});
        DrawScope.-CC.o(drawWithContent, c0.a.p(aVar, listOf, 0.0f, Float.intBitsToFloat((int) (drawWithContent.e() & 4294967295L)), 0, 8, (Object) null), 0L, 0L, 0.0f, (androidx.compose.ui.graphics.drawscope.g) null, (androidx.compose.ui.graphics.m0) null, androidx.compose.ui.graphics.y.a.i(), 62, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(p2 p2Var, String str, String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        p2.e(p2Var, str, "view_more_comment", null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(ArrayList arrayList, int i, p1.a layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Iterator it2 = arrayList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it2.hasNext()) {
            int i4 = i2 + 1;
            androidx.compose.ui.layout.p1 p1Var = (androidx.compose.ui.layout.p1) it2.next();
            if (i2 > 0) {
                i3 += i;
            }
            p1.a.G(layout, p1Var, i3, 0, 0.0f, 4, (Object) null);
            i3 += p1Var.a;
            i2 = i4;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(State state, State state2, androidx.compose.ui.graphics.c1 graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.c(((Number) state.getValue()).floatValue());
        graphicsLayer.l(((Number) state2.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(final u2 u2Var, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        Composer composer3;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(327831264);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(u2Var)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
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
                ComposerKt.traceEventStart(327831264, i2, -1, "com.dragon.read.kmp.reader.detail.MetaStatItem (BookDetailModules.kt:427)");
            }
            Modifier.a aVar = Modifier.Companion;
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.m i5 = eVar.i();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(i5, aVar2.k(), startRestartGroup, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, aVar);
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
            g5.e(b2, a2, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            androidx.compose.ui.layout.p0 b4 = androidx.compose.foundation.layout.r2.b(eVar.h(), aVar2.a(), startRestartGroup, 48);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, aVar);
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
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, b4, companion.c());
            g5.e(b5, currentCompositionLocalMap2, companion.e());
            Function2 b6 = companion.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a5))) {
                b5.updateRememberedValue(Integer.valueOf(a5));
                b5.apply(Integer.valueOf(a5), b6);
            }
            g5.e(b5, e2, companion.d());
            w2 w2Var = w2.b;
            String str = u2Var.a;
            og4.a aVar3 = og4.a.a;
            og4.a c = aVar3.c();
            int i6 = og4.a.b;
            a6.j(str, (Modifier) null, c.b(startRestartGroup, i6).k(), x0.x.h(18), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 0, 131026);
            String str2 = u2Var.b;
            startRestartGroup.startReplaceGroup(-95066);
            if (str2 != null && !StringsKt__StringsKt.isBlank(str2)) {
                z2 = false;
            }
            if (!z2) {
                a3.a(SizeKt.x(aVar, x0.i.g(2)), startRestartGroup, 6);
                i3 = i6;
                composer3 = startRestartGroup;
                a6.j(str2, (Modifier) null, aVar3.c().b(startRestartGroup, i6).k(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer3, 3072, 3072, 122866);
            } else {
                composer3 = startRestartGroup;
                i3 = i6;
            }
            composer3.endReplaceGroup();
            composer3.endNode();
            Composer composer4 = composer3;
            a3.a(SizeKt.i(aVar, x0.i.g(4)), composer4, 6);
            composer2 = composer4;
            a6.j(u2Var.c, (Modifier) null, aVar3.c().b(composer4, i3).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 3072, 3120, 120818);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit A0;
                    A0 = BookDetailModulesKt.A0(u2.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return A0;
                }
            });
        }
    }

    private static final void B0(final String str, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        org.jetbrains.compose.resources.b skin_top_book_rank_text_dark;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1121839867);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        boolean z3 = true;
        if ((i2 & 19) != 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1121839867, i2, -1, "com.dragon.read.kmp.reader.detail.PeakRankTitle (BookDetailModules.kt:560)");
            }
            startRestartGroup.startReplaceGroup(5004770);
            int i5 = i2 & 14;
            if (i5 != 4) {
                z3 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = StringsKt___StringsKt.drop(str, 3);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            String str2 = (String) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(androidx.compose.ui.text.font.j.b.b(), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(5004770);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new BookDetailModulesKt$PeakRankTitle$1$1(mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(str, (Function2) rememberedValue3, startRestartGroup, i5);
            e.c i6 = androidx.compose.ui.e.a.i();
            Modifier.a aVar = Modifier.Companion;
            androidx.compose.ui.layout.p0 b2 = androidx.compose.foundation.layout.r2.b(androidx.compose.foundation.layout.e.a.h(), i6, startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, aVar);
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
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, b2, companion2.c());
            g5.e(b3, currentCompositionLocalMap, companion2.e());
            Function2 b4 = companion2.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                b3.updateRememberedValue(Integer.valueOf(a2));
                b3.apply(Integer.valueOf(a2), b4);
            }
            g5.e(b3, e, companion2.d());
            w2 w2Var = w2.b;
            Res.drawable drawableVar = Res.drawable.INSTANCE;
            if (z) {
                skin_top_book_rank_text_dark = Drawable0_commonMainKt.getSkin_top_book_rank_text_light(drawableVar);
            } else {
                skin_top_book_rank_text_dark = Drawable0_commonMainKt.getSkin_top_book_rank_text_dark(drawableVar);
            }
            androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(skin_top_book_rank_text_dark, startRestartGroup, 0), (String) null, SizeKt.u(aVar, x0.i.g(37), x0.i.g(20)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 432, 248);
            a3.a(SizeKt.x(aVar, x0.i.g(2)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            a6.j(str2, (Modifier) null, og4.a.a.c().b(startRestartGroup, og4.a.b).p(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) mutableState.getValue(), 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 199680, 3120, 120722);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit C0;
                    C0 = BookDetailModulesKt.C0(str, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return C0;
                }
            });
        }
    }

    public static final void f0(final String str, final String str2, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-145383907);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(str2)) {
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
                ComposerKt.traceEventStart(-145383907, i2, -1, "com.dragon.read.kmp.reader.detail.CopyrightInfoItem (BookDetailModules.kt:921)");
            }
            if (str != null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2 && !oc4.a.a.m(str2)) {
                Modifier.a aVar = Modifier.Companion;
                androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 0);
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, aVar);
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
                g5.e(b2, a2, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                    b2.updateRememberedValue(Integer.valueOf(a3));
                    b2.apply(Integer.valueOf(a3), b3);
                }
                g5.e(b2, e, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                a3.a(SizeKt.i(aVar, x0.i.g(28)), startRestartGroup, 6);
                long h = og4.a.a.c().h(startRestartGroup, og4.a.b).h();
                long h2 = x0.x.h(12);
                long h3 = x0.x.h(20);
                Modifier h4 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                float f = 16;
                composer2 = startRestartGroup;
                a6.j("版权信息：本书的数字版权由" + str + "提供并授权发行，如有任何疑问，请通过「我的-反馈与帮助」告知我们", androidx.compose.foundation.layout.f2.v(h4, x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null), h, h2, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, h3, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3120, 6, 130032);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                androidx.compose.runtime.t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.t
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit h0;
                            h0 = BookDetailModulesKt.h0(str, str2, i, (Composer) obj, ((Integer) obj2).intValue());
                            return h0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g0;
                    g0 = BookDetailModulesKt.g0(str, str2, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(final c cVar, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        long s;
        long j;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1743525374);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(cVar)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        boolean z2 = true;
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1743525374, i2, -1, "com.dragon.read.kmp.reader.detail.IntroTagChip (BookDetailModules.kt:682)");
            }
            if (cVar.c) {
                startRestartGroup.startReplaceGroup(-490633683);
                s = og4.a.a.c().b(startRestartGroup, og4.a.b).t0();
            } else {
                startRestartGroup.startReplaceGroup(-490632338);
                s = og4.a.a.c().b(startRestartGroup, og4.a.b).s();
            }
            startRestartGroup.endReplaceGroup();
            if (cVar.c) {
                startRestartGroup.startReplaceGroup(-490630037);
                j = og4.a.a.c().b(startRestartGroup, og4.a.b).p();
            } else {
                startRestartGroup.startReplaceGroup(-490628760);
                j = og4.a.a.c().b(startRestartGroup, og4.a.b).j();
            }
            startRestartGroup.endReplaceGroup();
            long j2 = j;
            startRestartGroup.startReplaceGroup(-490625727);
            Modifier c = BackgroundKt.c(Modifier.Companion, s, k.g.c(x0.i.g(4)));
            startRestartGroup.startReplaceGroup(-490625543);
            if (function0 != null) {
                startRestartGroup.startReplaceGroup(5004770);
                if ((i2 & 112) != 32) {
                    z2 = false;
                }
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.detail.e
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit o0;
                            o0 = BookDetailModulesKt.o0(Function0.this);
                            return o0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                c = ClickableKt.clickable-oSLSa3U$default(c, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endReplaceGroup();
            Modifier s2 = androidx.compose.foundation.layout.f2.s(c, x0.i.g(8), x0.i.g(6));
            androidx.compose.ui.layout.p0 b2 = androidx.compose.foundation.layout.r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, s2);
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
            composer2 = startRestartGroup;
            a6.j(cVar.a, (Modifier) null, j2, x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 3072, 3120, 120818);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit p0;
                    p0 = BookDetailModulesKt.p0(c.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return p0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(boolean z, p2 p2Var, String str, Function1 function1, s2 s2Var) {
        if (z) {
            p2Var.h(str);
            p2.e(p2Var, str, "dianfeng_tag", null, 4, null);
        }
        function1.invoke(s2Var);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.layout.r0 M0(List list, float f, Function1 function1, androidx.compose.ui.layout.b2 SubcomposeLayout, x0.b bVar) {
        int coerceAtLeast;
        int i;
        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
        final ArrayList arrayList = new ArrayList(list.size());
        final int x0 = SubcomposeLayout.x0(f);
        Iterator it2 = list.iterator();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (it2.hasNext()) {
            int i5 = i3 + 1;
            androidx.compose.ui.layout.p1 L = ((androidx.compose.ui.layout.n0) CollectionsKt___CollectionsKt.first(SubcomposeLayout.I1("tag_" + i3, androidx.compose.runtime.internal.t.c(-778374849, true, new b((c) it2.next(), function1))))).L(x0.b.d(bVar.r(), 0, 0, 0, 0, 10, (Object) null));
            if (arrayList.isEmpty()) {
                i = L.a + i4;
            } else {
                i = i4 + x0 + L.a;
            }
            if (i > x0.b.l(bVar.r())) {
                break;
            }
            if (!arrayList.isEmpty()) {
                i4 += x0;
            }
            arrayList.add(L);
            i4 += L.a;
            i2 = Math.max(i2, L.b);
            i3 = i5;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i4, 0);
        return androidx.compose.ui.layout.s0.b(SubcomposeLayout, coerceAtLeast, i2, (Map) null, new Function1() { // from class: com.dragon.read.kmp.reader.detail.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit N0;
                N0 = BookDetailModulesKt.N0(arrayList, x0, (p1.a) obj);
                return N0;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(final t3 t3Var, final t2 t2Var, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(470438208);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(t3Var)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(t2Var)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
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
                ComposerKt.traceEventStart(470438208, i2, -1, "com.dragon.read.kmp.reader.detail.MetaScoreItem (BookDetailModules.kt:447)");
            }
            com.dragon.read.kmp.community.bookcomment.z zVar = (com.dragon.read.kmp.community.bookcomment.z) startRestartGroup.consume(BookDetailPageKt.E());
            if (zVar != null) {
                composer2 = startRestartGroup;
                zVar.b(t2Var.b, t2Var.c, t3Var.j0, t3Var.U, t2Var.a, t2Var.f, t2Var.g, com.dragon.read.kmp.reader.detail.platform.c.a.a(), function0, startRestartGroup, (i2 << 18) & 234881024);
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
        androidx.compose.runtime.t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit y0;
                    y0 = BookDetailModulesKt.y0(t3Var, t2Var, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return y0;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void V(final long r15, androidx.compose.ui.Modifier r17, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.BookDetailModulesKt.V(long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(final String str, final s2 s2Var, final Function1<? super s2, Unit> function1, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        boolean z3;
        boolean z4;
        Modifier modifier;
        org.jetbrains.compose.resources.b skin_top_book_rank_icon_dark;
        int i3;
        int i4;
        int i5;
        boolean z5;
        boolean z6;
        boolean z7;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(479572658);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i8 = 4;
            } else {
                i8 = 2;
            }
            i2 = i8 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(s2Var)) {
                i7 = 32;
            } else {
                i7 = 16;
            }
            i2 |= i7;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i2 |= i6;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(479572658, i2, -1, "com.dragon.read.kmp.reader.detail.MetaRankItem (BookDetailModules.kt:467)");
            }
            String str2 = s2Var.a;
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(str2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = Boolean.valueOf(StringsKt__StringsJVMKt.startsWith$default(str2, "巅峰榜", false, 2, null));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final boolean booleanValue = ((Boolean) rememberedValue).booleanValue();
            startRestartGroup.endReplaceGroup();
            og4.a aVar = og4.a.a;
            boolean e = com.dragon.read.kmp.service.d1.e(aVar.c().a());
            final p2 p2Var = (p2) startRestartGroup.consume(r2.c());
            Object[] objArr = {str};
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.detail.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState r0;
                        r0 = BookDetailModulesKt.r0();
                        return r0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            MutableState mutableState = (MutableState) y.d.d(objArr, (Function0) rememberedValue2, startRestartGroup, 48);
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changed2 = startRestartGroup.changed(mutableState) | startRestartGroup.changedInstance(p2Var);
            int i9 = i2 & 14;
            if (i9 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z8 = changed2 | z2;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new BookDetailModulesKt$MetaRankItem$1$1(mutableState, p2Var, str, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(str, (Function2) rememberedValue3, startRestartGroup, i9);
            startRestartGroup.startReplaceGroup(1307844347);
            Modifier modifier2 = Modifier.Companion;
            startRestartGroup.startReplaceGroup(1307844775);
            if (StringUtilsKt.a(s2Var.c)) {
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changed3 = startRestartGroup.changed(booleanValue) | startRestartGroup.changedInstance(p2Var);
                if (i9 == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean z9 = changed3 | z5;
                if ((i2 & 896) == 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean z10 = z9 | z6;
                if ((i2 & 112) == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean z11 = z10 | z7;
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (!z11 && rememberedValue4 != companion.getEmpty()) {
                    z3 = e;
                    z4 = booleanValue;
                } else {
                    z4 = booleanValue;
                    z3 = e;
                    Function0 function0 = new Function0() { // from class: com.dragon.read.kmp.reader.detail.g0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit s0;
                            s0 = BookDetailModulesKt.s0(booleanValue, p2Var, str, function1, s2Var);
                            return s0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function0);
                    rememberedValue4 = function0;
                }
                startRestartGroup.endReplaceGroup();
                modifier = ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue4, 15, (Object) null);
            } else {
                z3 = e;
                z4 = booleanValue;
                modifier = modifier2;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endReplaceGroup();
            if (s2Var.d) {
                startRestartGroup.startReplaceGroup(1888910442);
                e.a aVar2 = androidx.compose.ui.e.a;
                e.c i10 = aVar2.i();
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                androidx.compose.ui.layout.p0 b2 = androidx.compose.foundation.layout.r2.b(eVar.h(), i10, startRestartGroup, 48);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier);
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
                Composer b3 = g5.b(startRestartGroup);
                g5.e(b3, b2, companion2.c());
                g5.e(b3, currentCompositionLocalMap, companion2.e());
                Function2 b4 = companion2.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                    b3.updateRememberedValue(Integer.valueOf(a2));
                    b3.apply(Integer.valueOf(a2), b4);
                }
                g5.e(b3, e2, companion2.d());
                w2 w2Var = w2.b;
                float f = 35;
                float f2 = 30;
                Modifier x = SizeKt.x(SizeKt.i(modifier2, x0.i.g(f)), x0.i.g(f2));
                androidx.compose.ui.layout.p0 i11 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(startRestartGroup, x);
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
                Composer b5 = g5.b(startRestartGroup);
                g5.e(b5, i11, companion2.c());
                g5.e(b5, currentCompositionLocalMap2, companion2.e());
                Function2 b6 = companion2.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a4))) {
                    b5.updateRememberedValue(Integer.valueOf(a4));
                    b5.apply(Integer.valueOf(a4), b6);
                }
                g5.e(b5, e3, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Res.drawable drawableVar = Res.drawable.INSTANCE;
                if (z3) {
                    skin_top_book_rank_icon_dark = Drawable0_commonMainKt.getSkin_top_book_rank_icon_light(drawableVar);
                } else {
                    skin_top_book_rank_icon_dark = Drawable0_commonMainKt.getSkin_top_book_rank_icon_dark(drawableVar);
                }
                boolean z12 = z3;
                composer2 = startRestartGroup;
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(skin_top_book_rank_icon_dark, startRestartGroup, 0), (String) null, SizeKt.x(SizeKt.i(modifier2, x0.i.g(f)), x0.i.g(f2)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, composer2, 432, 248);
                composer2.startReplaceGroup(352788377);
                if (!z12) {
                    Modifier d = BackgroundKt.d(SizeKt.x(SizeKt.i(modifier2, x0.i.g(f)), x0.i.g(f2)), androidx.compose.ui.graphics.n0.b(436207616), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                    i3 = 6;
                    androidx.compose.foundation.layout.m.b(d, composer2, 6);
                } else {
                    i3 = 6;
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                a3.a(SizeKt.x(modifier2, x0.i.g(i3)), composer2, i3);
                androidx.compose.ui.layout.p0 a6 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar2.k(), composer2, 0);
                int a7 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier e4 = ComposedModifierKt.e(composer2, modifier2);
                Function0 a8 = companion2.a();
                if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(a8);
                } else {
                    composer2.useNode();
                }
                Composer b7 = g5.b(composer2);
                g5.e(b7, a6, companion2.c());
                g5.e(b7, currentCompositionLocalMap3, companion2.e());
                Function2 b8 = companion2.b();
                if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a7))) {
                    b7.updateRememberedValue(Integer.valueOf(a7));
                    b7.apply(Integer.valueOf(a7), b8);
                }
                g5.e(b7, e4, companion2.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                if (z4) {
                    composer2.startReplaceGroup(-1216785347);
                    B0(str2, z12, composer2, 0);
                    composer2.endReplaceGroup();
                    i5 = 4;
                    i4 = 0;
                } else {
                    composer2.startReplaceGroup(-1216606725);
                    i4 = 0;
                    a6.j(str2, (Modifier) null, aVar.c().b(composer2, og4.a.b).k(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 199680, 3120, 120786);
                    composer2.endReplaceGroup();
                    i5 = 4;
                }
                a3.a(SizeKt.i(modifier2, x0.i.g(i5)), composer2, 6);
                androidx.compose.ui.layout.p0 b9 = androidx.compose.foundation.layout.r2.b(eVar.h(), aVar2.i(), composer2, 48);
                int a9 = j.a(androidx.compose.runtime.i.b(composer2, i4));
                androidx.compose.runtime.e0 currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier e5 = ComposedModifierKt.e(composer2, modifier2);
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
                Composer b10 = g5.b(composer2);
                g5.e(b10, b9, companion2.c());
                g5.e(b10, currentCompositionLocalMap4, companion2.e());
                Function2 b11 = companion2.b();
                if (b10.getInserting() || !Intrinsics.areEqual(b10.rememberedValue(), Integer.valueOf(a9))) {
                    b10.updateRememberedValue(Integer.valueOf(a9));
                    b10.apply(Integer.valueOf(a9), b11);
                }
                g5.e(b10, e5, companion2.d());
                String str3 = s2Var.b;
                og4.a c = aVar.c();
                int i12 = og4.a.b;
                a6.j(str3, (Modifier) null, c.b(composer2, i12).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 3072, 3120, 120818);
                composer2.startReplaceGroup(-688743476);
                if (StringUtilsKt.a(s2Var.c)) {
                    androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(yo2.d2.d(f2.a.a), composer2, i4), (String) null, SizeKt.s(modifier2, x0.i.g(10)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, aVar.c().b(composer2, i12).h(), 0, 2, (Object) null), 0, composer2, 432, 184);
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                composer2.endNode();
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(1891062400);
                androidx.compose.foundation.layout.e eVar2 = androidx.compose.foundation.layout.e.a;
                e.m i13 = eVar2.i();
                e.a aVar3 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a11 = androidx.compose.foundation.layout.x.a(i13, aVar3.k(), composer2, 0);
                int a12 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                Modifier e6 = ComposedModifierKt.e(composer2, modifier2);
                ComposeUiNode.Companion companion3 = ComposeUiNode.o0;
                Function0 a13 = companion3.a();
                if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(a13);
                } else {
                    composer2.useNode();
                }
                Composer b12 = g5.b(composer2);
                g5.e(b12, a11, companion3.c());
                g5.e(b12, currentCompositionLocalMap5, companion3.e());
                Function2 b13 = companion3.b();
                if (b12.getInserting() || !Intrinsics.areEqual(b12.rememberedValue(), Integer.valueOf(a12))) {
                    b12.updateRememberedValue(Integer.valueOf(a12));
                    b12.apply(Integer.valueOf(a12), b13);
                }
                g5.e(b12, e6, companion3.d());
                androidx.compose.foundation.layout.c0 c0Var2 = androidx.compose.foundation.layout.c0.b;
                androidx.compose.ui.layout.p0 b14 = androidx.compose.foundation.layout.r2.b(eVar2.h(), aVar3.a(), composer2, 48);
                int a14 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                Modifier e7 = ComposedModifierKt.e(composer2, modifier2);
                Function0 a15 = companion3.a();
                if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(a15);
                } else {
                    composer2.useNode();
                }
                Composer b15 = g5.b(composer2);
                g5.e(b15, b14, companion3.c());
                g5.e(b15, currentCompositionLocalMap6, companion3.e());
                Function2 b16 = companion3.b();
                if (b15.getInserting() || !Intrinsics.areEqual(b15.rememberedValue(), Integer.valueOf(a14))) {
                    b15.updateRememberedValue(Integer.valueOf(a14));
                    b15.apply(Integer.valueOf(a14), b16);
                }
                g5.e(b15, e7, companion3.d());
                w2 w2Var2 = w2.b;
                String str4 = s2Var.e;
                og4.a c2 = aVar.c();
                int i14 = og4.a.b;
                a6.j(str4, (Modifier) null, c2.b(composer2, i14).k(), x0.x.h(18), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131026);
                a3.a(SizeKt.x(modifier2, x0.i.g(2)), composer2, 6);
                a6.j(s2Var.f + (char) 20154, (Modifier) null, aVar.c().b(composer2, i14).k(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3072, 0, 131058);
                composer2.endNode();
                a3.a(SizeKt.i(modifier2, x0.i.g((float) 4)), composer2, 6);
                a6.j(s2Var.b, (Modifier) null, aVar.c().b(composer2, i14).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 3072, 3120, 120818);
                composer2.endNode();
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t0;
                    t0 = BookDetailModulesKt.t0(str, s2Var, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return t0;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void K0(final java.util.List<com.dragon.read.kmp.reader.detail.c> r17, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r18, androidx.compose.ui.Modifier r19, float r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.BookDetailModulesKt.K0(java.util.List, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void u0(final com.bytedance.kmp.reading.model.t3 r24, com.dragon.read.kmp.reader.detail.s2 r25, com.dragon.read.kmp.reader.detail.u2 r26, com.dragon.read.kmp.reader.detail.t2 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.BookDetailModulesKt.u0(com.bytedance.kmp.reading.model.t3, com.dragon.read.kmp.reader.detail.s2, com.dragon.read.kmp.reader.detail.u2, com.dragon.read.kmp.reader.detail.t2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void c0(Modifier modifier, final org.jetbrains.compose.resources.b bVar, final String str, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        Modifier modifier3;
        Composer startRestartGroup = composer.startRestartGroup(566530008);
        int i8 = i2 & 1;
        if (i8 != 0) {
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
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changed(bVar)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (startRestartGroup.changed(str)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        int i9 = i3;
        boolean z2 = true;
        if ((i9 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i9 & 1)) {
            if (i8 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(566530008, i9, -1, "com.dragon.read.kmp.reader.detail.BottomBarItem (BookDetailModules.kt:896)");
            }
            Modifier d = SizeKt.d(SizeKt.x(modifier3, x0.i.g(64)), 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            if ((i9 & 7168) != 2048) {
                z2 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.detail.v
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit d0;
                        d0 = BookDetailModulesKt.d0(Function0.this);
                        return d0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier4 = ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.g(), startRestartGroup, 48);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier4);
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
            g5.e(b2, a2, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            Modifier.a aVar = Modifier.Companion;
            float f = 10;
            a3.a(SizeKt.i(aVar, x0.i.g(f)), startRestartGroup, 6);
            androidx.compose.ui.graphics.e1 a5 = org.jetbrains.compose.resources.c.a(bVar, startRestartGroup, (i9 >> 3) & 14);
            Modifier s = SizeKt.s(aVar, x0.i.g(20));
            m0.a aVar2 = androidx.compose.ui.graphics.m0.b;
            og4.a aVar3 = og4.a.a;
            og4.a c = aVar3.c();
            int i10 = og4.a.b;
            androidx.compose.foundation.z0.g(a5, (String) null, s, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(aVar2, c.b(startRestartGroup, i10).k(), 0, 2, (Object) null), 0, startRestartGroup, 432, 184);
            a3.a(SizeKt.i(aVar, x0.i.g(2)), startRestartGroup, 6);
            a6.j(str, (Modifier) null, aVar3.c().b(startRestartGroup, i10).k(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, ((i9 >> 6) & 14) | 199680, 3120, 120786);
            a3.a(SizeKt.i(aVar, x0.i.g(f)), startRestartGroup, 6);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        androidx.compose.runtime.t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e0;
                    e0 = BookDetailModulesKt.e0(modifier5, bVar, str, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return e0;
                }
            });
        }
    }

    public static final void l0(final List<c> tags, final String str, final boolean z, final Function0<Unit> onToggle, final Function1<? super String, Unit> onTagClick, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(str, "abstract");
        Intrinsics.checkNotNullParameter(onToggle, "onToggle");
        Intrinsics.checkNotNullParameter(onTagClick, "onTagClick");
        Composer startRestartGroup = composer.startRestartGroup(1920314289);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(tags)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i2 = i7 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(str)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i2 |= i6;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i2 |= i5;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(onToggle)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i2 |= i4;
        }
        if ((i & 24576) == 0) {
            if (startRestartGroup.changedInstance(onTagClick)) {
                i3 = 16384;
            } else {
                i3 = 8192;
            }
            i2 |= i3;
        }
        int i8 = i2;
        if ((i8 & 9363) != 9362) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i8 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1920314289, i8, -1, "com.dragon.read.kmp.reader.detail.Intro (BookDetailModules.kt:595)");
            }
            Modifier.a aVar = Modifier.Companion;
            float f = 12;
            Modifier s = androidx.compose.foundation.layout.f2.s(aVar, x0.i.g(16), x0.i.g(f));
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.m i9 = eVar.i();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(i9, aVar2.k(), startRestartGroup, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, s);
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
            g5.e(b2, a2, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            androidx.compose.ui.layout.p0 b4 = androidx.compose.foundation.layout.r2.b(eVar.h(), aVar2.i(), startRestartGroup, 48);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, aVar);
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
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, b4, companion.c());
            g5.e(b5, currentCompositionLocalMap2, companion.e());
            Function2 b6 = companion.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a5))) {
                b5.updateRememberedValue(Integer.valueOf(a5));
                b5.apply(Integer.valueOf(a5), b6);
            }
            g5.e(b5, e2, companion.d());
            w2 w2Var = w2.b;
            og4.a aVar3 = og4.a.a;
            og4.a c = aVar3.c();
            int i10 = og4.a.b;
            a6.j("简介", (Modifier) null, c.b(startRestartGroup, i10).F3(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 3120, 120786);
            float f2 = 10;
            a3.a(SizeKt.x(aVar, x0.i.g(f2)), startRestartGroup, 6);
            int i11 = i8 >> 9;
            composer2 = startRestartGroup;
            K0(tags, onTagClick, null, x0.i.g(4), composer2, (i8 & 14) | 3072 | (i11 & 112), 4);
            startRestartGroup.endNode();
            a3.a(SizeKt.i(aVar, x0.i.g(f)), startRestartGroup, 6);
            ExtandableTextKt.e(str, "展开", aVar3.c().b(startRestartGroup, i10).h(), "收起", aVar3.c().b(startRestartGroup, i10).h(), x0.i.g(f2), SizeKt.h(aVar, 0.0f, 1, (Object) null), z, 0, new g3(aVar3.c().b(composer2, i10).j(), x0.x.h(14), (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (androidx.compose.ui.graphics.e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, x0.x.h(22), (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16646140, (DefaultConstructorMarker) null), onToggle, null, null, composer2, ((i8 >> 3) & 14) | 1772592 | ((i8 << 15) & 29360128), i11 & 14, 6400);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m0;
                    m0 = BookDetailModulesKt.m0(tags, str, z, onToggle, onTagClick, i, (Composer) obj, ((Integer) obj2).intValue());
                    return m0;
                }
            });
        }
    }

    public static final void Q(final String bookId, final List<com.dragon.read.kmp.reader.detail.widget.a> items, final boolean z, final Function0<Unit> onRefreshClick, final Function0<Unit> onAiMoreClick, final Function4<? super String, ? super BookType, ? super com.dragon.read.kmp.reader.detail.widget.a, ? super ym4.k, Unit> onItemClick, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        boolean z3;
        boolean z4;
        Object obj;
        boolean z5;
        boolean z6;
        org.jetbrains.compose.resources.b e;
        String str;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(onRefreshClick, "onRefreshClick");
        Intrinsics.checkNotNullParameter(onAiMoreClick, "onAiMoreClick");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Composer startRestartGroup = composer.startRestartGroup(202651212);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(bookId)) {
                i8 = 4;
            } else {
                i8 = 2;
            }
            i2 = i8 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(items)) {
                i7 = 32;
            } else {
                i7 = 16;
            }
            i2 |= i7;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i2 |= i6;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(onRefreshClick)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i2 |= i5;
        }
        if ((i & 24576) == 0) {
            if (startRestartGroup.changedInstance(onAiMoreClick)) {
                i4 = 16384;
            } else {
                i4 = 8192;
            }
            i2 |= i4;
        }
        if ((196608 & i) == 0) {
            if (startRestartGroup.changedInstance(onItemClick)) {
                i3 = 131072;
            } else {
                i3 = 65536;
            }
            i2 |= i3;
        }
        if ((74899 & i2) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(202651212, i2, -1, "com.dragon.read.kmp.reader.detail.AlsoReadSection (BookDetailModules.kt:744)");
            }
            if (items.isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                androidx.compose.runtime.t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.x
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit R;
                            R = BookDetailModulesKt.R(bookId, items, z, onRefreshClick, onAiMoreClick, onItemClick, i, (Composer) obj2, ((Integer) obj3).intValue());
                            return R;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = androidx.compose.animation.core.b.b(0.0f, 0.0f, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Animatable animatable = (Animatable) rememberedValue;
            startRestartGroup.endReplaceGroup();
            p2 p2Var = (p2) startRestartGroup.consume(r2.c());
            Boolean valueOf = Boolean.valueOf(z);
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i2 & 896) == 256) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean changedInstance = z3 | startRestartGroup.changedInstance(animatable);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new BookDetailModulesKt$AlsoReadSection$2$1(z, animatable, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue2, startRestartGroup, (i2 >> 6) & 14);
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance2 = startRestartGroup.changedInstance(p2Var);
            int i9 = i2 & 14;
            if (i9 == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z7 = z4 | changedInstance2;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (!z7 && rememberedValue3 != companion.getEmpty()) {
                obj = null;
            } else {
                obj = null;
                rememberedValue3 = new BookDetailModulesKt$AlsoReadSection$3$1(p2Var, bookId, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue3, startRestartGroup, 6);
            Modifier.a aVar = Modifier.Companion;
            Modifier h = SizeKt.h(aVar, 0.0f, 1, obj);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.m i10 = eVar.i();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(i10, aVar2.k(), startRestartGroup, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, h);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, a2, companion2.c());
            g5.e(b2, currentCompositionLocalMap, companion2.e());
            Function2 b3 = companion2.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e2, companion2.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            float f = 16;
            Modifier u = androidx.compose.foundation.layout.f2.u(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(28), x0.i.g(f), x0.i.g(f));
            androidx.compose.ui.layout.p0 b4 = androidx.compose.foundation.layout.r2.b(eVar.h(), aVar2.i(), startRestartGroup, 48);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, u);
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
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, b4, companion2.c());
            g5.e(b5, currentCompositionLocalMap2, companion2.e());
            Function2 b6 = companion2.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a5))) {
                b5.updateRememberedValue(Integer.valueOf(a5));
                b5.apply(Integer.valueOf(a5), b6);
            }
            g5.e(b5, e3, companion2.d());
            w2 w2Var = w2.b;
            long h2 = x0.x.h(16);
            c0.a aVar3 = androidx.compose.ui.text.font.c0.b;
            androidx.compose.ui.text.font.c0 d = aVar3.d();
            og4.a aVar4 = og4.a.a;
            og4.a c = aVar4.c();
            int i11 = og4.a.b;
            a6.j("读这本书的人还在读", (Modifier) null, c.b(startRestartGroup, i11).F3(), h2, (androidx.compose.ui.text.font.y) null, d, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 3120, 120786);
            float f2 = 2;
            a3.a(SizeKt.x(aVar, x0.i.g(f2)), startRestartGroup, 6);
            androidx.compose.ui.graphics.e1 a7 = org.jetbrains.compose.resources.c.a(yo2.d2.c(f2.a.a), startRestartGroup, 0);
            androidx.compose.ui.graphics.m0 c2 = m0.a.c(androidx.compose.ui.graphics.m0.b, aVar4.c().h(startRestartGroup, i11).k(), 0, 2, (Object) null);
            Modifier a8 = androidx.compose.ui.draw.n.a(SizeKt.s(aVar, x0.i.g(f)), ((Number) animatable.k()).floatValue());
            startRestartGroup.startReplaceGroup(5004770);
            if ((i2 & 7168) == 2048) {
                z5 = true;
            } else {
                z5 = false;
            }
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.reader.detail.y
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit S;
                        S = BookDetailModulesKt.S(Function0.this);
                        return S;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            androidx.compose.foundation.z0.g(a7, (String) null, ClickableKt.clickable-oSLSa3U$default(a8, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue4, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, c2, 0, startRestartGroup, 48, 184);
            startRestartGroup.startReplaceGroup(-807444284);
            if (com.dragon.read.kmp.reader.detail.platform.a.a.b()) {
                boolean d2 = com.dragon.read.kmp.service.d1.d(aVar4.c().a());
                a3.a(androidx.compose.foundation.layout.u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
                float f3 = 6;
                Modifier c3 = BackgroundKt.c(SizeKt.i(SizeKt.F(aVar, (e.b) null, false, 3, (Object) null), x0.i.g(26)), aVar4.c().b(startRestartGroup, i11).o(), k.g.c(x0.i.g(f3)));
                startRestartGroup.startReplaceGroup(5004770);
                if ((i2 & 57344) == 16384) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: com.dragon.read.kmp.reader.detail.z
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit T;
                            T = BookDetailModulesKt.T(Function0.this);
                            return T;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                Modifier v = androidx.compose.foundation.layout.f2.v(ClickableKt.clickable-oSLSa3U$default(c3, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue5, 15, (Object) null), x0.i.g(f3), 0.0f, x0.i.g(f3), 0.0f, 10, (Object) null);
                androidx.compose.ui.layout.p0 b7 = androidx.compose.foundation.layout.r2.b(eVar.h(), aVar2.i(), startRestartGroup, 48);
                int a9 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e4 = ComposedModifierKt.e(startRestartGroup, v);
                Function0 a10 = companion2.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a10);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b8 = g5.b(startRestartGroup);
                g5.e(b8, b7, companion2.c());
                g5.e(b8, currentCompositionLocalMap3, companion2.e());
                Function2 b9 = companion2.b();
                if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a9))) {
                    b8.updateRememberedValue(Integer.valueOf(a9));
                    b8.apply(Integer.valueOf(a9), b9);
                }
                g5.e(b8, e4, companion2.d());
                c25.q qVar = c25.q.a;
                if (d2) {
                    e = c25.o.d(qVar);
                } else {
                    e = c25.o.e(qVar);
                }
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(e, startRestartGroup, 0), (String) null, SizeKt.s(aVar, x0.i.g(f)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 432, 248);
                a3.a(SizeKt.x(aVar, x0.i.g(f2)), startRestartGroup, 6);
                if (com.dragon.read.kmp.service.b1.a.w()) {
                    str = "AI搜";
                } else {
                    str = "AI搜更多";
                }
                a6.j(str, (Modifier) null, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, new g3(aVar4.h(startRestartGroup, i11).o2(), 0.0f, x0.x.h(12), aVar3.d(), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (androidx.compose.ui.graphics.e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 33554418, (DefaultConstructorMarker) null), startRestartGroup, 0, 3072, 57342);
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            composer2 = startRestartGroup;
            BookDetailHorizontalCoverListKt.o(bookId, "page_recommend", null, null, items, onItemClick, true, startRestartGroup, i9 | 1572912 | ((i2 << 9) & 57344) | (i2 & 458752), 12);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit U;
                    U = BookDetailModulesKt.U(bookId, items, z, onRefreshClick, onAiMoreClick, onItemClick, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return U;
                }
            });
        }
    }

    public static final void i0(final String bookId, final String bookName, final String str, final String subTitle, final String authorId, final String authorName, final String str2, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        String str3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(bookName, "bookName");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(authorId, "authorId");
        Intrinsics.checkNotNullParameter(authorName, "authorName");
        Composer startRestartGroup = composer.startRestartGroup(-81366403);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(bookId)) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i2 = i9 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(bookName)) {
                i8 = 32;
            } else {
                i8 = 16;
            }
            i2 |= i8;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(str)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i2 |= i7;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changed(subTitle)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i2 |= i6;
        }
        if ((i & 24576) == 0) {
            if (startRestartGroup.changed(authorId)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i2 |= i5;
        }
        if ((196608 & i) == 0) {
            if (startRestartGroup.changed(authorName)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i2 |= i4;
        }
        if ((1572864 & i) == 0) {
            if (startRestartGroup.changed(str2)) {
                i3 = 1048576;
            } else {
                i3 = 524288;
            }
            i2 |= i3;
        }
        int i10 = i2;
        boolean z2 = true;
        if ((599187 & i10) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-81366403, i10, -1, "com.dragon.read.kmp.reader.detail.Header (BookDetailModules.kt:270)");
            }
            final p2 p2Var = (p2) startRestartGroup.consume(r2.c());
            Modifier.a aVar = Modifier.Companion;
            float f = 16;
            Modifier u = androidx.compose.foundation.layout.f2.u(aVar, x0.i.g(f), x0.i.g(a + x0.i.g(com.dragon.read.kmp.service.d1.g(ScreenUtils.a.h(ig4.f.a(startRestartGroup, 0))))), x0.i.g(f), x0.i.g(f));
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.e h = eVar.h();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 b2 = androidx.compose.foundation.layout.r2.b(h, aVar2.l(), startRestartGroup, 0);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, u);
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
            if (str == null) {
                str3 = "";
            } else {
                str3 = str;
            }
            float f2 = 0;
            com.dragon.read.kmp.widget.p0.k(str3, BookType.READ, x0.i.g(4), false, false, x0.i.g(f2), x0.i.g(f2), x0.i.g(f2), x0.i.g(f2), x0.i.g(f2), false, SizeKt.i(SizeKt.x(aVar, x0.i.g(72)), x0.i.g(108)), null, null, null, startRestartGroup, 920347056, 54, 28680);
            a3.a(SizeKt.x(aVar, x0.i.g(f)), startRestartGroup, 6);
            Modifier b5 = w2Var.b(androidx.compose.foundation.layout.u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), aVar2.i());
            androidx.compose.ui.layout.p0 a4 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar2.k(), startRestartGroup, 0);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, b5);
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
            Composer b6 = g5.b(startRestartGroup);
            g5.e(b6, a4, companion.c());
            g5.e(b6, currentCompositionLocalMap2, companion.e());
            Function2 b7 = companion.b();
            if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a5))) {
                b6.updateRememberedValue(Integer.valueOf(a5));
                b6.apply(Integer.valueOf(a5), b7);
            }
            g5.e(b6, e2, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            og4.a aVar3 = og4.a.a;
            og4.a c = aVar3.c();
            int i11 = og4.a.b;
            long k = c.b(startRestartGroup, i11).k();
            long h2 = x0.x.h(20);
            androidx.compose.ui.text.font.c0 d = androidx.compose.ui.text.font.c0.b.d();
            s.a aVar4 = w0.s.b;
            a6.j(bookName, (Modifier) null, k, h2, (androidx.compose.ui.text.font.y) null, d, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 2, 0, (Function1) null, (g3) null, startRestartGroup, ((i10 >> 3) & 14) | 199680, 3120, 120786);
            a3.a(SizeKt.i(aVar, x0.i.g(6)), startRestartGroup, 6);
            a6.j(subTitle, (Modifier) null, aVar3.c().b(startRestartGroup, i11).j(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, ((i10 >> 9) & 14) | 3072, 3120, 120818);
            a3.a(SizeKt.i(aVar, x0.i.g(8)), startRestartGroup, 6);
            if (!com.dragon.read.kmp.reader.detail.platform.c.a.a()) {
                startRestartGroup.startReplaceGroup(553467104);
                composer2 = startRestartGroup;
                a6.j(authorName, (Modifier) null, aVar3.c().b(startRestartGroup, i11).f0(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Function1) null, (g3) null, composer2, ((i10 >> 15) & 14) | 3072, 3120, 120818);
                composer2.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            } else {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(553754598);
                com.dragon.read.kmp.community.bookcomment.z zVar = (com.dragon.read.kmp.community.bookcomment.z) composer2.consume(BookDetailPageKt.E());
                if (zVar != null) {
                    composer2.startReplaceGroup(-1633490746);
                    boolean changedInstance = composer2.changedInstance(p2Var);
                    if ((i10 & 14) != 4) {
                        z2 = false;
                    }
                    boolean z3 = changedInstance | z2;
                    Object rememberedValue = composer2.rememberedValue();
                    if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.detail.i
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit j0;
                                j0 = BookDetailModulesKt.j0(p2.this, bookId);
                                return j0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceGroup();
                    int i12 = i10 >> 12;
                    zVar.g(authorId, authorName, str2, (Function0) rememberedValue, composer2, (i12 & 14) | (i12 & 112) | (i12 & 896));
                    Unit unit2 = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k0;
                    k0 = BookDetailModulesKt.k0(bookId, bookName, str, subTitle, authorId, authorName, str2, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k0;
                }
            });
        }
    }

    public static final void Z(Modifier modifier, final Function0<Unit> onCatalogClick, final boolean z, final boolean z2, final Function0<Unit> onListenClick, final String readText, final Function0<Unit> onReadClick, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        Modifier modifier4;
        boolean z4;
        float f;
        Intrinsics.checkNotNullParameter(onCatalogClick, "onCatalogClick");
        Intrinsics.checkNotNullParameter(onListenClick, "onListenClick");
        Intrinsics.checkNotNullParameter(readText, "readText");
        Intrinsics.checkNotNullParameter(onReadClick, "onReadClick");
        Composer startRestartGroup = composer.startRestartGroup(-335656803);
        int i11 = i2 & 1;
        if (i11 != 0) {
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
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(onCatalogClick)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (startRestartGroup.changed(z2)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            if (startRestartGroup.changedInstance(onListenClick)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        }
        if ((i2 & 32) != 0) {
            i3 |= 196608;
        } else if ((i & 196608) == 0) {
            if (startRestartGroup.changed(readText)) {
                i9 = 131072;
            } else {
                i9 = 65536;
            }
            i3 |= i9;
        }
        if ((i2 & 64) != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (startRestartGroup.changedInstance(onReadClick)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i3 |= i10;
        }
        int i12 = i3;
        if ((599187 & i12) != 599186) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (startRestartGroup.shouldExecute(z3, i12 & 1)) {
            if (i11 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-335656803, i12, -1, "com.dragon.read.kmp.reader.detail.BottomActionBar (BookDetailModules.kt:858)");
            }
            Modifier i13 = SizeKt.i(SizeKt.h(modifier4, 0.0f, 1, (Object) null), x0.i.g(58));
            og4.a aVar = og4.a.a;
            og4.a c = aVar.c();
            int i14 = og4.a.b;
            float f2 = 16;
            Modifier t = androidx.compose.foundation.layout.f2.t(BackgroundKt.d(i13, c.b(startRestartGroup, i14).m(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f2), 0.0f, 2, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 b2 = androidx.compose.foundation.layout.r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.i(), startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, t);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a3 = companion.a();
            Modifier modifier5 = modifier4;
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
            c25.q qVar = c25.q.a;
            c0(null, c25.o.c(qVar), "目录", onCatalogClick, startRestartGroup, ((i12 << 6) & 7168) | 384, 1);
            startRestartGroup.startReplaceGroup(1224286789);
            if (z) {
                Modifier.a aVar3 = Modifier.Companion;
                if (z2) {
                    f = 1.0f;
                } else {
                    f = 0.3f;
                }
                c0(androidx.compose.ui.draw.a.a(aVar3, f), c25.o.b(qVar), "听书", onListenClick, startRestartGroup, ((i12 >> 3) & 7168) | 384, 0);
            }
            startRestartGroup.endReplaceGroup();
            Modifier.a aVar4 = Modifier.Companion;
            a3.a(SizeKt.x(aVar4, x0.i.g(f2)), startRestartGroup, 6);
            Modifier b5 = BackgroundKt.b(SizeKt.i(androidx.compose.foundation.layout.u2.a(w2Var, aVar4, 1.0f, false, 2, (Object) null), x0.i.g(36)), aVar.h(startRestartGroup, i14).E0(), k.g.c(x0.i.g(22)), 0.0f, 4, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            if ((i12 & 3670016) == 1048576) {
                z4 = true;
            } else {
                z4 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.detail.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit a0;
                        a0 = BookDetailModulesKt.a0(Function0.this);
                        return a0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier t2 = androidx.compose.foundation.layout.f2.t(ClickableKt.clickable-oSLSa3U$default(b5, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), x0.i.g(24), 0.0f, 2, (Object) null);
            androidx.compose.ui.layout.p0 i15 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, t2);
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
            Composer b6 = g5.b(startRestartGroup);
            g5.e(b6, i15, companion.c());
            g5.e(b6, currentCompositionLocalMap2, companion.e());
            Function2 b7 = companion.b();
            if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a4))) {
                b6.updateRememberedValue(Integer.valueOf(a4));
                b6.apply(Integer.valueOf(a4), b7);
            }
            g5.e(b6, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            composer2 = startRestartGroup;
            a6.j(readText, (Modifier) null, aVar.c().b(startRestartGroup, i14).r(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, ((i12 >> 15) & 14) | 199680, 0, 131026);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        androidx.compose.runtime.t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit b0;
                    b0 = BookDetailModulesKt.b0(modifier3, onCatalogClick, z, z2, onListenClick, readText, onReadClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return b0;
                }
            });
        }
    }

    public static final void D0(final String bookId, final String str, final String str2, final String str3, final String str4, final List<com.dragon.read.kmp.community.bookcomment.a> list, final int i, final Integer num, final String str5, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Composer startRestartGroup = composer.startRestartGroup(-1024466675);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(bookId)) {
                i12 = 4;
            } else {
                i12 = 2;
            }
            i3 = i12 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(str)) {
                i11 = 32;
            } else {
                i11 = 16;
            }
            i3 |= i11;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(str2)) {
                i10 = 256;
            } else {
                i10 = 128;
            }
            i3 |= i10;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changed(str3)) {
                i9 = 2048;
            } else {
                i9 = 1024;
            }
            i3 |= i9;
        }
        if ((i2 & 24576) == 0) {
            if (startRestartGroup.changed(str4)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        }
        if ((196608 & i2) == 0) {
            if (startRestartGroup.changedInstance(list)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        }
        if ((1572864 & i2) == 0) {
            if (startRestartGroup.changed(i)) {
                i6 = 1048576;
            } else {
                i6 = 524288;
            }
            i3 |= i6;
        }
        if ((12582912 & i2) == 0) {
            if (startRestartGroup.changed(num)) {
                i5 = 8388608;
            } else {
                i5 = 4194304;
            }
            i3 |= i5;
        }
        if ((100663296 & i2) == 0) {
            if (startRestartGroup.changed(str5)) {
                i4 = 67108864;
            } else {
                i4 = 33554432;
            }
            i3 |= i4;
        }
        boolean z5 = false;
        if ((38347923 & i3) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1024466675, i3, -1, "com.dragon.read.kmp.reader.detail.ReviewsSection (BookDetailModules.kt:711)");
            }
            if (list != null && !list.isEmpty()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                androidx.compose.runtime.t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.m
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit E0;
                            E0 = BookDetailModulesKt.E0(bookId, str, str2, str3, str4, list, i, num, str5, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return E0;
                        }
                    });
                    return;
                }
                return;
            }
            if (!com.dragon.read.kmp.reader.detail.platform.c.a.a()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                androidx.compose.runtime.t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.n
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit F0;
                            F0 = BookDetailModulesKt.F0(bookId, str, str2, str3, str4, list, i, num, str5, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return F0;
                        }
                    });
                    return;
                }
                return;
            }
            final p2 p2Var = (p2) startRestartGroup.consume(r2.c());
            com.dragon.read.kmp.community.bookcomment.z zVar = (com.dragon.read.kmp.community.bookcomment.z) startRestartGroup.consume(BookDetailPageKt.E());
            if (zVar == null) {
                composer2 = startRestartGroup;
            } else {
                Modifier v = androidx.compose.foundation.layout.f2.v(Modifier.Companion, 0.0f, x0.i.g(16), 0.0f, 0.0f, 13, (Object) null);
                startRestartGroup.startReplaceGroup(5004770);
                int i13 = i3 & 14;
                if (i13 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.reader.detail.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit G0;
                            G0 = BookDetailModulesKt.G0(bookId, (ym4.a) obj);
                            return G0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Function1 function1 = (Function1) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance = startRestartGroup.changedInstance(p2Var);
                if (i13 == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z6 = z4 | changedInstance;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.reader.detail.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit H0;
                            H0 = BookDetailModulesKt.H0(p2.this, bookId, (String) obj);
                            return H0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function1 function12 = (Function1) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance2 = startRestartGroup.changedInstance(p2Var);
                if (i13 == 4) {
                    z5 = true;
                }
                boolean z7 = changedInstance2 | z5;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z7 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.reader.detail.r
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit I0;
                            I0 = BookDetailModulesKt.I0(p2.this, bookId);
                            return I0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                int i14 = i3 << 3;
                composer2 = startRestartGroup;
                zVar.d(v, bookId, str, str2, str3, str4, list, i, num, str5, function1, function12, (Function0) rememberedValue3, composer2, (i14 & 1879048192) | (i14 & 112) | 6 | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (29360128 & i14) | (234881024 & i14), 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup3 = composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit J0;
                    J0 = BookDetailModulesKt.J0(bookId, str, str2, str3, str4, list, i, num, str5, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return J0;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0410  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void P0(final java.lang.String r45, final boolean r46, final long r47, final boolean r49, final java.lang.String r50, final com.bytedance.kmp.ugc.model.xy r51, final kotlin.jvm.functions.Function0<kotlin.Unit> r52, final kotlin.jvm.functions.Function0<kotlin.Unit> r53, final kotlin.jvm.functions.Function0<kotlin.Unit> r54, final kotlin.jvm.functions.Function0<kotlin.Unit> r55, androidx.compose.runtime.Composer r56, final int r57) {
        /*
            Method dump skipped, instructions count: 1438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.BookDetailModulesKt.P0(java.lang.String, boolean, long, boolean, java.lang.String, com.bytedance.kmp.ugc.model.xy, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }
}
