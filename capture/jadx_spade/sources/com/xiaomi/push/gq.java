package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gq implements hp<gq, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f539a;
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

    /* renamed from: a, reason: collision with other field name */
    public long f540a;

    /* renamed from: a, reason: collision with other field name */
    public gr f541a;

    /* renamed from: a, reason: collision with other field name */
    public gt f542a;

    /* renamed from: a, reason: collision with other field name */
    public String f543a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f544a = new BitSet(4);

    /* renamed from: a, reason: collision with other field name */
    public boolean f545a = false;

    /* renamed from: b, reason: collision with other field name */
    public long f546b;

    /* renamed from: b, reason: collision with other field name */
    public String f547b;

    /* renamed from: c, reason: collision with other field name */
    public long f548c;

    /* renamed from: c, reason: collision with other field name */
    public String f549c;

    /* renamed from: d, reason: collision with other field name */
    public String f550d;

    /* renamed from: e, reason: collision with other field name */
    public String f551e;

    /* renamed from: f, reason: collision with other field name */
    public String f552f;

    /* renamed from: g, reason: collision with other field name */
    public String f553g;

    /* renamed from: h, reason: collision with other field name */
    public String f554h;

    /* renamed from: i, reason: collision with other field name */
    public String f555i;

    /* renamed from: j, reason: collision with other field name */
    public String f556j;

    /* renamed from: k, reason: collision with other field name */
    public String f557k;

    /* renamed from: l, reason: collision with other field name */
    public String f558l;

    public int hashCode() {
        return 0;
    }

    public long a() {
        return this.f540a;
    }

    public String b() {
        return this.f547b;
    }

    public String c() {
        return this.f549c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m491a() {
        return this.f543a;
    }

    public boolean e() {
        return this.f544a.get(0);
    }

    public boolean f() {
        return this.f544a.get(1);
    }

    public boolean g() {
        if (this.f550d != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f551e != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f552f != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f553g != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f554h != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.f541a != null) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (this.f555i != null) {
            return true;
        }
        return false;
    }

    public boolean n() {
        return this.f544a.get(2);
    }

    public boolean o() {
        if (this.f556j != null) {
            return true;
        }
        return false;
    }

    public boolean p() {
        return this.f544a.get(3);
    }

    public boolean q() {
        if (this.f557k != null) {
            return true;
        }
        return false;
    }

    public boolean r() {
        if (this.f558l != null) {
            return true;
        }
        return false;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m495b() {
        if (this.f543a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m496c() {
        if (this.f547b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f549c != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m493a() {
        if (this.f542a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m492a() {
        if (this.f543a != null) {
            if (this.f547b != null) {
                if (this.f549c != null) {
                    return;
                }
                throw new ia("Required field 'payload' was not present! Struct: " + toString());
            }
            throw new ia("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    static {
        Covode.recordClassIndex(655566);
        f539a = new ie("PushMessage");
        a = new hw("", (byte) 12, (short) 1);
        b = new hw("", (byte) 11, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 10, (short) 5);
        f = new hw("", (byte) 10, (short) 6);
        g = new hw("", (byte) 11, (short) 7);
        h = new hw("", (byte) 11, (short) 8);
        i = new hw("", (byte) 11, (short) 9);
        j = new hw("", (byte) 11, (short) 10);
        k = new hw("", (byte) 11, (short) 11);
        l = new hw("", (byte) 12, (short) 12);
        m = new hw("", (byte) 11, (short) 13);
        n = new hw("", (byte) 2, (short) 14);
        o = new hw("", (byte) 11, (short) 15);
        p = new hw("", (byte) 10, (short) 16);
        q = new hw("", (byte) 11, (short) 20);
        r = new hw("", (byte) 11, (short) 21);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m493a()) {
            sb.append("to:");
            gt gtVar = this.f542a;
            if (gtVar == null) {
                sb.append("null");
            } else {
                sb.append(gtVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f543a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f547b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f549c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f540a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f546b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f550d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f551e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f552f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f553g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f554h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            gr grVar = this.f541a;
            if (grVar == null) {
                sb.append("null");
            } else {
                sb.append(grVar);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f555i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f545a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f556j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f548c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f557k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f558l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void b(boolean z) {
        this.f544a.set(1, z);
    }

    public void c(boolean z) {
        this.f544a.set(2, z);
    }

    public void d(boolean z) {
        this.f544a.set(3, z);
    }

    public void a(boolean z) {
        this.f544a.set(0, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gq)) {
            return false;
        }
        return m494a((gq) obj);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                m492a();
                return;
            }
            short s = mo607a.f830a;
            if (s != 20) {
                if (s != 21) {
                    switch (s) {
                        case 1:
                            if (b2 == 12) {
                                gt gtVar = new gt();
                                this.f542a = gtVar;
                                gtVar.a(hzVar);
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 2:
                            if (b2 == 11) {
                                this.f543a = hzVar.mo612a();
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 3:
                            if (b2 == 11) {
                                this.f547b = hzVar.mo612a();
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 4:
                            if (b2 == 11) {
                                this.f549c = hzVar.mo612a();
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 5:
                            if (b2 == 10) {
                                this.f540a = hzVar.mo606a();
                                a(true);
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            if (b2 == 10) {
                                this.f546b = hzVar.mo606a();
                                b(true);
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 7:
                            if (b2 == 11) {
                                this.f550d = hzVar.mo612a();
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                            if (b2 == 11) {
                                this.f551e = hzVar.mo612a();
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 9:
                            if (b2 == 11) {
                                this.f552f = hzVar.mo612a();
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 10:
                            if (b2 == 11) {
                                this.f553g = hzVar.mo612a();
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 11:
                            if (b2 == 11) {
                                this.f554h = hzVar.mo612a();
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                            if (b2 == 12) {
                                gr grVar = new gr();
                                this.f541a = grVar;
                                grVar.a(hzVar);
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                            if (b2 == 11) {
                                this.f555i = hzVar.mo612a();
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 14:
                            if (b2 == 2) {
                                this.f545a = hzVar.mo617a();
                                c(true);
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 15:
                            if (b2 == 11) {
                                this.f556j = hzVar.mo612a();
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        case 16:
                            if (b2 == 10) {
                                this.f548c = hzVar.mo606a();
                                d(true);
                                break;
                            } else {
                                ic.a(hzVar, b2);
                                break;
                            }
                        default:
                            ic.a(hzVar, b2);
                            break;
                    }
                } else if (b2 == 11) {
                    this.f558l = hzVar.mo612a();
                } else {
                    ic.a(hzVar, b2);
                }
            } else if (b2 == 11) {
                this.f557k = hzVar.mo612a();
            } else {
                ic.a(hzVar, b2);
            }
            hzVar.g();
        }
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m492a();
        hzVar.a(f539a);
        if (this.f542a != null && m493a()) {
            hzVar.a(a);
            this.f542a.b(hzVar);
            hzVar.b();
        }
        if (this.f543a != null) {
            hzVar.a(b);
            hzVar.a(this.f543a);
            hzVar.b();
        }
        if (this.f547b != null) {
            hzVar.a(c);
            hzVar.a(this.f547b);
            hzVar.b();
        }
        if (this.f549c != null) {
            hzVar.a(d);
            hzVar.a(this.f549c);
            hzVar.b();
        }
        if (e()) {
            hzVar.a(e);
            hzVar.a(this.f540a);
            hzVar.b();
        }
        if (f()) {
            hzVar.a(f);
            hzVar.a(this.f546b);
            hzVar.b();
        }
        if (this.f550d != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f550d);
            hzVar.b();
        }
        if (this.f551e != null && h()) {
            hzVar.a(h);
            hzVar.a(this.f551e);
            hzVar.b();
        }
        if (this.f552f != null && i()) {
            hzVar.a(i);
            hzVar.a(this.f552f);
            hzVar.b();
        }
        if (this.f553g != null && j()) {
            hzVar.a(j);
            hzVar.a(this.f553g);
            hzVar.b();
        }
        if (this.f554h != null && k()) {
            hzVar.a(k);
            hzVar.a(this.f554h);
            hzVar.b();
        }
        if (this.f541a != null && l()) {
            hzVar.a(l);
            this.f541a.b(hzVar);
            hzVar.b();
        }
        if (this.f555i != null && m()) {
            hzVar.a(m);
            hzVar.a(this.f555i);
            hzVar.b();
        }
        if (n()) {
            hzVar.a(n);
            hzVar.a(this.f545a);
            hzVar.b();
        }
        if (this.f556j != null && o()) {
            hzVar.a(o);
            hzVar.a(this.f556j);
            hzVar.b();
        }
        if (p()) {
            hzVar.a(p);
            hzVar.a(this.f548c);
            hzVar.b();
        }
        if (this.f557k != null && q()) {
            hzVar.a(q);
            hzVar.a(this.f557k);
            hzVar.b();
        }
        if (this.f558l != null && r()) {
            hzVar.a(r);
            hzVar.a(this.f558l);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gq gqVar) {
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
        if (!getClass().equals(gqVar.getClass())) {
            return getClass().getName().compareTo(gqVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m493a()).compareTo(Boolean.valueOf(gqVar.m493a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m493a() && (a19 = hq.a(this.f542a, gqVar.f542a)) != 0) {
            return a19;
        }
        int compareTo2 = Boolean.valueOf(m495b()).compareTo(Boolean.valueOf(gqVar.m495b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m495b() && (a18 = hq.a(this.f543a, gqVar.f543a)) != 0) {
            return a18;
        }
        int compareTo3 = Boolean.valueOf(m496c()).compareTo(Boolean.valueOf(gqVar.m496c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m496c() && (a17 = hq.a(this.f547b, gqVar.f547b)) != 0) {
            return a17;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gqVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a16 = hq.a(this.f549c, gqVar.f549c)) != 0) {
            return a16;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gqVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a15 = hq.a(this.f540a, gqVar.f540a)) != 0) {
            return a15;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gqVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a14 = hq.a(this.f546b, gqVar.f546b)) != 0) {
            return a14;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gqVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a13 = hq.a(this.f550d, gqVar.f550d)) != 0) {
            return a13;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gqVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a12 = hq.a(this.f551e, gqVar.f551e)) != 0) {
            return a12;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gqVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a11 = hq.a(this.f552f, gqVar.f552f)) != 0) {
            return a11;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gqVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a10 = hq.a(this.f553g, gqVar.f553g)) != 0) {
            return a10;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gqVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a9 = hq.a(this.f554h, gqVar.f554h)) != 0) {
            return a9;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(gqVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a8 = hq.a(this.f541a, gqVar.f541a)) != 0) {
            return a8;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gqVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a7 = hq.a(this.f555i, gqVar.f555i)) != 0) {
            return a7;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gqVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a6 = hq.a(this.f545a, gqVar.f545a)) != 0) {
            return a6;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(gqVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a5 = hq.a(this.f556j, gqVar.f556j)) != 0) {
            return a5;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(gqVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a4 = hq.a(this.f548c, gqVar.f548c)) != 0) {
            return a4;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(gqVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a3 = hq.a(this.f557k, gqVar.f557k)) != 0) {
            return a3;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(gqVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a2 = hq.a(this.f558l, gqVar.f558l)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m494a(gq gqVar) {
        if (gqVar == null) {
            return false;
        }
        boolean m493a = m493a();
        boolean m493a2 = gqVar.m493a();
        if ((m493a || m493a2) && (!m493a || !m493a2 || !this.f542a.m511a(gqVar.f542a))) {
            return false;
        }
        boolean m495b = m495b();
        boolean m495b2 = gqVar.m495b();
        if ((m495b || m495b2) && (!m495b || !m495b2 || !this.f543a.equals(gqVar.f543a))) {
            return false;
        }
        boolean m496c = m496c();
        boolean m496c2 = gqVar.m496c();
        if ((m496c || m496c2) && (!m496c || !m496c2 || !this.f547b.equals(gqVar.f547b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gqVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f549c.equals(gqVar.f549c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = gqVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f540a != gqVar.f540a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gqVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f546b != gqVar.f546b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = gqVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f550d.equals(gqVar.f550d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = gqVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f551e.equals(gqVar.f551e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gqVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f552f.equals(gqVar.f552f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = gqVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f553g.equals(gqVar.f553g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = gqVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f554h.equals(gqVar.f554h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = gqVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f541a.m503a(gqVar.f541a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = gqVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.f555i.equals(gqVar.f555i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = gqVar.n();
        if ((n2 || n3) && (!n2 || !n3 || this.f545a != gqVar.f545a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = gqVar.o();
        if ((o2 || o3) && (!o2 || !o3 || !this.f556j.equals(gqVar.f556j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = gqVar.p();
        if ((p2 || p3) && (!p2 || !p3 || this.f548c != gqVar.f548c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = gqVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.f557k.equals(gqVar.f557k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = gqVar.r();
        if (r2 || r3) {
            if (!r2 || !r3 || !this.f558l.equals(gqVar.f558l)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
