package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final /* synthetic */ class FlowKt__DelayKt {
    static {
        Covode.recordClassIndex(659143);
    }

    public static final <T> Flow<T> b(Flow<? extends T> flow, Function1<? super T, Long> function1) {
        return e(flow, function1);
    }

    public static final <T> Flow<T> i(Flow<? extends T> flow, long j) {
        return j(flow, j);
    }

    public static final <T> Flow<T> c(Flow<? extends T> flow, long j) {
        return FlowKt.debounce(flow, DelayKt.m1069toDelayMillisLRDsOJo(j));
    }

    public static final <T> Flow<T> d(Flow<? extends T> flow, final Function1<? super T, kotlin.time.c> function1) {
        return e(flow, new Function1<T, Long>() { // from class: kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(Object obj) {
                return invoke((FlowKt__DelayKt$debounce$3<T>) obj);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(T t) {
                return Long.valueOf(DelayKt.m1069toDelayMillisLRDsOJo(function1.invoke(t).W()));
            }
        });
    }

    private static final <T> Flow<T> e(Flow<? extends T> flow, Function1<? super T, Long> function1) {
        return FlowCoroutineKt.b(new FlowKt__DelayKt$debounceInternal$1(function1, flow, null));
    }

    public static final ReceiveChannel<Unit> f(CoroutineScope coroutineScope, long j) {
        return ProduceKt.produce$default(coroutineScope, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$1(j, null), 1, null);
    }

    public static final <T> Flow<T> h(Flow<? extends T> flow, long j) {
        return FlowKt.sample(flow, DelayKt.m1069toDelayMillisLRDsOJo(j));
    }

    private static final <T> Flow<T> j(Flow<? extends T> flow, long j) {
        return FlowCoroutineKt.b(new FlowKt__DelayKt$timeoutInternal$1(j, flow, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> a(Flow<? extends T> flow, final long j) {
        boolean z;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (j == 0) {
                return flow;
            }
            return e(flow, new Function1<T, Long>() { // from class: kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Long invoke(T t) {
                    return Long.valueOf(j);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Long invoke(Object obj) {
                    return invoke((FlowKt__DelayKt$debounce$2<T>) obj);
                }
            });
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    public static final <T> Flow<T> g(Flow<? extends T> flow, long j) {
        boolean z;
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return FlowCoroutineKt.b(new FlowKt__DelayKt$sample$2(j, flow, null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }
}
