package io.reactivex.internal.subscribers;

import com.bytedance.covode.number.Covode;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final g<T> parent;
    final int prefetch;
    long produced;
    volatile nm6.j<T> queue;

    static {
        Covode.recordClassIndex(657696);
    }

    public void setDone() {
        this.done = true;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    public nm6.j<T> queue() {
        return this.queue;
    }

    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void requestOne() {
        if (this.fusionMode != 1) {
            long j = this.produced + 1;
            if (j == this.limit) {
                this.produced = 0L;
                get().request(j);
            } else {
                this.produced = j;
            }
        }
    }

    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    public void request(long j) {
        if (this.fusionMode != 1) {
            long j2 = this.produced + j;
            if (j2 >= this.limit) {
                this.produced = 0L;
                get().request(j2);
            } else {
                this.produced = j2;
            }
        }
    }

    @Override // io.reactivex.FlowableSubscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof nm6.g) {
                nm6.g gVar = (nm6.g) subscription;
                int requestFusion = gVar.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = gVar;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = gVar;
                    io.reactivex.internal.util.k.j(subscription, this.prefetch);
                    return;
                }
            }
            this.queue = io.reactivex.internal.util.k.c(this.prefetch);
            io.reactivex.internal.util.k.j(subscription, this.prefetch);
        }
    }

    public InnerQueuedSubscriber(g<T> gVar, int i) {
        this.parent = gVar;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }
}
