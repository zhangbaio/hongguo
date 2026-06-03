package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.t;
import java.util.Date;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f extends t.b {
    private boolean A;
    private boolean B;
    private int C;
    public String D;
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final long i;
    private final long j;
    private final long k;
    private final long l;
    private final long m;
    private final boolean n;
    private final Long o;
    private final Long p;
    private final Long q;
    private final Long r;
    private final String s;
    private final Long t;
    private final Long u;
    private final String v;
    private final String w;
    private Long x;
    private Long y;
    private Integer z;

    @Override // com.ttnet.org.chromium.net.t.b
    public Long B() {
        return this.p;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long C() {
        return this.o;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public int D() {
        return this.C;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long a() {
        return this.x;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public boolean b() {
        return this.B;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public String g() {
        return this.s;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long h() {
        return this.t;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public boolean i() {
        return this.A;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long l() {
        return this.r;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Integer m() {
        return this.z;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public String o() {
        return this.v;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public String p() {
        return this.D;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public String r() {
        return this.w;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long t() {
        return this.u;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long u() {
        return this.y;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Long x() {
        return this.q;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public boolean y() {
        return this.n;
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date A() {
        return E(this.f);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date c() {
        return E(this.e);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date d() {
        return E(this.d);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date e() {
        return E(this.c);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date f() {
        return E(this.b);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date j() {
        return E(this.k);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date k() {
        return E(this.j);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date n() {
        return E(this.m);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date q() {
        return E(this.a);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date s() {
        return E(this.l);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date v() {
        return E(this.i);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date w() {
        return E(this.h);
    }

    @Override // com.ttnet.org.chromium.net.t.b
    public Date z() {
        return E(this.g);
    }

    static {
        Covode.recordClassIndex(654605);
    }

    private static Date E(long j) {
        if (j != -1) {
            return new Date(j);
        }
        return null;
    }

    public f(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15, String str, long j16, long j17, String str2, String str3, long j18, long j19, int i, boolean z2, boolean z3, int i2) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
        this.g = j7;
        this.h = j8;
        this.i = j9;
        this.j = j10;
        this.k = j11;
        this.l = j12;
        this.m = j13;
        this.n = z;
        this.q = Long.valueOf(j14);
        this.r = Long.valueOf(j15);
        this.x = Long.valueOf(j18);
        this.y = Long.valueOf(j19);
        this.z = Integer.valueOf(i);
        this.A = z2;
        this.B = z3;
        this.C = i2;
        this.s = str;
        this.t = Long.valueOf(j16);
        this.u = Long.valueOf(j17);
        if (j12 != -1 && j9 != -1) {
            this.o = Long.valueOf(j12 - j9);
        } else {
            this.o = null;
        }
        if (j != -1 && j13 != -1) {
            this.p = Long.valueOf(j13 - j);
        } else {
            this.p = null;
        }
        this.v = str2;
        this.w = str3;
    }
}
