package com.dragon.read.kmp.widget;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class y1 {
    public static final int c = 0;
    public final org.jetbrains.compose.resources.b a;
    public final androidx.compose.ui.graphics.m0 b;

    static {
        Covode.recordClassIndex(609665);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y1)) {
            return false;
        }
        y1 y1Var = (y1) obj;
        return Intrinsics.areEqual(this.a, y1Var.a) && Intrinsics.areEqual(this.b, y1Var.b);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        androidx.compose.ui.graphics.m0 m0Var = this.b;
        return hashCode + (m0Var == null ? 0 : m0Var.hashCode());
    }

    public String toString() {
        return "StarDrawable(res=" + this.a + ", colorFilter=" + this.b + ')';
    }

    public y1(org.jetbrains.compose.resources.b res, androidx.compose.ui.graphics.m0 m0Var) {
        Intrinsics.checkNotNullParameter(res, "res");
        this.a = res;
        this.b = m0Var;
    }

    public /* synthetic */ y1(org.jetbrains.compose.resources.b bVar, androidx.compose.ui.graphics.m0 m0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i & 2) != 0 ? null : m0Var);
    }
}
