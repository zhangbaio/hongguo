package kotlinx.coroutines.sync;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.d;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.selects.h;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SemaphoreImpl implements Semaphore {
    private static final /* synthetic */ AtomicReferenceFieldUpdater c;
    private static final /* synthetic */ AtomicLongFieldUpdater d;
    private static final /* synthetic */ AtomicReferenceFieldUpdater e;
    private static final /* synthetic */ AtomicLongFieldUpdater f;
    private static final /* synthetic */ AtomicIntegerFieldUpdater g;
    private volatile /* synthetic */ int _availablePermits$volatile;
    private final int a;
    private final Function1<Throwable, Unit> b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    static {
        Covode.recordClassIndex(659370);
        c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head$volatile");
        d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx$volatile");
        e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail$volatile");
        f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx$volatile");
        g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits$volatile");
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public Object acquire(Continuation<? super Unit> continuation) {
        return c(this, continuation);
    }

    private final int g() {
        int andDecrement;
        do {
            andDecrement = g.getAndDecrement(this);
        } while (andDecrement > this.a);
        return andDecrement;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(g.get(this), 0);
    }

    private final void f() {
        int i;
        do {
            i = g.get(this);
            if (i <= this.a) {
                return;
            }
        } while (!g.compareAndSet(this, i, this.a));
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        do {
            int andIncrement = g.getAndIncrement(this);
            if (andIncrement < this.a) {
                if (andIncrement >= 0) {
                    return;
                }
            } else {
                f();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.a).toString());
            }
        } while (!o());
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
        while (true) {
            int i = g.get(this);
            if (i > this.a) {
                f();
            } else {
                if (i <= 0) {
                    return false;
                }
                if (g.compareAndSet(this, i, i - 1)) {
                    return true;
                }
            }
        }
    }

    private final boolean o() {
        int i;
        Object c2;
        int i2;
        f0 f0Var;
        f0 f0Var2;
        int i3;
        f0 f0Var3;
        f0 f0Var4;
        f0 f0Var5;
        boolean z;
        a aVar = (a) c.get(this);
        long andIncrement = d.getAndIncrement(this);
        i = SemaphoreKt.SEGMENT_SIZE;
        long j = andIncrement / i;
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        do {
            c2 = d.c(aVar, j, semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (d0.c(c2)) {
                break;
            }
            c0 b = d0.b(c2);
            while (true) {
                c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
                if (c0Var.c >= b.c) {
                    break;
                }
                if (!b.t()) {
                    z = false;
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c0Var, b)) {
                    if (c0Var.o()) {
                        c0Var.m();
                    }
                } else if (b.o()) {
                    b.m();
                }
            }
            z = true;
        } while (!z);
        a aVar2 = (a) d0.b(c2);
        aVar2.b();
        if (aVar2.c > j) {
            return false;
        }
        i2 = SemaphoreKt.SEGMENT_SIZE;
        int i4 = (int) (andIncrement % i2);
        f0Var = SemaphoreKt.PERMIT;
        Object andSet = aVar2.u().getAndSet(i4, f0Var);
        if (andSet == null) {
            i3 = SemaphoreKt.MAX_SPIN_CYCLES;
            for (int i5 = 0; i5 < i3; i5++) {
                Object obj = aVar2.u().get(i4);
                f0Var5 = SemaphoreKt.TAKEN;
                if (obj == f0Var5) {
                    return true;
                }
            }
            f0Var3 = SemaphoreKt.PERMIT;
            f0Var4 = SemaphoreKt.BROKEN;
            return !c.a(aVar2.u(), i4, f0Var3, f0Var4);
        }
        f0Var2 = SemaphoreKt.CANCELLED;
        if (andSet == f0Var2) {
            return false;
        }
        return n(andSet);
    }

    protected final void b(CancellableContinuation<? super Unit> cancellableContinuation) {
        while (g() <= 0) {
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (e((f2) cancellableContinuation)) {
                return;
            }
        }
        cancellableContinuation.resume(Unit.INSTANCE, this.b);
    }

    private final Object d(Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl b = n.b(intercepted);
        try {
            if (!e(b)) {
                b(b);
            }
            Object result = b.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended2) {
                return result;
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            b.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    private final boolean n(Object obj) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, this.b);
            if (tryResume != null) {
                cancellableContinuation.completeResume(tryResume);
                return true;
            }
            return false;
        }
        if (obj instanceof h) {
            return ((h) obj).trySelect(this, Unit.INSTANCE);
        }
        throw new IllegalStateException(("unexpected: " + obj).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(f2 f2Var) {
        int i;
        Object c2;
        int i2;
        f0 f0Var;
        f0 f0Var2;
        boolean z;
        a aVar = (a) e.get(this);
        long andIncrement = f.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 semaphoreImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        i = SemaphoreKt.SEGMENT_SIZE;
        long j = andIncrement / i;
        do {
            c2 = d.c(aVar, j, semaphoreImpl$addAcquireToQueue$createNewSegment$1);
            if (d0.c(c2)) {
                break;
            }
            c0 b = d0.b(c2);
            while (true) {
                c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
                if (c0Var.c >= b.c) {
                    break;
                }
                if (!b.t()) {
                    z = false;
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c0Var, b)) {
                    if (c0Var.o()) {
                        c0Var.m();
                    }
                } else if (b.o()) {
                    b.m();
                }
            }
            z = true;
        } while (!z);
        a aVar2 = (a) d0.b(c2);
        i2 = SemaphoreKt.SEGMENT_SIZE;
        int i3 = (int) (andIncrement % i2);
        if (c.a(aVar2.u(), i3, null, f2Var)) {
            f2Var.invokeOnCancellation(aVar2, i3);
            return true;
        }
        f0Var = SemaphoreKt.PERMIT;
        f0Var2 = SemaphoreKt.TAKEN;
        if (c.a(aVar2.u(), i3, f0Var, f0Var2)) {
            if (f2Var instanceof CancellableContinuation) {
                Intrinsics.checkNotNull(f2Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                ((CancellableContinuation) f2Var).resume(Unit.INSTANCE, this.b);
                return true;
            }
            if (f2Var instanceof h) {
                ((h) f2Var).selectInRegistrationPhase(Unit.INSTANCE);
                return true;
            }
            throw new IllegalStateException(("unexpected: " + f2Var).toString());
        }
        return false;
    }

    static /* synthetic */ Object c(SemaphoreImpl semaphoreImpl, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (semaphoreImpl.g() > 0) {
            return Unit.INSTANCE;
        }
        Object d2 = semaphoreImpl.d(continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (d2 == coroutine_suspended) {
            return d2;
        }
        return Unit.INSTANCE;
    }

    protected final void m(h<?> hVar, Object obj) {
        while (g() <= 0) {
            Intrinsics.checkNotNull(hVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (e((f2) hVar)) {
                return;
            }
        }
        hVar.selectInRegistrationPhase(Unit.INSTANCE);
    }

    public SemaphoreImpl(int i, int i2) {
        boolean z;
        this.a = i;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 >= 0 && i2 <= i) {
                a aVar = new a(0L, null, 2);
                this.head$volatile = aVar;
                this.tail$volatile = aVar;
                this._availablePermits$volatile = i - i2;
                this.b = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        SemaphoreImpl.this.release();
                    }
                };
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i).toString());
    }
}
