package io.reactivex.internal.schedulers;

import com.bytedance.covode.number.Covode;
import io.reactivex.Scheduler;
import java.util.concurrent.ThreadFactory;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f extends Scheduler {
    private static final RxThreadFactory b;
    final ThreadFactory a;

    public f() {
        this(b);
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new g(this.a);
    }

    static {
        Covode.recordClassIndex(657657);
        b = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    }

    public f(ThreadFactory threadFactory) {
        this.a = threadFactory;
    }
}
