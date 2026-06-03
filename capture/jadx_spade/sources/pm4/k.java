package pm4;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.reader.lib.ReaderClient;
import com.dragon.reader.lib.interfaces.IReaderConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k implements h {
    public static final int d;
    public final ReaderClient a;
    private final a b;
    private final n c;

    static {
        Covode.recordClassIndex(608517);
        d = 8;
    }

    @Override // pm4.h
    public a a() {
        return this.b;
    }

    @Override // pm4.h
    public n getReaderConfig() {
        return this.c;
    }

    @Override // pm4.h
    public Context getContext() {
        Context context = this.a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return context;
    }

    public k(ReaderClient impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.a = impl;
        this.b = new a(new d(impl));
        IReaderConfig readerConfig = impl.getReaderConfig();
        Intrinsics.checkNotNullExpressionValue(readerConfig, "getReaderConfig(...)");
        this.c = new n(new o(readerConfig));
    }
}
