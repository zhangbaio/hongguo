package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b<E> extends kotlinx.coroutines.a<Unit> implements Channel<E> {
    public final Channel<E> d;

    static {
        Covode.recordClassIndex(659074);
    }

    public final Channel<E> J0() {
        return this;
    }

    public boolean close(Throwable th) {
        return this.d.close(th);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceive() {
        return this.d.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        return this.d.getOnReceiveCatching();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceiveOrNull() {
        return this.d.getOnReceiveOrNull();
    }

    public kotlinx.coroutines.selects.e<E, SendChannel<E>> getOnSend() {
        return this.d.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        this.d.invokeOnClose(function1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this.d.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.d.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return this.d.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return this.d.iterator();
    }

    public boolean offer(E e) {
        return this.d.offer(e);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public E poll() {
        return this.d.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation<? super E> continuation) {
        return this.d.receive(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU */
    public Object mo1079receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        Object mo1079receiveCatchingJP2dKIU = this.d.mo1079receiveCatchingJP2dKIU(continuation);
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return mo1079receiveCatchingJP2dKIU;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return this.d.receiveOrNull(continuation);
    }

    public Object send(E e, Continuation<? super Unit> continuation) {
        return this.d.send(e, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk */
    public Object mo1080tryReceivePtdJZtk() {
        return this.d.mo1080tryReceivePtdJZtk();
    }

    /* renamed from: trySend-JP2dKIU */
    public Object mo1078trySendJP2dKIU(E e) {
        return this.d.mo1078trySendJP2dKIU(e);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        v(new JobCancellationException(y(), null, this));
    }

    @Override // kotlinx.coroutines.JobSupport
    public void v(Throwable th) {
        CancellationException x0 = JobSupport.x0(this, th, null, 1, null);
        this.d.cancel(x0);
        s(x0);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(y(), null, this);
        }
        v(cancellationException);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final /* synthetic */ boolean cancel(Throwable th) {
        v(new JobCancellationException(y(), null, this));
        return true;
    }

    public b(CoroutineContext coroutineContext, Channel<E> channel, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this.d = channel;
    }
}
