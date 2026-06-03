package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b0 {
    static {
        Covode.recordClassIndex(658946);
    }

    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(Continuation<?> continuation) {
        Object m773constructorimpl;
        if (continuation instanceof kotlinx.coroutines.internal.j) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(continuation + '@' + b(continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m776exceptionOrNullimpl(m773constructorimpl) != null) {
            m773constructorimpl = continuation.getClass().getName() + '@' + b(continuation);
        }
        return (String) m773constructorimpl;
    }
}
