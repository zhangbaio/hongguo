package com.zhihu.matisse.internal.entity;

import com.bytedance.covode.number.Covode;
import com.zhihu.matisse.MimeType;
import fm6.c;
import fm6.d;
import java.util.List;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    public Set<MimeType> a;
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public List<zl6.a> j;
    public boolean k;
    public int l;
    public int m;
    public float n;
    public boolean o;
    public c p;
    public d q;
    public fm6.b r;
    public boolean s;
    public boolean t;
    public int u;

    static {
        Covode.recordClassIndex(656122);
    }

    private static final class b {
        private static final a a;

        static {
            Covode.recordClassIndex(656123);
            a = new a();
        }
    }

    private a() {
    }

    public static a a() {
        a b2 = b();
        b2.f();
        return b2;
    }

    public static a b() {
        return b.a;
    }

    public boolean c() {
        if (this.e != -1) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.c && MimeType.ofImage().containsAll(this.a)) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.c && MimeType.ofVideo().containsAll(this.a)) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (!this.f) {
            if (this.g == 1) {
                return true;
            }
            if (this.h == 1 && this.i == 1) {
                return true;
            }
        }
        return false;
    }

    private void f() {
        this.a = null;
        this.b = true;
        this.c = false;
        this.d = 2131296855;
        this.e = 0;
        this.f = false;
        this.g = 1;
        this.h = 0;
        this.i = 0;
        this.j = null;
        this.k = false;
        this.l = 3;
        this.m = 0;
        this.n = 0.5f;
        this.o = true;
        this.s = false;
        this.t = false;
        this.u = Integer.MAX_VALUE;
    }
}
