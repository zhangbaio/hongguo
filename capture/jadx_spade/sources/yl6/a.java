package yl6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    public final Number a;
    public final String b;
    public final String c;
    public final String d;
    public final Number e;

    static {
        Covode.recordClassIndex(656104);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.e, aVar.e);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Number number = this.e;
        return hashCode4 + (number != null ? number.hashCode() : 0);
    }

    public String toString() {
        return "AlbumUpdateEvent(type=" + this.a + ", albumId=" + this.b + ", albumName=" + this.c + ", thumbUrl=" + this.d + ", videoCount=" + this.e + ")";
    }

    public final Number getType() {
        return this.a;
    }

    public a(Number type, String str, String str2, String str3, Number number) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = type;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = number;
    }
}
