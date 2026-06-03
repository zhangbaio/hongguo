package com.tencent.open.log;

import com.bytedance.covode.number.Covode;
import com.tencent.open.log.d;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class Tracer {
    private volatile int a;
    private volatile boolean b;
    private g c;

    static {
        Covode.recordClassIndex(653535);
    }

    protected abstract void doTrace(int i, Thread thread, long j, String str, String str2, Throwable th);

    public boolean d() {
        return this.b;
    }

    public g e() {
        return this.c;
    }

    public Tracer() {
        this(c.a, true, g.a);
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(g gVar) {
        this.c = gVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public Tracer(int i, boolean z, g gVar) {
        this.a = c.a;
        this.b = true;
        this.c = g.a;
        a(i);
        a(z);
        a(gVar);
    }

    public void a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.a, i)) {
            doTrace(i, thread, j, str, str2, th);
        }
    }
}
