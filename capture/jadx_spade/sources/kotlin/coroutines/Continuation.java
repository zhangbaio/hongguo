package kotlin.coroutines;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface Continuation<T> {
    CoroutineContext getContext();

    void resumeWith(Object obj);
}
