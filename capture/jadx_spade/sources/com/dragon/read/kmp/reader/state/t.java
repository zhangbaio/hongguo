package com.dragon.read.kmp.reader.state;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.d0;
import androidx.compose.runtime.t2;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import com.dragon.read.kmp.reader.state.m;
import com.dragon.read.kmp.reader.state.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t {
    static {
        Covode.recordClassIndex(608584);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function2 function2, int i, Composer composer, int i2) {
        f(function2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final class b implements g3 {
        private final /* synthetic */ g3 a;
        private final long b = x0.l.b.b();

        public float a() {
            return this.a.a();
        }

        public long b() {
            return this.a.b();
        }

        public long c() {
            return this.a.c();
        }

        public long d() {
            return this.a.d();
        }

        public float e() {
            return this.a.e();
        }

        public float f() {
            return this.a.f();
        }

        public float g() {
            return this.a.g();
        }

        public float i() {
            return this.a.i();
        }

        public long h() {
            return this.b;
        }

        b(g3 g3Var) {
            this.a = g3Var;
        }
    }

    private static final d h(State<d> state) {
        return (d) state.getValue();
    }

    private static final f k(State<f> state) {
        return (f) state.getValue();
    }

    private static final c m(State<c> state) {
        return (c) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e n(m.a aVar) {
        return new e(aVar.d);
    }

    private static final e o(State<e> state) {
        return (e) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d g(b bVar) {
        return new d(om4.a.a(), k.a, l.a, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c l(m.a aVar) {
        return new c(aVar.b, aVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f j(m.a aVar) {
        int i = aVar.a;
        return new f(i, zl4.c.b(i), zl4.c.a(aVar.a));
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> a;

        a(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.a = function2;
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
                    ComposerKt.traceEventStart(-1839004166, i, -1, "com.dragon.read.kmp.reader.state.RSUiStyle.<anonymous> (ReaderUI.kt:100)");
                }
                this.a.invoke(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final void f(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        int i3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1674300742);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(content)) {
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
                ComposerKt.traceEventStart(-1674300742, i2, -1, "com.dragon.read.kmp.reader.state.RSUiStyle (ReaderUI.kt:51)");
            }
            n nVar = new n();
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                m mVar = (m) f2.d.c(Reflection.getOrCreateKotlinClass(m.class), c, (String) null, nVar, creationExtras, startRestartGroup, 0, 0);
                g3 g3Var = (g3) startRestartGroup.consume(CompositionLocalsKt.s());
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new b(g3Var);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final b bVar = (b) rememberedValue;
                startRestartGroup.endReplaceGroup();
                final m.a aVar = (m.a) mVar.b.getValue();
                int i4 = aVar.a;
                startRestartGroup.startReplaceGroup(5004770);
                boolean changed = startRestartGroup.changed(i4);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.reader.state.o
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            f j;
                            j = t.j(m.a.this);
                            return j;
                        }
                    });
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                State state = (State) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                int i5 = aVar.b;
                ReaderBgColorType readerBgColorType = aVar.c;
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changed2 = startRestartGroup.changed(i5) | startRestartGroup.changed(readerBgColorType.ordinal());
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.reader.state.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            c l;
                            l = t.l(m.a.this);
                            return l;
                        }
                    });
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                State state2 = (State) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                boolean z2 = aVar.d;
                startRestartGroup.startReplaceGroup(5004770);
                boolean changed3 = startRestartGroup.changed(z2);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed3 || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.reader.state.q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            e n;
                            n = t.n(m.a.this);
                            return n;
                        }
                    });
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                State state3 = (State) rememberedValue4;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.reader.state.r
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            d g;
                            g = t.g(t.b.this);
                            return g;
                        }
                    });
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                State state4 = (State) rememberedValue5;
                startRestartGroup.endReplaceGroup();
                d0.d(new t2[]{zl4.r.A().provides(Integer.valueOf(k(state).a)), zl4.r.w().provides(k(state).b), zl4.r.s().provides(k(state).c), zl4.r.t().provides(Integer.valueOf(m(state2).a)), zl4.r.u().provides(m(state2).b), zl4.r.z().provides(Boolean.valueOf(o(state3).a)), zl4.r.y().provides(Float.valueOf(h(state4).a)), IndicationKt.c().provides(h(state4).b), androidx.compose.material.ripple.r.c().provides(h(state4).c), CompositionLocalsKt.s().provides(h(state4).d)}, androidx.compose.runtime.internal.t.e(-1839004166, true, new a(content), startRestartGroup, 54), startRestartGroup, t2.i | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.state.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i6;
                    i6 = t.i(Function2.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return i6;
                }
            });
        }
    }
}
