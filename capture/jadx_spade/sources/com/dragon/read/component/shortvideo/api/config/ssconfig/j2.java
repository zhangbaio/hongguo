package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j2 {
    public final boolean a;
    public final boolean b;

    static {
        Covode.recordClassIndex(598538);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public j2() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.j2.<init>():void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j2)) {
            return false;
        }
        j2 j2Var = (j2) obj;
        return this.a == j2Var.a && this.b == j2Var.b;
    }

    public int hashCode() {
        return (androidx.compose.animation.m.a(this.a) * 31) + androidx.compose.animation.m.a(this.b);
    }

    public String toString() {
        return "SingleSeriesPageSlideOptConfig(advancePlay=" + this.a + ", otherOpt=" + this.b + ')';
    }

    public j2(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public /* synthetic */ j2(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}
