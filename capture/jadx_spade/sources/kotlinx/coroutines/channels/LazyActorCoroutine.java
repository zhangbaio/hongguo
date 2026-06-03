package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class LazyActorCoroutine<E> extends a<E> {
    private Continuation<? super Unit> e;

    static {
        Covode.recordClassIndex(659091);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void n0() {
        ym6.a.b(this.e, this);
    }

    @Override // kotlinx.coroutines.channels.b, kotlinx.coroutines.channels.SendChannel
    public kotlinx.coroutines.selects.e<E, SendChannel<E>> getOnSend() {
        LazyActorCoroutine$onSend$1 lazyActorCoroutine$onSend$1 = LazyActorCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(lazyActorCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.f(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(lazyActorCoroutine$onSend$1, 3), super.getOnSend().getProcessResFunc(), null, 8, null);
    }

    @Override // kotlinx.coroutines.channels.b, kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        boolean close = super.close(th);
        start();
        return close;
    }

    @Override // kotlinx.coroutines.channels.b, kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e) {
        start();
        return super.offer(e);
    }

    @Override // kotlinx.coroutines.channels.b, kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo1078trySendJP2dKIU(E e) {
        start();
        return super.mo1078trySendJP2dKIU(e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0(kotlinx.coroutines.selects.h<?> hVar, Object obj) {
        n0();
        super.getOnSend().getRegFunc().invoke(this, hVar, obj);
    }

    @Override // kotlinx.coroutines.channels.b, kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        start();
        Object send = super.send(e, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (send == coroutine_suspended) {
            return send;
        }
        return Unit.INSTANCE;
    }
}
