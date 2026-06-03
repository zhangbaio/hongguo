package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.b;
import kotlinx.datetime.format.d;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o0 extends kotlinx.datetime.format.a<zm6.h, f0> {
    public static final b b;
    private final kotlinx.datetime.internal.format.f<Object> a;

    static {
        Covode.recordClassIndex(659492);
        b = new b(null);
    }

    public static final class a implements kotlinx.datetime.format.b<Object, a>, d {
        private final kotlinx.datetime.internal.format.d<Object> a;

        static {
            Covode.recordClassIndex(659493);
        }

        @Override // kotlinx.datetime.format.b
        public kotlinx.datetime.internal.format.d<Object> f() {
            return this.a;
        }

        public kotlinx.datetime.internal.format.f<Object> B() {
            return b.a.c(this);
        }

        @Override // kotlinx.datetime.format.b
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public a k() {
            return new a(new kotlinx.datetime.internal.format.d());
        }

        @Override // kotlinx.datetime.format.y.a
        public void a(Padding padding) {
            d.a.i(this, padding);
        }

        @Override // kotlinx.datetime.format.f
        public void c(kotlinx.datetime.internal.format.n<? super g1> nVar) {
            d.a.b(this, nVar);
        }

        @Override // kotlinx.datetime.format.y.a
        public void g(int i) {
            d.a.o(this, i);
        }

        @Override // kotlinx.datetime.format.y.a
        public void l(Padding padding) {
            d.a.n(this, padding);
        }

        @Override // kotlinx.datetime.format.y.a
        public void m(Padding padding) {
            d.a.d(this, padding);
        }

        @Override // kotlinx.datetime.format.y.d
        public void p(int i) {
            d.a.k(this, i);
        }

        @Override // kotlinx.datetime.format.y
        public void q(String str) {
            b.a.d(this, str);
        }

        @Override // kotlinx.datetime.format.y.d
        public void r(x<zm6.j> xVar) {
            d.a.m(this, xVar);
        }

        @Override // kotlinx.datetime.format.y.a
        public void u(x<kotlinx.datetime.c> xVar) {
            d.a.c(this, xVar);
        }

        @Override // kotlinx.datetime.format.y.d
        public void v(Padding padding) {
            d.a.g(this, padding);
        }

        @Override // kotlinx.datetime.format.y.d
        public void w(Padding padding) {
            d.a.j(this, padding);
        }

        @Override // kotlinx.datetime.format.y.d
        public void x(Padding padding) {
            d.a.f(this, padding);
        }

        @Override // kotlinx.datetime.format.c
        public void z(kotlinx.datetime.internal.format.n<? super g> nVar) {
            d.a.a(this, nVar);
        }

        public a(kotlinx.datetime.internal.format.d<Object> actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.a = actualBuilder;
        }

        @Override // kotlinx.datetime.format.d
        public void i(kotlinx.datetime.internal.format.n<Object> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            f().a(structure);
        }

        @Override // kotlinx.datetime.format.y.d
        public void d(int i, int i2) {
            d.a.l(this, i, i2);
        }

        @Override // kotlinx.datetime.format.b
        public void s(String str, Function1<? super a, Unit> function1) {
            b.a.b(this, str, function1);
        }

        @Override // kotlinx.datetime.format.b
        public void t(Function1<? super a, Unit>[] function1Arr, Function1<? super a, Unit> function1) {
            b.a.a(this, function1Arr, function1);
        }
    }

    @Override // kotlinx.datetime.format.a
    public kotlinx.datetime.internal.format.f<f0> b() {
        return this.a;
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public f0 c() {
        f0 f0Var;
        f0Var = t0.b;
        return f0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(kotlinx.datetime.internal.format.f<Object> actualFormat) {
        super(null);
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.a = actualFormat;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.datetime.format.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public f0 d(zm6.h value) {
        Intrinsics.checkNotNullParameter(value, "value");
        f0 f0Var = new f0(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        f0Var.d(value);
        return f0Var;
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public zm6.h e(f0 intermediate) {
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return intermediate.q();
    }

    public static final class b {
        static {
            Covode.recordClassIndex(659494);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final o0 a(Function1<? super y.b, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            a aVar = new a(new kotlinx.datetime.internal.format.d());
            block.invoke(aVar);
            return new o0(aVar.B());
        }
    }
}
