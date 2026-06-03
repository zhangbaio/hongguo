package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hn implements hp<hn, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f809a;
    private static final hw b;
    private static final hw c;
    private static final hw d;
    private static final hw e;
    private static final hw f;
    private static final hw g;
    private static final hw h;
    private static final hw i;

    /* renamed from: a, reason: collision with other field name */
    public long f810a;

    /* renamed from: a, reason: collision with other field name */
    public gt f811a;

    /* renamed from: a, reason: collision with other field name */
    public String f812a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f813a = new BitSet(1);

    /* renamed from: b, reason: collision with other field name */
    public String f814b;

    /* renamed from: c, reason: collision with other field name */
    public String f815c;

    /* renamed from: d, reason: collision with other field name */
    public String f816d;

    /* renamed from: e, reason: collision with other field name */
    public String f817e;

    /* renamed from: f, reason: collision with other field name */
    public String f818f;

    /* renamed from: g, reason: collision with other field name */
    public String f819g;

    public int hashCode() {
        return 0;
    }

    public String a() {
        return this.f814b;
    }

    public String b() {
        return this.f817e;
    }

    public String c() {
        return this.f819g;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m598b() {
        if (this.f811a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m599c() {
        if (this.f814b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f815c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f813a.get(0);
    }

    public boolean f() {
        if (this.f816d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f817e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f818f != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f819g != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m596a() {
        if (this.f812a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m595a() {
        if (this.f814b != null) {
            return;
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    static {
        Covode.recordClassIndex(655590);
        f809a = new ie("XmPushActionUnSubscriptionResult");
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
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = false;
        if (m596a()) {
            sb.append("debug:");
            String str = this.f812a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m598b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gt gtVar = this.f811a;
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
        String str2 = this.f814b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f815c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f810a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f816d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f817e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f818f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f819g;
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
        this.f813a.set(0, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hn)) {
            return false;
        }
        return m597a((hn) obj);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                m595a();
                return;
            }
            switch (mo607a.f830a) {
                case 1:
                    if (b2 == 11) {
                        this.f812a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f811a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f814b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f815c = hzVar.mo612a();
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
                        this.f810a = hzVar.mo606a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f816d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 11) {
                        this.f817e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f818f = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f819g = hzVar.mo612a();
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
        m595a();
        hzVar.a(f809a);
        if (this.f812a != null && m596a()) {
            hzVar.a(a);
            hzVar.a(this.f812a);
            hzVar.b();
        }
        if (this.f811a != null && m598b()) {
            hzVar.a(b);
            this.f811a.b(hzVar);
            hzVar.b();
        }
        if (this.f814b != null) {
            hzVar.a(c);
            hzVar.a(this.f814b);
            hzVar.b();
        }
        if (this.f815c != null && d()) {
            hzVar.a(d);
            hzVar.a(this.f815c);
            hzVar.b();
        }
        if (e()) {
            hzVar.a(e);
            hzVar.a(this.f810a);
            hzVar.b();
        }
        if (this.f816d != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f816d);
            hzVar.b();
        }
        if (this.f817e != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f817e);
            hzVar.b();
        }
        if (this.f818f != null && h()) {
            hzVar.a(h);
            hzVar.a(this.f818f);
            hzVar.b();
        }
        if (this.f819g != null && i()) {
            hzVar.a(i);
            hzVar.a(this.f819g);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hn hnVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!getClass().equals(hnVar.getClass())) {
            return getClass().getName().compareTo(hnVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m596a()).compareTo(Boolean.valueOf(hnVar.m596a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m596a() && (a10 = hq.a(this.f812a, hnVar.f812a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(m598b()).compareTo(Boolean.valueOf(hnVar.m598b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m598b() && (a9 = hq.a(this.f811a, hnVar.f811a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(m599c()).compareTo(Boolean.valueOf(hnVar.m599c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m599c() && (a8 = hq.a(this.f814b, hnVar.f814b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hnVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = hq.a(this.f815c, hnVar.f815c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hnVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = hq.a(this.f810a, hnVar.f810a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hnVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = hq.a(this.f816d, hnVar.f816d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hnVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = hq.a(this.f817e, hnVar.f817e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hnVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = hq.a(this.f818f, hnVar.f818f)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hnVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a2 = hq.a(this.f819g, hnVar.f819g)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m597a(hn hnVar) {
        if (hnVar == null) {
            return false;
        }
        boolean m596a = m596a();
        boolean m596a2 = hnVar.m596a();
        if ((m596a || m596a2) && (!m596a || !m596a2 || !this.f812a.equals(hnVar.f812a))) {
            return false;
        }
        boolean m598b = m598b();
        boolean m598b2 = hnVar.m598b();
        if ((m598b || m598b2) && (!m598b || !m598b2 || !this.f811a.m511a(hnVar.f811a))) {
            return false;
        }
        boolean m599c = m599c();
        boolean m599c2 = hnVar.m599c();
        if ((m599c || m599c2) && (!m599c || !m599c2 || !this.f814b.equals(hnVar.f814b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hnVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f815c.equals(hnVar.f815c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hnVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f810a != hnVar.f810a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hnVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f816d.equals(hnVar.f816d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hnVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f817e.equals(hnVar.f817e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hnVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f818f.equals(hnVar.f818f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hnVar.i();
        if (i2 || i3) {
            if (!i2 || !i3 || !this.f819g.equals(hnVar.f819g)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
