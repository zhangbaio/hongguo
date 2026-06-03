package wk6;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    public volatile long a;
    private volatile long b;
    private volatile boolean c;

    static {
        Covode.recordClassIndex(655857);
    }

    public void e() {
        this.c = true;
    }

    public long b() {
        if (this.c) {
            return this.a;
        }
        return Math.max(this.a, this.b);
    }

    public void d() {
        this.a = 0L;
        this.b = 0L;
        this.c = false;
    }

    public boolean a(long j) {
        if (j < this.a) {
            return true;
        }
        return false;
    }

    public void f(long j) {
        this.a += j;
        this.b += j;
    }

    public void c(long j, long j2) {
        this.a = j;
        this.b = j2;
    }
}
