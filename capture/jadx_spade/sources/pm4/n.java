package pm4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n implements l {
    public static final int b;
    public final l a;

    static {
        Covode.recordClassIndex(608521);
        b = 8;
    }

    public n(l impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.a = impl;
    }

    @Override // pm4.l
    public void update(lm4.k properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.a.update(properties);
    }
}
