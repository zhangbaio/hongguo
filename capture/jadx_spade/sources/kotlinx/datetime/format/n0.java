package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n0 {
    private static final Lazy a;
    private static final Lazy b;
    private static final e0 c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final x e() {
        return i0.b.a(new Function1() { // from class: kotlinx.datetime.format.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f;
                f = n0.f((y.a) obj);
                return f;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x g() {
        return i0.b.a(new Function1() { // from class: kotlinx.datetime.format.l0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h;
                h = n0.h((y.a) obj);
                return h;
            }
        });
    }

    public static final x<kotlinx.datetime.c> j() {
        return (x) a.getValue();
    }

    public static final x<kotlinx.datetime.c> k() {
        return (x) b.getValue();
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Covode.recordClassIndex(659491);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: kotlinx.datetime.format.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                x g;
                g = n0.g();
                return g;
            }
        });
        a = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: kotlinx.datetime.format.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                x e;
                e = n0.e();
                return e;
            }
        });
        b = lazy2;
        c = new e0(null, null, null, null, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(y.a build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        y.a.C0226a.c(build, null, 1, null);
        y.a.C0226a.b(build, null, 1, null);
        y.a.C0226a.a(build, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(y.a build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        y.a.C0226a.c(build, null, 1, null);
        z.b(build, '-');
        y.a.C0226a.b(build, null, 1, null);
        z.b(build, '-');
        y.a.C0226a.a(build, null, 1, null);
        return Unit.INSTANCE;
    }

    public static final void m(y.a aVar, Padding padding) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(padding, "padding");
        if (aVar instanceof c) {
            ((c) aVar).z(new kotlinx.datetime.internal.format.e(new p2(padding, true)));
        }
    }

    public static final void n(y.a aVar, int i) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar instanceof c) {
            ((c) aVar).z(new kotlinx.datetime.internal.format.e(new e1(i, true)));
        }
    }

    public static final <T> T l(T t, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (t != null) {
            return t;
        }
        throw new DateTimeFormatException("Can not create a " + name + " from the given input: the field " + name + " is missing");
    }
}
