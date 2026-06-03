package com.dragon.read.openanim;

import android.animation.TimeInterpolator;
import android.view.Choreographer;
import android.view.animation.LinearInterpolator;
import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class v implements Choreographer.FrameCallback {
    public float a = 1.0f;
    private long b = 0;
    public float c = -1.0f;
    public float d = 0.0f;
    public float e = 59.0f;
    private float f = 59.0f - 0.0f;
    private int g = -1;
    private float h = 0.0f;
    public TimeInterpolator i = new LinearInterpolator();
    private final Set<b> j = new CopyOnWriteArraySet();
    private final Set<a> k = new CopyOnWriteArraySet();
    public boolean l = false;

    public interface a {
        void a(v vVar);

        void b(v vVar);
    }

    public interface b {
        void a(v vVar);
    }

    static {
        Covode.recordClassIndex(612640);
    }

    private void j() {
        k(true);
    }

    private void l() {
        this.a = -this.a;
    }

    private float d() {
        return (1.0E9f / this.f) / Math.abs(this.a);
    }

    private boolean e() {
        if (this.a < 0.0f) {
            return true;
        }
        return false;
    }

    private void i() {
        if (this.l) {
            k(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public float c() {
        float f = this.c;
        float f2 = this.d;
        return this.i.getInterpolation((f - f2) / (this.e - f2));
    }

    private void h() {
        Iterator<b> it2 = this.j.iterator();
        while (it2.hasNext()) {
            it2.next().a(this);
        }
    }

    private void q() {
        float f = this.c;
        if (f >= this.d && f <= this.e) {
        } else {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.d), Float.valueOf(this.e), Float.valueOf(this.c)));
        }
    }

    public void a(a aVar) {
        this.k.add(aVar);
    }

    public void b(b bVar) {
        this.j.add(bVar);
    }

    public void m(long j) {
        o(0, (int) j, 1000);
    }

    private void k(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.l = false;
        }
    }

    private void f(boolean z) {
        Iterator<a> it2 = this.k.iterator();
        while (it2.hasNext()) {
            it2.next().a(this);
        }
    }

    private void g(boolean z) {
        Iterator<a> it2 = this.k.iterator();
        while (it2.hasNext()) {
            it2.next().b(this);
        }
    }

    private void n(int i) {
        float f = i;
        if (this.c == f) {
            return;
        }
        this.c = m4.f.b(f, this.d, this.e);
        this.b = System.nanoTime();
        h();
    }

    public void p(boolean z) {
        float f;
        if (z) {
            l();
        }
        this.l = true;
        g(e());
        if (e()) {
            f = this.e;
        } else {
            f = this.d;
        }
        n((int) f);
        this.b = System.nanoTime();
        i();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (!this.l) {
            return;
        }
        i();
        long nanoTime = System.nanoTime();
        float d = (nanoTime - this.b) / d();
        float f = this.c;
        if (e()) {
            d = -d;
        }
        float f2 = f + d;
        boolean z = !m4.f.d(f2, this.d, this.e);
        float b2 = m4.f.b(f2, this.d, this.e);
        if (this.g <= 0 || Math.abs(nanoTime - this.b) > this.h) {
            this.c = b2;
            this.b = nanoTime;
            h();
        }
        if (z) {
            this.c = this.e;
            j();
            f(e());
        }
        q();
    }

    private void o(int i, int i2, int i3) {
        if (i2 <= i) {
            return;
        }
        this.d = m4.f.c(i, 0, i);
        this.e = m4.f.c(i2, 1, i2);
        this.f = i3;
    }
}
