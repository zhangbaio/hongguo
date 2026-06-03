package pm4;

import com.bytedance.covode.number.Covode;
import com.dragon.reader.lib.interfaces.IReaderConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o implements l {
    public static final int b;
    public final IReaderConfig a;

    static {
        Covode.recordClassIndex(608522);
        b = 8;
    }

    public o(IReaderConfig impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.a = impl;
    }

    @Override // pm4.l
    public void update(lm4.k properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.a.update(new j45.a(properties));
    }
}
