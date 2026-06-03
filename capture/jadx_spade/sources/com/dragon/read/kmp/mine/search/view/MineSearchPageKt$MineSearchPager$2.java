package com.dragon.read.kmp.mine.search.view;

import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material.a6;
import androidx.compose.material.g5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class MineSearchPageKt$MineSearchPager$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MineSearchPageViewModel a;
    final /* synthetic */ PagerState b;
    final /* synthetic */ CoroutineScope c;

    MineSearchPageKt$MineSearchPager$2(MineSearchPageViewModel mineSearchPageViewModel, PagerState pagerState, CoroutineScope coroutineScope) {
        this.a = mineSearchPageViewModel;
        this.b = pagerState;
        this.c = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        b(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    public final void b(Composer composer, int i) {
        boolean z;
        boolean z2;
        ?? r13 = 1;
        if ((i & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (composer.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(171376354, i, -1, "com.dragon.read.kmp.mine.search.view.MineSearchPager.<anonymous> (MineSearchPage.kt:179)");
            }
            List<b0> list = this.a.d;
            final PagerState pagerState = this.b;
            final CoroutineScope coroutineScope = this.c;
            final int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                b0 b0Var = (b0) obj;
                if (pagerState.u() == i2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Modifier d = SizeKt.d(SizeKt.F(Modifier.Companion, (e.b) null, false, 3, (Object) null), 0.0f, (int) r13, (Object) null);
                composer.startReplaceGroup(-1746271574);
                boolean changedInstance = composer.changedInstance(coroutineScope) | composer.changed(pagerState) | composer.changed(i2);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.search.view.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = MineSearchPageKt$MineSearchPager$2.c(CoroutineScope.this, pagerState, i2);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                androidx.compose.runtime.internal.a e = androidx.compose.runtime.internal.t.e(368479747, (boolean) r13, new a(pagerState, i2, b0Var), composer, 54);
                g5.f(z2, (Function0) rememberedValue, d, false, (androidx.compose.foundation.interaction.i) null, 0L, 0L, e, composer, 12583296, 120);
                i2 = i3;
                coroutineScope = coroutineScope;
                pagerState = pagerState;
                r13 = 1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    static final class a implements Function3<androidx.compose.foundation.layout.b0, Composer, Integer, Unit> {
        final /* synthetic */ PagerState a;
        final /* synthetic */ int b;
        final /* synthetic */ b0 c;

        a(PagerState pagerState, int i, b0 b0Var) {
            this.a = pagerState;
            this.b = i;
            this.c = b0Var;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.b0 b0Var, Composer composer, Integer num) {
            a(b0Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.b0 Tab, Composer composer, int i) {
            boolean z;
            androidx.compose.ui.text.font.c0 h;
            String str;
            androidx.compose.ui.text.font.c0 h2;
            Intrinsics.checkNotNullParameter(Tab, "$this$Tab");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(368479747, i, -1, "com.dragon.read.kmp.mine.search.view.MineSearchPager.<anonymous>.<anonymous>.<anonymous> (MineSearchPage.kt:191)");
                }
                float d = com.dragon.read.kmp.utils.d.d(this.a, this.b);
                og4.a aVar = og4.a.a;
                int i2 = og4.a.b;
                long c = com.dragon.read.kmp.utils.d.c(aVar.h(composer, i2).h(), aVar.h(composer, i2).T2(), d, composer, 0);
                Modifier.a aVar2 = Modifier.Companion;
                Modifier v = f2.v(SizeKt.d(aVar2, 0.0f, 1, (Object) null), 0.0f, 0.0f, x0.i.g(16), 0.0f, 11, (Object) null);
                e.a aVar3 = androidx.compose.ui.e.a;
                androidx.compose.ui.e e = aVar3.e();
                b0 b0Var = this.c;
                PagerState pagerState = this.a;
                int i3 = this.b;
                p0 i4 = androidx.compose.foundation.layout.m.i(e, false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, v);
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
                Composer b = androidx.compose.runtime.g5.b(composer);
                androidx.compose.runtime.g5.e(b, i4, companion.c());
                androidx.compose.runtime.g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                androidx.compose.runtime.g5.e(b, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                p0 b3 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar3.l(), composer, 0);
                int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, aVar2);
                Function0 a4 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a4);
                } else {
                    composer.useNode();
                }
                Composer b4 = androidx.compose.runtime.g5.b(composer);
                androidx.compose.runtime.g5.e(b4, b3, companion.c());
                androidx.compose.runtime.g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a3))) {
                    b4.updateRememberedValue(Integer.valueOf(a3));
                    b4.apply(Integer.valueOf(a3), b5);
                }
                androidx.compose.runtime.g5.e(b4, e3, companion.d());
                w2 w2Var = w2.b;
                String str2 = b0Var.b.b;
                if (pagerState.u() == i3) {
                    h = androidx.compose.ui.text.font.c0.b.i();
                } else {
                    h = androidx.compose.ui.text.font.c0.b.h();
                }
                a6.j(str2, (Modifier) null, c, x0.x.h(16), (androidx.compose.ui.text.font.y) null, h, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131026);
                int i5 = b0Var.a;
                if (i5 < 100) {
                    str = String.valueOf(i5);
                } else {
                    str = "99+";
                }
                if (pagerState.u() == i3) {
                    h2 = androidx.compose.ui.text.font.c0.b.i();
                } else {
                    h2 = androidx.compose.ui.text.font.c0.b.h();
                }
                a6.j(str, (Modifier) null, c, x0.x.h(12), (androidx.compose.ui.text.font.y) null, h2, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131026);
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
    public static final Unit c(CoroutineScope coroutineScope, PagerState pagerState, int i) {
        kotlinx.coroutines.i.e(coroutineScope, null, null, new MineSearchPageKt$MineSearchPager$2$1$1$1$1(pagerState, i, null), 3, null);
        return Unit.INSTANCE;
    }
}
