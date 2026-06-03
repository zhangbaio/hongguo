package ak4;

import ak4.d;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.u;
import androidx.compose.foundation.layout.u1;
import androidx.compose.foundation.layout.v;
import androidx.compose.foundation.layout.x;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.mine.x6;
import com.dragon.read.component.biz.impl.mine.y6;
import com.dragon.read.kmp.mine.search.view.MineSearchPageViewModel;
import com.dragon.read.kmp.service.c0;
import com.dragon.read.kmp.service.f1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import q64.a0;
import xh4.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d extends j {
    public static final int f;

    static {
        Covode.recordClassIndex(607747);
        f = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(d dVar, int i, Composer composer, int i2) {
        dVar.v(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function3<v, Composer, Integer, Unit> {
        a() {
        }

        /* renamed from: ak4.d$a$a, reason: collision with other inner class name */
        public static final class C0000a implements f1 {
            final /* synthetic */ d a;

            @Override // com.dragon.read.kmp.service.f1
            public void a() {
            }

            @Override // com.dragon.read.kmp.service.f1
            public void b() {
            }

            @Override // com.dragon.read.kmp.service.f1
            public void success() {
                xh4.a r = this.a.r();
                if (r != null) {
                    a.a.b(r, new ai4.b(true, false, false, false, (Object) null, 0, 62, (DefaultConstructorMarker) null), (a0) null, 2, (Object) null);
                }
            }

            C0000a(d dVar) {
                this.a = dVar;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(d dVar) {
            c0.a.K5("mine_search_post_login", new C0000a(dVar));
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
                    ComposerKt.traceEventStart(1291019890, i2, -1, "com.dragon.read.kmp.mine.search.MineSearchPostTabStaggeredDelegate.LoginPanel.<anonymous> (MineSearchPostTabStaggeredDelegate.kt:61)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier f = u1.f(aVar, 0.0f, x0.i.g(x0.i.g(BoxWithConstraints.f() * 1.0f) / 3.0f), 1, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                e.b g = aVar2.g();
                final d dVar = d.this;
                p0 a = x.a(androidx.compose.foundation.layout.e.a.i(), g, composer, 48);
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
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                x6 x6Var = x6.a;
                String c = org.jetbrains.compose.resources.j.c(y6.h(x6Var), composer, 0);
                long h = x0.x.h(14);
                og4.a aVar3 = og4.a.a;
                int i4 = og4.a.b;
                a6.j(c, (Modifier) null, aVar3.h(composer, i4).j(), h, (y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131058);
                float g2 = x0.i.g(20);
                composer.startReplaceGroup(-1814856593);
                a3.a(SizeKt.i(aVar, g2), composer, 0);
                composer.endReplaceGroup();
                float f2 = 8;
                Modifier d = BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null), k.g.c(x0.i.g(f2))), aVar3.h(composer, i4).o(), (f2) null, 2, (Object) null);
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(dVar);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: ak4.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c2;
                            c2 = d.a.c(d.this);
                            return c2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                p0 i5 = m.i(aVar2.o(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, modifier);
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
                g5.e(b3, i5, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                    b3.updateRememberedValue(Integer.valueOf(a4));
                    b3.apply(Integer.valueOf(a4), b4);
                }
                g5.e(b3, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                a6.j(org.jetbrains.compose.resources.j.c(y6.g(x6Var), composer, 0), androidx.compose.foundation.layout.f2.s(aVar, x0.i.g(22), x0.i.g(f2)), aVar3.h(composer, i4).T2(), x0.x.h(14), (y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199728, 0, 131024);
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

    @Override // ak4.j
    public Function3<mg4.b, Composer, Integer, Unit> j(mg4.b config, boolean z) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (!c0.a.isLogin()) {
            return t.c(-1571033553, true, new b());
        }
        return super.j(config, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1445345672);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(this)) {
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
                ComposerKt.traceEventStart(1445345672, i2, -1, "com.dragon.read.kmp.mine.search.MineSearchPostTabStaggeredDelegate.LoginPanel (MineSearchPostTabStaggeredDelegate.kt:56)");
            }
            u.c(androidx.compose.foundation.layout.f2.t(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(24), 0.0f, 2, (Object) null), androidx.compose.ui.e.a.m(), false, t.e(1291019890, true, new a(), startRestartGroup, 54), startRestartGroup, 3126, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: ak4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit w;
                    w = d.w(d.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return w;
                }
            });
        }
    }

    static final class b implements Function3<mg4.b, Composer, Integer, Unit> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(mg4.b bVar, Composer composer, Integer num) {
            a(bVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(mg4.b it2, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(it2, "it");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1571033553, i, -1, "com.dragon.read.kmp.mine.search.MineSearchPostTabStaggeredDelegate.emptyLayoutContent.<anonymous> (MineSearchPostTabStaggeredDelegate.kt:49)");
                }
                d.this.v(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i, hn4.a feedTab, MineSearchPageViewModel mineSearchPageViewModel) {
        super(i, feedTab, mineSearchPageViewModel);
        Intrinsics.checkNotNullParameter(feedTab, "feedTab");
    }
}
