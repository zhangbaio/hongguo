package kotlinx.coroutines.sync;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.selects.e;
import kotlinx.coroutines.selects.f;
import kotlinx.coroutines.selects.h;
import kotlinx.coroutines.selects.i;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MutexImpl extends SemaphoreImpl implements Mutex {
    private static final /* synthetic */ AtomicReferenceFieldUpdater i;
    private final Function3<h<?>, Object, Object, Function1<Throwable, Unit>> h;
    private volatile /* synthetic */ Object owner$volatile;

    static {
        Covode.recordClassIndex(659365);
        i = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater r() {
        return i;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public Object lock(Object obj, Continuation<? super Unit> continuation) {
        return u(this, obj, continuation);
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(Object obj) {
        t(this, obj);
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        if (getAvailablePermits() == 0) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public e<Object, Mutex> getOnLock() {
        MutexImpl$onLock$1 mutexImpl$onLock$1 = MutexImpl$onLock$1.INSTANCE;
        Intrinsics.checkNotNull(mutexImpl$onLock$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(mutexImpl$onLock$1, 3);
        MutexImpl$onLock$2 mutexImpl$onLock$2 = MutexImpl$onLock$2.INSTANCE;
        Intrinsics.checkNotNull(mutexImpl$onLock$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new f(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(mutexImpl$onLock$2, 3), this.h);
    }

    public String toString() {
        return "Mutex@" + b0.b(this) + "[isLocked=" + isLocked() + ",owner=" + i.get(this) + ']';
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean holdsLock(Object obj) {
        if (s(obj) == 1) {
            return true;
        }
        return false;
    }

    private final class a<Q> implements i<Q> {
        public final i<Q> a;
        public final Object b;

        static {
            Covode.recordClassIndex(659367);
        }

        @Override // kotlinx.coroutines.selects.h
        public void disposeOnCompletion(DisposableHandle disposableHandle) {
            this.a.disposeOnCompletion(disposableHandle);
        }

        @Override // kotlinx.coroutines.selects.i, kotlinx.coroutines.selects.h
        public CoroutineContext getContext() {
            return this.a.getContext();
        }

        @Override // kotlinx.coroutines.f2
        public void invokeOnCancellation(c0<?> c0Var, int i) {
            this.a.invokeOnCancellation(c0Var, i);
        }

        @Override // kotlinx.coroutines.selects.h
        public void selectInRegistrationPhase(Object obj) {
            MutexImpl.r().set(MutexImpl.this, this.b);
            this.a.selectInRegistrationPhase(obj);
        }

        @Override // kotlinx.coroutines.selects.h
        public boolean trySelect(Object obj, Object obj2) {
            boolean trySelect = this.a.trySelect(obj, obj2);
            MutexImpl mutexImpl = MutexImpl.this;
            if (trySelect) {
                MutexImpl.r().set(mutexImpl, this.b);
            }
            return trySelect;
        }

        public a(i<Q> iVar, Object obj) {
            this.a = iVar;
            this.b = obj;
        }
    }

    public MutexImpl(boolean z) {
        super(1, z ? 1 : 0);
        f0 f0Var;
        if (z) {
            f0Var = null;
        } else {
            f0Var = MutexKt.NO_OWNER;
        }
        this.owner$volatile = f0Var;
        this.h = new Function3<h<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Function1<Throwable, Unit> invoke(h<?> hVar, final Object obj, Object obj2) {
                final MutexImpl mutexImpl = MutexImpl.this;
                return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        MutexImpl.this.unlock(obj);
                    }
                };
            }
        };
    }

    private final int s(Object obj) {
        f0 f0Var;
        while (isLocked()) {
            Object obj2 = i.get(this);
            f0Var = MutexKt.NO_OWNER;
            if (obj2 != f0Var) {
                if (obj2 == obj) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    private final int y(Object obj) {
        while (!tryAcquire()) {
            if (obj == null) {
                return 1;
            }
            int s = s(obj);
            if (s == 1) {
                return 2;
            }
            if (s == 2) {
                return 1;
            }
        }
        i.set(this, obj);
        return 0;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(Object obj) {
        int y = y(obj);
        if (y == 0) {
            return true;
        }
        if (y != 1) {
            if (y != 2) {
                throw new IllegalStateException("unexpected".toString());
            }
            throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
        }
        return false;
    }

    public void p(Object obj) {
        f0 f0Var;
        boolean z;
        f0 f0Var2;
        while (isLocked()) {
            Object obj2 = i.get(this);
            f0Var = MutexKt.NO_OWNER;
            if (obj2 != f0Var) {
                if (obj2 != obj && obj != null) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
                    f0Var2 = MutexKt.NO_OWNER;
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj2, f0Var2)) {
                        release();
                        return;
                    }
                } else {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    private final class CancellableContinuationWithOwner implements CancellableContinuation<Unit>, f2 {
        public final CancellableContinuationImpl<Unit> a;
        public final Object b;

        static {
            Covode.recordClassIndex(659366);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, Unit unit) {
            this.a.resumeUndispatched(coroutineDispatcher, unit);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object tryResume(Unit unit, Object obj) {
            return this.a.tryResume(unit, obj);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean cancel(Throwable th) {
            return this.a.cancel(th);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void completeResume(Object obj) {
            this.a.completeResume(obj);
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.a.getContext();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void initCancellability() {
            this.a.initCancellability();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
            this.a.invokeOnCancellation(function1);
        }

        @Override // kotlinx.coroutines.f2
        public void invokeOnCancellation(c0<?> c0Var, int i) {
            this.a.invokeOnCancellation(c0Var, i);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isActive() {
            return this.a.isActive();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isCancelled() {
            return this.a.isCancelled();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isCompleted() {
            return this.a.isCompleted();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void resumeUndispatchedWithException(CoroutineDispatcher coroutineDispatcher, Throwable th) {
            this.a.resumeUndispatchedWithException(coroutineDispatcher, th);
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            this.a.resumeWith(obj);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public Object tryResumeWithException(Throwable th) {
            return this.a.tryResumeWithException(th);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void resume(Unit unit, Function1<? super Throwable, Unit> function1) {
            MutexImpl.r().set(MutexImpl.this, this.b);
            CancellableContinuationImpl<Unit> cancellableContinuationImpl = this.a;
            final MutexImpl mutexImpl = MutexImpl.this;
            cancellableContinuationImpl.resume(unit, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$resume$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    MutexImpl.this.unlock(this.b);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CancellableContinuationWithOwner(CancellableContinuationImpl<? super Unit> cancellableContinuationImpl, Object obj) {
            this.a = cancellableContinuationImpl;
            this.b = obj;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Object tryResume(Unit unit, Object obj, Function1<? super Throwable, Unit> function1) {
            CancellableContinuationImpl<Unit> cancellableContinuationImpl = this.a;
            final MutexImpl mutexImpl = MutexImpl.this;
            Object tryResume = cancellableContinuationImpl.tryResume(unit, obj, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$tryResume$token$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    MutexImpl.r().set(MutexImpl.this, this.b);
                    MutexImpl.this.unlock(this.b);
                }
            });
            if (tryResume != null) {
                MutexImpl.r().set(MutexImpl.this, this.b);
            }
            return tryResume;
        }
    }

    protected void x(h<?> hVar, Object obj) {
        f0 f0Var;
        if (obj != null && holdsLock(obj)) {
            f0Var = MutexKt.ON_LOCK_ALREADY_LOCKED_BY_OWNER;
            hVar.selectInRegistrationPhase(f0Var);
        } else {
            Intrinsics.checkNotNull(hVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            m(new a((i) hVar, obj), obj);
        }
    }

    @TargetClass("kotlinx.coroutines.sync.MutexImpl")
    @Insert("unlock")
    public static void t(MutexImpl mutexImpl, Object obj) {
        MutexImpl mutexImpl2;
        boolean z;
        if (mutexImpl instanceof Mutex) {
            mutexImpl2 = mutexImpl;
        } else {
            mutexImpl2 = null;
        }
        if (mutexImpl2 != null && !mutexImpl2.isLocked()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            LogWrapper.error("ReadingKmpAop", "This mutex is not locked", new Object[0]);
        } else {
            mutexImpl.p(obj);
        }
    }

    private final Object v(Object obj, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl b = n.b(intercepted);
        try {
            b(new CancellableContinuationWithOwner(b, obj));
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

    protected Object w(Object obj, Object obj2) {
        f0 f0Var;
        f0Var = MutexKt.ON_LOCK_ALREADY_LOCKED_BY_OWNER;
        if (!Intrinsics.areEqual(obj2, f0Var)) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    static /* synthetic */ Object u(MutexImpl mutexImpl, Object obj, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (mutexImpl.tryLock(obj)) {
            return Unit.INSTANCE;
        }
        Object v = mutexImpl.v(obj, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (v == coroutine_suspended) {
            return v;
        }
        return Unit.INSTANCE;
    }
}
