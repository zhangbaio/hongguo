package kotlinx.coroutines.selects;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.selects.SelectBuilder;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SelectImplementation<R> implements kotlinx.coroutines.l, SelectBuilder<R>, i<R> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater state$volatile$FU;
    private List<SelectImplementation<R>.a> clauses;
    private final CoroutineContext context;
    private Object disposableHandleOrSegment;
    private int indexInSegment;
    private Object internalResult;
    private volatile /* synthetic */ Object state$volatile;

    static {
        Covode.recordClassIndex(659350);
        state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");
    }

    private final /* synthetic */ Object getState$volatile() {
        return this.state$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final /* synthetic */ void setState$volatile(Object obj) {
        this.state$volatile = obj;
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, obj, obj2, function1.invoke(obj2)));
    }

    public Object doSelect(Continuation<? super R> continuation) {
        return doSelect$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.selects.i, kotlinx.coroutines.selects.h
    public CoroutineContext getContext() {
        return this.context;
    }

    private final boolean isSelected() {
        return state$volatile$FU.get(this) instanceof a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getInRegistrationPhase() {
        f0 f0Var;
        Object obj = state$volatile$FU.get(this);
        f0Var = SelectKt.b;
        if (obj != f0Var && !(obj instanceof List)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCancelled() {
        f0 f0Var;
        Object obj = state$volatile$FU.get(this);
        f0Var = SelectKt.d;
        if (obj == f0Var) {
            return true;
        }
        return false;
    }

    public final class a {
        public final Object a;
        private final Function3<Object, h<?>, Object, Unit> b;
        private final Function3<Object, Object, Object, Object> c;
        private final Object d;
        private final Object e;
        public final Function3<h<?>, Object, Object, Function1<Throwable, Unit>> f;
        public Object g;
        public int h = -1;

        static {
            Covode.recordClassIndex(659351);
        }

        public final void b() {
            Object obj = this.g;
            SelectImplementation<R> selectImplementation = SelectImplementation.this;
            DisposableHandle disposableHandle = null;
            if (obj instanceof c0) {
                ((c0) obj).r(this.h, null, selectImplementation.getContext());
                return;
            }
            if (obj instanceof DisposableHandle) {
                disposableHandle = (DisposableHandle) obj;
            }
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }

        public final Object d(Object obj) {
            return this.c.invoke(this.a, this.d, obj);
        }

        public final boolean e(SelectImplementation<R> selectImplementation) {
            f0 f0Var;
            this.b.invoke(this.a, selectImplementation, this.d);
            Object obj = ((SelectImplementation) selectImplementation).internalResult;
            f0Var = SelectKt.e;
            if (obj == f0Var) {
                return true;
            }
            return false;
        }

        public final Function1<Throwable, Unit> a(h<?> hVar, Object obj) {
            Function3<h<?>, Object, Object, Function1<Throwable, Unit>> function3 = this.f;
            if (function3 != null) {
                return function3.invoke(hVar, this.d, obj);
            }
            return null;
        }

        public final Object c(Object obj, Continuation<? super R> continuation) {
            Object obj2 = this.e;
            if (this.d == SelectKt.i()) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((Function1) obj2).invoke(continuation);
            }
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) obj2).invoke(obj, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Object obj, Function3<Object, ? super h<?>, Object, Unit> function3, Function3<Object, Object, Object, ? extends Object> function32, Object obj2, Object obj3, Function3<? super h<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> function33) {
            this.a = obj;
            this.b = function3;
            this.c = function32;
            this.d = obj2;
            this.e = obj3;
            this.f = function33;
        }
    }

    @Override // kotlinx.coroutines.selects.h
    public void disposeOnCompletion(DisposableHandle disposableHandle) {
        this.disposableHandleOrSegment = disposableHandle;
    }

    @Override // kotlinx.coroutines.selects.h
    public void selectInRegistrationPhase(Object obj) {
        this.internalResult = obj;
    }

    public SelectImplementation(CoroutineContext coroutineContext) {
        f0 f0Var;
        f0 f0Var2;
        this.context = coroutineContext;
        f0Var = SelectKt.b;
        this.state$volatile = f0Var;
        this.clauses = new ArrayList(2);
        this.indexInSegment = -1;
        f0Var2 = SelectKt.e;
        this.internalResult = f0Var2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object complete(Continuation<? super R> continuation) {
        Object obj = state$volatile$FU.get(this);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        SelectImplementation<R>.a aVar = (a) obj;
        Object obj2 = this.internalResult;
        cleanup(aVar);
        return aVar.c(aVar.d(obj2), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reregisterClause(Object obj) {
        SelectImplementation<R>.a findClause = findClause(obj);
        Intrinsics.checkNotNull(findClause);
        findClause.g = null;
        findClause.h = -1;
        register(findClause, true);
    }

    private final void cleanup(SelectImplementation<R>.a aVar) {
        f0 f0Var;
        f0 f0Var2;
        List<SelectImplementation<R>.a> list = this.clauses;
        if (list == null) {
            return;
        }
        for (SelectImplementation<R>.a aVar2 : list) {
            if (aVar2 != aVar) {
                aVar2.b();
            }
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$volatile$FU;
        f0Var = SelectKt.c;
        atomicReferenceFieldUpdater.set(this, f0Var);
        f0Var2 = SelectKt.e;
        this.internalResult = f0Var2;
        this.clauses = null;
    }

    @Override // kotlinx.coroutines.l
    public void invoke(Throwable th) {
        Object obj;
        f0 f0Var;
        f0 f0Var2;
        f0 f0Var3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$volatile$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            f0Var = SelectKt.c;
            if (obj == f0Var) {
                return;
            } else {
                f0Var2 = SelectKt.d;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, f0Var2));
        List<SelectImplementation<R>.a> list = this.clauses;
        if (list == null) {
            return;
        }
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            ((a) it2.next()).b();
        }
        f0Var3 = SelectKt.e;
        this.internalResult = f0Var3;
        this.clauses = null;
    }

    private final void checkClauseObject(Object obj) {
        boolean z;
        List<SelectImplementation<R>.a> list = this.clauses;
        Intrinsics.checkNotNull(list);
        boolean z2 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (((a) it2.next()).a == obj) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2) {
            return;
        }
        throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0057 A[PHI: r6
  0x0057: PHI (r6v5 java.lang.Object) = (r6v4 java.lang.Object), (r6v1 java.lang.Object) binds: [B:17:0x0054, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doSelectSuspend(kotlin.coroutines.Continuation<? super R> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L57
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.selects.SelectImplementation r2 = (kotlinx.coroutines.selects.SelectImplementation) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4b
        L3c:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.waitUntilSelected(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r2 = r5
        L4b:
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r2.complete(r0)
            if (r6 != r1) goto L57
            return r1
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.doSelectSuspend(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final SelectImplementation<R>.a findClause(Object obj) {
        boolean z;
        List<SelectImplementation<R>.a> list = this.clauses;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((a) next).a == obj) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                obj2 = next;
                break;
            }
        }
        SelectImplementation<R>.a aVar = (a) obj2;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
    
        r0 = r0.getResult();
        r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
    
        if (r0 != r1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        r6 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
    
        if (r0 != r6) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object waitUntilSelected(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            kotlinx.coroutines.CancellableContinuationImpl r0 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r6)
            r2 = 1
            r0.<init>(r1, r2)
            r0.initCancellability()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = access$getState$volatile$FU()
        L11:
            java.lang.Object r2 = r1.get(r5)
            kotlinx.coroutines.internal.f0 r3 = kotlinx.coroutines.selects.SelectKt.g()
            if (r2 != r3) goto L29
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = access$getState$volatile$FU()
            boolean r2 = androidx.concurrent.futures.a.a(r3, r5, r2, r0)
            if (r2 == 0) goto L11
            kotlinx.coroutines.n.c(r0, r5)
            goto L65
        L29:
            boolean r3 = r2 instanceof java.util.List
            if (r3 == 0) goto L52
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = access$getState$volatile$FU()
            kotlinx.coroutines.internal.f0 r4 = kotlinx.coroutines.selects.SelectKt.g()
            boolean r3 = androidx.concurrent.futures.a.a(r3, r5, r2, r4)
            if (r3 == 0) goto L11
            r3 = r2
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L44:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L11
            java.lang.Object r3 = r2.next()
            access$reregisterClause(r5, r3)
            goto L44
        L52:
            boolean r1 = r2 instanceof kotlinx.coroutines.selects.SelectImplementation.a
            if (r1 == 0) goto L7c
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            kotlinx.coroutines.selects.SelectImplementation$a r2 = (kotlinx.coroutines.selects.SelectImplementation.a) r2
            java.lang.Object r3 = access$getInternalResult$p(r5)
            kotlin.jvm.functions.Function1 r2 = r2.a(r5, r3)
            r0.resume(r1, r2)
        L65:
            java.lang.Object r0 = r0.getResult()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L72
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r6)
        L72:
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r6) goto L79
            return r0
        L79:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L7c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unexpected state: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.waitUntilSelected(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(e<? super P, ? extends Q> eVar, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.a.a(this, eVar, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long j, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        SelectBuilder.a.b(this, j, function1);
    }

    @Override // kotlinx.coroutines.f2
    public void invokeOnCancellation(c0<?> c0Var, int i) {
        this.disposableHandleOrSegment = c0Var;
        this.indexInSegment = i;
    }

    static /* synthetic */ <R> Object doSelect$suspendImpl(SelectImplementation<R> selectImplementation, Continuation<? super R> continuation) {
        if (selectImplementation.isSelected()) {
            return selectImplementation.complete(continuation);
        }
        return selectImplementation.doSelectSuspend(continuation);
    }

    @Override // kotlinx.coroutines.selects.h
    public boolean trySelect(Object obj, Object obj2) {
        if (trySelectInternal(obj, obj2) == 0) {
            return true;
        }
        return false;
    }

    public final TrySelectDetailedResult trySelectDetailed(Object obj, Object obj2) {
        TrySelectDetailedResult a2;
        a2 = SelectKt.a(trySelectInternal(obj, obj2));
        return a2;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        register$default(this, new a(selectClause1.getClauseObject(), selectClause1.getRegFunc(), selectClause1.getProcessResFunc(), null, function2, selectClause1.getOnCancellationConstructor()), false, 1, null);
    }

    public final void register(SelectImplementation<R>.a aVar, boolean z) {
        if (state$volatile$FU.get(this) instanceof a) {
            return;
        }
        if (!z) {
            checkClauseObject(aVar.a);
        }
        if (aVar.e(this)) {
            if (!z) {
                List<SelectImplementation<R>.a> list = this.clauses;
                Intrinsics.checkNotNull(list);
                list.add(aVar);
            }
            aVar.g = this.disposableHandleOrSegment;
            aVar.h = this.indexInSegment;
            this.disposableHandleOrSegment = null;
            this.indexInSegment = -1;
            return;
        }
        state$volatile$FU.set(this, aVar);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(b bVar, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        register$default(this, new a(bVar.getClauseObject(), bVar.getRegFunc(), bVar.getProcessResFunc(), SelectKt.i(), function1, bVar.getOnCancellationConstructor()), false, 1, null);
    }

    private final int trySelectInternal(Object obj, Object obj2) {
        boolean j;
        f0 f0Var;
        f0 f0Var2;
        boolean z;
        f0 f0Var3;
        f0 f0Var4;
        while (true) {
            Object obj3 = state$volatile$FU.get(this);
            if (obj3 instanceof CancellableContinuation) {
                SelectImplementation<R>.a findClause = findClause(obj);
                if (findClause == null) {
                    continue;
                } else {
                    Function1<Throwable, Unit> a2 = findClause.a(this, obj2);
                    if (androidx.concurrent.futures.a.a(state$volatile$FU, this, obj3, findClause)) {
                        this.internalResult = obj2;
                        j = SelectKt.j((CancellableContinuation) obj3, a2);
                        if (j) {
                            return 0;
                        }
                        f0Var = SelectKt.e;
                        this.internalResult = f0Var;
                        return 2;
                    }
                }
            } else {
                f0Var2 = SelectKt.c;
                if (Intrinsics.areEqual(obj3, f0Var2)) {
                    z = true;
                } else {
                    z = obj3 instanceof a;
                }
                if (z) {
                    return 3;
                }
                f0Var3 = SelectKt.d;
                if (Intrinsics.areEqual(obj3, f0Var3)) {
                    return 2;
                }
                f0Var4 = SelectKt.b;
                if (Intrinsics.areEqual(obj3, f0Var4)) {
                    if (androidx.concurrent.futures.a.a(state$volatile$FU, this, obj3, CollectionsKt__CollectionsJVMKt.listOf(obj))) {
                        return 1;
                    }
                } else if (obj3 instanceof List) {
                    if (androidx.concurrent.futures.a.a(state$volatile$FU, this, obj3, CollectionsKt___CollectionsKt.plus((Collection<? extends Object>) obj3, obj))) {
                        return 1;
                    }
                } else {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processResultAndInvokeBlockRecoveringException(kotlinx.coroutines.selects.SelectImplementation<R>.a r5, java.lang.Object r6, kotlin.coroutines.Continuation<? super R> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L29
            goto L43
        L29:
            r5 = move-exception
            goto L44
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r6 = r5.d(r6)     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r7 = r5.c(r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r7 != r1) goto L43
            return r1
        L43:
            return r7
        L44:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.processResultAndInvokeBlockRecoveringException(kotlinx.coroutines.selects.SelectImplementation$a, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(e<? super P, ? extends Q> eVar, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        register$default(this, new a(eVar.getClauseObject(), eVar.getRegFunc(), eVar.getProcessResFunc(), p, function2, eVar.getOnCancellationConstructor()), false, 1, null);
    }

    public static /* synthetic */ void register$default(SelectImplementation selectImplementation, a aVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            selectImplementation.register(aVar, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }
}
