package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class e<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b;
    private final Deferred<T>[] a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    static {
        Covode.recordClassIndex(658889);
        b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount$volatile");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicIntegerFieldUpdater d() {
        return b;
    }

    private final class a extends f1 {
        private static final /* synthetic */ AtomicReferenceFieldUpdater h;
        private volatile /* synthetic */ Object _disposer$volatile;
        private final CancellableContinuation<List<? extends T>> e;
        public DisposableHandle f;

        static {
            Covode.recordClassIndex(658890);
            h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer$volatile");
        }

        public final e<T>.b u() {
            return (b) h.get(this);
        }

        public final DisposableHandle v() {
            DisposableHandle disposableHandle = this.f;
            if (disposableHandle != null) {
                return disposableHandle;
            }
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            return null;
        }

        public final void x(e<T>.b bVar) {
            h.set(this, bVar);
        }

        @Override // kotlinx.coroutines.z0
        public void invoke(Throwable th) {
            if (th != null) {
                Object tryResumeWithException = this.e.tryResumeWithException(th);
                if (tryResumeWithException != null) {
                    this.e.completeResume(tryResumeWithException);
                    e<T>.b u = u();
                    if (u != null) {
                        u.a();
                        return;
                    }
                    return;
                }
                return;
            }
            if (e.d().decrementAndGet(e.this) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.e;
                Deferred[] deferredArr = ((e) e.this).a;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred deferred : deferredArr) {
                    arrayList.add(deferred.getCompleted());
                }
                cancellableContinuation.resumeWith(Result.m773constructorimpl(arrayList));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(CancellableContinuation<? super List<? extends T>> cancellableContinuation) {
            this.e = cancellableContinuation;
        }
    }

    private final class b implements l {
        private final e<T>.a[] a;

        static {
            Covode.recordClassIndex(658891);
        }

        public final void a() {
            for (e<T>.a aVar : this.a) {
                aVar.v().dispose();
            }
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.a + ']';
        }

        @Override // kotlinx.coroutines.l
        public void invoke(Throwable th) {
            a();
        }

        public b(e<T>.a[] aVarArr) {
            this.a = aVarArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Deferred<? extends T>[] deferredArr) {
        this.a = deferredArr;
        this.notCompletedCount$volatile = deferredArr.length;
    }

    public final Object c(Continuation<? super List<? extends T>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        int length = this.a.length;
        a[] aVarArr = new a[length];
        for (int i = 0; i < length; i++) {
            Deferred deferred = this.a[i];
            deferred.start();
            a aVar = new a(cancellableContinuationImpl);
            aVar.f = JobKt__JobKt.B(deferred, false, false, aVar, 3, null);
            Unit unit = Unit.INSTANCE;
            aVarArr[i] = aVar;
        }
        e<T>.b bVar = new b(aVarArr);
        for (int i2 = 0; i2 < length; i2++) {
            aVarArr[i2].x(bVar);
        }
        if (cancellableContinuationImpl.isCompleted()) {
            bVar.a();
        } else {
            n.c(cancellableContinuationImpl, bVar);
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
