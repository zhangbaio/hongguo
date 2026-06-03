package pm4;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j implements h {
    public static final int b;
    private final h a;

    static {
        Covode.recordClassIndex(608516);
        b = 8;
    }

    @Override // pm4.h
    public a a() {
        return this.a.a();
    }

    @Override // pm4.h
    public Context getContext() {
        return this.a.getContext();
    }

    @Override // pm4.h
    public n getReaderConfig() {
        return this.a.getReaderConfig();
    }

    public j(h impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.a = impl;
    }
}
