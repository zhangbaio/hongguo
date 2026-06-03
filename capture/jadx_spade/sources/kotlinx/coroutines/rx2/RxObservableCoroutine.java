package kotlinx.coroutines.rx2;

import com.bytedance.covode.number.Covode;
import io.reactivex.ObservableEmitter;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.i;
import kotlinx.coroutines.selects.h;
import kotlinx.coroutines.sync.Mutex;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class RxObservableCoroutine<T> extends kotlinx.coroutines.a<Unit> implements ProducerScope<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater f;
    private volatile /* synthetic */ int _signal$volatile;
    private final ObservableEmitter<T> d;
    private final Mutex e;

    static {
        Covode.recordClassIndex(659309);
        f = AtomicIntegerFieldUpdater.newUpdater(RxObservableCoroutine.class, "_signal$volatile");
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public SendChannel<T> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return !isActive();
    }

    private final void U0() {
        Mutex.DefaultImpls.unlock$default(this.e, null, 1, null);
        if (!isActive() && Mutex.DefaultImpls.tryLock$default(this.e, null, 1, null)) {
            N0(G(), H());
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public kotlinx.coroutines.selects.e<T, SendChannel<T>> getOnSend() {
        RxObservableCoroutine$onSend$1 rxObservableCoroutine$onSend$1 = RxObservableCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(rxObservableCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(rxObservableCoroutine$onSend$1, 3);
        RxObservableCoroutine$onSend$2 rxObservableCoroutine$onSend$2 = RxObservableCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(rxObservableCoroutine$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.f(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(rxObservableCoroutine$onSend$2, 3), null, 8, null);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public Void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        throw new UnsupportedOperationException("RxObservableCoroutine doesn't support invokeOnClose");
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

    private final Throwable M0(T t) {
        if (!isActive()) {
            N0(G(), H());
            return getCancellationException();
        }
        try {
            this.d.onNext(t);
            U0();
            return null;
        } catch (Throwable th) {
            UndeliverableException undeliverableException = new UndeliverableException(th);
            boolean close = close(undeliverableException);
            U0();
            if (!close) {
                b.a(undeliverableException, getContext());
                return getCancellationException();
            }
            return undeliverableException;
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo1078trySendJP2dKIU(T t) {
        if (!Mutex.DefaultImpls.tryLock$default(this.e, null, 1, null)) {
            return ChannelResult.Companion.b();
        }
        Throwable M0 = M0(t);
        if (M0 == null) {
            return ChannelResult.Companion.c(Unit.INSTANCE);
        }
        return ChannelResult.Companion.a(M0);
    }

    @Override // kotlinx.coroutines.a
    protected void G0(Throwable th, boolean z) {
        T0(th, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object R0(Object obj, Object obj2) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlinx.coroutines.rx2.RxObservableCoroutine");
        Throwable M0 = M0(obj);
        if (M0 == null) {
            return this;
        }
        throw M0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(h<?> hVar, Object obj) {
        if (Mutex.DefaultImpls.tryLock$default(this.e, null, 1, null)) {
            hVar.selectInRegistrationPhase(Unit.INSTANCE);
        } else {
            i.e(this, null, null, new RxObservableCoroutine$registerSelectForSend$1(this, hVar, null), 3, null);
        }
    }

    private final void T0(Throwable th, boolean z) {
        if (f.compareAndSet(this, 0, -1) && Mutex.DefaultImpls.tryLock$default(this.e, null, 1, null)) {
            N0(th, z);
        }
    }

    private final void N0(Throwable th, boolean z) {
        Throwable th2;
        try {
        } finally {
            Mutex.DefaultImpls.unlock$default(this.e, null, 1, null);
        }
        if (f.get(this) == -2) {
            return;
        }
        f.set(this, -2);
        if (th != null) {
            th2 = th;
        } else {
            th2 = null;
        }
        if (th2 == null) {
            try {
                this.d.onComplete();
            } catch (Exception e) {
                b.a(e, getContext());
            }
            return;
        }
        if ((th2 instanceof UndeliverableException) && !z) {
            b.a(th, getContext());
        } else if (th2 != getCancellationException() || !this.d.isDisposed()) {
            try {
                this.d.onError(th);
            } catch (Exception e2) {
                ExceptionsKt__ExceptionsKt.addSuppressed(th, e2);
                b.a(th, getContext());
            }
        }
        return;
        Mutex.DefaultImpls.unlock$default(this.e, null, 1, null);
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
            boolean r0 = r6 instanceof kotlinx.coroutines.rx2.RxObservableCoroutine$send$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.rx2.RxObservableCoroutine$send$1 r0 = (kotlinx.coroutines.rx2.RxObservableCoroutine$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.rx2.RxObservableCoroutine$send$1 r0 = new kotlinx.coroutines.rx2.RxObservableCoroutine$send$1
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
            kotlinx.coroutines.rx2.RxObservableCoroutine r0 = (kotlinx.coroutines.rx2.RxObservableCoroutine) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4b
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r4.e
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxObservableCoroutine.send(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
