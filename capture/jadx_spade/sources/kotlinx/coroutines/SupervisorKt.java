package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SupervisorKt {
    static {
        Covode.recordClassIndex(659030);
    }

    public static final CompletableJob SupervisorJob(Job job) {
        return new t1(job);
    }

    public static final <R> Object supervisorScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        Object coroutine_suspended;
        s1 s1Var = new s1(continuation.getContext(), continuation);
        Object b = ym6.b.b(s1Var, s1Var, function2);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (b == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return b;
    }

    public static /* synthetic */ CompletableJob SupervisorJob$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return SupervisorJob(job);
    }

    /* renamed from: SupervisorJob$default, reason: collision with other method in class */
    public static /* synthetic */ Job m1074SupervisorJob$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return SupervisorJob(job);
    }
}
