package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {
    private final Flow<Flow<T>> d;
    private final int e;

    static {
        Covode.recordClassIndex(659187);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected String b() {
        return "concurrency=" + this.e;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel<T> i(CoroutineScope coroutineScope) {
        return ProduceKt.produce(coroutineScope, this.a, this.b, g());
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object d(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Semaphore Semaphore$default = SemaphoreKt.Semaphore$default(this.e, 0, 2, null);
        n nVar = new n(producerScope);
        Object collect = this.d.collect(new ChannelFlowMerge$collectTo$2((Job) continuation.getContext().get(Job.Key), Semaphore$default, producerScope, nVar), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (collect == coroutine_suspended) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> e(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new ChannelFlowMerge(this.d, this.e, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge(Flow<? extends Flow<? extends T>> flow, int i, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.d = flow;
        this.e = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ChannelFlowMerge(kotlinx.coroutines.flow.Flow r7, int r8, kotlin.coroutines.CoroutineContext r9, int r10, kotlinx.coroutines.channels.BufferOverflow r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 4
            if (r13 == 0) goto L6
            kotlin.coroutines.EmptyCoroutineContext r9 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
        L6:
            r3 = r9
            r9 = r12 & 8
            if (r9 == 0) goto Le
            r10 = -2
            r4 = -2
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowMerge.<init>(kotlinx.coroutines.flow.Flow, int, kotlin.coroutines.CoroutineContext, int, kotlinx.coroutines.channels.BufferOverflow, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
