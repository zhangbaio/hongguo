package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.format.g1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g0 implements g1, kotlinx.datetime.internal.format.parser.c<g0> {
    private Integer a;
    private Integer b;
    private AmPmMarker c;
    private Integer d;
    private Integer e;
    private Integer f;

    static {
        Covode.recordClassIndex(659486);
    }

    public g0() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // kotlinx.datetime.format.g1
    public Integer i() {
        return this.e;
    }

    @Override // kotlinx.datetime.format.g1
    public Integer k() {
        return this.d;
    }

    @Override // kotlinx.datetime.format.g1
    public Integer o() {
        return this.f;
    }

    @Override // kotlinx.datetime.format.g1
    public Integer p() {
        return this.b;
    }

    @Override // kotlinx.datetime.format.g1
    public AmPmMarker s() {
        return this.c;
    }

    @Override // kotlinx.datetime.format.g1
    public Integer x() {
        return this.a;
    }

    @Override // kotlinx.datetime.format.g1
    public an6.a l() {
        return g1.a.a(this);
    }

    @Override // kotlinx.datetime.internal.format.parser.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public g0 copy() {
        return new g0(x(), p(), s(), k(), i(), o());
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Integer x = x();
        int i6 = 0;
        if (x != null) {
            i = x.intValue();
        } else {
            i = 0;
        }
        int i7 = i * 31;
        Integer p = p();
        if (p != null) {
            i2 = p.intValue();
        } else {
            i2 = 0;
        }
        int i8 = i7 + (i2 * 31);
        AmPmMarker s = s();
        if (s != null) {
            i3 = s.hashCode();
        } else {
            i3 = 0;
        }
        int i9 = i8 + (i3 * 31);
        Integer k = k();
        if (k != null) {
            i4 = k.intValue();
        } else {
            i4 = 0;
        }
        int i10 = i9 + (i4 * 31);
        Integer i11 = i();
        if (i11 != null) {
            i5 = i11.intValue();
        } else {
            i5 = 0;
        }
        int i12 = i10 + (i5 * 31);
        Integer o = o();
        if (o != null) {
            i6 = o.intValue();
        }
        return i12 + i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
    
        if (r1 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Integer r1 = r4.x()
            java.lang.String r2 = "??"
            if (r1 != 0) goto Le
            r1 = r2
        Le:
            r0.append(r1)
            r1 = 58
            r0.append(r1)
            java.lang.Integer r3 = r4.k()
            if (r3 != 0) goto L1d
            r3 = r2
        L1d:
            r0.append(r3)
            r0.append(r1)
            java.lang.Integer r1 = r4.i()
            if (r1 != 0) goto L2a
            goto L2b
        L2a:
            r2 = r1
        L2b:
            r0.append(r2)
            r1 = 46
            r0.append(r1)
            java.lang.Integer r1 = r4.o()
            if (r1 == 0) goto L4f
            int r1 = r1.intValue()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            int r2 = 9 - r2
            r3 = 48
            java.lang.String r1 = kotlin.text.StringsKt.padStart(r1, r2, r3)
            if (r1 != 0) goto L51
        L4f:
            java.lang.String r1 = "???"
        L51:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.format.g0.toString():java.lang.String");
    }

    public final zm6.j d() {
        int intValue;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        Integer x = x();
        int i2 = 12;
        int i3 = 0;
        if (x != null) {
            intValue = x.intValue();
            Integer p = p();
            boolean z4 = true;
            if (p != null) {
                int intValue2 = p.intValue();
                if (((intValue + 11) % 12) + 1 == intValue2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    throw new IllegalArgumentException(("Inconsistent hour and hour-of-am-pm: hour is " + intValue + ", but hour-of-am-pm is " + intValue2).toString());
                }
            }
            AmPmMarker s = s();
            if (s != null) {
                if (s == AmPmMarker.PM) {
                    z = true;
                } else {
                    z = false;
                }
                if (intValue >= 12) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z != z2) {
                    z4 = false;
                }
                if (!z4) {
                    throw new IllegalArgumentException(("Inconsistent hour and the AM/PM marker: hour is " + intValue + ", but the AM/PM marker is " + s).toString());
                }
            }
        } else {
            Integer p2 = p();
            Integer num = null;
            if (p2 != null) {
                int intValue3 = p2.intValue();
                AmPmMarker s2 = s();
                if (s2 != null) {
                    if (intValue3 == 12) {
                        intValue3 = 0;
                    }
                    if (s2 != AmPmMarker.PM) {
                        i2 = 0;
                    }
                    num = Integer.valueOf(intValue3 + i2);
                }
            }
            if (num != null) {
                intValue = num.intValue();
            } else {
                throw new DateTimeFormatException("Incomplete time: missing hour");
            }
        }
        int intValue4 = ((Number) n0.l(k(), "minute")).intValue();
        Integer i4 = i();
        if (i4 != null) {
            i = i4.intValue();
        } else {
            i = 0;
        }
        Integer o = o();
        if (o != null) {
            i3 = o.intValue();
        }
        return new zm6.j(intValue, intValue4, i, i3);
    }

    @Override // kotlinx.datetime.format.g1
    public void B(Integer num) {
        this.d = num;
    }

    @Override // kotlinx.datetime.format.g1
    public void C(Integer num) {
        this.a = num;
    }

    @Override // kotlinx.datetime.format.g1
    public void b(Integer num) {
        this.e = num;
    }

    @Override // kotlinx.datetime.format.g1
    public void f(an6.a aVar) {
        g1.a.b(this, aVar);
    }

    @Override // kotlinx.datetime.format.g1
    public void h(AmPmMarker amPmMarker) {
        this.c = amPmMarker;
    }

    @Override // kotlinx.datetime.format.g1
    public void t(Integer num) {
        this.b = num;
    }

    @Override // kotlinx.datetime.format.g1
    public void u(Integer num) {
        this.f = num;
    }

    public final void c(zm6.j localTime) {
        AmPmMarker amPmMarker;
        Intrinsics.checkNotNullParameter(localTime, "localTime");
        C(Integer.valueOf(localTime.b()));
        t(Integer.valueOf(((localTime.b() + 11) % 12) + 1));
        if (localTime.b() >= 12) {
            amPmMarker = AmPmMarker.PM;
        } else {
            amPmMarker = AmPmMarker.AM;
        }
        h(amPmMarker);
        B(Integer.valueOf(localTime.c()));
        b(Integer.valueOf(localTime.e()));
        u(Integer.valueOf(localTime.d()));
    }

    public boolean equals(Object obj) {
        if (obj instanceof g0) {
            g0 g0Var = (g0) obj;
            if (Intrinsics.areEqual(x(), g0Var.x()) && Intrinsics.areEqual(p(), g0Var.p()) && s() == g0Var.s() && Intrinsics.areEqual(k(), g0Var.k()) && Intrinsics.areEqual(i(), g0Var.i()) && Intrinsics.areEqual(o(), g0Var.o())) {
                return true;
            }
        }
        return false;
    }

    public g0(Integer num, Integer num2, AmPmMarker amPmMarker, Integer num3, Integer num4, Integer num5) {
        this.a = num;
        this.b = num2;
        this.c = amPmMarker;
        this.d = num3;
        this.e = num4;
        this.f = num5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ g0(java.lang.Integer r6, java.lang.Integer r7, kotlinx.datetime.format.AmPmMarker r8, java.lang.Integer r9, java.lang.Integer r10, java.lang.Integer r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L7
            r13 = r0
            goto L8
        L7:
            r13 = r6
        L8:
            r6 = r12 & 2
            if (r6 == 0) goto Le
            r1 = r0
            goto Lf
        Le:
            r1 = r7
        Lf:
            r6 = r12 & 4
            if (r6 == 0) goto L15
            r2 = r0
            goto L16
        L15:
            r2 = r8
        L16:
            r6 = r12 & 8
            if (r6 == 0) goto L1c
            r3 = r0
            goto L1d
        L1c:
            r3 = r9
        L1d:
            r6 = r12 & 16
            if (r6 == 0) goto L23
            r4 = r0
            goto L24
        L23:
            r4 = r10
        L24:
            r6 = r12 & 32
            if (r6 == 0) goto L2a
            r12 = r0
            goto L2b
        L2a:
            r12 = r11
        L2b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.format.g0.<init>(java.lang.Integer, java.lang.Integer, kotlinx.datetime.format.AmPmMarker, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
