package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class UndispatchedContextCollector<T> implements FlowCollector<T> {
    private final CoroutineContext a;
    private final Object b;
    private final Function2<T, Continuation<? super Unit>, Object> c;

    static {
        Covode.recordClassIndex(659209);
    }

    public UndispatchedContextCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        this.a = coroutineContext;
        this.b = ThreadContextKt.b(coroutineContext);
        this.c = new UndispatchedContextCollector$emitRef$1(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object c = d.c(this.a, t, this.b, this.c, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (c == coroutine_suspended) {
            return c;
        }
        return Unit.INSTANCE;
    }
}
