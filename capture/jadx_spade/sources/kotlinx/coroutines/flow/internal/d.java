package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    static {
        Covode.recordClassIndex(659186);
    }

    public static final <T> ChannelFlow<T> b(Flow<? extends T> flow) {
        ChannelFlow<T> channelFlow;
        if (flow instanceof ChannelFlow) {
            channelFlow = (ChannelFlow) flow;
        } else {
            channelFlow = null;
        }
        if (channelFlow == null) {
            return new e(flow, null, 0, null, 14, null);
        }
        return channelFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> FlowCollector<T> e(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        boolean z;
        if (flowCollector instanceof n) {
            z = true;
        } else {
            z = flowCollector instanceof k;
        }
        if (!z) {
            return new UndispatchedContextCollector(flowCollector, coroutineContext);
        }
        return flowCollector;
    }

    public static final <T, V> Object c(CoroutineContext coroutineContext, V v, Object obj, Function2<? super V, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object invoke;
        Object coroutine_suspended;
        Object c = ThreadContextKt.c(coroutineContext, obj);
        try {
            o oVar = new o(continuation, coroutineContext);
            if (!(function2 instanceof BaseContinuationImpl)) {
                invoke = IntrinsicsKt__IntrinsicsJvmKt.wrapWithContinuationImpl(function2, v, oVar);
            } else {
                invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(v, oVar);
            }
            ThreadContextKt.a(coroutineContext, c);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (invoke == coroutine_suspended) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return invoke;
        } catch (Throwable th) {
            ThreadContextKt.a(coroutineContext, c);
            throw th;
        }
    }

    public static /* synthetic */ Object d(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation, int i, Object obj3) {
        if ((i & 4) != 0) {
            obj2 = ThreadContextKt.b(coroutineContext);
        }
        return c(coroutineContext, obj, obj2, function2, continuation);
    }
}
