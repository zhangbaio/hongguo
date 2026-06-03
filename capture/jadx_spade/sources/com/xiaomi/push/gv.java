package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gv implements hp<gv, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f606a;
    private static final hw b;
    private static final hw c;
    private static final hw d;
    private static final hw e;
    private static final hw f;
    private static final hw g;
    private static final hw h;
    private static final hw i;
    private static final hw j;

    /* renamed from: a, reason: collision with other field name */
    public gt f608a;

    /* renamed from: a, reason: collision with other field name */
    public String f609a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f611a;

    /* renamed from: b, reason: collision with other field name */
    public String f612b;

    /* renamed from: c, reason: collision with other field name */
    public String f613c;

    /* renamed from: d, reason: collision with other field name */
    public String f614d;

    /* renamed from: e, reason: collision with other field name */
    public String f615e;

    /* renamed from: f, reason: collision with other field name */
    public String f616f;

    /* renamed from: g, reason: collision with other field name */
    public String f617g;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f610a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public long f607a = 0;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m517a(gv gvVar) {
        if (gvVar == null) {
            return false;
        }
        boolean m516a = m516a();
        boolean m516a2 = gvVar.m516a();
        if ((m516a || m516a2) && !(m516a && m516a2 && this.f609a.equals(gvVar.f609a))) {
            return false;
        }
        boolean m518b = m518b();
        boolean m518b2 = gvVar.m518b();
        if ((m518b || m518b2) && !(m518b && m518b2 && this.f608a.m511a(gvVar.f608a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gvVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f612b.equals(gvVar.f612b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gvVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f613c.equals(gvVar.f613c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = gvVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f614d.equals(gvVar.f614d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gvVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f607a == gvVar.f607a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = gvVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f615e.equals(gvVar.f615e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = gvVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f611a.equals(gvVar.f611a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gvVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f616f.equals(gvVar.f616f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = gvVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f617g.equals(gvVar.f617g);
        }
        return true;
    }

    public String b() {
        return this.f614d;
    }

    public boolean c() {
        if (this.f612b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f613c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f614d != null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.f610a.get(0);
    }

    public boolean g() {
        if (this.f615e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f611a != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f616f != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f617g != null) {
            return true;
        }
        return false;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m518b() {
        if (this.f608a != null) {
            return true;
        }
        return false;
    }

    public String a() {
        return this.f612b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m514a() {
        return this.f611a;
    }

    static {
        Covode.recordClassIndex(655571);
        f606a = new ie("XmPushActionAckNotification");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 12, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 11, (short) 5);
        f = new hw("", (byte) 10, (short) 7);
        g = new hw("", (byte) 11, (short) 8);
        h = new hw("", (byte) 13, (short) 9);
        i = new hw("", (byte) 11, (short) 10);
        j = new hw("", (byte) 11, (short) 11);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m515a() {
        if (this.f612b != null) {
            return;
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (m516a()) {
            sb.append("debug:");
            String str = this.f609a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m518b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gt gtVar = this.f608a;
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
        String str2 = this.f612b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f613c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f614d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f607a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f615e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f611a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f616f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f617g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m516a() {
        if (this.f609a != null) {
            return true;
        }
        return false;
    }

    public gv a(gt gtVar) {
        this.f608a = gtVar;
        return this;
    }

    public gv b(String str) {
        this.f613c = str;
        return this;
    }

    public gv c(String str) {
        this.f614d = str;
        return this;
    }

    public gv d(String str) {
        this.f615e = str;
        return this;
    }

    public gv e(String str) {
        this.f616f = str;
        return this;
    }

    public gv a(long j2) {
        this.f607a = j2;
        a(true);
        return this;
    }

    public gv a(String str) {
        this.f612b = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gv)) {
            return false;
        }
        return m517a((gv) obj);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                m515a();
                return;
            }
            switch (mo607a.f830a) {
                case 1:
                    if (b2 == 11) {
                        this.f609a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f608a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f612b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f613c = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f614d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                default:
                    ic.a(hzVar, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f607a = hzVar.mo606a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 11) {
                        this.f615e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 13) {
                        hy mo609a = hzVar.mo609a();
                        this.f611a = new HashMap(mo609a.f832a * 2);
                        for (int i2 = 0; i2 < mo609a.f832a; i2++) {
                            this.f611a.put(hzVar.mo612a(), hzVar.mo612a());
                        }
                        hzVar.h();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f616f = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f617g = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
            }
            hzVar.g();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gv gvVar) {
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
        if (!getClass().equals(gvVar.getClass())) {
            return getClass().getName().compareTo(gvVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m516a()).compareTo(Boolean.valueOf(gvVar.m516a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m516a() && (a11 = hq.a(this.f609a, gvVar.f609a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(m518b()).compareTo(Boolean.valueOf(gvVar.m518b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m518b() && (a10 = hq.a(this.f608a, gvVar.f608a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gvVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = hq.a(this.f612b, gvVar.f612b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gvVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = hq.a(this.f613c, gvVar.f613c)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gvVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = hq.a(this.f614d, gvVar.f614d)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gvVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = hq.a(this.f607a, gvVar.f607a)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gvVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = hq.a(this.f615e, gvVar.f615e)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gvVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = hq.a(this.f611a, gvVar.f611a)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gvVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = hq.a(this.f616f, gvVar.f616f)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gvVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a2 = hq.a(this.f617g, gvVar.f617g)) != 0) {
            return a2;
        }
        return 0;
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m515a();
        hzVar.a(f606a);
        if (this.f609a != null && m516a()) {
            hzVar.a(a);
            hzVar.a(this.f609a);
            hzVar.b();
        }
        if (this.f608a != null && m518b()) {
            hzVar.a(b);
            this.f608a.b(hzVar);
            hzVar.b();
        }
        if (this.f612b != null) {
            hzVar.a(c);
            hzVar.a(this.f612b);
            hzVar.b();
        }
        if (this.f613c != null && d()) {
            hzVar.a(d);
            hzVar.a(this.f613c);
            hzVar.b();
        }
        if (this.f614d != null && e()) {
            hzVar.a(e);
            hzVar.a(this.f614d);
            hzVar.b();
        }
        if (f()) {
            hzVar.a(f);
            hzVar.a(this.f607a);
            hzVar.b();
        }
        if (this.f615e != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f615e);
            hzVar.b();
        }
        if (this.f611a != null && h()) {
            hzVar.a(h);
            hzVar.a(new hy((byte) 11, (byte) 11, this.f611a.size()));
            for (Map.Entry<String, String> entry : this.f611a.entrySet()) {
                hzVar.a(entry.getKey());
                hzVar.a(entry.getValue());
            }
            hzVar.d();
            hzVar.b();
        }
        if (this.f616f != null && i()) {
            hzVar.a(i);
            hzVar.a(this.f616f);
            hzVar.b();
        }
        if (this.f617g != null && j()) {
            hzVar.a(j);
            hzVar.a(this.f617g);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    public void a(boolean z) {
        this.f610a.set(0, z);
    }
}
