package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Result;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CompletableDeferredKt {
    static {
        Covode.recordClassIndex(658917);
    }

    public static final <T> CompletableDeferred<T> CompletableDeferred(Job job) {
        return new t(job);
    }

    public static final <T> CompletableDeferred<T> CompletableDeferred(T t) {
        t tVar = new t(null);
        tVar.complete(t);
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean completeWith(CompletableDeferred<T> completableDeferred, Object obj) {
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(obj);
        if (m776exceptionOrNullimpl == null) {
            return completableDeferred.complete(obj);
        }
        return completableDeferred.completeExceptionally(m776exceptionOrNullimpl);
    }

    public static /* synthetic */ CompletableDeferred CompletableDeferred$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return CompletableDeferred(job);
    }
}
