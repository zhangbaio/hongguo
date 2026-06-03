package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n<T> implements FlowCollector<T> {
    private final SendChannel<T> a;

    static {
        Covode.recordClassIndex(659206);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(SendChannel<? super T> sendChannel) {
        this.a = sendChannel;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object send = this.a.send(t, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (send == coroutine_suspended) {
            return send;
        }
        return Unit.INSTANCE;
    }
}
