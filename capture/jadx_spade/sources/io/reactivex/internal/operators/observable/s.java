package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class s<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final long a;
    final TimeUnit b;
    final Scheduler c;
    final boolean d;

    static {
        Covode.recordClassIndex(657181);
    }

    static final class a<T> implements Observer<T>, Disposable {
        final Observer<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler.Worker d;
        final boolean e;
        Disposable f;

        static {
            Covode.recordClassIndex(657182);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        final class c implements Runnable {
            private final T a;

            static {
                Covode.recordClassIndex(657185);
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.onNext(this.a);
            }

            c(T t) {
                this.a = t;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f.dispose();
            this.d.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.d.schedule(new RunnableC0182a(), this.b, this.c);
        }

        /* renamed from: io.reactivex.internal.operators.observable.s$a$a, reason: collision with other inner class name */
        final class RunnableC0182a implements Runnable {
            static {
                Covode.recordClassIndex(657183);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onComplete();
                } finally {
                    a.this.d.dispose();
                }
            }

            RunnableC0182a() {
            }
        }

        final class b implements Runnable {
            private final Throwable a;

            static {
                Covode.recordClassIndex(657184);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onError(this.a);
                } finally {
                    a.this.d.dispose();
                }
            }

            b(Throwable th) {
                this.a = th;
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.d.schedule(new c(t), this.b, this.c);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            long j;
            Scheduler.Worker worker = this.d;
            b bVar = new b(th);
            if (this.e) {
                j = this.b;
            } else {
                j = 0;
            }
            worker.schedule(bVar, j, this.c);
        }

        a(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.a = observer;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
            this.e = z;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Observer<? super T> dVar;
        if (this.d) {
            dVar = observer;
        } else {
            dVar = new io.reactivex.observers.d(observer);
        }
        this.source.subscribe(new a(dVar, this.a, this.b, this.c.createWorker(), this.d));
    }

    public s(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.a = j;
        this.b = timeUnit;
        this.c = scheduler;
        this.d = z;
    }
}
