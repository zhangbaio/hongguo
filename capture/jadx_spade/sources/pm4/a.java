package pm4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements e {
    public static final int b;
    private final e a;

    static {
        Covode.recordClassIndex(608508);
        b = 8;
    }

    public a(e impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.a = impl;
    }

    @Override // pm4.e
    public void a(f configChangedListener) {
        Intrinsics.checkNotNullParameter(configChangedListener, "configChangedListener");
        this.a.a(configChangedListener);
    }
}
