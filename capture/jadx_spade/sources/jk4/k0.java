package jk4;

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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import c54.b4;
import c54.d4;
import c54.e4;
import c54.f4;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.compose.common.uicontext.appstyle.ThemeType;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import java.util.Collection;
import java.util.List;
import jk4.k0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import w0.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k0 {
    static {
        Covode.recordClassIndex(607878);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(z zVar, l lVar, int i, Composer composer, int i2) {
        z(zVar, lVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(z zVar, l lVar, int i, Composer composer, int i2) {
        z(zVar, lVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Modifier modifier, int i, Composer composer, int i2) {
        k(modifier, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(boolean z, int i, Composer composer, int i2) {
        m(z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(z zVar, boolean z, int i, Composer composer, int i2) {
        o(zVar, z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(z zVar, boolean z, int i, Composer composer, int i2) {
        u(zVar, z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(z zVar, l lVar, int i, Composer composer, int i2) {
        w(zVar, lVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(z zVar, l lVar, int i, Composer composer, int i2) {
        w(zVar, lVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private static final List<String> p(MutableState<List<String>> mutableState) {
        return (List) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void q(MutableState<List<String>> mutableState, List<String> list) {
        mutableState.setValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ z a;

        a(z zVar) {
            this.a = zVar;
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
                    ComposerKt.traceEventStart(-1294475200, i, -1, "com.dragon.read.kmp.nps.SeriesNpsKmpFullScreenCard.<anonymous> (SeriesNpsKmpCard.kt:81)");
                }
                Modifier.a aVar = Modifier.Companion;
                float f = 47;
                Modifier v = f2.v(SizeKt.f(aVar, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(32), x0.i.g(f), 0.0f, 8, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.e e = aVar2.e();
                z zVar = this.a;
                androidx.compose.ui.layout.p0 i2 = androidx.compose.foundation.layout.m.i(e, false);
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
                Composer b = g5.b(composer);
                g5.e(b, i2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                k0.u(zVar, false, composer, 48);
                k0.k(f2.v(boxScopeInstance.b(aVar, aVar2.b()), 0.0f, 0.0f, 0.0f, x0.i.g(21), 7, (Object) null), composer, 0);
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

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ l a;
        final /* synthetic */ MutableState<Boolean> b;
        final /* synthetic */ z c;

        b(l lVar, MutableState<Boolean> mutableState, z zVar) {
            this.a = lVar;
            this.b = mutableState;
            this.c = zVar;
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
                    ComposerKt.traceEventStart(2113158428, i, -1, "com.dragon.read.kmp.nps.SeriesNpsKmpHalfScreenCard.<anonymous> (SeriesNpsKmpCard.kt:65)");
                }
                Modifier h = SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changedInstance = composer.changedInstance(this.a);
                final l lVar = this.a;
                final MutableState<Boolean> mutableState = this.b;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: jk4.l0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit c;
                            c = k0.b.c(l.this, mutableState, (androidx.compose.ui.layout.w) obj);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                float f = 47;
                Modifier v = f2.v(androidx.compose.ui.layout.d1.a(h, (Function1) rememberedValue), x0.i.g(f), x0.i.g(32), x0.i.g(f), 0.0f, 8, (Object) null);
                androidx.compose.ui.e e = androidx.compose.ui.e.a.e();
                z zVar = this.c;
                androidx.compose.ui.layout.p0 i2 = androidx.compose.foundation.layout.m.i(e, false);
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
                Composer b = g5.b(composer);
                g5.e(b, i2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                k0.u(zVar, true, composer, 48);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(l lVar, MutableState mutableState, androidx.compose.ui.layout.w layoutCoordinates) {
            Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
            if (!k0.B(mutableState)) {
                lVar.a(layoutCoordinates);
                k0.C(mutableState, true);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(String str, z zVar, MutableState mutableState) {
        List plus;
        if (p(mutableState).contains(str)) {
            plus = CollectionsKt___CollectionsKt.minus(p(mutableState), str);
        } else if (zVar.c) {
            plus = CollectionsKt__CollectionsJVMKt.listOf(str);
        } else {
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends String>) p(mutableState), str);
        }
        q(mutableState, plus);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final Modifier modifier, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1977796301);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(modifier)) {
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
                ComposerKt.traceEventStart(1977796301, i2, -1, "com.dragon.read.kmp.nps.FlipUpContinueGuide (SeriesNpsKmpCard.kt:90)");
            }
            int i4 = (i2 & 14) >> 3;
            androidx.compose.ui.layout.p0 b2 = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.l(), startRestartGroup, (i4 & 112) | (i4 & 14));
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
            androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(b4.v(d4.a), startRestartGroup, 0), "flip_up_continue", SizeKt.s(Modifier.Companion, x0.i.g(16)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 432, 248);
            composer2 = startRestartGroup;
            a6.j(org.jetbrains.compose.resources.j.c(f4.i(e4.a), startRestartGroup, 0), (Modifier) null, og4.a.a.h(startRestartGroup, og4.a.b).G(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131026);
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
            endRestartGroup.a(new Function2() { // from class: jk4.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l;
                    l = k0.l(modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                    return l;
                }
            });
        }
    }

    private static final void m(final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        org.jetbrains.compose.resources.i q;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-163758147);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(z)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-163758147, i2, -1, "com.dragon.read.kmp.nps.NpsHeader (SeriesNpsKmpCard.kt:199)");
            }
            Modifier.a aVar = Modifier.Companion;
            float f = 6;
            Modifier a2 = androidx.compose.ui.draw.e.a(aVar, k.g.c(x0.i.g(f)));
            og4.a aVar2 = og4.a.a;
            int i4 = og4.a.b;
            Modifier d = BackgroundKt.d(a2, aVar2.h(startRestartGroup, i4).I(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            e.a aVar3 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, d);
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
            g5.e(b2, i5, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier s = f2.s(aVar, x0.i.g(f), x0.i.g(4));
            androidx.compose.ui.layout.p0 b4 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar3.i(), startRestartGroup, 48);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, s);
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
            e4 e4Var = e4.a;
            String c = org.jetbrains.compose.resources.j.c(f4.s(e4Var), startRestartGroup, 0);
            long F = aVar2.h(startRestartGroup, i4).F();
            long h = x0.x.h(12);
            c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
            a6.j(c, (Modifier) null, F, h, (androidx.compose.ui.text.font.y) null, aVar4.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 0, 131026);
            a3.a(SizeKt.x(aVar, x0.i.g(f)), startRestartGroup, 6);
            a3.a(BackgroundKt.d(SizeKt.u(aVar, x0.i.g(1), x0.i.g(10)), aVar2.h(startRestartGroup, i4).I(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
            a3.a(SizeKt.x(aVar, x0.i.g(f)), startRestartGroup, 6);
            if (z) {
                startRestartGroup.startReplaceGroup(1949829583);
                q = f4.A(e4Var);
            } else {
                startRestartGroup.startReplaceGroup(1949831054);
                q = f4.q(e4Var);
            }
            String c2 = org.jetbrains.compose.resources.j.c(q, startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            a6.j(c2, (Modifier) null, aVar2.h(startRestartGroup, i4).F(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, aVar4.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131026);
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
            endRestartGroup.a(new Function2() { // from class: jk4.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n;
                    n = k0.n(z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return n;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(q0 q0Var, z zVar, String str, MutableState mutableState) {
        if (((Boolean) q0Var.b.getValue()).booleanValue()) {
            return Unit.INSTANCE;
        }
        if (!p(mutableState).isEmpty()) {
            q0Var.I0(p(mutableState), zVar);
        } else {
            ig4.g.b(str, (ToastDuration) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    public static final void w(final z zVar, final l iDepend, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        Composer startRestartGroup = composer.startRestartGroup(-246415599);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(zVar)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(iDepend);
            } else {
                changedInstance = startRestartGroup.changedInstance(iDepend);
            }
            if (changedInstance) {
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
                ComposerKt.traceEventStart(-246415599, i2, -1, "com.dragon.read.kmp.nps.SeriesNpsKmpFullScreenCard (SeriesNpsKmpCard.kt:77)");
            }
            if (zVar == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: jk4.a0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit x;
                            x = k0.x(z.this, iDepend, i, (Composer) obj, ((Integer) obj2).intValue());
                            return x;
                        }
                    });
                    return;
                }
                return;
            }
            r0 r0Var = new r0(iDepend);
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                pg4.p.f(new pg4.i((pg4.a) null, ThemeType.SPECIFIC, (Theme) null, 5, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(-1294475200, true, new a(zVar), startRestartGroup, 54), startRestartGroup, 48, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: jk4.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit y;
                    y = k0.y(z.this, iDepend, i, (Composer) obj, ((Integer) obj2).intValue());
                    return y;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(final z zVar, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        e.b k;
        int f;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(1303762595);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(zVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i2 & 19) != 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1303762595, i2, -1, "com.dragon.read.kmp.nps.SeriesNpsKmpCard (SeriesNpsKmpCard.kt:109)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            if (z) {
                k = aVar2.g();
            } else {
                k = aVar2.k();
            }
            androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), k, startRestartGroup, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, h);
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
            m(zVar.c, startRestartGroup, 0);
            a3.a(SizeKt.i(aVar, x0.i.g(12)), startRestartGroup, 6);
            String str = zVar.b;
            Modifier h2 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            h.a aVar3 = w0.h.b;
            if (z) {
                f = aVar3.a();
            } else {
                f = aVar3.f();
            }
            int i6 = f;
            if (z) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            int i7 = i2;
            a6.j(str, h2, androidx.compose.ui.graphics.l0.b.i(), x0.x.h(18), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(i6), 0L, w0.s.b.b(), false, i3, 0, (Function1) null, (g3) null, startRestartGroup, 200112, 48, 120272);
            startRestartGroup = startRestartGroup;
            a3.a(SizeKt.i(aVar, x0.i.g(20)), startRestartGroup, 6);
            o(zVar, z, startRestartGroup, (i7 & 14) | (i7 & 112));
            startRestartGroup.startReplaceGroup(-2015384688);
            if (z) {
                a3.a(SizeKt.i(aVar, x0.i.g(32)), startRestartGroup, 6);
                k(f2.v(c0Var.b(aVar, androidx.compose.ui.e.a.g()), 0.0f, 0.0f, 0.0f, x0.i.g(21), 7, (Object) null), startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: jk4.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit v;
                    v = k0.v(z.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return v;
                }
            });
        }
    }

    public static final void z(final z zVar, final l iDepend, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        Composer startRestartGroup = composer.startRestartGroup(-1133749267);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(zVar)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(iDepend);
            } else {
                changedInstance = startRestartGroup.changedInstance(iDepend);
            }
            if (changedInstance) {
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
                ComposerKt.traceEventStart(-1133749267, i2, -1, "com.dragon.read.kmp.nps.SeriesNpsKmpHalfScreenCard (SeriesNpsKmpCard.kt:60)");
            }
            if (zVar == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: jk4.c0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit A;
                            A = k0.A(z.this, iDepend, i, (Composer) obj, ((Integer) obj2).intValue());
                            return A;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            r0 r0Var = new r0(iDepend);
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                pg4.p.f(new pg4.i((pg4.a) null, ThemeType.SPECIFIC, (Theme) null, 5, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(2113158428, true, new b(iDepend, mutableState, zVar), startRestartGroup, 54), startRestartGroup, 48, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: jk4.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit D;
                    D = k0.D(z.this, iDepend, i, (Composer) obj, ((Integer) obj2).intValue());
                    return D;
                }
            });
        }
    }

    private static final void o(final z zVar, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        CreationExtras creationExtras;
        float f;
        List listOf;
        q0 q0Var;
        Composer composer3;
        long T0;
        int i3;
        org.jetbrains.compose.resources.b J;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-5642253);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(zVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        int i6 = 18;
        if ((i2 & 19) != 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-5642253, i2, -1, "com.dragon.read.kmp.nps.NpsSelectedItems (SeriesNpsKmpCard.kt:133)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                CreationExtras creationExtras2 = creationExtras;
                int i7 = 0;
                int i8 = 1;
                q0 q0Var2 = (q0) f2.d.c(Reflection.getOrCreateKotlinClass(q0.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras2, startRestartGroup, 0, 0);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Object obj = null;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default(CollectionsKt__CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1127228749);
                for (final String str : zVar.d) {
                    Modifier.a aVar = Modifier.Companion;
                    float f2 = 12;
                    Modifier a2 = androidx.compose.ui.draw.e.a(SizeKt.h(aVar, 0.0f, i8, obj), k.g.c(x0.i.g(f2)));
                    if (p(mutableState).contains(str)) {
                        startRestartGroup.startReplaceGroup(-520892783);
                        T0 = og4.a.a.h(startRestartGroup, og4.a.b).C3();
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-520890318);
                        T0 = og4.a.a.h(startRestartGroup, og4.a.b).T0();
                        startRestartGroup.endReplaceGroup();
                    }
                    Modifier d = BackgroundKt.d(a2, T0, (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                    startRestartGroup.startReplaceGroup(-1746271574);
                    boolean changed = startRestartGroup.changed(str) | startRestartGroup.changedInstance(zVar);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: jk4.g0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit r;
                                r = k0.r(str, zVar, mutableState);
                                return r;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null);
                    androidx.compose.ui.layout.p0 b2 = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), startRestartGroup, 48);
                    int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, i7));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
                    Composer b3 = g5.b(startRestartGroup);
                    g5.e(b3, b2, companion.c());
                    g5.e(b3, currentCompositionLocalMap, companion.e());
                    Function2 b4 = companion.b();
                    if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                        b3.updateRememberedValue(Integer.valueOf(a3));
                        b3.apply(Integer.valueOf(a3), b4);
                    }
                    g5.e(b3, e, companion.d());
                    w2 w2Var = w2.b;
                    a3.a(SizeKt.x(aVar, x0.i.g(i6)), startRestartGroup, 6);
                    if (p(mutableState).contains(str)) {
                        startRestartGroup.startReplaceGroup(88089876);
                        J = b4.I(d4.a);
                        i3 = 0;
                    } else {
                        i3 = 0;
                        startRestartGroup.startReplaceGroup(88091548);
                        J = b4.J(d4.a);
                    }
                    androidx.compose.ui.graphics.e1 a5 = org.jetbrains.compose.resources.c.a(J, startRestartGroup, i3);
                    startRestartGroup.endReplaceGroup();
                    androidx.compose.foundation.z0.g(a5, "icon_checked", SizeKt.s(aVar, x0.i.g(16)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 432, 248);
                    a3.a(SizeKt.x(aVar, x0.i.g(8)), startRestartGroup, 6);
                    Composer composer4 = startRestartGroup;
                    a6.j(str, f2.t(aVar, 0.0f, x0.i.g(14), 1, (Object) null), androidx.compose.ui.graphics.l0.b.i(), x0.x.h(15), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer4, 200112, 0, 131024);
                    composer4.endNode();
                    startRestartGroup = composer4;
                    a3.a(SizeKt.i(aVar, x0.i.g(f2)), startRestartGroup, 6);
                    mutableState = mutableState;
                    q0Var2 = q0Var2;
                    i8 = 1;
                    obj = null;
                    i6 = 18;
                    i7 = 0;
                }
                final MutableState mutableState2 = mutableState;
                final q0 q0Var3 = q0Var2;
                startRestartGroup.endReplaceGroup();
                Modifier.a aVar2 = Modifier.Companion;
                a3.a(SizeKt.i(aVar2, x0.i.g(z ? 12 : 28)), startRestartGroup, 0);
                e4 e4Var = e4.a;
                final String c2 = org.jetbrains.compose.resources.j.c(f4.t(e4Var), startRestartGroup, 0);
                Modifier a6 = androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.h(aVar2, 0.0f, 1, (Object) null), x0.i.g(44)), k.g.c(x0.i.g(12)));
                if (!p(mutableState2).isEmpty()) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                Modifier a7 = androidx.compose.ui.draw.a.a(a6, f);
                c0.a aVar3 = androidx.compose.ui.graphics.c0.b;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.n0.d(4294934029L)), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.n0.d(4294939187L))});
                Modifier b5 = BackgroundKt.b(a7, c0.a.p(aVar3, listOf, 0.0f, 0.0f, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null);
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changedInstance = startRestartGroup.changedInstance(q0Var3) | startRestartGroup.changedInstance(zVar) | startRestartGroup.changed(c2);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: jk4.h0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit s;
                            s = k0.s(q0.this, zVar, c2, mutableState2);
                            return s;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(b5, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null);
                androidx.compose.ui.layout.p0 i9 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
                int a8 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier2);
                ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                Function0 a9 = companion2.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a9);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b6 = g5.b(startRestartGroup);
                g5.e(b6, i9, companion2.c());
                g5.e(b6, currentCompositionLocalMap2, companion2.e());
                Function2 b7 = companion2.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a8))) {
                    b6.updateRememberedValue(Integer.valueOf(a8));
                    b6.apply(Integer.valueOf(a8), b7);
                }
                g5.e(b6, e2, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                startRestartGroup.startReplaceGroup(-718724432);
                if (!((Boolean) q0Var3.b.getValue()).booleanValue()) {
                    q0Var = q0Var3;
                    composer3 = startRestartGroup;
                    a6.j(org.jetbrains.compose.resources.j.c(f4.r(e4Var), startRestartGroup, 0), (Modifier) null, androidx.compose.ui.graphics.l0.b.i(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer3, 200064, 0, 131026);
                } else {
                    q0Var = q0Var3;
                    composer3 = startRestartGroup;
                }
                composer3.endReplaceGroup();
                composer2 = composer3;
                com.dragon.read.kmp.widget.m1.c(SizeKt.s(aVar2, x0.i.g(16)), ((Boolean) q0Var.b.getValue()).booleanValue(), composer2, 6, 0);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: jk4.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit t;
                    t = k0.t(z.this, z, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return t;
                }
            });
        }
    }
}
