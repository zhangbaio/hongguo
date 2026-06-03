package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gm implements hp<gm, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f518a;
    private static final hw b;
    private static final hw c;

    /* renamed from: a, reason: collision with other field name */
    public long f519a;

    /* renamed from: a, reason: collision with other field name */
    public gg f520a;

    /* renamed from: a, reason: collision with other field name */
    public String f521a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f522a = new BitSet(1);

    public int hashCode() {
        return 0;
    }

    public boolean b() {
        if (this.f520a != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f521a != null) {
            return true;
        }
        return false;
    }

    public String a() {
        return this.f521a;
    }

    static {
        Covode.recordClassIndex(655562);
        f518a = new ie("DataCollectionItem");
        a = new hw("", (byte) 10, (short) 1);
        b = new hw("", (byte) 8, (short) 2);
        c = new hw("", (byte) 11, (short) 3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m477a() {
        if (this.f520a != null) {
            if (this.f521a != null) {
                return;
            }
            throw new ia("Required field 'content' was not present! Struct: " + toString());
        }
        throw new ia("Required field 'collectionType' was not present! Struct: " + toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f519a);
        sb.append(", ");
        sb.append("collectionType:");
        gg ggVar = this.f520a;
        if (ggVar == null) {
            sb.append("null");
        } else {
            sb.append(ggVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f521a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m478a() {
        return this.f522a.get(0);
    }

    public gm a(gg ggVar) {
        this.f520a = ggVar;
        return this;
    }

    public gm a(long j) {
        this.f519a = j;
        a(true);
        return this;
    }

    public gm a(String str) {
        this.f521a = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gm)) {
            return false;
        }
        return m479a((gm) obj);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                break;
            }
            short s = mo607a.f830a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        ic.a(hzVar, b2);
                    } else if (b2 == 11) {
                        this.f521a = hzVar.mo612a();
                    } else {
                        ic.a(hzVar, b2);
                    }
                } else if (b2 == 8) {
                    this.f520a = gg.a(hzVar.mo605a());
                } else {
                    ic.a(hzVar, b2);
                }
            } else if (b2 == 10) {
                this.f519a = hzVar.mo606a();
                a(true);
            } else {
                ic.a(hzVar, b2);
            }
            hzVar.g();
        }
        hzVar.f();
        if (m478a()) {
            m477a();
            return;
        }
        throw new ia("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        m477a();
        hzVar.a(f518a);
        hzVar.a(a);
        hzVar.a(this.f519a);
        hzVar.b();
        if (this.f520a != null) {
            hzVar.a(b);
            hzVar.mo616a(this.f520a.a());
            hzVar.b();
        }
        if (this.f521a != null) {
            hzVar.a(c);
            hzVar.a(this.f521a);
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gm gmVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(gmVar.getClass())) {
            return getClass().getName().compareTo(gmVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m478a()).compareTo(Boolean.valueOf(gmVar.m478a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m478a() && (a4 = hq.a(this.f519a, gmVar.f519a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gmVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = hq.a(this.f520a, gmVar.f520a)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gmVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a2 = hq.a(this.f521a, gmVar.f521a)) != 0) {
            return a2;
        }
        return 0;
    }

    public void a(boolean z) {
        this.f522a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m479a(gm gmVar) {
        if (gmVar == null || this.f519a != gmVar.f519a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gmVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f520a.equals(gmVar.f520a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gmVar.c();
        if (c2 || c3) {
            if (!c2 || !c3 || !this.f521a.equals(gmVar.f521a)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
