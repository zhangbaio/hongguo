package jm6;

import com.bytedance.covode.number.Covode;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private static volatile Function<Callable<Scheduler>, Scheduler> a;
    private static volatile Function<Scheduler, Scheduler> b;

    static {
        Covode.recordClassIndex(656246);
    }

    static Scheduler c(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    public static Scheduler d(Callable<Scheduler> callable) {
        if (callable != null) {
            Function<Callable<Scheduler>, Scheduler> function = a;
            if (function == null) {
                return c(callable);
            }
            return b(function, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static Scheduler e(Scheduler scheduler) {
        if (scheduler != null) {
            Function<Scheduler, Scheduler> function = b;
            if (function == null) {
                return scheduler;
            }
            return (Scheduler) a(function, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    static <T, R> R a(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    static Scheduler b(Function<Callable<Scheduler>, Scheduler> function, Callable<Scheduler> callable) {
        Scheduler scheduler = (Scheduler) a(function, callable);
        if (scheduler != null) {
            return scheduler;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }
}
