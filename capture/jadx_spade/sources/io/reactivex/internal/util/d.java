package io.reactivex.internal.util;

import com.bytedance.covode.number.Covode;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d extends CountDownLatch implements Consumer<Throwable>, Action {
    public Throwable a;

    static {
        Covode.recordClassIndex(657724);
    }

    @Override // io.reactivex.functions.Action
    public void run() {
        countDown();
    }

    public d() {
        super(1);
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable th) {
        this.a = th;
        countDown();
    }
}
