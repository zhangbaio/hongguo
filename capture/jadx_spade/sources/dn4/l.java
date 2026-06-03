package dn4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.service.d1;
import dn4.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    static {
        Covode.recordClassIndex(608747);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(MutableState mutableState, Function1 function1, int i, Composer composer, int i2) {
        b(mutableState, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function1<Integer, Unit> a;
        final /* synthetic */ m b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Integer, Unit> function1, m mVar) {
            this.a = function1;
            this.b = mVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(Function1 function1, m mVar) {
            function1.invoke(Integer.valueOf(mVar.a));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            b(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(Composer composer, int i) {
            boolean z;
            org.jetbrains.compose.resources.b T;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(255743075, i, -1, "com.dragon.read.kmp.search.card.IpForumEntranceCard.<anonymous> (IpForumEntranceCard.kt:56)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier a = androidx.compose.ui.draw.e.a(f2.v(SizeKt.i(SizeKt.x(aVar, pg4.j.c(84, composer, 6)), pg4.j.c(126, composer, 6)), 0.0f, 0.0f, 0.0f, x0.i.g(8), 7, (Object) null), k.g.c(x0.i.g(6)));
                og4.a aVar2 = og4.a.a;
                int i2 = og4.a.b;
                Modifier d = BackgroundKt.d(a, aVar2.h(composer, i2).o(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changed = composer.changed(this.a) | composer.changed(this.b);
                final Function1<Integer, Unit> function1 = this.a;
                final m mVar = this.b;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: dn4.k
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = l.a.c(Function1.this, mVar);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                m mVar2 = this.b;
                e.a aVar3 = androidx.compose.ui.e.a;
                p0 i3 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, modifier);
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
                g5.e(b, i3, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                Modifier b3 = BoxScopeInstance.a.b(SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar3.e());
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                p0 a4 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar3.k(), composer, 0);
                int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, b3);
                Function0 a6 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a6);
                } else {
                    composer.useNode();
                }
                Composer b4 = g5.b(composer);
                g5.e(b4, a4, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                    b4.updateRememberedValue(Integer.valueOf(a5));
                    b4.apply(Integer.valueOf(a5), b5);
                }
                g5.e(b4, e2, companion.d());
                Modifier a7 = androidx.compose.ui.draw.e.a(androidx.compose.foundation.layout.c0.b.b(SizeKt.s(aVar, x0.i.g(32)), aVar3.g()), k.g.f());
                String str = mVar2.b;
                composer.startReplaceGroup(-1894633773);
                com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                if (d1.d(aVar2.e(composer, i2))) {
                    T = d2.S(f2.a.a);
                } else {
                    T = d2.T(f2.a.a);
                }
                nVar.e = T;
                composer.endReplaceGroup();
                LoadImageKt.g(str, (String) null, nVar, a7, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, composer, 0, 114);
                a3.a(SizeKt.i(aVar, x0.i.g(12)), composer, 6);
                p0 b6 = r2.b(eVar.h(), aVar3.i(), composer, 48);
                int a8 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, aVar);
                Function0 a9 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a9);
                } else {
                    composer.useNode();
                }
                Composer b7 = g5.b(composer);
                g5.e(b7, b6, companion.c());
                g5.e(b7, currentCompositionLocalMap3, companion.e());
                Function2 b8 = companion.b();
                if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a8))) {
                    b7.updateRememberedValue(Integer.valueOf(a8));
                    b7.apply(Integer.valueOf(a8), b8);
                }
                g5.e(b7, e3, companion.d());
                w2 w2Var = w2.b;
                a6.j("更多讨论", (Modifier) null, aVar2.h(composer, i2).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3078, 0, 131058);
                z0.g(com.dragon.read.kmp.compose.common.image.e.a(d2.D(f2.a.a), composer, 0), (String) null, SizeKt.s(aVar, x0.i.g(10)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, aVar2.h(composer, i2).h(), 0, 2, (Object) null), 0, composer, 432, 184);
                composer.endNode();
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

    public static final void b(final MutableState<m> state, final Function1<? super Integer, Unit> click, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(click, "click");
        Composer startRestartGroup = composer.startRestartGroup(1205028084);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(state)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(click)) {
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
                ComposerKt.traceEventStart(1205028084, i2, -1, "com.dragon.read.kmp.search.card.IpForumEntranceCard (IpForumEntranceCard.kt:53)");
            }
            pg4.p.f((pg4.i) null, androidx.compose.runtime.internal.t.e(255743075, true, new a(click, (m) state.getValue()), startRestartGroup, 54), startRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: dn4.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = l.c(state, click, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}
