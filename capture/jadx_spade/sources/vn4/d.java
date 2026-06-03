package vn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public final int a;
    public final int b;
    public final int c;
    public final Integer d;
    public final String e;
    public final String f;
    public final int g;

    static {
        Covode.recordClassIndex(608944);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && this.b == dVar.b && this.c == dVar.c && Intrinsics.areEqual(this.d, dVar.d) && Intrinsics.areEqual(this.e, dVar.e) && Intrinsics.areEqual(this.f, dVar.f) && this.g == dVar.g;
    }

    public int hashCode() {
        int i = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        Integer num = this.d;
        return ((((((i + (num == null ? 0 : num.hashCode())) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g;
    }

    public String toString() {
        return "SharePosterQrStyle(right=" + this.a + ", bottom=" + this.b + ", size=" + this.c + ", padding=" + this.d + ", fgColor=" + this.e + ", bgColor=" + this.f + ", radius=" + this.g + ')';
    }

    public d(int i, int i2, int i3, Integer num, String fgColor, String bgColor, int i4) {
        Intrinsics.checkNotNullParameter(fgColor, "fgColor");
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = num;
        this.e = fgColor;
        this.f = bgColor;
        this.g = i4;
    }
}
