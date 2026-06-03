package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.z0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class JobSupport implements Job, s, n1 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a;
    private static final /* synthetic */ AtomicReferenceFieldUpdater b;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    static {
        Covode.recordClassIndex(659005);
        a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");
        b = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");
    }

    public boolean L() {
        return true;
    }

    public boolean O() {
        return false;
    }

    protected boolean U(Throwable th) {
        return false;
    }

    protected boolean Y() {
        return false;
    }

    protected void l0(Throwable th) {
    }

    protected void m0(Object obj) {
    }

    protected void n0() {
    }

    protected void p(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String y() {
        return "Job was cancelled";
    }

    private static final class c implements x0 {
        private static final /* synthetic */ AtomicIntegerFieldUpdater b;
        private static final /* synthetic */ AtomicReferenceFieldUpdater c;
        private static final /* synthetic */ AtomicReferenceFieldUpdater d;
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;
        private final j1 a;

        static {
            Covode.recordClassIndex(659008);
            b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting$volatile");
            c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause$volatile");
            d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder$volatile");
        }

        @Override // kotlinx.coroutines.x0
        public j1 a() {
            return this.a;
        }

        private final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        private final Object d() {
            return d.get(this);
        }

        public final Throwable e() {
            return (Throwable) c.get(this);
        }

        public final boolean i() {
            if (e() != null) {
                return true;
            }
            return false;
        }

        @Override // kotlinx.coroutines.x0
        public boolean isActive() {
            if (e() == null) {
                return true;
            }
            return false;
        }

        public final boolean j() {
            if (b.get(this) != 0) {
                return true;
            }
            return false;
        }

        public final boolean k() {
            kotlinx.coroutines.internal.f0 f0Var;
            Object d2 = d();
            f0Var = g1.e;
            if (d2 == f0Var) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Finishing[cancelling=" + i() + ", completing=" + j() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + a() + ']';
        }

        private final void n(Object obj) {
            d.set(this, obj);
        }

        public final void m(boolean z) {
            b.set(this, z ? 1 : 0);
        }

        public final void o(Throwable th) {
            c.set(this, th);
        }

        public final void b(Throwable th) {
            Throwable e = e();
            if (e == null) {
                o(th);
                return;
            }
            if (th == e) {
                return;
            }
            Object d2 = d();
            if (d2 == null) {
                n(th);
                return;
            }
            if (d2 instanceof Throwable) {
                if (th == d2) {
                    return;
                }
                ArrayList<Throwable> c2 = c();
                c2.add(d2);
                c2.add(th);
                n(c2);
                return;
            }
            if (d2 instanceof ArrayList) {
                ((ArrayList) d2).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + d2).toString());
        }

        public final List<Throwable> l(Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.f0 f0Var;
            Object d2 = d();
            if (d2 == null) {
                arrayList = c();
            } else if (d2 instanceof Throwable) {
                ArrayList<Throwable> c2 = c();
                c2.add(d2);
                arrayList = c2;
            } else if (d2 instanceof ArrayList) {
                arrayList = (ArrayList) d2;
            } else {
                throw new IllegalStateException(("State is " + d2).toString());
            }
            Throwable e = e();
            if (e != null) {
                arrayList.add(0, e);
            }
            if (th != null && !Intrinsics.areEqual(th, e)) {
                arrayList.add(th);
            }
            f0Var = g1.e;
            n(f0Var);
            return arrayList;
        }

        public c(j1 j1Var, boolean z, Throwable th) {
            this.a = j1Var;
            this._isCompleting$volatile = z ? 1 : 0;
            this._rootCause$volatile = th;
        }
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.Key;
    }

    public String f0() {
        return b0.a(this);
    }

    public final q Q() {
        return (q) b.get(this);
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence<Job> getChildren() {
        return SequencesKt__SequenceBuilderKt.sequence(new JobSupport$children$1(this, null));
    }

    @Override // kotlinx.coroutines.Job
    public Job getParent() {
        q Q = Q();
        if (Q != null) {
            return Q.getParent();
        }
        return null;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(R() instanceof x0);
    }

    private final boolean Z() {
        Object R;
        do {
            R = R();
            if (!(R instanceof x0)) {
                return false;
            }
        } while (u0(R) < 0);
        return true;
    }

    protected final boolean H() {
        Object R = R();
        if ((R instanceof v) && ((v) R).a()) {
            return true;
        }
        return false;
    }

    public final Object R() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof kotlinx.coroutines.internal.y)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.y) obj).a(this);
        }
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object R = R();
        if (!(R instanceof x0)) {
            return I(R);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // kotlinx.coroutines.Job
    public final kotlinx.coroutines.selects.b getOnJoin() {
        JobSupport$onJoin$1 jobSupport$onJoin$1 = JobSupport$onJoin$1.INSTANCE;
        Intrinsics.checkNotNull(jobSupport$onJoin$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.c(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(jobSupport$onJoin$1, 3), null, 4, null);
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object R = R();
        if ((R instanceof x0) && ((x0) R).isActive()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object R = R();
        if (!(R instanceof v) && (!(R instanceof c) || !((c) R).i())) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int u0;
        do {
            u0 = u0(R());
            if (u0 == 0) {
                return false;
            }
        } while (u0 != 1);
        return true;
    }

    public String toString() {
        return y0() + '@' + b0.b(this);
    }

    public final Object F() {
        Object R = R();
        if (!(R instanceof x0)) {
            if (!(R instanceof v)) {
                return g1.h(R);
            }
            throw ((v) R).a;
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    protected final SelectClause1<?> N() {
        JobSupport$onAwaitInternal$1 jobSupport$onAwaitInternal$1 = JobSupport$onAwaitInternal$1.INSTANCE;
        Intrinsics.checkNotNull(jobSupport$onAwaitInternal$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(jobSupport$onAwaitInternal$1, 3);
        JobSupport$onAwaitInternal$2 jobSupport$onAwaitInternal$2 = JobSupport$onAwaitInternal$2.INSTANCE;
        Intrinsics.checkNotNull(jobSupport$onAwaitInternal$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.d(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(jobSupport$onAwaitInternal$2, 3), null, 8, null);
    }

    public final String y0() {
        return f0() + '{' + v0(R()) + '}';
    }

    protected final Throwable G() {
        Object R = R();
        if (R instanceof c) {
            Throwable e2 = ((c) R).e();
            if (e2 == null) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            return e2;
        }
        if (!(R instanceof x0)) {
            if (R instanceof v) {
                return ((v) R).a;
            }
            return null;
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.n1
    public CancellationException n() {
        CancellationException cancellationException;
        Object R = R();
        CancellationException cancellationException2 = null;
        if (R instanceof c) {
            cancellationException = ((c) R).e();
        } else if (R instanceof v) {
            cancellationException = ((v) R).a;
        } else if (!(R instanceof x0)) {
            cancellationException = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + R).toString());
        }
        if (cancellationException instanceof CancellationException) {
            cancellationException2 = cancellationException;
        }
        if (cancellationException2 == null) {
            return new JobCancellationException("Parent job is " + v0(R), cancellationException, this);
        }
        return cancellationException2;
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object R = R();
        if (R instanceof c) {
            Throwable e2 = ((c) R).e();
            if (e2 != null) {
                CancellationException w0 = w0(e2, b0.a(this) + " is cancelling");
                if (w0 != null) {
                    return w0;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(R instanceof x0)) {
            if (R instanceof v) {
                return x0(this, ((v) R).a, null, 1, null);
            }
            return new JobCancellationException(b0.a(this) + " has completed normally", null, this);
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // kotlinx.coroutines.s
    public final void a(n1 n1Var) {
        t(n1Var);
    }

    public void v(Throwable th) {
        t(th);
    }

    public void V(Throwable th) {
        throw th;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) Job.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return Job.DefaultImpls.plus(this, coroutineContext);
    }

    public final boolean s(Throwable th) {
        return t(th);
    }

    public final void t0(q qVar) {
        b.set(this, qVar);
    }

    private static final class b extends f1 {
        private final JobSupport e;
        private final c f;
        private final r g;
        private final Object h;

        static {
            Covode.recordClassIndex(659007);
        }

        @Override // kotlinx.coroutines.z0
        public void invoke(Throwable th) {
            this.e.B(this.f, this.g, this.h);
        }

        public b(JobSupport jobSupport, c cVar, r rVar, Object obj) {
            this.e = jobSupport;
            this.f = cVar;
            this.g = rVar;
            this.h = obj;
        }
    }

    private final class e extends f1 {
        private final kotlinx.coroutines.selects.h<?> e;

        static {
            Covode.recordClassIndex(659010);
        }

        @Override // kotlinx.coroutines.z0
        public void invoke(Throwable th) {
            this.e.trySelect(JobSupport.this, Unit.INSTANCE);
        }

        public e(kotlinx.coroutines.selects.h<?> hVar) {
            this.e = hVar;
        }
    }

    private final Throwable I(Object obj) {
        v vVar;
        if (obj instanceof v) {
            vVar = (v) obj;
        } else {
            vVar = null;
        }
        if (vVar == null) {
            return null;
        }
        return vVar.a;
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(y(), null, this);
        }
        v(cancellationException);
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        return X(false, true, new z0.a(function1));
    }

    @Override // kotlinx.coroutines.Job
    public Job plus(Job job) {
        return Job.DefaultImpls.plus((Job) this, job);
    }

    private final class d extends f1 {
        private final kotlinx.coroutines.selects.h<?> e;

        static {
            Covode.recordClassIndex(659009);
        }

        @Override // kotlinx.coroutines.z0
        public void invoke(Throwable th) {
            Object R = JobSupport.this.R();
            if (!(R instanceof v)) {
                R = g1.h(R);
            }
            this.e.trySelect(JobSupport.this, R);
        }

        public d(kotlinx.coroutines.selects.h<?> hVar) {
            this.e = hVar;
        }
    }

    public static final class f extends LockFreeLinkedListNode.a {
        final /* synthetic */ JobSupport d;
        final /* synthetic */ Object e;

        @Override // kotlinx.coroutines.internal.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object e(LockFreeLinkedListNode lockFreeLinkedListNode) {
            boolean z;
            if (this.d.R() == this.e) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return null;
            }
            return kotlinx.coroutines.internal.r.a();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(LockFreeLinkedListNode lockFreeLinkedListNode, JobSupport jobSupport, Object obj) {
            super(lockFreeLinkedListNode);
            this.d = jobSupport;
            this.e = obj;
        }
    }

    public JobSupport(boolean z) {
        o0 o0Var;
        if (z) {
            o0Var = g1.g;
        } else {
            o0Var = g1.f;
        }
        this._state$volatile = o0Var;
    }

    private final r E(x0 x0Var) {
        r rVar;
        if (x0Var instanceof r) {
            rVar = (r) x0Var;
        } else {
            rVar = null;
        }
        if (rVar == null) {
            j1 a2 = x0Var.a();
            if (a2 == null) {
                return null;
            }
            return g0(a2);
        }
        return rVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.w0] */
    private final void o0(o0 o0Var) {
        j1 j1Var = new j1();
        if (!o0Var.isActive()) {
            j1Var = new w0(j1Var);
        }
        androidx.concurrent.futures.a.a(a, this, o0Var, j1Var);
    }

    private final void p0(f1 f1Var) {
        f1Var.e(new j1());
        androidx.concurrent.futures.a.a(a, this, f1Var, f1Var.j());
    }

    @Override // kotlinx.coroutines.Job
    public final q attachChild(s sVar) {
        DisposableHandle B = JobKt__JobKt.B(this, true, false, new r(sVar), 2, null);
        Intrinsics.checkNotNull(B, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (q) B;
    }

    public final boolean c0(Object obj) {
        Object C0;
        kotlinx.coroutines.internal.f0 f0Var;
        kotlinx.coroutines.internal.f0 f0Var2;
        do {
            C0 = C0(R(), obj);
            f0Var = g1.a;
            if (C0 == f0Var) {
                return false;
            }
            if (C0 == g1.b) {
                return true;
            }
            f0Var2 = g1.c;
        } while (C0 == f0Var2);
        p(C0);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ boolean cancel(Throwable th) {
        Throwable jobCancellationException;
        if (th == null || (jobCancellationException = x0(this, th, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(y(), null, this);
        }
        v(jobCancellationException);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (!Z()) {
            JobKt.ensureActive(continuation.getContext());
            return Unit.INSTANCE;
        }
        Object a0 = a0(continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (a0 == coroutine_suspended) {
            return a0;
        }
        return Unit.INSTANCE;
    }

    public boolean z(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (t(th) && L()) {
            return true;
        }
        return false;
    }

    private static final class a<T> extends CancellableContinuationImpl<T> {
        private final JobSupport a;

        static {
            Covode.recordClassIndex(659006);
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String nameString() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable getContinuationCancellationCause(Job job) {
            Throwable e;
            Object R = this.a.R();
            if ((R instanceof c) && (e = ((c) R).e()) != null) {
                return e;
            }
            if (R instanceof v) {
                return ((v) R).a;
            }
            return job.getCancellationException();
        }

        public a(Continuation<? super T> continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.a = jobSupport;
        }
    }

    private final Throwable C(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof Throwable;
        }
        if (z) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new JobCancellationException(y(), null, this);
            }
            return th;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((n1) obj).n();
    }

    private final j1 P(x0 x0Var) {
        j1 a2 = x0Var.a();
        if (a2 == null) {
            if (x0Var instanceof o0) {
                return new j1();
            }
            if (x0Var instanceof f1) {
                p0((f1) x0Var);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + x0Var).toString());
        }
        return a2;
    }

    private final Object a0(Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        n.a(cancellableContinuationImpl, JobKt__JobKt.B(this, false, false, new p1(cancellableContinuationImpl), 3, null));
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

    private final r g0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.o()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.k();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.j();
            if (!lockFreeLinkedListNode.o()) {
                if (lockFreeLinkedListNode instanceof r) {
                    return (r) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof j1) {
                    return null;
                }
            }
        }
    }

    private final Object r(Continuation<Object> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        a aVar = new a(intercepted, this);
        aVar.initCancellability();
        n.a(aVar, JobKt__JobKt.B(this, false, false, new o1(aVar), 3, null));
        Object result = aVar.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final int u0(Object obj) {
        o0 o0Var;
        if (obj instanceof o0) {
            if (((o0) obj).isActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            o0Var = g1.g;
            if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, o0Var)) {
                return -1;
            }
            n0();
            return 1;
        }
        if (!(obj instanceof w0)) {
            return 0;
        }
        if (!androidx.concurrent.futures.a.a(a, this, obj, ((w0) obj).a())) {
            return -1;
        }
        n0();
        return 1;
    }

    private final String v0(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.i()) {
                return "Cancelling";
            }
            if (!cVar.j()) {
                return "Active";
            }
            return "Completing";
        }
        if (obj instanceof x0) {
            if (((x0) obj).isActive()) {
                return "Active";
            }
            return "New";
        }
        if (obj instanceof v) {
            return "Cancelled";
        }
        return "Completed";
    }

    private final Object w(Object obj) {
        kotlinx.coroutines.internal.f0 f0Var;
        Object C0;
        kotlinx.coroutines.internal.f0 f0Var2;
        do {
            Object R = R();
            if ((R instanceof x0) && (!(R instanceof c) || !((c) R).j())) {
                C0 = C0(R, new v(C(obj), false, 2, null));
                f0Var2 = g1.c;
            } else {
                f0Var = g1.a;
                return f0Var;
            }
        } while (C0 == f0Var2);
        return C0;
    }

    private final boolean x(Throwable th) {
        if (Y()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        q Q = Q();
        if (Q != null && Q != l1.a) {
            if (Q.b(th) || z) {
                return true;
            }
            return false;
        }
        return z;
    }

    protected final void W(Job job) {
        if (job == null) {
            t0(l1.a);
            return;
        }
        job.start();
        q attachChild = job.attachChild(this);
        t0(attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            t0(l1.a);
        }
    }

    public final Object d0(Object obj) {
        Object C0;
        kotlinx.coroutines.internal.f0 f0Var;
        kotlinx.coroutines.internal.f0 f0Var2;
        do {
            C0 = C0(R(), obj);
            f0Var = g1.a;
            if (C0 != f0Var) {
                f0Var2 = g1.c;
            } else {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, I(obj));
            }
        } while (C0 == f0Var2);
        return C0;
    }

    protected final Object q(Continuation<Object> continuation) {
        Object R;
        do {
            R = R();
            if (!(R instanceof x0)) {
                if (!(R instanceof v)) {
                    return g1.h(R);
                }
                throw ((v) R).a;
            }
        } while (u0(R) < 0);
        return r(continuation);
    }

    public final void s0(f1 f1Var) {
        Object R;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        o0 o0Var;
        do {
            R = R();
            if (R instanceof f1) {
                if (R != f1Var) {
                    return;
                }
                atomicReferenceFieldUpdater = a;
                o0Var = g1.g;
            } else {
                if ((R instanceof x0) && ((x0) R).a() != null) {
                    f1Var.p();
                    return;
                }
                return;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, R, o0Var));
    }

    public final boolean t(Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.f0 f0Var;
        kotlinx.coroutines.internal.f0 f0Var2;
        kotlinx.coroutines.internal.f0 f0Var3;
        obj2 = g1.a;
        if (O() && (obj2 = w(obj)) == g1.b) {
            return true;
        }
        f0Var = g1.a;
        if (obj2 == f0Var) {
            obj2 = b0(obj);
        }
        f0Var2 = g1.a;
        if (obj2 == f0Var2 || obj2 == g1.b) {
            return true;
        }
        f0Var3 = g1.d;
        if (obj2 == f0Var3) {
            return false;
        }
        p(obj2);
        return true;
    }

    private final Object b0(Object obj) {
        kotlinx.coroutines.internal.f0 f0Var;
        kotlinx.coroutines.internal.f0 f0Var2;
        kotlinx.coroutines.internal.f0 f0Var3;
        kotlinx.coroutines.internal.f0 f0Var4;
        kotlinx.coroutines.internal.f0 f0Var5;
        kotlinx.coroutines.internal.f0 f0Var6;
        Throwable th = null;
        Throwable th2 = null;
        while (true) {
            Object R = R();
            if (R instanceof c) {
                synchronized (R) {
                    if (((c) R).k()) {
                        f0Var2 = g1.d;
                        return f0Var2;
                    }
                    boolean i = ((c) R).i();
                    if (obj != null || !i) {
                        if (th2 == null) {
                            th2 = C(obj);
                        }
                        ((c) R).b(th2);
                    }
                    Throwable e2 = ((c) R).e();
                    if (!i) {
                        th = e2;
                    }
                    if (th != null) {
                        h0(((c) R).a(), th);
                    }
                    f0Var = g1.a;
                    return f0Var;
                }
            }
            if (R instanceof x0) {
                if (th2 == null) {
                    th2 = C(obj);
                }
                x0 x0Var = (x0) R;
                if (x0Var.isActive()) {
                    if (B0(x0Var, th2)) {
                        f0Var4 = g1.a;
                        return f0Var4;
                    }
                } else {
                    Object C0 = C0(R, new v(th2, false, 2, null));
                    f0Var5 = g1.a;
                    if (C0 != f0Var5) {
                        f0Var6 = g1.c;
                        if (C0 != f0Var6) {
                            return C0;
                        }
                    } else {
                        throw new IllegalStateException(("Cannot happen in " + R).toString());
                    }
                }
            } else {
                f0Var3 = g1.d;
                return f0Var3;
            }
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) Job.DefaultImpls.fold(this, r, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j0(Object obj, Object obj2) {
        if (!(obj2 instanceof v)) {
            return obj2;
        }
        throw ((v) obj2).a;
    }

    private final boolean A0(x0 x0Var, Object obj) {
        if (!androidx.concurrent.futures.a.a(a, this, x0Var, g1.g(obj))) {
            return false;
        }
        l0(null);
        m0(obj);
        A(x0Var, obj);
        return true;
    }

    private final boolean B0(x0 x0Var, Throwable th) {
        j1 P = P(x0Var);
        if (P == null) {
            return false;
        }
        if (!androidx.concurrent.futures.a.a(a, this, x0Var, new c(P, false, th))) {
            return false;
        }
        h0(P, th);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(kotlinx.coroutines.selects.h<?> hVar, Object obj) {
        if (!Z()) {
            hVar.selectInRegistrationPhase(Unit.INSTANCE);
        } else {
            hVar.disposeOnCompletion(JobKt__JobKt.B(this, false, false, new e(hVar), 3, null));
        }
    }

    protected final CancellationException w0(Throwable th, String str) {
        CancellationException cancellationException;
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            if (str == null) {
                str = y();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    private final Object C0(Object obj, Object obj2) {
        kotlinx.coroutines.internal.f0 f0Var;
        kotlinx.coroutines.internal.f0 f0Var2;
        if (!(obj instanceof x0)) {
            f0Var2 = g1.a;
            return f0Var2;
        }
        if (((obj instanceof o0) || (obj instanceof f1)) && !(obj instanceof r) && !(obj2 instanceof v)) {
            if (A0((x0) obj, obj2)) {
                return obj2;
            }
            f0Var = g1.c;
            return f0Var;
        }
        return D0((x0) obj, obj2);
    }

    private final f1 e0(z0 z0Var, boolean z) {
        f1 f1Var = null;
        if (z) {
            if (z0Var instanceof c1) {
                f1Var = (c1) z0Var;
            }
            if (f1Var == null) {
                f1Var = new a1(z0Var);
            }
        } else {
            if (z0Var instanceof f1) {
                f1Var = (f1) z0Var;
            }
            if (f1Var == null) {
                f1Var = new b1(z0Var);
            }
        }
        f1Var.d = this;
        return f1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(kotlinx.coroutines.selects.h<?> hVar, Object obj) {
        Object R;
        do {
            R = R();
            if (!(R instanceof x0)) {
                if (!(R instanceof v)) {
                    R = g1.h(R);
                }
                hVar.selectInRegistrationPhase(R);
                return;
            }
        } while (u0(R) < 0);
        hVar.disposeOnCompletion(JobKt__JobKt.B(this, false, false, new d(hVar), 3, null));
    }

    private final void o(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                ExceptionsKt__ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }

    private final void A(x0 x0Var, Object obj) {
        v vVar;
        q Q = Q();
        if (Q != null) {
            Q.dispose();
            t0(l1.a);
        }
        Throwable th = null;
        if (obj instanceof v) {
            vVar = (v) obj;
        } else {
            vVar = null;
        }
        if (vVar != null) {
            th = vVar.a;
        }
        if (x0Var instanceof f1) {
            try {
                ((f1) x0Var).invoke(th);
                return;
            } catch (Throwable th2) {
                V(new CompletionHandlerException("Exception in completion handler " + x0Var + " for " + this, th2));
                return;
            }
        }
        j1 a2 = x0Var.a();
        if (a2 != null) {
            i0(a2, th);
        }
    }

    private final Object D(c cVar, Object obj) {
        v vVar;
        Throwable th;
        boolean i;
        Throwable K;
        if (obj instanceof v) {
            vVar = (v) obj;
        } else {
            vVar = null;
        }
        if (vVar != null) {
            th = vVar.a;
        } else {
            th = null;
        }
        synchronized (cVar) {
            i = cVar.i();
            List<Throwable> l = cVar.l(th);
            K = K(cVar, l);
            if (K != null) {
                o(K, l);
            }
        }
        boolean z = false;
        if (K != null && K != th) {
            obj = new v(K, false, 2, null);
        }
        if (K != null) {
            if (x(K) || U(K)) {
                z = true;
            }
            if (z) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((v) obj).c();
            }
        }
        if (!i) {
            l0(K);
        }
        m0(obj);
        androidx.concurrent.futures.a.a(a, this, cVar, g1.g(obj));
        A(cVar, obj);
        return obj;
    }

    private final Throwable K(c cVar, List<? extends Throwable> list) {
        Object obj;
        boolean z;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (!cVar.i()) {
                return null;
            }
            return new JobCancellationException(y(), null, this);
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (!(((Throwable) obj) instanceof CancellationException)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it4 = list.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    break;
                }
                Object next = it4.next();
                Throwable th3 = (Throwable) next;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final void h0(j1 j1Var, Throwable th) {
        l0(th);
        Object i = j1Var.i();
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) i; !Intrinsics.areEqual(lockFreeLinkedListNode, j1Var); lockFreeLinkedListNode = lockFreeLinkedListNode.j()) {
            if (lockFreeLinkedListNode instanceof c1) {
                f1 f1Var = (f1) lockFreeLinkedListNode;
                try {
                    f1Var.invoke(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + f1Var + " for " + this, th2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            V(completionHandlerException);
        }
        x(th);
    }

    private final void i0(j1 j1Var, Throwable th) {
        Object i = j1Var.i();
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) i; !Intrinsics.areEqual(lockFreeLinkedListNode, j1Var); lockFreeLinkedListNode = lockFreeLinkedListNode.j()) {
            if (lockFreeLinkedListNode instanceof f1) {
                f1 f1Var = (f1) lockFreeLinkedListNode;
                try {
                    f1Var.invoke(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + f1Var + " for " + this, th2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            V(completionHandlerException);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object D0(x0 x0Var, Object obj) {
        c cVar;
        v vVar;
        kotlinx.coroutines.internal.f0 f0Var;
        kotlinx.coroutines.internal.f0 f0Var2;
        kotlinx.coroutines.internal.f0 f0Var3;
        j1 P = P(x0Var);
        if (P == null) {
            f0Var3 = g1.c;
            return f0Var3;
        }
        ?? r2 = 0;
        if (x0Var instanceof c) {
            cVar = (c) x0Var;
        } else {
            cVar = null;
        }
        boolean z = false;
        if (cVar == null) {
            cVar = new c(P, false, null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (cVar) {
            if (cVar.j()) {
                f0Var2 = g1.a;
                return f0Var2;
            }
            cVar.m(true);
            if (cVar != x0Var && !androidx.concurrent.futures.a.a(a, this, x0Var, cVar)) {
                f0Var = g1.c;
                return f0Var;
            }
            boolean i = cVar.i();
            if (obj instanceof v) {
                vVar = (v) obj;
            } else {
                vVar = null;
            }
            if (vVar != null) {
                cVar.b(vVar.a);
            }
            Throwable e2 = cVar.e();
            if (!i) {
                z = true;
            }
            if (Boolean.valueOf(z).booleanValue()) {
                r2 = e2;
            }
            ref$ObjectRef.element = r2;
            Unit unit = Unit.INSTANCE;
            if (r2 != 0) {
                h0(P, r2);
            }
            r E = E(x0Var);
            if (E != null && E0(cVar, E, obj)) {
                return g1.b;
            }
            return D(cVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(c cVar, r rVar, Object obj) {
        r g0 = g0(rVar);
        if (g0 != null && E0(cVar, g0, obj)) {
            return;
        }
        p(D(cVar, obj));
    }

    private final boolean E0(c cVar, r rVar, Object obj) {
        while (JobKt__JobKt.B(rVar.e, false, false, new b(this, cVar, rVar, obj), 1, null) == l1.a) {
            rVar = g0(rVar);
            if (rVar == null) {
                return false;
            }
        }
        return true;
    }

    private final boolean l(Object obj, j1 j1Var, f1 f1Var) {
        int s;
        f fVar = new f(f1Var, this, obj);
        do {
            s = j1Var.k().s(f1Var, j1Var, fVar);
            if (s == 1) {
                return true;
            }
        } while (s != 2);
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1) {
        return X(z, z2, new z0.a(function1));
    }

    public final DisposableHandle X(boolean z, boolean z2, z0 z0Var) {
        v vVar;
        f1 e0 = e0(z0Var, z);
        while (true) {
            Object R = R();
            if (R instanceof o0) {
                o0 o0Var = (o0) R;
                if (o0Var.isActive()) {
                    if (androidx.concurrent.futures.a.a(a, this, R, e0)) {
                        return e0;
                    }
                } else {
                    o0(o0Var);
                }
            } else {
                Throwable th = null;
                if (R instanceof x0) {
                    j1 a2 = ((x0) R).a();
                    if (a2 == null) {
                        Intrinsics.checkNotNull(R, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        p0((f1) R);
                    } else {
                        DisposableHandle disposableHandle = l1.a;
                        if (z && (R instanceof c)) {
                            synchronized (R) {
                                th = ((c) R).e();
                                if (th == null || ((z0Var instanceof r) && !((c) R).j())) {
                                    if (l(R, a2, e0)) {
                                        if (th == null) {
                                            return e0;
                                        }
                                        disposableHandle = e0;
                                    }
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                        if (th != null) {
                            if (z2) {
                                z0Var.invoke(th);
                            }
                            return disposableHandle;
                        }
                        if (l(R, a2, e0)) {
                            return e0;
                        }
                    }
                } else {
                    if (z2) {
                        if (R instanceof v) {
                            vVar = (v) R;
                        } else {
                            vVar = null;
                        }
                        if (vVar != null) {
                            th = vVar.a;
                        }
                        z0Var.invoke(th);
                    }
                    return l1.a;
                }
            }
        }
    }

    public static /* synthetic */ CancellationException x0(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return jobSupport.w0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }
}
