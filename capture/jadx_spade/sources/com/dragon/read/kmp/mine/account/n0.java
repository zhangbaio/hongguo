package com.dragon.read.kmp.mine.account;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class n0 {
    public final String a;
    public final int b;

    static {
        Covode.recordClassIndex(607676);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return Intrinsics.areEqual(this.a, n0Var.a) && this.b == n0Var.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public String toString() {
        return "SpecialDel(newDigits=" + this.a + ", cursorDigitsDelta=" + this.b + ')';
    }

    public n0(String newDigits, int i) {
        Intrinsics.checkNotNullParameter(newDigits, "newDigits");
        this.a = newDigits;
        this.b = i;
    }
}
