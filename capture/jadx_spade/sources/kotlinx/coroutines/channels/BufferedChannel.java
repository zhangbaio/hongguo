package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.e0;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BufferedChannel<E> implements Channel<E> {
    private static final /* synthetic */ AtomicLongFieldUpdater d;
    private static final /* synthetic */ AtomicLongFieldUpdater e;
    private static final /* synthetic */ AtomicLongFieldUpdater f;
    private static final /* synthetic */ AtomicLongFieldUpdater g;
    private static final /* synthetic */ AtomicReferenceFieldUpdater h;
    private static final /* synthetic */ AtomicReferenceFieldUpdater i;
    private static final /* synthetic */ AtomicReferenceFieldUpdater j;
    private static final /* synthetic */ AtomicReferenceFieldUpdater k;
    private static final /* synthetic */ AtomicReferenceFieldUpdater l;
    private volatile /* synthetic */ Object _closeCause$volatile;
    private final int a;
    public final Function1<E, Unit> b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private final Function3<kotlinx.coroutines.selects.h<?>, Object, Object, Function1<Throwable, Unit>> c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    static {
        Covode.recordClassIndex(659067);
        d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");
        e = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");
        f = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");
        g = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
        h = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");
        i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");
        j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");
        k = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");
        l = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater P() {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater Q() {
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater T() {
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater U() {
        return d;
    }

    public Object M0(E e2, Continuation<? super Boolean> continuation) {
        return N0(this, e2, continuation);
    }

    protected boolean f0() {
        return false;
    }

    protected void m0() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation<? super E> continuation) {
        return B0(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo1079receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        return C0(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e2, Continuation<? super Unit> continuation) {
        return L0(this, e2, continuation);
    }

    protected void t0() {
    }

    protected void u0() {
    }

    private final void C() {
        isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        w(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return new a();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public E poll() {
        return (E) Channel.a.b(this);
    }

    private final long J() {
        return f.get(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable O() {
        Throwable L = L();
        if (L == null) {
            return new ClosedReceiveChannelException("Channel was closed");
        }
        return L;
    }

    protected final Throwable L() {
        return (Throwable) k.get(this);
    }

    public boolean Q0() {
        return P0(d.get(this));
    }

    public final long R() {
        return e.get(this);
    }

    protected final Throwable S() {
        Throwable L = L();
        if (L == null) {
            return new ClosedSendChannelException("Channel was closed");
        }
        return L;
    }

    public final long V() {
        return d.get(this) & 1152921504606846975L;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return d0(d.get(this));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return e0(d.get(this));
    }

    private final class a implements ChannelIterator<E>, f2 {
        private Object a;
        private CancellableContinuationImpl<? super Boolean> b;

        static {
            Covode.recordClassIndex(659068);
        }

        private final boolean f() {
            this.a = BufferedChannelKt.z();
            Throwable L = BufferedChannel.this.L();
            if (L == null) {
                return false;
            }
            throw e0.a(L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.b;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.b = null;
            this.a = BufferedChannelKt.z();
            Throwable L = BufferedChannel.this.L();
            if (L == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m773constructorimpl(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(L)));
            }
        }

        public final void i() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.b;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.b = null;
            this.a = BufferedChannelKt.z();
            Throwable L = BufferedChannel.this.L();
            if (L == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m773constructorimpl(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(L)));
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            f0 f0Var;
            boolean z;
            f0 f0Var2;
            E e = (E) this.a;
            f0Var = BufferedChannelKt.p;
            if (e != f0Var) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                f0Var2 = BufferedChannelKt.p;
                this.a = f0Var2;
                if (e != BufferedChannelKt.z()) {
                    return e;
                }
                throw e0.a(BufferedChannel.this.O());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }

        public a() {
            f0 f0Var;
            f0Var = BufferedChannelKt.p;
            this.a = f0Var;
        }

        public final boolean h(E e) {
            boolean B;
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.b;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            Function1<Throwable, Unit> function1 = null;
            this.b = null;
            this.a = e;
            Boolean bool = Boolean.TRUE;
            Function1<E, Unit> function12 = BufferedChannel.this.b;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.a(function12, e, cancellableContinuationImpl.getContext());
            }
            B = BufferedChannelKt.B(cancellableContinuationImpl, bool, function1);
            return B;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object a(Continuation<? super Boolean> continuation) {
            d<E> dVar;
            f0 f0Var;
            f0 f0Var2;
            f0 f0Var3;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            d<E> dVar2 = (d) BufferedChannel.P().get(bufferedChannel);
            while (!bufferedChannel.isClosedForReceive()) {
                long andIncrement = BufferedChannel.Q().getAndIncrement(bufferedChannel);
                int i = BufferedChannelKt.b;
                long j = andIncrement / i;
                int i2 = (int) (andIncrement % i);
                if (dVar2.c == j) {
                    dVar = dVar2;
                } else {
                    d<E> G = bufferedChannel.G(j, dVar2);
                    if (G == null) {
                        continue;
                    } else {
                        dVar = G;
                    }
                }
                Object W0 = bufferedChannel.W0(dVar, i2, andIncrement, null);
                f0Var = BufferedChannelKt.m;
                if (W0 != f0Var) {
                    f0Var2 = BufferedChannelKt.o;
                    if (W0 == f0Var2) {
                        if (andIncrement < bufferedChannel.V()) {
                            dVar.b();
                        }
                        dVar2 = dVar;
                    } else {
                        f0Var3 = BufferedChannelKt.n;
                        if (W0 == f0Var3) {
                            return e(dVar, i2, andIncrement, continuation);
                        }
                        dVar.b();
                        this.a = W0;
                        return Boxing.boxBoolean(true);
                    }
                } else {
                    throw new IllegalStateException("unreachable".toString());
                }
            }
            return Boxing.boxBoolean(f());
        }

        @Override // kotlinx.coroutines.f2
        public void invokeOnCancellation(c0<?> c0Var, int i) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.b;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(c0Var, i);
            }
        }

        private final Object e(d<E> dVar, int i, long j, Continuation<? super Boolean> continuation) {
            Continuation intercepted;
            f0 f0Var;
            f0 f0Var2;
            Boolean boxBoolean;
            f0 f0Var3;
            f0 f0Var4;
            f0 f0Var5;
            Object coroutine_suspended;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl b = n.b(intercepted);
            try {
                this.b = b;
                Object W0 = bufferedChannel.W0(dVar, i, j, this);
                f0Var = BufferedChannelKt.m;
                if (W0 == f0Var) {
                    bufferedChannel.v0(this, dVar, i);
                } else {
                    f0Var2 = BufferedChannelKt.o;
                    Function1<Throwable, Unit> function1 = null;
                    if (W0 == f0Var2) {
                        if (j < bufferedChannel.V()) {
                            dVar.b();
                        }
                        d dVar2 = (d) BufferedChannel.P().get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.isClosedForReceive()) {
                                g();
                                break;
                            }
                            long andIncrement = BufferedChannel.Q().getAndIncrement(bufferedChannel);
                            int i2 = BufferedChannelKt.b;
                            long j2 = andIncrement / i2;
                            int i3 = (int) (andIncrement % i2);
                            if (dVar2.c != j2) {
                                d G = bufferedChannel.G(j2, dVar2);
                                if (G != null) {
                                    dVar2 = G;
                                }
                            }
                            Object W02 = bufferedChannel.W0(dVar2, i3, andIncrement, this);
                            f0Var3 = BufferedChannelKt.m;
                            if (W02 == f0Var3) {
                                bufferedChannel.v0(this, dVar2, i3);
                                break;
                            }
                            f0Var4 = BufferedChannelKt.o;
                            if (W02 == f0Var4) {
                                if (andIncrement < bufferedChannel.V()) {
                                    dVar2.b();
                                }
                            } else {
                                f0Var5 = BufferedChannelKt.n;
                                if (W02 != f0Var5) {
                                    dVar2.b();
                                    this.a = W02;
                                    this.b = null;
                                    boxBoolean = Boxing.boxBoolean(true);
                                    Function1<E, Unit> function12 = bufferedChannel.b;
                                    if (function12 != null) {
                                        function1 = OnUndeliveredElementKt.a(function12, W02, b.getContext());
                                    }
                                } else {
                                    throw new IllegalStateException("unexpected".toString());
                                }
                            }
                        }
                    } else {
                        dVar.b();
                        this.a = W0;
                        this.b = null;
                        boxBoolean = Boxing.boxBoolean(true);
                        Function1<E, Unit> function13 = bufferedChannel.b;
                        if (function13 != null) {
                            function1 = OnUndeliveredElementKt.a(function13, W0, b.getContext());
                        }
                    }
                    b.resume(boxBoolean, function1);
                }
                Object result = b.getResult();
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (result == coroutine_suspended) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return result;
            } catch (Throwable th) {
                b.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th;
            }
        }
    }

    private final boolean g0() {
        long J = J();
        if (J != 0 && J != Long.MAX_VALUE) {
            return false;
        }
        return true;
    }

    private final void j0() {
        long j2;
        long w;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            w = BufferedChannelKt.w(1152921504606846975L & j2, 3);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, w));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        if (isClosedForReceive() || X()) {
            return false;
        }
        return !isClosedForReceive();
    }

    private final void a0() {
        Object obj;
        f0 f0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f0Var = BufferedChannelKt.q;
            } else {
                f0Var = BufferedChannelKt.r;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, f0Var));
        if (obj == null) {
            return;
        }
        ((Function1) obj).invoke(L());
    }

    private final void i0() {
        long j2;
        long w;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            if (((int) (j2 >> 60)) != 0) {
                return;
            } else {
                w = BufferedChannelKt.w(1152921504606846975L & j2, 1);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, w));
    }

    private final void k0() {
        long j2;
        long w;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            int i2 = (int) (j2 >> 60);
            if (i2 != 0) {
                if (i2 != 1) {
                    return;
                } else {
                    w = BufferedChannelKt.w(j2 & 1152921504606846975L, 3);
                }
            } else {
                w = BufferedChannelKt.w(j2 & 1152921504606846975L, 2);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, w));
    }

    private final d<E> y() {
        Object obj = j.get(this);
        d dVar = (d) h.get(this);
        if (dVar.c > ((d) obj).c) {
            obj = dVar;
        }
        d dVar2 = (d) i.get(this);
        if (dVar2.c > ((d) obj).c) {
            obj = dVar2;
        }
        return (d) kotlinx.coroutines.internal.d.b((kotlinx.coroutines.internal.e) obj);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceive() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$1, 3);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.d(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$2, 3), this.c);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.d(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.c);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$1, 3);
        BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.d(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$2, 3), this.c);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public kotlinx.coroutines.selects.e<E, BufferedChannel<E>> getOnSend() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$1, 3);
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.f(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$2, 3), null, 8, null);
    }

    private final void E() {
        if (g0()) {
            return;
        }
        d<E> dVar = (d) j.get(this);
        while (true) {
            long andIncrement = f.getAndIncrement(this);
            int i2 = BufferedChannelKt.b;
            long j2 = andIncrement / i2;
            if (V() <= andIncrement) {
                if (dVar.c < j2 && dVar.e() != 0) {
                    l0(j2, dVar);
                }
                Z(this, 0L, 1, null);
                return;
            }
            if (dVar.c != j2) {
                d<E> F = F(j2, dVar, andIncrement);
                if (F == null) {
                    continue;
                } else {
                    dVar = F;
                }
            }
            if (U0(dVar, (int) (andIncrement % i2), andIncrement)) {
                Z(this, 0L, 1, null);
                return;
            }
            Z(this, 0L, 1, null);
        }
    }

    public final boolean X() {
        while (true) {
            d<E> dVar = (d) i.get(this);
            long R = R();
            if (V() <= R) {
                return false;
            }
            int i2 = BufferedChannelKt.b;
            long j2 = R / i2;
            if (dVar.c != j2 && (dVar = G(j2, dVar)) == null) {
                if (((d) i.get(this)).c < j2) {
                    return false;
                }
            } else {
                dVar.b();
                if (b0(dVar, (int) (R % i2), R)) {
                    return true;
                }
                e.compareAndSet(this, R, 1 + R);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo1080tryReceivePtdJZtk() {
        Object obj;
        d dVar;
        f0 f0Var;
        f2 f2Var;
        f0 f0Var2;
        f0 f0Var3;
        long j2 = e.get(this);
        long j3 = d.get(this);
        if (d0(j3)) {
            return ChannelResult.Companion.a(L());
        }
        if (j2 >= (j3 & 1152921504606846975L)) {
            return ChannelResult.Companion.b();
        }
        obj = BufferedChannelKt.k;
        d dVar2 = (d) P().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = Q().getAndIncrement(this);
            int i2 = BufferedChannelKt.b;
            long j4 = andIncrement / i2;
            int i3 = (int) (andIncrement % i2);
            if (dVar2.c == j4) {
                dVar = dVar2;
            } else {
                d G = G(j4, dVar2);
                if (G == null) {
                    continue;
                } else {
                    dVar = G;
                }
            }
            Object W0 = W0(dVar, i3, andIncrement, obj);
            f0Var = BufferedChannelKt.m;
            if (W0 == f0Var) {
                if (obj instanceof f2) {
                    f2Var = (f2) obj;
                } else {
                    f2Var = null;
                }
                if (f2Var != null) {
                    v0(f2Var, dVar, i3);
                }
                c1(andIncrement);
                dVar.s();
                return ChannelResult.Companion.b();
            }
            f0Var2 = BufferedChannelKt.o;
            if (W0 == f0Var2) {
                if (andIncrement < V()) {
                    dVar.b();
                }
                dVar2 = dVar;
            } else {
                f0Var3 = BufferedChannelKt.n;
                if (W0 != f0Var3) {
                    dVar.b();
                    return ChannelResult.Companion.c(W0);
                }
                throw new IllegalStateException("unexpected".toString());
            }
        }
        return ChannelResult.Companion.a(L());
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x01e8, code lost:
    
        r3 = (kotlinx.coroutines.channels.d) r3.e();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException) {
        w(cancellationException);
    }

    private final void A(long j2) {
        H0(B(j2));
    }

    private final void I0(f2 f2Var) {
        K0(f2Var, true);
    }

    private final void J0(f2 f2Var) {
        K0(f2Var, false);
    }

    private final boolean d0(long j2) {
        return c0(j2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e0(long j2) {
        return c0(j2, false);
    }

    private final void p0(kotlinx.coroutines.selects.h<?> hVar) {
        hVar.selectInRegistrationPhase(BufferedChannelKt.z());
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        return z(th, false);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e2) {
        return Channel.a.a(this, e2);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return Channel.a.c(this, continuation);
    }

    private static final class b implements f2 {
        public final CancellableContinuation<Boolean> a;
        private final /* synthetic */ CancellableContinuationImpl<Boolean> b;

        static {
            Covode.recordClassIndex(659069);
        }

        @Override // kotlinx.coroutines.f2
        public void invokeOnCancellation(c0<?> c0Var, int i) {
            this.b.invokeOnCancellation(c0Var, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.a = cancellableContinuation;
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.b = (CancellableContinuationImpl) cancellableContinuation;
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(Throwable th) {
        return w(th);
    }

    public boolean w(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return z(th, true);
    }

    private final d<E> B(long j2) {
        d<E> y = y();
        if (f0()) {
            long h0 = h0(y);
            if (h0 != -1) {
                D(h0);
            }
        }
        x(y, j2);
        return y;
    }

    private final boolean P0(long j2) {
        if (e0(j2)) {
            return false;
        }
        return !v(j2 & 1152921504606846975L);
    }

    private final void a1(long j2) {
        long j3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = e;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            if (j3 >= j2) {
                return;
            }
        } while (!e.compareAndSet(this, j3, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(CancellableContinuation<? super ChannelResult<? extends E>> cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m773constructorimpl(ChannelResult.m1085boximpl(ChannelResult.Companion.a(L()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(CancellableContinuation<? super E> cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(O())));
    }

    private final boolean v(long j2) {
        if (j2 >= J() && j2 >= R() + this.a) {
            return false;
        }
        return true;
    }

    private final void Y(long j2) {
        boolean z;
        boolean z2;
        if ((g.addAndGet(this, j2) & 4611686018427387904L) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            do {
                if ((g.get(this) & 4611686018427387904L) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } while (z2);
        }
    }

    private final void b1(long j2) {
        long j3;
        long w;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            long j4 = 1152921504606846975L & j3;
            if (j4 >= j2) {
                return;
            } else {
                w = BufferedChannelKt.w(j4, (int) (j3 >> 60));
            }
        } while (!d.compareAndSet(this, j3, w));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        r9 = (kotlinx.coroutines.channels.d) r9.g();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long h0(kotlinx.coroutines.channels.d<E> r9) {
        /*
            r8 = this;
        L0:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3d
            long r3 = r9.c
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r8.R()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L1b
            return r1
        L1b:
            java.lang.Object r1 = r9.A(r0)
            if (r1 == 0) goto L2d
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.k()
            if (r1 != r2) goto L28
            goto L2d
        L28:
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.d
            if (r1 != r2) goto L3a
            return r3
        L2d:
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r1 = r9.u(r0, r1, r2)
            if (r1 == 0) goto L1b
            r9.s()
        L3a:
            int r0 = r0 + (-1)
            goto L4
        L3d:
            kotlinx.coroutines.internal.e r9 = r9.g()
            kotlinx.coroutines.channels.d r9 = (kotlinx.coroutines.channels.d) r9
            if (r9 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.h0(kotlinx.coroutines.channels.d):long");
    }

    protected final void D(long j2) {
        f0 f0Var;
        UndeliveredElementException d2;
        d<E> dVar = (d) i.get(this);
        while (true) {
            long j3 = e.get(this);
            if (j2 < Math.max(this.a + j3, J())) {
                return;
            }
            if (e.compareAndSet(this, j3, j3 + 1)) {
                int i2 = BufferedChannelKt.b;
                long j4 = j3 / i2;
                int i3 = (int) (j3 % i2);
                if (dVar.c != j4) {
                    d<E> G = G(j4, dVar);
                    if (G == null) {
                        continue;
                    } else {
                        dVar = G;
                    }
                }
                Object W0 = W0(dVar, i3, j3, null);
                f0Var = BufferedChannelKt.o;
                if (W0 == f0Var) {
                    if (j3 < V()) {
                        dVar.b();
                    }
                } else {
                    dVar.b();
                    Function1<E, Unit> function1 = this.b;
                    if (function1 != null && (d2 = OnUndeliveredElementKt.d(function1, W0, null, 2, null)) != null) {
                        throw d2;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        f0 f0Var;
        f0 f0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        f0 f0Var3;
        f0 f0Var4;
        if (androidx.concurrent.futures.a.a(l, this, (Object) null, function1)) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = l;
        do {
            Object obj = atomicReferenceFieldUpdater2.get(this);
            f0Var = BufferedChannelKt.q;
            if (obj == f0Var) {
                atomicReferenceFieldUpdater = l;
                f0Var3 = BufferedChannelKt.q;
                f0Var4 = BufferedChannelKt.r;
            } else {
                f0Var2 = BufferedChannelKt.r;
                if (obj == f0Var2) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, f0Var3, f0Var4));
        function1.invoke(L());
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00b4, code lost:
    
        r13 = (kotlinx.coroutines.channels.d) r13.g();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void H0(kotlinx.coroutines.channels.d<E> r13) {
        /*
            r12 = this;
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r0 = r12.b
            r1 = 0
            r2 = 1
            java.lang.Object r3 = kotlinx.coroutines.internal.n.b(r1, r2, r1)
        L8:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.b
            int r4 = r4 - r2
        Lb:
            r5 = -1
            if (r5 >= r4) goto Lb4
            long r6 = r13.c
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L17:
            java.lang.Object r8 = r13.A(r4)
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.f()
            if (r8 == r9) goto Lbc
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.d
            if (r8 != r9) goto L49
            long r9 = r12.R()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto Lbc
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r13.u(r4, r8, r9)
            if (r8 == 0) goto L17
            if (r0 == 0) goto L41
            java.lang.Object r5 = r13.z(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.c(r0, r5, r1)
        L41:
            r13.v(r4)
            r13.s()
            goto Lb0
        L49:
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.k()
            if (r8 == r9) goto La3
            if (r8 != 0) goto L52
            goto La3
        L52:
            boolean r9 = r8 instanceof kotlinx.coroutines.f2
            if (r9 != 0) goto L6f
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.j
            if (r9 == 0) goto L5b
            goto L6f
        L5b:
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r8 == r9) goto Lbc
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.q()
            if (r8 != r9) goto L68
            goto Lbc
        L68:
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r8 == r9) goto L17
            goto Lb0
        L6f:
            long r9 = r12.R()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto Lbc
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.j
            if (r9 == 0) goto L81
            r9 = r8
            kotlinx.coroutines.channels.j r9 = (kotlinx.coroutines.channels.j) r9
            kotlinx.coroutines.f2 r9 = r9.a
            goto L84
        L81:
            r9 = r8
            kotlinx.coroutines.f2 r9 = (kotlinx.coroutines.f2) r9
        L84:
            kotlinx.coroutines.internal.f0 r10 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r13.u(r4, r8, r10)
            if (r8 == 0) goto L17
            if (r0 == 0) goto L98
            java.lang.Object r5 = r13.z(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.c(r0, r5, r1)
        L98:
            java.lang.Object r3 = kotlinx.coroutines.internal.n.c(r3, r9)
            r13.v(r4)
            r13.s()
            goto Lb0
        La3:
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r13.u(r4, r8, r9)
            if (r8 == 0) goto L17
            r13.s()
        Lb0:
            int r4 = r4 + (-1)
            goto Lb
        Lb4:
            kotlinx.coroutines.internal.e r13 = r13.g()
            kotlinx.coroutines.channels.d r13 = (kotlinx.coroutines.channels.d) r13
            if (r13 != 0) goto L8
        Lbc:
            if (r3 == 0) goto Le2
            boolean r13 = r3 instanceof java.util.ArrayList
            if (r13 != 0) goto Lc8
            kotlinx.coroutines.f2 r3 = (kotlinx.coroutines.f2) r3
            r12.J0(r3)
            goto Le2
        Lc8:
            java.lang.String r13 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r13)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r13 = r3.size()
            int r13 = r13 - r2
        Ld4:
            if (r5 >= r13) goto Le2
            java.lang.Object r0 = r3.get(r13)
            kotlinx.coroutines.f2 r0 = (kotlinx.coroutines.f2) r0
            r12.J0(r0)
            int r13 = r13 + (-1)
            goto Ld4
        Le2:
            if (r1 != 0) goto Le5
            return
        Le5:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.H0(kotlinx.coroutines.channels.d):void");
    }

    protected final Object T0(E e2) {
        d dVar;
        f2 f2Var;
        Object obj = BufferedChannelKt.d;
        d dVar2 = (d) T().get(this);
        while (true) {
            long andIncrement = U().getAndIncrement(this);
            long j2 = andIncrement & 1152921504606846975L;
            boolean e0 = e0(andIncrement);
            int i2 = BufferedChannelKt.b;
            long j3 = j2 / i2;
            int i3 = (int) (j2 % i2);
            if (dVar2.c == j3) {
                dVar = dVar2;
            } else {
                d H = H(j3, dVar2);
                if (H == null) {
                    if (e0) {
                        return ChannelResult.Companion.a(S());
                    }
                } else {
                    dVar = H;
                }
            }
            int Y0 = Y0(dVar, i3, e2, j2, obj, e0);
            if (Y0 != 0) {
                if (Y0 != 1) {
                    if (Y0 != 2) {
                        if (Y0 != 3) {
                            if (Y0 != 4) {
                                if (Y0 == 5) {
                                    dVar.b();
                                }
                                dVar2 = dVar;
                            } else {
                                if (j2 < R()) {
                                    dVar.b();
                                }
                                return ChannelResult.Companion.a(S());
                            }
                        } else {
                            throw new IllegalStateException("unexpected".toString());
                        }
                    } else {
                        if (e0) {
                            dVar.s();
                            return ChannelResult.Companion.a(S());
                        }
                        if (obj instanceof f2) {
                            f2Var = (f2) obj;
                        } else {
                            f2Var = null;
                        }
                        if (f2Var != null) {
                            w0(f2Var, dVar, i3);
                        }
                        D((dVar.c * i2) + i3);
                        return ChannelResult.Companion.c(Unit.INSTANCE);
                    }
                } else {
                    return ChannelResult.Companion.c(Unit.INSTANCE);
                }
            } else {
                dVar.b();
                return ChannelResult.Companion.c(Unit.INSTANCE);
            }
        }
    }

    public final void c1(long j2) {
        int i2;
        long j3;
        long v;
        boolean z;
        long v2;
        long j4;
        long v3;
        if (g0()) {
            return;
        }
        while (J() <= j2) {
        }
        i2 = BufferedChannelKt.c;
        for (int i3 = 0; i3 < i2; i3++) {
            long J = J();
            if (J == (g.get(this) & 4611686018427387903L) && J == J()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            v = BufferedChannelKt.v(j3 & 4611686018427387903L, true);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, v));
        while (true) {
            long J2 = J();
            long j5 = g.get(this);
            long j6 = j5 & 4611686018427387903L;
            if ((4611686018427387904L & j5) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (J2 == j6 && J2 == J()) {
                break;
            }
            if (!z) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = g;
                v2 = BufferedChannelKt.v(j6, true);
                atomicLongFieldUpdater2.compareAndSet(this, j5, v2);
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater3 = g;
        do {
            j4 = atomicLongFieldUpdater3.get(this);
            v3 = BufferedChannelKt.v(j4 & 4611686018427387903L, false);
        } while (!atomicLongFieldUpdater3.compareAndSet(this, j4, v3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bd, code lost:
    
        return kotlinx.coroutines.channels.ChannelResult.Companion.c(kotlin.Unit.INSTANCE);
     */
    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo1078trySendJP2dKIU(E r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = U()
            long r0 = r0.get(r14)
            boolean r0 = r14.P0(r0)
            if (r0 == 0) goto L15
            kotlinx.coroutines.channels.ChannelResult$b r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r15 = r15.b()
            return r15
        L15:
            kotlinx.coroutines.internal.f0 r8 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f()
            java.lang.Object r0 = r0.get(r14)
            kotlinx.coroutines.channels.d r0 = (kotlinx.coroutines.channels.d) r0
        L23:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = g()
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = h(r14, r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.c
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L50
            kotlinx.coroutines.channels.d r1 = b(r14, r2, r0)
            if (r1 != 0) goto L4e
            if (r11 == 0) goto L23
            goto L90
        L4e:
            r13 = r1
            goto L51
        L50:
            r13 = r0
        L51:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = u(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lb2
            r1 = 1
            if (r0 == r1) goto Lb5
            r1 = 2
            if (r0 == r1) goto L8b
            r1 = 3
            if (r0 == r1) goto L7f
            r1 = 4
            if (r0 == r1) goto L73
            r1 = 5
            if (r0 == r1) goto L6e
            goto L71
        L6e:
            r13.b()
        L71:
            r0 = r13
            goto L23
        L73:
            long r0 = r14.R()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L90
            r13.b()
            goto L90
        L7f:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L8b:
            if (r11 == 0) goto L9b
            r13.s()
        L90:
            kotlinx.coroutines.channels.ChannelResult$b r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Throwable r0 = r14.S()
            java.lang.Object r15 = r15.a(r0)
            goto Lbd
        L9b:
            boolean r15 = r8 instanceof kotlinx.coroutines.f2
            if (r15 == 0) goto La2
            kotlinx.coroutines.f2 r8 = (kotlinx.coroutines.f2) r8
            goto La3
        La2:
            r8 = 0
        La3:
            if (r8 == 0) goto La8
            m(r14, r8, r13, r12)
        La8:
            r13.s()
            kotlinx.coroutines.channels.ChannelResult$b r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r15 = r15.b()
            goto Lbd
        Lb2:
            r13.b()
        Lb5:
            kotlinx.coroutines.channels.ChannelResult$b r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            java.lang.Object r15 = r15.c(r0)
        Lbd:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.mo1078trySendJP2dKIU(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object A0(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.z()) {
            return this;
        }
        throw S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object x0(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.z()) {
            return obj2;
        }
        throw O();
    }

    private final void q0(E e2, kotlinx.coroutines.selects.h<?> hVar) {
        Function1<E, Unit> function1 = this.b;
        if (function1 != null) {
            OnUndeliveredElementKt.b(function1, e2, hVar.getContext());
        }
        hVar.selectInRegistrationPhase(BufferedChannelKt.z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(E e2, CancellableContinuation<? super Unit> cancellableContinuation) {
        Function1<E, Unit> function1 = this.b;
        if (function1 != null) {
            OnUndeliveredElementKt.b(function1, e2, cancellableContinuation.getContext());
        }
        Throwable S = S();
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(S)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object y0(Object obj, Object obj2) {
        Object c;
        if (obj2 == BufferedChannelKt.z()) {
            c = ChannelResult.Companion.a(L());
        } else {
            c = ChannelResult.Companion.c(obj2);
        }
        return ChannelResult.m1085boximpl(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object z0(Object obj, Object obj2) {
        if (obj2 == BufferedChannelKt.z()) {
            if (L() == null) {
                return null;
            }
            throw O();
        }
        return obj2;
    }

    protected boolean z(Throwable th, boolean z) {
        f0 f0Var;
        if (z) {
            i0();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k;
        f0Var = BufferedChannelKt.s;
        boolean a2 = androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, f0Var, th);
        if (z) {
            j0();
        } else {
            k0();
        }
        C();
        m0();
        if (a2) {
            a0();
        }
        return a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.functions.Function1<? super E, kotlin.Unit>, kotlin.jvm.functions.Function1<E, kotlin.Unit>] */
    public BufferedChannel(int i2, Function1<? super E, Unit> function1) {
        boolean z;
        long A;
        Function3 function3;
        f0 f0Var;
        this.a = i2;
        this.b = function1;
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            A = BufferedChannelKt.A(i2);
            this.bufferEnd$volatile = A;
            this.completedExpandBuffersAndPauseFlag$volatile = J();
            d dVar = new d(0L, null, this, 3);
            this.sendSegment$volatile = dVar;
            this.receiveSegment$volatile = dVar;
            if (g0()) {
                dVar = BufferedChannelKt.a;
                Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment$volatile = dVar;
            if (function1 != 0) {
                function3 = new Function3<kotlinx.coroutines.selects.h<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>(this) { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1
                    final /* synthetic */ BufferedChannel<E> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Function1<Throwable, Unit> invoke(final kotlinx.coroutines.selects.h<?> hVar, Object obj, final Object obj2) {
                        final BufferedChannel<E> bufferedChannel = this.this$0;
                        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1.1
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
                                if (obj2 != BufferedChannelKt.z()) {
                                    OnUndeliveredElementKt.b(bufferedChannel.b, obj2, hVar.getContext());
                                }
                            }
                        };
                    }
                };
            } else {
                function3 = null;
            }
            this.c = function3;
            f0Var = BufferedChannelKt.s;
            this._closeCause$volatile = f0Var;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i2 + ", should be >=0").toString());
    }

    static /* synthetic */ <E> Object B0(BufferedChannel<E> bufferedChannel, Continuation<? super E> continuation) {
        d<E> dVar;
        f0 f0Var;
        f0 f0Var2;
        f0 f0Var3;
        d<E> dVar2 = (d) P().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = Q().getAndIncrement(bufferedChannel);
            int i2 = BufferedChannelKt.b;
            long j2 = andIncrement / i2;
            int i3 = (int) (andIncrement % i2);
            if (dVar2.c == j2) {
                dVar = dVar2;
            } else {
                d<E> G = bufferedChannel.G(j2, dVar2);
                if (G == null) {
                    continue;
                } else {
                    dVar = G;
                }
            }
            Object W0 = bufferedChannel.W0(dVar, i3, andIncrement, null);
            f0Var = BufferedChannelKt.m;
            if (W0 != f0Var) {
                f0Var2 = BufferedChannelKt.o;
                if (W0 == f0Var2) {
                    if (andIncrement < bufferedChannel.V()) {
                        dVar.b();
                    }
                    dVar2 = dVar;
                } else {
                    f0Var3 = BufferedChannelKt.n;
                    if (W0 == f0Var3) {
                        return bufferedChannel.E0(dVar, i3, andIncrement, continuation);
                    }
                    dVar.b();
                    return W0;
                }
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        throw e0.a(bufferedChannel.O());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(kotlinx.coroutines.selects.h<?> hVar, Object obj) {
        f0 f0Var;
        f2 f2Var;
        f0 f0Var2;
        f0 f0Var3;
        d dVar = (d) P().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = Q().getAndIncrement(this);
            int i2 = BufferedChannelKt.b;
            long j2 = andIncrement / i2;
            int i3 = (int) (andIncrement % i2);
            if (dVar.c != j2) {
                d G = G(j2, dVar);
                if (G == null) {
                    continue;
                } else {
                    dVar = G;
                }
            }
            Object W0 = W0(dVar, i3, andIncrement, hVar);
            f0Var = BufferedChannelKt.m;
            if (W0 == f0Var) {
                if (hVar instanceof f2) {
                    f2Var = (f2) hVar;
                } else {
                    f2Var = null;
                }
                if (f2Var == null) {
                    return;
                }
                v0(f2Var, dVar, i3);
                return;
            }
            f0Var2 = BufferedChannelKt.o;
            if (W0 == f0Var2) {
                if (andIncrement < V()) {
                    dVar.b();
                }
            } else {
                f0Var3 = BufferedChannelKt.n;
                if (W0 != f0Var3) {
                    dVar.b();
                    hVar.selectInRegistrationPhase(W0);
                    return;
                }
                throw new IllegalStateException("unexpected".toString());
            }
        }
        p0(hVar);
    }

    private final boolean R0(Object obj, E e2) {
        boolean B;
        boolean B2;
        if (obj instanceof kotlinx.coroutines.selects.h) {
            return ((kotlinx.coroutines.selects.h) obj).trySelect(this, e2);
        }
        Function1<Throwable, Unit> function1 = null;
        if (obj instanceof i) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            i iVar = (i) obj;
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = iVar.a;
            ChannelResult m1085boximpl = ChannelResult.m1085boximpl(ChannelResult.Companion.c(e2));
            Function1<E, Unit> function12 = this.b;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.a(function12, e2, iVar.a.getContext());
            }
            B2 = BufferedChannelKt.B(cancellableContinuationImpl, m1085boximpl, function1);
            return B2;
        }
        if (obj instanceof a) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).h(e2);
        }
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Function1<E, Unit> function13 = this.b;
            if (function13 != null) {
                function1 = OnUndeliveredElementKt.a(function13, e2, cancellableContinuation.getContext());
            }
            B = BufferedChannelKt.B(cancellableContinuation, e2, function1);
            return B;
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    private final boolean c0(long j2, boolean z) {
        int i2 = (int) (j2 >> 60);
        if (i2 == 0 || i2 == 1) {
            return false;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                A(j2 & 1152921504606846975L);
            } else {
                throw new IllegalStateException(("unexpected close status: " + i2).toString());
            }
        } else {
            B(j2 & 1152921504606846975L);
            if (z && X()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l0(long j2, d<E> dVar) {
        boolean z;
        d<E> dVar2;
        d<E> dVar3;
        while (dVar.c < j2 && (dVar3 = (d) dVar.e()) != null) {
            dVar = dVar3;
        }
        while (true) {
            if (dVar.j() && (dVar2 = (d) dVar.e()) != null) {
                dVar = dVar2;
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
                while (true) {
                    c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
                    z = true;
                    if (c0Var.c >= dVar.c) {
                        break;
                    }
                    if (!dVar.t()) {
                        z = false;
                        break;
                    } else if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c0Var, dVar)) {
                        if (c0Var.o()) {
                            c0Var.m();
                        }
                    } else if (dVar.o()) {
                        dVar.m();
                    }
                }
                if (z) {
                    return;
                }
            }
        }
    }

    private final Object r0(E e2, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        UndeliveredElementException d2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        Function1<E, Unit> function1 = this.b;
        if (function1 != null && (d2 = OnUndeliveredElementKt.d(function1, e2, null, 2, null)) != null) {
            ExceptionsKt__ExceptionsKt.addSuppressed(d2, S());
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(d2)));
        } else {
            Throwable S = S();
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(S)));
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ <E> java.lang.Object C0(kotlinx.coroutines.channels.BufferedChannel<E> r14, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r15) {
        /*
            boolean r0 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L13
            r0 = r15
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r14, r15)
        L18:
            r6 = r0
            java.lang.Object r15 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            kotlin.ResultKt.throwOnFailure(r15)
            kotlinx.coroutines.channels.ChannelResult r15 = (kotlinx.coroutines.channels.ChannelResult) r15
            java.lang.Object r14 = r15.m1097unboximpl()
            goto Lb6
        L31:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L39:
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = d()
            java.lang.Object r1 = r1.get(r14)
            kotlinx.coroutines.channels.d r1 = (kotlinx.coroutines.channels.d) r1
        L47:
            boolean r3 = r14.isClosedForReceive()
            if (r3 == 0) goto L59
            kotlinx.coroutines.channels.ChannelResult$b r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Throwable r14 = r14.L()
            java.lang.Object r14 = r15.a(r14)
            goto Lb6
        L59:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = e()
            long r4 = r3.getAndIncrement(r14)
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r7 = (long) r3
            long r7 = r4 / r7
            long r9 = (long) r3
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r1.c
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L79
            kotlinx.coroutines.channels.d r7 = a(r14, r7, r1)
            if (r7 != 0) goto L77
            goto L47
        L77:
            r13 = r7
            goto L7a
        L79:
            r13 = r1
        L7a:
            r7 = r14
            r8 = r13
            r9 = r3
            r10 = r4
            r12 = r15
            java.lang.Object r1 = t(r7, r8, r9, r10, r12)
            kotlinx.coroutines.internal.f0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.r()
            if (r1 == r7) goto Lb7
            kotlinx.coroutines.internal.f0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.h()
            if (r1 != r7) goto L9c
            long r7 = r14.V()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L9a
            r13.b()
        L9a:
            r1 = r13
            goto L47
        L9c:
            kotlinx.coroutines.internal.f0 r15 = kotlinx.coroutines.channels.BufferedChannelKt.s()
            if (r1 != r15) goto Lad
            r6.label = r2
            r1 = r14
            r2 = r13
            java.lang.Object r14 = r1.D0(r2, r3, r4, r6)
            if (r14 != r0) goto Lb6
            return r0
        Lad:
            r13.b()
            kotlinx.coroutines.channels.ChannelResult$b r14 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r14 = r14.c(r1)
        Lb6:
            return r14
        Lb7:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.C0(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d<E> G(long j2, d<E> dVar) {
        Object c;
        boolean z;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        do {
            c = kotlinx.coroutines.internal.d.c(dVar, j2, function2);
            if (!d0.c(c)) {
                c0 b2 = d0.b(c);
                while (true) {
                    c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
                    z = true;
                    if (c0Var.c >= b2.c) {
                        break;
                    }
                    if (!b2.t()) {
                        z = false;
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c0Var, b2)) {
                        if (c0Var.o()) {
                            c0Var.m();
                        }
                    } else if (b2.o()) {
                        b2.m();
                    }
                }
            } else {
                break;
            }
        } while (!z);
        if (d0.c(c)) {
            C();
            if (dVar.c * BufferedChannelKt.b >= V()) {
                return null;
            }
            dVar.b();
            return null;
        }
        d<E> dVar2 = (d) d0.b(c);
        if (!g0() && j2 <= J() / BufferedChannelKt.b) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = j;
            while (true) {
                c0 c0Var2 = (c0) atomicReferenceFieldUpdater2.get(this);
                if (c0Var2.c >= dVar2.c || !dVar2.t()) {
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, c0Var2, dVar2)) {
                    if (c0Var2.o()) {
                        c0Var2.m();
                    }
                } else if (dVar2.o()) {
                    dVar2.m();
                }
            }
        }
        long j3 = dVar2.c;
        if (j3 > j2) {
            int i2 = BufferedChannelKt.b;
            a1(j3 * i2);
            if (dVar2.c * i2 >= V()) {
                return null;
            }
            dVar2.b();
            return null;
        }
        return dVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d<E> H(long j2, d<E> dVar) {
        Object c;
        boolean z;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        do {
            c = kotlinx.coroutines.internal.d.c(dVar, j2, function2);
            if (!d0.c(c)) {
                c0 b2 = d0.b(c);
                while (true) {
                    c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
                    z = true;
                    if (c0Var.c >= b2.c) {
                        break;
                    }
                    if (!b2.t()) {
                        z = false;
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c0Var, b2)) {
                        if (c0Var.o()) {
                            c0Var.m();
                        }
                    } else if (b2.o()) {
                        b2.m();
                    }
                }
            } else {
                break;
            }
        } while (!z);
        if (d0.c(c)) {
            C();
            if (dVar.c * BufferedChannelKt.b >= R()) {
                return null;
            }
            dVar.b();
            return null;
        }
        d<E> dVar2 = (d) d0.b(c);
        long j3 = dVar2.c;
        if (j3 > j2) {
            int i2 = BufferedChannelKt.b;
            b1(j3 * i2);
            if (dVar2.c * i2 >= R()) {
                return null;
            }
            dVar2.b();
            return null;
        }
        return dVar2;
    }

    private final void K0(f2 f2Var, boolean z) {
        Throwable S;
        if (f2Var instanceof b) {
            CancellableContinuation<Boolean> cancellableContinuation = ((b) f2Var).a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m773constructorimpl(Boolean.FALSE));
            return;
        }
        if (f2Var instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) f2Var;
            Result.Companion companion2 = Result.Companion;
            if (z) {
                S = O();
            } else {
                S = S();
            }
            continuation.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(S)));
            return;
        }
        if (f2Var instanceof i) {
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((i) f2Var).a;
            Result.Companion companion3 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m773constructorimpl(ChannelResult.m1085boximpl(ChannelResult.Companion.a(L()))));
        } else if (f2Var instanceof a) {
            ((a) f2Var).i();
        } else {
            if (f2Var instanceof kotlinx.coroutines.selects.h) {
                ((kotlinx.coroutines.selects.h) f2Var).trySelect(this, BufferedChannelKt.z());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + f2Var).toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(d<E> dVar, long j2) {
        f0 f0Var;
        Object b2 = kotlinx.coroutines.internal.n.b(null, 1, null);
        loop0: while (dVar != null) {
            for (int i2 = BufferedChannelKt.b - 1; -1 < i2; i2--) {
                if ((dVar.c * BufferedChannelKt.b) + i2 < j2) {
                    break loop0;
                }
                while (true) {
                    Object A = dVar.A(i2);
                    if (A != null) {
                        f0Var = BufferedChannelKt.e;
                        if (A != f0Var) {
                            if (A instanceof j) {
                                if (dVar.u(i2, A, BufferedChannelKt.z())) {
                                    b2 = kotlinx.coroutines.internal.n.c(b2, ((j) A).a);
                                    dVar.B(i2, true);
                                    break;
                                }
                            } else {
                                if (!(A instanceof f2)) {
                                    break;
                                }
                                if (dVar.u(i2, A, BufferedChannelKt.z())) {
                                    b2 = kotlinx.coroutines.internal.n.c(b2, A);
                                    dVar.B(i2, true);
                                    break;
                                }
                            }
                        }
                    }
                    if (dVar.u(i2, A, BufferedChannelKt.z())) {
                        dVar.s();
                        break;
                    }
                }
            }
            dVar = (d) dVar.g();
        }
        if (b2 != null) {
            if (!(b2 instanceof ArrayList)) {
                I0((f2) b2);
                return;
            }
            Intrinsics.checkNotNull(b2, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) b2;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                I0((f2) arrayList.get(size));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0088, code lost:
    
        r14.selectInRegistrationPhase(kotlin.Unit.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008d, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void G0(kotlinx.coroutines.selects.h<?> r14, java.lang.Object r15) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f()
            java.lang.Object r0 = r0.get(r13)
            kotlinx.coroutines.channels.d r0 = (kotlinx.coroutines.channels.d) r0
        La:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = g()
            long r1 = r1.getAndIncrement(r13)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r3 = r3 & r1
            boolean r1 = h(r13, r1)
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r5 = (long) r2
            long r5 = r3 / r5
            long r7 = (long) r2
            long r7 = r3 % r7
            int r2 = (int) r7
            long r7 = r0.c
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 == 0) goto L35
            kotlinx.coroutines.channels.d r5 = b(r13, r5, r0)
            if (r5 != 0) goto L34
            if (r1 == 0) goto La
            goto L73
        L34:
            r0 = r5
        L35:
            r5 = r13
            r6 = r0
            r7 = r2
            r8 = r15
            r9 = r3
            r11 = r14
            r12 = r1
            int r5 = u(r5, r6, r7, r8, r9, r11, r12)
            if (r5 == 0) goto L85
            r6 = 1
            if (r5 == r6) goto L88
            r6 = 2
            if (r5 == r6) goto L6e
            r1 = 3
            if (r5 == r1) goto L62
            r1 = 4
            if (r5 == r1) goto L56
            r1 = 5
            if (r5 == r1) goto L52
            goto La
        L52:
            r0.b()
            goto La
        L56:
            long r1 = r13.R()
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 >= 0) goto L73
            r0.b()
            goto L73
        L62:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L6e:
            if (r1 == 0) goto L77
            r0.s()
        L73:
            r13.q0(r15, r14)
            goto L8d
        L77:
            boolean r15 = r14 instanceof kotlinx.coroutines.f2
            if (r15 == 0) goto L7e
            kotlinx.coroutines.f2 r14 = (kotlinx.coroutines.f2) r14
            goto L7f
        L7e:
            r14 = 0
        L7f:
            if (r14 == 0) goto L8d
            m(r13, r14, r0, r2)
            goto L8d
        L85:
            r0.b()
        L88:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            r14.selectInRegistrationPhase(r15)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.G0(kotlinx.coroutines.selects.h, java.lang.Object):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(f2 f2Var, d<E> dVar, int i2) {
        u0();
        f2Var.invokeOnCancellation(dVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(f2 f2Var, d<E> dVar, int i2) {
        f2Var.invokeOnCancellation(dVar, i2 + BufferedChannelKt.b);
    }

    private final boolean U0(d<E> dVar, int i2, long j2) {
        f0 f0Var;
        f0 f0Var2;
        Object A = dVar.A(i2);
        if ((A instanceof f2) && j2 >= e.get(this)) {
            f0Var = BufferedChannelKt.g;
            if (dVar.u(i2, A, f0Var)) {
                if (S0(A, dVar, i2)) {
                    dVar.E(i2, BufferedChannelKt.d);
                    return true;
                }
                f0Var2 = BufferedChannelKt.j;
                dVar.E(i2, f0Var2);
                dVar.B(i2, false);
                return false;
            }
        }
        return V0(dVar, i2, j2);
    }

    private final boolean S0(Object obj, d<E> dVar, int i2) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.C((CancellableContinuation) obj, Unit.INSTANCE, null, 2, null);
        }
        if (obj instanceof kotlinx.coroutines.selects.h) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailed = ((SelectImplementation) obj).trySelectDetailed(this, Unit.INSTANCE);
            if (trySelectDetailed == TrySelectDetailedResult.REREGISTER) {
                dVar.v(i2);
            }
            if (trySelectDetailed == TrySelectDetailedResult.SUCCESSFUL) {
                return true;
            }
            return false;
        }
        if (obj instanceof b) {
            return BufferedChannelKt.C(((b) obj).a, Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    private final boolean b0(d<E> dVar, int i2, long j2) {
        Object A;
        f0 f0Var;
        f0 f0Var2;
        f0 f0Var3;
        f0 f0Var4;
        f0 f0Var5;
        f0 f0Var6;
        f0 f0Var7;
        do {
            A = dVar.A(i2);
            if (A != null) {
                f0Var2 = BufferedChannelKt.e;
                if (A != f0Var2) {
                    if (A == BufferedChannelKt.d) {
                        return true;
                    }
                    f0Var3 = BufferedChannelKt.j;
                    if (A == f0Var3 || A == BufferedChannelKt.z()) {
                        return false;
                    }
                    f0Var4 = BufferedChannelKt.i;
                    if (A == f0Var4) {
                        return false;
                    }
                    f0Var5 = BufferedChannelKt.h;
                    if (A == f0Var5) {
                        return false;
                    }
                    f0Var6 = BufferedChannelKt.g;
                    if (A == f0Var6) {
                        return true;
                    }
                    f0Var7 = BufferedChannelKt.f;
                    if (A == f0Var7 || j2 != R()) {
                        return false;
                    }
                    return true;
                }
            }
            f0Var = BufferedChannelKt.h;
        } while (!dVar.u(i2, A, f0Var));
        E();
        return false;
    }

    private final d<E> F(long j2, d<E> dVar, long j3) {
        Object c;
        boolean z;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        do {
            c = kotlinx.coroutines.internal.d.c(dVar, j2, function2);
            if (d0.c(c)) {
                break;
            }
            c0 b2 = d0.b(c);
            while (true) {
                c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
                if (c0Var.c >= b2.c) {
                    break;
                }
                if (!b2.t()) {
                    z = false;
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c0Var, b2)) {
                    if (c0Var.o()) {
                        c0Var.m();
                    }
                } else if (b2.o()) {
                    b2.m();
                }
            }
            z = true;
        } while (!z);
        if (d0.c(c)) {
            C();
            l0(j2, dVar);
            Z(this, 0L, 1, null);
            return null;
        }
        d<E> dVar2 = (d) d0.b(c);
        if (dVar2.c > j2) {
            long j4 = dVar2.c;
            int i2 = BufferedChannelKt.b;
            if (f.compareAndSet(this, j3 + 1, j4 * i2)) {
                Y((dVar2.c * i2) - j3);
                return null;
            }
            Z(this, 0L, 1, null);
            return null;
        }
        return dVar2;
    }

    static /* synthetic */ <E> Object L0(BufferedChannel<E> bufferedChannel, E e2, Continuation<? super Unit> continuation) {
        d<E> dVar;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        Object coroutine_suspended4;
        d<E> dVar2 = (d) T().get(bufferedChannel);
        while (true) {
            long andIncrement = U().getAndIncrement(bufferedChannel);
            long j2 = andIncrement & 1152921504606846975L;
            boolean e0 = bufferedChannel.e0(andIncrement);
            int i2 = BufferedChannelKt.b;
            long j3 = j2 / i2;
            int i3 = (int) (j2 % i2);
            if (dVar2.c != j3) {
                d<E> H = bufferedChannel.H(j3, dVar2);
                if (H == null) {
                    if (e0) {
                        Object r0 = bufferedChannel.r0(e2, continuation);
                        coroutine_suspended4 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (r0 == coroutine_suspended4) {
                            return r0;
                        }
                    }
                } else {
                    dVar = H;
                }
            } else {
                dVar = dVar2;
            }
            int Y0 = bufferedChannel.Y0(dVar, i3, e2, j2, null, e0);
            if (Y0 != 0) {
                if (Y0 == 1) {
                    break;
                }
                if (Y0 != 2) {
                    if (Y0 != 3) {
                        if (Y0 != 4) {
                            if (Y0 == 5) {
                                dVar.b();
                            }
                            dVar2 = dVar;
                        } else {
                            if (j2 < bufferedChannel.R()) {
                                dVar.b();
                            }
                            Object r02 = bufferedChannel.r0(e2, continuation);
                            coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (r02 == coroutine_suspended3) {
                                return r02;
                            }
                        }
                    } else {
                        Object O0 = bufferedChannel.O0(dVar, i3, e2, j2, continuation);
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (O0 == coroutine_suspended2) {
                            return O0;
                        }
                    }
                } else if (e0) {
                    dVar.s();
                    Object r03 = bufferedChannel.r0(e2, continuation);
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (r03 == coroutine_suspended) {
                        return r03;
                    }
                }
            } else {
                dVar.b();
                break;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b6, code lost:
    
        r0 = kotlin.Result.Companion;
        r9.resumeWith(kotlin.Result.m773constructorimpl(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ <E> java.lang.Object N0(kotlinx.coroutines.channels.BufferedChannel<E> r18, E r19, kotlin.coroutines.Continuation<? super java.lang.Boolean> r20) {
        /*
            r8 = r18
            kotlinx.coroutines.CancellableContinuationImpl r9 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r20)
            r10 = 1
            r9.<init>(r0, r10)
            r9.initCancellability()
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r0 = r8.b
            r11 = 0
            if (r0 != 0) goto L16
            r0 = 1
            goto L17
        L16:
            r0 = 0
        L17:
            if (r0 == 0) goto Ld1
            kotlinx.coroutines.channels.BufferedChannel$b r12 = new kotlinx.coroutines.channels.BufferedChannel$b
            r12.<init>(r9)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f()
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.channels.d r0 = (kotlinx.coroutines.channels.d) r0
        L28:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = g()
            long r1 = r1.getAndIncrement(r8)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r13 = r1 & r3
            boolean r15 = h(r8, r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r2 = (long) r1
            long r2 = r13 / r2
            long r4 = (long) r1
            long r4 = r13 % r4
            int r7 = (int) r4
            long r4 = r0.c
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L55
            kotlinx.coroutines.channels.d r1 = b(r8, r2, r0)
            if (r1 != 0) goto L53
            if (r15 == 0) goto L28
            goto L9b
        L53:
            r6 = r1
            goto L56
        L55:
            r6 = r0
        L56:
            r0 = r18
            r1 = r6
            r2 = r7
            r3 = r19
            r4 = r13
            r16 = r6
            r6 = r12
            r17 = r7
            r7 = r15
            int r0 = u(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lb1
            if (r0 == r10) goto Lb6
            r1 = 2
            if (r0 == r1) goto L96
            r1 = 3
            if (r0 == r1) goto L8a
            r1 = 4
            if (r0 == r1) goto L7e
            r1 = 5
            if (r0 == r1) goto L78
            goto L7b
        L78:
            r16.b()
        L7b:
            r0 = r16
            goto L28
        L7e:
            long r0 = r18.R()
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 >= 0) goto L9b
            r16.b()
            goto L9b
        L8a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L96:
            if (r15 == 0) goto La9
            r16.s()
        L9b:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            java.lang.Object r0 = kotlin.Result.m773constructorimpl(r0)
            r9.resumeWith(r0)
            goto Lc3
        La9:
            r1 = r16
            r0 = r17
            m(r8, r12, r1, r0)
            goto Lc3
        Lb1:
            r1 = r16
            r1.b()
        Lb6:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            java.lang.Object r0 = kotlin.Result.m773constructorimpl(r0)
            r9.resumeWith(r0)
        Lc3:
            java.lang.Object r0 = r9.getResult()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto Ld0
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r20)
        Ld0:
            return r0
        Ld1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.N0(kotlinx.coroutines.channels.BufferedChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean V0(d<E> dVar, int i2, long j2) {
        f0 f0Var;
        f0 f0Var2;
        f0 f0Var3;
        f0 f0Var4;
        f0 f0Var5;
        f0 f0Var6;
        f0 f0Var7;
        f0 f0Var8;
        while (true) {
            Object A = dVar.A(i2);
            if (A instanceof f2) {
                if (j2 < e.get(this)) {
                    if (dVar.u(i2, A, new j((f2) A))) {
                        return true;
                    }
                } else {
                    f0Var = BufferedChannelKt.g;
                    if (dVar.u(i2, A, f0Var)) {
                        if (S0(A, dVar, i2)) {
                            dVar.E(i2, BufferedChannelKt.d);
                            return true;
                        }
                        f0Var2 = BufferedChannelKt.j;
                        dVar.E(i2, f0Var2);
                        dVar.B(i2, false);
                        return false;
                    }
                }
            } else {
                f0Var3 = BufferedChannelKt.j;
                if (A == f0Var3) {
                    return false;
                }
                if (A == null) {
                    f0Var4 = BufferedChannelKt.e;
                    if (dVar.u(i2, A, f0Var4)) {
                        return true;
                    }
                } else {
                    if (A == BufferedChannelKt.d) {
                        return true;
                    }
                    f0Var5 = BufferedChannelKt.h;
                    if (A == f0Var5) {
                        break;
                    }
                    f0Var6 = BufferedChannelKt.i;
                    if (A == f0Var6) {
                        break;
                    }
                    f0Var7 = BufferedChannelKt.k;
                    if (A == f0Var7 || A == BufferedChannelKt.z()) {
                        return true;
                    }
                    f0Var8 = BufferedChannelKt.f;
                    if (A != f0Var8) {
                        throw new IllegalStateException(("Unexpected cell state: " + A).toString());
                    }
                }
            }
        }
    }

    public /* synthetic */ BufferedChannel(int i2, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? null : function1);
    }

    static /* synthetic */ void Z(BufferedChannel bufferedChannel, long j2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                j2 = 1;
            }
            bufferedChannel.Y(j2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object W0(d<E> dVar, int i2, long j2, Object obj) {
        f0 f0Var;
        f0 f0Var2;
        f0 f0Var3;
        Object A = dVar.A(i2);
        if (A == null) {
            if (j2 >= (d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    f0Var3 = BufferedChannelKt.n;
                    return f0Var3;
                }
                if (dVar.u(i2, A, obj)) {
                    E();
                    f0Var2 = BufferedChannelKt.m;
                    return f0Var2;
                }
            }
        } else if (A == BufferedChannelKt.d) {
            f0Var = BufferedChannelKt.i;
            if (dVar.u(i2, A, f0Var)) {
                E();
                return dVar.C(i2);
            }
        }
        return X0(dVar, i2, j2, obj);
    }

    private final Object E0(d<E> dVar, int i2, long j2, Continuation<? super E> continuation) {
        Continuation intercepted;
        f0 f0Var;
        f0 f0Var2;
        f0 f0Var3;
        f0 f0Var4;
        f0 f0Var5;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl b2 = n.b(intercepted);
        try {
            Object W0 = W0(dVar, i2, j2, b2);
            f0Var = BufferedChannelKt.m;
            if (W0 == f0Var) {
                v0(b2, dVar, i2);
            } else {
                f0Var2 = BufferedChannelKt.o;
                Function1<Throwable, Unit> function1 = null;
                function1 = null;
                CancellableContinuationImpl cancellableContinuationImpl = null;
                if (W0 == f0Var2) {
                    if (j2 < V()) {
                        dVar.b();
                    }
                    d dVar2 = (d) P().get(this);
                    while (true) {
                        if (isClosedForReceive()) {
                            o0(b2);
                            break;
                        }
                        long andIncrement = Q().getAndIncrement(this);
                        int i3 = BufferedChannelKt.b;
                        long j3 = andIncrement / i3;
                        int i4 = (int) (andIncrement % i3);
                        if (dVar2.c != j3) {
                            d G = G(j3, dVar2);
                            if (G != null) {
                                dVar2 = G;
                            }
                        }
                        W0 = W0(dVar2, i4, andIncrement, b2);
                        f0Var3 = BufferedChannelKt.m;
                        if (W0 == f0Var3) {
                            if (b2 instanceof f2) {
                                cancellableContinuationImpl = b2;
                            }
                            if (cancellableContinuationImpl != null) {
                                v0(cancellableContinuationImpl, dVar2, i4);
                            }
                        } else {
                            f0Var4 = BufferedChannelKt.o;
                            if (W0 == f0Var4) {
                                if (andIncrement < V()) {
                                    dVar2.b();
                                }
                            } else {
                                f0Var5 = BufferedChannelKt.n;
                                if (W0 != f0Var5) {
                                    dVar2.b();
                                    Function1<E, Unit> function12 = this.b;
                                    if (function12 != null) {
                                        function1 = OnUndeliveredElementKt.a(function12, W0, b2.getContext());
                                    }
                                } else {
                                    throw new IllegalStateException("unexpected".toString());
                                }
                            }
                        }
                    }
                } else {
                    dVar.b();
                    Function1<E, Unit> function13 = this.b;
                    if (function13 != null) {
                        function1 = OnUndeliveredElementKt.a(function13, W0, b2.getContext());
                    }
                }
                b2.resume(W0, function1);
            }
            Object result = b2.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } catch (Throwable th) {
            b2.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    private final Object X0(d<E> dVar, int i2, long j2, Object obj) {
        f0 f0Var;
        f0 f0Var2;
        f0 f0Var3;
        f0 f0Var4;
        f0 f0Var5;
        f0 f0Var6;
        f0 f0Var7;
        f0 f0Var8;
        f0 f0Var9;
        f0 f0Var10;
        f0 f0Var11;
        f0 f0Var12;
        f0 f0Var13;
        f0 f0Var14;
        f0 f0Var15;
        f0 f0Var16;
        while (true) {
            Object A = dVar.A(i2);
            if (A != null) {
                f0Var5 = BufferedChannelKt.e;
                if (A != f0Var5) {
                    if (A == BufferedChannelKt.d) {
                        f0Var6 = BufferedChannelKt.i;
                        if (dVar.u(i2, A, f0Var6)) {
                            E();
                            return dVar.C(i2);
                        }
                    } else {
                        f0Var7 = BufferedChannelKt.j;
                        if (A == f0Var7) {
                            f0Var8 = BufferedChannelKt.o;
                            return f0Var8;
                        }
                        f0Var9 = BufferedChannelKt.h;
                        if (A == f0Var9) {
                            f0Var10 = BufferedChannelKt.o;
                            return f0Var10;
                        }
                        if (A == BufferedChannelKt.z()) {
                            E();
                            f0Var11 = BufferedChannelKt.o;
                            return f0Var11;
                        }
                        f0Var12 = BufferedChannelKt.g;
                        if (A != f0Var12) {
                            f0Var13 = BufferedChannelKt.f;
                            if (dVar.u(i2, A, f0Var13)) {
                                boolean z = A instanceof j;
                                if (z) {
                                    A = ((j) A).a;
                                }
                                if (S0(A, dVar, i2)) {
                                    f0Var16 = BufferedChannelKt.i;
                                    dVar.E(i2, f0Var16);
                                    E();
                                    return dVar.C(i2);
                                }
                                f0Var14 = BufferedChannelKt.j;
                                dVar.E(i2, f0Var14);
                                dVar.B(i2, false);
                                if (z) {
                                    E();
                                }
                                f0Var15 = BufferedChannelKt.o;
                                return f0Var15;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (j2 < (d.get(this) & 1152921504606846975L)) {
                f0Var = BufferedChannelKt.h;
                if (dVar.u(i2, A, f0Var)) {
                    E();
                    f0Var2 = BufferedChannelKt.o;
                    return f0Var2;
                }
            } else {
                if (obj == null) {
                    f0Var3 = BufferedChannelKt.n;
                    return f0Var3;
                }
                if (dVar.u(i2, A, obj)) {
                    E();
                    f0Var4 = BufferedChannelKt.m;
                    return f0Var4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D0(kotlinx.coroutines.channels.d<E> r11, int r12, long r13, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r15) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.D0(kotlinx.coroutines.channels.d, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0122 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object O0(kotlinx.coroutines.channels.d<E> r21, int r22, E r23, long r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.O0(kotlinx.coroutines.channels.d, int, java.lang.Object, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Y0(d<E> dVar, int i2, E e2, long j2, Object obj, boolean z) {
        f0 f0Var;
        f0 f0Var2;
        f0 f0Var3;
        dVar.F(i2, e2);
        if (z) {
            return Z0(dVar, i2, e2, j2, obj, z);
        }
        Object A = dVar.A(i2);
        if (A == null) {
            if (v(j2)) {
                if (dVar.u(i2, null, BufferedChannelKt.d)) {
                    return 1;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (dVar.u(i2, null, obj)) {
                    return 2;
                }
            }
        } else if (A instanceof f2) {
            dVar.v(i2);
            if (R0(A, e2)) {
                f0Var3 = BufferedChannelKt.i;
                dVar.E(i2, f0Var3);
                t0();
                return 0;
            }
            f0Var = BufferedChannelKt.k;
            Object w = dVar.w(i2, f0Var);
            f0Var2 = BufferedChannelKt.k;
            if (w != f0Var2) {
                dVar.B(i2, true);
            }
            return 5;
        }
        return Z0(dVar, i2, e2, j2, obj, z);
    }

    private final int Z0(d<E> dVar, int i2, E e2, long j2, Object obj, boolean z) {
        f0 f0Var;
        f0 f0Var2;
        f0 f0Var3;
        f0 f0Var4;
        f0 f0Var5;
        f0 f0Var6;
        f0 f0Var7;
        while (true) {
            Object A = dVar.A(i2);
            if (A == null) {
                if (v(j2) && !z) {
                    if (dVar.u(i2, null, BufferedChannelKt.d)) {
                        return 1;
                    }
                } else if (z) {
                    f0Var = BufferedChannelKt.j;
                    if (dVar.u(i2, null, f0Var)) {
                        dVar.B(i2, false);
                        return 4;
                    }
                } else {
                    if (obj == null) {
                        return 3;
                    }
                    if (dVar.u(i2, null, obj)) {
                        return 2;
                    }
                }
            } else {
                f0Var2 = BufferedChannelKt.e;
                if (A == f0Var2) {
                    if (dVar.u(i2, A, BufferedChannelKt.d)) {
                        return 1;
                    }
                } else {
                    f0Var3 = BufferedChannelKt.k;
                    if (A == f0Var3) {
                        dVar.v(i2);
                        return 5;
                    }
                    f0Var4 = BufferedChannelKt.h;
                    if (A == f0Var4) {
                        dVar.v(i2);
                        return 5;
                    }
                    if (A == BufferedChannelKt.z()) {
                        dVar.v(i2);
                        C();
                        return 4;
                    }
                    dVar.v(i2);
                    if (A instanceof j) {
                        A = ((j) A).a;
                    }
                    if (R0(A, e2)) {
                        f0Var7 = BufferedChannelKt.i;
                        dVar.E(i2, f0Var7);
                        t0();
                        return 0;
                    }
                    f0Var5 = BufferedChannelKt.k;
                    Object w = dVar.w(i2, f0Var5);
                    f0Var6 = BufferedChannelKt.k;
                    if (w != f0Var6) {
                        dVar.B(i2, true);
                    }
                    return 5;
                }
            }
        }
    }
}
