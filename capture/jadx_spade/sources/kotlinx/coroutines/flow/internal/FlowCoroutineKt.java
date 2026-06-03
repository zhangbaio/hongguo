package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowCoroutineKt {
    static {
        Covode.recordClassIndex(659196);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class a<R> implements Flow<R> {
        final /* synthetic */ Function3 a;

        public a(Function3 function3) {
            this.a = function3;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            Object a = FlowCoroutineKt.a(new FlowCoroutineKt$scopedFlow$1$1(this.a, flowCollector, null), continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (a == coroutine_suspended) {
                return a;
            }
            return Unit.INSTANCE;
        }
    }

    public static final <R> Flow<R> b(Function3<? super CoroutineScope, ? super FlowCollector<? super R>, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new a(function3);
    }

    public static final <R> Object a(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        Object coroutine_suspended;
        g gVar = new g(continuation.getContext(), continuation);
        Object b = ym6.b.b(gVar, gVar, function2);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (b == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return b;
    }
}
