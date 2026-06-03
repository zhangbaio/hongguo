package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.f0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class q0 extends r0 implements f0 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater d;
    private static final /* synthetic */ AtomicReferenceFieldUpdater e;
    private static final /* synthetic */ AtomicIntegerFieldUpdater f;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    static {
        Covode.recordClassIndex(658970);
        d = AtomicReferenceFieldUpdater.newUpdater(q0.class, Object.class, "_queue$volatile");
        e = AtomicReferenceFieldUpdater.newUpdater(q0.class, Object.class, "_delayed$volatile");
        f = AtomicIntegerFieldUpdater.newUpdater(q0.class, "_isCompleted$volatile");
    }

    public static abstract class c implements Runnable, Comparable<c>, DisposableHandle, kotlinx.coroutines.internal.l0 {
        private volatile Object _heap;
        public long a;
        private int b = -1;

        static {
            Covode.recordClassIndex(658973);
        }

        @Override // kotlinx.coroutines.internal.l0
        public int getIndex() {
            return this.b;
        }

        @Override // kotlinx.coroutines.internal.l0
        public kotlinx.coroutines.internal.k0<?> c() {
            Object obj = this._heap;
            if (obj instanceof kotlinx.coroutines.internal.k0) {
                return (kotlinx.coroutines.internal.k0) obj;
            }
            return null;
        }

        public String toString() {
            return "Delayed[nanos=" + this.a + ']';
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            kotlinx.coroutines.internal.f0 f0Var;
            d dVar;
            kotlinx.coroutines.internal.f0 f0Var2;
            synchronized (this) {
                Object obj = this._heap;
                f0Var = t0.a;
                if (obj == f0Var) {
                    return;
                }
                if (obj instanceof d) {
                    dVar = (d) obj;
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    dVar.h(this);
                }
                f0Var2 = t0.a;
                this._heap = f0Var2;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // kotlinx.coroutines.internal.l0
        public void setIndex(int i) {
            this.b = i;
        }

        public c(long j) {
            this.a = j;
        }

        public final boolean f(long j) {
            if (j - this.a >= 0) {
                return true;
            }
            return false;
        }

        @Override // kotlinx.coroutines.internal.l0
        public void a(kotlinx.coroutines.internal.k0<?> k0Var) {
            kotlinx.coroutines.internal.f0 f0Var;
            boolean z;
            Object obj = this._heap;
            f0Var = t0.a;
            if (obj != f0Var) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this._heap = k0Var;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // java.lang.Comparable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            long j = this.a - cVar.a;
            if (j > 0) {
                return 1;
            }
            if (j < 0) {
                return -1;
            }
            return 0;
        }

        public final int e(long j, d dVar, q0 q0Var) {
            kotlinx.coroutines.internal.f0 f0Var;
            synchronized (this) {
                Object obj = this._heap;
                f0Var = t0.a;
                if (obj == f0Var) {
                    return 2;
                }
                synchronized (dVar) {
                    c b = dVar.b();
                    if (q0Var.isCompleted()) {
                        return 1;
                    }
                    if (b == null) {
                        dVar.c = j;
                    } else {
                        long j2 = b.a;
                        if (j2 - j < 0) {
                            j = j2;
                        }
                        if (j - dVar.c > 0) {
                            dVar.c = j;
                        }
                    }
                    long j3 = this.a;
                    long j4 = dVar.c;
                    if (j3 - j4 < 0) {
                        this.a = j4;
                    }
                    dVar.a(this);
                    return 0;
                }
            }
        }
    }

    private static final class b extends c {
        private final Runnable c;

        static {
            Covode.recordClassIndex(658972);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.run();
        }

        @Override // kotlinx.coroutines.q0.c
        public String toString() {
            return super.toString() + this.c;
        }

        public b(long j, Runnable runnable) {
            super(j);
            this.c = runnable;
        }
    }

    private final class a extends c {
        private final CancellableContinuation<Unit> c;

        static {
            Covode.recordClassIndex(658971);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.resumeUndispatched(q0.this, Unit.INSTANCE);
        }

        @Override // kotlinx.coroutines.q0.c
        public String toString() {
            return super.toString() + this.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j);
            this.c = cancellableContinuation;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCompleted() {
        if (f.get(this) != 0) {
            return true;
        }
        return false;
    }

    protected final void Y() {
        d.set(this, null);
        e.set(this, null);
    }

    @Override // kotlinx.coroutines.p0
    public void shutdown() {
        v1.a.c();
        c0(true);
        P();
        while (G() <= 0) {
        }
        X();
    }

    private final void X() {
        c j;
        kotlinx.coroutines.c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) e.get(this);
            if (dVar != null && (j = dVar.j()) != null) {
                L(nanoTime, j);
            } else {
                return;
            }
        }
    }

    protected boolean W() {
        kotlinx.coroutines.internal.f0 f0Var;
        if (!F()) {
            return false;
        }
        d dVar = (d) e.get(this);
        if (dVar != null && !dVar.e()) {
            return false;
        }
        Object obj = d.get(this);
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.t) {
                return ((kotlinx.coroutines.internal.t) obj).j();
            }
            f0Var = t0.b;
            if (obj != f0Var) {
                return false;
            }
        }
        return true;
    }

    private final void P() {
        kotlinx.coroutines.internal.f0 f0Var;
        kotlinx.coroutines.internal.f0 f0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = d;
                f0Var = t0.b;
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, (Object) null, f0Var)) {
                    return;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.internal.t) {
                    ((kotlinx.coroutines.internal.t) obj).d();
                    return;
                }
                f0Var2 = t0.b;
                if (obj == f0Var2) {
                    return;
                }
                kotlinx.coroutines.internal.t tVar = new kotlinx.coroutines.internal.t(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                tVar.a((Runnable) obj);
                if (androidx.concurrent.futures.a.a(d, this, obj, tVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable Q() {
        kotlinx.coroutines.internal.f0 f0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.t) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.t tVar = (kotlinx.coroutines.internal.t) obj;
                Object m = tVar.m();
                if (m != kotlinx.coroutines.internal.t.h) {
                    return (Runnable) m;
                }
                androidx.concurrent.futures.a.a(d, this, obj, tVar.l());
            } else {
                f0Var = t0.b;
                if (obj == f0Var) {
                    return null;
                }
                if (androidx.concurrent.futures.a.a(d, this, obj, (Object) null)) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.p0
    protected long B() {
        c f2;
        long coerceAtLeast;
        kotlinx.coroutines.internal.f0 f0Var;
        if (super.B() == 0) {
            return 0L;
        }
        Object obj = d.get(this);
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.t) {
                if (!((kotlinx.coroutines.internal.t) obj).j()) {
                    return 0L;
                }
            } else {
                f0Var = t0.b;
                if (obj != f0Var) {
                    return 0L;
                }
                return Long.MAX_VALUE;
            }
        }
        d dVar = (d) e.get(this);
        if (dVar == null || (f2 = dVar.f()) == null) {
            return Long.MAX_VALUE;
        }
        long j = f2.a;
        kotlinx.coroutines.c.a();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j - System.nanoTime(), 0L);
        return coerceAtLeast;
    }

    @Override // kotlinx.coroutines.p0
    public long G() {
        c cVar;
        boolean z;
        if (H()) {
            return 0L;
        }
        d dVar = (d) e.get(this);
        if (dVar != null && !dVar.e()) {
            kotlinx.coroutines.c.a();
            long nanoTime = System.nanoTime();
            do {
                synchronized (dVar) {
                    c b2 = dVar.b();
                    cVar = null;
                    if (b2 != null) {
                        c cVar2 = b2;
                        if (cVar2.f(nanoTime)) {
                            z = S(cVar2);
                        } else {
                            z = false;
                        }
                        if (z) {
                            cVar = dVar.i(0);
                        }
                    }
                }
            } while (cVar != null);
        }
        Runnable Q = Q();
        if (Q != null) {
            Q.run();
            return 0L;
        }
        return B();
    }

    public static final class d extends kotlinx.coroutines.internal.k0<c> {
        public long c;

        static {
            Covode.recordClassIndex(658974);
        }

        public d(long j) {
            this.c = j;
        }
    }

    private final void c0(boolean z) {
        f.set(this, z ? 1 : 0);
    }

    public void R(Runnable runnable) {
        if (S(runnable)) {
            N();
        } else {
            c0.g.R(runnable);
        }
    }

    private final boolean d0(c cVar) {
        c cVar2;
        d dVar = (d) e.get(this);
        if (dVar != null) {
            cVar2 = dVar.f();
        } else {
            cVar2 = null;
        }
        if (cVar2 == cVar) {
            return true;
        }
        return false;
    }

    private final boolean S(Runnable runnable) {
        kotlinx.coroutines.internal.f0 f0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(d, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.t) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.t tVar = (kotlinx.coroutines.internal.t) obj;
                int a2 = tVar.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 != 1) {
                    if (a2 == 2) {
                        return false;
                    }
                } else {
                    androidx.concurrent.futures.a.a(d, this, obj, tVar.l());
                }
            } else {
                f0Var = t0.b;
                if (obj == f0Var) {
                    return false;
                }
                kotlinx.coroutines.internal.t tVar2 = new kotlinx.coroutines.internal.t(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                tVar2.a((Runnable) obj);
                tVar2.a(runnable);
                if (androidx.concurrent.futures.a.a(d, this, obj, tVar2)) {
                    return true;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        R(runnable);
    }

    private final int a0(long j, c cVar) {
        if (isCompleted()) {
            return 1;
        }
        d dVar = (d) e.get(this);
        if (dVar == null) {
            androidx.concurrent.futures.a.a(e, this, (Object) null, new d(j));
            Object obj = e.get(this);
            Intrinsics.checkNotNull(obj);
            dVar = (d) obj;
        }
        return cVar.e(j, dVar, this);
    }

    public final void Z(long j, c cVar) {
        int a0 = a0(j, cVar);
        if (a0 != 0) {
            if (a0 != 1) {
                if (a0 != 2) {
                    throw new IllegalStateException("unexpected result".toString());
                }
                return;
            } else {
                L(j, cVar);
                return;
            }
        }
        if (d0(cVar)) {
            N();
        }
    }

    protected final DisposableHandle b0(long j, Runnable runnable) {
        long d2 = t0.d(j);
        if (d2 < 4611686018427387903L) {
            kotlinx.coroutines.c.a();
            long nanoTime = System.nanoTime();
            b bVar = new b(d2 + nanoTime, runnable);
            Z(nanoTime, bVar);
            return bVar;
        }
        return l1.a;
    }

    @Override // kotlinx.coroutines.f0
    public void scheduleResumeAfterDelay(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        long d2 = t0.d(j);
        if (d2 < 4611686018427387903L) {
            kotlinx.coroutines.c.a();
            long nanoTime = System.nanoTime();
            a aVar = new a(d2 + nanoTime, cancellableContinuation);
            Z(nanoTime, aVar);
            n.a(cancellableContinuation, aVar);
        }
    }

    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return f0.a.b(this, j, runnable, coroutineContext);
    }
}
