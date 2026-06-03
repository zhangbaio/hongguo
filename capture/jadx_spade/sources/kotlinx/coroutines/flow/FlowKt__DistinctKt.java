package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final /* synthetic */ class FlowKt__DistinctKt {
    private static final Function1<Object, Object> a;
    private static final Function2<Object, Object, Boolean> b;

    static {
        Covode.recordClassIndex(659144);
        a = new Function1<Object, Object>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultKeySelector$1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return obj;
            }
        };
        b = new Function2<Object, Object, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultAreEquivalent$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(Object obj, Object obj2) {
                return Boolean.valueOf(Intrinsics.areEqual(obj, obj2));
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> a(Flow<? extends T> flow) {
        if (!(flow instanceof StateFlow)) {
            return d(flow, a, b);
        }
        return flow;
    }

    public static final <T, K> Flow<T> c(Flow<? extends T> flow, Function1<? super T, ? extends K> function1) {
        return d(flow, function1, b);
    }

    public static final <T> Flow<T> b(Flow<? extends T> flow, Function2<? super T, ? super T, Boolean> function2) {
        Function1<Object, Object> function1 = a;
        Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return d(flow, function1, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Flow<T> d(Flow<? extends T> flow, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        if (flow instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) flow;
            if (distinctFlowImpl.b == function1 && distinctFlowImpl.c == function2) {
                return flow;
            }
        }
        return new DistinctFlowImpl(flow, function1, function2);
    }
}
