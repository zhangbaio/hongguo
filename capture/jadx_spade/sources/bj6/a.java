package bj6;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a<T> {
    private T a;
    private int b = 0;

    static {
        Covode.recordClassIndex(653020);
    }

    public synchronized T b() {
        return this.a;
    }

    public a(T t) {
        this.a = t;
    }

    public synchronized void a(T t, int i) {
        if (i < this.b) {
            return;
        }
        this.a = t;
        this.b = i;
    }
}
