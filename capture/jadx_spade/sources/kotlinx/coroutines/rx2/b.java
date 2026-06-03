package kotlinx.coroutines.rx2;

import com.bytedance.covode.number.Covode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.z;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    static {
        Covode.recordClassIndex(659301);
    }

    public static final void a(Throwable th, CoroutineContext coroutineContext) {
        if (th instanceof CancellationException) {
            return;
        }
        try {
            RxJavaPlugins.onError(th);
        } catch (Throwable th2) {
            ExceptionsKt__ExceptionsKt.addSuppressed(th, th2);
            z.a(coroutineContext, th);
        }
    }
}
