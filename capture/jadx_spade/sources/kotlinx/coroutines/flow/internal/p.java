package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class p extends SharedFlowImpl<Integer> implements StateFlow<Integer> {
    static {
        Covode.recordClassIndex(659208);
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            valueOf = Integer.valueOf(F().intValue());
        }
        return valueOf;
    }

    public p(int i) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        tryEmit(Integer.valueOf(i));
    }

    public final boolean T(int i) {
        boolean tryEmit;
        synchronized (this) {
            tryEmit = tryEmit(Integer.valueOf(F().intValue() + i));
        }
        return tryEmit;
    }
}
