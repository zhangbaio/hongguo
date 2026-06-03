package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.ResultKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e0 {
    private static final StackTraceElement a;
    private static final String b;
    private static final String c;

    public static final <E extends Throwable> E a(E e) {
        return e;
    }

    static {
        Object obj;
        Object obj2;
        Object obj3 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        Object obj4 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        Covode.recordClassIndex(659263);
        a = new a.a().a();
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m773constructorimpl(l3.a.q("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m776exceptionOrNullimpl(obj) == null) {
            obj4 = obj;
        }
        b = (String) obj4;
        try {
            obj2 = Result.m773constructorimpl(l3.a.q("kotlinx.coroutines.internal.StackTraceRecoveryKt").getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            obj2 = Result.m773constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m776exceptionOrNullimpl(obj2) == null) {
            obj3 = obj2;
        }
        c = (String) obj3;
    }
}
