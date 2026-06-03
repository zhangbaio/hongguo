package com.dragon.read.kmp.shortvideo.distribution.infinite;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.v0;
import androidx.compose.foundation.lazy.grid.w0;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
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
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.p90;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class InnerInfinitePanelKt {
    private static final Lazy a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, Function1 function1, FilterType filterType, Function0 function0, int i, int i2, Composer composer, int i3) {
        j(gVar, function1, filterType, function0, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(LazyGridState lazyGridState, Function1 function1, int i, int i2, Composer composer, int i3) {
        m(lazyGridState, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(LazyGridState lazyGridState, Function1 function1, int i, int i2, Composer composer, int i3) {
        m(lazyGridState, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, Function0 function0, Function1 function1, FilterType filterType, int i, int i2, Composer composer, int i3) {
        p(gVar, function0, function1, filterType, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class b implements Function0<Unit> {
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.g a;
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.d b;

        b(com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar) {
            this.a = gVar;
            this.b = dVar;
        }

        public final void a() {
            this.a.f(this.b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class c implements Function0<Unit> {
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.c a;

        c(com.dragon.read.kmp.shortvideo.distribution.infinite.c cVar) {
            this.a = cVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            com.dragon.read.kmp.shortvideo.distribution.infinite.c cVar = this.a;
            cVar.d = -1;
            cVar.e.setValue(Boolean.FALSE);
        }
    }

    static final class d implements Function0<Unit> {
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.g a;
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.d b;

        d(com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar) {
            this.a = gVar;
            this.b = dVar;
        }

        public final void a() {
            this.a.f(this.b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class e implements Function0<Unit> {
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.g a;
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.d b;
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.g c;
        final /* synthetic */ FilterType d;
        final /* synthetic */ Function0<Unit> e;

        e(com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar, com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar2, FilterType filterType, Function0<Unit> function0) {
            this.a = gVar;
            this.b = dVar;
            this.c = gVar2;
            this.d = filterType;
            this.e = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            boolean n = this.a.n(this.b.b.b);
            this.c.e(this.b, this.d);
            if (!n) {
                this.e.invoke();
                this.c.j(false, this.d);
            }
        }
    }

    public static final float x() {
        return ((x0.i) a.getValue()).m();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(609032);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.infinite.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                x0.i y;
                y = InnerInfinitePanelKt.y();
                return y;
            }
        });
        a = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x0.i y() {
        b1 b1Var = b1.a;
        int n = b1Var.n();
        if (n > 0) {
            return x0.i.d(x0.i.g(x0.i.g(b1Var.y(n)) - x0.i.g(98)));
        }
        return x0.i.d(x0.i.g(749));
    }

    public static final class g implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public g(List list) {
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

    public static final class f implements Function1<Integer, Object> {
        final /* synthetic */ Function2 a;
        final /* synthetic */ List b;

        public f(Function2 function2, List list) {
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
    public static final androidx.compose.foundation.lazy.grid.c r(androidx.compose.foundation.lazy.grid.y item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return androidx.compose.foundation.lazy.grid.c.a(androidx.compose.foundation.lazy.grid.b1.a(item.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object s(int i, com.dragon.read.kmp.shortvideo.distribution.infinite.d filterItem) {
        Intrinsics.checkNotNullParameter(filterItem, "filterItem");
        p90 p90Var = filterItem.b;
        return p90Var.b + '_' + p90Var.c;
    }

    public static final void w(com.dragon.read.kmp.shortvideo.distribution.infinite.g infiniteFilterData, FilterType filterType) {
        List<com.dragon.read.kmp.shortvideo.distribution.infinite.c> list;
        boolean z;
        Intrinsics.checkNotNullParameter(infiniteFilterData, "infiniteFilterData");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        com.dragon.read.kmp.shortvideo.distribution.infinite.g b2 = com.dragon.read.kmp.shortvideo.distribution.infinite.h.b(infiniteFilterData, filterType);
        if (b2 != null && (list = b2.c) != null) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                com.dragon.read.kmp.shortvideo.distribution.infinite.c cVar = (com.dragon.read.kmp.shortvideo.distribution.infinite.c) obj;
                Iterator<com.dragon.read.kmp.shortvideo.distribution.infinite.d> it2 = cVar.c.iterator();
                int i3 = 0;
                while (true) {
                    if (it2.hasNext()) {
                        if (Intrinsics.areEqual(it2.next().b.c, Boolean.TRUE)) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                MutableState<Boolean> mutableState = cVar.e;
                if (cVar.d != -1) {
                    int size = cVar.c.size();
                    int i4 = cVar.d;
                    if (size > i4) {
                        z = true;
                        if (i3 + 1 < i4) {
                            mutableState.setValue(Boolean.valueOf(z));
                            i = i2;
                        }
                    }
                }
                z = false;
                mutableState.setValue(Boolean.valueOf(z));
                i = i2;
            }
        }
    }

    static final class a implements Function3<androidx.compose.foundation.lazy.grid.w, Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.c a;

        a(com.dragon.read.kmp.shortvideo.distribution.infinite.c cVar) {
            this.a = cVar;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.grid.w wVar, Composer composer, Integer num) {
            a(wVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.grid.w item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(54437026, i, -1, "com.dragon.read.kmp.shortvideo.distribution.infinite.SelectPanelView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InnerInfinitePanel.kt:116)");
                }
                Modifier v = f2.v(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, x0.i.g(24), 0.0f, x0.i.g(16), 5, (Object) null);
                e.e h = androidx.compose.foundation.layout.e.a.h();
                e.c l = androidx.compose.ui.e.a.l();
                com.dragon.read.kmp.shortvideo.distribution.infinite.c cVar = this.a;
                p0 b = r2.b(h, l, composer, 54);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, v);
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
                a6.j(cVar.a, (Modifier) null, og4.a.a.h(composer, og4.a.b).k(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 131026);
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
    public static final Unit k(Function0 function0, com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, FilterType filterType) {
        function0.invoke();
        gVar.j(true, filterType);
        return Unit.INSTANCE;
    }

    public static final vc4.a u(com.dragon.read.kmp.shortvideo.distribution.infinite.d filterItem, String str, ym4.a paramsArgs) {
        Intrinsics.checkNotNullParameter(filterItem, "filterItem");
        Intrinsics.checkNotNullParameter(paramsArgs, "paramsArgs");
        vc4.a aVar = new vc4.a();
        String str2 = filterItem.b.a;
        if (str2 == null) {
            str2 = "";
        }
        vc4.a n = aVar.m(str2).n(com.dragon.read.kmp.shortvideo.distribution.infinite.h.d(filterItem));
        String str3 = "1";
        vc4.a h2 = n.h("1");
        if (!com.dragon.read.kmp.shortvideo.distribution.infinite.h.i(filterItem)) {
            str3 = "0";
        }
        vc4.a d2 = h2.g(str3).d(str);
        ym4.a aVar2 = new ym4.a();
        aVar2.j(paramsArgs);
        return d2.j(aVar2);
    }

    public static final class h implements Function4<androidx.compose.foundation.lazy.grid.w, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.c b;
        final /* synthetic */ boolean c;
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.g d;
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.g e;
        final /* synthetic */ FilterType f;
        final /* synthetic */ Function0 g;

        public h(List list, com.dragon.read.kmp.shortvideo.distribution.infinite.c cVar, boolean z, com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar2, FilterType filterType, Function0 function0) {
            this.a = list;
            this.b = cVar;
            this.c = z;
            this.d = gVar;
            this.e = gVar2;
            this.f = filterType;
            this.g = function0;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.grid.w wVar, Integer num, Composer composer, Integer num2) {
            a(wVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.grid.w wVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            boolean z2;
            long o;
            long j;
            int i4;
            boolean z3;
            long o2;
            int i5;
            int i6;
            if ((i2 & 6) == 0) {
                if (composer.changed(wVar)) {
                    i6 = 4;
                } else {
                    i6 = 2;
                }
                i3 = i2 | i6;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composer.changed(i)) {
                    i5 = 32;
                } else {
                    i5 = 16;
                }
                i3 |= i5;
            }
            boolean z4 = true;
            if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1942245546, i3, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:576)");
                }
                int i7 = (i3 & 112) | (i3 & 14);
                com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar = (com.dragon.read.kmp.shortvideo.distribution.infinite.d) this.a.get(i);
                composer.startReplaceGroup(-800190267);
                composer.startReplaceGroup(-718550728);
                int i8 = this.b.d;
                if (i8 != -1 && (i4 = i + 1) >= i8 && this.c) {
                    if (i4 == i8) {
                        Modifier.a aVar = Modifier.Companion;
                        composer.startReplaceGroup(-1633490746);
                        boolean changed = composer.changed(this.d);
                        if ((((i7 & 896) ^ 384) > 256 && composer.changed(dVar)) || (i7 & 384) == 256) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        boolean z5 = z3 | changed;
                        Object rememberedValue = composer.rememberedValue();
                        if (z5 || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new b(this.d, dVar);
                            composer.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceGroup();
                        float f = 12;
                        float f2 = 8;
                        Modifier h = SizeKt.h(androidx.compose.ui.draw.e.a(f2.v(tc4.i.d(aVar, (Function0) null, (Function0) rememberedValue, 1, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(f), 7, (Object) null), k.g.c(x0.i.g(f2))), 0.0f, 1, (Object) null);
                        if (this.e.n(dVar.b.b)) {
                            composer.startReplaceGroup(-799714387);
                            o2 = og4.a.a.h(composer, og4.a.b).x();
                            composer.endReplaceGroup();
                        } else {
                            composer.startReplaceGroup(-799603500);
                            o2 = og4.a.a.h(composer, og4.a.b).o();
                            composer.endReplaceGroup();
                        }
                        Modifier s = f2.s(BackgroundKt.d(h, o2, (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f), x0.i.g(f2));
                        composer.startReplaceGroup(5004770);
                        boolean changed2 = composer.changed(this.b);
                        Object rememberedValue2 = composer.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new c(this.b);
                            composer.updateRememberedValue(rememberedValue2);
                        }
                        composer.endReplaceGroup();
                        Modifier modifier = ClickableKt.clickable-oSLSa3U$default(s, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null);
                        p0 i9 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
                        int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                        e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                        Modifier e = ComposedModifierKt.e(composer, modifier);
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
                        Composer b = g5.b(composer);
                        g5.e(b, i9, companion.c());
                        g5.e(b, currentCompositionLocalMap, companion.e());
                        Function2 b2 = companion.b();
                        if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                            b.updateRememberedValue(Integer.valueOf(a));
                            b.apply(Integer.valueOf(a), b2);
                        }
                        g5.e(b, e, companion.d());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                        z0.g(org.jetbrains.compose.resources.c.a(u75.r.d(u75.t.a), composer, 0), "展开", SizeKt.s(aVar, x0.i.g(16)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, composer, 432, 248);
                        composer.endNode();
                    }
                    composer.endReplaceGroup();
                    composer.endReplaceGroup();
                } else {
                    composer.endReplaceGroup();
                    Modifier.a aVar2 = Modifier.Companion;
                    composer.startReplaceGroup(-1633490746);
                    boolean changed3 = composer.changed(this.d);
                    int i10 = (i7 & 896) ^ 384;
                    if ((i10 > 256 && composer.changed(dVar)) || (i7 & 384) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean z6 = changed3 | z2;
                    Object rememberedValue3 = composer.rememberedValue();
                    if (z6 || rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = new d(this.d, dVar);
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    composer.endReplaceGroup();
                    Modifier d = tc4.i.d(aVar2, (Function0) null, (Function0) rememberedValue3, 1, (Object) null);
                    float f3 = 12;
                    float f4 = 8;
                    Modifier h2 = SizeKt.h(androidx.compose.ui.draw.e.a(f2.v(d, 0.0f, 0.0f, 0.0f, x0.i.g(f3), 7, (Object) null), k.g.c(x0.i.g(f4))), 0.0f, 1, (Object) null);
                    if (this.e.n(dVar.b.b)) {
                        composer.startReplaceGroup(-798580035);
                        o = og4.a.a.h(composer, og4.a.b).x();
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(-798485020);
                        o = og4.a.a.h(composer, og4.a.b).o();
                        composer.endReplaceGroup();
                    }
                    Modifier s2 = f2.s(BackgroundKt.d(h2, o, (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f3), x0.i.g(f4));
                    composer.startReplaceGroup(-1224400529);
                    boolean changed4 = composer.changed(this.e);
                    if ((i10 <= 256 || !composer.changed(dVar)) && (i7 & 384) != 256) {
                        z4 = false;
                    }
                    boolean changed5 = changed4 | z4 | composer.changed(this.d) | composer.changed(this.f.ordinal()) | composer.changed(this.g);
                    Object rememberedValue4 = composer.rememberedValue();
                    if (changed5 || rememberedValue4 == Composer.Companion.getEmpty()) {
                        rememberedValue4 = new e(this.e, dVar, this.d, this.f, this.g);
                        composer.updateRememberedValue(rememberedValue4);
                    }
                    composer.endReplaceGroup();
                    Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(s2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue4, 15, (Object) null);
                    p0 i11 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
                    int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(composer, modifier2);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                    Function0 a4 = companion2.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a4);
                    } else {
                        composer.useNode();
                    }
                    Composer b3 = g5.b(composer);
                    g5.e(b3, i11, companion2.c());
                    g5.e(b3, currentCompositionLocalMap2, companion2.e());
                    Function2 b4 = companion2.b();
                    if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                        b3.updateRememberedValue(Integer.valueOf(a3));
                        b3.apply(Integer.valueOf(a3), b4);
                    }
                    g5.e(b3, e2, companion2.d());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.a;
                    p90 p90Var = dVar.b;
                    String str = p90Var.a;
                    if (str == null) {
                        str = "";
                    }
                    String str2 = str;
                    if (this.e.n(p90Var.b)) {
                        composer.startReplaceGroup(-771475539);
                        j = og4.a.a.h(composer, og4.a.b).f();
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(-771391374);
                        j = og4.a.a.h(composer, og4.a.b).j();
                        composer.endReplaceGroup();
                    }
                    a6.j(str2, (Modifier) null, j, x0.x.h(14), (androidx.compose.ui.text.font.y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer, 3072, 3120, 120818);
                    composer.endNode();
                    composer.endReplaceGroup();
                }
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
    public static final Unit q(com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, FilterType filterType, Function0 function0, w0 LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        com.dragon.read.kmp.shortvideo.distribution.infinite.g b2 = com.dragon.read.kmp.shortvideo.distribution.infinite.h.b(gVar, filterType);
        if (b2 == null) {
            return Unit.INSTANCE;
        }
        int i = 0;
        for (Object obj : b2.c) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.dragon.read.kmp.shortvideo.distribution.infinite.c cVar = (com.dragon.read.kmp.shortvideo.distribution.infinite.c) obj;
            v0.a(LazyVerticalGrid, (Object) null, new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.infinite.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    androidx.compose.foundation.lazy.grid.c r;
                    r = InnerInfinitePanelKt.r((androidx.compose.foundation.lazy.grid.y) obj2);
                    return r;
                }
            }, (Object) null, androidx.compose.runtime.internal.t.c(54437026, true, new a(cVar)), 5, (Object) null);
            boolean booleanValue = ((Boolean) cVar.e.getValue()).booleanValue();
            List<com.dragon.read.kmp.shortvideo.distribution.infinite.d> list = cVar.c;
            LazyVerticalGrid.d(list.size(), new f(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.infinite.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Object s;
                    s = InnerInfinitePanelKt.s(((Integer) obj2).intValue(), (d) obj3);
                    return s;
                }
            }, list), (Function2) null, new g(list), androidx.compose.runtime.internal.t.c(-1942245546, true, new h(list, cVar, booleanValue, gVar, b2, filterType, function0)));
            i = i2;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ vc4.a v(com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar, String str, ym4.a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return u(dVar, str, aVar);
    }

    private static final void m(final LazyGridState lazyGridState, final Function1<? super Boolean, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2;
        Composer startRestartGroup = composer.startRestartGroup(771719823);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            if (startRestartGroup.changed(lazyGridState)) {
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
            if (startRestartGroup.changedInstance(function1)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        boolean z3 = false;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i6 != 0) {
                function1 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(771719823, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.infinite.PanelScrollEffect (InnerInfinitePanel.kt:180)");
            }
            if (function1 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.infinite.p
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit n;
                            n = InnerInfinitePanelKt.n(lazyGridState, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return n;
                        }
                    });
                    return;
                }
                return;
            }
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i3 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i3 & 112) == 32) {
                z3 = true;
            }
            boolean z4 = z2 | z3;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new InnerInfinitePanelKt$PanelScrollEffect$2$1(lazyGridState, function1, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue, startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.infinite.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = InnerInfinitePanelKt.o(lazyGridState, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void p(final com.dragon.read.kmp.shortvideo.distribution.infinite.g r24, final kotlin.jvm.functions.Function0<kotlin.Unit> r25, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r26, com.dragon.read.kmp.shortvideo.distribution.model.FilterType r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.infinite.InnerInfinitePanelKt.p(com.dragon.read.kmp.shortvideo.distribution.infinite.g, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, com.dragon.read.kmp.shortvideo.distribution.model.FilterType, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(final com.dragon.read.kmp.shortvideo.distribution.infinite.g r37, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r38, com.dragon.read.kmp.shortvideo.distribution.model.FilterType r39, final kotlin.jvm.functions.Function0<kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 879
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.infinite.InnerInfinitePanelKt.j(com.dragon.read.kmp.shortvideo.distribution.infinite.g, kotlin.jvm.functions.Function1, com.dragon.read.kmp.shortvideo.distribution.model.FilterType, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
