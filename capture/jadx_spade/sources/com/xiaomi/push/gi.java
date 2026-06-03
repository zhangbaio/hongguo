package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gi implements hp<gi, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f499a;
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

    /* renamed from: a, reason: collision with other field name */
    public long f500a;

    /* renamed from: a, reason: collision with other field name */
    public String f501a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f502a = new BitSet(3);

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f503a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f504a;

    /* renamed from: b, reason: collision with other field name */
    public long f505b;

    /* renamed from: b, reason: collision with other field name */
    public String f506b;

    /* renamed from: c, reason: collision with other field name */
    public String f507c;

    /* renamed from: d, reason: collision with other field name */
    public String f508d;

    /* renamed from: e, reason: collision with other field name */
    public String f509e;

    /* renamed from: f, reason: collision with other field name */
    public String f510f;

    /* renamed from: g, reason: collision with other field name */
    public String f511g;

    /* renamed from: a, reason: collision with other method in class */
    public void m469a() {
    }

    public int hashCode() {
        return 0;
    }

    public long a() {
        return this.f505b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m471a() {
        return this.f501a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m470a(boolean z) {
        this.f502a.set(0, z);
    }

    public void a(String str, String str2) {
        if (this.f503a == null) {
            this.f503a = new HashMap();
        }
        this.f503a.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m472a(gi giVar) {
        if (giVar == null) {
            return false;
        }
        boolean m471a = m471a();
        boolean m471a2 = giVar.m471a();
        if ((m471a || m471a2) && !(m471a && m471a2 && this.f501a.equals(giVar.f501a))) {
            return false;
        }
        boolean m473b = m473b();
        boolean m473b2 = giVar.m473b();
        if ((m473b || m473b2) && !(m473b && m473b2 && this.f506b.equals(giVar.f506b))) {
            return false;
        }
        boolean m474c = m474c();
        boolean m474c2 = giVar.m474c();
        if ((m474c || m474c2) && !(m474c && m474c2 && this.f507c.equals(giVar.f507c))) {
            return false;
        }
        boolean m475d = m475d();
        boolean m475d2 = giVar.m475d();
        if ((m475d || m475d2) && !(m475d && m475d2 && this.f500a == giVar.f500a)) {
            return false;
        }
        boolean m476e = m476e();
        boolean m476e2 = giVar.m476e();
        if ((m476e || m476e2) && !(m476e && m476e2 && this.f505b == giVar.f505b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = giVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f504a == giVar.f504a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = giVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f508d.equals(giVar.f508d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = giVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f509e.equals(giVar.f509e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = giVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f510f.equals(giVar.f510f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = giVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f503a.equals(giVar.f503a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = giVar.k();
        if (k2 || k3) {
            return k2 && k3 && this.f511g.equals(giVar.f511g);
        }
        return true;
    }

    public String c() {
        return this.f509e;
    }

    public String d() {
        return this.f510f;
    }

    public String e() {
        return this.f511g;
    }

    public boolean f() {
        return this.f502a.get(2);
    }

    public boolean g() {
        if (this.f508d != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f509e != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f510f != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f503a != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f511g != null) {
            return true;
        }
        return false;
    }

    public String b() {
        return this.f507c;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m475d() {
        return this.f502a.get(0);
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m476e() {
        return this.f502a.get(1);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m474c() {
        if (this.f507c != null) {
            return true;
        }
        return false;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m473b() {
        if (this.f506b != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655558);
        f499a = new ie("ClientUploadDataItem");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 11, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 10, (short) 4);
        e = new hw("", (byte) 10, (short) 5);
        f = new hw("", (byte) 2, (short) 6);
        g = new hw("", (byte) 11, (short) 7);
        h = new hw("", (byte) 11, (short) 8);
        i = new hw("", (byte) 11, (short) 9);
        j = new hw("", (byte) 13, (short) 10);
        k = new hw("", (byte) 11, (short) 11);
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m467a() {
        return this.f501a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m468a() {
        return this.f503a;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (m471a()) {
            sb.append("channel:");
            String str = this.f501a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m473b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f506b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m474c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f507c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m475d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f500a);
            z = false;
        }
        if (m476e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f505b);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f504a);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f508d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f509e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f510f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f503a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        } else {
            z2 = z;
        }
        if (k()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f511g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public gi b(String str) {
        this.f506b = str;
        return this;
    }

    public gi c(String str) {
        this.f507c = str;
        return this;
    }

    public gi d(String str) {
        this.f508d = str;
        return this;
    }

    public gi e(String str) {
        this.f509e = str;
        return this;
    }

    public gi f(String str) {
        this.f510f = str;
        return this;
    }

    public gi g(String str) {
        this.f511g = str;
        return this;
    }

    public gi a(long j2) {
        this.f500a = j2;
        m470a(true);
        return this;
    }

    public gi b(long j2) {
        this.f505b = j2;
        b(true);
        return this;
    }

    public gi a(String str) {
        this.f501a = str;
        return this;
    }

    public void c(boolean z) {
        this.f502a.set(2, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gi)) {
            return false;
        }
        return m472a((gi) obj);
    }

    public gi a(Map<String, String> map) {
        this.f503a = map;
        return this;
    }

    public void b(boolean z) {
        this.f502a.set(1, z);
    }

    public gi a(boolean z) {
        this.f504a = z;
        c(true);
        return this;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gi giVar) {
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
        if (!getClass().equals(giVar.getClass())) {
            return getClass().getName().compareTo(giVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m471a()).compareTo(Boolean.valueOf(giVar.m471a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m471a() && (a12 = hq.a(this.f501a, giVar.f501a)) != 0) {
            return a12;
        }
        int compareTo2 = Boolean.valueOf(m473b()).compareTo(Boolean.valueOf(giVar.m473b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m473b() && (a11 = hq.a(this.f506b, giVar.f506b)) != 0) {
            return a11;
        }
        int compareTo3 = Boolean.valueOf(m474c()).compareTo(Boolean.valueOf(giVar.m474c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m474c() && (a10 = hq.a(this.f507c, giVar.f507c)) != 0) {
            return a10;
        }
        int compareTo4 = Boolean.valueOf(m475d()).compareTo(Boolean.valueOf(giVar.m475d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m475d() && (a9 = hq.a(this.f500a, giVar.f500a)) != 0) {
            return a9;
        }
        int compareTo5 = Boolean.valueOf(m476e()).compareTo(Boolean.valueOf(giVar.m476e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m476e() && (a8 = hq.a(this.f505b, giVar.f505b)) != 0) {
            return a8;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(giVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a7 = hq.a(this.f504a, giVar.f504a)) != 0) {
            return a7;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(giVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a6 = hq.a(this.f508d, giVar.f508d)) != 0) {
            return a6;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(giVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a5 = hq.a(this.f509e, giVar.f509e)) != 0) {
            return a5;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(giVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a4 = hq.a(this.f510f, giVar.f510f)) != 0) {
            return a4;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(giVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a3 = hq.a(this.f503a, giVar.f503a)) != 0) {
            return a3;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(giVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a2 = hq.a(this.f511g, giVar.f511g)) != 0) {
            return a2;
        }
        return 0;
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m469a();
        hzVar.a(f499a);
        if (this.f501a != null && m471a()) {
            hzVar.a(a);
            hzVar.a(this.f501a);
            hzVar.b();
        }
        if (this.f506b != null && m473b()) {
            hzVar.a(b);
            hzVar.a(this.f506b);
            hzVar.b();
        }
        if (this.f507c != null && m474c()) {
            hzVar.a(c);
            hzVar.a(this.f507c);
            hzVar.b();
        }
        if (m475d()) {
            hzVar.a(d);
            hzVar.a(this.f500a);
            hzVar.b();
        }
        if (m476e()) {
            hzVar.a(e);
            hzVar.a(this.f505b);
            hzVar.b();
        }
        if (f()) {
            hzVar.a(f);
            hzVar.a(this.f504a);
            hzVar.b();
        }
        if (this.f508d != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f508d);
            hzVar.b();
        }
        if (this.f509e != null && h()) {
            hzVar.a(h);
            hzVar.a(this.f509e);
            hzVar.b();
        }
        if (this.f510f != null && i()) {
            hzVar.a(i);
            hzVar.a(this.f510f);
            hzVar.b();
        }
        if (this.f503a != null && j()) {
            hzVar.a(j);
            hzVar.a(new hy((byte) 11, (byte) 11, this.f503a.size()));
            for (Map.Entry<String, String> entry : this.f503a.entrySet()) {
                hzVar.a(entry.getKey());
                hzVar.a(entry.getValue());
            }
            hzVar.d();
            hzVar.b();
        }
        if (this.f511g != null && k()) {
            hzVar.a(k);
            hzVar.a(this.f511g);
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
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                m469a();
                return;
            }
            switch (mo607a.f830a) {
                case 1:
                    if (b2 == 11) {
                        this.f501a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 11) {
                        this.f506b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f507c = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 10) {
                        this.f500a = hzVar.mo606a();
                        m470a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f505b = hzVar.mo606a();
                        b(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    if (b2 == 2) {
                        this.f504a = hzVar.mo617a();
                        c(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f508d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 11) {
                        this.f509e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f510f = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 13) {
                        hy mo609a = hzVar.mo609a();
                        this.f503a = new HashMap(mo609a.f832a * 2);
                        for (int i2 = 0; i2 < mo609a.f832a; i2++) {
                            this.f503a.put(hzVar.mo612a(), hzVar.mo612a());
                        }
                        hzVar.h();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f511g = hzVar.mo612a();
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
}
