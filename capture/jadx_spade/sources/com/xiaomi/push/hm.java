package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hm implements hp<hm, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f800a;
    private static final hw b;
    private static final hw c;
    private static final hw d;
    private static final hw e;
    private static final hw f;
    private static final hw g;
    private static final hw h;

    /* renamed from: a, reason: collision with other field name */
    public gt f801a;

    /* renamed from: a, reason: collision with other field name */
    public String f802a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f803a;

    /* renamed from: b, reason: collision with other field name */
    public String f804b;

    /* renamed from: c, reason: collision with other field name */
    public String f805c;

    /* renamed from: d, reason: collision with other field name */
    public String f806d;

    /* renamed from: e, reason: collision with other field name */
    public String f807e;

    /* renamed from: f, reason: collision with other field name */
    public String f808f;

    public int hashCode() {
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m593a() {
        if (this.f802a != null) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f801a != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f804b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f805c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f806d != null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.f807e != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f808f != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f803a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655589);
        f800a = new ie("XmPushActionUnSubscription");
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
        if (this.f804b != null) {
            if (this.f805c != null) {
                if (this.f806d != null) {
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
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = false;
        if (m593a()) {
            sb.append("debug:");
            String str = this.f802a;
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
            gt gtVar = this.f801a;
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
        String str2 = this.f804b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f805c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f806d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f807e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f808f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f803a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hm a(String str) {
        this.f804b = str;
        return this;
    }

    public hm b(String str) {
        this.f805c = str;
        return this;
    }

    public hm c(String str) {
        this.f806d = str;
        return this;
    }

    public hm d(String str) {
        this.f807e = str;
        return this;
    }

    public hm e(String str) {
        this.f808f = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hm)) {
            return false;
        }
        return m594a((hm) obj);
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
                        this.f802a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f801a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f804b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f805c = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f806d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    if (b2 == 11) {
                        this.f807e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f808f = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 15) {
                        hx mo608a = hzVar.mo608a();
                        this.f803a = new ArrayList(mo608a.f831a);
                        for (int i = 0; i < mo608a.f831a; i++) {
                            this.f803a.add(hzVar.mo612a());
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
        hzVar.a(f800a);
        if (this.f802a != null && m593a()) {
            hzVar.a(a);
            hzVar.a(this.f802a);
            hzVar.b();
        }
        if (this.f801a != null && b()) {
            hzVar.a(b);
            this.f801a.b(hzVar);
            hzVar.b();
        }
        if (this.f804b != null) {
            hzVar.a(c);
            hzVar.a(this.f804b);
            hzVar.b();
        }
        if (this.f805c != null) {
            hzVar.a(d);
            hzVar.a(this.f805c);
            hzVar.b();
        }
        if (this.f806d != null) {
            hzVar.a(e);
            hzVar.a(this.f806d);
            hzVar.b();
        }
        if (this.f807e != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f807e);
            hzVar.b();
        }
        if (this.f808f != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f808f);
            hzVar.b();
        }
        if (this.f803a != null && h()) {
            hzVar.a(h);
            hzVar.a(new hx((byte) 11, this.f803a.size()));
            Iterator<String> it2 = this.f803a.iterator();
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
    public int compareTo(hm hmVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(hmVar.getClass())) {
            return getClass().getName().compareTo(hmVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m593a()).compareTo(Boolean.valueOf(hmVar.m593a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m593a() && (a9 = hq.a(this.f802a, hmVar.f802a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hmVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = hq.a(this.f801a, hmVar.f801a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hmVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = hq.a(this.f804b, hmVar.f804b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hmVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = hq.a(this.f805c, hmVar.f805c)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hmVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = hq.a(this.f806d, hmVar.f806d)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hmVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = hq.a(this.f807e, hmVar.f807e)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hmVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = hq.a(this.f808f, hmVar.f808f)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hmVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a2 = hq.a(this.f803a, hmVar.f803a)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m594a(hm hmVar) {
        if (hmVar == null) {
            return false;
        }
        boolean m593a = m593a();
        boolean m593a2 = hmVar.m593a();
        if ((m593a || m593a2) && (!m593a || !m593a2 || !this.f802a.equals(hmVar.f802a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hmVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f801a.m511a(hmVar.f801a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hmVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f804b.equals(hmVar.f804b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hmVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f805c.equals(hmVar.f805c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hmVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f806d.equals(hmVar.f806d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hmVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f807e.equals(hmVar.f807e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hmVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f808f.equals(hmVar.f808f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hmVar.h();
        if (h2 || h3) {
            if (!h2 || !h3 || !this.f803a.equals(hmVar.f803a)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
