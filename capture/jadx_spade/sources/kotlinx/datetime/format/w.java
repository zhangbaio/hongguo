package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.b;
import kotlinx.datetime.format.d;
import kotlinx.datetime.format.e;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class w extends kotlinx.datetime.format.a<DateTimeComponents, v> {
    private final kotlinx.datetime.internal.format.f<v> a;

    static {
        Covode.recordClassIndex(659453);
    }

    public static final class a implements b<v, a>, d, e, y.c {
        private final kotlinx.datetime.internal.format.d<v> a;

        static {
            Covode.recordClassIndex(659454);
        }

        @Override // kotlinx.datetime.format.b
        public kotlinx.datetime.internal.format.d<v> f() {
            return this.a;
        }

        public kotlinx.datetime.internal.format.f<v> B() {
            return b.a.c(this);
        }

        @Override // kotlinx.datetime.format.b
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public a k() {
            return new a(new kotlinx.datetime.internal.format.d());
        }

        @Override // kotlinx.datetime.format.y.c
        public void o() {
            f().a(new kotlinx.datetime.internal.format.e(new h1(zm6.l.Companion.b())));
        }

        @Override // kotlinx.datetime.format.y.e
        public void A(Padding padding) {
            e.a.b(this, padding);
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
        public void e(MonthNames monthNames) {
            d.a.h(this, monthNames);
        }

        @Override // kotlinx.datetime.format.y.a
        public void g(int i) {
            d.a.o(this, i);
        }

        @Override // kotlinx.datetime.format.y.e
        public void h(Padding padding) {
            e.a.c(this, padding);
        }

        @Override // kotlinx.datetime.format.y.e
        public void j(x<zm6.o> xVar) {
            e.a.a(this, xVar);
        }

        @Override // kotlinx.datetime.format.y.a
        public void l(Padding padding) {
            d.a.n(this, padding);
        }

        @Override // kotlinx.datetime.format.y.a
        public void m(Padding padding) {
            d.a.d(this, padding);
        }

        @Override // kotlinx.datetime.format.y.e
        public void n(Padding padding) {
            e.a.d(this, padding);
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

        @Override // kotlinx.datetime.format.y.a
        public void y(DayOfWeekNames dayOfWeekNames) {
            d.a.e(this, dayOfWeekNames);
        }

        @Override // kotlinx.datetime.format.c
        public void z(kotlinx.datetime.internal.format.n<? super g> nVar) {
            d.a.a(this, nVar);
        }

        public a(kotlinx.datetime.internal.format.d<v> actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.a = actualBuilder;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.datetime.format.e
        public void b(kotlinx.datetime.internal.format.n<? super o1> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            f().a(structure);
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
    public kotlinx.datetime.internal.format.f<v> b() {
        return this.a;
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public v c() {
        v vVar;
        vVar = DateTimeComponentsKt.b;
        return vVar;
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public v d(DateTimeComponents value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public w(kotlinx.datetime.internal.format.f<? super v> actualFormat) {
        super(null);
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.a = actualFormat;
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public DateTimeComponents e(v intermediate) {
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return new DateTimeComponents(intermediate);
    }
}
