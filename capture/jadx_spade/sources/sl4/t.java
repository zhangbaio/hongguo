package sl4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.font.z;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.l0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.guestprofile.tabContent.data.FootLoadingState;
import com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPagerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t {
    static {
        Covode.recordClassIndex(608156);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(FootLoadingState footLoadingState, int i, Composer composer, int i2) {
        d(footLoadingState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(FootLoadingState footLoadingState, int i, Composer composer, int i2) {
        d(footLoadingState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(tl4.l lVar) {
        com.dragon.read.kmp.j.a.d("LoadMoreFootView", "on retry view");
        tl4.l.A(lVar, false, 1, null);
        return Unit.INSTANCE;
    }

    private static final g3 h(Composer composer, int i) {
        composer.startReplaceGroup(-558659843);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-558659843, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.view.getTextStyle (LoadMoreFootView.kt:73)");
        }
        g3 g3Var = new g3(og4.a.a.h(composer, og4.a.b).h(), x.h(12), (c0) null, (y) null, (z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777212, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return g3Var;
    }

    public static final void d(final FootLoadingState state, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer startRestartGroup = composer.startRestartGroup(1096821780);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(state.ordinal())) {
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
                ComposerKt.traceEventStart(1096821780, i2, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.view.LoadMoreFootView (LoadMoreFootView.kt:27)");
            }
            final tl4.l lVar = (tl4.l) startRestartGroup.consume(ProfileTabPagerKt.E());
            startRestartGroup.startReplaceGroup(1778747179);
            if (state == FootLoadingState.GONE) {
                androidx.compose.foundation.layout.m.b(SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(6)), startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: sl4.q
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit e;
                            e = t.e(FootLoadingState.this, i, (Composer) obj, ((Integer) obj2).intValue());
                            return e;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.endReplaceGroup();
            Modifier.a aVar = Modifier.Companion;
            Modifier v = f2.v(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(38)), 0.0f, 0.0f, 0.0f, x0.i.g(18), 7, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i4 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, v);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a2 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a2);
            } else {
                startRestartGroup.useNode();
            }
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i4, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            if (state == FootLoadingState.LOADING) {
                startRestartGroup.startReplaceGroup(639960879);
                composer2 = startRestartGroup;
                a6.j("加载中...", (Modifier) null, 0L, 0L, (y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, h(startRestartGroup, 0), startRestartGroup, 6, 0, 65534);
                composer2.endReplaceGroup();
            } else if (state == FootLoadingState.ERROR) {
                startRestartGroup.startReplaceGroup(640078679);
                g3 h = h(startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changed = startRestartGroup.changed(lVar);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: sl4.r
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit f;
                            f = t.f(tl4.l.this);
                            return f;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                a6.j("加载失败，请点击重试...", ClickableKt.clickable-oSLSa3U$default(aVar, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), 0L, 0L, (y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, h, startRestartGroup, 6, 0, 65532);
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            } else if (state == FootLoadingState.NOT_MORE) {
                startRestartGroup.startReplaceGroup(640420268);
                p0 b3 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.i(), startRestartGroup, 54);
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, aVar);
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
                Composer b4 = g5.b(startRestartGroup);
                g5.e(b4, b3, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a3))) {
                    b4.updateRememberedValue(Integer.valueOf(a3));
                    b4.apply(Integer.valueOf(a3), b5);
                }
                g5.e(b4, e2, companion.d());
                w2 w2Var = w2.b;
                float f = (float) 0.5d;
                float f2 = 12;
                Modifier x = SizeKt.x(SizeKt.i(aVar, x0.i.g(f)), x0.i.g(f2));
                og4.a aVar3 = og4.a.a;
                int i5 = og4.a.b;
                a3.a(BackgroundKt.d(x, aVar3.h(startRestartGroup, i5).h(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
                a6.j("已显示全部内容", f2.t(aVar, x0.i.g(8), 0.0f, 2, (Object) null), 0L, 0L, (y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, h(startRestartGroup, 0), startRestartGroup, 54, 0, 65532);
                Modifier x2 = SizeKt.x(SizeKt.i(aVar, x0.i.g(f)), x0.i.g(f2));
                composer2 = startRestartGroup;
                a3.a(BackgroundKt.d(x2, aVar3.h(composer2, i5).h(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer2, 0);
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                composer2 = startRestartGroup;
                if (state == FootLoadingState.INIT) {
                    composer2.startReplaceGroup(641146536);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(641158068);
                    composer2.endReplaceGroup();
                }
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: sl4.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = t.g(FootLoadingState.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }
}
