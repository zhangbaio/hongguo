package kotlinx.coroutines.future;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a<T> implements BiFunction<T, Throwable, Unit> {
    public volatile Continuation<? super T> cont;

    static {
        Covode.recordClassIndex(659211);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ Unit apply(Object obj, Throwable th) {
        a(obj, th);
        return Unit.INSTANCE;
    }

    public void a(T t, Throwable th) {
        CompletionException completionException;
        Throwable cause;
        Continuation<? super T> continuation = this.cont;
        if (continuation == null) {
            return;
        }
        if (th == null) {
            continuation.resumeWith(Result.m773constructorimpl(t));
            return;
        }
        if (th instanceof CompletionException) {
            completionException = (CompletionException) th;
        } else {
            completionException = null;
        }
        if (completionException != null && (cause = completionException.getCause()) != null) {
            th = cause;
        }
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(th)));
    }
}
