package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gp implements hp<gp, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f530a;
    private static final hw b;
    private static final hw c;
    private static final hw d;
    private static final hw e;
    private static final hw f;
    private static final hw g;

    /* renamed from: a, reason: collision with other field name */
    public int f531a;

    /* renamed from: a, reason: collision with other field name */
    public long f532a;

    /* renamed from: a, reason: collision with other field name */
    public String f533a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f534a = new BitSet(6);

    /* renamed from: a, reason: collision with other field name */
    public boolean f535a;

    /* renamed from: b, reason: collision with other field name */
    public int f536b;

    /* renamed from: b, reason: collision with other field name */
    public boolean f537b;

    /* renamed from: c, reason: collision with other field name */
    public int f538c;

    /* renamed from: a, reason: collision with other method in class */
    public void m486a() {
    }

    public int hashCode() {
        return 0;
    }

    public int a() {
        return this.f531a;
    }

    public int b() {
        return this.f536b;
    }

    public int c() {
        return this.f538c;
    }

    public boolean g() {
        return this.f537b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m484a() {
        return this.f532a;
    }

    public boolean h() {
        return this.f534a.get(5);
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m485a() {
        return this.f533a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m489b() {
        return this.f534a.get(1);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m490c() {
        return this.f534a.get(2);
    }

    public boolean d() {
        return this.f534a.get(3);
    }

    public boolean e() {
        return this.f534a.get(4);
    }

    public boolean f() {
        if (this.f533a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655565);
        f530a = new ie("OnlineConfigItem");
        a = new hw("", (byte) 8, (short) 1);
        b = new hw("", (byte) 8, (short) 2);
        c = new hw("", (byte) 2, (short) 3);
        d = new hw("", (byte) 8, (short) 4);
        e = new hw("", (byte) 10, (short) 5);
        f = new hw("", (byte) 11, (short) 6);
        g = new hw("", (byte) 2, (short) 7);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m487a() {
        return this.f534a.get(0);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (m487a()) {
            sb.append("key:");
            sb.append(this.f531a);
            z = false;
        } else {
            z = true;
        }
        if (m489b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f536b);
            z = false;
        }
        if (m490c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f535a);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f538c);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f532a);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f533a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        } else {
            z2 = z;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f537b);
        }
        sb.append(")");
        return sb.toString();
    }

    public void b(boolean z) {
        this.f534a.set(1, z);
    }

    public void c(boolean z) {
        this.f534a.set(2, z);
    }

    public void d(boolean z) {
        this.f534a.set(3, z);
    }

    public void e(boolean z) {
        this.f534a.set(4, z);
    }

    public void f(boolean z) {
        this.f534a.set(5, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gp)) {
            return false;
        }
        return m488a((gp) obj);
    }

    public void a(boolean z) {
        this.f534a.set(0, z);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                m486a();
                return;
            }
            switch (mo607a.f830a) {
                case 1:
                    if (b2 == 8) {
                        this.f531a = hzVar.mo605a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 8) {
                        this.f536b = hzVar.mo605a();
                        b(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 2) {
                        this.f535a = hzVar.mo617a();
                        c(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 8) {
                        this.f538c = hzVar.mo605a();
                        d(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f532a = hzVar.mo606a();
                        e(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    if (b2 == 11) {
                        this.f533a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 2) {
                        this.f537b = hzVar.mo617a();
                        f(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                default:
                    ic.a(hzVar, b2);
                    break;
            }
            hzVar.g();
        }
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m486a();
        hzVar.a(f530a);
        if (m487a()) {
            hzVar.a(a);
            hzVar.mo616a(this.f531a);
            hzVar.b();
        }
        if (m489b()) {
            hzVar.a(b);
            hzVar.mo616a(this.f536b);
            hzVar.b();
        }
        if (m490c()) {
            hzVar.a(c);
            hzVar.a(this.f535a);
            hzVar.b();
        }
        if (d()) {
            hzVar.a(d);
            hzVar.mo616a(this.f538c);
            hzVar.b();
        }
        if (e()) {
            hzVar.a(e);
            hzVar.a(this.f532a);
            hzVar.b();
        }
        if (this.f533a != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f533a);
            hzVar.b();
        }
        if (h()) {
            hzVar.a(g);
            hzVar.a(this.f537b);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gp gpVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(gpVar.getClass())) {
            return getClass().getName().compareTo(gpVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m487a()).compareTo(Boolean.valueOf(gpVar.m487a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m487a() && (a8 = hq.a(this.f531a, gpVar.f531a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(m489b()).compareTo(Boolean.valueOf(gpVar.m489b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m489b() && (a7 = hq.a(this.f536b, gpVar.f536b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(m490c()).compareTo(Boolean.valueOf(gpVar.m490c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m490c() && (a6 = hq.a(this.f535a, gpVar.f535a)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gpVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a5 = hq.a(this.f538c, gpVar.f538c)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gpVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a4 = hq.a(this.f532a, gpVar.f532a)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gpVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a3 = hq.a(this.f533a, gpVar.f533a)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gpVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a2 = hq.a(this.f537b, gpVar.f537b)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m488a(gp gpVar) {
        if (gpVar == null) {
            return false;
        }
        boolean m487a = m487a();
        boolean m487a2 = gpVar.m487a();
        if ((m487a || m487a2) && (!m487a || !m487a2 || this.f531a != gpVar.f531a)) {
            return false;
        }
        boolean m489b = m489b();
        boolean m489b2 = gpVar.m489b();
        if ((m489b || m489b2) && (!m489b || !m489b2 || this.f536b != gpVar.f536b)) {
            return false;
        }
        boolean m490c = m490c();
        boolean m490c2 = gpVar.m490c();
        if ((m490c || m490c2) && (!m490c || !m490c2 || this.f535a != gpVar.f535a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gpVar.d();
        if ((d2 || d3) && (!d2 || !d3 || this.f538c != gpVar.f538c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = gpVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f532a != gpVar.f532a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gpVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f533a.equals(gpVar.f533a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = gpVar.h();
        if (h || h2) {
            if (!h || !h2 || this.f537b != gpVar.f537b) {
                return false;
            }
            return true;
        }
        return true;
    }
}
