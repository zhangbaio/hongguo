package kotlinx.coroutines.reactive;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.i;
import kotlinx.coroutines.selects.e;
import kotlinx.coroutines.selects.f;
import kotlinx.coroutines.selects.h;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.z;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class PublisherCoroutine<T> extends kotlinx.coroutines.a<Unit> implements ProducerScope<T>, Subscription {
    private static final /* synthetic */ AtomicLongFieldUpdater g;
    private volatile /* synthetic */ long _nRequested$volatile;
    private volatile boolean cancelled;
    private final Subscriber<T> d;
    private final Function2<Throwable, CoroutineContext, Unit> e;
    private final Mutex f;

    static {
        Covode.recordClassIndex(659292);
        g = AtomicLongFieldUpdater.newUpdater(PublisherCoroutine.class, "_nRequested$volatile");
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public SendChannel<T> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public void cancel() {
        this.cancelled = true;
        super.cancel((CancellationException) null);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return !isActive();
    }

    private final void U0() {
        Mutex.DefaultImpls.unlock$default(this.f, null, 1, null);
        if (isCompleted() && Mutex.DefaultImpls.tryLock$default(this.f, null, 1, null)) {
            N0(G(), H());
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public e<T, SendChannel<T>> getOnSend() {
        PublisherCoroutine$onSend$1 publisherCoroutine$onSend$1 = PublisherCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(publisherCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(publisherCoroutine$onSend$1, 3);
        PublisherCoroutine$onSend$2 publisherCoroutine$onSend$2 = PublisherCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(publisherCoroutine$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new f(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(publisherCoroutine$onSend$2, 3), null, 8, null);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public Void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        throw new UnsupportedOperationException("PublisherCoroutine doesn't support invokeOnClose");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public void H0(Unit unit) {
        T0(null, false);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        return s(th);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(T t) {
        return ProducerScope.a.a(this, t);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo1078trySendJP2dKIU(T t) {
        if (!Mutex.DefaultImpls.tryLock$default(this.f, null, 1, null)) {
            return ChannelResult.Companion.b();
        }
        Throwable M0 = M0(t);
        if (M0 == null) {
            return ChannelResult.Companion.c(Unit.INSTANCE);
        }
        return ChannelResult.Companion.a(M0);
    }

    private final Throwable M0(T t) {
        if (t != null) {
            if (!isActive()) {
                U0();
                return getCancellationException();
            }
            try {
                this.d.onNext(t);
                while (true) {
                    long j = g.get(this);
                    if (j < 0 || j == Long.MAX_VALUE) {
                        break;
                    }
                    long j2 = j - 1;
                    if (g.compareAndSet(this, j, j2)) {
                        if (j2 == 0) {
                            return null;
                        }
                    }
                }
                U0();
                return null;
            } catch (Throwable th) {
                this.cancelled = true;
                boolean close = close(th);
                U0();
                if (!close) {
                    this.e.invoke(th, getContext());
                    return getCancellationException();
                }
                return th;
            }
        }
        U0();
        throw new NullPointerException("Attempted to emit `null` inside a reactive publisher");
    }

    public void request(long j) {
        long j2;
        long j3;
        if (j <= 0) {
            s(new IllegalArgumentException("non-positive subscription request " + j));
            return;
        }
        do {
            j2 = g.get(this);
            if (j2 < 0) {
                return;
            }
            long j4 = j2 + j;
            j3 = Long.MAX_VALUE;
            if (j4 >= 0 && j != Long.MAX_VALUE) {
                j3 = j4;
            }
            if (j2 == j3) {
                return;
            }
        } while (!g.compareAndSet(this, j2, j3));
        if (j2 == 0) {
            U0();
        }
    }

    @Override // kotlinx.coroutines.a
    protected void G0(Throwable th, boolean z) {
        T0(th, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object R0(Object obj, Object obj2) {
        Throwable M0 = M0(obj);
        if (M0 == null) {
            return this;
        }
        throw M0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(h<?> hVar, Object obj) {
        if (Mutex.DefaultImpls.tryLock$default(this.f, null, 1, null)) {
            hVar.selectInRegistrationPhase(Unit.INSTANCE);
        } else {
            i.e(this, null, null, new PublisherCoroutine$registerSelectForSend$1(this, hVar, null), 3, null);
        }
    }

    private final void N0(Throwable th, boolean z) {
        if (g.get(this) != -2) {
            g.set(this, -2L);
            if (this.cancelled) {
                if (th != null && !z) {
                    this.e.invoke(th, getContext());
                }
            } else {
                if (th == null) {
                    try {
                        this.d.onComplete();
                    } catch (Throwable th2) {
                        z.a(getContext(), th2);
                    }
                    return;
                } else {
                    try {
                        this.d.onError(th);
                    } catch (Throwable th3) {
                        if (th3 != th) {
                            ExceptionsKt__ExceptionsKt.addSuppressed(th, th3);
                        }
                        z.a(getContext(), th);
                    }
                    return;
                }
                Mutex.DefaultImpls.unlock$default(this.f, null, 1, null);
            }
        }
    }

    private final void T0(Throwable th, boolean z) {
        long j;
        boolean z2;
        do {
            j = g.get(this);
            if (j == -2) {
                return;
            }
            if (j >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalStateException("Check failed.".toString());
            }
        } while (!g.compareAndSet(this, j, -1L));
        if (j == 0) {
            N0(th, z);
        } else if (Mutex.DefaultImpls.tryLock$default(this.f, null, 1, null)) {
            N0(th, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object send(T r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.reactive.PublisherCoroutine$send$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.reactive.PublisherCoroutine$send$1 r0 = (kotlinx.coroutines.reactive.PublisherCoroutine$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.reactive.PublisherCoroutine$send$1 r0 = new kotlinx.coroutines.reactive.PublisherCoroutine$send$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.reactive.PublisherCoroutine r0 = (kotlinx.coroutines.reactive.PublisherCoroutine) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4b
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r4.f
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            r2 = 0
            java.lang.Object r6 = kotlinx.coroutines.sync.Mutex.DefaultImpls.lock$default(r6, r2, r0, r3, r2)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r0 = r4
        L4b:
            java.lang.Throwable r5 = r0.M0(r5)
            if (r5 != 0) goto L54
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L54:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.PublisherCoroutine.send(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
