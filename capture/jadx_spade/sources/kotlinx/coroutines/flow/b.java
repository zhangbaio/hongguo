package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class b<T> extends ChannelFlow<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater f;
    private volatile /* synthetic */ int consumed$volatile;
    private final ReceiveChannel<T> d;
    private final boolean e;

    static {
        Covode.recordClassIndex(659130);
        f = AtomicIntegerFieldUpdater.newUpdater(b.class, "consumed$volatile");
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected String b() {
        return "channel=" + this.d;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Flow<T> f() {
        return new b(this.d, this.e, null, 0, null, 28, null);
    }

    private final void k() {
        if (this.e) {
            boolean z = true;
            if (f.getAndSet(this, 1) != 0) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel<T> i(CoroutineScope coroutineScope) {
        k();
        if (this.b == -3) {
            return this.d;
        }
        return super.i(coroutineScope);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object d(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        Object e;
        Object coroutine_suspended;
        e = FlowKt__ChannelsKt.e(new kotlinx.coroutines.flow.internal.n(producerScope), this.d, this.e, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (e == coroutine_suspended) {
            return e;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object e;
        Object coroutine_suspended2;
        if (this.b == -3) {
            k();
            e = FlowKt__ChannelsKt.e(flowCollector, this.d, this.e, continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (e == coroutine_suspended2) {
                return e;
            }
            return Unit.INSTANCE;
        }
        Object collect = super.collect(flowCollector, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (collect == coroutine_suspended) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> e(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new b(this.d, this.e, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(ReceiveChannel<? extends T> receiveChannel, boolean z, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.d = receiveChannel;
        this.e = z;
        this.consumed$volatile = 0;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ b(kotlinx.coroutines.channels.ReceiveChannel r7, boolean r8, kotlin.coroutines.CoroutineContext r9, int r10, kotlinx.coroutines.channels.BufferOverflow r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 4
            if (r13 == 0) goto L6
            kotlin.coroutines.EmptyCoroutineContext r9 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
        L6:
            r3 = r9
            r9 = r12 & 8
            if (r9 == 0) goto Le
            r10 = -3
            r4 = -3
            goto Lf
        Le:
            r4 = r10
        Lf:
            r9 = r12 & 16
            if (r9 == 0) goto L15
            kotlinx.coroutines.channels.BufferOverflow r11 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
        L15:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.b.<init>(kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.CoroutineContext, int, kotlinx.coroutines.channels.BufferOverflow, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
