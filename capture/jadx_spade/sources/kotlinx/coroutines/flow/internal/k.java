package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k implements FlowCollector<Object> {
    public static final k a;

    static {
        Covode.recordClassIndex(659201);
        a = new k();
    }

    private k() {
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
