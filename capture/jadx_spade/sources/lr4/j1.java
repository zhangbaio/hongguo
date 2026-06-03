package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j1 {
    public final String a;
    public final long b;
    private final int c;
    public final int d;

    static {
        Covode.recordClassIndex(611619);
    }

    public final int getType() {
        return this.c;
    }

    public j1(String commentId, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        this.a = commentId;
        this.b = j;
        this.c = i;
        this.d = i2;
    }
}
