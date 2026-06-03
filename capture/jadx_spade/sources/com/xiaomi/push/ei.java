package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ei implements hp<ei, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f360a;
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
    public byte f361a;

    /* renamed from: a, reason: collision with other field name */
    public int f362a;

    /* renamed from: a, reason: collision with other field name */
    public String f363a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f364a = new BitSet(6);

    /* renamed from: b, reason: collision with other field name */
    public int f365b;

    /* renamed from: b, reason: collision with other field name */
    public String f366b;

    /* renamed from: c, reason: collision with other field name */
    public int f367c;

    /* renamed from: c, reason: collision with other field name */
    public String f368c;

    /* renamed from: d, reason: collision with other field name */
    public int f369d;

    /* renamed from: d, reason: collision with other field name */
    public String f370d;

    /* renamed from: e, reason: collision with other field name */
    public int f371e;

    public int hashCode() {
        return 0;
    }

    public boolean g() {
        if (this.f368c != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f370d != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        return this.f364a.get(4);
    }

    public boolean j() {
        return this.f364a.get(5);
    }

    public boolean e() {
        if (this.f366b != null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.f364a.get(3);
    }

    public void a() {
        if (this.f363a != null) {
            return;
        }
        throw new ia("Required field 'connpt' was not present! Struct: " + toString());
    }

    public boolean b() {
        return this.f364a.get(1);
    }

    public boolean c() {
        return this.f364a.get(2);
    }

    public boolean d() {
        if (this.f363a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655487);
        f360a = new ie("StatsEvent");
        a = new hw("", (byte) 3, (short) 1);
        b = new hw("", (byte) 8, (short) 2);
        c = new hw("", (byte) 8, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 11, (short) 5);
        f = new hw("", (byte) 8, (short) 6);
        g = new hw("", (byte) 11, (short) 7);
        h = new hw("", (byte) 11, (short) 8);
        i = new hw("", (byte) 8, (short) 9);
        j = new hw("", (byte) 8, (short) 10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m379a() {
        return this.f364a.get(0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f361a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f362a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f365b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f363a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f366b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f367c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f368c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f370d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f369d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f371e);
        }
        sb.append(")");
        return sb.toString();
    }

    public ei a(String str) {
        this.f363a = str;
        return this;
    }

    public ei b(String str) {
        this.f366b = str;
        return this;
    }

    public ei c(String str) {
        this.f368c = str;
        return this;
    }

    public ei d(String str) {
        this.f370d = str;
        return this;
    }

    public ei a(byte b2) {
        this.f361a = b2;
        a(true);
        return this;
    }

    public ei b(int i2) {
        this.f365b = i2;
        c(true);
        return this;
    }

    public ei c(int i2) {
        this.f367c = i2;
        d(true);
        return this;
    }

    public ei d(int i2) {
        this.f369d = i2;
        e(true);
        return this;
    }

    public void e(boolean z) {
        this.f364a.set(4, z);
    }

    public void f(boolean z) {
        this.f364a.set(5, z);
    }

    public ei a(int i2) {
        this.f362a = i2;
        b(true);
        return this;
    }

    public void b(boolean z) {
        this.f364a.set(1, z);
    }

    public void c(boolean z) {
        this.f364a.set(2, z);
    }

    public void d(boolean z) {
        this.f364a.set(3, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ei)) {
            return false;
        }
        return m380a((ei) obj);
    }

    public void a(boolean z) {
        this.f364a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m380a(ei eiVar) {
        if (eiVar == null || this.f361a != eiVar.f361a || this.f362a != eiVar.f362a || this.f365b != eiVar.f365b) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = eiVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f363a.equals(eiVar.f363a))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = eiVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f366b.equals(eiVar.f366b))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = eiVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f367c != eiVar.f367c)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = eiVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f368c.equals(eiVar.f368c))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = eiVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f370d.equals(eiVar.f370d))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = eiVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f369d != eiVar.f369d)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = eiVar.j();
        if (j2 || j3) {
            if (!j2 || !j3 || this.f371e != eiVar.f371e) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        a();
        hzVar.a(f360a);
        hzVar.a(a);
        hzVar.a(this.f361a);
        hzVar.b();
        hzVar.a(b);
        hzVar.mo616a(this.f362a);
        hzVar.b();
        hzVar.a(c);
        hzVar.mo616a(this.f365b);
        hzVar.b();
        if (this.f363a != null) {
            hzVar.a(d);
            hzVar.a(this.f363a);
            hzVar.b();
        }
        if (this.f366b != null && e()) {
            hzVar.a(e);
            hzVar.a(this.f366b);
            hzVar.b();
        }
        if (f()) {
            hzVar.a(f);
            hzVar.mo616a(this.f367c);
            hzVar.b();
        }
        if (this.f368c != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f368c);
            hzVar.b();
        }
        if (this.f370d != null && h()) {
            hzVar.a(h);
            hzVar.a(this.f370d);
            hzVar.b();
        }
        if (i()) {
            hzVar.a(i);
            hzVar.mo616a(this.f369d);
            hzVar.b();
        }
        if (j()) {
            hzVar.a(j);
            hzVar.mo616a(this.f371e);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ei eiVar) {
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
        if (!getClass().equals(eiVar.getClass())) {
            return getClass().getName().compareTo(eiVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m379a()).compareTo(Boolean.valueOf(eiVar.m379a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m379a() && (a11 = hq.a(this.f361a, eiVar.f361a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(eiVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = hq.a(this.f362a, eiVar.f362a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(eiVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = hq.a(this.f365b, eiVar.f365b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(eiVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = hq.a(this.f363a, eiVar.f363a)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(eiVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = hq.a(this.f366b, eiVar.f366b)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(eiVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = hq.a(this.f367c, eiVar.f367c)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(eiVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = hq.a(this.f368c, eiVar.f368c)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(eiVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = hq.a(this.f370d, eiVar.f370d)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(eiVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = hq.a(this.f369d, eiVar.f369d)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(eiVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a2 = hq.a(this.f371e, eiVar.f371e)) != 0) {
            return a2;
        }
        return 0;
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                if (m379a()) {
                    if (b()) {
                        if (c()) {
                            a();
                            return;
                        }
                        throw new ia("Required field 'value' was not found in serialized data! Struct: " + toString());
                    }
                    throw new ia("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                throw new ia("Required field 'chid' was not found in serialized data! Struct: " + toString());
            }
            switch (mo607a.f830a) {
                case 1:
                    if (b2 == 3) {
                        this.f361a = hzVar.a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 8) {
                        this.f362a = hzVar.mo605a();
                        b(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 8) {
                        this.f365b = hzVar.mo605a();
                        c(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f363a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f366b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    if (b2 == 8) {
                        this.f367c = hzVar.mo605a();
                        d(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f368c = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 11) {
                        this.f370d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 8) {
                        this.f369d = hzVar.mo605a();
                        e(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 8) {
                        this.f371e = hzVar.mo605a();
                        f(true);
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
}
