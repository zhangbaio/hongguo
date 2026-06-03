package io.reactivex.internal.schedulers;

import com.bytedance.covode.number.Covode;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SchedulerWhen extends Scheduler implements Disposable {
    static final Disposable d;
    static final Disposable e;
    private final Scheduler a;
    private final io.reactivex.processors.a<Flowable<Completable>> b;
    private Disposable c;

    static final class d implements Disposable {
        static {
            Covode.recordClassIndex(657678);
        }

        d() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }
    }

    static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        static {
            Covode.recordClassIndex(657677);
        }

        protected abstract Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver);

        ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get().isDisposed();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable;
            Disposable disposable2 = SchedulerWhen.e;
            do {
                disposable = get();
                if (disposable == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(disposable, disposable2));
            if (disposable != SchedulerWhen.d) {
                disposable.dispose();
            }
        }

        void call(Scheduler.Worker worker, CompletableObserver completableObserver) {
            Disposable disposable;
            Disposable disposable2 = get();
            if (disposable2 == SchedulerWhen.e || disposable2 != (disposable = SchedulerWhen.d)) {
                return;
            }
            Disposable callActual = callActual(worker, completableObserver);
            if (!compareAndSet(disposable, callActual)) {
                callActual.dispose();
            }
        }
    }

    static final class c extends Scheduler.Worker {
        private final AtomicBoolean a = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> b;
        private final Scheduler.Worker c;

        static {
            Covode.recordClassIndex(657676);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.a.get();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.a.compareAndSet(false, true)) {
                this.b.onComplete();
                this.c.dispose();
            }
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.b.onNext(immediateAction);
            return immediateAction;
        }

        c(io.reactivex.processors.a<ScheduledAction> aVar, Scheduler.Worker worker) {
            this.b = aVar;
            this.c = worker;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.b.onNext(delayedAction);
            return delayedAction;
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.c.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    static class b implements Runnable {
        final CompletableObserver a;
        final Runnable b;

        static {
            Covode.recordClassIndex(657675);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } finally {
                this.a.onComplete();
            }
        }

        b(Runnable runnable, CompletableObserver completableObserver) {
            this.b = runnable;
            this.a = completableObserver;
        }
    }

    static {
        Covode.recordClassIndex(657670);
        d = new d();
        e = Disposables.disposed();
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        Scheduler.Worker createWorker = this.a.createWorker();
        io.reactivex.processors.a<T> serialized = UnicastProcessor.c().toSerialized();
        Flowable map = serialized.map(new a(createWorker));
        c cVar = new c(serialized, createWorker);
        this.b.onNext(map);
        return cVar;
    }

    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        static {
            Covode.recordClassIndex(657674);
        }

        ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.schedule(new b(this.action, completableObserver));
        }
    }

    static final class a implements Function<ScheduledAction, Completable> {
        final Scheduler.Worker a;

        static {
            Covode.recordClassIndex(657671);
        }

        a(Scheduler.Worker worker) {
            this.a = worker;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Completable apply(ScheduledAction scheduledAction) {
            return new C0190a(scheduledAction);
        }

        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a, reason: collision with other inner class name */
        final class C0190a extends Completable {
            final ScheduledAction a;

            static {
                Covode.recordClassIndex(657672);
            }

            @Override // io.reactivex.Completable
            protected void subscribeActual(CompletableObserver completableObserver) {
                completableObserver.onSubscribe(this.a);
                this.a.call(a.this.a, completableObserver);
            }

            C0190a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }
        }
    }

    static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        static {
            Covode.recordClassIndex(657673);
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.schedule(new b(this.action, completableObserver), this.delayTime, this.unit);
        }

        DelayedAction(Runnable runnable, long j, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j;
            this.unit = timeUnit;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SchedulerWhen(Function<Flowable<Flowable<Completable>>, Completable> function, Scheduler scheduler) {
        this.a = scheduler;
        io.reactivex.processors.a serialized = UnicastProcessor.c().toSerialized();
        this.b = serialized;
        try {
            this.c = ((Completable) function.apply(serialized)).subscribe();
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }
}
