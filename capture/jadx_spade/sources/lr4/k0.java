package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class k0 {
    public static final int m;
    public String a;
    public int b;
    public int c;
    public int d;
    public long e;
    public String f;
    public String g;
    public String h;
    public String i;
    public boolean j;
    public String k;
    public String l;

    static {
        Covode.recordClassIndex(611590);
        m = 8;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k0(String bookId) {
        this(bookId, 0, 0, 0, 0L, "", "", "", "", true, "", "");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
    }

    public k0(String bookId, int i, int i2, int i3, long j, String bookName, String coverUrl, String str, String str2, boolean z, String str3, String str4) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(bookName, "bookName");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        this.a = bookId;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = j;
        this.f = bookName;
        this.g = coverUrl;
        this.h = str;
        this.i = str2;
        this.j = z;
        this.k = str3;
        this.l = str4;
    }
}
