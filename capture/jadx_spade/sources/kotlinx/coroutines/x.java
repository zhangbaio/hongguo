package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class x {
    static {
        Covode.recordClassIndex(658925);
    }

    public static final <T> Object c(Object obj, CancellableContinuation<?> cancellableContinuation) {
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(obj);
        if (m776exceptionOrNullimpl != null) {
            return new v(m776exceptionOrNullimpl, false, 2, null);
        }
        return obj;
    }

    public static final <T> Object a(Object obj, Continuation<? super T> continuation) {
        if (obj instanceof v) {
            Result.Companion companion = Result.Companion;
            return Result.m773constructorimpl(ResultKt.createFailure(((v) obj).a));
        }
        return Result.m773constructorimpl(obj);
    }

    public static final <T> Object b(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(obj);
        if (m776exceptionOrNullimpl == null) {
            if (function1 != null) {
                return new w(obj, function1);
            }
            return obj;
        }
        return new v(m776exceptionOrNullimpl, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return b(obj, function1);
    }
}
