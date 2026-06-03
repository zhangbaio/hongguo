package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class g<E> extends BufferedChannel<E> {
    private final int m;
    private final BufferOverflow n;

    static {
        Covode.recordClassIndex(659090);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public Object M0(E e, Continuation<? super Boolean> continuation) {
        return e1(this, e, continuation);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean Q0() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        return d1(this, e, continuation);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected boolean f0() {
        if (this.n == BufferOverflow.DROP_OLDEST) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo1078trySendJP2dKIU(E e) {
        return g1(e, false);
    }

    private final Object g1(E e, boolean z) {
        if (this.n == BufferOverflow.DROP_LATEST) {
            return f1(e, z);
        }
        return T0(e);
    }

    private final Object f1(E e, boolean z) {
        Function1<E, Unit> function1;
        UndeliveredElementException d;
        Object mo1078trySendJP2dKIU = super.mo1078trySendJP2dKIU(e);
        if (!ChannelResult.m1095isSuccessimpl(mo1078trySendJP2dKIU) && !ChannelResult.m1093isClosedimpl(mo1078trySendJP2dKIU)) {
            if (z && (function1 = this.b) != null && (d = OnUndeliveredElementKt.d(function1, e, null, 2, null)) != null) {
                throw d;
            }
            return ChannelResult.Companion.c(Unit.INSTANCE);
        }
        return mo1078trySendJP2dKIU;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void G0(kotlinx.coroutines.selects.h<?> hVar, Object obj) {
        Object mo1078trySendJP2dKIU = mo1078trySendJP2dKIU(obj);
        if (!(mo1078trySendJP2dKIU instanceof ChannelResult.c)) {
            hVar.selectInRegistrationPhase(Unit.INSTANCE);
        } else {
            if (mo1078trySendJP2dKIU instanceof ChannelResult.a) {
                ChannelResult.m1089exceptionOrNullimpl(mo1078trySendJP2dKIU);
                hVar.selectInRegistrationPhase(BufferedChannelKt.z());
                return;
            }
            throw new IllegalStateException("unreachable".toString());
        }
    }

    static /* synthetic */ <E> Object e1(g<E> gVar, E e, Continuation<? super Boolean> continuation) {
        Object g1 = gVar.g1(e, true);
        if (!(g1 instanceof ChannelResult.c)) {
            return Boxing.boxBoolean(true);
        }
        return Boxing.boxBoolean(false);
    }

    static /* synthetic */ <E> Object d1(g<E> gVar, E e, Continuation<? super Unit> continuation) {
        UndeliveredElementException d;
        Object g1 = gVar.g1(e, true);
        if (g1 instanceof ChannelResult.a) {
            ChannelResult.m1089exceptionOrNullimpl(g1);
            Function1<E, Unit> function1 = gVar.b;
            if (function1 != null && (d = OnUndeliveredElementKt.d(function1, e, null, 2, null)) != null) {
                ExceptionsKt__ExceptionsKt.addSuppressed(d, gVar.S());
                throw d;
            }
            throw gVar.S();
        }
        return Unit.INSTANCE;
    }

    public g(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(i, function1);
        boolean z;
        this.m = i;
        this.n = bufferOverflow;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i >= 1) {
                return;
            }
            throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i + " was specified").toString());
        }
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
    }

    public /* synthetic */ g(int i, BufferOverflow bufferOverflow, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bufferOverflow, (i2 & 4) != 0 ? null : function1);
    }
}
