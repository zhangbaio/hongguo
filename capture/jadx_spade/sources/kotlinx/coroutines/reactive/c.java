package kotlinx.coroutines.reactive;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.channels.BufferedChannel;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class c<T> extends BufferedChannel<T> implements Subscriber<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater n;
    private static final /* synthetic */ AtomicIntegerFieldUpdater o;
    private volatile /* synthetic */ int _requested$volatile;
    private volatile /* synthetic */ Object _subscription$volatile;
    private final int m;

    static {
        Covode.recordClassIndex(659295);
        n = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_subscription$volatile");
        o = AtomicIntegerFieldUpdater.newUpdater(c.class, "_requested$volatile");
    }

    public void onComplete() {
        close(null);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void t0() {
        o.incrementAndGet(this);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void m0() {
        Subscription subscription = (Subscription) n.getAndSet(this, null);
        if (subscription != null) {
            subscription.cancel();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void u0() {
        Subscription subscription;
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = o;
        while (true) {
            int i2 = atomicIntegerFieldUpdater.get(this);
            subscription = (Subscription) n.get(this);
            i = i2 - 1;
            if (subscription != null && i < 0) {
                if (i2 == this.m || o.compareAndSet(this, i2, this.m)) {
                    break;
                }
            } else if (o.compareAndSet(this, i2, i)) {
                return;
            }
        }
        subscription.request(this.m - i);
    }

    public void onError(Throwable th) {
        close(th);
    }

    public void onNext(T t) {
        o.decrementAndGet(this);
        mo1078trySendJP2dKIU(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(int i) {
        super(Integer.MAX_VALUE, null, 2, 0 == true ? 1 : 0);
        boolean z;
        this.m = i;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("Invalid request size: " + i).toString());
    }

    public void onSubscribe(Subscription subscription) {
        n.set(this, subscription);
        while (!isClosedForSend()) {
            int i = o.get(this);
            if (i >= this.m) {
                return;
            }
            if (o.compareAndSet(this, i, this.m)) {
                subscription.request(this.m - i);
                return;
            }
        }
        subscription.cancel();
    }
}
