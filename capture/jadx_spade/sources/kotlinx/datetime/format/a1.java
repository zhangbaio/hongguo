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
public final class a1 {
    private static final Lazy a;
    private static final g0 b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final u0 f() {
        return u0.b.a(new Function1() { // from class: kotlinx.datetime.format.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g;
                g = a1.g((y.d) obj);
                return g;
            }
        });
    }

    public static final u0 l() {
        return (u0) a.getValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(659499);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: kotlinx.datetime.format.v0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                u0 f;
                f = a1.f();
                return f;
            }
        });
        a = lazy;
        b = new g0(null, null, null, null, null, null, 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(y.d alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(y.d alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        z.b(alternativeParsing, ':');
        y.d.a.c(alternativeParsing, null, 1, null);
        z.d(alternativeParsing, null, new Function1() { // from class: kotlinx.datetime.format.z0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j;
                j = a1.j((y.d) obj);
                return j;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(y.d optional) {
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        z.b(optional, '.');
        optional.d(1, 9);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(y.d build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        y.d.a.a(build, null, 1, null);
        z.b(build, ':');
        y.d.a.b(build, null, 1, null);
        z.a(build, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h;
                h = a1.h((y.d) obj);
                return h;
            }
        }}, new Function1() { // from class: kotlinx.datetime.format.y0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i;
                i = a1.i((y.d) obj);
                return i;
            }
        });
        return Unit.INSTANCE;
    }
}
