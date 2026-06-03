package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface BroadcastChannel<E> extends SendChannel<E> {
    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    ReceiveChannel<E> openSubscription();
}
