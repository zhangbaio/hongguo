package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gy implements hp<gy, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f624a;
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
    public long f625a;

    /* renamed from: a, reason: collision with other field name */
    public gt f626a;

    /* renamed from: a, reason: collision with other field name */
    public String f627a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f629a;

    /* renamed from: b, reason: collision with other field name */
    public String f631b;

    /* renamed from: c, reason: collision with other field name */
    public String f633c;

    /* renamed from: d, reason: collision with other field name */
    public String f634d;

    /* renamed from: e, reason: collision with other field name */
    public String f635e;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f628a = new BitSet(3);

    /* renamed from: a, reason: collision with other field name */
    public boolean f630a = false;

    /* renamed from: b, reason: collision with other field name */
    public boolean f632b = true;

    public int hashCode() {
        return 0;
    }

    public String a() {
        return this.f633c;
    }

    public boolean d() {
        if (this.f633c != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f629a != null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.f634d != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f635e != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        return this.f628a.get(0);
    }

    public boolean i() {
        return this.f628a.get(1);
    }

    public boolean j() {
        return this.f628a.get(2);
    }

    public boolean b() {
        if (this.f627a != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f631b != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m525a() {
        if (this.f626a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655574);
        f624a = new ie("XmPushActionCommand");
        a = new hw("", (byte) 12, (short) 2);
        b = new hw("", (byte) 11, (short) 3);
        c = new hw("", (byte) 11, (short) 4);
        d = new hw("", (byte) 11, (short) 5);
        e = new hw("", (byte) 15, (short) 6);
        f = new hw("", (byte) 11, (short) 7);
        g = new hw("", (byte) 11, (short) 9);
        h = new hw("", (byte) 2, (short) 10);
        i = new hw("", (byte) 2, (short) 11);
        j = new hw("", (byte) 10, (short) 12);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m523a() {
        if (this.f627a != null) {
            if (this.f631b != null) {
                if (this.f633c != null) {
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
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m525a()) {
            sb.append("target:");
            gt gtVar = this.f626a;
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
        String str = this.f627a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f631b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f633c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f629a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f634d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f635e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f630a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f632b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f625a);
        }
        sb.append(")");
        return sb.toString();
    }

    public gy a(String str) {
        this.f627a = str;
        return this;
    }

    public gy b(String str) {
        this.f631b = str;
        return this;
    }

    public gy c(String str) {
        this.f633c = str;
        return this;
    }

    public gy d(String str) {
        this.f634d = str;
        return this;
    }

    public gy e(String str) {
        this.f635e = str;
        return this;
    }

    public void b(boolean z) {
        this.f628a.set(1, z);
    }

    public void c(boolean z) {
        this.f628a.set(2, z);
    }

    public void a(boolean z) {
        this.f628a.set(0, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gy)) {
            return false;
        }
        return m526a((gy) obj);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m524a(String str) {
        if (this.f629a == null) {
            this.f629a = new ArrayList();
        }
        this.f629a.add(str);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                m523a();
                return;
            }
            switch (mo607a.f830a) {
                case 2:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f626a = gtVar;
                        gtVar.a(hzVar);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f627a = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f631b = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f633c = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    if (b2 == 15) {
                        hx mo608a = hzVar.mo608a();
                        this.f629a = new ArrayList(mo608a.f831a);
                        for (int i2 = 0; i2 < mo608a.f831a; i2++) {
                            this.f629a.add(hzVar.mo612a());
                        }
                        hzVar.i();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f634d = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                default:
                    ic.a(hzVar, b2);
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f635e = hzVar.mo612a();
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 2) {
                        this.f630a = hzVar.mo617a();
                        a(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f632b = hzVar.mo617a();
                        b(true);
                        break;
                    } else {
                        ic.a(hzVar, b2);
                        break;
                    }
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    if (b2 == 10) {
                        this.f625a = hzVar.mo606a();
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
        m523a();
        hzVar.a(f624a);
        if (this.f626a != null && m525a()) {
            hzVar.a(a);
            this.f626a.b(hzVar);
            hzVar.b();
        }
        if (this.f627a != null) {
            hzVar.a(b);
            hzVar.a(this.f627a);
            hzVar.b();
        }
        if (this.f631b != null) {
            hzVar.a(c);
            hzVar.a(this.f631b);
            hzVar.b();
        }
        if (this.f633c != null) {
            hzVar.a(d);
            hzVar.a(this.f633c);
            hzVar.b();
        }
        if (this.f629a != null && e()) {
            hzVar.a(e);
            hzVar.a(new hx((byte) 11, this.f629a.size()));
            Iterator<String> it2 = this.f629a.iterator();
            while (it2.hasNext()) {
                hzVar.a(it2.next());
            }
            hzVar.e();
            hzVar.b();
        }
        if (this.f634d != null && f()) {
            hzVar.a(f);
            hzVar.a(this.f634d);
            hzVar.b();
        }
        if (this.f635e != null && g()) {
            hzVar.a(g);
            hzVar.a(this.f635e);
            hzVar.b();
        }
        if (h()) {
            hzVar.a(h);
            hzVar.a(this.f630a);
            hzVar.b();
        }
        if (i()) {
            hzVar.a(i);
            hzVar.a(this.f632b);
            hzVar.b();
        }
        if (j()) {
            hzVar.a(j);
            hzVar.a(this.f625a);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gy gyVar) {
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
        if (!getClass().equals(gyVar.getClass())) {
            return getClass().getName().compareTo(gyVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m525a()).compareTo(Boolean.valueOf(gyVar.m525a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m525a() && (a11 = hq.a(this.f626a, gyVar.f626a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gyVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = hq.a(this.f627a, gyVar.f627a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gyVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = hq.a(this.f631b, gyVar.f631b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gyVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = hq.a(this.f633c, gyVar.f633c)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gyVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = hq.a(this.f629a, gyVar.f629a)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gyVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = hq.a(this.f634d, gyVar.f634d)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gyVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = hq.a(this.f635e, gyVar.f635e)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gyVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = hq.a(this.f630a, gyVar.f630a)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gyVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = hq.a(this.f632b, gyVar.f632b)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gyVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a2 = hq.a(this.f625a, gyVar.f625a)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m526a(gy gyVar) {
        if (gyVar == null) {
            return false;
        }
        boolean m525a = m525a();
        boolean m525a2 = gyVar.m525a();
        if ((m525a || m525a2) && (!m525a || !m525a2 || !this.f626a.m511a(gyVar.f626a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gyVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f627a.equals(gyVar.f627a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gyVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f631b.equals(gyVar.f631b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gyVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f633c.equals(gyVar.f633c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = gyVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f629a.equals(gyVar.f629a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gyVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f634d.equals(gyVar.f634d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = gyVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f635e.equals(gyVar.f635e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = gyVar.h();
        if ((h2 || h3) && (!h2 || !h3 || this.f630a != gyVar.f630a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gyVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f632b != gyVar.f632b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = gyVar.j();
        if (j2 || j3) {
            if (!j2 || !j3 || this.f625a != gyVar.f625a) {
                return false;
            }
            return true;
        }
        return true;
    }
}
