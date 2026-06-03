package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CombineKt {
    static {
        Covode.recordClassIndex(659193);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class a<R> implements Flow<R> {
        final /* synthetic */ Flow a;
        final /* synthetic */ Flow b;
        final /* synthetic */ Function3 c;

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            Object coroutineScope = CoroutineScopeKt.coroutineScope(new CombineKt$zipImpl$1$1(this.a, this.b, flowCollector, this.c, null), continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (coroutineScope == coroutine_suspended) {
                return coroutineScope;
            }
            return Unit.INSTANCE;
        }

        public a(Flow flow, Flow flow2, Function3 function3) {
            this.a = flow;
            this.b = flow2;
            this.c = function3;
        }
    }

    public static final <T1, T2, R> Flow<R> b(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return new a(flow2, flow, function3);
    }

    public static final <R, T> Object a(FlowCollector<? super R> flowCollector, Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object a2 = FlowCoroutineKt.a(new CombineKt$combineInternal$2(flowArr, function0, function3, flowCollector, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (a2 == coroutine_suspended) {
            return a2;
        }
        return Unit.INSTANCE;
    }
}
