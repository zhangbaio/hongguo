package kotlinx.coroutines;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface CompletableJob extends Job {
    boolean complete();

    boolean completeExceptionally(Throwable th);
}
