package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gu implements hp<gu, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f584a;
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
    public int f585a;

    /* renamed from: a, reason: collision with other field name */
    public long f586a;

    /* renamed from: a, reason: collision with other field name */
    public gt f587a;

    /* renamed from: a, reason: collision with other field name */
    public hh f588a;

    /* renamed from: a, reason: collision with other field name */
    public String f589a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f591a;

    /* renamed from: a, reason: collision with other field name */
    public short f592a;

    /* renamed from: b, reason: collision with other field name */
    public String f594b;

    /* renamed from: b, reason: collision with other field name */
    public short f595b;

    /* renamed from: c, reason: collision with other field name */
    public String f596c;

    /* renamed from: d, reason: collision with other field name */
    public String f597d;

    /* renamed from: e, reason: collision with other field name */
    public String f598e;

    /* renamed from: f, reason: collision with other field name */
    public String f599f;

    /* renamed from: g, reason: collision with other field name */
    public String f600g;

    /* renamed from: h, reason: collision with other field name */
    public String f601h;

    /* renamed from: i, reason: collision with other field name */
    public String f602i;

    /* renamed from: j, reason: collision with other field name */
    public String f603j;

    /* renamed from: k, reason: collision with other field name */
    public String f604k;

    /* renamed from: l, reason: collision with other field name */
    public String f605l;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f590a = new BitSet(5);

    /* renamed from: a, reason: collision with other field name */
    public boolean f593a = false;

    public int hashCode() {
        return 0;
    }

    public boolean f() {
        if (this.f597d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f598e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f588a != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f599f != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f600g != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        return this.f590a.get(1);
    }

    public boolean l() {
        if (this.f601h != null) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (this.f602i != null) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if (this.f603j != null) {
            return true;
        }
        return false;
    }

    public boolean o() {
        return this.f590a.get(2);
    }

    public boolean p() {
        return this.f590a.get(3);
    }

    public boolean q() {
        if (this.f604k != null) {
            return true;
        }
        return false;
    }

    public boolean r() {
        if (this.f605l != null) {
            return true;
        }
        return false;
    }

    public boolean s() {
        return this.f590a.get(4);
    }

    public boolean t() {
        if (this.f591a != null) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f587a != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f594b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f596c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f590a.get(0);
    }

    public void a() {
        if (this.f594b != null) {
            if (this.f596c != null) {
                return;
            }
            throw new ia("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m512a() {
        if (this.f589a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655570);
        f584a = new ie("XmPushActionAckMessage");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 12, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 10, (short) 5);
        f = new hw("", (byte) 11, (short) 6);
        g = new hw("", (byte) 11, (short) 7);
        h = new hw("", (byte) 12, (short) 8);
        i = new hw("", (byte) 11, (short) 9);
        j = new hw("", (byte) 11, (short) 10);
        k = new hw("", (byte) 2, (short) 11);
        l = new hw("", (byte) 11, (short) 12);
        m = new hw("", (byte) 11, (short) 13);
        n = new hw("", (byte) 11, (short) 14);
        o = new hw("", (byte) 6, (short) 15);
        p = new hw("", (byte) 6, (short) 16);
        q = new hw("", (byte) 11, (short) 20);
        r = new hw("", (byte) 11, (short) 21);
        s = new hw("", (byte) 8, (short) 22);
        t = new hw("", (byte) 13, (short) 23);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = false;
        if (m512a()) {
            sb.append("debug:");
            String str = this.f589a;
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
            gt gtVar = this.f587a;
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
        String str2 = this.f594b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f596c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f586a);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f597d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f598e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            hh hhVar = this.f588a;
            if (hhVar == null) {
                sb.append("null");
            } else {
                sb.append(hhVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f599f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f600g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f593a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f601h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f602i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f603j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f592a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f595b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f604k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f605l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f585a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f591a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public gu a(String str) {
        this.f594b = str;
        return this;
    }

    public gu b(String str) {
        this.f596c = str;
        return this;
    }

    public gu c(String str) {
        this.f597d = str;
        return this;
    }

    public gu d(String str) {
        this.f598e = str;
        return this;
    }

    public gu a(long j2) {
        this.f586a = j2;
        a(true);
        return this;
    }

    public void b(boolean z) {
        this.f590a.set(1, z);
    }

    public void c(boolean z) {
        this.f590a.set(2, z);
    }

    public void d(boolean z) {
        this.f590a.set(3, z);
    }

    public void e(boolean z) {
        this.f590a.set(4, z);
    }

    public gu a(short s2) {
        this.f592a = s2;
        c(true);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gu)) {
            return false;
        }
        return m513a((gu) obj);
    }

    public void a(boolean z) {
        this.f590a.set(0, z);
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
                throw new ia("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (mo607a.f830a) {
                case 1:
                    if (b2 == 11) {
                        this.f589a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f587a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f594b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f596c = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f586a = hzVar.mo606a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    if (b2 == 11) {
                        this.f597d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f598e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 12) {
                        hh hhVar = new hh();
                        this.f588a = hhVar;
                        hhVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f599f = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f600g = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f593a = hzVar.mo617a();
                        b(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    if (b2 == 11) {
                        this.f601h = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                    if (b2 == 11) {
                        this.f602i = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 11) {
                        this.f603j = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 6) {
                        this.f592a = hzVar.mo614a();
                        c(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 6) {
                        this.f595b = hzVar.mo614a();
                        d(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                case 18:
                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                default:
                    ic.a(hzVar, b2);
                    break;
                case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                    if (b2 == 11) {
                        this.f604k = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                    if (b2 == 11) {
                        this.f605l = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                    if (b2 == 8) {
                        this.f585a = hzVar.mo605a();
                        e(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                    if (b2 == 13) {
                        hy mo609a = hzVar.mo609a();
                        this.f591a = new HashMap(mo609a.f832a * 2);
                        for (int i2 = 0; i2 < mo609a.f832a; i2++) {
                            this.f591a.put(hzVar.mo612a(), hzVar.mo612a());
                        }
                        hzVar.h();
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
        hzVar.a(f584a);
        if (this.f589a != null && m512a()) {
            hzVar.a(a);
            hzVar.a(this.f589a);
            hzVar.b();
        }
        if (this.f587a != null && b()) {
            hzVar.a(b);
            this.f587a.b(hzVar);
            hzVar.b();
        }
        if (this.f594b != null) {
            hzVar.a(c);
            hzVar.a(this.f594b);
            hzVar.b();
        }
        if (this.f596c != null) {
            hzVar.a(d);
            hzVar.a(this.f596c);
            hzVar.b();
        }
        hzVar.a(e);
        hzVar.a(this.f586a);
        hzVar.b();
        if (this.f597d != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f597d);
            hzVar.b();
        }
        if (this.f598e != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f598e);
            hzVar.b();
        }
        if (this.f588a != null && h()) {
            hzVar.a(h);
            this.f588a.b(hzVar);
            hzVar.b();
        }
        if (this.f599f != null && i()) {
            hzVar.a(i);
            hzVar.a(this.f599f);
            hzVar.b();
        }
        if (this.f600g != null && j()) {
            hzVar.a(j);
            hzVar.a(this.f600g);
            hzVar.b();
        }
        if (k()) {
            hzVar.a(k);
            hzVar.a(this.f593a);
            hzVar.b();
        }
        if (this.f601h != null && l()) {
            hzVar.a(l);
            hzVar.a(this.f601h);
            hzVar.b();
        }
        if (this.f602i != null && m()) {
            hzVar.a(m);
            hzVar.a(this.f602i);
            hzVar.b();
        }
        if (this.f603j != null && n()) {
            hzVar.a(n);
            hzVar.a(this.f603j);
            hzVar.b();
        }
        if (o()) {
            hzVar.a(o);
            hzVar.a(this.f592a);
            hzVar.b();
        }
        if (p()) {
            hzVar.a(p);
            hzVar.a(this.f595b);
            hzVar.b();
        }
        if (this.f604k != null && q()) {
            hzVar.a(q);
            hzVar.a(this.f604k);
            hzVar.b();
        }
        if (this.f605l != null && r()) {
            hzVar.a(r);
            hzVar.a(this.f605l);
            hzVar.b();
        }
        if (s()) {
            hzVar.a(s);
            hzVar.mo616a(this.f585a);
            hzVar.b();
        }
        if (this.f591a != null && t()) {
            hzVar.a(t);
            hzVar.a(new hy((byte) 11, (byte) 11, this.f591a.size()));
            for (Map.Entry<String, String> entry : this.f591a.entrySet()) {
                hzVar.a(entry.getKey());
                hzVar.a(entry.getValue());
            }
            hzVar.d();
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gu guVar) {
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
        if (!getClass().equals(guVar.getClass())) {
            return getClass().getName().compareTo(guVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m512a()).compareTo(Boolean.valueOf(guVar.m512a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m512a() && (a21 = hq.a(this.f589a, guVar.f589a)) != 0) {
            return a21;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(guVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a20 = hq.a(this.f587a, guVar.f587a)) != 0) {
            return a20;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(guVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a19 = hq.a(this.f594b, guVar.f594b)) != 0) {
            return a19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(guVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a18 = hq.a(this.f596c, guVar.f596c)) != 0) {
            return a18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(guVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a17 = hq.a(this.f586a, guVar.f586a)) != 0) {
            return a17;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(guVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a16 = hq.a(this.f597d, guVar.f597d)) != 0) {
            return a16;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(guVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a15 = hq.a(this.f598e, guVar.f598e)) != 0) {
            return a15;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(guVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a14 = hq.a(this.f588a, guVar.f588a)) != 0) {
            return a14;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(guVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a13 = hq.a(this.f599f, guVar.f599f)) != 0) {
            return a13;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(guVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a12 = hq.a(this.f600g, guVar.f600g)) != 0) {
            return a12;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(guVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a11 = hq.a(this.f593a, guVar.f593a)) != 0) {
            return a11;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(guVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a10 = hq.a(this.f601h, guVar.f601h)) != 0) {
            return a10;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(guVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a9 = hq.a(this.f602i, guVar.f602i)) != 0) {
            return a9;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(guVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a8 = hq.a(this.f603j, guVar.f603j)) != 0) {
            return a8;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(guVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a7 = hq.a(this.f592a, guVar.f592a)) != 0) {
            return a7;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(guVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a6 = hq.a(this.f595b, guVar.f595b)) != 0) {
            return a6;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(guVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a5 = hq.a(this.f604k, guVar.f604k)) != 0) {
            return a5;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(guVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a4 = hq.a(this.f605l, guVar.f605l)) != 0) {
            return a4;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(guVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a3 = hq.a(this.f585a, guVar.f585a)) != 0) {
            return a3;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(guVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (t() && (a2 = hq.a(this.f591a, guVar.f591a)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m513a(gu guVar) {
        if (guVar == null) {
            return false;
        }
        boolean m512a = m512a();
        boolean m512a2 = guVar.m512a();
        if ((m512a || m512a2) && (!m512a || !m512a2 || !this.f589a.equals(guVar.f589a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = guVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f587a.m511a(guVar.f587a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = guVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f594b.equals(guVar.f594b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = guVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f596c.equals(guVar.f596c))) || this.f586a != guVar.f586a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = guVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f597d.equals(guVar.f597d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = guVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f598e.equals(guVar.f598e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = guVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f588a.m575a(guVar.f588a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = guVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f599f.equals(guVar.f599f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = guVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f600g.equals(guVar.f600g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = guVar.k();
        if ((k2 || k3) && (!k2 || !k3 || this.f593a != guVar.f593a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = guVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f601h.equals(guVar.f601h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = guVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.f602i.equals(guVar.f602i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = guVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.f603j.equals(guVar.f603j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = guVar.o();
        if ((o2 || o3) && (!o2 || !o3 || this.f592a != guVar.f592a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = guVar.p();
        if ((p2 || p3) && (!p2 || !p3 || this.f595b != guVar.f595b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = guVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.f604k.equals(guVar.f604k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = guVar.r();
        if ((r2 || r3) && (!r2 || !r3 || !this.f605l.equals(guVar.f605l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = guVar.s();
        if ((s2 || s3) && (!s2 || !s3 || this.f585a != guVar.f585a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = guVar.t();
        if (t2 || t3) {
            if (!t2 || !t3 || !this.f591a.equals(guVar.f591a)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
