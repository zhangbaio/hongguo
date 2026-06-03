package com.dragon.read.kmp.profile.guestprofile.view;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public final String a;
    public final String b;

    static {
        Covode.recordClassIndex(608166);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual(this.a, dVar.a) && Intrinsics.areEqual(this.b, dVar.b);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "NumberDisplay(number=" + this.a + ", unit=" + this.b + ')';
    }

    public d(String number, String str) {
        Intrinsics.checkNotNullParameter(number, "number");
        this.a = number;
        this.b = str;
    }
}
