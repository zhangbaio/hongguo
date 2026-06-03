package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ObservableTakeLastTimed<T> extends a<T, T> {
    final long a;
    final long b;
    final TimeUnit c;
    final Scheduler d;
    final int e;
    final boolean f;

    static {
        Covode.recordClassIndex(657410);
    }

    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        final Observer<? super T> downstream;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        Disposable upstream;

        static {
            Covode.recordClassIndex(657411);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                if (compareAndSet(false, true)) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            boolean z;
            Throwable th;
            if (!compareAndSet(false, true)) {
                return;
            }
            Observer<? super T> observer = this.downstream;
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            boolean z2 = this.delayError;
            while (!this.cancelled) {
                if (!z2 && (th = this.error) != null) {
                    aVar.clear();
                    observer.onError(th);
                    return;
                }
                Object poll = aVar.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        observer.onError(th2);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
                Object poll2 = aVar.poll();
                if (((Long) poll).longValue() >= this.scheduler.now(this.unit) - this.time) {
                    observer.onNext(poll2);
                }
            }
            aVar.clear();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            boolean z;
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            long now = this.scheduler.now(this.unit);
            long j = this.time;
            long j2 = this.count;
            if (j2 == Long.MAX_VALUE) {
                z = true;
            } else {
                z = false;
            }
            aVar.l(Long.valueOf(now), t);
            while (!aVar.isEmpty()) {
                if (((Long) aVar.peek()).longValue() <= now - j || (!z && (aVar.n() >> 1) > j2)) {
                    aVar.poll();
                    aVar.poll();
                } else {
                    return;
                }
            }
        }

        TakeLastTimedObserver(Observer<? super T> observer, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
            this.downstream = observer;
            this.count = j;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.delayError = z;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeLastTimedObserver(observer, this.a, this.b, this.c, this.d, this.e, this.f));
    }

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(observableSource);
        this.a = j;
        this.b = j2;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = i;
        this.f = z;
    }
}
