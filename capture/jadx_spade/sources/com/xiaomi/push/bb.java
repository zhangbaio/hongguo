package com.xiaomi.push;

import com.bytedance.apm.agent.instrumentation.ThreadMonitor;
import com.bytedance.covode.number.Covode;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bb<T> {
    private final long a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private final long i;

    static {
        Covode.recordClassIndex(655370);
    }

    public long a() {
        return this.c;
    }

    public long b() {
        return this.d;
    }

    public long d() {
        long j = this.h;
        long j2 = this.g;
        if (j > j2) {
            return j - j2;
        }
        return 0L;
    }

    public long c() {
        long j = this.f;
        if (j > 0) {
            long j2 = this.e;
            if (j2 > 0) {
                return j / j2;
            }
        }
        return 0L;
    }

    public T a(Callable<T> callable) {
        T t;
        long j = this.b;
        long j2 = this.i;
        if (j > j2) {
            long j3 = (j / j2) * this.a;
            this.b = 0L;
            if (j3 > 0) {
                try {
                    ThreadMonitor.sleepMonitor(j3);
                } catch (Exception unused) {
                }
            }
        }
        long nanoTime = System.nanoTime();
        if (this.g <= 0) {
            this.g = nanoTime;
        }
        try {
            t = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
            t = null;
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        this.h = System.nanoTime();
        this.e++;
        if (this.c < nanoTime2) {
            this.c = nanoTime2;
        }
        if (nanoTime2 > 0) {
            this.f += nanoTime2;
            long j4 = this.d;
            if (j4 == 0 || j4 > nanoTime2) {
                this.d = nanoTime2;
            }
        }
        this.b += Math.max(nanoTime2, 0L);
        return t;
    }

    public bb(long j, long j2) {
        this.i = j * 1000000;
        this.a = j2;
    }
}
