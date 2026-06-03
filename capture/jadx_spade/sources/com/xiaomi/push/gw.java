package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gw implements hp<gw, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f618a;
    private static final hw b;

    /* renamed from: a, reason: collision with other field name */
    public int f619a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f620a = new BitSet(2);

    /* renamed from: b, reason: collision with other field name */
    public int f621b;

    public void a() {
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m519a() {
        return this.f620a.get(0);
    }

    public boolean b() {
        return this.f620a.get(1);
    }

    static {
        Covode.recordClassIndex(655572);
        f618a = new ie("XmPushActionCheckClientInfo");
        a = new hw("", (byte) 8, (short) 1);
        b = new hw("", (byte) 8, (short) 2);
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f619a + ", pluginConfigVersion:" + this.f621b + ")";
    }

    public gw a(int i) {
        this.f619a = i;
        a(true);
        return this;
    }

    public gw b(int i) {
        this.f621b = i;
        b(true);
        return this;
    }

    public void a(boolean z) {
        this.f620a.set(0, z);
    }

    public void b(boolean z) {
        this.f620a.set(1, z);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof gw)) {
            return false;
        }
        return m520a((gw) obj);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m520a(gw gwVar) {
        if (gwVar == null || this.f619a != gwVar.f619a || this.f621b != gwVar.f621b) {
            return false;
        }
        return true;
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        a();
        hzVar.a(f618a);
        hzVar.a(a);
        hzVar.mo616a(this.f619a);
        hzVar.b();
        hzVar.a(b);
        hzVar.mo616a(this.f621b);
        hzVar.b();
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gw gwVar) {
        int a2;
        int a3;
        if (!getClass().equals(gwVar.getClass())) {
            return getClass().getName().compareTo(gwVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m519a()).compareTo(Boolean.valueOf(gwVar.m519a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m519a() && (a3 = hq.a(this.f619a, gwVar.f619a)) != 0) {
            return a3;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gwVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a2 = hq.a(this.f621b, gwVar.f621b)) != 0) {
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
                break;
            }
            short s = mo607a.f830a;
            if (s != 1) {
                if (s != 2) {
                    ic.a(hzVar, b2);
                } else if (b2 == 8) {
                    this.f621b = hzVar.mo605a();
                    b(true);
                } else {
                    ic.a(hzVar, b2);
                }
            } else if (b2 == 8) {
                this.f619a = hzVar.mo605a();
                a(true);
            } else {
                ic.a(hzVar, b2);
            }
            hzVar.g();
        }
        hzVar.f();
        if (m519a()) {
            if (b()) {
                a();
                return;
            }
            throw new ia("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
        throw new ia("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
    }
}
