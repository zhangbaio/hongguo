package com.dragon.read.kmp.reader.detail;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s2 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;

    static {
        Covode.recordClassIndex(608373);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s2)) {
            return false;
        }
        s2 s2Var = (s2) obj;
        return Intrinsics.areEqual(this.a, s2Var.a) && Intrinsics.areEqual(this.b, s2Var.b) && Intrinsics.areEqual(this.c, s2Var.c) && this.d == s2Var.d && Intrinsics.areEqual(this.e, s2Var.e) && Intrinsics.areEqual(this.f, s2Var.f);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + androidx.compose.animation.m.a(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "MetaRowRank(title=" + this.a + ", subTitle=" + this.b + ", url=" + this.c + ", isDianFeng=" + this.d + ", count=" + this.e + ", unit=" + this.f + ')';
    }

    public s2(String title, String subTitle, String str, boolean z, String count, String unit) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(count, "count");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.a = title;
        this.b = subTitle;
        this.c = str;
        this.d = z;
        this.e = count;
        this.f = unit;
    }
}
