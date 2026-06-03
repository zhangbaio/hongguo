package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gn implements hp<gn, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f523a;
    private static final hw b;
    private static final hw c;

    /* renamed from: a, reason: collision with other field name */
    public int f524a;

    /* renamed from: a, reason: collision with other field name */
    public gk f525a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f526a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public List<gp> f527a;

    public int hashCode() {
        return 0;
    }

    public int a() {
        return this.f524a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public gk m480a() {
        return this.f525a;
    }

    public boolean b() {
        if (this.f527a != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f525a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m481a() {
        if (this.f527a != null) {
            return;
        }
        throw new ia("Required field 'configItems' was not present! Struct: " + toString());
    }

    static {
        Covode.recordClassIndex(655563);
        f523a = new ie("NormalConfig");
        a = new hw("", (byte) 8, (short) 1);
        b = new hw("", (byte) 15, (short) 2);
        c = new hw("", (byte) 8, (short) 3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m482a() {
        return this.f526a.get(0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f524a);
        sb.append(", ");
        sb.append("configItems:");
        List<gp> list = this.f527a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            gk gkVar = this.f525a;
            if (gkVar == null) {
                sb.append("null");
            } else {
                sb.append(gkVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f526a.set(0, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gn)) {
            return false;
        }
        return m483a((gn) obj);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m483a(gn gnVar) {
        if (gnVar == null || this.f524a != gnVar.f524a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gnVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f527a.equals(gnVar.f527a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gnVar.c();
        if (c2 || c3) {
            if (!c2 || !c3 || !this.f525a.equals(gnVar.f525a)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m481a();
        hzVar.a(f523a);
        hzVar.a(a);
        hzVar.mo616a(this.f524a);
        hzVar.b();
        if (this.f527a != null) {
            hzVar.a(b);
            hzVar.a(new hx((byte) 12, this.f527a.size()));
            Iterator<gp> it2 = this.f527a.iterator();
            while (it2.hasNext()) {
                it2.next().b(hzVar);
            }
            hzVar.e();
            hzVar.b();
        }
        if (this.f525a != null && c()) {
            hzVar.a(c);
            hzVar.mo616a(this.f525a.a());
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gn gnVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(gnVar.getClass())) {
            return getClass().getName().compareTo(gnVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m482a()).compareTo(Boolean.valueOf(gnVar.m482a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m482a() && (a4 = hq.a(this.f524a, gnVar.f524a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gnVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = hq.a(this.f527a, gnVar.f527a)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gnVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a2 = hq.a(this.f525a, gnVar.f525a)) != 0) {
            return a2;
        }
        return 0;
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
                        ic.a(hzVar, b2);
                    } else if (b2 == 8) {
                        this.f525a = gk.a(hzVar.mo605a());
                    } else {
                        ic.a(hzVar, b2);
                    }
                } else if (b2 == 15) {
                    hx mo608a = hzVar.mo608a();
                    this.f527a = new ArrayList(mo608a.f831a);
                    for (int i = 0; i < mo608a.f831a; i++) {
                        gp gpVar = new gp();
                        gpVar.a(hzVar);
                        this.f527a.add(gpVar);
                    }
                    hzVar.i();
                } else {
                    ic.a(hzVar, b2);
                }
            } else if (b2 == 8) {
                this.f524a = hzVar.mo605a();
                a(true);
            } else {
                ic.a(hzVar, b2);
            }
            hzVar.g();
        }
        hzVar.f();
        if (m482a()) {
            m481a();
            return;
        }
        throw new ia("Required field 'version' was not found in serialized data! Struct: " + toString());
    }
}
