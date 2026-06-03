package com.ttnet.org.chromium.base.task;

import com.bytedance.covode.number.Covode;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class o {
    public static final o g;
    public static final o h;
    public static final o i;
    public static final o j;
    public static final o k;
    public static final o l;
    public static final o m;
    public static final o n;
    public static final o o;
    public static final o p;
    public static final o q;
    int a;
    boolean b;
    boolean c;
    byte d;
    byte[] e;
    boolean f;

    private o() {
        this.a = 2;
    }

    public boolean a() {
        if (this.d != 0) {
            return true;
        }
        return false;
    }

    public o b() {
        o oVar = new o(this);
        oVar.b = true;
        return oVar;
    }

    public o d() {
        o oVar = new o(this);
        oVar.c = true;
        return oVar;
    }

    public o e() {
        if (!this.c && !a()) {
            return d();
        }
        return this;
    }

    public int hashCode() {
        return ((((((((((1147 + this.a) * 37) + (!this.b ? 1 : 0)) * 37) + (!this.c ? 1 : 0)) * 37) + this.d) * 37) + Arrays.hashCode(this.e)) * 37) + (!this.f ? 1 : 0);
    }

    static {
        Covode.recordClassIndex(654418);
        o c = new o().c(0);
        g = c;
        h = c.b();
        o c2 = new o().c(1);
        i = c2;
        j = c2.b();
        o c3 = new o().c(2);
        k = c3;
        l = c3.b();
        o oVar = new o();
        m = oVar;
        oVar.f = true;
        o c4 = new o().d().c(2);
        n = c4;
        o = c4.c(2);
        p = c4.c(1);
        q = c4.c(0);
    }

    public o c(int i2) {
        o oVar = new o(this);
        oVar.a = i2;
        return oVar;
    }

    private o(o oVar) {
        this.a = oVar.a;
        this.b = oVar.b;
        this.c = oVar.c;
        this.d = oVar.d;
        this.e = oVar.e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.a == oVar.a && this.b == oVar.b && this.c == oVar.c && this.d == oVar.d && Arrays.equals(this.e, oVar.e) && this.f == oVar.f) {
            return true;
        }
        return false;
    }
}
