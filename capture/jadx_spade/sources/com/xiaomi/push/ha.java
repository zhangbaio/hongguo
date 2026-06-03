package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ha implements hp<ha, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f648a;
    private static final hw b;
    private static final hw c;
    private static final hw d;
    private static final hw e;
    private static final hw f;
    private static final hw g;
    private static final hw h;

    /* renamed from: a, reason: collision with other field name */
    public ge f649a;

    /* renamed from: a, reason: collision with other field name */
    public gr f650a;

    /* renamed from: a, reason: collision with other field name */
    public gt f651a;

    /* renamed from: a, reason: collision with other field name */
    public String f652a;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f653a;

    /* renamed from: b, reason: collision with other field name */
    public String f656b;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f654a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f655a = true;

    /* renamed from: b, reason: collision with other field name */
    public boolean f657b = true;

    public int hashCode() {
        return 0;
    }

    public ge a() {
        return this.f649a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m537a() {
        return this.f649a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m536a(boolean z) {
        this.f654a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m539a() {
        a(hq.a(this.f653a));
        return this.f653a.array();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m538a(ha haVar) {
        if (haVar == null) {
            return false;
        }
        boolean m537a = m537a();
        boolean m537a2 = haVar.m537a();
        if (((m537a || m537a2) && (!m537a || !m537a2 || !this.f649a.equals(haVar.f649a))) || this.f655a != haVar.f655a || this.f657b != haVar.f657b) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = haVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f653a.equals(haVar.f653a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = haVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f652a.equals(haVar.f652a))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = haVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f656b.equals(haVar.f656b))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = haVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f651a.m511a(haVar.f651a))) {
            return false;
        }
        boolean i = i();
        boolean i2 = haVar.i();
        if (i || i2) {
            return i && i2 && this.f650a.m503a(haVar.f650a);
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
                        if (b2 == 8) {
                            this.f649a = ge.a(hzVar.mo605a());
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 2:
                        if (b2 == 2) {
                            this.f655a = hzVar.mo617a();
                            m536a(true);
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 3:
                        if (b2 == 2) {
                            this.f657b = hzVar.mo617a();
                            m540b(true);
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 4:
                        if (b2 == 11) {
                            this.f653a = hzVar.mo613a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 5:
                        if (b2 == 11) {
                            this.f652a = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        if (b2 == 11) {
                            this.f656b = hzVar.mo612a();
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case 7:
                        if (b2 == 12) {
                            gt gtVar = new gt();
                            this.f651a = gtVar;
                            gtVar.a(hzVar);
                            break;
                        } else {
                            ic.a(hzVar, b2);
                            break;
                        }
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        if (b2 == 12) {
                            gr grVar = new gr();
                            this.f650a = grVar;
                            grVar.a(hzVar);
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
                if (!c()) {
                    throw new ia("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new ia("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m535a();
                return;
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m535a() {
        if (this.f649a == null) {
            throw new ia("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f653a == null) {
            throw new ia("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f651a != null) {
            return;
        }
        throw new ia("Required field 'target' was not present! Struct: " + toString());
    }

    /* renamed from: a, reason: collision with other method in class */
    public gr m533a() {
        return this.f650a;
    }

    public boolean c() {
        return this.f654a.get(0);
    }

    public boolean d() {
        return this.f654a.get(1);
    }

    public boolean e() {
        if (this.f653a != null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.f652a != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f656b != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f651a != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f650a != null) {
            return true;
        }
        return false;
    }

    public String b() {
        return this.f656b;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m541b() {
        return this.f655a;
    }

    static {
        Covode.recordClassIndex(655577);
        f648a = new ie("XmPushActionContainer");
        a = new hw("", (byte) 8, (short) 1);
        b = new hw("", (byte) 2, (short) 2);
        c = new hw("", (byte) 2, (short) 3);
        d = new hw("", (byte) 11, (short) 4);
        e = new hw("", (byte) 11, (short) 5);
        f = new hw("", (byte) 11, (short) 6);
        g = new hw("", (byte) 12, (short) 7);
        h = new hw("", (byte) 12, (short) 8);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        ge geVar = this.f649a;
        if (geVar == null) {
            sb.append("null");
        } else {
            sb.append(geVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f655a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f657b);
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f652a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f656b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        gt gtVar = this.f651a;
        if (gtVar == null) {
            sb.append("null");
        } else {
            sb.append(gtVar);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            gr grVar = this.f650a;
            if (grVar == null) {
                sb.append("null");
            } else {
                sb.append(grVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m534a() {
        return this.f652a;
    }

    public ha b(String str) {
        this.f656b = str;
        return this;
    }

    public ha b(boolean z) {
        this.f657b = z;
        m540b(true);
        return this;
    }

    public ha a(ge geVar) {
        this.f649a = geVar;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ha)) {
            return false;
        }
        return m538a((ha) obj);
    }

    public ha a(gr grVar) {
        this.f650a = grVar;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m540b(boolean z) {
        this.f654a.set(1, z);
    }

    public ha a(gt gtVar) {
        this.f651a = gtVar;
        return this;
    }

    public ha a(String str) {
        this.f652a = str;
        return this;
    }

    public ha a(ByteBuffer byteBuffer) {
        this.f653a = byteBuffer;
        return this;
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m535a();
        hzVar.a(f648a);
        if (this.f649a != null) {
            hzVar.a(a);
            hzVar.mo616a(this.f649a.a());
            hzVar.b();
        }
        hzVar.a(b);
        hzVar.a(this.f655a);
        hzVar.b();
        hzVar.a(c);
        hzVar.a(this.f657b);
        hzVar.b();
        if (this.f653a != null) {
            hzVar.a(d);
            hzVar.a(this.f653a);
            hzVar.b();
        }
        if (this.f652a != null && f()) {
            hzVar.a(e);
            hzVar.a(this.f652a);
            hzVar.b();
        }
        if (this.f656b != null && g()) {
            hzVar.a(f);
            hzVar.a(this.f656b);
            hzVar.b();
        }
        if (this.f651a != null) {
            hzVar.a(g);
            this.f651a.b(hzVar);
            hzVar.b();
        }
        if (this.f650a != null && i()) {
            hzVar.a(h);
            this.f650a.b(hzVar);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ha haVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(haVar.getClass())) {
            return getClass().getName().compareTo(haVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m537a()).compareTo(Boolean.valueOf(haVar.m537a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m537a() && (a9 = hq.a(this.f649a, haVar.f649a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(haVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a8 = hq.a(this.f655a, haVar.f655a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(haVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a7 = hq.a(this.f657b, haVar.f657b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(haVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (a6 = hq.a(this.f653a, haVar.f653a)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(haVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a5 = hq.a(this.f652a, haVar.f652a)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(haVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (a4 = hq.a(this.f656b, haVar.f656b)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(haVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a3 = hq.a(this.f651a, haVar.f651a)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(haVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (i() && (a2 = hq.a(this.f650a, haVar.f650a)) != 0) {
            return a2;
        }
        return 0;
    }

    public ha a(boolean z) {
        this.f655a = z;
        m536a(true);
        return this;
    }
}
