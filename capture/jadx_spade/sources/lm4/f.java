package lm4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class f implements com.dragon.read.kmp.b {
    public static final int j;
    private float b;
    private float c;
    private float d;
    private float e;
    private int f;
    private boolean g;
    private int a = 1;
    private int h = -2;
    private int i = -2;

    static {
        Covode.recordClassIndex(608481);
        j = 8;
    }

    public float a() {
        return this.b;
    }

    public float b() {
        return this.d;
    }

    public boolean c() {
        return this.g;
    }

    public int d() {
        return this.a;
    }

    public float e() {
        return this.c;
    }

    public float f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.h;
    }

    public final boolean i() {
        boolean z;
        boolean z2;
        if (a() == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return true;
        }
        if (b() == 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return true;
        }
        return false;
    }

    public void j(float f) {
        this.b = f;
    }

    public void k(float f) {
        this.d = f;
    }

    public void l(boolean z) {
        this.g = z;
    }

    public void m(int i) {
        this.a = i;
    }

    public void n(float f) {
        this.c = f;
    }

    public void o(float f) {
        this.e = f;
    }

    public void p(int i) {
        this.f = i;
    }

    public void q(int i) {
        this.i = i;
    }

    public void r(int i) {
        this.h = i;
    }
}
