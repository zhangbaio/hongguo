package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class YieldKt {
    static {
        Covode.recordClassIndex(659048);
    }

    public static final Object yield(Continuation<? super Unit> continuation) {
        Continuation intercepted;
        kotlinx.coroutines.internal.j jVar;
        Object obj;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        CoroutineContext context = continuation.getContext();
        JobKt.ensureActive(context);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        if (intercepted instanceof kotlinx.coroutines.internal.j) {
            jVar = (kotlinx.coroutines.internal.j) intercepted;
        } else {
            jVar = null;
        }
        if (jVar == null) {
            obj = Unit.INSTANCE;
        } else {
            if (jVar.a.isDispatchNeeded(context)) {
                jVar.c(context, Unit.INSTANCE);
            } else {
                g2 g2Var = new g2();
                CoroutineContext plus = context.plus(g2Var);
                Unit unit = Unit.INSTANCE;
                jVar.c(plus, unit);
                if (g2Var.a) {
                    if (kotlinx.coroutines.internal.k.d(jVar)) {
                        obj = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    } else {
                        obj = unit;
                    }
                }
            }
            obj = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (obj == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (obj == coroutine_suspended2) {
            return obj;
        }
        return Unit.INSTANCE;
    }
}
