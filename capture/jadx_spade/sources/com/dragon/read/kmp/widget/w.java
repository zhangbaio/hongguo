package com.dragon.read.kmp.widget;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w {
    public final int a;
    public final String b;

    static {
        Covode.recordClassIndex(609639);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.a == wVar.a && Intrinsics.areEqual(this.b, wVar.b);
    }

    public int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public String toString() {
        return "CommonLayoutFailResult(code=" + this.a + ", message=" + this.b + ')';
    }

    public w(int i, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.a = i;
        this.b = message;
    }
}
