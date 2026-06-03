package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class u0 extends k0 {
    public static final int n;

    static {
        Covode.recordClassIndex(611601);
        n = k0.m;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u0(k0 item) {
        this(item.a, item.b, item.c, item.d, item.e, item.f, item.g, item.h, item.i, item.j, item.k, item.l);
        Intrinsics.checkNotNullParameter(item, "item");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(String bookId, int i, int i2, int i3, long j, String bookName, String coverUrl, String str, String str2, boolean z, String str3, String str4) {
        super(bookId, i, i2, i3, j, bookName, coverUrl, str, str2, z, str3, str4);
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(bookName, "bookName");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
    }
}
