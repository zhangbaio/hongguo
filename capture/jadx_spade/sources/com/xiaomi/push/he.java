package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class he implements hp<he, Object>, Serializable, Cloneable {
    private static final hw A;
    private static final hw B;
    private static final hw C;
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f679a;
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
    private static final hw m;
    private static final hw n;
    private static final hw o;
    private static final hw p;
    private static final hw q;
    private static final hw r;
    private static final hw s;
    private static final hw t;
    private static final hw u;
    private static final hw v;
    private static final hw w;
    private static final hw x;
    private static final hw y;
    private static final hw z;

    /* renamed from: a, reason: collision with other field name */
    public int f680a;

    /* renamed from: a, reason: collision with other field name */
    public long f681a;

    /* renamed from: a, reason: collision with other field name */
    public gs f682a;

    /* renamed from: a, reason: collision with other field name */
    public gt f683a;

    /* renamed from: a, reason: collision with other field name */
    public String f684a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f686a;

    /* renamed from: b, reason: collision with other field name */
    public int f688b;

    /* renamed from: b, reason: collision with other field name */
    public long f689b;

    /* renamed from: b, reason: collision with other field name */
    public String f690b;

    /* renamed from: c, reason: collision with other field name */
    public int f692c;

    /* renamed from: c, reason: collision with other field name */
    public String f693c;

    /* renamed from: d, reason: collision with other field name */
    public String f695d;

    /* renamed from: e, reason: collision with other field name */
    public String f696e;

    /* renamed from: f, reason: collision with other field name */
    public String f697f;

    /* renamed from: g, reason: collision with other field name */
    public String f698g;

    /* renamed from: h, reason: collision with other field name */
    public String f699h;

    /* renamed from: i, reason: collision with other field name */
    public String f700i;

    /* renamed from: j, reason: collision with other field name */
    public String f701j;

    /* renamed from: k, reason: collision with other field name */
    public String f702k;

    /* renamed from: l, reason: collision with other field name */
    public String f703l;

    /* renamed from: m, reason: collision with other field name */
    public String f704m;

    /* renamed from: n, reason: collision with other field name */
    public String f705n;

    /* renamed from: o, reason: collision with other field name */
    public String f706o;

    /* renamed from: p, reason: collision with other field name */
    public String f707p;

    /* renamed from: q, reason: collision with other field name */
    public String f708q;

    /* renamed from: r, reason: collision with other field name */
    public String f709r;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f685a = new BitSet(8);

    /* renamed from: a, reason: collision with other field name */
    public boolean f687a = true;

    /* renamed from: c, reason: collision with other field name */
    public boolean f694c = false;

    /* renamed from: b, reason: collision with other field name */
    public boolean f691b = false;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m560a(he heVar) {
        if (heVar == null) {
            return false;
        }
        boolean m559a = m559a();
        boolean m559a2 = heVar.m559a();
        if ((m559a || m559a2) && !(m559a && m559a2 && this.f684a.equals(heVar.f684a))) {
            return false;
        }
        boolean m561b = m561b();
        boolean m561b2 = heVar.m561b();
        if ((m561b || m561b2) && !(m561b && m561b2 && this.f683a.m511a(heVar.f683a))) {
            return false;
        }
        boolean m562c = m562c();
        boolean m562c2 = heVar.m562c();
        if ((m562c || m562c2) && !(m562c && m562c2 && this.f690b.equals(heVar.f690b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = heVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f693c.equals(heVar.f693c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = heVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f695d.equals(heVar.f695d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = heVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f696e.equals(heVar.f696e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = heVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f697f.equals(heVar.f697f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = heVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f698g.equals(heVar.f698g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = heVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f699h.equals(heVar.f699h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = heVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f700i.equals(heVar.f700i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = heVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f701j.equals(heVar.f701j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = heVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f702k.equals(heVar.f702k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = heVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f680a == heVar.f680a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = heVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f688b == heVar.f688b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = heVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f703l.equals(heVar.f703l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = heVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f704m.equals(heVar.f704m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = heVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f705n.equals(heVar.f705n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = heVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f706o.equals(heVar.f706o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = heVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f692c == heVar.f692c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = heVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f682a.equals(heVar.f682a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = heVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f687a == heVar.f687a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = heVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f681a == heVar.f681a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = heVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f689b == heVar.f689b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = heVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f707p.equals(heVar.f707p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = heVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f708q.equals(heVar.f708q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = heVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f691b == heVar.f691b)) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = heVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f686a.equals(heVar.f686a))) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = heVar.B();
        if ((B2 || B3) && !(B2 && B3 && this.f694c == heVar.f694c)) {
            return false;
        }
        boolean C2 = C();
        boolean C3 = heVar.C();
        if (C2 || C3) {
            return C2 && C3 && this.f709r.equals(heVar.f709r);
        }
        return true;
    }

    public boolean A() {
        if (this.f686a != null) {
            return true;
        }
        return false;
    }

    public boolean B() {
        return this.f685a.get(7);
    }

    public boolean C() {
        if (this.f709r != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f699h != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f700i != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f701j != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.f702k != null) {
            return true;
        }
        return false;
    }

    public boolean m() {
        return this.f685a.get(0);
    }

    public boolean n() {
        return this.f685a.get(1);
    }

    public boolean o() {
        if (this.f703l != null) {
            return true;
        }
        return false;
    }

    public boolean p() {
        if (this.f704m != null) {
            return true;
        }
        return false;
    }

    public boolean q() {
        if (this.f705n != null) {
            return true;
        }
        return false;
    }

    public boolean r() {
        if (this.f706o != null) {
            return true;
        }
        return false;
    }

    public boolean s() {
        return this.f685a.get(2);
    }

    public boolean t() {
        if (this.f682a != null) {
            return true;
        }
        return false;
    }

    public boolean u() {
        return this.f685a.get(3);
    }

    public boolean v() {
        return this.f685a.get(4);
    }

    public boolean w() {
        return this.f685a.get(5);
    }

    public boolean x() {
        if (this.f707p != null) {
            return true;
        }
        return false;
    }

    public boolean y() {
        if (this.f708q != null) {
            return true;
        }
        return false;
    }

    public boolean z() {
        return this.f685a.get(6);
    }

    public String b() {
        return this.f693c;
    }

    public String c() {
        return this.f697f;
    }

    public boolean d() {
        if (this.f693c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f695d != null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.f696e != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f697f != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f698g != null) {
            return true;
        }
        return false;
    }

    public String a() {
        return this.f690b;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m561b() {
        if (this.f683a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m562c() {
        if (this.f690b != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m558a() {
        if (this.f690b != null) {
            if (this.f693c != null) {
                if (this.f697f != null) {
                    return;
                }
                throw new ia("Required field 'token' was not present! Struct: " + toString());
            }
            throw new ia("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m559a() {
        if (this.f684a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655581);
        f679a = new ie("XmPushActionRegistration");
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
        k = new hw("", (byte) 11, (short) 11);
        l = new hw("", (byte) 11, (short) 12);
        m = new hw("", (byte) 8, (short) 13);
        n = new hw("", (byte) 8, (short) 14);
        o = new hw("", (byte) 11, (short) 15);
        p = new hw("", (byte) 11, (short) 16);
        q = new hw("", (byte) 11, (short) 17);
        r = new hw("", (byte) 11, (short) 18);
        s = new hw("", (byte) 8, (short) 19);
        t = new hw("", (byte) 8, (short) 20);
        u = new hw("", (byte) 2, (short) 21);
        v = new hw("", (byte) 10, (short) 22);
        w = new hw("", (byte) 10, (short) 23);
        x = new hw("", (byte) 11, (short) 24);
        y = new hw("", (byte) 11, (short) 25);
        z = new hw("", (byte) 2, (short) 26);
        A = new hw("", (byte) 13, (short) 100);
        B = new hw("", (byte) 2, (short) 101);
        C = new hw("", (byte) 11, (short) 102);
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = false;
        if (m559a()) {
            sb.append("debug:");
            String str = this.f684a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m561b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            gt gtVar = this.f683a;
            if (gtVar == null) {
                sb.append("null");
            } else {
                sb.append(gtVar);
            }
        } else {
            z3 = z2;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f690b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f693c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f695d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f696e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f697f;
        if (str6 == null) {
            sb.append("null");
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f698g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f699h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f700i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f701j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f702k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f680a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f688b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f703l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f704m;
            if (str13 == null) {
                sb.append("null");
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f705n;
            if (str14 == null) {
                sb.append("null");
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f706o;
            if (str15 == null) {
                sb.append("null");
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f692c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            gs gsVar = this.f682a;
            if (gsVar == null) {
                sb.append("null");
            } else {
                sb.append(gsVar);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f687a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f681a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f689b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f707p;
            if (str16 == null) {
                sb.append("null");
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f708q;
            if (str17 == null) {
                sb.append("null");
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f691b);
        }
        if (A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f686a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f694c);
        }
        if (C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f709r;
            if (str18 == null) {
                sb.append("null");
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public he a(gs gsVar) {
        this.f682a = gsVar;
        return this;
    }

    public he b(String str) {
        this.f693c = str;
        return this;
    }

    public he c(String str) {
        this.f695d = str;
        return this;
    }

    public he d(String str) {
        this.f696e = str;
        return this;
    }

    public he e(String str) {
        this.f697f = str;
        return this;
    }

    public he f(String str) {
        this.f698g = str;
        return this;
    }

    public he g(String str) {
        this.f699h = str;
        return this;
    }

    public he h(String str) {
        this.f702k = str;
        return this;
    }

    public he i(String str) {
        this.f706o = str;
        return this;
    }

    public he a(int i2) {
        this.f680a = i2;
        a(true);
        return this;
    }

    public he b(int i2) {
        this.f688b = i2;
        b(true);
        return this;
    }

    public he c(int i2) {
        this.f692c = i2;
        c(true);
        return this;
    }

    public void d(boolean z2) {
        this.f685a.set(3, z2);
    }

    public void e(boolean z2) {
        this.f685a.set(4, z2);
    }

    public void f(boolean z2) {
        this.f685a.set(5, z2);
    }

    public void g(boolean z2) {
        this.f685a.set(6, z2);
    }

    public void h(boolean z2) {
        this.f685a.set(7, z2);
    }

    public he a(String str) {
        this.f690b = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof he)) {
            return false;
        }
        return m560a((he) obj);
    }

    public void b(boolean z2) {
        this.f685a.set(1, z2);
    }

    public void c(boolean z2) {
        this.f685a.set(2, z2);
    }

    public void a(boolean z2) {
        this.f685a.set(0, z2);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                m558a();
                return;
            }
            short s2 = mo607a.f830a;
            switch (s2) {
                case 1:
                    if (b2 == 11) {
                        this.f684a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f683a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f690b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f693c = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f695d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    if (b2 == 11) {
                        this.f696e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f697f = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 11) {
                        this.f698g = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f699h = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f700i = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f701j = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    if (b2 == 11) {
                        this.f702k = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                    if (b2 == 8) {
                        this.f680a = hzVar.mo605a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 8) {
                        this.f688b = hzVar.mo605a();
                        b(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 11) {
                        this.f703l = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 11) {
                        this.f704m = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                    if (b2 == 11) {
                        this.f705n = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 18:
                    if (b2 == 11) {
                        this.f706o = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                    if (b2 == 8) {
                        this.f692c = hzVar.mo605a();
                        c(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                    if (b2 == 8) {
                        this.f682a = gs.a(hzVar.mo605a());
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                    if (b2 == 2) {
                        this.f687a = hzVar.mo617a();
                        d(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                    if (b2 == 10) {
                        this.f681a = hzVar.mo606a();
                        e(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                    if (b2 == 10) {
                        this.f689b = hzVar.mo606a();
                        f(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                    if (b2 == 11) {
                        this.f707p = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                    if (b2 == 11) {
                        this.f708q = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                    if (b2 == 2) {
                        this.f691b = hzVar.mo617a();
                        g(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                default:
                    switch (s2) {
                        case 100:
                            if (b2 == 13) {
                                hy mo609a = hzVar.mo609a();
                                this.f686a = new HashMap(mo609a.f832a * 2);
                                for (int i2 = 0; i2 < mo609a.f832a; i2++) {
                                    this.f686a.put(hzVar.mo612a(), hzVar.mo612a());
                                }
                                hzVar.h();
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 101:
                            if (b2 == 2) {
                                this.f694c = hzVar.mo617a();
                                h(true);
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 102:
                            if (b2 == 11) {
                                this.f709r = hzVar.mo612a();
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        default:
                            ic.a(hzVar, b2);
                            break;
                    }
            }
            hzVar.g();
        }
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m558a();
        hzVar.a(f679a);
        if (this.f684a != null && m559a()) {
            hzVar.a(a);
            hzVar.a(this.f684a);
            hzVar.b();
        }
        if (this.f683a != null && m561b()) {
            hzVar.a(b);
            this.f683a.b(hzVar);
            hzVar.b();
        }
        if (this.f690b != null) {
            hzVar.a(c);
            hzVar.a(this.f690b);
            hzVar.b();
        }
        if (this.f693c != null) {
            hzVar.a(d);
            hzVar.a(this.f693c);
            hzVar.b();
        }
        if (this.f695d != null && e()) {
            hzVar.a(e);
            hzVar.a(this.f695d);
            hzVar.b();
        }
        if (this.f696e != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f696e);
            hzVar.b();
        }
        if (this.f697f != null) {
            hzVar.a(g);
            hzVar.a(this.f697f);
            hzVar.b();
        }
        if (this.f698g != null && h()) {
            hzVar.a(h);
            hzVar.a(this.f698g);
            hzVar.b();
        }
        if (this.f699h != null && i()) {
            hzVar.a(i);
            hzVar.a(this.f699h);
            hzVar.b();
        }
        if (this.f700i != null && j()) {
            hzVar.a(j);
            hzVar.a(this.f700i);
            hzVar.b();
        }
        if (this.f701j != null && k()) {
            hzVar.a(k);
            hzVar.a(this.f701j);
            hzVar.b();
        }
        if (this.f702k != null && l()) {
            hzVar.a(l);
            hzVar.a(this.f702k);
            hzVar.b();
        }
        if (m()) {
            hzVar.a(m);
            hzVar.mo616a(this.f680a);
            hzVar.b();
        }
        if (n()) {
            hzVar.a(n);
            hzVar.mo616a(this.f688b);
            hzVar.b();
        }
        if (this.f703l != null && o()) {
            hzVar.a(o);
            hzVar.a(this.f703l);
            hzVar.b();
        }
        if (this.f704m != null && p()) {
            hzVar.a(p);
            hzVar.a(this.f704m);
            hzVar.b();
        }
        if (this.f705n != null && q()) {
            hzVar.a(q);
            hzVar.a(this.f705n);
            hzVar.b();
        }
        if (this.f706o != null && r()) {
            hzVar.a(r);
            hzVar.a(this.f706o);
            hzVar.b();
        }
        if (s()) {
            hzVar.a(s);
            hzVar.mo616a(this.f692c);
            hzVar.b();
        }
        if (this.f682a != null && t()) {
            hzVar.a(t);
            hzVar.mo616a(this.f682a.a());
            hzVar.b();
        }
        if (u()) {
            hzVar.a(u);
            hzVar.a(this.f687a);
            hzVar.b();
        }
        if (v()) {
            hzVar.a(v);
            hzVar.a(this.f681a);
            hzVar.b();
        }
        if (w()) {
            hzVar.a(w);
            hzVar.a(this.f689b);
            hzVar.b();
        }
        if (this.f707p != null && x()) {
            hzVar.a(x);
            hzVar.a(this.f707p);
            hzVar.b();
        }
        if (this.f708q != null && y()) {
            hzVar.a(y);
            hzVar.a(this.f708q);
            hzVar.b();
        }
        if (z()) {
            hzVar.a(z);
            hzVar.a(this.f691b);
            hzVar.b();
        }
        if (this.f686a != null && A()) {
            hzVar.a(A);
            hzVar.a(new hy((byte) 11, (byte) 11, this.f686a.size()));
            for (Map.Entry<String, String> entry : this.f686a.entrySet()) {
                hzVar.a(entry.getKey());
                hzVar.a(entry.getValue());
            }
            hzVar.d();
            hzVar.b();
        }
        if (B()) {
            hzVar.a(B);
            hzVar.a(this.f694c);
            hzVar.b();
        }
        if (this.f709r != null && C()) {
            hzVar.a(C);
            hzVar.a(this.f709r);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(he heVar) {
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
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        int a20;
        int a21;
        int a22;
        int a23;
        int a24;
        int a25;
        int a26;
        int a27;
        int a28;
        int a29;
        int a30;
        if (!getClass().equals(heVar.getClass())) {
            return getClass().getName().compareTo(heVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m559a()).compareTo(Boolean.valueOf(heVar.m559a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m559a() && (a30 = hq.a(this.f684a, heVar.f684a)) != 0) {
            return a30;
        }
        int compareTo2 = Boolean.valueOf(m561b()).compareTo(Boolean.valueOf(heVar.m561b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m561b() && (a29 = hq.a(this.f683a, heVar.f683a)) != 0) {
            return a29;
        }
        int compareTo3 = Boolean.valueOf(m562c()).compareTo(Boolean.valueOf(heVar.m562c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m562c() && (a28 = hq.a(this.f690b, heVar.f690b)) != 0) {
            return a28;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(heVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a27 = hq.a(this.f693c, heVar.f693c)) != 0) {
            return a27;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(heVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a26 = hq.a(this.f695d, heVar.f695d)) != 0) {
            return a26;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(heVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a25 = hq.a(this.f696e, heVar.f696e)) != 0) {
            return a25;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(heVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a24 = hq.a(this.f697f, heVar.f697f)) != 0) {
            return a24;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(heVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a23 = hq.a(this.f698g, heVar.f698g)) != 0) {
            return a23;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(heVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a22 = hq.a(this.f699h, heVar.f699h)) != 0) {
            return a22;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(heVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a21 = hq.a(this.f700i, heVar.f700i)) != 0) {
            return a21;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(heVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a20 = hq.a(this.f701j, heVar.f701j)) != 0) {
            return a20;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(heVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a19 = hq.a(this.f702k, heVar.f702k)) != 0) {
            return a19;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(heVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a18 = hq.a(this.f680a, heVar.f680a)) != 0) {
            return a18;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(heVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a17 = hq.a(this.f688b, heVar.f688b)) != 0) {
            return a17;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(heVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a16 = hq.a(this.f703l, heVar.f703l)) != 0) {
            return a16;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(heVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a15 = hq.a(this.f704m, heVar.f704m)) != 0) {
            return a15;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(heVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a14 = hq.a(this.f705n, heVar.f705n)) != 0) {
            return a14;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(heVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a13 = hq.a(this.f706o, heVar.f706o)) != 0) {
            return a13;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(heVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a12 = hq.a(this.f692c, heVar.f692c)) != 0) {
            return a12;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(heVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (t() && (a11 = hq.a(this.f682a, heVar.f682a)) != 0) {
            return a11;
        }
        int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(heVar.u()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (u() && (a10 = hq.a(this.f687a, heVar.f687a)) != 0) {
            return a10;
        }
        int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(heVar.v()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (v() && (a9 = hq.a(this.f681a, heVar.f681a)) != 0) {
            return a9;
        }
        int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(heVar.w()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (w() && (a8 = hq.a(this.f689b, heVar.f689b)) != 0) {
            return a8;
        }
        int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(heVar.x()));
        if (compareTo24 != 0) {
            return compareTo24;
        }
        if (x() && (a7 = hq.a(this.f707p, heVar.f707p)) != 0) {
            return a7;
        }
        int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(heVar.y()));
        if (compareTo25 != 0) {
            return compareTo25;
        }
        if (y() && (a6 = hq.a(this.f708q, heVar.f708q)) != 0) {
            return a6;
        }
        int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(heVar.z()));
        if (compareTo26 != 0) {
            return compareTo26;
        }
        if (z() && (a5 = hq.a(this.f691b, heVar.f691b)) != 0) {
            return a5;
        }
        int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(heVar.A()));
        if (compareTo27 != 0) {
            return compareTo27;
        }
        if (A() && (a4 = hq.a(this.f686a, heVar.f686a)) != 0) {
            return a4;
        }
        int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(heVar.B()));
        if (compareTo28 != 0) {
            return compareTo28;
        }
        if (B() && (a3 = hq.a(this.f694c, heVar.f694c)) != 0) {
            return a3;
        }
        int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(heVar.C()));
        if (compareTo29 != 0) {
            return compareTo29;
        }
        if (C() && (a2 = hq.a(this.f709r, heVar.f709r)) != 0) {
            return a2;
        }
        return 0;
    }
}
