package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f0 implements g, g1, kotlinx.datetime.internal.format.parser.c<f0> {
    public final e0 a;
    public final g0 b;

    static {
        Covode.recordClassIndex(659485);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // kotlinx.datetime.format.g1
    public void B(Integer num) {
        this.b.B(num);
    }

    @Override // kotlinx.datetime.format.g1
    public void C(Integer num) {
        this.b.C(num);
    }

    @Override // kotlinx.datetime.format.g
    public Integer a() {
        return this.a.a();
    }

    @Override // kotlinx.datetime.format.g1
    public void b(Integer num) {
        this.b.b(num);
    }

    @Override // kotlinx.datetime.format.g
    public Integer e() {
        return this.a.e();
    }

    @Override // kotlinx.datetime.format.g1
    public void f(an6.a aVar) {
        this.b.f(aVar);
    }

    @Override // kotlinx.datetime.format.g
    public void g(Integer num) {
        this.a.g(num);
    }

    @Override // kotlinx.datetime.format.g1
    public void h(AmPmMarker amPmMarker) {
        this.b.h(amPmMarker);
    }

    @Override // kotlinx.datetime.format.g1
    public Integer i() {
        return this.b.i();
    }

    @Override // kotlinx.datetime.format.g
    public void j(Integer num) {
        this.a.j(num);
    }

    @Override // kotlinx.datetime.format.g1
    public Integer k() {
        return this.b.k();
    }

    @Override // kotlinx.datetime.format.g1
    public an6.a l() {
        return this.b.l();
    }

    @Override // kotlinx.datetime.format.g
    public void m(Integer num) {
        this.a.m(num);
    }

    @Override // kotlinx.datetime.format.g
    public Integer n() {
        return this.a.n();
    }

    @Override // kotlinx.datetime.format.g1
    public Integer o() {
        return this.b.o();
    }

    @Override // kotlinx.datetime.format.g1
    public Integer p() {
        return this.b.p();
    }

    @Override // kotlinx.datetime.format.g1
    public AmPmMarker s() {
        return this.b.s();
    }

    @Override // kotlinx.datetime.format.g1
    public void t(Integer num) {
        this.b.t(num);
    }

    @Override // kotlinx.datetime.format.g1
    public void u(Integer num) {
        this.b.u(num);
    }

    @Override // kotlinx.datetime.format.g
    public void v(Integer num) {
        this.a.v(num);
    }

    @Override // kotlinx.datetime.format.g
    public Integer w() {
        return this.a.w();
    }

    @Override // kotlinx.datetime.format.g1
    public Integer x() {
        return this.b.x();
    }

    @Override // kotlinx.datetime.internal.format.parser.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f0 copy() {
        return new f0(this.a.copy(), this.b.copy());
    }

    public final zm6.h q() {
        return new zm6.h(this.a.d(), this.b.d());
    }

    public final void d(zm6.h dateTime) {
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        this.a.c(dateTime.b());
        this.b.c(dateTime.i());
    }

    public f0(e0 date, g0 time) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        this.a = date;
        this.b = time;
    }

    public /* synthetic */ f0(e0 e0Var, g0 g0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new e0(null, null, null, null, 15, null) : e0Var, (i & 2) != 0 ? new g0(null, null, null, null, null, null, 63, null) : g0Var);
    }
}
