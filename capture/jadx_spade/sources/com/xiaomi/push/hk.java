package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hk implements hp<hk, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f775a;
    private static final hw b;
    private static final hw c;
    private static final hw d;
    private static final hw e;
    private static final hw f;
    private static final hw g;
    private static final hw h;
    private static final hw i;
    private static final hw j;
    private static final hw k;
    private static final hw l;

    /* renamed from: a, reason: collision with other field name */
    public long f776a;

    /* renamed from: a, reason: collision with other field name */
    public gt f777a;

    /* renamed from: a, reason: collision with other field name */
    public String f778a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f779a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f780a = true;

    /* renamed from: b, reason: collision with other field name */
    public String f781b;

    /* renamed from: c, reason: collision with other field name */
    public String f782c;

    /* renamed from: d, reason: collision with other field name */
    public String f783d;

    /* renamed from: e, reason: collision with other field name */
    public String f784e;

    /* renamed from: f, reason: collision with other field name */
    public String f785f;

    /* renamed from: g, reason: collision with other field name */
    public String f786g;

    /* renamed from: h, reason: collision with other field name */
    public String f787h;

    /* renamed from: i, reason: collision with other field name */
    public String f788i;

    public int hashCode() {
        return 0;
    }

    public boolean c() {
        if (this.f781b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f782c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f783d != null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.f784e != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f785f != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f786g != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f787h != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f788i != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        return this.f779a.get(0);
    }

    public boolean l() {
        return this.f779a.get(1);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m588a() {
        if (this.f778a != null) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f777a != null) {
            return true;
        }
        return false;
    }

    public void a() {
        if (this.f781b != null) {
            if (this.f782c != null) {
                return;
            }
            throw new ia("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    static {
        Covode.recordClassIndex(655587);
        f775a = new ie("XmPushActionUnRegistration");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 12, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 11, (short) 5);
        f = new hw("", (byte) 11, (short) 6);
        g = new hw("", (byte) 11, (short) 7);
        h = new hw("", (byte) 11, (short) 8);
        i = new hw("", (byte) 11, (short) 9);
        j = new hw("", (byte) 11, (short) 10);
        k = new hw("", (byte) 2, (short) 11);
        l = new hw("", (byte) 10, (short) 12);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = false;
        if (m588a()) {
            sb.append("debug:");
            String str = this.f778a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gt gtVar = this.f777a;
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
        String str2 = this.f781b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f782c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f783d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f784e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f785f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f786g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f787h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f788i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f780a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f776a);
        }
        sb.append(")");
        return sb.toString();
    }

    public hk a(String str) {
        this.f781b = str;
        return this;
    }

    public hk b(String str) {
        this.f782c = str;
        return this;
    }

    public hk c(String str) {
        this.f783d = str;
        return this;
    }

    public hk d(String str) {
        this.f785f = str;
        return this;
    }

    public hk e(String str) {
        this.f786g = str;
        return this;
    }

    public void a(boolean z) {
        this.f779a.set(0, z);
    }

    public void b(boolean z) {
        this.f779a.set(1, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hk)) {
            return false;
        }
        return m589a((hk) obj);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                a();
                return;
            }
            switch (mo607a.f830a) {
                case 1:
                    if (b2 == 11) {
                        this.f778a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f777a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f781b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f782c = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f783d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    if (b2 == 11) {
                        this.f784e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f785f = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 11) {
                        this.f786g = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f787h = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f788i = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f780a = hzVar.mo617a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    if (b2 == 10) {
                        this.f776a = hzVar.mo606a();
                        b(true);
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

    /* renamed from: a, reason: collision with other method in class */
    public boolean m589a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m588a = m588a();
        boolean m588a2 = hkVar.m588a();
        if ((m588a || m588a2) && (!m588a || !m588a2 || !this.f778a.equals(hkVar.f778a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hkVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f777a.m511a(hkVar.f777a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hkVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f781b.equals(hkVar.f781b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hkVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f782c.equals(hkVar.f782c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hkVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f783d.equals(hkVar.f783d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hkVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f784e.equals(hkVar.f784e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hkVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f785f.equals(hkVar.f785f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hkVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f786g.equals(hkVar.f786g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hkVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f787h.equals(hkVar.f787h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hkVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f788i.equals(hkVar.f788i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hkVar.k();
        if ((k2 || k3) && (!k2 || !k3 || this.f780a != hkVar.f780a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hkVar.l();
        if (l2 || l3) {
            if (!l2 || !l3 || this.f776a != hkVar.f776a) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        a();
        hzVar.a(f775a);
        if (this.f778a != null && m588a()) {
            hzVar.a(a);
            hzVar.a(this.f778a);
            hzVar.b();
        }
        if (this.f777a != null && b()) {
            hzVar.a(b);
            this.f777a.b(hzVar);
            hzVar.b();
        }
        if (this.f781b != null) {
            hzVar.a(c);
            hzVar.a(this.f781b);
            hzVar.b();
        }
        if (this.f782c != null) {
            hzVar.a(d);
            hzVar.a(this.f782c);
            hzVar.b();
        }
        if (this.f783d != null && e()) {
            hzVar.a(e);
            hzVar.a(this.f783d);
            hzVar.b();
        }
        if (this.f784e != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f784e);
            hzVar.b();
        }
        if (this.f785f != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f785f);
            hzVar.b();
        }
        if (this.f786g != null && h()) {
            hzVar.a(h);
            hzVar.a(this.f786g);
            hzVar.b();
        }
        if (this.f787h != null && i()) {
            hzVar.a(i);
            hzVar.a(this.f787h);
            hzVar.b();
        }
        if (this.f788i != null && j()) {
            hzVar.a(j);
            hzVar.a(this.f788i);
            hzVar.b();
        }
        if (k()) {
            hzVar.a(k);
            hzVar.a(this.f780a);
            hzVar.b();
        }
        if (l()) {
            hzVar.a(l);
            hzVar.a(this.f776a);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hk hkVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        if (!getClass().equals(hkVar.getClass())) {
            return getClass().getName().compareTo(hkVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m588a()).compareTo(Boolean.valueOf(hkVar.m588a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m588a() && (a13 = hq.a(this.f778a, hkVar.f778a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hkVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a12 = hq.a(this.f777a, hkVar.f777a)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hkVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a11 = hq.a(this.f781b, hkVar.f781b)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hkVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a10 = hq.a(this.f782c, hkVar.f782c)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hkVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a9 = hq.a(this.f783d, hkVar.f783d)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a8 = hq.a(this.f784e, hkVar.f784e)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a7 = hq.a(this.f785f, hkVar.f785f)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a6 = hq.a(this.f786g, hkVar.f786g)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hkVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a5 = hq.a(this.f787h, hkVar.f787h)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hkVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a4 = hq.a(this.f788i, hkVar.f788i)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hkVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a3 = hq.a(this.f780a, hkVar.f780a)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hkVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a2 = hq.a(this.f776a, hkVar.f776a)) != 0) {
            return a2;
        }
        return 0;
    }
}
