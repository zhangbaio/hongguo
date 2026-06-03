package xq4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final C0293a d;
    public static final int e;
    public int a;
    public String b;
    public List<b> c;

    /* renamed from: xq4.a$a, reason: collision with other inner class name */
    public static final class C0293a {
        static {
            Covode.recordClassIndex(611348);
        }

        private C0293a() {
        }

        public /* synthetic */ C0293a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(611347);
        d = new C0293a(null);
        e = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && Intrinsics.areEqual(this.b, aVar.b);
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BookSelectConfig(maxBookCardCount=" + this.a + ", maxBookCardCountTips=" + this.b + ')';
    }

    public final boolean b() {
        if (this.c.size() >= this.a) {
            return true;
        }
        return false;
    }

    public final a a() {
        a aVar = new a(this.a, this.b);
        aVar.c.addAll(this.c);
        return aVar;
    }

    public final void c(List<b> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.c = list;
    }

    public a(int i, String str) {
        this.a = i;
        this.b = str;
        this.c = new ArrayList();
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;

        static {
            Covode.recordClassIndex(611349);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Info(id=" + this.a + ", bookType=" + this.b + ", genreType=" + this.c + ')';
        }

        public b(String id, String bookType, String genreType) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(bookType, "bookType");
            Intrinsics.checkNotNullParameter(genreType, "genreType");
            this.a = id;
            this.b = bookType;
            this.c = genreType;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(int r1, java.lang.String r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L6
            r1 = 20
        L6:
            r3 = r3 & 2
            if (r3 == 0) goto L21
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "最多添加"
            r2.append(r3)
            r2.append(r1)
            r3 = 26412(0x672c, float:3.7011E-41)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
        L21:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xq4.a.<init>(int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
