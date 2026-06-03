package jk4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e1 {
    static {
        Covode.recordClassIndex(607885);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(int i, Composer composer, int i2) {
        j(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(int i, Composer composer, int i2) {
        n(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(t0 t0Var, u0 u0Var, q1 q1Var, int i, int i2, Composer composer, int i3) {
        r(t0Var, u0Var, q1Var, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(f1 f1Var, m mVar, q1 q1Var, int i, int i2, Composer composer, int i3) {
        v(f1Var, mVar, q1Var, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f1 k(State<f1> state) {
        return (f1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m l(State<m> state) {
        return (m) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f1 o(State<f1> state) {
        return (f1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m p(State<m> state) {
        return (m) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(q1 q1Var) {
        q1Var.S0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(q1 q1Var) {
        q1Var.M0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(q1 q1Var) {
        q1Var.S0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(q1 q1Var) {
        q1Var.R0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(q1 q1Var, t0 t0Var) {
        q1Var.T0(t0Var);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ y a;
        final /* synthetic */ State<f1> b;
        final /* synthetic */ State<m> c;

        a(y yVar, State<f1> state, State<m> state2) {
            this.a = yVar;
            this.b = state;
            this.c = state2;
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
                    ComposerKt.traceEventStart(-694571991, i, -1, "com.dragon.read.kmp.nps.SeriesDetailNpsCard.<anonymous> (SimilarNpsCard.kt:58)");
                }
                e1.v(e1.k(this.b), e1.l(this.c), this.a, composer, 0, 0);
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
        final /* synthetic */ State<f1> a;
        final /* synthetic */ State<m> b;

        b(State<f1> state, State<m> state2) {
            this.a = state;
            this.b = state2;
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
                    ComposerKt.traceEventStart(1099393998, i, -1, "com.dragon.read.kmp.nps.SimilarNpsCard.<anonymous> (SimilarNpsCard.kt:48)");
                }
                e1.v(e1.o(this.a), e1.p(this.b), null, composer, 0, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final void j(Composer composer, final int i) {
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(1533536568);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1533536568, i, -1, "com.dragon.read.kmp.nps.SeriesDetailNpsCard (SimilarNpsCard.kt:53)");
            }
            y b2 = f2.d.b(y.class, (ViewModelStoreOwner) null, (String) null, (ViewModelProvider.Factory) null, (CreationExtras) null, startRestartGroup, 0, 30);
            pg4.p.e(new pg4.h((pg4.t) null, (pg4.t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(-694571991, true, new a(b2, FlowExtKt.b(b2.I0(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7), FlowExtKt.b(b2.h, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7)), startRestartGroup, 54), startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: jk4.d1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m;
                    m = e1.m(i, (Composer) obj, ((Integer) obj2).intValue());
                    return m;
                }
            });
        }
    }

    public static final void n(Composer composer, final int i) {
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(-748879521);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-748879521, i, -1, "com.dragon.read.kmp.nps.SimilarNpsCard (SimilarNpsCard.kt:43)");
            }
            q1 b2 = f2.d.b(q1.class, (ViewModelStoreOwner) null, (String) null, (ViewModelProvider.Factory) null, (CreationExtras) null, startRestartGroup, 0, 30);
            pg4.p.e(new pg4.h((pg4.t) null, (pg4.t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(1099393998, true, new b(FlowExtKt.b(b2.I0(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7), FlowExtKt.b(b2.h, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7)), startRestartGroup, 54), startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: jk4.v0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit q;
                    q = e1.q(i, (Composer) obj, ((Integer) obj2).intValue());
                    return q;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void r(final jk4.t0 r44, final jk4.u0 r45, jk4.q1 r46, androidx.compose.runtime.Composer r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 734
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jk4.e1.r(jk4.t0, jk4.u0, jk4.q1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void v(final jk4.f1 r31, final jk4.m r32, jk4.q1 r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 820
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jk4.e1.v(jk4.f1, jk4.m, jk4.q1, androidx.compose.runtime.Composer, int, int):void");
    }
}
