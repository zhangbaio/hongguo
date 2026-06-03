package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$2<R> implements Flow<R> {
    final /* synthetic */ Flow[] a;
    final /* synthetic */ Function2 b;

    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ZipKt$combine$$inlined$unsafeFlow$2.this.collect(null, this);
        }
    }

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$2(Flow[] flowArr, Function2 function2) {
        this.a = flowArr;
        this.b = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Flow[] flowArr = this.a;
        Intrinsics.needClassReification();
        final Flow[] flowArr2 = this.a;
        Function0<T[]> function0 = new Function0<T[]>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$5$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T[] invoke() {
                int length = flowArr2.length;
                Intrinsics.reifiedOperationMarker(0, "T?");
                return (T[]) new Object[length];
            }
        };
        Intrinsics.needClassReification();
        Object a = CombineKt.a(flowCollector, flowArr, function0, new FlowKt__ZipKt$combine$5$2(this.b, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (a == coroutine_suspended) {
            return a;
        }
        return Unit.INSTANCE;
    }
}
