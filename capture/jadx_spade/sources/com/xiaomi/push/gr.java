package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gr implements hp<gr, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f559a;
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

    /* renamed from: a, reason: collision with other field name */
    public int f560a;

    /* renamed from: a, reason: collision with other field name */
    public long f561a;

    /* renamed from: a, reason: collision with other field name */
    public String f562a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f563a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f564a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f565a;

    /* renamed from: b, reason: collision with other field name */
    public int f566b;

    /* renamed from: b, reason: collision with other field name */
    public String f567b;

    /* renamed from: b, reason: collision with other field name */
    public Map<String, String> f568b;

    /* renamed from: c, reason: collision with other field name */
    public int f569c;

    /* renamed from: c, reason: collision with other field name */
    public String f570c;

    /* renamed from: c, reason: collision with other field name */
    public Map<String, String> f571c;

    /* renamed from: d, reason: collision with other field name */
    public String f572d;

    /* renamed from: e, reason: collision with other field name */
    public String f573e;

    public int hashCode() {
        return 0;
    }

    public int a() {
        return this.f560a;
    }

    public int b() {
        return this.f566b;
    }

    public int c() {
        return this.f569c;
    }

    public boolean l() {
        return this.f565a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m502a() {
        return this.f562a != null;
    }

    public void a(boolean z) {
        this.f563a.set(0, z);
    }

    public void a(String str, String str2) {
        if (this.f564a == null) {
            this.f564a = new HashMap();
        }
        this.f564a.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m503a(gr grVar) {
        if (grVar == null) {
            return false;
        }
        boolean m502a = m502a();
        boolean m502a2 = grVar.m502a();
        if (((m502a || m502a2) && !(m502a && m502a2 && this.f562a.equals(grVar.f562a))) || this.f561a != grVar.f561a) {
            return false;
        }
        boolean m508c = m508c();
        boolean m508c2 = grVar.m508c();
        if ((m508c || m508c2) && !(m508c && m508c2 && this.f567b.equals(grVar.f567b))) {
            return false;
        }
        boolean m509d = m509d();
        boolean m509d2 = grVar.m509d();
        if ((m509d || m509d2) && !(m509d && m509d2 && this.f570c.equals(grVar.f570c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = grVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f572d.equals(grVar.f572d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = grVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f560a == grVar.f560a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = grVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f573e.equals(grVar.f573e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = grVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f566b == grVar.f566b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = grVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f569c == grVar.f569c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = grVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f564a.equals(grVar.f564a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = grVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f568b.equals(grVar.f568b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = grVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f565a == grVar.f565a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = grVar.n();
        if (n || n2) {
            return n && n2 && this.f571c.equals(grVar.f571c);
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
                int i2 = 0;
                switch (mo607a.f830a) {
                    case 1:
                        if (b2 == 11) {
                            this.f562a = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 2:
                        if (b2 == 10) {
                            this.f561a = hzVar.mo606a();
                            a(true);
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 3:
                        if (b2 == 11) {
                            this.f567b = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 4:
                        if (b2 == 11) {
                            this.f570c = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 5:
                        if (b2 == 11) {
                            this.f572d = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        if (b2 == 8) {
                            this.f560a = hzVar.mo605a();
                            b(true);
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 7:
                        if (b2 == 11) {
                            this.f573e = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        if (b2 == 8) {
                            this.f566b = hzVar.mo605a();
                            c(true);
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 9:
                        if (b2 == 8) {
                            this.f569c = hzVar.mo605a();
                            d(true);
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 10:
                        if (b2 == 13) {
                            hy mo609a = hzVar.mo609a();
                            this.f564a = new HashMap(mo609a.f832a * 2);
                            while (i2 < mo609a.f832a) {
                                this.f564a.put(hzVar.mo612a(), hzVar.mo612a());
                                i2++;
                            }
                            hzVar.h();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 11:
                        if (b2 == 13) {
                            hy mo609a2 = hzVar.mo609a();
                            this.f568b = new HashMap(mo609a2.f832a * 2);
                            while (i2 < mo609a2.f832a) {
                                this.f568b.put(hzVar.mo612a(), hzVar.mo612a());
                                i2++;
                            }
                            hzVar.h();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                        if (b2 == 2) {
                            this.f565a = hzVar.mo617a();
                            e(true);
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                        if (b2 == 13) {
                            hy mo609a3 = hzVar.mo609a();
                            this.f571c = new HashMap(mo609a3.f832a * 2);
                            while (i2 < mo609a3.f832a) {
                                this.f571c.put(hzVar.mo612a(), hzVar.mo612a());
                                i2++;
                            }
                            hzVar.h();
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
            } else {
                hzVar.f();
                if (!m506b()) {
                    throw new ia("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m501a();
                return;
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m497a() {
        return this.f561a;
    }

    public String d() {
        return this.f572d;
    }

    public boolean f() {
        return this.f563a.get(1);
    }

    public boolean g() {
        if (this.f573e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        return this.f563a.get(2);
    }

    public boolean i() {
        return this.f563a.get(3);
    }

    public boolean j() {
        if (this.f564a != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f568b != null) {
            return true;
        }
        return false;
    }

    public boolean m() {
        return this.f563a.get(4);
    }

    public boolean n() {
        if (this.f571c != null) {
            return true;
        }
        return false;
    }

    public gr() {
        this.f563a = new BitSet(5);
        this.f565a = false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public gr m498a() {
        return new gr(this);
    }

    public boolean e() {
        if (this.f572d != null) {
            return true;
        }
        return false;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m504b() {
        return this.f567b;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m507c() {
        return this.f570c;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m509d() {
        if (this.f570c != null) {
            return true;
        }
        return false;
    }

    /* renamed from: b, reason: collision with other method in class */
    public Map<String, String> m505b() {
        return this.f568b;
    }

    static {
        Covode.recordClassIndex(655567);
        f559a = new ie("PushMetaInfo");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 10, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 11, (short) 5);
        f = new hw("", (byte) 8, (short) 6);
        g = new hw("", (byte) 11, (short) 7);
        h = new hw("", (byte) 8, (short) 8);
        i = new hw("", (byte) 8, (short) 9);
        j = new hw("", (byte) 13, (short) 10);
        k = new hw("", (byte) 13, (short) 11);
        l = new hw("", (byte) 2, (short) 12);
        m = new hw("", (byte) 13, (short) 13);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m508c() {
        if (this.f567b != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m499a() {
        return this.f562a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m500a() {
        return this.f564a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f562a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f561a);
        if (m508c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f567b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (m509d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f570c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f572d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f560a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f573e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f566b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f569c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f564a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f568b;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f565a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f571c;
            if (map3 == null) {
                sb.append("null");
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m506b() {
        return this.f563a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m501a() {
        if (this.f562a != null) {
            return;
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    public gr d(String str) {
        this.f572d = str;
        return this;
    }

    public gr b(int i2) {
        this.f566b = i2;
        c(true);
        return this;
    }

    public gr c(int i2) {
        this.f569c = i2;
        d(true);
        return this;
    }

    public void e(boolean z) {
        this.f563a.set(4, z);
    }

    public gr b(String str) {
        this.f567b = str;
        return this;
    }

    public gr c(String str) {
        this.f570c = str;
        return this;
    }

    public void d(boolean z) {
        this.f563a.set(3, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gr)) {
            return false;
        }
        return m503a((gr) obj);
    }

    public gr a(int i2) {
        this.f560a = i2;
        b(true);
        return this;
    }

    public gr a(String str) {
        this.f562a = str;
        return this;
    }

    public void c(boolean z) {
        this.f563a.set(2, z);
    }

    public gr a(Map<String, String> map) {
        this.f564a = map;
        return this;
    }

    public gr(gr grVar) {
        BitSet bitSet = new BitSet(5);
        this.f563a = bitSet;
        bitSet.clear();
        this.f563a.or(grVar.f563a);
        if (grVar.m502a()) {
            this.f562a = grVar.f562a;
        }
        this.f561a = grVar.f561a;
        if (grVar.m508c()) {
            this.f567b = grVar.f567b;
        }
        if (grVar.m509d()) {
            this.f570c = grVar.f570c;
        }
        if (grVar.e()) {
            this.f572d = grVar.f572d;
        }
        this.f560a = grVar.f560a;
        if (grVar.g()) {
            this.f573e = grVar.f573e;
        }
        this.f566b = grVar.f566b;
        this.f569c = grVar.f569c;
        if (grVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : grVar.f564a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f564a = hashMap;
        }
        if (grVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : grVar.f568b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f568b = hashMap2;
        }
        this.f565a = grVar.f565a;
        if (grVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : grVar.f571c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f571c = hashMap3;
        }
    }

    public void b(boolean z) {
        this.f563a.set(1, z);
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m501a();
        hzVar.a(f559a);
        if (this.f562a != null) {
            hzVar.a(a);
            hzVar.a(this.f562a);
            hzVar.b();
        }
        hzVar.a(b);
        hzVar.a(this.f561a);
        hzVar.b();
        if (this.f567b != null && m508c()) {
            hzVar.a(c);
            hzVar.a(this.f567b);
            hzVar.b();
        }
        if (this.f570c != null && m509d()) {
            hzVar.a(d);
            hzVar.a(this.f570c);
            hzVar.b();
        }
        if (this.f572d != null && e()) {
            hzVar.a(e);
            hzVar.a(this.f572d);
            hzVar.b();
        }
        if (f()) {
            hzVar.a(f);
            hzVar.mo616a(this.f560a);
            hzVar.b();
        }
        if (this.f573e != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f573e);
            hzVar.b();
        }
        if (h()) {
            hzVar.a(h);
            hzVar.mo616a(this.f566b);
            hzVar.b();
        }
        if (i()) {
            hzVar.a(i);
            hzVar.mo616a(this.f569c);
            hzVar.b();
        }
        if (this.f564a != null && j()) {
            hzVar.a(j);
            hzVar.a(new hy((byte) 11, (byte) 11, this.f564a.size()));
            for (Map.Entry<String, String> entry : this.f564a.entrySet()) {
                hzVar.a(entry.getKey());
                hzVar.a(entry.getValue());
            }
            hzVar.d();
            hzVar.b();
        }
        if (this.f568b != null && k()) {
            hzVar.a(k);
            hzVar.a(new hy((byte) 11, (byte) 11, this.f568b.size()));
            for (Map.Entry<String, String> entry2 : this.f568b.entrySet()) {
                hzVar.a(entry2.getKey());
                hzVar.a(entry2.getValue());
            }
            hzVar.d();
            hzVar.b();
        }
        if (m()) {
            hzVar.a(l);
            hzVar.a(this.f565a);
            hzVar.b();
        }
        if (this.f571c != null && n()) {
            hzVar.a(m);
            hzVar.a(new hy((byte) 11, (byte) 11, this.f571c.size()));
            for (Map.Entry<String, String> entry3 : this.f571c.entrySet()) {
                hzVar.a(entry3.getKey());
                hzVar.a(entry3.getValue());
            }
            hzVar.d();
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gr grVar) {
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
        if (!getClass().equals(grVar.getClass())) {
            return getClass().getName().compareTo(grVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m502a()).compareTo(Boolean.valueOf(grVar.m502a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m502a() && (a14 = hq.a(this.f562a, grVar.f562a)) != 0) {
            return a14;
        }
        int compareTo2 = Boolean.valueOf(m506b()).compareTo(Boolean.valueOf(grVar.m506b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m506b() && (a13 = hq.a(this.f561a, grVar.f561a)) != 0) {
            return a13;
        }
        int compareTo3 = Boolean.valueOf(m508c()).compareTo(Boolean.valueOf(grVar.m508c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m508c() && (a12 = hq.a(this.f567b, grVar.f567b)) != 0) {
            return a12;
        }
        int compareTo4 = Boolean.valueOf(m509d()).compareTo(Boolean.valueOf(grVar.m509d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m509d() && (a11 = hq.a(this.f570c, grVar.f570c)) != 0) {
            return a11;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(grVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a10 = hq.a(this.f572d, grVar.f572d)) != 0) {
            return a10;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(grVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a9 = hq.a(this.f560a, grVar.f560a)) != 0) {
            return a9;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(grVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a8 = hq.a(this.f573e, grVar.f573e)) != 0) {
            return a8;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(grVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a7 = hq.a(this.f566b, grVar.f566b)) != 0) {
            return a7;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(grVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a6 = hq.a(this.f569c, grVar.f569c)) != 0) {
            return a6;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(grVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a5 = hq.a(this.f564a, grVar.f564a)) != 0) {
            return a5;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(grVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a4 = hq.a(this.f568b, grVar.f568b)) != 0) {
            return a4;
        }
        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(grVar.m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m() && (a3 = hq.a(this.f565a, grVar.f565a)) != 0) {
            return a3;
        }
        int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(grVar.n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (n() && (a2 = hq.a(this.f571c, grVar.f571c)) != 0) {
            return a2;
        }
        return 0;
    }

    public void b(String str, String str2) {
        if (this.f568b == null) {
            this.f568b = new HashMap();
        }
        this.f568b.put(str, str2);
    }
}
