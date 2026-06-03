package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hg implements hp<hg, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f732a;
    private static final hw b;
    private static final hw c;
    private static final hw d;
    private static final hw e;
    private static final hw f;
    private static final hw g;

    /* renamed from: a, reason: collision with other field name */
    public long f733a;

    /* renamed from: a, reason: collision with other field name */
    public gt f734a;

    /* renamed from: a, reason: collision with other field name */
    public String f735a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f736a = new BitSet(1);

    /* renamed from: b, reason: collision with other field name */
    public String f737b;

    /* renamed from: c, reason: collision with other field name */
    public String f738c;

    /* renamed from: d, reason: collision with other field name */
    public String f739d;

    /* renamed from: e, reason: collision with other field name */
    public String f740e;

    public int hashCode() {
        return 0;
    }

    public boolean b() {
        if (this.f734a != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f737b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f738c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f736a.get(0);
    }

    public boolean f() {
        if (this.f739d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f740e != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m570a() {
        if (this.f735a != null) {
            return true;
        }
        return false;
    }

    public void a() {
        if (this.f737b != null) {
            if (this.f738c != null) {
                return;
            }
            throw new ia("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    static {
        Covode.recordClassIndex(655583);
        f732a = new ie("XmPushActionSendFeedbackResult");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 12, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 10, (short) 6);
        f = new hw("", (byte) 11, (short) 7);
        g = new hw("", (byte) 11, (short) 8);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = false;
        if (m570a()) {
            sb.append("debug:");
            String str = this.f735a;
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
            gt gtVar = this.f734a;
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
        String str2 = this.f737b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f738c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f733a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f739d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f740e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f736a.set(0, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hg)) {
            return false;
        }
        return m571a((hg) obj);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                if (e()) {
                    a();
                    return;
                }
                throw new ia("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo607a.f830a) {
                case 1:
                    if (b2 == 11) {
                        this.f735a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f734a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f737b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f738c = hzVar.mo612a();
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
                        this.f733a = hzVar.mo606a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f739d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 11) {
                        this.f740e = hzVar.mo612a();
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
        a();
        hzVar.a(f732a);
        if (this.f735a != null && m570a()) {
            hzVar.a(a);
            hzVar.a(this.f735a);
            hzVar.b();
        }
        if (this.f734a != null && b()) {
            hzVar.a(b);
            this.f734a.b(hzVar);
            hzVar.b();
        }
        if (this.f737b != null) {
            hzVar.a(c);
            hzVar.a(this.f737b);
            hzVar.b();
        }
        if (this.f738c != null) {
            hzVar.a(d);
            hzVar.a(this.f738c);
            hzVar.b();
        }
        hzVar.a(e);
        hzVar.a(this.f733a);
        hzVar.b();
        if (this.f739d != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f739d);
            hzVar.b();
        }
        if (this.f740e != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f740e);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hg hgVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(hgVar.getClass())) {
            return getClass().getName().compareTo(hgVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m570a()).compareTo(Boolean.valueOf(hgVar.m570a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m570a() && (a8 = hq.a(this.f735a, hgVar.f735a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hgVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a7 = hq.a(this.f734a, hgVar.f734a)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hgVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a6 = hq.a(this.f737b, hgVar.f737b)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hgVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a5 = hq.a(this.f738c, hgVar.f738c)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hgVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a4 = hq.a(this.f733a, hgVar.f733a)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hgVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a3 = hq.a(this.f739d, hgVar.f739d)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hgVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a2 = hq.a(this.f740e, hgVar.f740e)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m571a(hg hgVar) {
        if (hgVar == null) {
            return false;
        }
        boolean m570a = m570a();
        boolean m570a2 = hgVar.m570a();
        if ((m570a || m570a2) && (!m570a || !m570a2 || !this.f735a.equals(hgVar.f735a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hgVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f734a.m511a(hgVar.f734a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hgVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f737b.equals(hgVar.f737b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hgVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f738c.equals(hgVar.f738c))) || this.f733a != hgVar.f733a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hgVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f739d.equals(hgVar.f739d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hgVar.g();
        if (g2 || g3) {
            if (!g2 || !g3 || !this.f740e.equals(hgVar.f740e)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
