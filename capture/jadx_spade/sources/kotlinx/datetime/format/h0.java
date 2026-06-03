package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h0 implements o1, kotlinx.datetime.internal.format.parser.c<h0> {
    private Boolean a;
    private Integer b;
    private Integer c;
    private Integer d;

    static {
        Covode.recordClassIndex(659487);
    }

    public h0() {
        this(null, null, null, null, 15, null);
    }

    @Override // kotlinx.datetime.format.o1
    public Integer d() {
        return this.d;
    }

    @Override // kotlinx.datetime.format.o1
    public Boolean isNegative() {
        return this.a;
    }

    @Override // kotlinx.datetime.format.o1
    public Integer y() {
        return this.b;
    }

    @Override // kotlinx.datetime.format.o1
    public Integer z() {
        return this.c;
    }

    @Override // kotlinx.datetime.internal.format.parser.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public h0 copy() {
        return new h0(isNegative(), y(), z(), d());
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        Boolean isNegative = isNegative();
        int i4 = 0;
        if (isNegative != null) {
            i = isNegative.hashCode();
        } else {
            i = 0;
        }
        Integer y = y();
        if (y != null) {
            i2 = y.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = i + i2;
        Integer z = z();
        if (z != null) {
            i3 = z.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = i5 + i3;
        Integer d = d();
        if (d != null) {
            i4 = d.hashCode();
        }
        return i6 + i4;
    }

    public final zm6.o e() {
        int i;
        Integer num;
        Integer num2;
        if (Intrinsics.areEqual(isNegative(), Boolean.TRUE)) {
            i = -1;
        } else {
            i = 1;
        }
        Integer y = y();
        Integer num3 = null;
        if (y != null) {
            num = Integer.valueOf(y.intValue() * i);
        } else {
            num = null;
        }
        Integer z = z();
        if (z != null) {
            num2 = Integer.valueOf(z.intValue() * i);
        } else {
            num2 = null;
        }
        Integer d = d();
        if (d != null) {
            num3 = Integer.valueOf(d.intValue() * i);
        }
        return zm6.t.d(num, num2, num3);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        Boolean isNegative = isNegative();
        if (isNegative != null) {
            if (isNegative.booleanValue()) {
                str = "-";
            } else {
                str = "+";
            }
        } else {
            str = " ";
        }
        sb.append(str);
        Object y = y();
        Object obj = "??";
        if (y == null) {
            y = "??";
        }
        sb.append(y);
        sb.append(':');
        Object z = z();
        if (z == null) {
            z = "??";
        }
        sb.append(z);
        sb.append(':');
        Integer d = d();
        if (d != null) {
            obj = d;
        }
        sb.append(obj);
        return sb.toString();
    }

    @Override // kotlinx.datetime.format.o1
    public void A(Integer num) {
        this.d = num;
    }

    @Override // kotlinx.datetime.format.o1
    public void c(Integer num) {
        this.b = num;
    }

    @Override // kotlinx.datetime.format.o1
    public void q(Boolean bool) {
        this.a = bool;
    }

    @Override // kotlinx.datetime.format.o1
    public void r(Integer num) {
        this.c = num;
    }

    public final void b(zm6.o offset) {
        boolean z;
        Intrinsics.checkNotNullParameter(offset, "offset");
        if (offset.a() < 0) {
            z = true;
        } else {
            z = false;
        }
        q(Boolean.valueOf(z));
        int abs = Math.abs(offset.a());
        c(Integer.valueOf(abs / 3600));
        r(Integer.valueOf((abs / 60) % 60));
        A(Integer.valueOf(abs % 60));
    }

    public boolean equals(Object obj) {
        if (obj instanceof h0) {
            h0 h0Var = (h0) obj;
            if (Intrinsics.areEqual(isNegative(), h0Var.isNegative()) && Intrinsics.areEqual(y(), h0Var.y()) && Intrinsics.areEqual(z(), h0Var.z()) && Intrinsics.areEqual(d(), h0Var.d())) {
                return true;
            }
        }
        return false;
    }

    public h0(Boolean bool, Integer num, Integer num2, Integer num3) {
        this.a = bool;
        this.b = num;
        this.c = num2;
        this.d = num3;
    }

    public /* synthetic */ h0(Boolean bool, Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3);
    }
}
