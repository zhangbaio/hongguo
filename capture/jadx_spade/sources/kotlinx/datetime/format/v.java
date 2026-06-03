package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class v implements g, g1, o1, kotlinx.datetime.internal.format.parser.c<v> {
    public final e0 a;
    public final g0 b;
    public final h0 c;
    public String d;

    static {
        Covode.recordClassIndex(659452);
    }

    public v() {
        this(null, null, null, null, 15, null);
    }

    @Override // kotlinx.datetime.format.o1
    public void A(Integer num) {
        this.c.A(num);
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

    @Override // kotlinx.datetime.format.o1
    public void c(Integer num) {
        this.c.c(num);
    }

    @Override // kotlinx.datetime.format.o1
    public Integer d() {
        return this.c.d();
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

    @Override // kotlinx.datetime.format.o1
    public Boolean isNegative() {
        return this.c.isNegative();
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

    @Override // kotlinx.datetime.format.o1
    public void q(Boolean bool) {
        this.c.q(bool);
    }

    @Override // kotlinx.datetime.format.o1
    public void r(Integer num) {
        this.c.r(num);
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

    @Override // kotlinx.datetime.format.o1
    public Integer y() {
        return this.c.y();
    }

    @Override // kotlinx.datetime.format.o1
    public Integer z() {
        return this.c.z();
    }

    @Override // kotlinx.datetime.internal.format.parser.c
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public v copy() {
        return new v(this.a.copy(), this.b.copy(), this.c.copy(), this.d);
    }

    public int hashCode() {
        int i;
        int hashCode = (this.a.hashCode() ^ this.b.hashCode()) ^ this.c.hashCode();
        String str = this.d;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return hashCode ^ i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof v) {
            v vVar = (v) obj;
            if (Intrinsics.areEqual(vVar.a, this.a) && Intrinsics.areEqual(vVar.b, this.b) && Intrinsics.areEqual(vVar.c, this.c) && Intrinsics.areEqual(vVar.d, this.d)) {
                return true;
            }
        }
        return false;
    }

    public v(e0 date, g0 time, h0 offset, String str) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(offset, "offset");
        this.a = date;
        this.b = time;
        this.c = offset;
        this.d = str;
    }

    public /* synthetic */ v(e0 e0Var, g0 g0Var, h0 h0Var, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new e0(null, null, null, null, 15, null) : e0Var, (i & 2) != 0 ? new g0(null, null, null, null, null, null, 63, null) : g0Var, (i & 4) != 0 ? new h0(null, null, null, null, 15, null) : h0Var, (i & 8) != 0 ? null : str);
    }
}
