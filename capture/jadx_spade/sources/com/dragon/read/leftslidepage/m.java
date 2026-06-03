package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public static final int d;
    public final String a;
    public String b;
    public final boolean c;

    static {
        Covode.recordClassIndex(611257);
        d = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return Intrinsics.areEqual(this.a, mVar.a) && Intrinsics.areEqual(this.b, mVar.b) && this.c == mVar.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + androidx.compose.animation.m.a(this.c);
    }

    public String toString() {
        return "SideBarTitleParams(areaTitle=" + this.a + ", areaSubTitle=" + this.b + ", hasMoreIcon=" + this.c + ')';
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public m(String areaTitle, String areaSubTitle, boolean z) {
        Intrinsics.checkNotNullParameter(areaTitle, "areaTitle");
        Intrinsics.checkNotNullParameter(areaSubTitle, "areaSubTitle");
        this.a = areaTitle;
        this.b = areaSubTitle;
        this.c = z;
    }

    public /* synthetic */ m(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? true : z);
    }
}
