package kotlinx.coroutines;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface CompletableDeferred<T> extends Deferred<T> {
    boolean complete(T t);

    boolean completeExceptionally(Throwable th);
}
