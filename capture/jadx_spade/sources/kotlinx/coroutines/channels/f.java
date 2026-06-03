package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f<E> implements BroadcastChannel<E> {
    private final BroadcastChannelImpl<E> a;

    static {
        Covode.recordClassIndex(659089);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(CancellationException cancellationException) {
        this.a.cancel(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public /* synthetic */ boolean cancel(Throwable th) {
        return this.a.cancel(th);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        return this.a.close(th);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public kotlinx.coroutines.selects.e<E, SendChannel<E>> getOnSend() {
        return this.a.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        this.a.invokeOnClose(function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.a.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e) {
        return this.a.offer(e);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        return this.a.openSubscription();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        return this.a.send(e, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo1078trySendJP2dKIU(E e) {
        return this.a.mo1078trySendJP2dKIU(e);
    }

    public f() {
        this(new BroadcastChannelImpl(-1));
    }

    private f(BroadcastChannelImpl<E> broadcastChannelImpl) {
        this.a = broadcastChannelImpl;
    }
}
