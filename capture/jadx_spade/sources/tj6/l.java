package tj6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sj6.b;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l implements sj6.b {
    public static final a e;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    static {
        Covode.recordClassIndex(654078);
        e = new a(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return Intrinsics.areEqual(this.a, lVar.a) && Intrinsics.areEqual(this.b, lVar.b) && Intrinsics.areEqual(this.c, lVar.c) && Intrinsics.areEqual(this.d, lVar.d);
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    @Override // sj6.b
    public String getDetailScene() {
        return this.c;
    }

    @Override // sj6.a
    public String getMainScene() {
        return this.a;
    }

    @Override // sj6.b
    public String getSceneMatchKey() {
        return this.d;
    }

    @Override // sj6.a
    public String getSubScene() {
        return this.b;
    }

    @Override // sj6.b, sj6.a
    public String getScene() {
        return b.a.b(this);
    }

    public String toString() {
        return getScene();
    }

    public static final class a {
        static {
            Covode.recordClassIndex(654079);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public l(String str, String str2) {
        this(str, str2, null, null);
    }

    public l(sj6.a aVar, String str) {
        this(aVar.getMainScene(), aVar.getSubScene(), str, null);
    }

    public l(sj6.a aVar, String str, String str2) {
        this(aVar.getMainScene(), aVar.getSubScene(), str, str2);
    }

    public l(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }
}
