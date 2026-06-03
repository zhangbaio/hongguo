package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class x {
    public final String a;
    public final String b;
    public final String c;
    public final Integer d;
    public final String e;
    public final long f;

    static {
        Covode.recordClassIndex(611574);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Intrinsics.areEqual(this.a, xVar.a) && Intrinsics.areEqual(this.b, xVar.b) && Intrinsics.areEqual(this.c, xVar.c) && Intrinsics.areEqual(this.d, xVar.d) && Intrinsics.areEqual(this.e, xVar.e) && this.f == xVar.f;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.d;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.e;
        return ((hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31) + j.a(this.f);
    }

    public String toString() {
        return "DialogueProgress(bookId=" + this.a + ", progress=" + this.b + ", chapterName=" + this.c + ", chapterIndex=" + this.d + ", chapterId=" + this.e + ", updateTime=" + this.f + ')';
    }
}
