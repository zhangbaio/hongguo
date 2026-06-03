package im4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.reader.model.SaaSBookInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final int b;
    private final SaaSBookInfo a;

    static {
        Covode.recordClassIndex(608468);
        b = 8;
    }

    public final String a() {
        return this.a.bookId;
    }

    public final String b() {
        return this.a.lastChapterItemId;
    }

    public final boolean c() {
        return this.a.isPubPay;
    }

    public d(SaaSBookInfo delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.a = delegate;
    }
}
