package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hl implements hp<hl, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f789a;
    private static final hw b;
    private static final hw c;
    private static final hw d;
    private static final hw e;
    private static final hw f;
    private static final hw g;
    private static final hw h;
    private static final hw i;

    /* renamed from: a, reason: collision with other field name */
    public long f790a;

    /* renamed from: a, reason: collision with other field name */
    public gt f791a;

    /* renamed from: a, reason: collision with other field name */
    public String f792a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f793a = new BitSet(3);

    /* renamed from: b, reason: collision with other field name */
    public long f794b;

    /* renamed from: b, reason: collision with other field name */
    public String f795b;

    /* renamed from: c, reason: collision with other field name */
    public long f796c;

    /* renamed from: c, reason: collision with other field name */
    public String f797c;

    /* renamed from: d, reason: collision with other field name */
    public String f798d;

    /* renamed from: e, reason: collision with other field name */
    public String f799e;

    public int hashCode() {
        return 0;
    }

    public String a() {
        return this.f799e;
    }

    public boolean d() {
        if (this.f797c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f793a.get(0);
    }

    public boolean f() {
        if (this.f798d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f799e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        return this.f793a.get(1);
    }

    public boolean i() {
        return this.f793a.get(2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m591a() {
        if (this.f792a != null) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f791a != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f795b != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m590a() {
        if (this.f795b != null) {
            if (this.f797c != null) {
                return;
            }
            throw new ia("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    static {
        Covode.recordClassIndex(655588);
        f789a = new ie("XmPushActionUnRegistrationResult");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 12, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 10, (short) 6);
        f = new hw("", (byte) 11, (short) 7);
        g = new hw("", (byte) 11, (short) 8);
        h = new hw("", (byte) 10, (short) 9);
        i = new hw("", (byte) 10, (short) 10);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (m591a()) {
            sb.append("debug:");
            String str = this.f792a;
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
            gt gtVar = this.f791a;
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
        String str2 = this.f795b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f797c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f790a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f798d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f799e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f794b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f796c);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f793a.set(0, z);
    }

    public void b(boolean z) {
        this.f793a.set(1, z);
    }

    public void c(boolean z) {
        this.f793a.set(2, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof hl)) {
            return false;
        }
        return m592a((hl) obj);
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
                    m590a();
                    return;
                }
                throw new ia("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo607a.f830a) {
                case 1:
                    if (b2 == 11) {
                        this.f792a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f791a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f795b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f797c = hzVar.mo612a();
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
                        this.f790a = hzVar.mo606a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f798d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    if (b2 == 11) {
                        this.f799e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 10) {
                        this.f794b = hzVar.mo606a();
                        b(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 10) {
                        this.f796c = hzVar.mo606a();
                        c(true);
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
        m590a();
        hzVar.a(f789a);
        if (this.f792a != null && m591a()) {
            hzVar.a(a);
            hzVar.a(this.f792a);
            hzVar.b();
        }
        if (this.f791a != null && b()) {
            hzVar.a(b);
            this.f791a.b(hzVar);
            hzVar.b();
        }
        if (this.f795b != null) {
            hzVar.a(c);
            hzVar.a(this.f795b);
            hzVar.b();
        }
        if (this.f797c != null) {
            hzVar.a(d);
            hzVar.a(this.f797c);
            hzVar.b();
        }
        hzVar.a(e);
        hzVar.a(this.f790a);
        hzVar.b();
        if (this.f798d != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f798d);
            hzVar.b();
        }
        if (this.f799e != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f799e);
            hzVar.b();
        }
        if (h()) {
            hzVar.a(h);
            hzVar.a(this.f794b);
            hzVar.b();
        }
        if (i()) {
            hzVar.a(i);
            hzVar.a(this.f796c);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hl hlVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!getClass().equals(hlVar.getClass())) {
            return getClass().getName().compareTo(hlVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m591a()).compareTo(Boolean.valueOf(hlVar.m591a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m591a() && (a10 = hq.a(this.f792a, hlVar.f792a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hlVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a9 = hq.a(this.f791a, hlVar.f791a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hlVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a8 = hq.a(this.f795b, hlVar.f795b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hlVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = hq.a(this.f797c, hlVar.f797c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hlVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = hq.a(this.f790a, hlVar.f790a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hlVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = hq.a(this.f798d, hlVar.f798d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hlVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = hq.a(this.f799e, hlVar.f799e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hlVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = hq.a(this.f794b, hlVar.f794b)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hlVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a2 = hq.a(this.f796c, hlVar.f796c)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m592a(hl hlVar) {
        if (hlVar == null) {
            return false;
        }
        boolean m591a = m591a();
        boolean m591a2 = hlVar.m591a();
        if ((m591a || m591a2) && (!m591a || !m591a2 || !this.f792a.equals(hlVar.f792a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hlVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f791a.m511a(hlVar.f791a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hlVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f795b.equals(hlVar.f795b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hlVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f797c.equals(hlVar.f797c))) || this.f790a != hlVar.f790a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hlVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f798d.equals(hlVar.f798d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hlVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f799e.equals(hlVar.f799e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hlVar.h();
        if ((h2 || h3) && (!h2 || !h3 || this.f794b != hlVar.f794b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hlVar.i();
        if (i2 || i3) {
            if (!i2 || !i3 || this.f796c != hlVar.f796c) {
                return false;
            }
            return true;
        }
        return true;
    }
}
