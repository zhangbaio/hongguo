package wq3;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final String a;
    public final String b;
    public final Map<String, Serializable> c;

    static {
        Covode.recordClassIndex(598665);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "CapabilityNode(seriesId=" + this.a + ", vid=" + this.b + ", extra=" + this.c + ')';
    }

    public a(String str, String str2, Map<String, Serializable> extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.a = str;
        this.b = str2;
        this.c = extra;
    }
}
