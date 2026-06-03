package io.reactivex.internal.operators.flowable;

import ak4.d;
import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class u0 {
    static {
        Covode.recordClassIndex(656785);
    }

    static final class a<T, R> extends Flowable<R> {
        final T a;
        final Function<? super T, ? extends Publisher<? extends R>> b;

        static {
            Covode.recordClassIndex(656786);
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                Callable callable = (Publisher) ObjectHelper.requireNonNull(this.b.apply(this.a), "The mapper returned a null Publisher");
                if (callable instanceof Callable) {
                    try {
                        Object call = callable.call();
                        if (call == null) {
                            EmptySubscription.complete(subscriber);
                            return;
                        } else {
                            subscriber.onSubscribe(new ScalarSubscription(subscriber, call));
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptySubscription.error(th, subscriber);
                        return;
                    }
                }
                callable.subscribe(subscriber);
            } catch (Throwable th2) {
                EmptySubscription.error(th2, subscriber);
            }
        }

        a(T t, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.a = t;
            this.b = function;
        }
    }

    public static <T, U> Flowable<U> a(T t, Function<? super T, ? extends Publisher<? extends U>> function) {
        return RxJavaPlugins.onAssembly(new a(t, function));
    }

    public static <T, R> boolean b(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        if (publisher instanceof Callable) {
            try {
                d.a.C0000a c0000a = (Object) ((Callable) publisher).call();
                if (c0000a == null) {
                    EmptySubscription.complete(subscriber);
                    return true;
                }
                try {
                    Callable callable = (Publisher) ObjectHelper.requireNonNull(function.apply(c0000a), "The mapper returned a null Publisher");
                    if (callable instanceof Callable) {
                        try {
                            Object call = callable.call();
                            if (call == null) {
                                EmptySubscription.complete(subscriber);
                                return true;
                            }
                            subscriber.onSubscribe(new ScalarSubscription(subscriber, call));
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            EmptySubscription.error(th, subscriber);
                            return true;
                        }
                    } else {
                        callable.subscribe(subscriber);
                    }
                    return true;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptySubscription.error(th2, subscriber);
                    return true;
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptySubscription.error(th3, subscriber);
                return true;
            }
        }
        return false;
    }
}
