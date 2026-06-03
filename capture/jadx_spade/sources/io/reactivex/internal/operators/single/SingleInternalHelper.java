package io.reactivex.internal.operators.single;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SingleInternalHelper {
    static {
        Covode.recordClassIndex(657591);
    }

    public static <T> Callable<NoSuchElementException> a() {
        return NoSuchElementCallable.INSTANCE;
    }

    public static <T> Function<SingleSource<? extends T>, Publisher<? extends T>> b() {
        return ToFlowable.INSTANCE;
    }

    public static <T> Function<SingleSource<? extends T>, Observable<? extends T>> c() {
        return ToObservable.INSTANCE;
    }

    enum NoSuchElementCallable implements Callable<NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public NoSuchElementException call() throws Exception {
            return new NoSuchElementException();
        }

        static {
            Covode.recordClassIndex(657592);
        }
    }

    enum ToFlowable implements Function<SingleSource, Publisher> {
        INSTANCE;

        static {
            Covode.recordClassIndex(657593);
        }

        @Override // io.reactivex.functions.Function
        public Publisher apply(SingleSource singleSource) {
            return new SingleToFlowable(singleSource);
        }
    }

    enum ToObservable implements Function<SingleSource, Observable> {
        INSTANCE;

        static {
            Covode.recordClassIndex(657596);
        }

        @Override // io.reactivex.functions.Function
        public Observable apply(SingleSource singleSource) {
            return new SingleToObservable(singleSource);
        }
    }
}
