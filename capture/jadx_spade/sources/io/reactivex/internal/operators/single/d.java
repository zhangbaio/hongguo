package io.reactivex.internal.operators.single;

import com.bytedance.covode.number.Covode;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<T> extends Single<T> {
    final SingleSource<? extends T> a;
    final long b;
    final TimeUnit c;
    final Scheduler d;
    final boolean e;

    static {
        Covode.recordClassIndex(657536);
    }

    final class a implements SingleObserver<T> {
        private final SequentialDisposable a;
        final SingleObserver<? super T> b;

        static {
            Covode.recordClassIndex(657537);
        }

        /* renamed from: io.reactivex.internal.operators.single.d$a$a, reason: collision with other inner class name */
        final class RunnableC0189a implements Runnable {
            private final Throwable a;

            static {
                Covode.recordClassIndex(657538);
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.onError(this.a);
            }

            RunnableC0189a(Throwable th) {
                this.a = th;
            }
        }

        final class b implements Runnable {
            private final T a;

            static {
                Covode.recordClassIndex(657539);
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.onSuccess(this.a);
            }

            b(T t) {
                this.a = t;
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.a.replace(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            long j;
            SequentialDisposable sequentialDisposable = this.a;
            Scheduler scheduler = d.this.d;
            RunnableC0189a runnableC0189a = new RunnableC0189a(th);
            d dVar = d.this;
            if (dVar.e) {
                j = dVar.b;
            } else {
                j = 0;
            }
            sequentialDisposable.replace(scheduler.scheduleDirect(runnableC0189a, j, dVar.c));
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            SequentialDisposable sequentialDisposable = this.a;
            Scheduler scheduler = d.this.d;
            b bVar = new b(t);
            d dVar = d.this;
            sequentialDisposable.replace(scheduler.scheduleDirect(bVar, dVar.b, dVar.c));
        }

        a(SequentialDisposable sequentialDisposable, SingleObserver<? super T> singleObserver) {
            this.a = sequentialDisposable;
            this.b = singleObserver;
        }
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.onSubscribe(sequentialDisposable);
        this.a.subscribe(new a(sequentialDisposable, singleObserver));
    }

    public d(SingleSource<? extends T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.a = singleSource;
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = z;
    }
}
