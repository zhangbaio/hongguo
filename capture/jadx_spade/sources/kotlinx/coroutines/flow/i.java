package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class i<T> extends AbstractFlow<T> {
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> a;

    static {
        Covode.recordClassIndex(659159);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.a = function2;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object b(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object invoke = this.a.invoke(flowCollector, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (invoke == coroutine_suspended) {
            return invoke;
        }
        return Unit.INSTANCE;
    }
}
