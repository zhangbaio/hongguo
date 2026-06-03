package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class v<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final Consumer<? super T> b;
    final Consumer<? super Throwable> c;
    final Action d;
    final Action e;

    static {
        Covode.recordClassIndex(656588);
    }

    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {
        final Consumer<? super T> f;
        final Consumer<? super Throwable> g;
        final Action h;
        final Action i;

        static {
            Covode.recordClassIndex(656589);
        }

        @Override // io.reactivex.internal.subscribers.a
        public void onComplete() {
            if (this.d) {
                return;
            }
            try {
                this.h.run();
                this.d = true;
                this.a.onComplete();
                try {
                    this.i.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // nm6.j
        public T poll() throws Exception {
            try {
                T poll = this.c.poll();
                if (poll != null) {
                    try {
                        this.f.accept(poll);
                    } catch (Throwable th) {
                        try {
                            Exceptions.throwIfFatal(th);
                            try {
                                this.g.accept(th);
                                throw ExceptionHelper.throwIfThrowable(th);
                            } catch (Throwable th2) {
                                throw new CompositeException(th, th2);
                            }
                        } finally {
                            this.i.run();
                        }
                    }
                } else if (this.e == 1) {
                    this.h.run();
                }
                return poll;
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                try {
                    this.g.accept(th3);
                    throw ExceptionHelper.throwIfThrowable(th3);
                } catch (Throwable th4) {
                    throw new CompositeException(th3, th4);
                }
            }
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return d(i);
        }

        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                this.a.onNext((Object) null);
                return;
            }
            try {
                this.f.accept(t);
                this.a.onNext(t);
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // nm6.a
        public boolean tryOnNext(T t) {
            if (this.d) {
                return false;
            }
            try {
                this.f.accept(t);
                return this.a.tryOnNext(t);
            } catch (Throwable th) {
                c(th);
                return false;
            }
        }

        @Override // io.reactivex.internal.subscribers.a
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            boolean z = true;
            this.d = true;
            try {
                this.g.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.a.onError(th);
            }
            try {
                this.i.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(th3);
            }
        }

        a(nm6.a<? super T> aVar, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(aVar);
            this.f = consumer;
            this.g = consumer2;
            this.h = action;
            this.i = action2;
        }
    }

    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> {
        final Consumer<? super T> f;
        final Consumer<? super Throwable> g;
        final Action h;
        final Action i;

        static {
            Covode.recordClassIndex(656590);
        }

        @Override // io.reactivex.internal.subscribers.b
        public void onComplete() {
            if (this.d) {
                return;
            }
            try {
                this.h.run();
                this.d = true;
                this.a.onComplete();
                try {
                    this.i.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // nm6.j
        public T poll() throws Exception {
            try {
                T poll = this.c.poll();
                if (poll != null) {
                    try {
                        this.f.accept(poll);
                    } catch (Throwable th) {
                        try {
                            Exceptions.throwIfFatal(th);
                            try {
                                this.g.accept(th);
                                throw ExceptionHelper.throwIfThrowable(th);
                            } catch (Throwable th2) {
                                throw new CompositeException(th, th2);
                            }
                        } finally {
                            this.i.run();
                        }
                    }
                } else if (this.e == 1) {
                    this.h.run();
                }
                return poll;
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                try {
                    this.g.accept(th3);
                    throw ExceptionHelper.throwIfThrowable(th3);
                } catch (Throwable th4) {
                    throw new CompositeException(th3, th4);
                }
            }
        }

        @Override // nm6.f
        public int requestFusion(int i) {
            return d(i);
        }

        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                this.a.onNext((Object) null);
                return;
            }
            try {
                this.f.accept(t);
                this.a.onNext(t);
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // io.reactivex.internal.subscribers.b
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            boolean z = true;
            this.d = true;
            try {
                this.g.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.a.onError(th);
            }
            try {
                this.i.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(th3);
            }
        }

        b(Subscriber<? super T> subscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(subscriber);
            this.f = consumer;
            this.g = consumer2;
            this.h = action;
            this.i = action2;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof nm6.a) {
            this.a.subscribe((FlowableSubscriber) new a((nm6.a) subscriber, this.b, this.c, this.d, this.e));
        } else {
            this.a.subscribe((FlowableSubscriber) new b(subscriber, this.b, this.c, this.d, this.e));
        }
    }

    public v(Flowable<T> flowable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(flowable);
        this.b = consumer;
        this.c = consumer2;
        this.d = action;
        this.e = action2;
    }
}
