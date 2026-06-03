package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hd implements hp<hd, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f662a;
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

    /* renamed from: a, reason: collision with other field name */
    public long f663a;

    /* renamed from: a, reason: collision with other field name */
    public gt f664a;

    /* renamed from: a, reason: collision with other field name */
    public String f665a;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f666a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f667a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f668a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f669a;

    /* renamed from: b, reason: collision with other field name */
    public String f670b;

    /* renamed from: b, reason: collision with other field name */
    public boolean f671b;

    /* renamed from: c, reason: collision with other field name */
    public String f672c;

    /* renamed from: d, reason: collision with other field name */
    public String f673d;

    /* renamed from: e, reason: collision with other field name */
    public String f674e;

    /* renamed from: f, reason: collision with other field name */
    public String f675f;

    /* renamed from: g, reason: collision with other field name */
    public String f676g;

    /* renamed from: h, reason: collision with other field name */
    public String f677h;

    /* renamed from: i, reason: collision with other field name */
    public String f678i;

    public int hashCode() {
        return 0;
    }

    public gt a() {
        return this.f664a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m552a() {
        return this.f665a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m551a(boolean z) {
        this.f667a.set(0, z);
    }

    public void a(String str, String str2) {
        if (this.f668a == null) {
            this.f668a = new HashMap();
        }
        this.f668a.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m554a() {
        a(hq.a(this.f666a));
        return this.f666a.array();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m553a(hd hdVar) {
        if (hdVar == null) {
            return false;
        }
        boolean m552a = m552a();
        boolean m552a2 = hdVar.m552a();
        if ((m552a || m552a2) && !(m552a && m552a2 && this.f665a.equals(hdVar.f665a))) {
            return false;
        }
        boolean m555b = m555b();
        boolean m555b2 = hdVar.m555b();
        if ((m555b || m555b2) && !(m555b && m555b2 && this.f664a.m511a(hdVar.f664a))) {
            return false;
        }
        boolean m556c = m556c();
        boolean m556c2 = hdVar.m556c();
        if ((m556c || m556c2) && !(m556c && m556c2 && this.f670b.equals(hdVar.f670b))) {
            return false;
        }
        boolean m557d = m557d();
        boolean m557d2 = hdVar.m557d();
        if ((m557d || m557d2) && !(m557d && m557d2 && this.f672c.equals(hdVar.f672c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hdVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f673d.equals(hdVar.f673d))) || this.f669a != hdVar.f669a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hdVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f674e.equals(hdVar.f674e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hdVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f668a.equals(hdVar.f668a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hdVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f675f.equals(hdVar.f675f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hdVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f676g.equals(hdVar.f676g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hdVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f677h.equals(hdVar.f677h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hdVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f678i.equals(hdVar.f678i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hdVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f666a.equals(hdVar.f666a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hdVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f663a == hdVar.f663a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hdVar.o();
        if (o2 || o3) {
            return o2 && o3 && this.f671b == hdVar.f671b;
        }
        return true;
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 != 0) {
                switch (mo607a.f830a) {
                    case 1:
                        if (b2 == 11) {
                            this.f665a = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 2:
                        if (b2 == 12) {
                            gt gtVar = new gt();
                            this.f664a = gtVar;
                            gtVar.a(hzVar);
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 3:
                        if (b2 == 11) {
                            this.f670b = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 4:
                        if (b2 == 11) {
                            this.f672c = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 5:
                        if (b2 == 11) {
                            this.f673d = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        if (b2 == 2) {
                            this.f669a = hzVar.mo617a();
                            m551a(true);
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 7:
                        if (b2 == 11) {
                            this.f674e = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        if (b2 == 13) {
                            hy mo609a = hzVar.mo609a();
                            this.f668a = new HashMap(mo609a.f832a * 2);
                            for (int i2 = 0; i2 < mo609a.f832a; i2++) {
                                this.f668a.put(hzVar.mo612a(), hzVar.mo612a());
                            }
                            hzVar.h();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 9:
                        if (b2 == 11) {
                            this.f675f = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 10:
                        if (b2 == 11) {
                            this.f676g = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 11:
                    case 16:
                    case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                    case 18:
                    case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                    default:
                        ic.a(hzVar, b2);
                        break;
                    case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                        if (b2 == 11) {
                            this.f677h = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                        if (b2 == 11) {
                            this.f678i = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 14:
                        if (b2 == 11) {
                            this.f666a = hzVar.mo613a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 15:
                        if (b2 == 10) {
                            this.f663a = hzVar.mo606a();
                            b(true);
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                        if (b2 == 2) {
                            this.f671b = hzVar.mo617a();
                            c(true);
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                }
                hzVar.g();
            } else {
                hzVar.f();
                if (!f()) {
                    throw new ia("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m550a();
                return;
            }
        }
    }

    public String b() {
        return this.f672c;
    }

    public String c() {
        return this.f673d;
    }

    public String d() {
        return this.f675f;
    }

    public boolean e() {
        if (this.f673d != null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.f667a.get(0);
    }

    public boolean g() {
        if (this.f674e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f668a != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f675f != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f676g != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f677h != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.f678i != null) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (this.f666a != null) {
            return true;
        }
        return false;
    }

    public boolean n() {
        return this.f667a.get(1);
    }

    public boolean o() {
        return this.f667a.get(2);
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m557d() {
        if (this.f672c != null) {
            return true;
        }
        return false;
    }

    public hd() {
        this.f667a = new BitSet(3);
        this.f669a = true;
        this.f671b = false;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m555b() {
        if (this.f664a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m556c() {
        if (this.f670b != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655580);
        f662a = new ie("XmPushActionNotification");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 12, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 11, (short) 5);
        f = new hw("", (byte) 2, (short) 6);
        g = new hw("", (byte) 11, (short) 7);
        h = new hw("", (byte) 13, (short) 8);
        i = new hw("", (byte) 11, (short) 9);
        j = new hw("", (byte) 11, (short) 10);
        k = new hw("", (byte) 11, (short) 12);
        l = new hw("", (byte) 11, (short) 13);
        m = new hw("", (byte) 11, (short) 14);
        n = new hw("", (byte) 10, (short) 15);
        o = new hw("", (byte) 2, (short) 20);
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m548a() {
        return this.f670b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m549a() {
        return this.f668a;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = false;
        if (m552a()) {
            sb.append("debug:");
            String str = this.f665a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m555b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gt gtVar = this.f664a;
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
        String str2 = this.f670b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (m557d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f672c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f673d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f669a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f674e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f668a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f675f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f676g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f677h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f678i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f666a;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                hq.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f663a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f671b);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m550a() {
        if (this.f670b != null) {
            return;
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    public hd b(String str) {
        this.f672c = str;
        return this;
    }

    public hd c(String str) {
        this.f673d = str;
        return this;
    }

    public hd d(String str) {
        this.f675f = str;
        return this;
    }

    public hd a(String str) {
        this.f670b = str;
        return this;
    }

    public hd a(ByteBuffer byteBuffer) {
        this.f666a = byteBuffer;
        return this;
    }

    public void b(boolean z) {
        this.f667a.set(1, z);
    }

    public void c(boolean z) {
        this.f667a.set(2, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hd)) {
            return false;
        }
        return m553a((hd) obj);
    }

    public hd a(Map<String, String> map) {
        this.f668a = map;
        return this;
    }

    public hd a(boolean z) {
        this.f669a = z;
        m551a(true);
        return this;
    }

    public hd a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m550a();
        hzVar.a(f662a);
        if (this.f665a != null && m552a()) {
            hzVar.a(a);
            hzVar.a(this.f665a);
            hzVar.b();
        }
        if (this.f664a != null && m555b()) {
            hzVar.a(b);
            this.f664a.b(hzVar);
            hzVar.b();
        }
        if (this.f670b != null) {
            hzVar.a(c);
            hzVar.a(this.f670b);
            hzVar.b();
        }
        if (this.f672c != null && m557d()) {
            hzVar.a(d);
            hzVar.a(this.f672c);
            hzVar.b();
        }
        if (this.f673d != null && e()) {
            hzVar.a(e);
            hzVar.a(this.f673d);
            hzVar.b();
        }
        hzVar.a(f);
        hzVar.a(this.f669a);
        hzVar.b();
        if (this.f674e != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f674e);
            hzVar.b();
        }
        if (this.f668a != null && h()) {
            hzVar.a(h);
            hzVar.a(new hy((byte) 11, (byte) 11, this.f668a.size()));
            for (Map.Entry<String, String> entry : this.f668a.entrySet()) {
                hzVar.a(entry.getKey());
                hzVar.a(entry.getValue());
            }
            hzVar.d();
            hzVar.b();
        }
        if (this.f675f != null && i()) {
            hzVar.a(i);
            hzVar.a(this.f675f);
            hzVar.b();
        }
        if (this.f676g != null && j()) {
            hzVar.a(j);
            hzVar.a(this.f676g);
            hzVar.b();
        }
        if (this.f677h != null && k()) {
            hzVar.a(k);
            hzVar.a(this.f677h);
            hzVar.b();
        }
        if (this.f678i != null && l()) {
            hzVar.a(l);
            hzVar.a(this.f678i);
            hzVar.b();
        }
        if (this.f666a != null && m()) {
            hzVar.a(m);
            hzVar.a(this.f666a);
            hzVar.b();
        }
        if (n()) {
            hzVar.a(n);
            hzVar.a(this.f663a);
            hzVar.b();
        }
        if (o()) {
            hzVar.a(o);
            hzVar.a(this.f671b);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hd hdVar) {
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
        if (!getClass().equals(hdVar.getClass())) {
            return getClass().getName().compareTo(hdVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m552a()).compareTo(Boolean.valueOf(hdVar.m552a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m552a() && (a16 = hq.a(this.f665a, hdVar.f665a)) != 0) {
            return a16;
        }
        int compareTo2 = Boolean.valueOf(m555b()).compareTo(Boolean.valueOf(hdVar.m555b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m555b() && (a15 = hq.a(this.f664a, hdVar.f664a)) != 0) {
            return a15;
        }
        int compareTo3 = Boolean.valueOf(m556c()).compareTo(Boolean.valueOf(hdVar.m556c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m556c() && (a14 = hq.a(this.f670b, hdVar.f670b)) != 0) {
            return a14;
        }
        int compareTo4 = Boolean.valueOf(m557d()).compareTo(Boolean.valueOf(hdVar.m557d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m557d() && (a13 = hq.a(this.f672c, hdVar.f672c)) != 0) {
            return a13;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hdVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a12 = hq.a(this.f673d, hdVar.f673d)) != 0) {
            return a12;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hdVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a11 = hq.a(this.f669a, hdVar.f669a)) != 0) {
            return a11;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hdVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a10 = hq.a(this.f674e, hdVar.f674e)) != 0) {
            return a10;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hdVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a9 = hq.a(this.f668a, hdVar.f668a)) != 0) {
            return a9;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hdVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a8 = hq.a(this.f675f, hdVar.f675f)) != 0) {
            return a8;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hdVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a7 = hq.a(this.f676g, hdVar.f676g)) != 0) {
            return a7;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hdVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a6 = hq.a(this.f677h, hdVar.f677h)) != 0) {
            return a6;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hdVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a5 = hq.a(this.f678i, hdVar.f678i)) != 0) {
            return a5;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hdVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a4 = hq.a(this.f666a, hdVar.f666a)) != 0) {
            return a4;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hdVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a3 = hq.a(this.f663a, hdVar.f663a)) != 0) {
            return a3;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hdVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a2 = hq.a(this.f671b, hdVar.f671b)) != 0) {
            return a2;
        }
        return 0;
    }

    public hd(String str, boolean z) {
        this();
        this.f670b = str;
        this.f669a = z;
        m551a(true);
    }
}
