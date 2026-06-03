package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ej implements hp<ej, Object>, Serializable, Cloneable {
    private static final hw a;

    /* renamed from: a, reason: collision with other field name */
    private static final ie f372a;
    private static final hw b;
    private static final hw c;

    /* renamed from: a, reason: collision with other field name */
    public String f373a;

    /* renamed from: a, reason: collision with other field name */
    public List<ei> f374a;

    /* renamed from: b, reason: collision with other field name */
    public String f375b;

    public int hashCode() {
        return 0;
    }

    public ej() {
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m381a() {
        if (this.f373a != null) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f375b != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f374a != null) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655488);
        f372a = new ie("StatsEvents");
        a = new hw("", (byte) 11, (short) 1);
        b = new hw("", (byte) 11, (short) 2);
        c = new hw("", (byte) 15, (short) 3);
    }

    public void a() {
        if (this.f373a != null) {
            if (this.f374a != null) {
                return;
            }
            throw new ia("Required field 'events' was not present! Struct: " + toString());
        }
        throw new ia("Required field 'uuid' was not present! Struct: " + toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f373a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f375b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<ei> list = this.f374a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public ej a(String str) {
        this.f375b = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ej)) {
            return false;
        }
        return m382a((ej) obj);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz hzVar) {
        hzVar.mo611a();
        while (true) {
            hw mo607a = hzVar.mo607a();
            byte b2 = mo607a.a;
            if (b2 == 0) {
                hzVar.f();
                a();
                return;
            }
            short s = mo607a.f830a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        ic.a(hzVar, b2);
                    } else if (b2 == 15) {
                        hx mo608a = hzVar.mo608a();
                        this.f374a = new ArrayList(mo608a.f831a);
                        for (int i = 0; i < mo608a.f831a; i++) {
                            ei eiVar = new ei();
                            eiVar.a(hzVar);
                            this.f374a.add(eiVar);
                        }
                        hzVar.i();
                    } else {
                        ic.a(hzVar, b2);
                    }
                } else if (b2 == 11) {
                    this.f375b = hzVar.mo612a();
                } else {
                    ic.a(hzVar, b2);
                }
            } else if (b2 == 11) {
                this.f373a = hzVar.mo612a();
            } else {
                ic.a(hzVar, b2);
            }
            hzVar.g();
        }
    }

    @Override // com.xiaomi.push.hp
    public void b(hz hzVar) {
        a();
        hzVar.a(f372a);
        if (this.f373a != null) {
            hzVar.a(a);
            hzVar.a(this.f373a);
            hzVar.b();
        }
        if (this.f375b != null && b()) {
            hzVar.a(b);
            hzVar.a(this.f375b);
            hzVar.b();
        }
        if (this.f374a != null) {
            hzVar.a(c);
            hzVar.a(new hx((byte) 12, this.f374a.size()));
            Iterator<ei> it2 = this.f374a.iterator();
            while (it2.hasNext()) {
                it2.next().b(hzVar);
            }
            hzVar.e();
            hzVar.b();
        }
        hzVar.c();
        hzVar.mo615a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ej ejVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(ejVar.getClass())) {
            return getClass().getName().compareTo(ejVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m381a()).compareTo(Boolean.valueOf(ejVar.m381a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m381a() && (a4 = hq.a(this.f373a, ejVar.f373a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ejVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = hq.a(this.f375b, ejVar.f375b)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ejVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a2 = hq.a(this.f374a, ejVar.f374a)) != 0) {
            return a2;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m382a(ej ejVar) {
        if (ejVar == null) {
            return false;
        }
        boolean m381a = m381a();
        boolean m381a2 = ejVar.m381a();
        if ((m381a || m381a2) && (!m381a || !m381a2 || !this.f373a.equals(ejVar.f373a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ejVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f375b.equals(ejVar.f375b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ejVar.c();
        if (c2 || c3) {
            if (!c2 || !c3 || !this.f374a.equals(ejVar.f374a)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public ej(String str, List<ei> list) {
        this();
        this.f373a = str;
        this.f374a = list;
    }
}
