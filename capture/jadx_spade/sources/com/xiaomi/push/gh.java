package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gh implements hp<gh, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f497a;

    /* renamed from: a, reason: collision with other field name */
    public List<gi> f498a;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m465a() {
        if (this.f498a != null) {
            return true;
        }
        return false;
    }

    public int a() {
        List<gi> list = this.f498a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    static {
        Covode.recordClassIndex(655557);
        f497a = new ie("ClientUploadData");
        a = new hw("", (byte) 15, (short) 1);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m464a() {
        if (this.f498a != null) {
            return;
        }
        throw new ia("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<gi> list = this.f498a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gh)) {
            return false;
        }
        return m466a((gh) obj);
    }

    public void a(gi giVar) {
        if (this.f498a == null) {
            this.f498a = new ArrayList();
        }
        this.f498a.add(giVar);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gh ghVar) {
        int a2;
        if (!getClass().equals(ghVar.getClass())) {
            return getClass().getName().compareTo(ghVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m465a()).compareTo(Boolean.valueOf(ghVar.m465a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m465a() && (a2 = hq.a(this.f498a, ghVar.f498a)) != 0) {
            return a2;
        }
        return 0;
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m464a();
        hzVar.a(f497a);
        if (this.f498a != null) {
            hzVar.a(a);
            hzVar.a(new hx((byte) 12, this.f498a.size()));
            Iterator<gi> it2 = this.f498a.iterator();
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
                m464a();
                return;
            }
            if (mo607a.f830a != 1) {
                ic.a(hzVar, b);
            } else if (b == 15) {
                hx mo608a = hzVar.mo608a();
                this.f498a = new ArrayList(mo608a.f831a);
                for (int i = 0; i < mo608a.f831a; i++) {
                    gi giVar = new gi();
                    giVar.a(hzVar);
                    this.f498a.add(giVar);
                }
                hzVar.i();
            } else {
                ic.a(hzVar, b);
            }
            hzVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m466a(gh ghVar) {
        if (ghVar == null) {
            return false;
        }
        boolean m465a = m465a();
        boolean m465a2 = ghVar.m465a();
        if (m465a || m465a2) {
            if (!m465a || !m465a2 || !this.f498a.equals(ghVar.f498a)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
