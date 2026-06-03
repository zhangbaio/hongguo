package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hj implements hp<hj, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f764a;
    private static final hw b;
    private static final hw c;
    private static final hw d;
    private static final hw e;
    private static final hw f;
    private static final hw g;
    private static final hw h;
    private static final hw i;

    /* renamed from: a, reason: collision with other field name */
    public long f765a;

    /* renamed from: a, reason: collision with other field name */
    public gt f766a;

    /* renamed from: a, reason: collision with other field name */
    public String f767a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f768a = new BitSet(1);

    /* renamed from: b, reason: collision with other field name */
    public String f769b;

    /* renamed from: c, reason: collision with other field name */
    public String f770c;

    /* renamed from: d, reason: collision with other field name */
    public String f771d;

    /* renamed from: e, reason: collision with other field name */
    public String f772e;

    /* renamed from: f, reason: collision with other field name */
    public String f773f;

    /* renamed from: g, reason: collision with other field name */
    public String f774g;

    public int hashCode() {
        return 0;
    }

    public String a() {
        return this.f769b;
    }

    public String b() {
        return this.f772e;
    }

    public String c() {
        return this.f774g;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m586b() {
        if (this.f766a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m587c() {
        if (this.f769b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f770c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f768a.get(0);
    }

    public boolean f() {
        if (this.f771d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f772e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f773f != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f774g != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m584a() {
        if (this.f767a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m583a() {
        if (this.f769b != null) {
            return;
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    static {
        Covode.recordClassIndex(655586);
        f764a = new ie("XmPushActionSubscriptionResult");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 12, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 10, (short) 6);
        f = new hw("", (byte) 11, (short) 7);
        g = new hw("", (byte) 11, (short) 8);
        h = new hw("", (byte) 11, (short) 9);
        i = new hw("", (byte) 11, (short) 10);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (m584a()) {
            sb.append("debug:");
            String str = this.f767a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m586b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gt gtVar = this.f766a;
            if (gtVar == null) {
                sb.append("null");
            } else {
                sb.append(gtVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f769b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f770c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f765a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f771d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f772e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f773f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f774g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f768a.set(0, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hj)) {
            return false;
        }
        return m585a((hj) obj);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                m583a();
                return;
            }
            switch (mo607a.f830a) {
                case 1:
                    if (b2 == 11) {
                        this.f767a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f766a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f769b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f770c = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                default:
                    ic.a(hzVar, b2);
                    break;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    if (b2 == 10) {
                        this.f765a = hzVar.mo606a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f771d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 11) {
                        this.f772e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f773f = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f774g = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
            }
            hzVar.g();
        }
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m583a();
        hzVar.a(f764a);
        if (this.f767a != null && m584a()) {
            hzVar.a(a);
            hzVar.a(this.f767a);
            hzVar.b();
        }
        if (this.f766a != null && m586b()) {
            hzVar.a(b);
            this.f766a.b(hzVar);
            hzVar.b();
        }
        if (this.f769b != null) {
            hzVar.a(c);
            hzVar.a(this.f769b);
            hzVar.b();
        }
        if (this.f770c != null && d()) {
            hzVar.a(d);
            hzVar.a(this.f770c);
            hzVar.b();
        }
        if (e()) {
            hzVar.a(e);
            hzVar.a(this.f765a);
            hzVar.b();
        }
        if (this.f771d != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f771d);
            hzVar.b();
        }
        if (this.f772e != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f772e);
            hzVar.b();
        }
        if (this.f773f != null && h()) {
            hzVar.a(h);
            hzVar.a(this.f773f);
            hzVar.b();
        }
        if (this.f774g != null && i()) {
            hzVar.a(i);
            hzVar.a(this.f774g);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hj hjVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!getClass().equals(hjVar.getClass())) {
            return getClass().getName().compareTo(hjVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m584a()).compareTo(Boolean.valueOf(hjVar.m584a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m584a() && (a10 = hq.a(this.f767a, hjVar.f767a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(m586b()).compareTo(Boolean.valueOf(hjVar.m586b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m586b() && (a9 = hq.a(this.f766a, hjVar.f766a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(m587c()).compareTo(Boolean.valueOf(hjVar.m587c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m587c() && (a8 = hq.a(this.f769b, hjVar.f769b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hjVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = hq.a(this.f770c, hjVar.f770c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hjVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = hq.a(this.f765a, hjVar.f765a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hjVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = hq.a(this.f771d, hjVar.f771d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hjVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = hq.a(this.f772e, hjVar.f772e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hjVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = hq.a(this.f773f, hjVar.f773f)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hjVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a2 = hq.a(this.f774g, hjVar.f774g)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m585a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean m584a = m584a();
        boolean m584a2 = hjVar.m584a();
        if ((m584a || m584a2) && (!m584a || !m584a2 || !this.f767a.equals(hjVar.f767a))) {
            return false;
        }
        boolean m586b = m586b();
        boolean m586b2 = hjVar.m586b();
        if ((m586b || m586b2) && (!m586b || !m586b2 || !this.f766a.m511a(hjVar.f766a))) {
            return false;
        }
        boolean m587c = m587c();
        boolean m587c2 = hjVar.m587c();
        if ((m587c || m587c2) && (!m587c || !m587c2 || !this.f769b.equals(hjVar.f769b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hjVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f770c.equals(hjVar.f770c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hjVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f765a != hjVar.f765a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hjVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f771d.equals(hjVar.f771d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hjVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f772e.equals(hjVar.f772e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hjVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f773f.equals(hjVar.f773f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hjVar.i();
        if (i2 || i3) {
            if (!i2 || !i3 || !this.f774g.equals(hjVar.f774g)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
