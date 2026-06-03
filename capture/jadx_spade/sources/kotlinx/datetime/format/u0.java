package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.b;
import kotlinx.datetime.format.f;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class u0 extends kotlinx.datetime.format.a<zm6.j, g0> {
    public static final b b;
    private final kotlinx.datetime.internal.format.f<g1> a;

    static {
        Covode.recordClassIndex(659496);
        b = new b(null);
    }

    private static final class a implements kotlinx.datetime.format.b<g1, a>, f {
        private final kotlinx.datetime.internal.format.d<g1> a;

        static {
            Covode.recordClassIndex(659497);
        }

        @Override // kotlinx.datetime.format.b
        public kotlinx.datetime.internal.format.d<g1> f() {
            return this.a;
        }

        public kotlinx.datetime.internal.format.f<g1> B() {
            return b.a.c(this);
        }

        @Override // kotlinx.datetime.format.b
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public a k() {
            return new a(new kotlinx.datetime.internal.format.d());
        }

        @Override // kotlinx.datetime.format.y.d
        public void p(int i) {
            f.a.d(this, i);
        }

        @Override // kotlinx.datetime.format.y
        public void q(String str) {
            b.a.d(this, str);
        }

        @Override // kotlinx.datetime.format.y.d
        public void v(Padding padding) {
            f.a.b(this, padding);
        }

        @Override // kotlinx.datetime.format.y.d
        public void w(Padding padding) {
            f.a.c(this, padding);
        }

        @Override // kotlinx.datetime.format.y.d
        public void x(Padding padding) {
            f.a.a(this, padding);
        }

        public a(kotlinx.datetime.internal.format.d<g1> actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.a = actualBuilder;
        }

        @Override // kotlinx.datetime.format.f
        public void c(kotlinx.datetime.internal.format.n<? super g1> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            f().a(structure);
        }

        @Override // kotlinx.datetime.format.y.d
        public void d(int i, int i2) {
            f.a.e(this, i, i2);
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
    public kotlinx.datetime.internal.format.f<g0> b() {
        return this.a;
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public g0 c() {
        g0 g0Var;
        g0Var = a1.b;
        return g0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public u0(kotlinx.datetime.internal.format.f<? super g1> actualFormat) {
        super(null);
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.a = actualFormat;
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public zm6.j e(g0 intermediate) {
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return intermediate.d();
    }

    public static final class b {
        static {
            Covode.recordClassIndex(659498);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final u0 a(Function1<? super y.d, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            a aVar = new a(new kotlinx.datetime.internal.format.d());
            block.invoke(aVar);
            return new u0(aVar.B());
        }
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public g0 d(zm6.j value) {
        Intrinsics.checkNotNullParameter(value, "value");
        g0 g0Var = new g0(null, null, null, null, null, null, 63, null);
        g0Var.c(value);
        return g0Var;
    }
}
