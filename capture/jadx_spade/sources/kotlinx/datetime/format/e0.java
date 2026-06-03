package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e0 implements g, kotlinx.datetime.internal.format.parser.c<e0> {
    private Integer a;
    private Integer b;
    private Integer c;
    private Integer d;

    static {
        Covode.recordClassIndex(659484);
    }

    public e0() {
        this(null, null, null, null, 15, null);
    }

    @Override // kotlinx.datetime.format.g
    public Integer a() {
        return this.d;
    }

    @Override // kotlinx.datetime.format.g
    public Integer e() {
        return this.a;
    }

    @Override // kotlinx.datetime.format.g
    public Integer n() {
        return this.c;
    }

    @Override // kotlinx.datetime.format.g
    public Integer w() {
        return this.b;
    }

    @Override // kotlinx.datetime.internal.format.parser.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e0 copy() {
        return new e0(e(), w(), n(), a());
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        Integer e = e();
        int i4 = 0;
        if (e != null) {
            i = e.hashCode();
        } else {
            i = 0;
        }
        int i5 = i * 31;
        Integer w = w();
        if (w != null) {
            i2 = w.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = i5 + (i2 * 31);
        Integer n = n();
        if (n != null) {
            i3 = n.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = i6 + (i3 * 31);
        Integer a = a();
        if (a != null) {
            i4 = a.hashCode();
        }
        return i7 + (i4 * 31);
    }

    public final kotlinx.datetime.c d() {
        int intValue;
        kotlinx.datetime.c cVar = new kotlinx.datetime.c(((Number) n0.l(e(), "year")).intValue(), ((Number) n0.l(w(), "monthNumber")).intValue(), ((Number) n0.l(n(), "dayOfMonth")).intValue());
        Integer a = a();
        if (a != null && (intValue = a.intValue()) != zm6.f.b(cVar.c())) {
            throw new DateTimeFormatException("Can not create a LocalDate from the given input: the day of week is " + zm6.f.a(intValue) + " but the date is " + cVar + ", which is a " + cVar.c());
        }
        return cVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Object e = e();
        Object obj = "??";
        if (e == null) {
            e = "??";
        }
        sb.append(e);
        sb.append('-');
        Object w = w();
        if (w == null) {
            w = "??";
        }
        sb.append(w);
        sb.append('-');
        Object n = n();
        if (n == null) {
            n = "??";
        }
        sb.append(n);
        sb.append(" (day of week is ");
        Integer a = a();
        if (a != null) {
            obj = a;
        }
        sb.append(obj);
        sb.append(')');
        return sb.toString();
    }

    @Override // kotlinx.datetime.format.g
    public void g(Integer num) {
        this.d = num;
    }

    @Override // kotlinx.datetime.format.g
    public void j(Integer num) {
        this.b = num;
    }

    @Override // kotlinx.datetime.format.g
    public void m(Integer num) {
        this.a = num;
    }

    @Override // kotlinx.datetime.format.g
    public void v(Integer num) {
        this.c = num;
    }

    public final void c(kotlinx.datetime.c date) {
        Intrinsics.checkNotNullParameter(date, "date");
        m(Integer.valueOf(date.e()));
        j(Integer.valueOf(date.d()));
        v(Integer.valueOf(date.b()));
        g(Integer.valueOf(zm6.f.b(date.c())));
    }

    public boolean equals(Object obj) {
        if (obj instanceof e0) {
            e0 e0Var = (e0) obj;
            if (Intrinsics.areEqual(e(), e0Var.e()) && Intrinsics.areEqual(w(), e0Var.w()) && Intrinsics.areEqual(n(), e0Var.n()) && Intrinsics.areEqual(a(), e0Var.a())) {
                return true;
            }
        }
        return false;
    }

    public e0(Integer num, Integer num2, Integer num3, Integer num4) {
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
    }

    public /* synthetic */ e0(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
    }
}
