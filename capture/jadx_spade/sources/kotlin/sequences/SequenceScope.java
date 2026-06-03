package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class SequenceScope<T> {
    static {
        Covode.recordClassIndex(658721);
    }

    public abstract Object yield(T t, Continuation<? super Unit> continuation);

    public abstract Object yieldAll(Iterator<? extends T> it2, Continuation<? super Unit> continuation);

    public final Object yieldAll(Sequence<? extends T> sequence, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object yieldAll = yieldAll(sequence.iterator(), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (yieldAll == coroutine_suspended) {
            return yieldAll;
        }
        return Unit.INSTANCE;
    }

    public final Object yieldAll(Iterable<? extends T> iterable, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return Unit.INSTANCE;
        }
        Object yieldAll = yieldAll(iterable.iterator(), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (yieldAll == coroutine_suspended) {
            return yieldAll;
        }
        return Unit.INSTANCE;
    }
}
