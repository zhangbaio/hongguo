package com.dragon.read.openanim;

import android.animation.TimeInterpolator;
import android.graphics.drawable.Drawable;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ui.util.CubicBezierInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class b {
    public static final int h;
    public boolean a;
    public long b = b();
    public long c = b();
    public TimeInterpolator d = d();
    public TimeInterpolator e = c();
    public o f;
    public o g;

    static {
        Covode.recordClassIndex(612623);
        h = 8;
    }

    private final long b() {
        return 450L;
    }

    protected abstract o g();

    protected abstract o h();

    public void a() {
        o oVar = this.f;
        if (oVar != null) {
            oVar.a();
        }
        o oVar2 = this.g;
        if (oVar2 != null) {
            oVar2.a();
        }
    }

    private final TimeInterpolator c() {
        return new CubicBezierInterpolator(0.42d, 0.0d, 1.0d, 1.0d);
    }

    private final TimeInterpolator d() {
        return new CubicBezierInterpolator(0.0d, 0.0d, 0.58d, 1.0d);
    }

    public final Drawable e() {
        Drawable drawable;
        o oVar = this.f;
        if (oVar == null || (drawable = oVar.a) == null) {
            o g = g();
            this.f = g;
            if (g != null) {
                return g.a;
            }
            return null;
        }
        return drawable;
    }

    public final Drawable f() {
        Drawable drawable;
        if (this.a) {
            return e();
        }
        o oVar = this.g;
        if (oVar == null || (drawable = oVar.a) == null) {
            o h2 = h();
            this.g = h2;
            if (h2 != null) {
                return h2.a;
            }
            return null;
        }
        return drawable;
    }

    public final void i(long j) {
        this.b = j;
        this.c = j;
    }

    public final void j(TimeInterpolator timeInterpolator) {
        Intrinsics.checkNotNullParameter(timeInterpolator, "<set-?>");
        this.d = timeInterpolator;
    }
}
