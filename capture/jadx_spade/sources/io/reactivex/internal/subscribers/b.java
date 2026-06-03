package io.reactivex.internal.subscribers;

import com.bytedance.covode.number.Covode;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class b<T, R> implements FlowableSubscriber<T>, nm6.g<R> {
    protected final Subscriber<? super R> a;
    protected Subscription b;
    protected nm6.g<T> c;
    protected boolean d;
    protected int e;

    static {
        Covode.recordClassIndex(657687);
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    public void cancel() {
        this.b.cancel();
    }

    public void clear() {
        this.c.clear();
    }

    @Override // nm6.j
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    public void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.a.onComplete();
    }

    public b(Subscriber<? super R> subscriber) {
        this.a = subscriber;
    }

    @Override // nm6.j
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void request(long j) {
        this.b.request(j);
    }

    protected final void c(Throwable th) {
        Exceptions.throwIfFatal(th);
        this.b.cancel();
        onError(th);
    }

    protected final int d(int i) {
        nm6.g<T> gVar = this.c;
        if (gVar != null && (i & 4) == 0) {
            int requestFusion = gVar.requestFusion(i);
            if (requestFusion != 0) {
                this.e = requestFusion;
            }
            return requestFusion;
        }
        return 0;
    }

    public void onError(Throwable th) {
        if (this.d) {
            RxJavaPlugins.onError(th);
        } else {
            this.d = true;
            this.a.onError(th);
        }
    }

    @Override // io.reactivex.FlowableSubscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.b, subscription)) {
            this.b = subscription;
            if (subscription instanceof nm6.g) {
                this.c = (nm6.g) subscription;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }
}
