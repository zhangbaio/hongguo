package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public final boolean a;
    public final String b;

    static {
        Covode.recordClassIndex(608820);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && Intrinsics.areEqual(this.b, bVar.b);
    }

    public int hashCode() {
        return (androidx.compose.animation.m.a(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "AddBookshelfResult(isSuccess=" + this.a + ", msg=" + this.b + ')';
    }

    public b(boolean z, String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.a = z;
        this.b = msg;
    }
}
