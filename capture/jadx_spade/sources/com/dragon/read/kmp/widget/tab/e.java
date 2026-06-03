package com.dragon.read.kmp.widget.tab;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import x0.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class e {
    public final float a;
    public final float b;

    static {
        Covode.recordClassIndex(609696);
    }

    public /* synthetic */ e(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return i.i(this.a, eVar.a) && i.i(this.b, eVar.b);
    }

    public int hashCode() {
        return (i.k(this.a) * 31) + i.k(this.b);
    }

    public String toString() {
        return "TabPositionInfo(left=" + ((Object) i.l(this.a)) + ", width=" + ((Object) i.l(this.b)) + ')';
    }

    private e(float f, float f2) {
        this.a = f;
        this.b = f2;
    }
}
