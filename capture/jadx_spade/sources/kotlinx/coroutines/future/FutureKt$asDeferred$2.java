package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.z;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class FutureKt$asDeferred$2 extends Lambda implements Function2<Object, Throwable, Object> {
    final /* synthetic */ CompletableDeferred<Object> $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FutureKt$asDeferred$2(CompletableDeferred<Object> completableDeferred) {
        super(2);
        this.$result = completableDeferred;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Throwable th) {
        CompletionException completionException;
        boolean completeExceptionally;
        Throwable cause;
        try {
            if (th == null) {
                completeExceptionally = this.$result.complete(obj);
            } else {
                CompletableDeferred<Object> completableDeferred = this.$result;
                if (th instanceof CompletionException) {
                    completionException = (CompletionException) th;
                } else {
                    completionException = null;
                }
                if (completionException != null && (cause = completionException.getCause()) != null) {
                    th = cause;
                }
                completeExceptionally = completableDeferred.completeExceptionally(th);
            }
            return Boolean.valueOf(completeExceptionally);
        } catch (Throwable th2) {
            z.a(EmptyCoroutineContext.INSTANCE, th2);
            return Unit.INSTANCE;
        }
    }
}
