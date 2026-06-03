package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gz implements hp<gz, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f636a;
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
    public long f637a;

    /* renamed from: a, reason: collision with other field name */
    public gt f638a;

    /* renamed from: a, reason: collision with other field name */
    public String f639a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f641a;

    /* renamed from: b, reason: collision with other field name */
    public String f643b;

    /* renamed from: c, reason: collision with other field name */
    public String f644c;

    /* renamed from: d, reason: collision with other field name */
    public String f645d;

    /* renamed from: e, reason: collision with other field name */
    public String f646e;

    /* renamed from: f, reason: collision with other field name */
    public String f647f;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f640a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f642a = true;

    public int hashCode() {
        return 0;
    }

    public String a() {
        return this.f639a;
    }

    public String b() {
        return this.f644c;
    }

    public String c() {
        return this.f647f;
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m527a() {
        return this.f641a;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m532c() {
        if (this.f643b != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f644c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f640a.get(0);
    }

    public boolean f() {
        if (this.f645d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f646e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f641a != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f647f != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        return this.f640a.get(1);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m531b() {
        if (this.f639a != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m529a() {
        if (this.f638a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655575);
        f636a = new ie("XmPushActionCommandResult");
        a = new hw("", (byte) 12, (short) 2);
        b = new hw("", (byte) 11, (short) 3);
        c = new hw("", (byte) 11, (short) 4);
        d = new hw("", (byte) 11, (short) 5);
        e = new hw("", (byte) 10, (short) 7);
        f = new hw("", (byte) 11, (short) 8);
        g = new hw("", (byte) 11, (short) 9);
        h = new hw("", (byte) 15, (short) 10);
        i = new hw("", (byte) 11, (short) 12);
        j = new hw("", (byte) 2, (short) 13);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m528a() {
        if (this.f639a != null) {
            if (this.f643b != null) {
                if (this.f644c != null) {
                    return;
                }
                throw new ia("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new ia("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m529a()) {
            sb.append("target:");
            gt gtVar = this.f638a;
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
        String str = this.f639a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f643b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f644c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f637a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f645d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f646e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f641a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f647f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f642a);
        }
        sb.append(")");
        return sb.toString();
    }

    public void b(boolean z) {
        this.f640a.set(1, z);
    }

    public void a(boolean z) {
        this.f640a.set(0, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gz)) {
            return false;
        }
        return m530a((gz) obj);
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m528a();
        hzVar.a(f636a);
        if (this.f638a != null && m529a()) {
            hzVar.a(a);
            this.f638a.b(hzVar);
            hzVar.b();
        }
        if (this.f639a != null) {
            hzVar.a(b);
            hzVar.a(this.f639a);
            hzVar.b();
        }
        if (this.f643b != null) {
            hzVar.a(c);
            hzVar.a(this.f643b);
            hzVar.b();
        }
        if (this.f644c != null) {
            hzVar.a(d);
            hzVar.a(this.f644c);
            hzVar.b();
        }
        hzVar.a(e);
        hzVar.a(this.f637a);
        hzVar.b();
        if (this.f645d != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f645d);
            hzVar.b();
        }
        if (this.f646e != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f646e);
            hzVar.b();
        }
        if (this.f641a != null && h()) {
            hzVar.a(h);
            hzVar.a(new hx((byte) 11, this.f641a.size()));
            Iterator<String> it2 = this.f641a.iterator();
            while (it2.hasNext()) {
                hzVar.a(it2.next());
            }
            hzVar.e();
            hzVar.b();
        }
        if (this.f647f != null && i()) {
            hzVar.a(i);
            hzVar.a(this.f647f);
            hzVar.b();
        }
        if (j()) {
            hzVar.a(j);
            hzVar.a(this.f642a);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gz gzVar) {
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
        if (!getClass().equals(gzVar.getClass())) {
            return getClass().getName().compareTo(gzVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m529a()).compareTo(Boolean.valueOf(gzVar.m529a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m529a() && (a11 = hq.a(this.f638a, gzVar.f638a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(m531b()).compareTo(Boolean.valueOf(gzVar.m531b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m531b() && (a10 = hq.a(this.f639a, gzVar.f639a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(m532c()).compareTo(Boolean.valueOf(gzVar.m532c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m532c() && (a9 = hq.a(this.f643b, gzVar.f643b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gzVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = hq.a(this.f644c, gzVar.f644c)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gzVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = hq.a(this.f637a, gzVar.f637a)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gzVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = hq.a(this.f645d, gzVar.f645d)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gzVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = hq.a(this.f646e, gzVar.f646e)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gzVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = hq.a(this.f641a, gzVar.f641a)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gzVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = hq.a(this.f647f, gzVar.f647f)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gzVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a2 = hq.a(this.f642a, gzVar.f642a)) != 0) {
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
                if (e()) {
                    m528a();
                    return;
                }
                throw new ia("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo607a.f830a) {
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f638a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f639a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f643b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f644c = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                case 11:
                default:
                    ic.a(hzVar, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f637a = hzVar.mo606a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 11) {
                        this.f645d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f646e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 15) {
                        hx mo608a = hzVar.mo608a();
                        this.f641a = new ArrayList(mo608a.f831a);
                        for (int i2 = 0; i2 < mo608a.f831a; i2++) {
                            this.f641a.add(hzVar.mo612a());
                        }
                        hzVar.i();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    if (b2 == 11) {
                        this.f647f = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                    if (b2 == 2) {
                        this.f642a = hzVar.mo617a();
                        b(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
            }
            hzVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m530a(gz gzVar) {
        if (gzVar == null) {
            return false;
        }
        boolean m529a = m529a();
        boolean m529a2 = gzVar.m529a();
        if ((m529a || m529a2) && (!m529a || !m529a2 || !this.f638a.m511a(gzVar.f638a))) {
            return false;
        }
        boolean m531b = m531b();
        boolean m531b2 = gzVar.m531b();
        if ((m531b || m531b2) && (!m531b || !m531b2 || !this.f639a.equals(gzVar.f639a))) {
            return false;
        }
        boolean m532c = m532c();
        boolean m532c2 = gzVar.m532c();
        if ((m532c || m532c2) && (!m532c || !m532c2 || !this.f643b.equals(gzVar.f643b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gzVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f644c.equals(gzVar.f644c))) || this.f637a != gzVar.f637a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gzVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f645d.equals(gzVar.f645d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = gzVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f646e.equals(gzVar.f646e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = gzVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f641a.equals(gzVar.f641a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gzVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f647f.equals(gzVar.f647f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = gzVar.j();
        if (j2 || j3) {
            if (!j2 || !j3 || this.f642a != gzVar.f642a) {
                return false;
            }
            return true;
        }
        return true;
    }
}
