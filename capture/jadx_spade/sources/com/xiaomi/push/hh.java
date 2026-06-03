package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hh implements hp<hh, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f741a;
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
    public gq f742a;

    /* renamed from: a, reason: collision with other field name */
    public gt f743a;

    /* renamed from: a, reason: collision with other field name */
    public String f744a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f746a;

    /* renamed from: b, reason: collision with other field name */
    public String f748b;

    /* renamed from: c, reason: collision with other field name */
    public String f749c;

    /* renamed from: d, reason: collision with other field name */
    public String f750d;

    /* renamed from: e, reason: collision with other field name */
    public String f751e;

    /* renamed from: f, reason: collision with other field name */
    public String f752f;

    /* renamed from: g, reason: collision with other field name */
    public String f753g;

    /* renamed from: h, reason: collision with other field name */
    public String f754h;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f745a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public boolean f747a = true;

    public int hashCode() {
        return 0;
    }

    public gq a() {
        return this.f742a;
    }

    public String b() {
        return this.f749c;
    }

    public String c() {
        return this.f751e;
    }

    public String d() {
        return this.f752f;
    }

    public String e() {
        return this.f753g;
    }

    public String f() {
        return this.f754h;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m572a() {
        return this.f748b;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m576b() {
        if (this.f743a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m577c() {
        if (this.f748b != null) {
            return true;
        }
        return false;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m578d() {
        if (this.f749c != null) {
            return true;
        }
        return false;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m579e() {
        if (this.f750d != null) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m580f() {
        if (this.f751e != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f752f != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f742a != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        return this.f745a.get(0);
    }

    public boolean j() {
        if (this.f746a != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f753g != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.f754h != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m574a() {
        if (this.f744a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m573a() {
        if (this.f748b != null) {
            if (this.f749c != null) {
                return;
            }
            throw new ia("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    static {
        Covode.recordClassIndex(655584);
        f741a = new ie("XmPushActionSendMessage");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 12, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 11, (short) 5);
        f = new hw("", (byte) 11, (short) 6);
        g = new hw("", (byte) 11, (short) 7);
        h = new hw("", (byte) 12, (short) 8);
        i = new hw("", (byte) 2, (short) 9);
        j = new hw("", (byte) 13, (short) 10);
        k = new hw("", (byte) 11, (short) 11);
        l = new hw("", (byte) 11, (short) 12);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m574a()) {
            sb.append("debug:");
            String str = this.f744a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m576b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gt gtVar = this.f743a;
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
        String str2 = this.f748b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f749c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (m579e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f750d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m580f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f751e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f752f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            gq gqVar = this.f742a;
            if (gqVar == null) {
                sb.append("null");
            } else {
                sb.append(gqVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f747a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f746a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f753g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f754h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f745a.set(0, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hh)) {
            return false;
        }
        return m575a((hh) obj);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                m573a();
                return;
            }
            switch (mo607a.f830a) {
                case 1:
                    if (b2 == 11) {
                        this.f744a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f743a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f748b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f749c = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f750d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    if (b2 == 11) {
                        this.f751e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f752f = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 12) {
                        gq gqVar = new gq();
                        this.f742a = gqVar;
                        gqVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 2) {
                        this.f747a = hzVar.mo617a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 13) {
                        hy mo609a = hzVar.mo609a();
                        this.f746a = new HashMap(mo609a.f832a * 2);
                        for (int i2 = 0; i2 < mo609a.f832a; i2++) {
                            this.f746a.put(hzVar.mo612a(), hzVar.mo612a());
                        }
                        hzVar.h();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f753g = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    if (b2 == 11) {
                        this.f754h = hzVar.mo612a();
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
        m573a();
        hzVar.a(f741a);
        if (this.f744a != null && m574a()) {
            hzVar.a(a);
            hzVar.a(this.f744a);
            hzVar.b();
        }
        if (this.f743a != null && m576b()) {
            hzVar.a(b);
            this.f743a.b(hzVar);
            hzVar.b();
        }
        if (this.f748b != null) {
            hzVar.a(c);
            hzVar.a(this.f748b);
            hzVar.b();
        }
        if (this.f749c != null) {
            hzVar.a(d);
            hzVar.a(this.f749c);
            hzVar.b();
        }
        if (this.f750d != null && m579e()) {
            hzVar.a(e);
            hzVar.a(this.f750d);
            hzVar.b();
        }
        if (this.f751e != null && m580f()) {
            hzVar.a(f);
            hzVar.a(this.f751e);
            hzVar.b();
        }
        if (this.f752f != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f752f);
            hzVar.b();
        }
        if (this.f742a != null && h()) {
            hzVar.a(h);
            this.f742a.b(hzVar);
            hzVar.b();
        }
        if (i()) {
            hzVar.a(i);
            hzVar.a(this.f747a);
            hzVar.b();
        }
        if (this.f746a != null && j()) {
            hzVar.a(j);
            hzVar.a(new hy((byte) 11, (byte) 11, this.f746a.size()));
            for (Map.Entry<String, String> entry : this.f746a.entrySet()) {
                hzVar.a(entry.getKey());
                hzVar.a(entry.getValue());
            }
            hzVar.d();
            hzVar.b();
        }
        if (this.f753g != null && k()) {
            hzVar.a(k);
            hzVar.a(this.f753g);
            hzVar.b();
        }
        if (this.f754h != null && l()) {
            hzVar.a(l);
            hzVar.a(this.f754h);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hh hhVar) {
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
        if (!getClass().equals(hhVar.getClass())) {
            return getClass().getName().compareTo(hhVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m574a()).compareTo(Boolean.valueOf(hhVar.m574a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m574a() && (a13 = hq.a(this.f744a, hhVar.f744a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(m576b()).compareTo(Boolean.valueOf(hhVar.m576b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m576b() && (a12 = hq.a(this.f743a, hhVar.f743a)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(m577c()).compareTo(Boolean.valueOf(hhVar.m577c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m577c() && (a11 = hq.a(this.f748b, hhVar.f748b)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(m578d()).compareTo(Boolean.valueOf(hhVar.m578d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m578d() && (a10 = hq.a(this.f749c, hhVar.f749c)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(m579e()).compareTo(Boolean.valueOf(hhVar.m579e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m579e() && (a9 = hq.a(this.f750d, hhVar.f750d)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(m580f()).compareTo(Boolean.valueOf(hhVar.m580f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m580f() && (a8 = hq.a(this.f751e, hhVar.f751e)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hhVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a7 = hq.a(this.f752f, hhVar.f752f)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hhVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a6 = hq.a(this.f742a, hhVar.f742a)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hhVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a5 = hq.a(this.f747a, hhVar.f747a)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hhVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a4 = hq.a(this.f746a, hhVar.f746a)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hhVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a3 = hq.a(this.f753g, hhVar.f753g)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hhVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a2 = hq.a(this.f754h, hhVar.f754h)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m575a(hh hhVar) {
        if (hhVar == null) {
            return false;
        }
        boolean m574a = m574a();
        boolean m574a2 = hhVar.m574a();
        if ((m574a || m574a2) && (!m574a || !m574a2 || !this.f744a.equals(hhVar.f744a))) {
            return false;
        }
        boolean m576b = m576b();
        boolean m576b2 = hhVar.m576b();
        if ((m576b || m576b2) && (!m576b || !m576b2 || !this.f743a.m511a(hhVar.f743a))) {
            return false;
        }
        boolean m577c = m577c();
        boolean m577c2 = hhVar.m577c();
        if ((m577c || m577c2) && (!m577c || !m577c2 || !this.f748b.equals(hhVar.f748b))) {
            return false;
        }
        boolean m578d = m578d();
        boolean m578d2 = hhVar.m578d();
        if ((m578d || m578d2) && (!m578d || !m578d2 || !this.f749c.equals(hhVar.f749c))) {
            return false;
        }
        boolean m579e = m579e();
        boolean m579e2 = hhVar.m579e();
        if ((m579e || m579e2) && (!m579e || !m579e2 || !this.f750d.equals(hhVar.f750d))) {
            return false;
        }
        boolean m580f = m580f();
        boolean m580f2 = hhVar.m580f();
        if ((m580f || m580f2) && (!m580f || !m580f2 || !this.f751e.equals(hhVar.f751e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hhVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f752f.equals(hhVar.f752f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hhVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f742a.m494a(hhVar.f742a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hhVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f747a != hhVar.f747a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hhVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f746a.equals(hhVar.f746a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hhVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f753g.equals(hhVar.f753g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hhVar.l();
        if (l2 || l3) {
            if (!l2 || !l3 || !this.f754h.equals(hhVar.f754h)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
