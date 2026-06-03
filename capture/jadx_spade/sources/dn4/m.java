package dn4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public final int a;
    public final String b;
    public final String c;

    static {
        Covode.recordClassIndex(608748);
    }

    public m() {
        this(0, null, null, 7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.a == mVar.a && Intrinsics.areEqual(this.b, mVar.b) && Intrinsics.areEqual(this.c, mVar.c);
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "IpForumEntranceCardModel(index=" + this.a + ", cover=" + this.b + ", schema=" + this.c + ')';
    }

    public m(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public /* synthetic */ m(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2);
    }
}
