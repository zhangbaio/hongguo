package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class y {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;

    static {
        Covode.recordClassIndex(611575);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Intrinsics.areEqual(this.a, yVar.a) && Intrinsics.areEqual(this.b, yVar.b) && Intrinsics.areEqual(this.c, yVar.c) && Intrinsics.areEqual(this.d, yVar.d) && Intrinsics.areEqual(this.e, yVar.e) && this.f == yVar.f;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        return ((hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + j.a(this.f);
    }

    public String toString() {
        return "DialogueRecord(bookId=" + this.a + ", bookName=" + this.b + ", coverUrl=" + this.c + ", category=" + this.d + ", bookStatus=" + this.e + ", updateTime=" + this.f + ')';
    }
}
