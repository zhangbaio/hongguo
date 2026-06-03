package io.reactivex.internal.util;

import com.bytedance.covode.number.Covode;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e implements Consumer<Disposable> {
    public Disposable a;

    static {
        Covode.recordClassIndex(657725);
    }

    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Disposable disposable) throws Exception {
        this.a = disposable;
    }
}
