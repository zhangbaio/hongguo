package lm4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class g implements com.dragon.read.kmp.b {
    public static final int f;
    public final com.dragon.read.kmp.i a = new com.dragon.read.kmp.i(com.dragon.read.kmp.reader.utils.p.o("PageTurnMode"));
    private int b = 2;
    private int c = 2;
    private int d = 3;
    private int e = 3;

    static {
        Covode.recordClassIndex(608482);
        f = 8;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.e;
    }

    public void e(int i) {
        this.c = i;
    }

    public void f(int i) {
        this.d = i;
    }

    public void g(int i) {
        this.b = i;
    }

    public void h(int i) {
        this.e = i;
    }
}
