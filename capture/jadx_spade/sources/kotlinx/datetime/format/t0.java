package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class t0 {
    private static final Lazy a;
    private static final f0 b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final o0 e() {
        return o0.b.a(new Function1() { // from class: kotlinx.datetime.format.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f;
                f = t0.f((y.b) obj);
                return f;
            }
        });
    }

    public static final o0 j() {
        return (o0) a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Lazy lazy;
        Covode.recordClassIndex(659495);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: kotlinx.datetime.format.p0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                o0 e;
                e = t0.e();
                return e;
            }
        });
        a = lazy;
        b = new f0(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(y.b alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        z.b(alternativeParsing, 't');
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(y.b alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        z.b(alternativeParsing, 'T');
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(y.b build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        build.u(n0.j());
        z.a(build, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g;
                g = t0.g((y.b) obj);
                return g;
            }
        }}, new Function1() { // from class: kotlinx.datetime.format.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h;
                h = t0.h((y.b) obj);
                return h;
            }
        });
        build.r(a1.l());
        return Unit.INSTANCE;
    }
}
