package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j extends kotlinx.coroutines.flow.internal.c<SharedFlowImpl<?>> {
    public long a = -1;
    public Continuation<? super Unit> b;

    static {
        Covode.recordClassIndex(659165);
    }

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Continuation<Unit>[] b(SharedFlowImpl<?> sharedFlowImpl) {
        long j = this.a;
        this.a = -1L;
        this.b = null;
        return sharedFlowImpl.Q(j);
    }

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(SharedFlowImpl<?> sharedFlowImpl) {
        if (this.a >= 0) {
            return false;
        }
        this.a = sharedFlowImpl.R();
        return true;
    }
}
