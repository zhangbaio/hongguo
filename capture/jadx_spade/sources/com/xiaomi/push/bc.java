package com.xiaomi.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bc {
    private long a;
    private long b;
    private long c;
    private long d;
    private final long e = System.currentTimeMillis();

    static {
        Covode.recordClassIndex(655371);
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m183a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public int a() {
        return com.xiaomi.push.service.ag.a() ? 1 : 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m184a() {
        this.c++;
    }

    public void b(long j) {
        this.b += j;
    }

    public void c(long j) {
        this.d += j;
    }

    public void a(long j) {
        this.a = j;
    }
}
