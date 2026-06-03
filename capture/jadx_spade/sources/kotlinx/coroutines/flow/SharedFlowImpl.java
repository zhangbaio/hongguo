package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SharedFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<j> implements MutableSharedFlow<T>, kotlinx.coroutines.flow.a<T>, kotlinx.coroutines.flow.internal.i<T> {
    private final int e;
    private final int f;
    private final BufferOverflow g;
    private Object[] h;
    private long i;
    private long j;
    private int k;
    private int l;

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(659163);
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(659161);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return u(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        return z(this, t, continuation);
    }

    private static final class a implements DisposableHandle {
        public final SharedFlowImpl<?> a;
        public long b;
        public final Object c;
        public final Continuation<Unit> d;

        static {
            Covode.recordClassIndex(659162);
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.a.s(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(SharedFlowImpl<?> sharedFlowImpl, long j, Object obj, Continuation<? super Unit> continuation) {
            this.a = sharedFlowImpl;
            this.b = j;
            this.c = obj;
            this.d = continuation;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int J() {
        return this.k + this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public j e() {
        return new j();
    }

    private final long D() {
        return E() + this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long E() {
        return Math.min(this.j, this.i);
    }

    private final long H() {
        return E() + this.k + this.l;
    }

    private final int I() {
        return (int) ((E() + this.k) - this.i);
    }

    public final long R() {
        long j = this.i;
        if (j < this.j) {
            this.j = j;
        }
        return j;
    }

    protected final T F() {
        Object bufferAt;
        Object[] objArr = this.h;
        Intrinsics.checkNotNull(objArr);
        bufferAt = SharedFlowKt.getBufferAt(objArr, (this.i + I()) - 1);
        return (T) bufferAt;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            P(D(), this.j, D(), H());
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void t() {
        Object bufferAt;
        if (this.f == 0 && this.l <= 1) {
            return;
        }
        Object[] objArr = this.h;
        Intrinsics.checkNotNull(objArr);
        while (this.l > 0) {
            bufferAt = SharedFlowKt.getBufferAt(objArr, (E() + J()) - 1);
            if (bufferAt == SharedFlowKt.NO_VALUE) {
                this.l--;
                SharedFlowKt.setBufferAt(objArr, E() + J(), null);
            } else {
                return;
            }
        }
    }

    private final void y() {
        Object[] objArr = this.h;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.setBufferAt(objArr, E(), null);
        this.k--;
        long E = E() + 1;
        if (this.i < E) {
            this.i = E;
        }
        if (this.j < E) {
            v(E);
        }
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        Object bufferAt;
        synchronized (this) {
            int I = I();
            if (I == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(I);
            Object[] objArr = this.h;
            Intrinsics.checkNotNull(objArr);
            for (int i = 0; i < I; i++) {
                bufferAt = SharedFlowKt.getBufferAt(objArr, this.i + i);
                arrayList.add(bufferAt);
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public j[] f(int i) {
        return new j[i];
    }

    private final Object G(long j) {
        Object bufferAt;
        Object[] objArr = this.h;
        Intrinsics.checkNotNull(objArr);
        bufferAt = SharedFlowKt.getBufferAt(objArr, j);
        if (bufferAt instanceof a) {
            return ((a) bufferAt).c;
        }
        return bufferAt;
    }

    private final boolean M(T t) {
        if (this.e == 0) {
            return true;
        }
        B(t);
        int i = this.k + 1;
        this.k = i;
        if (i > this.e) {
            y();
        }
        this.j = E() + this.k;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(Object obj) {
        int J = J();
        Object[] objArr = this.h;
        if (objArr == null) {
            objArr = K(null, 0, 2);
        } else if (J >= objArr.length) {
            objArr = K(objArr, J, objArr.length * 2);
        }
        SharedFlowKt.setBufferAt(objArr, E() + J, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long N(j jVar) {
        long j = jVar.a;
        if (j < D()) {
            return j;
        }
        if (this.f > 0 || j > E() || this.l == 0) {
            return -1L;
        }
        return j;
    }

    private final Object O(j jVar) {
        Object obj;
        Continuation<Unit>[] continuationArr = kotlinx.coroutines.flow.internal.b.a;
        synchronized (this) {
            long N = N(jVar);
            if (N < 0) {
                obj = SharedFlowKt.NO_VALUE;
            } else {
                long j = jVar.a;
                Object G = G(N);
                jVar.a = N + 1;
                continuationArr = Q(j);
                obj = G;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m773constructorimpl(Unit.INSTANCE));
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(a aVar) {
        Object bufferAt;
        synchronized (this) {
            if (aVar.b < E()) {
                return;
            }
            Object[] objArr = this.h;
            Intrinsics.checkNotNull(objArr);
            bufferAt = SharedFlowKt.getBufferAt(objArr, aVar.b);
            if (bufferAt != aVar) {
                return;
            }
            SharedFlowKt.setBufferAt(objArr, aVar.b, SharedFlowKt.NO_VALUE);
            t();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r0 = r9.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void v(long r10) {
        /*
            r9 = this;
            int r0 = kotlinx.coroutines.flow.internal.a.b(r9)
            if (r0 == 0) goto L27
            kotlinx.coroutines.flow.internal.c[] r0 = kotlinx.coroutines.flow.internal.a.c(r9)
            if (r0 == 0) goto L27
            int r1 = r0.length
            r2 = 0
        Le:
            if (r2 >= r1) goto L27
            r3 = r0[r2]
            if (r3 == 0) goto L24
            kotlinx.coroutines.flow.j r3 = (kotlinx.coroutines.flow.j) r3
            long r4 = r3.a
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L24
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 >= 0) goto L24
            r3.a = r10
        L24:
            int r2 = r2 + 1
            goto Le
        L27:
            r9.j = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.v(long):void");
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t) {
        int i;
        boolean z;
        Continuation<Unit>[] continuationArr = kotlinx.coroutines.flow.internal.b.a;
        synchronized (this) {
            if (L(t)) {
                continuationArr = C(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m773constructorimpl(Unit.INSTANCE));
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0007, code lost:
    
        r1 = r11.a;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object, java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.coroutines.Continuation<kotlin.Unit>[] C(kotlin.coroutines.Continuation<kotlin.Unit>[] r12) {
        /*
            r11 = this;
            int r0 = r12.length
            int r1 = kotlinx.coroutines.flow.internal.a.b(r11)
            if (r1 == 0) goto L48
            kotlinx.coroutines.flow.internal.c[] r1 = kotlinx.coroutines.flow.internal.a.c(r11)
            if (r1 == 0) goto L48
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L48
            r4 = r1[r3]
            if (r4 == 0) goto L45
            kotlinx.coroutines.flow.j r4 = (kotlinx.coroutines.flow.j) r4
            kotlin.coroutines.Continuation<? super kotlin.Unit> r5 = r4.b
            if (r5 != 0) goto L1c
            goto L45
        L1c:
            long r6 = r11.N(r4)
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L45
            int r6 = r12.length
            if (r0 < r6) goto L3a
            int r6 = r12.length
            r7 = 2
            int r6 = r6 * 2
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r6)
            java.lang.String r6 = "copyOf(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r6)
        L3a:
            r6 = r12
            kotlin.coroutines.Continuation[] r6 = (kotlin.coroutines.Continuation[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.b = r0
            r0 = r7
        L45:
            int r3 = r3 + 1
            goto Lf
        L48:
            kotlin.coroutines.Continuation[] r12 = (kotlin.coroutines.Continuation[]) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.C(kotlin.coroutines.Continuation[]):kotlin.coroutines.Continuation[]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L(T t) {
        if (this.b == 0) {
            return M(t);
        }
        if (this.k >= this.f && this.j <= this.i) {
            int i = b.a[this.g.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return true;
                }
            } else {
                return false;
            }
        }
        B(t);
        int i2 = this.k + 1;
        this.k = i2;
        if (i2 > this.f) {
            y();
        }
        if (I() > this.e) {
            P(this.i + 1, this.j, D(), H());
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        r4 = r21.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.coroutines.Continuation<kotlin.Unit>[] Q(long r22) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.Q(long):kotlin.coroutines.Continuation[]");
    }

    private final Object r(j jVar, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            if (N(jVar) < 0) {
                jVar.b = cancellableContinuationImpl;
            } else {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m773constructorimpl(Unit.INSTANCE));
            }
            Unit unit = Unit.INSTANCE;
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

    private final Object A(T t, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Continuation<Unit>[] continuationArr;
        a aVar;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        Continuation<Unit>[] continuationArr2 = kotlinx.coroutines.flow.internal.b.a;
        synchronized (this) {
            if (L(t)) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m773constructorimpl(Unit.INSTANCE));
                continuationArr = C(continuationArr2);
                aVar = null;
            } else {
                a aVar2 = new a(this, J() + E(), t, cancellableContinuationImpl);
                B(aVar2);
                this.l++;
                if (this.f == 0) {
                    continuationArr2 = C(continuationArr2);
                }
                continuationArr = continuationArr2;
                aVar = aVar2;
            }
        }
        if (aVar != null) {
            kotlinx.coroutines.n.a(cancellableContinuationImpl, aVar);
        }
        for (Continuation<Unit> continuation2 : continuationArr) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m773constructorimpl(Unit.INSTANCE));
            }
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

    @Override // kotlinx.coroutines.flow.internal.i
    public Flow<T> a(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, coroutineContext, i, bufferOverflow);
    }

    public SharedFlowImpl(int i, int i2, BufferOverflow bufferOverflow) {
        this.e = i;
        this.f = i2;
        this.g = bufferOverflow;
    }

    static /* synthetic */ <T> Object z(SharedFlowImpl<T> sharedFlowImpl, T t, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (sharedFlowImpl.tryEmit(t)) {
            return Unit.INSTANCE;
        }
        Object A = sharedFlowImpl.A(t, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (A == coroutine_suspended) {
            return A;
        }
        return Unit.INSTANCE;
    }

    private final Object[] K(Object[] objArr, int i, int i2) {
        boolean z;
        Object bufferAt;
        if (i2 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Object[] objArr2 = new Object[i2];
            this.h = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long E = E();
            for (int i3 = 0; i3 < i; i3++) {
                long j = i3 + E;
                bufferAt = SharedFlowKt.getBufferAt(objArr, j);
                SharedFlowKt.setBufferAt(objArr2, j, bufferAt);
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|(3:(6:(1:(1:11)(2:41|42))(1:43)|12|13|14|15|(3:16|(3:28|29|(2:31|32)(1:33))(4:18|(1:20)|21|(2:23|24)(1:26))|27))(4:44|45|46|47)|37|38)(5:53|54|55|(2:57|(1:59))|61)|48|49|15|(3:16|(0)(0)|27)))|64|6|(0)(0)|48|49|15|(3:16|(0)(0)|27)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d2, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d3, code lost:
    
        r5 = r8;
        r8 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ <T> java.lang.Object u(kotlinx.coroutines.flow.SharedFlowImpl<T> r8, kotlinx.coroutines.flow.FlowCollector<? super T> r9, kotlin.coroutines.Continuation<?> r10) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.u(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void P(long j, long j2, long j3, long j4) {
        long min = Math.min(j2, j);
        for (long E = E(); E < min; E++) {
            Object[] objArr = this.h;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.setBufferAt(objArr, E, null);
        }
        this.i = j;
        this.j = j2;
        this.k = (int) (j3 - min);
        this.l = (int) (j4 - j3);
    }
}
