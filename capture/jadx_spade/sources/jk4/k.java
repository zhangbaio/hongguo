package jk4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
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
import androidx.compose.ui.platform.CompositionLocalsKt;
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
import com.dragon.read.kmp.base.ui.util.ScreenUtils;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.compose.common.uicontext.appstyle.ThemeType;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.ss.ttm.player.MediaPlayer;
import java.util.Collection;
import java.util.List;
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
import kotlin.math.MathKt__MathJVMKt;
import w0.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k {
    static {
        Covode.recordClassIndex(607869);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Modifier modifier, int i, Composer composer, int i2) {
        i(modifier, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(z zVar, l lVar, int i, Composer composer, int i2) {
        k(zVar, lVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(z zVar, l lVar, int i, Composer composer, int i2) {
        k(zVar, lVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(boolean z, int i, Composer composer, int i2) {
        n(z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(z zVar, boolean z, int i, int i2, Composer composer, int i3) {
        p(zVar, z, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(z zVar, boolean z, int i, int i2, Composer composer, int i3) {
        v(zVar, z, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    private static final List<String> u(MutableState<List<String>> mutableState) {
        return (List) mutableState.getValue();
    }

    private static final void q(MutableState<List<String>> mutableState, List<String> list) {
        mutableState.setValue(list);
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ z a;
        final /* synthetic */ int b;

        a(z zVar, int i) {
            this.a = zVar;
            this.b = i;
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
                    ComposerKt.traceEventStart(-490452092, i, -1, "com.dragon.read.kmp.nps.FqSeriesNpsKmpFullScreenCard.<anonymous> (FqSeriesNspKmpCard.kt:66)");
                }
                Modifier.a aVar = Modifier.Companion;
                float f = 47;
                Modifier v = f2.v(SizeKt.f(aVar, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(32), x0.i.g(f), 0.0f, 8, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.e e = aVar2.e();
                z zVar = this.a;
                int i2 = this.b;
                androidx.compose.ui.layout.p0 i3 = androidx.compose.foundation.layout.m.i(e, false);
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
                g5.e(b, i3, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                k.v(zVar, false, i2, composer, 48);
                k.i(f2.v(boxScopeInstance.b(aVar, aVar2.b()), 0.0f, 0.0f, 0.0f, x0.i.g(21), 7, (Object) null), composer, 0);
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
    public static final Unit r(String str, z zVar, MutableState mutableState) {
        List plus;
        if (u(mutableState).contains(str)) {
            plus = CollectionsKt___CollectionsKt.minus(u(mutableState), str);
        } else if (zVar.c) {
            plus = CollectionsKt__CollectionsJVMKt.listOf(str);
        } else {
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends String>) u(mutableState), str);
        }
        q(mutableState, plus);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final Modifier modifier, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1541985956);
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
                ComposerKt.traceEventStart(-1541985956, i2, -1, "com.dragon.read.kmp.nps.FlipUpContinueGuide (FqSeriesNspKmpCard.kt:247)");
            }
            int i4 = (i2 & 14) >> 3;
            androidx.compose.ui.layout.p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.l(), startRestartGroup, (i4 & 112) | (i4 & 14));
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, b, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
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
            endRestartGroup.a(new Function2() { // from class: jk4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j;
                    j = k.j(modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                    return j;
                }
            });
        }
    }

    private static final void n(final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        String c;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(2008491596);
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
                ComposerKt.traceEventStart(2008491596, i2, -1, "com.dragon.read.kmp.nps.NpsHeader (FqSeriesNspKmpCard.kt:114)");
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
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i5, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                b.updateRememberedValue(Integer.valueOf(a3));
                b.apply(Integer.valueOf(a3), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier s = f2.s(aVar, x0.i.g(f), x0.i.g(4));
            androidx.compose.ui.layout.p0 b3 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar3.i(), startRestartGroup, 48);
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
            Composer b4 = g5.b(startRestartGroup);
            g5.e(b4, b3, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                b4.updateRememberedValue(Integer.valueOf(a5));
                b4.apply(Integer.valueOf(a5), b5);
            }
            g5.e(b4, e2, companion.d());
            w2 w2Var = w2.b;
            e4 e4Var = e4.a;
            String c2 = org.jetbrains.compose.resources.j.c(f4.s(e4Var), startRestartGroup, 0);
            long F = aVar2.h(startRestartGroup, i4).F();
            long h = x0.x.h(12);
            c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
            a6.j(c2, (Modifier) null, F, h, (androidx.compose.ui.text.font.y) null, aVar4.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 0, 131026);
            a3.a(SizeKt.x(aVar, x0.i.g(f)), startRestartGroup, 6);
            a3.a(BackgroundKt.d(SizeKt.u(aVar, x0.i.g(1), x0.i.g(10)), aVar2.h(startRestartGroup, i4).I(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
            a3.a(SizeKt.x(aVar, x0.i.g(f)), startRestartGroup, 6);
            if (z) {
                startRestartGroup.startReplaceGroup(-1712054818);
                c = org.jetbrains.compose.resources.j.c(f4.A(e4Var), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1712052195);
                c = org.jetbrains.compose.resources.j.c(f4.q(e4Var), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            }
            composer2 = startRestartGroup;
            a6.j(c, (Modifier) null, aVar2.h(startRestartGroup, i4).F(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, aVar4.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131026);
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
            endRestartGroup.a(new Function2() { // from class: jk4.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = k.o(z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(q0 q0Var, z zVar, String str, MutableState mutableState) {
        if (((Boolean) q0Var.b.getValue()).booleanValue()) {
            return Unit.INSTANCE;
        }
        if (!u(mutableState).isEmpty()) {
            q0Var.I0(u(mutableState), zVar);
        } else {
            ig4.g.b(str, (ToastDuration) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    public static final void k(final z zVar, final l iDepend, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        int roundToInt;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        Composer startRestartGroup = composer.startRestartGroup(-679568939);
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
                ComposerKt.traceEventStart(-679568939, i2, -1, "com.dragon.read.kmp.nps.FqSeriesNpsKmpFullScreenCard (FqSeriesNspKmpCard.kt:58)");
            }
            if (zVar == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: jk4.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit l;
                            l = k.l(z.this, iDepend, i, (Composer) obj, ((Integer) obj2).intValue());
                            return l;
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
                startRestartGroup.startReplaceGroup(-230711862);
                roundToInt = MathKt__MathJVMKt.roundToInt(((x0.e) startRestartGroup.consume(CompositionLocalsKt.f())).v1(ScreenUtils.a.f(ig4.f.a(startRestartGroup, 0))));
                startRestartGroup.endReplaceGroup();
                pg4.p.f(new pg4.i((pg4.a) null, ThemeType.SPECIFIC, (Theme) null, 5, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(-490452092, true, new a(zVar, roundToInt), startRestartGroup, 54), startRestartGroup, 48, 0);
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
            endRestartGroup2.a(new Function2() { // from class: jk4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m;
                    m = k.m(z.this, iDepend, i, (Composer) obj, ((Integer) obj2).intValue());
                    return m;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final z zVar, final boolean z, final int i, Composer composer, final int i2) {
        int i3;
        boolean z2;
        e.b k;
        int f;
        int i4;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(670016085);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(zVar)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i3 = i7 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i3 |= i6;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(i)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(670016085, i3, -1, "com.dragon.read.kmp.nps.SeriesNpsKmpCard (FqSeriesNspKmpCard.kt:83)");
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
            Composer b = g5.b(startRestartGroup);
            g5.e(b, a2, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                b.updateRememberedValue(Integer.valueOf(a3));
                b.apply(Integer.valueOf(a3), b2);
            }
            g5.e(b, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            n(zVar.c, startRestartGroup, 0);
            a3.a(SizeKt.i(aVar, x0.i.g(12)), startRestartGroup, 6);
            String str = zVar.b;
            Modifier h2 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            h.a aVar3 = w0.h.b;
            if (z) {
                f = aVar3.a();
            } else {
                f = aVar3.f();
            }
            int i8 = f;
            if (!z && i >= 800) {
                i4 = 3;
            } else {
                i4 = 2;
            }
            int i9 = i3;
            a6.j(str, h2, androidx.compose.ui.graphics.l0.b.i(), x0.x.h(20), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(i8), 0L, w0.s.b.b(), false, i4, 0, (Function1) null, (g3) null, startRestartGroup, 200112, 48, 120272);
            startRestartGroup = startRestartGroup;
            a3.a(SizeKt.i(aVar, x0.i.g(20)), startRestartGroup, 6);
            p(zVar, z, i, startRestartGroup, (i9 & 896) | (i9 & 14) | (i9 & 112));
            startRestartGroup.startReplaceGroup(2146146058);
            if (z) {
                a3.a(SizeKt.i(aVar, x0.i.g(32)), startRestartGroup, 6);
                i(f2.v(c0Var.b(aVar, androidx.compose.ui.e.a.g()), 0.0f, 0.0f, 0.0f, x0.i.g(21), 7, (Object) null), startRestartGroup, 0);
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
            endRestartGroup.a(new Function2() { // from class: jk4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit w;
                    w = k.w(z.this, z, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return w;
                }
            });
        }
    }

    private static final void p(final z zVar, final boolean z, final int i, Composer composer, final int i2) {
        int i3;
        boolean z2;
        Composer composer2;
        CreationExtras creationExtras;
        float f;
        List listOf;
        q0 q0Var;
        Modifier modifier;
        Composer composer3;
        String str;
        long T0;
        long i4;
        androidx.compose.ui.graphics.e1 a2;
        Modifier modifier2;
        Composer composer4;
        float g;
        Modifier modifier3;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(1690662821);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(zVar)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i3 = i7 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i3 |= i6;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(i)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1690662821, i3, -1, "com.dragon.read.kmp.nps.NpsSelectedItems (FqSeriesNspKmpCard.kt:151)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                CreationExtras creationExtras2 = creationExtras;
                int i8 = 0;
                int i9 = 1;
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
                startRestartGroup.startReplaceGroup(1229343414);
                for (final String str2 : zVar.d) {
                    Modifier modifier4 = Modifier.Companion;
                    float f2 = 8;
                    Modifier a3 = androidx.compose.ui.draw.e.a(SizeKt.h(modifier4, 0.0f, i9, obj), k.g.c(x0.i.g(f2)));
                    if (u(mutableState).contains(str2)) {
                        startRestartGroup.startReplaceGroup(1845574915);
                        T0 = og4.a.a.h(startRestartGroup, og4.a.b).k0();
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(1845577636);
                        T0 = og4.a.a.h(startRestartGroup, og4.a.b).T0();
                        startRestartGroup.endReplaceGroup();
                    }
                    Modifier d = BackgroundKt.d(a3, T0, (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                    startRestartGroup.startReplaceGroup(-1746271574);
                    boolean changed = startRestartGroup.changed(str2) | startRestartGroup.changedInstance(zVar);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: jk4.g
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit r;
                                r = k.r(str2, zVar, mutableState);
                                return r;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier modifier5 = ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null);
                    androidx.compose.ui.layout.p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), startRestartGroup, 48);
                    int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, i8));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(startRestartGroup, modifier5);
                    ComposeUiNode.Companion companion = ComposeUiNode.o0;
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
                    Composer b2 = g5.b(startRestartGroup);
                    g5.e(b2, b, companion.c());
                    g5.e(b2, currentCompositionLocalMap, companion.e());
                    Function2 b3 = companion.b();
                    if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a4))) {
                        b2.updateRememberedValue(Integer.valueOf(a4));
                        b2.apply(Integer.valueOf(a4), b3);
                    }
                    g5.e(b2, e, companion.d());
                    w2 w2Var = w2.b;
                    float f3 = 18;
                    a3.a(SizeKt.x(modifier4, x0.i.g(f3)), startRestartGroup, 6);
                    Modifier a6 = u2.a(w2Var, f2.t(modifier4, 0.0f, x0.i.g(14), 1, (Object) null), 1.0f, false, 2, (Object) null);
                    startRestartGroup.startReplaceGroup(1127841548);
                    if (u(mutableState).contains(str2)) {
                        i4 = og4.a.a.h(startRestartGroup, og4.a.b).c();
                    } else {
                        i4 = androidx.compose.ui.graphics.l0.b.i();
                    }
                    startRestartGroup.endReplaceGroup();
                    Composer composer5 = startRestartGroup;
                    MutableState mutableState2 = mutableState;
                    q0 q0Var3 = q0Var2;
                    a6.j(str2, a6, i4, x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer5, 199680, 0, 131024);
                    if (zVar.c) {
                        composer5.startReplaceGroup(603575643);
                        if (u(mutableState2).contains(str2)) {
                            modifier3 = modifier4;
                            composer4 = composer5;
                            androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(b4.x(d4.a), composer5, 0), "icon_checked", SizeKt.s(modifier4, x0.i.g(16)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, composer5, 432, 248);
                        } else {
                            composer4 = composer5;
                            modifier3 = modifier4;
                        }
                        composer4.endReplaceGroup();
                        modifier2 = modifier3;
                    } else {
                        composer5.startReplaceGroup(603915899);
                        if (u(mutableState2).contains(str2)) {
                            composer5.startReplaceGroup(603992841);
                            a2 = org.jetbrains.compose.resources.c.a(b4.x(d4.a), composer5, 0);
                            composer5.endReplaceGroup();
                        } else {
                            composer5.startReplaceGroup(604094087);
                            a2 = org.jetbrains.compose.resources.c.a(b4.y(d4.a), composer5, 0);
                            composer5.endReplaceGroup();
                        }
                        modifier2 = modifier4;
                        composer4 = composer5;
                        androidx.compose.foundation.z0.g(a2, "icon_checked", SizeKt.s(modifier4, x0.i.g(16)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, composer5, 432, 248);
                        composer4.endReplaceGroup();
                    }
                    Modifier modifier6 = modifier2;
                    startRestartGroup = composer4;
                    a3.a(SizeKt.x(modifier6, x0.i.g(f3)), startRestartGroup, 6);
                    startRestartGroup.endNode();
                    if (i < 800) {
                        g = x0.i.g(f2);
                    } else {
                        g = x0.i.g(12);
                    }
                    a3.a(SizeKt.i(modifier6, g), startRestartGroup, 0);
                    mutableState = mutableState2;
                    q0Var2 = q0Var3;
                    i9 = 1;
                    obj = null;
                    i8 = 0;
                }
                final MutableState mutableState3 = mutableState;
                final q0 q0Var4 = q0Var2;
                int i10 = 12;
                startRestartGroup.endReplaceGroup();
                Modifier modifier7 = Modifier.Companion;
                if (!z) {
                    i10 = 28;
                }
                a3.a(SizeKt.i(modifier7, x0.i.g(i10)), startRestartGroup, 0);
                e4 e4Var = e4.a;
                final String c2 = org.jetbrains.compose.resources.j.c(f4.t(e4Var), startRestartGroup, 0);
                Modifier a7 = androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.h(modifier7, 0.0f, 1, (Object) null), x0.i.g(44)), k.g.c(x0.i.g(22)));
                if (!u(mutableState3).isEmpty()) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                Modifier a8 = androidx.compose.ui.draw.a.a(a7, f);
                c0.a aVar = androidx.compose.ui.graphics.c0.b;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.n0.d(4294938706L)), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.n0.d(4294600485L))});
                Modifier b4 = BackgroundKt.b(a8, c0.a.p(aVar, listOf, 0.0f, 0.0f, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null);
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changedInstance = startRestartGroup.changedInstance(q0Var4) | startRestartGroup.changedInstance(zVar) | startRestartGroup.changed(c2);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: jk4.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit s;
                            s = k.s(q0.this, zVar, c2, mutableState3);
                            return s;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier8 = ClickableKt.clickable-oSLSa3U$default(b4, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null);
                androidx.compose.ui.layout.p0 i11 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
                int a9 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier8);
                ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
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
                Composer b5 = g5.b(startRestartGroup);
                g5.e(b5, i11, companion2.c());
                g5.e(b5, currentCompositionLocalMap2, companion2.e());
                Function2 b6 = companion2.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a9))) {
                    b5.updateRememberedValue(Integer.valueOf(a9));
                    b5.apply(Integer.valueOf(a9), b6);
                }
                g5.e(b5, e2, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                startRestartGroup.startReplaceGroup(1700149885);
                if (!((Boolean) q0Var4.b.getValue()).booleanValue()) {
                    String str3 = zVar.e;
                    startRestartGroup.startReplaceGroup(1700152255);
                    if (str3 == null) {
                        str = org.jetbrains.compose.resources.j.c(f4.m(e4Var), startRestartGroup, 0);
                    } else {
                        str = str3;
                    }
                    startRestartGroup.endReplaceGroup();
                    q0Var = q0Var4;
                    modifier = modifier7;
                    composer3 = startRestartGroup;
                    a6.j(str, (Modifier) null, androidx.compose.ui.graphics.l0.b.i(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer3, 200064, 0, 131026);
                } else {
                    q0Var = q0Var4;
                    modifier = modifier7;
                    composer3 = startRestartGroup;
                }
                composer3.endReplaceGroup();
                composer2 = composer3;
                com.dragon.read.kmp.widget.m1.c(SizeKt.s(modifier, x0.i.g(16)), ((Boolean) q0Var.b.getValue()).booleanValue(), composer2, 6, 0);
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
            endRestartGroup.a(new Function2() { // from class: jk4.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit t;
                    t = k.t(z.this, z, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    return t;
                }
            });
        }
    }
}
