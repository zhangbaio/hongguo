package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.coroutines.CoroutineContext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class z {
    static {
        Covode.recordClassIndex(658935);
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        ExceptionsKt__ExceptionsKt.addSuppressed(runtimeException, th);
        return runtimeException;
    }

    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.Key);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } else {
                kotlinx.coroutines.internal.i.a(coroutineContext, th);
            }
        } catch (Throwable th2) {
            kotlinx.coroutines.internal.i.a(coroutineContext, b(th, th2));
        }
    }
}
