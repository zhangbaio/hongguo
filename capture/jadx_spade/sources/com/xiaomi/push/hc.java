package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hc implements hp<hc, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f660a;

    /* renamed from: a, reason: collision with other field name */
    public List<gn> f661a;

    public int hashCode() {
        return 0;
    }

    public List<gn> a() {
        return this.f661a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m546a() {
        if (this.f661a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655579);
        f660a = new ie("XmPushActionNormalConfig");
        a = new hw("", (byte) 15, (short) 1);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m545a() {
        if (this.f661a != null) {
            return;
        }
        throw new ia("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<gn> list = this.f661a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hc)) {
            return false;
        }
        return m547a((hc) obj);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m547a(hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        boolean m546a = m546a();
        boolean m546a2 = hcVar.m546a();
        if (m546a || m546a2) {
            if (!m546a || !m546a2 || !this.f661a.equals(hcVar.f661a)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hc hcVar) {
        int a2;
        if (!getClass().equals(hcVar.getClass())) {
            return getClass().getName().compareTo(hcVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m546a()).compareTo(Boolean.valueOf(hcVar.m546a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m546a() && (a2 = hq.a(this.f661a, hcVar.f661a)) != 0) {
            return a2;
        }
        return 0;
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m545a();
        hzVar.a(f660a);
        if (this.f661a != null) {
            hzVar.a(a);
            hzVar.a(new hx((byte) 12, this.f661a.size()));
            Iterator<gn> it2 = this.f661a.iterator();
            while (it2.hasNext()) {
                it2.next().b(hzVar);
            }
            hzVar.e();
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b = mo607a.a;
            if (b == 0) {
                hzVar.f();
                m545a();
                return;
            }
            if (mo607a.f830a != 1) {
                ic.a(hzVar, b);
            } else if (b == 15) {
                hx mo608a = hzVar.mo608a();
                this.f661a = new ArrayList(mo608a.f831a);
                for (int i = 0; i < mo608a.f831a; i++) {
                    gn gnVar = new gn();
                    gnVar.a(hzVar);
                    this.f661a.add(gnVar);
                }
                hzVar.i();
            } else {
                ic.a(hzVar, b);
            }
            hzVar.g();
        }
    }
}
