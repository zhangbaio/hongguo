package wq3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public final String a;
    public final String b;
    public final long c;

    static {
        Covode.recordClassIndex(598666);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b) && this.c == bVar.c;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + j.a(this.c);
    }

    public String toString() {
        return "CapabilityVideoParam(seriesId=" + this.a + ", videoId=" + this.b + ", vidIndex=" + this.c + ')';
    }

    public b(String seriesId, String str, long j) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        this.a = seriesId;
        this.b = str;
        this.c = j;
    }

    public /* synthetic */ b(String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? 0L : j);
    }
}
