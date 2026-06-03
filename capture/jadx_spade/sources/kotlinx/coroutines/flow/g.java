package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class g<T> implements SharedFlow<T>, a<T>, kotlinx.coroutines.flow.internal.i<T> {
    private final Job a;
    private final /* synthetic */ SharedFlow<T> b;

    static {
        Covode.recordClassIndex(659157);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return this.b.collect(flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        return this.b.getReplayCache();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(SharedFlow<? extends T> sharedFlow, Job job) {
        this.a = job;
        this.b = sharedFlow;
    }

    @Override // kotlinx.coroutines.flow.internal.i
    public Flow<T> a(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, coroutineContext, i, bufferOverflow);
    }
}
