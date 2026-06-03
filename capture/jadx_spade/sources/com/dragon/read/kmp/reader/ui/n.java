package com.dragon.read.kmp.reader.ui;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public final m a;
    public final boolean b;
    public final float c;
    public final Function0<Unit> d;
    public final Function0<Unit> e;
    public final Function0<Unit> f;

    static {
        Covode.recordClassIndex(608592);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.areEqual(this.a, nVar.a) && this.b == nVar.b && Float.compare(this.c, nVar.c) == 0 && Intrinsics.areEqual(this.d, nVar.d) && Intrinsics.areEqual(this.e, nVar.e) && Intrinsics.areEqual(this.f, nVar.f);
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + androidx.compose.animation.m.a(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "HotLineParam(item=" + this.a + ", isDownToUp=" + this.b + ", arrowX=" + this.c + ", onAddUnderlineClick=" + this.d + ", onCountClick=" + this.e + ", onDismiss=" + this.f + ')';
    }

    public n(m item, boolean z, float f, Function0<Unit> onAddUnderlineClick, Function0<Unit> onCountClick, Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onAddUnderlineClick, "onAddUnderlineClick");
        Intrinsics.checkNotNullParameter(onCountClick, "onCountClick");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        this.a = item;
        this.b = z;
        this.c = f;
        this.d = onAddUnderlineClick;
        this.e = onCountClick;
        this.f = onDismiss;
    }
}
