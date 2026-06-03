package kotlinx.coroutines.flow;

import androidx.compose.animation.core.g1;
import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.internal.f0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class m extends kotlinx.coroutines.flow.internal.c<StateFlowImpl<?>> {
    private final AtomicReference<Object> a = new AtomicReference<>(null);

    static {
        Covode.recordClassIndex(659177);
    }

    public final boolean h() {
        f0 f0Var;
        f0 f0Var2;
        AtomicReference<Object> atomicReference = this.a;
        f0Var = StateFlowKt.NONE;
        Object andSet = atomicReference.getAndSet(f0Var);
        Intrinsics.checkNotNull(andSet);
        f0Var2 = StateFlowKt.PENDING;
        if (andSet == f0Var2) {
            return true;
        }
        return false;
    }

    public final void g() {
        f0 f0Var;
        f0 f0Var2;
        f0 f0Var3;
        f0 f0Var4;
        AtomicReference<Object> atomicReference = this.a;
        while (true) {
            Object a = kotlinx.coroutines.internal.f.a(atomicReference);
            if (a == null) {
                return;
            }
            f0Var = StateFlowKt.PENDING;
            if (a == f0Var) {
                return;
            }
            f0Var2 = StateFlowKt.NONE;
            if (a == f0Var2) {
                AtomicReference<Object> atomicReference2 = this.a;
                f0Var3 = StateFlowKt.PENDING;
                if (g1.a(atomicReference2, a, f0Var3)) {
                    return;
                }
            } else {
                AtomicReference<Object> atomicReference3 = this.a;
                f0Var4 = StateFlowKt.NONE;
                if (g1.a(atomicReference3, a, f0Var4)) {
                    Result.Companion companion = Result.Companion;
                    ((CancellableContinuationImpl) a).resumeWith(Result.m773constructorimpl(Unit.INSTANCE));
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Continuation<Unit>[] b(StateFlowImpl<?> stateFlowImpl) {
        kotlinx.coroutines.internal.f.b(this.a, null);
        return kotlinx.coroutines.flow.internal.b.a;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(StateFlowImpl<?> stateFlowImpl) {
        f0 f0Var;
        if (kotlinx.coroutines.internal.f.a(this.a) != null) {
            return false;
        }
        AtomicReference<Object> atomicReference = this.a;
        f0Var = StateFlowKt.NONE;
        kotlinx.coroutines.internal.f.b(atomicReference, f0Var);
        return true;
    }

    public final Object e(Continuation<? super Unit> continuation) {
        Continuation intercepted;
        f0 f0Var;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AtomicReference atomicReference = this.a;
        f0Var = StateFlowKt.NONE;
        if (!g1.a(atomicReference, f0Var, cancellableContinuationImpl)) {
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m773constructorimpl(Unit.INSTANCE));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended2) {
            return result;
        }
        return Unit.INSTANCE;
    }
}
