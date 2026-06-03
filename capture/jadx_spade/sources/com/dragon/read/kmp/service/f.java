package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public final boolean a;
    public final String b;

    static {
        Covode.recordClassIndex(608825);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a == fVar.a && Intrinsics.areEqual(this.b, fVar.b);
    }

    public int hashCode() {
        return (androidx.compose.animation.m.a(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "DeleteHistoryResult(isSuccess=" + this.a + ", errorMsg=" + this.b + ')';
    }

    public f(boolean z, String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.a = z;
        this.b = errorMsg;
    }
}
