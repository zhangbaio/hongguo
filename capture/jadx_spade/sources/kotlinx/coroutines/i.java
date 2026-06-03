package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final /* synthetic */ class i {
    static {
        Covode.recordClassIndex(658897);
    }

    public static final <T> Object c(CoroutineDispatcher coroutineDispatcher, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return BuildersKt.withContext(coroutineDispatcher, function2, continuation);
    }

    public static final <T> Object f(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object J0;
        Object coroutine_suspended;
        CoroutineContext context = continuation.getContext();
        CoroutineContext d = CoroutineContextKt.d(context, coroutineContext);
        JobKt.ensureActive(d);
        if (d == context) {
            kotlinx.coroutines.internal.b0 b0Var = new kotlinx.coroutines.internal.b0(d, continuation);
            J0 = ym6.b.b(b0Var, b0Var, function2);
        } else {
            ContinuationInterceptor.b bVar = ContinuationInterceptor.Key;
            if (Intrinsics.areEqual(d.get(bVar), context.get(bVar))) {
                d2 d2Var = new d2(d, continuation);
                CoroutineContext context2 = d2Var.getContext();
                Object c = ThreadContextKt.c(context2, null);
                try {
                    Object b = ym6.b.b(d2Var, d2Var, function2);
                    ThreadContextKt.a(context2, c);
                    J0 = b;
                } catch (Throwable th) {
                    ThreadContextKt.a(context2, c);
                    throw th;
                }
            } else {
                h0 h0Var = new h0(d, continuation);
                ym6.a.d(function2, h0Var, h0Var, null, 4, null);
                J0 = h0Var.J0();
            }
        }
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (J0 == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return J0;
    }

    public static final <T> Deferred<T> a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        e0 e0Var;
        CoroutineContext e = CoroutineContextKt.e(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            e0Var = new h1(e, function2);
        } else {
            e0Var = new e0(e, true);
        }
        ((a) e0Var).I0(coroutineStart, e0Var, function2);
        return (Deferred<T>) e0Var;
    }

    public static final Job d(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        a r1Var;
        CoroutineContext e = CoroutineContextKt.e(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            r1Var = new i1(e, function2);
        } else {
            r1Var = new r1(e, true);
        }
        r1Var.I0(coroutineStart, r1Var, function2);
        return r1Var;
    }

    public static /* synthetic */ Deferred b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.async(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static /* synthetic */ Job e(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.launch(coroutineScope, coroutineContext, coroutineStart, function2);
    }
}
