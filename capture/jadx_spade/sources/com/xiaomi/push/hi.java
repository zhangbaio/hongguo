package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hi implements hp<hi, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f755a;
    private static final hw b;
    private static final hw c;
    private static final hw d;
    private static final hw e;
    private static final hw f;
    private static final hw g;
    private static final hw h;

    /* renamed from: a, reason: collision with other field name */
    public gt f756a;

    /* renamed from: a, reason: collision with other field name */
    public String f757a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f758a;

    /* renamed from: b, reason: collision with other field name */
    public String f759b;

    /* renamed from: c, reason: collision with other field name */
    public String f760c;

    /* renamed from: d, reason: collision with other field name */
    public String f761d;

    /* renamed from: e, reason: collision with other field name */
    public String f762e;

    /* renamed from: f, reason: collision with other field name */
    public String f763f;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m581a() {
        if (this.f757a != null) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f756a != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f759b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f760c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f761d != null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.f762e != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f763f != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f758a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655585);
        f755a = new ie("XmPushActionSubscription");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 12, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 11, (short) 5);
        f = new hw("", (byte) 11, (short) 6);
        g = new hw("", (byte) 11, (short) 7);
        h = new hw("", (byte) 15, (short) 8);
    }

    public void a() {
        if (this.f759b != null) {
            if (this.f760c != null) {
                if (this.f761d != null) {
                    return;
                }
                throw new ia("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new ia("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = false;
        if (m581a()) {
            sb.append("debug:");
            String str = this.f757a;
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
            gt gtVar = this.f756a;
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
        String str2 = this.f759b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f760c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f761d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f762e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f763f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f758a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hi a(String str) {
        this.f759b = str;
        return this;
    }

    public hi b(String str) {
        this.f760c = str;
        return this;
    }

    public hi c(String str) {
        this.f761d = str;
        return this;
    }

    public hi d(String str) {
        this.f762e = str;
        return this;
    }

    public hi e(String str) {
        this.f763f = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hi)) {
            return false;
        }
        return m582a((hi) obj);
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
                        this.f757a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f756a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f759b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f760c = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f761d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    if (b2 == 11) {
                        this.f762e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f763f = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 15) {
                        hx mo608a = hzVar.mo608a();
                        this.f758a = new ArrayList(mo608a.f831a);
                        for (int i = 0; i < mo608a.f831a; i++) {
                            this.f758a.add(hzVar.mo612a());
                        }
                        hzVar.i();
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
        a();
        hzVar.a(f755a);
        if (this.f757a != null && m581a()) {
            hzVar.a(a);
            hzVar.a(this.f757a);
            hzVar.b();
        }
        if (this.f756a != null && b()) {
            hzVar.a(b);
            this.f756a.b(hzVar);
            hzVar.b();
        }
        if (this.f759b != null) {
            hzVar.a(c);
            hzVar.a(this.f759b);
            hzVar.b();
        }
        if (this.f760c != null) {
            hzVar.a(d);
            hzVar.a(this.f760c);
            hzVar.b();
        }
        if (this.f761d != null) {
            hzVar.a(e);
            hzVar.a(this.f761d);
            hzVar.b();
        }
        if (this.f762e != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f762e);
            hzVar.b();
        }
        if (this.f763f != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f763f);
            hzVar.b();
        }
        if (this.f758a != null && h()) {
            hzVar.a(h);
            hzVar.a(new hx((byte) 11, this.f758a.size()));
            Iterator<String> it2 = this.f758a.iterator();
            while (it2.hasNext()) {
                hzVar.a(it2.next());
            }
            hzVar.e();
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hi hiVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(hiVar.getClass())) {
            return getClass().getName().compareTo(hiVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m581a()).compareTo(Boolean.valueOf(hiVar.m581a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m581a() && (a9 = hq.a(this.f757a, hiVar.f757a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hiVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = hq.a(this.f756a, hiVar.f756a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hiVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = hq.a(this.f759b, hiVar.f759b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hiVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = hq.a(this.f760c, hiVar.f760c)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hiVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = hq.a(this.f761d, hiVar.f761d)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hiVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = hq.a(this.f762e, hiVar.f762e)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hiVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = hq.a(this.f763f, hiVar.f763f)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hiVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a2 = hq.a(this.f758a, hiVar.f758a)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m582a(hi hiVar) {
        if (hiVar == null) {
            return false;
        }
        boolean m581a = m581a();
        boolean m581a2 = hiVar.m581a();
        if ((m581a || m581a2) && (!m581a || !m581a2 || !this.f757a.equals(hiVar.f757a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hiVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f756a.m511a(hiVar.f756a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hiVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f759b.equals(hiVar.f759b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hiVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f760c.equals(hiVar.f760c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hiVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f761d.equals(hiVar.f761d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hiVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f762e.equals(hiVar.f762e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hiVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f763f.equals(hiVar.f763f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hiVar.h();
        if (h2 || h3) {
            if (!h2 || !h3 || !this.f758a.equals(hiVar.f758a)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
