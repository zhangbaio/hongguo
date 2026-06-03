package io.reactivex.internal.util;

import androidx.compose.animation.core.g1;
import com.bytedance.covode.number.Covode;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {
    static {
        Covode.recordClassIndex(657727);
    }

    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> cls) {
        RxJavaPlugins.onError(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference<Disposable> atomicReference, Disposable disposable, Class<?> cls) {
        ObjectHelper.requireNonNull(disposable, "next is null");
        if (!g1.a(atomicReference, (Object) null, disposable)) {
            disposable.dispose();
            if (atomicReference.get() != DisposableHelper.DISPOSED) {
                b(cls);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean d(AtomicReference<Subscription> atomicReference, Subscription subscription, Class<?> cls) {
        ObjectHelper.requireNonNull(subscription, "next is null");
        if (!g1.a(atomicReference, (Object) null, subscription)) {
            subscription.cancel();
            if (atomicReference.get() != SubscriptionHelper.CANCELLED) {
                b(cls);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean e(Disposable disposable, Disposable disposable2, Class<?> cls) {
        ObjectHelper.requireNonNull(disposable2, "next is null");
        if (disposable != null) {
            disposable2.dispose();
            if (disposable != DisposableHelper.DISPOSED) {
                b(cls);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean f(Subscription subscription, Subscription subscription2, Class<?> cls) {
        ObjectHelper.requireNonNull(subscription2, "next is null");
        if (subscription != null) {
            subscription2.cancel();
            if (subscription != SubscriptionHelper.CANCELLED) {
                b(cls);
                return false;
            }
            return false;
        }
        return true;
    }
}
