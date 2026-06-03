package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gx implements hp<gx, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f622a;

    /* renamed from: a, reason: collision with other field name */
    public List<gm> f623a;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m521a() {
        if (this.f623a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655573);
        f622a = new ie("XmPushActionCollectData");
        a = new hw("", (byte) 15, (short) 1);
    }

    public void a() {
        if (this.f623a != null) {
            return;
        }
        throw new ia("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<gm> list = this.f623a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public gx a(List<gm> list) {
        this.f623a = list;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gx)) {
            return false;
        }
        return m522a((gx) obj);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m522a(gx gxVar) {
        if (gxVar == null) {
            return false;
        }
        boolean m521a = m521a();
        boolean m521a2 = gxVar.m521a();
        if (m521a || m521a2) {
            if (!m521a || !m521a2 || !this.f623a.equals(gxVar.f623a)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gx gxVar) {
        int a2;
        if (!getClass().equals(gxVar.getClass())) {
            return getClass().getName().compareTo(gxVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m521a()).compareTo(Boolean.valueOf(gxVar.m521a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m521a() && (a2 = hq.a(this.f623a, gxVar.f623a)) != 0) {
            return a2;
        }
        return 0;
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        a();
        hzVar.a(f622a);
        if (this.f623a != null) {
            hzVar.a(a);
            hzVar.a(new hx((byte) 12, this.f623a.size()));
            Iterator<gm> it2 = this.f623a.iterator();
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
                a();
                return;
            }
            if (mo607a.f830a != 1) {
                ic.a(hzVar, b);
            } else if (b == 15) {
                hx mo608a = hzVar.mo608a();
                this.f623a = new ArrayList(mo608a.f831a);
                for (int i = 0; i < mo608a.f831a; i++) {
                    gm gmVar = new gm();
                    gmVar.a(hzVar);
                    this.f623a.add(gmVar);
                }
                hzVar.i();
            } else {
                ic.a(hzVar, b);
            }
            hzVar.g();
        }
    }
}
