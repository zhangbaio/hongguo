package io.reactivex.internal.operators.completable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class x extends Completable {
    final CompletableSource a;
    final long b;
    final TimeUnit c;
    final Scheduler d;
    final CompletableSource e;

    static {
        Covode.recordClassIndex(656459);
    }

    final class a implements Runnable {
        private final AtomicBoolean a;
        final CompositeDisposable b;
        final CompletableObserver c;

        static {
            Covode.recordClassIndex(656460);
        }

        /* renamed from: io.reactivex.internal.operators.completable.x$a$a, reason: collision with other inner class name */
        final class C0176a implements CompletableObserver {
            static {
                Covode.recordClassIndex(656461);
            }

            @Override // io.reactivex.CompletableObserver
            public void onComplete() {
                a.this.b.dispose();
                a.this.c.onComplete();
            }

            C0176a() {
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                a.this.b.add(disposable);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                a.this.b.dispose();
                a.this.c.onError(th);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.compareAndSet(false, true)) {
                this.b.clear();
                CompletableSource completableSource = x.this.e;
                if (completableSource == null) {
                    CompletableObserver completableObserver = this.c;
                    x xVar = x.this;
                    completableObserver.onError(new TimeoutException(ExceptionHelper.timeoutMessage(xVar.b, xVar.c)));
                    return;
                }
                completableSource.subscribe(new C0176a());
            }
        }

        a(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.a = atomicBoolean;
            this.b = compositeDisposable;
            this.c = completableObserver;
        }
    }

    static final class b implements CompletableObserver {
        private final CompositeDisposable a;
        private final AtomicBoolean b;
        private final CompletableObserver c;

        static {
            Covode.recordClassIndex(656462);
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            if (this.b.compareAndSet(false, true)) {
                this.a.dispose();
                this.c.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.a.add(disposable);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (this.b.compareAndSet(false, true)) {
                this.a.dispose();
                this.c.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        b(CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean, CompletableObserver completableObserver) {
            this.a = compositeDisposable;
            this.b = atomicBoolean;
            this.c = completableObserver;
        }
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.add(this.d.scheduleDirect(new a(atomicBoolean, compositeDisposable, completableObserver), this.b, this.c));
        this.a.subscribe(new b(compositeDisposable, atomicBoolean, completableObserver));
    }

    public x(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource2) {
        this.a = completableSource;
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = completableSource2;
    }
}
