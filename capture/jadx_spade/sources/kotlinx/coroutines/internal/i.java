package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i {
    static {
        Covode.recordClassIndex(659222);
    }

    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        Iterator<CoroutineExceptionHandler> it2 = h.a().iterator();
        while (it2.hasNext()) {
            try {
                it2.next().handleException(coroutineContext, th);
            } catch (ExceptionSuccessfullyProcessed unused) {
                return;
            } catch (Throwable th2) {
                h.b(kotlinx.coroutines.z.b(th, th2));
            }
        }
        try {
            ExceptionsKt__ExceptionsKt.addSuppressed(th, new DiagnosticCoroutineContextException(coroutineContext));
        } catch (Throwable unused2) {
        }
        h.b(th);
    }
}
