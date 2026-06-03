package com.dragon.read.kmp.reader.detail;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class u2 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;

    static {
        Covode.recordClassIndex(608375);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u2)) {
            return false;
        }
        u2 u2Var = (u2) obj;
        return Intrinsics.areEqual(this.a, u2Var.a) && Intrinsics.areEqual(this.b, u2Var.b) && Intrinsics.areEqual(this.c, u2Var.c) && this.d == u2Var.d;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31) + androidx.compose.animation.m.a(this.d);
    }

    public String toString() {
        return "MetaRowStat(value=" + this.a + ", unit=" + this.b + ", desc=" + this.c + ", isNewBook=" + this.d + ')';
    }

    public u2(String value, String str, String desc, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.a = value;
        this.b = str;
        this.c = desc;
        this.d = z;
    }
}
