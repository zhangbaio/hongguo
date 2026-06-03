package kotlinx.coroutines.reactive;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowSubscription<T> extends kotlinx.coroutines.a<Unit> implements Subscription {
    private static final /* synthetic */ AtomicLongFieldUpdater f;
    private static final /* synthetic */ AtomicReferenceFieldUpdater g;
    private volatile boolean cancellationRequested;
    public final Flow<T> d;
    public final Subscriber<? super T> e;
    private volatile /* synthetic */ Object producer$volatile;
    private volatile /* synthetic */ long requested$volatile;

    static {
        Covode.recordClassIndex(659288);
        f = AtomicLongFieldUpdater.newUpdater(FlowSubscription.class, "requested$volatile");
        g = AtomicReferenceFieldUpdater.newUpdater(FlowSubscription.class, Object.class, "producer$volatile");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater O0() {
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater P0() {
        return f;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public void cancel() {
        this.cancellationRequested = true;
        cancel((CancellationException) null);
    }

    private final Object M0(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object collect = this.d.collect(new a(this), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (collect == coroutine_suspended) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(7:5|6|(1:(3:9|10|11)(2:35|36))(4:37|38|39|(1:41)(1:42))|12|13|14|15))|46|6|(0)(0)|12|13|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
    
        kotlinx.coroutines.z.a(r0.getCoroutineContext(), r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N0(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1 r0 = (kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1 r0 = new kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.reactive.FlowSubscription r0 = (kotlinx.coroutines.reactive.FlowSubscription) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L2d
            goto L46
        L2d:
            r5 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L57
            r0.label = r3     // Catch: java.lang.Throwable -> L57
            java.lang.Object r5 = r4.M0(r0)     // Catch: java.lang.Throwable -> L57
            if (r5 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            org.reactivestreams.Subscriber<? super T> r5 = r0.e     // Catch: java.lang.Throwable -> L4c
            r5.onComplete()     // Catch: java.lang.Throwable -> L4c
            goto L54
        L4c:
            r5 = move-exception
            kotlin.coroutines.CoroutineContext r0 = r0.getCoroutineContext()
            kotlinx.coroutines.z.a(r0, r5)
        L54:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L57:
            r5 = move-exception
            r0 = r4
        L59:
            boolean r1 = r0.cancellationRequested
            if (r1 == 0) goto L69
            boolean r1 = r0.isActive()
            if (r1 != 0) goto L69
            java.util.concurrent.CancellationException r1 = r0.getCancellationException()
            if (r5 == r1) goto L7a
        L69:
            org.reactivestreams.Subscriber<? super T> r1 = r0.e     // Catch: java.lang.Throwable -> L6f
            r1.onError(r5)     // Catch: java.lang.Throwable -> L6f
            goto L7a
        L6f:
            r1 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r5, r1)
            kotlin.coroutines.CoroutineContext r0 = r0.getCoroutineContext()
            kotlinx.coroutines.z.a(r0, r5)
        L7a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.FlowSubscription.N0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void request(long j) {
        long j2;
        long j3;
        Continuation continuation;
        if (j <= 0) {
            return;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            j3 = j2 + j;
            if (j3 <= 0) {
                j3 = Long.MAX_VALUE;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, j3));
        if (j2 <= 0) {
            do {
                continuation = (Continuation) g.getAndSet(this, null);
            } while (continuation == null);
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m773constructorimpl(Unit.INSTANCE));
        }
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ FlowSubscription<T> a;

        a(FlowSubscription<T> flowSubscription) {
            this.a = flowSubscription;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            Object coroutine_suspended2;
            this.a.e.onNext(t);
            if (FlowSubscription.P0().decrementAndGet(this.a) <= 0) {
                FlowSubscription<T> flowSubscription = this.a;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                cancellableContinuationImpl.initCancellability();
                FlowSubscription.O0().set(flowSubscription, cancellableContinuationImpl);
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
            JobKt.ensureActive(this.a.getCoroutineContext());
            return Unit.INSTANCE;
        }
    }
}
