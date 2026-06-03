package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gt implements hp<gt, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f576a;
    private static final hw b;
    private static final hw c;
    private static final hw d;
    private static final hw e;
    private static final hw f;

    /* renamed from: a, reason: collision with other field name */
    public String f578a;

    /* renamed from: d, reason: collision with other field name */
    public String f583d;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f579a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public long f577a = 5;

    /* renamed from: b, reason: collision with other field name */
    public String f581b = "xiaomi.com";

    /* renamed from: c, reason: collision with other field name */
    public String f582c = "";

    /* renamed from: a, reason: collision with other field name */
    public boolean f580a = false;

    public int hashCode() {
        return 0;
    }

    public boolean c() {
        if (this.f581b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f582c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f579a.get(1);
    }

    public boolean f() {
        if (this.f583d != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m510a() {
        return this.f579a.get(0);
    }

    public boolean b() {
        if (this.f578a != null) {
            return true;
        }
        return false;
    }

    public void a() {
        if (this.f578a != null) {
            return;
        }
        throw new ia("Required field 'userId' was not present! Struct: " + toString());
    }

    static {
        Covode.recordClassIndex(655569);
        f576a = new ie("Target");
        a = new hw("", (byte) 10, (short) 1);
        b = new hw("", (byte) 11, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 2, (short) 5);
        f = new hw("", (byte) 11, (short) 7);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f577a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f578a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f581b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f582c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f580a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f583d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f579a.set(0, z);
    }

    public void b(boolean z) {
        this.f579a.set(1, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gt)) {
            return false;
        }
        return m511a((gt) obj);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                break;
            }
            short s = mo607a.f830a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s != 7) {
                                    ic.a(hzVar, b2);
                                } else if (b2 == 11) {
                                    this.f583d = hzVar.mo612a();
                                } else {
                                    ic.a(hzVar, b2);
                                }
                            } else if (b2 == 2) {
                                this.f580a = hzVar.mo617a();
                                b(true);
                            } else {
                                ic.a(hzVar, b2);
                            }
                        } else if (b2 == 11) {
                            this.f582c = hzVar.mo612a();
                        } else {
                            ic.a(hzVar, b2);
                        }
                    } else if (b2 == 11) {
                        this.f581b = hzVar.mo612a();
                    } else {
                        ic.a(hzVar, b2);
                    }
                } else if (b2 == 11) {
                    this.f578a = hzVar.mo612a();
                } else {
                    ic.a(hzVar, b2);
                }
            } else if (b2 == 10) {
                this.f577a = hzVar.mo606a();
                a(true);
            } else {
                ic.a(hzVar, b2);
            }
            hzVar.g();
        }
        hzVar.f();
        if (m510a()) {
            a();
            return;
        }
        throw new ia("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        a();
        hzVar.a(f576a);
        hzVar.a(a);
        hzVar.a(this.f577a);
        hzVar.b();
        if (this.f578a != null) {
            hzVar.a(b);
            hzVar.a(this.f578a);
            hzVar.b();
        }
        if (this.f581b != null && c()) {
            hzVar.a(c);
            hzVar.a(this.f581b);
            hzVar.b();
        }
        if (this.f582c != null && d()) {
            hzVar.a(d);
            hzVar.a(this.f582c);
            hzVar.b();
        }
        if (e()) {
            hzVar.a(e);
            hzVar.a(this.f580a);
            hzVar.b();
        }
        if (this.f583d != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f583d);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gt gtVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (!getClass().equals(gtVar.getClass())) {
            return getClass().getName().compareTo(gtVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m510a()).compareTo(Boolean.valueOf(gtVar.m510a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m510a() && (a7 = hq.a(this.f577a, gtVar.f577a)) != 0) {
            return a7;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gtVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a6 = hq.a(this.f578a, gtVar.f578a)) != 0) {
            return a6;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gtVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a5 = hq.a(this.f581b, gtVar.f581b)) != 0) {
            return a5;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gtVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a4 = hq.a(this.f582c, gtVar.f582c)) != 0) {
            return a4;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gtVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a3 = hq.a(this.f580a, gtVar.f580a)) != 0) {
            return a3;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gtVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a2 = hq.a(this.f583d, gtVar.f583d)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m511a(gt gtVar) {
        if (gtVar == null || this.f577a != gtVar.f577a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gtVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f578a.equals(gtVar.f578a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gtVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f581b.equals(gtVar.f581b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gtVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f582c.equals(gtVar.f582c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = gtVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f580a != gtVar.f580a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gtVar.f();
        if (f2 || f3) {
            if (!f2 || !f3 || !this.f583d.equals(gtVar.f583d)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
