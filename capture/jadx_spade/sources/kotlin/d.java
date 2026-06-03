package kotlin;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class d<T, R> extends c<T, R> implements Continuation<R> {
    private Function3<? super c<?, ?>, Object, ? super Continuation<Object>, ? extends Object> a;
    private Object b;
    private Continuation<Object> c;
    private Object d;

    static {
        Covode.recordClassIndex(658041);
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final R b() {
        Object obj;
        Object obj2;
        Object invoke;
        Object coroutine_suspended;
        while (true) {
            R r = (R) this.d;
            Continuation<Object> continuation = this.c;
            if (continuation == null) {
                ResultKt.throwOnFailure(r);
                return r;
            }
            obj = b.a;
            if (Result.m775equalsimpl0(obj, r)) {
                try {
                    Function3<? super c<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function3 = this.a;
                    Object obj3 = this.b;
                    if (!(function3 instanceof BaseContinuationImpl)) {
                        invoke = IntrinsicsKt__IntrinsicsJvmKt.wrapWithContinuationImpl(function3, this, obj3, continuation);
                    } else {
                        invoke = ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3)).invoke(this, obj3, continuation);
                    }
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (invoke != coroutine_suspended) {
                        continuation.resumeWith(Result.m773constructorimpl(invoke));
                    }
                } catch (Throwable th) {
                    Result.Companion companion = Result.Companion;
                    continuation.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(th)));
                }
            } else {
                obj2 = b.a;
                this.d = obj2;
                continuation.resumeWith(r);
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.c = null;
        this.d = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(Function3<? super c<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> block, T t) {
        super(null);
        Object obj;
        Intrinsics.checkNotNullParameter(block, "block");
        this.a = block;
        this.b = t;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.c = this;
        obj = b.a;
        this.d = obj;
    }

    @Override // kotlin.c
    public Object a(T t, Continuation<? super R> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.c = continuation;
        this.b = t;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == coroutine_suspended2) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }
}
