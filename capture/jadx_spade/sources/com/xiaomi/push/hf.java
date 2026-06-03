package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hf implements hp<hf, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f710a;
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

    /* renamed from: a, reason: collision with other field name */
    public int f711a;

    /* renamed from: a, reason: collision with other field name */
    public long f712a;

    /* renamed from: a, reason: collision with other field name */
    public gt f713a;

    /* renamed from: a, reason: collision with other field name */
    public String f714a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f716a;

    /* renamed from: b, reason: collision with other field name */
    public int f718b;

    /* renamed from: b, reason: collision with other field name */
    public long f719b;

    /* renamed from: b, reason: collision with other field name */
    public String f720b;

    /* renamed from: c, reason: collision with other field name */
    public long f721c;

    /* renamed from: c, reason: collision with other field name */
    public String f722c;

    /* renamed from: d, reason: collision with other field name */
    public String f723d;

    /* renamed from: e, reason: collision with other field name */
    public String f724e;

    /* renamed from: f, reason: collision with other field name */
    public String f725f;

    /* renamed from: g, reason: collision with other field name */
    public String f726g;

    /* renamed from: h, reason: collision with other field name */
    public String f727h;

    /* renamed from: i, reason: collision with other field name */
    public String f728i;

    /* renamed from: j, reason: collision with other field name */
    public String f729j;

    /* renamed from: k, reason: collision with other field name */
    public String f730k;

    /* renamed from: l, reason: collision with other field name */
    public String f731l;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f715a = new BitSet(6);

    /* renamed from: a, reason: collision with other field name */
    public boolean f717a = false;

    public int hashCode() {
        return 0;
    }

    public long a() {
        return this.f712a;
    }

    public String b() {
        return this.f725f;
    }

    public String c() {
        return this.f726g;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m563a() {
        return this.f720b;
    }

    public boolean g() {
        if (this.f724e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f725f != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f726g != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        return this.f715a.get(1);
    }

    public boolean k() {
        if (this.f727h != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.f728i != null) {
            return true;
        }
        return false;
    }

    public boolean m() {
        return this.f715a.get(2);
    }

    public boolean n() {
        if (this.f729j != null) {
            return true;
        }
        return false;
    }

    public boolean o() {
        return this.f715a.get(3);
    }

    public boolean p() {
        if (this.f730k != null) {
            return true;
        }
        return false;
    }

    public boolean q() {
        return this.f715a.get(4);
    }

    public boolean r() {
        if (this.f731l != null) {
            return true;
        }
        return false;
    }

    public boolean s() {
        return this.f715a.get(5);
    }

    public boolean t() {
        if (this.f716a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m564a() {
        return this.f716a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m568b() {
        if (this.f713a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m569c() {
        if (this.f720b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f722c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f715a.get(0);
    }

    public boolean f() {
        if (this.f723d != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m565a() {
        if (this.f720b != null) {
            if (this.f722c != null) {
                return;
            }
            throw new ia("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m566a() {
        if (this.f714a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655582);
        f710a = new ie("XmPushActionRegistrationResult");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 12, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 10, (short) 6);
        f = new hw("", (byte) 11, (short) 7);
        g = new hw("", (byte) 11, (short) 8);
        h = new hw("", (byte) 11, (short) 9);
        i = new hw("", (byte) 11, (short) 10);
        j = new hw("", (byte) 10, (short) 11);
        k = new hw("", (byte) 11, (short) 12);
        l = new hw("", (byte) 11, (short) 13);
        m = new hw("", (byte) 10, (short) 14);
        n = new hw("", (byte) 11, (short) 15);
        o = new hw("", (byte) 8, (short) 16);
        p = new hw("", (byte) 11, (short) 17);
        q = new hw("", (byte) 8, (short) 18);
        r = new hw("", (byte) 11, (short) 19);
        s = new hw("", (byte) 2, (short) 20);
        t = new hw("", (byte) 15, (short) 21);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = false;
        if (m566a()) {
            sb.append("debug:");
            String str = this.f714a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m568b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gt gtVar = this.f713a;
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
        String str2 = this.f720b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f722c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f712a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f723d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f724e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f726g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f719b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f727h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f728i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f721c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.f729j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f711a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.f730k;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f718b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.f731l;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f717a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("autoMarkPkgs:");
            List<String> list = this.f716a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void b(boolean z) {
        this.f715a.set(1, z);
    }

    public void c(boolean z) {
        this.f715a.set(2, z);
    }

    public void d(boolean z) {
        this.f715a.set(3, z);
    }

    public void e(boolean z) {
        this.f715a.set(4, z);
    }

    public void f(boolean z) {
        this.f715a.set(5, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hf)) {
            return false;
        }
        return m567a((hf) obj);
    }

    public void a(boolean z) {
        this.f715a.set(0, z);
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
                    m565a();
                    return;
                }
                throw new ia("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo607a.f830a) {
                case 1:
                    if (b2 == 11) {
                        this.f714a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f713a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f720b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f722c = hzVar.mo612a();
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
                        this.f712a = hzVar.mo606a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f723d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 11) {
                        this.f724e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f725f = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f726g = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 10) {
                        this.f719b = hzVar.mo606a();
                        b(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    if (b2 == 11) {
                        this.f727h = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                    if (b2 == 11) {
                        this.f728i = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 10) {
                        this.f721c = hzVar.mo606a();
                        c(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 11) {
                        this.f729j = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 8) {
                        this.f711a = hzVar.mo605a();
                        d(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                    if (b2 == 11) {
                        this.f730k = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 18:
                    if (b2 == 8) {
                        this.f718b = hzVar.mo605a();
                        e(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                    if (b2 == 11) {
                        this.f731l = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                    if (b2 == 2) {
                        this.f717a = hzVar.mo617a();
                        f(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                    if (b2 == 15) {
                        hx mo608a = hzVar.mo608a();
                        this.f716a = new ArrayList(mo608a.f831a);
                        for (int i2 = 0; i2 < mo608a.f831a; i2++) {
                            this.f716a.add(hzVar.mo612a());
                        }
                        hzVar.i();
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
        m565a();
        hzVar.a(f710a);
        if (this.f714a != null && m566a()) {
            hzVar.a(a);
            hzVar.a(this.f714a);
            hzVar.b();
        }
        if (this.f713a != null && m568b()) {
            hzVar.a(b);
            this.f713a.b(hzVar);
            hzVar.b();
        }
        if (this.f720b != null) {
            hzVar.a(c);
            hzVar.a(this.f720b);
            hzVar.b();
        }
        if (this.f722c != null) {
            hzVar.a(d);
            hzVar.a(this.f722c);
            hzVar.b();
        }
        hzVar.a(e);
        hzVar.a(this.f712a);
        hzVar.b();
        if (this.f723d != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f723d);
            hzVar.b();
        }
        if (this.f724e != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f724e);
            hzVar.b();
        }
        if (this.f725f != null && h()) {
            hzVar.a(h);
            hzVar.a(this.f725f);
            hzVar.b();
        }
        if (this.f726g != null && i()) {
            hzVar.a(i);
            hzVar.a(this.f726g);
            hzVar.b();
        }
        if (j()) {
            hzVar.a(j);
            hzVar.a(this.f719b);
            hzVar.b();
        }
        if (this.f727h != null && k()) {
            hzVar.a(k);
            hzVar.a(this.f727h);
            hzVar.b();
        }
        if (this.f728i != null && l()) {
            hzVar.a(l);
            hzVar.a(this.f728i);
            hzVar.b();
        }
        if (m()) {
            hzVar.a(m);
            hzVar.a(this.f721c);
            hzVar.b();
        }
        if (this.f729j != null && n()) {
            hzVar.a(n);
            hzVar.a(this.f729j);
            hzVar.b();
        }
        if (o()) {
            hzVar.a(o);
            hzVar.mo616a(this.f711a);
            hzVar.b();
        }
        if (this.f730k != null && p()) {
            hzVar.a(p);
            hzVar.a(this.f730k);
            hzVar.b();
        }
        if (q()) {
            hzVar.a(q);
            hzVar.mo616a(this.f718b);
            hzVar.b();
        }
        if (this.f731l != null && r()) {
            hzVar.a(r);
            hzVar.a(this.f731l);
            hzVar.b();
        }
        if (s()) {
            hzVar.a(s);
            hzVar.a(this.f717a);
            hzVar.b();
        }
        if (this.f716a != null && t()) {
            hzVar.a(t);
            hzVar.a(new hx((byte) 11, this.f716a.size()));
            Iterator<String> it2 = this.f716a.iterator();
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
    public int compareTo(hf hfVar) {
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
        if (!getClass().equals(hfVar.getClass())) {
            return getClass().getName().compareTo(hfVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m566a()).compareTo(Boolean.valueOf(hfVar.m566a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m566a() && (a21 = hq.a(this.f714a, hfVar.f714a)) != 0) {
            return a21;
        }
        int compareTo2 = Boolean.valueOf(m568b()).compareTo(Boolean.valueOf(hfVar.m568b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m568b() && (a20 = hq.a(this.f713a, hfVar.f713a)) != 0) {
            return a20;
        }
        int compareTo3 = Boolean.valueOf(m569c()).compareTo(Boolean.valueOf(hfVar.m569c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m569c() && (a19 = hq.a(this.f720b, hfVar.f720b)) != 0) {
            return a19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hfVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a18 = hq.a(this.f722c, hfVar.f722c)) != 0) {
            return a18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hfVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a17 = hq.a(this.f712a, hfVar.f712a)) != 0) {
            return a17;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hfVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a16 = hq.a(this.f723d, hfVar.f723d)) != 0) {
            return a16;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hfVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a15 = hq.a(this.f724e, hfVar.f724e)) != 0) {
            return a15;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hfVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a14 = hq.a(this.f725f, hfVar.f725f)) != 0) {
            return a14;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hfVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a13 = hq.a(this.f726g, hfVar.f726g)) != 0) {
            return a13;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hfVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a12 = hq.a(this.f719b, hfVar.f719b)) != 0) {
            return a12;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hfVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a11 = hq.a(this.f727h, hfVar.f727h)) != 0) {
            return a11;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hfVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a10 = hq.a(this.f728i, hfVar.f728i)) != 0) {
            return a10;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hfVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a9 = hq.a(this.f721c, hfVar.f721c)) != 0) {
            return a9;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hfVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a8 = hq.a(this.f729j, hfVar.f729j)) != 0) {
            return a8;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hfVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a7 = hq.a(this.f711a, hfVar.f711a)) != 0) {
            return a7;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hfVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a6 = hq.a(this.f730k, hfVar.f730k)) != 0) {
            return a6;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hfVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a5 = hq.a(this.f718b, hfVar.f718b)) != 0) {
            return a5;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hfVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a4 = hq.a(this.f731l, hfVar.f731l)) != 0) {
            return a4;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hfVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a3 = hq.a(this.f717a, hfVar.f717a)) != 0) {
            return a3;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hfVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (t() && (a2 = hq.a(this.f716a, hfVar.f716a)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m567a(hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        boolean m566a = m566a();
        boolean m566a2 = hfVar.m566a();
        if ((m566a || m566a2) && (!m566a || !m566a2 || !this.f714a.equals(hfVar.f714a))) {
            return false;
        }
        boolean m568b = m568b();
        boolean m568b2 = hfVar.m568b();
        if ((m568b || m568b2) && (!m568b || !m568b2 || !this.f713a.m511a(hfVar.f713a))) {
            return false;
        }
        boolean m569c = m569c();
        boolean m569c2 = hfVar.m569c();
        if ((m569c || m569c2) && (!m569c || !m569c2 || !this.f720b.equals(hfVar.f720b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hfVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f722c.equals(hfVar.f722c))) || this.f712a != hfVar.f712a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hfVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f723d.equals(hfVar.f723d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hfVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f724e.equals(hfVar.f724e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hfVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f725f.equals(hfVar.f725f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hfVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f726g.equals(hfVar.f726g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hfVar.j();
        if ((j2 || j3) && (!j2 || !j3 || this.f719b != hfVar.f719b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hfVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f727h.equals(hfVar.f727h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hfVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f728i.equals(hfVar.f728i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hfVar.m();
        if ((m2 || m3) && (!m2 || !m3 || this.f721c != hfVar.f721c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hfVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.f729j.equals(hfVar.f729j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hfVar.o();
        if ((o2 || o3) && (!o2 || !o3 || this.f711a != hfVar.f711a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hfVar.p();
        if ((p2 || p3) && (!p2 || !p3 || !this.f730k.equals(hfVar.f730k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hfVar.q();
        if ((q2 || q3) && (!q2 || !q3 || this.f718b != hfVar.f718b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hfVar.r();
        if ((r2 || r3) && (!r2 || !r3 || !this.f731l.equals(hfVar.f731l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hfVar.s();
        if ((s2 || s3) && (!s2 || !s3 || this.f717a != hfVar.f717a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hfVar.t();
        if (t2 || t3) {
            if (!t2 || !t3 || !this.f716a.equals(hfVar.f716a)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
