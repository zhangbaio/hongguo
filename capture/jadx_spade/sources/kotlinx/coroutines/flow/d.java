package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class d implements Flow {
    public static final d a;

    static {
        Covode.recordClassIndex(659133);
        a = new d();
    }

    private d() {
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<?> flowCollector, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
