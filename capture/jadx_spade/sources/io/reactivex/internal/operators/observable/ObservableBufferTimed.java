package io.reactivex.internal.operators.observable;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {
    final Callable<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    static {
        Covode.recordClassIndex(657138);
    }

    static final class a<T, U extends Collection<? super T>> extends io.reactivex.internal.observers.j<T, U, U> implements Runnable, Disposable {
        final Callable<U> g;
        final long h;
        final TimeUnit i;
        final int j;
        final boolean k;
        final Scheduler.Worker l;
        U m;
        Disposable n;
        Disposable o;
        long p;
        long q;

        static {
            Covode.recordClassIndex(657139);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.d) {
                this.d = true;
                this.o.dispose();
                this.l.dispose();
                synchronized (this) {
                    this.m = null;
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u;
            this.l.dispose();
            synchronized (this) {
                u = this.m;
                this.m = null;
            }
            this.c.offer(u);
            this.e = true;
            if (f()) {
                io.reactivex.internal.util.k.d(this.c, this.b, false, this, this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u2 = this.m;
                    if (u2 != null && this.p == this.q) {
                        this.m = u;
                        i(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                this.b.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                this.m = null;
            }
            this.b.onError(th);
            this.l.dispose();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.o, disposable)) {
                this.o = disposable;
                try {
                    this.m = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                    this.b.onSubscribe(this);
                    Scheduler.Worker worker = this.l;
                    long j = this.h;
                    this.n = worker.schedulePeriodically(this, j, j, this.i);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    EmptyDisposable.error(th, this.b);
                    this.l.dispose();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.m;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.j) {
                    return;
                }
                this.m = null;
                this.p++;
                if (this.k) {
                    this.n.dispose();
                }
                i(u, false, this);
                try {
                    U u2 = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                    synchronized (this) {
                        this.m = u2;
                        this.q++;
                    }
                    if (this.k) {
                        Scheduler.Worker worker = this.l;
                        long j = this.h;
                        this.n = worker.schedulePeriodically(this, j, j, this.i);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.b.onError(th);
                    dispose();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(Observer<? super U> observer, U u) {
            observer.onNext(u);
        }

        a(Observer<? super U> observer, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.g = callable;
            this.h = j;
            this.i = timeUnit;
            this.j = i;
            this.k = z;
            this.l = worker;
        }
    }

    static final class c<T, U extends Collection<? super T>> extends io.reactivex.internal.observers.j<T, U, U> implements Runnable, Disposable {
        final Callable<U> g;
        final long h;
        final long i;
        final TimeUnit j;
        final Scheduler.Worker k;
        final List<U> l;
        Disposable m;

        static {
            Covode.recordClassIndex(657141);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        void m() {
            synchronized (this) {
                this.l.clear();
            }
        }

        final class a implements Runnable {
            private final U a;

            static {
                Covode.recordClassIndex(657142);
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.l.remove(this.a);
                }
                c cVar = c.this;
                cVar.i(this.a, false, cVar.k);
            }

            a(U u) {
                this.a = u;
            }
        }

        final class b implements Runnable {
            private final U a;

            static {
                Covode.recordClassIndex(657143);
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.l.remove(this.a);
                }
                c cVar = c.this;
                cVar.i(this.a, false, cVar.k);
            }

            b(U u) {
                this.a = u;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.d) {
                this.d = true;
                m();
                this.m.dispose();
                this.k.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.l);
                this.l.clear();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.c.offer((Collection) it2.next());
            }
            this.e = true;
            if (f()) {
                io.reactivex.internal.util.k.d(this.c, this.b, false, this.k, this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d) {
                return;
            }
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    if (this.d) {
                        return;
                    }
                    this.l.add(collection);
                    this.k.schedule(new a(collection), this.h, this.j);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.b.onError(th);
                dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.e = true;
            m();
            this.b.onError(th);
            this.k.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it2 = this.l.iterator();
                while (it2.hasNext()) {
                    it2.next().add(t);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.m, disposable)) {
                this.m = disposable;
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                    this.l.add(collection);
                    this.b.onSubscribe(this);
                    Scheduler.Worker worker = this.k;
                    long j = this.i;
                    worker.schedulePeriodically(this, j, j, this.j);
                    this.k.schedule(new b(collection), this.h, this.j);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    EmptyDisposable.error(th, this.b);
                    this.k.dispose();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(Observer<? super U> observer, U u) {
            observer.onNext(u);
        }

        c(Observer<? super U> observer, Callable<U> callable, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.g = callable;
            this.h = j;
            this.i = j2;
            this.j = timeUnit;
            this.k = worker;
            this.l = new LinkedList();
        }
    }

    static final class b<T, U extends Collection<? super T>> extends io.reactivex.internal.observers.j<T, U, U> implements Runnable, Disposable {
        final Callable<U> g;
        final long h;
        final TimeUnit i;
        final Scheduler j;
        Disposable k;
        U l;
        final AtomicReference<Disposable> m;

        static {
            Covode.recordClassIndex(657140);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.m);
            this.k.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.m.get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.l;
                this.l = null;
            }
            if (u != null) {
                this.c.offer(u);
                this.e = true;
                if (f()) {
                    io.reactivex.internal.util.k.d(this.c, this.b, false, null, this);
                }
            }
            DisposableHelper.dispose(this.m);
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U u2 = (U) ObjectHelper.requireNonNull(this.g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u = this.l;
                    if (u != null) {
                        this.l = u2;
                    }
                }
                if (u == null) {
                    DisposableHelper.dispose(this.m);
                } else {
                    h(u, false, this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.b.onError(th);
                dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.l;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                this.l = null;
            }
            this.b.onError(th);
            DisposableHelper.dispose(this.m);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                try {
                    this.l = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                    this.b.onSubscribe(this);
                    if (!this.d) {
                        Scheduler scheduler = this.j;
                        long j = this.h;
                        Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j, j, this.i);
                        if (!androidx.compose.animation.core.g1.a(this.m, (Object) null, schedulePeriodicallyDirect)) {
                            schedulePeriodicallyDirect.dispose();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dispose();
                    EmptyDisposable.error(th, this.b);
                }
            }
        }

        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(Observer<? super U> observer, U u) {
            this.b.onNext(u);
        }

        b(Observer<? super U> observer, Callable<U> callable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.m = new AtomicReference<>();
            this.g = callable;
            this.h = j;
            this.i = timeUnit;
            this.j = scheduler;
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        if (this.timespan == this.timeskip && this.maxSize == Integer.MAX_VALUE) {
            this.source.subscribe(new b(new io.reactivex.observers.d(observer), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
            return;
        }
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeskip) {
            this.source.subscribe(new a(new io.reactivex.observers.d(observer), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, createWorker));
        } else {
            this.source.subscribe(new c(new io.reactivex.observers.d(observer), this.bufferSupplier, this.timespan, this.timeskip, this.unit, createWorker));
        }
    }

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i, boolean z) {
        super(observableSource);
        this.timespan = j;
        this.timeskip = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSupplier = callable;
        this.maxSize = i;
        this.restartTimerOnMaxSize = z;
    }
}
