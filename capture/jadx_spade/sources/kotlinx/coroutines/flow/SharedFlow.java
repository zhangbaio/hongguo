package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface SharedFlow<T> extends Flow<T> {
    @Override // kotlinx.coroutines.flow.Flow
    Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation);

    List<T> getReplayCache();
}
