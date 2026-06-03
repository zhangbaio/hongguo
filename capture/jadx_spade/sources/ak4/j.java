package ak4;

import ak4.j;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u;
import androidx.compose.foundation.layout.u1;
import androidx.compose.foundation.layout.v;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import bk4.b0;
import bk4.o;
import bk4.q;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SearchSource;
import com.bytedance.kmp.reading.model.SearchTabType;
import com.bytedance.kmp.reading.model.s80;
import com.dragon.read.component.biz.impl.mine.x6;
import com.dragon.read.component.biz.impl.mine.y6;
import com.dragon.read.kmp.mine.search.view.MineSearchPageViewModel;
import com.dragon.read.kmp.utils.k0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import uh4.c;
import w0.s;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class j implements uh4.c {
    public static final int e;
    private final int a;
    private final hn4.a b;
    private final MineSearchPageViewModel c;
    private boolean d;

    static {
        Covode.recordClassIndex(607748);
        e = 8;
    }

    public void onDestroy() {
        c.a.b(this);
    }

    public final xh4.a r() {
        return this.b.y0();
    }

    public void onResume() {
        xh4.a r;
        xh4.a r2 = r();
        boolean z = false;
        if (r2 != null && !r2.b()) {
            z = true;
        }
        if (z && (r = r()) != null) {
            r.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        zm4.d.d(zm4.d.a, q(), null, k0.a.b(), 2, null);
        dk4.a.a.c(this.b.A0().d, false);
    }

    private final String q() {
        return zm4.e.a.a() + "://search?source=" + SearchSource.HgMyTabRecover.getValue() + "&directSearchSourceId=" + com.bytedance.kmp.network.g.h("clks_mine###", (String) null, false, 6, (Object) null) + "&directQueryWord=" + com.bytedance.kmp.network.g.h(this.b.A0().d, (String) null, false, 6, (Object) null);
    }

    static final class a implements Function3<mg4.b, Composer, Integer, Unit> {
        a() {
        }

        /* renamed from: ak4.j$a$a, reason: collision with other inner class name */
        static final class C0001a implements Function3<v, Composer, Integer, Unit> {
            final /* synthetic */ j a;

            C0001a(j jVar) {
                this.a = jVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit c(j jVar) {
                jVar.t();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(v vVar, Composer composer, Integer num) {
                b(vVar, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void b(v BoxWithConstraints, Composer composer, int i) {
                int i2;
                boolean z;
                String c;
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
                        ComposerKt.traceEventStart(-362197142, i2, -1, "com.dragon.read.kmp.mine.search.MineSearchTabStaggeredDelegate.emptyLayoutContent.<anonymous>.<anonymous> (MineSearchTabStaggeredDelegate.kt:148)");
                    }
                    Modifier.a aVar = Modifier.Companion;
                    Modifier f = u1.f(aVar, 0.0f, x0.i.g(x0.i.g(BoxWithConstraints.f() * 1.0f) / 3.0f), 1, (Object) null);
                    e.a aVar2 = androidx.compose.ui.e.a;
                    e.b g = aVar2.g();
                    final j jVar = this.a;
                    androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                    p0 a = x.a(eVar.i(), g, composer, 48);
                    int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer, f);
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
                    Modifier u = SizeKt.u(aVar, x0.i.g(118), x0.i.g(90));
                    p0 i4 = m.i(aVar2.e(), false);
                    int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(composer, u);
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
                    g5.e(b3, i4, companion.c());
                    g5.e(b3, currentCompositionLocalMap2, companion.e());
                    Function2 b4 = companion.b();
                    if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                        b3.updateRememberedValue(Integer.valueOf(a4));
                        b3.apply(Integer.valueOf(a4), b4);
                    }
                    g5.e(b3, e2, companion.d());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                    com.dragon.read.kmp.compose.common.b.E("empty", composer, 6);
                    composer.endNode();
                    int i5 = jVar.b.A0().a;
                    if (i5 == SearchTabType.MyFavorite.getValue()) {
                        composer.startReplaceGroup(-2068562510);
                        c = org.jetbrains.compose.resources.j.c(y6.j(x6.a), composer, 0);
                        composer.endReplaceGroup();
                    } else if (i5 == SearchTabType.MyLike.getValue()) {
                        composer.startReplaceGroup(-2068559026);
                        c = org.jetbrains.compose.resources.j.c(y6.l(x6.a), composer, 0);
                        composer.endReplaceGroup();
                    } else if (i5 == SearchTabType.MyPost.getValue()) {
                        composer.startReplaceGroup(-2068555666);
                        c = org.jetbrains.compose.resources.j.c(y6.m(x6.a), composer, 0);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(-2068553007);
                        c = org.jetbrains.compose.resources.j.c(y6.k(x6.a), composer, 0);
                        composer.endReplaceGroup();
                    }
                    long h = x0.x.h(14);
                    og4.a aVar3 = og4.a.a;
                    int i6 = og4.a.b;
                    a6.j(c, f2.v(aVar, 0.0f, x0.i.g(20), 0.0f, 0.0f, 13, (Object) null), aVar3.h(composer, i6).j(), h, (y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3120, 0, 131056);
                    float g2 = x0.i.g(10);
                    composer.startReplaceGroup(-1814856593);
                    a3.a(SizeKt.i(aVar, g2), composer, 0);
                    composer.endReplaceGroup();
                    float f2 = 2;
                    Modifier t = f2.t(SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null), 0.0f, x0.i.g(f2), 1, (Object) null);
                    composer.startReplaceGroup(5004770);
                    boolean changedInstance = composer.changedInstance(jVar);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: ak4.i
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit c2;
                                c2 = j.a.C0001a.c(j.this);
                                return c2;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    Modifier modifier = ClickableKt.clickable-oSLSa3U$default(t, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                    p0 b5 = r2.b(eVar.h(), aVar2.i(), composer, 48);
                    int a6 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                    Modifier e3 = ComposedModifierKt.e(composer, modifier);
                    Function0 a7 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a7);
                    } else {
                        composer.useNode();
                    }
                    Composer b6 = g5.b(composer);
                    g5.e(b6, b5, companion.c());
                    g5.e(b6, currentCompositionLocalMap3, companion.e());
                    Function2 b7 = companion.b();
                    if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a6))) {
                        b6.updateRememberedValue(Integer.valueOf(a6));
                        b6.apply(Integer.valueOf(a6), b7);
                    }
                    g5.e(b6, e3, companion.d());
                    w2 w2Var = w2.b;
                    x6 x6Var = x6.a;
                    a6.j(org.jetbrains.compose.resources.j.c(y6.i(x6Var), composer, 0), (Modifier) null, aVar3.h(composer, i6).h(), x0.x.h(14), (y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131058);
                    float g3 = x0.i.g(f2);
                    composer.startReplaceGroup(-344996060);
                    a3.a(SizeKt.x(aVar, g3), composer, 0);
                    composer.endReplaceGroup();
                    Modifier a8 = w2Var.a(aVar, 1.0f, false);
                    p0 i7 = m.i(aVar2.o(), false);
                    int a9 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                    Modifier e4 = ComposedModifierKt.e(composer, a8);
                    Function0 a10 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a10);
                    } else {
                        composer.useNode();
                    }
                    Composer b8 = g5.b(composer);
                    g5.e(b8, i7, companion.c());
                    g5.e(b8, currentCompositionLocalMap4, companion.e());
                    Function2 b9 = companion.b();
                    if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a9))) {
                        b8.updateRememberedValue(Integer.valueOf(a9));
                        b8.apply(Integer.valueOf(a9), b9);
                    }
                    g5.e(b8, e4, companion.d());
                    a6.j(jVar.b.A0().d, (Modifier) null, aVar3.h(composer, i6).f(), x0.x.h(14), (y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer, 3072, 3120, 120818);
                    composer.endNode();
                    float g4 = x0.i.g(f2);
                    composer.startReplaceGroup(-344996060);
                    a3.a(SizeKt.x(aVar, g4), composer, 0);
                    composer.endReplaceGroup();
                    a6.j(org.jetbrains.compose.resources.j.c(y6.n(x6Var), composer, 0), (Modifier) null, aVar3.h(composer, i6).h(), x0.x.h(14), (y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131058);
                    z0.g(org.jetbrains.compose.resources.c.a(d2.F(f2.a.a), composer, 0), "跳转综搜箭头", SizeKt.s(aVar, x0.i.g(16)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(m0.b, aVar3.h(composer, i6).h(), 0, 2, (Object) null), 0, composer, 432, 184);
                    composer.endNode();
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
        public static final Unit c(j jVar) {
            MineSearchPageViewModel mineSearchPageViewModel = jVar.c;
            boolean z = false;
            if (mineSearchPageViewModel != null && mineSearchPageViewModel.L0(jVar.a)) {
                z = true;
            }
            if (z) {
                jVar.c.P0(jVar.a);
                dk4.a.a.c(jVar.b.A0().d, true);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(mg4.b bVar, Composer composer, Integer num) {
            b(bVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(mg4.b it2, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(it2, "it");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-457273580, i, -1, "com.dragon.read.kmp.mine.search.MineSearchTabStaggeredDelegate.emptyLayoutContent.<anonymous> (MineSearchTabStaggeredDelegate.kt:139)");
                }
                androidx.compose.ui.e m = androidx.compose.ui.e.a.m();
                Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(24), 0.0f, 2, (Object) null);
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(j.this);
                final j jVar = j.this;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: ak4.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = j.a.c(j.this);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                u.c(tc4.i.d(t, (Function0) null, (Function0) rememberedValue, 1, (Object) null), m, false, t.e(-362197142, true, new C0001a(j.this), composer, 54), composer, 3120, 4);
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
    public static final yh4.g h(wh4.i depend) {
        Intrinsics.checkNotNullParameter(depend, "depend");
        return new bk4.m(depend);
    }

    private final boolean s(int i) {
        if (i == SearchTabType.MySubscribe.getValue()) {
            return true;
        }
        return false;
    }

    public void a(ai4.d dVar, ai4.b bVar) {
        c.a.f(this, dVar, bVar);
    }

    public void l(Throwable th, ai4.b bVar) {
        c.a.d(this, th, bVar);
    }

    public void m(ai4.c cVar, ai4.b bVar) {
        c.a.e(this, cVar, bVar);
    }

    public Function3<mg4.b, Composer, Integer, Unit> j(mg4.b config, boolean z) {
        Intrinsics.checkNotNullParameter(config, "config");
        return t.c(-457273580, true, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yh4.g f(j jVar, wh4.i depend) {
        Intrinsics.checkNotNullParameter(depend, "depend");
        if (jVar.b.A0().a == SearchTabType.MyFavorite.getValue()) {
            return new bk4.g(depend);
        }
        return new bk4.i(depend);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yh4.g g(j jVar, wh4.i depend) {
        Intrinsics.checkNotNullParameter(depend, "depend");
        int i = jVar.b.A0().a;
        if (jVar.s(i)) {
            return new b0(depend);
        }
        if (i == SearchTabType.MyFavorite.getValue()) {
            return new q(depend);
        }
        if (i == SearchTabType.MyLike.getValue()) {
            return new bk4.t(depend);
        }
        if (i == SearchTabType.MyPost.getValue()) {
            return new o(depend, jVar.r());
        }
        return new bk4.e0(depend);
    }

    public void k(ai4.d result, ai4.b requestParams) {
        boolean z;
        xh4.a r;
        ai4.a requestHelper;
        ai4.a requestHelper2;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
        c.a.c(this, result, requestParams);
        if (requestParams.a) {
            xh4.a r2 = r();
            if (r2 != null && (requestHelper2 = r2.getRequestHelper()) != null) {
                requestHelper2.m(result.b);
            }
            s80 a2 = this.b.a();
            if (a2 != null) {
                z = Intrinsics.areEqual(a2.f, Boolean.FALSE);
            } else {
                z = false;
            }
            if (z && (r = r()) != null && (requestHelper = r.getRequestHelper()) != null) {
                requestHelper.l(false);
            }
        }
    }

    public void b(int i, int i2, int i3) {
        c.a.h(this, i, i2, i3);
    }

    public j(int i, hn4.a feedTab, MineSearchPageViewModel mineSearchPageViewModel) {
        Intrinsics.checkNotNullParameter(feedTab, "feedTab");
        this.a = i;
        this.b = feedTab;
        this.c = mineSearchPageViewModel;
        this.d = true;
        xh4.a r = r();
        if (r != null) {
            r.g(Reflection.getOrCreateKotlinClass(ck4.a.class), new Function1() { // from class: ak4.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    yh4.g f;
                    f = j.f(j.this, (wh4.i) obj);
                    return f;
                }
            });
        }
        xh4.a r2 = r();
        if (r2 != null) {
            r2.g(Reflection.getOrCreateKotlinClass(ck4.d.class), new Function1() { // from class: ak4.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    yh4.g g;
                    g = j.g(j.this, (wh4.i) obj);
                    return g;
                }
            });
        }
        xh4.a r3 = r();
        if (r3 != null) {
            r3.g(Reflection.getOrCreateKotlinClass(ck4.c.class), new Function1() { // from class: ak4.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    yh4.g h;
                    h = j.h((wh4.i) obj);
                    return h;
                }
            });
        }
    }
}
