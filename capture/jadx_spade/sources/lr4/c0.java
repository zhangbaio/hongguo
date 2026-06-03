package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;
    public final String g;
    public final long h;

    static {
        Covode.recordClassIndex(611581);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return Intrinsics.areEqual(this.a, c0Var.a) && Intrinsics.areEqual(this.b, c0Var.b) && Intrinsics.areEqual(this.c, c0Var.c) && Intrinsics.areEqual(this.d, c0Var.d) && this.e == c0Var.e && this.f == c0Var.f && Intrinsics.areEqual(this.g, c0Var.g) && this.h == c0Var.h;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int hashCode4 = (((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.e) * 31) + this.f) * 31;
        String str4 = this.g;
        return ((hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + j.a(this.h);
    }

    public String toString() {
        return "InteractiveRecord(bookId=" + this.a + ", bookName=" + this.b + ", coverUrl=" + this.c + ", category=" + this.d + ", width=" + this.e + ", height=" + this.f + ", bookStatue=" + this.g + ", updateTime=" + this.h + ')';
    }
}
