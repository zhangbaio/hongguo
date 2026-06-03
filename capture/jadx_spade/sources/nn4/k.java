package nn4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k {
    public static final int c;
    public String a;
    public boolean b;

    static {
        Covode.recordClassIndex(608813);
        c = 8;
    }

    public k(String seriesId, boolean z) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        this.a = seriesId;
        this.b = z;
    }
}
