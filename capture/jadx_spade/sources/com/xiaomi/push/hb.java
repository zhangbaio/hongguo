package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hb implements hp<hb, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f658a;

    /* renamed from: a, reason: collision with other field name */
    public List<gp> f659a;

    public int hashCode() {
        return 0;
    }

    public List<gp> a() {
        return this.f659a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m543a() {
        if (this.f659a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655578);
        f658a = new ie("XmPushActionCustomConfig");
        a = new hw("", (byte) 15, (short) 1);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m542a() {
        if (this.f659a != null) {
            return;
        }
        throw new ia("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<gp> list = this.f659a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hb)) {
            return false;
        }
        return m544a((hb) obj);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m544a(hb hbVar) {
        if (hbVar == null) {
            return false;
        }
        boolean m543a = m543a();
        boolean m543a2 = hbVar.m543a();
        if (m543a || m543a2) {
            if (!m543a || !m543a2 || !this.f659a.equals(hbVar.f659a)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hb hbVar) {
        int a2;
        if (!getClass().equals(hbVar.getClass())) {
            return getClass().getName().compareTo(hbVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m543a()).compareTo(Boolean.valueOf(hbVar.m543a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m543a() && (a2 = hq.a(this.f659a, hbVar.f659a)) != 0) {
            return a2;
        }
        return 0;
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m542a();
        hzVar.a(f658a);
        if (this.f659a != null) {
            hzVar.a(a);
            hzVar.a(new hx((byte) 12, this.f659a.size()));
            Iterator<gp> it2 = this.f659a.iterator();
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
                m542a();
                return;
            }
            if (mo607a.f830a != 1) {
                ic.a(hzVar, b);
            } else if (b == 15) {
                hx mo608a = hzVar.mo608a();
                this.f659a = new ArrayList(mo608a.f831a);
                for (int i = 0; i < mo608a.f831a; i++) {
                    gp gpVar = new gp();
                    gpVar.a(hzVar);
                    this.f659a.add(gpVar);
                }
                hzVar.i();
            } else {
                ic.a(hzVar, b);
            }
            hzVar.g();
        }
    }
}
