package com.dragon.read.kmp.widget.slidetab;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import x0.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public final float a;
    public final float b;

    static {
        Covode.recordClassIndex(609692);
    }

    public /* synthetic */ f(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    public final float a() {
        return i.g(this.a + this.b);
    }

    public int hashCode() {
        return (i.k(this.a) * 31) + i.k(this.b);
    }

    public String toString() {
        return "TabPosition(left=" + ((Object) i.l(this.a)) + ", right=" + ((Object) i.l(a())) + ", width=" + ((Object) i.l(this.b)) + ')';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (i.i(this.a, fVar.a) && i.i(this.b, fVar.b)) {
            return true;
        }
        return false;
    }

    private f(float f, float f2) {
        this.a = f;
        this.b = f2;
    }
}
