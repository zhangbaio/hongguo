package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l2 {
    private static final Lazy a;
    private static final Lazy b;
    private static final Lazy c;
    private static final h0 d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(659571);
            int[] iArr = new int[WhenToOutput.values().length];
            try {
                iArr[WhenToOutput.NEVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WhenToOutput.IF_NONZERO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WhenToOutput.ALWAYS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p1 E() {
        return p1.b.a(new Function1() { // from class: kotlinx.datetime.format.f2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F;
                F = l2.F((y.e) obj);
                return F;
            }
        });
    }

    public static final p1 L() {
        return (p1) c.getValue();
    }

    public static final p1 M() {
        return (p1) a.getValue();
    }

    public static final p1 N() {
        return (p1) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p1 v() {
        return p1.b.a(new Function1() { // from class: kotlinx.datetime.format.g2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit w;
                w = l2.w((y.e) obj);
                return w;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p1 x() {
        return p1.b.a(new Function1() { // from class: kotlinx.datetime.format.e2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y;
                y = l2.y((y.e) obj);
                return y;
            }
        });
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Covode.recordClassIndex(659570);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: kotlinx.datetime.format.q1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                p1 E;
                E = l2.E();
                return E;
            }
        });
        a = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: kotlinx.datetime.format.b2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                p1 x;
                x = l2.x();
                return x;
            }
        });
        b = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: kotlinx.datetime.format.d2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                p1 v;
                v = l2.v();
                return v;
            }
        });
        c = lazy3;
        d = new h0(null, null, null, null, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(y.e optional) {
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        y.e.a.c(optional, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(y.e alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        alternativeParsing.q("z");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(y.e alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        z.b(alternativeParsing, 'z');
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(y.e build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        y.e.a.a(build, null, 1, null);
        y.e.a.b(build, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(y.e alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        alternativeParsing.q("z");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(y.e alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        z.c(alternativeParsing, "Z", new Function1() { // from class: kotlinx.datetime.format.t1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit B;
                B = l2.B((y.e) obj);
                return B;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(y.e optional) {
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        y.e.a.a(optional, null, 1, null);
        z.d(optional, null, new Function1() { // from class: kotlinx.datetime.format.u1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit C;
                C = l2.C((y.e) obj);
                return C;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(y.e optional) {
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        y.e.a.b(optional, null, 1, null);
        z.d(optional, null, new Function1() { // from class: kotlinx.datetime.format.a2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit D;
                D = l2.D((y.e) obj);
                return D;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(y.e build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        z.a(build, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.h2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit J;
                J = l2.J((y.e) obj);
                return J;
            }
        }}, new Function1() { // from class: kotlinx.datetime.format.i2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G;
                G = l2.G((y.e) obj);
                return G;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(y.e alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        z.c(alternativeParsing, "Z", new Function1() { // from class: kotlinx.datetime.format.s1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit H;
                H = l2.H((y.e) obj);
                return H;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(y.e optional) {
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        y.e.a.a(optional, null, 1, null);
        z.b(optional, ':');
        y.e.a.b(optional, null, 1, null);
        z.d(optional, null, new Function1() { // from class: kotlinx.datetime.format.y1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I;
                I = l2.I((y.e) obj);
                return I;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(y.e optional) {
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        z.b(optional, ':');
        y.e.a.c(optional, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(y.e build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        z.a(build, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.j2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit z;
                z = l2.z((y.e) obj);
                return z;
            }
        }}, new Function1() { // from class: kotlinx.datetime.format.k2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit A;
                A = l2.A((y.e) obj);
                return A;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(Function1 format, y optional) {
        Intrinsics.checkNotNullParameter(format, "$format");
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        format.invoke(optional);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(boolean z, y.e outputIfNeeded) {
        Intrinsics.checkNotNullParameter(outputIfNeeded, "$this$outputIfNeeded");
        if (z) {
            z.b(outputIfNeeded, ':');
        }
        y.e.a.c(outputIfNeeded, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(final boolean z, WhenToOutput outputSecond, y.e outputIfNeeded) {
        Intrinsics.checkNotNullParameter(outputSecond, "$outputSecond");
        Intrinsics.checkNotNullParameter(outputIfNeeded, "$this$outputIfNeeded");
        if (z) {
            z.b(outputIfNeeded, ':');
        }
        y.e.a.b(outputIfNeeded, null, 1, null);
        V(outputIfNeeded, outputSecond, new Function1() { // from class: kotlinx.datetime.format.z1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R;
                R = l2.R(z, (y.e) obj);
                return R;
            }
        });
        return Unit.INSTANCE;
    }

    public static final <T extends y> void V(T t, WhenToOutput whenToOutput, final Function1<? super T, Unit> format) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(whenToOutput, "whenToOutput");
        Intrinsics.checkNotNullParameter(format, "format");
        int i = a.a[whenToOutput.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    format.invoke(t);
                    return;
                }
                throw new NoWhenBranchMatchedException();
            }
            z.d(t, null, new Function1() { // from class: kotlinx.datetime.format.c2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit W;
                    W = l2.W(Function1.this, (y) obj);
                    return W;
                }
            }, 1, null);
        }
    }

    private static final void P(y.e eVar, WhenToOutput whenToOutput, final boolean z, final WhenToOutput whenToOutput2) {
        y.e.a.a(eVar, null, 1, null);
        V(eVar, whenToOutput, new Function1() { // from class: kotlinx.datetime.format.x1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Q;
                Q = l2.Q(z, whenToOutput2, (y.e) obj);
                return Q;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(WhenToOutput outputMinute, boolean z, WhenToOutput outputSecond, y.e alternativeParsing) {
        Intrinsics.checkNotNullParameter(outputMinute, "$outputMinute");
        Intrinsics.checkNotNullParameter(outputSecond, "$outputSecond");
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        P(alternativeParsing, outputMinute, z, outputSecond);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(final WhenToOutput outputMinute, final boolean z, final WhenToOutput outputSecond, y.e optional) {
        Intrinsics.checkNotNullParameter(outputMinute, "$outputMinute");
        Intrinsics.checkNotNullParameter(outputSecond, "$outputSecond");
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        z.a(optional, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.v1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit T;
                T = l2.T((y.e) obj);
                return T;
            }
        }}, new Function1() { // from class: kotlinx.datetime.format.w1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit U;
                U = l2.U(WhenToOutput.this, z, outputSecond, (y.e) obj);
                return U;
            }
        });
        return Unit.INSTANCE;
    }

    public static final void O(y.e eVar, boolean z, final boolean z2, final WhenToOutput outputMinute, final WhenToOutput outputSecond) {
        boolean z3;
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        Intrinsics.checkNotNullParameter(outputMinute, "outputMinute");
        Intrinsics.checkNotNullParameter(outputSecond, "outputSecond");
        if (outputMinute.compareTo(outputSecond) >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (z) {
                z.c(eVar, "Z", new Function1() { // from class: kotlinx.datetime.format.r1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit S;
                        S = l2.S(WhenToOutput.this, z2, outputSecond, (y.e) obj);
                        return S;
                    }
                });
                return;
            } else {
                P(eVar, outputMinute, z2, outputSecond);
                return;
            }
        }
        throw new IllegalArgumentException("Seconds cannot be included without minutes".toString());
    }
}
