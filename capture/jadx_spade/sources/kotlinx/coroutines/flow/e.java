package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.i;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final /* synthetic */ class e {
    static {
        Covode.recordClassIndex(659141);
    }

    public static final <T> Flow<T> g(Flow<? extends T> flow) {
        return d(flow, -1, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> e(Flow<? extends T> flow) {
        if (!(flow instanceof a)) {
            return new CancellableFlowImpl(flow);
        }
        return flow;
    }

    private static final void f(CoroutineContext coroutineContext) {
        boolean z;
        if (coroutineContext.get(Job.Key) == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
    }

    public static final /* synthetic */ Flow a(Flow flow, int i) {
        return d(flow, i, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> h(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        f(coroutineContext);
        if (!Intrinsics.areEqual(coroutineContext, EmptyCoroutineContext.INSTANCE)) {
            if (flow instanceof kotlinx.coroutines.flow.internal.i) {
                return i.a.a((kotlinx.coroutines.flow.internal.i) flow, coroutineContext, 0, null, 6, null);
            }
            return new kotlinx.coroutines.flow.internal.e(flow, coroutineContext, 0, null, 12, null);
        }
        return flow;
    }

    public static final <T> Flow<T> b(Flow<? extends T> flow, int i, BufferOverflow bufferOverflow) {
        boolean z;
        int i2;
        BufferOverflow bufferOverflow2;
        boolean z2 = true;
        if (i < 0 && i != -2 && i != -1) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (i == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
                z2 = false;
            }
            if (z2) {
                if (i == -1) {
                    bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                    i2 = 0;
                } else {
                    i2 = i;
                    bufferOverflow2 = bufferOverflow;
                }
                if (flow instanceof kotlinx.coroutines.flow.internal.i) {
                    return i.a.a((kotlinx.coroutines.flow.internal.i) flow, null, i2, bufferOverflow2, 1, null);
                }
                return new kotlinx.coroutines.flow.internal.e(flow, null, i2, bufferOverflow2, 2, null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i).toString());
    }

    public static /* synthetic */ Flow c(Flow flow, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        return a(flow, i);
    }

    public static /* synthetic */ Flow d(Flow flow, int i, BufferOverflow bufferOverflow, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return FlowKt.buffer(flow, i, bufferOverflow);
    }
}
