package kotlinx.coroutines.rx2;

import com.bytedance.covode.number.Covode;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.channels.BufferedChannel;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class g<T> extends BufferedChannel<T> implements Observer<T>, MaybeObserver<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater m;
    private volatile /* synthetic */ Object _subscription$volatile;

    static {
        Covode.recordClassIndex(659315);
        m = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_subscription$volatile");
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        close(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g() {
        super(Integer.MAX_VALUE, null, 2, 0 == true ? 1 : 0);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void m0() {
        Disposable disposable = (Disposable) m.getAndSet(this, null);
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        close(th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        mo1078trySendJP2dKIU(t);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        m.set(this, disposable);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        mo1078trySendJP2dKIU(t);
        close(null);
    }
}
