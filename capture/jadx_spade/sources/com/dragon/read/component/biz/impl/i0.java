package com.dragon.read.component.biz.impl;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i0 {
    public final boolean a;
    public final int b;
    public final int c;

    static {
        Covode.recordClassIndex(588069);
    }

    public i0() {
        this(false, 0, 0, 7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.a == i0Var.a && this.b == i0Var.b && this.c == i0Var.c;
    }

    public int hashCode() {
        return (((m.a(this.a) * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        return "HistoryFeedConfig(enable=" + this.a + ", boxFoldSize=" + this.b + ", listFoldSize=" + this.c + ')';
    }

    public i0(boolean z, int i, int i2) {
        this.a = z;
        this.b = i;
        this.c = i2;
    }

    public /* synthetic */ i0(boolean z, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 3 : i, (i3 & 4) != 0 ? 3 : i2);
    }
}
