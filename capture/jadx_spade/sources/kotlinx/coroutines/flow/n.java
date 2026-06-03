package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n implements FlowCollector<Object> {
    public final Throwable a;

    static {
        Covode.recordClassIndex(659180);
    }

    public n(Throwable th) {
        this.a = th;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, Continuation<? super Unit> continuation) {
        throw this.a;
    }
}
