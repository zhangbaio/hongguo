package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.ChannelResult;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ChannelKt {
    static {
        Covode.recordClassIndex(659077);
    }

    public static final /* synthetic */ Channel Channel(int i) {
        return Channel$default(i, null, null, 6, null);
    }

    /* renamed from: onSuccess-WpGqRn0, reason: not valid java name */
    public static final <T> Object m1084onSuccessWpGqRn0(Object obj, Function1<? super T, Unit> function1) {
        if (!(obj instanceof ChannelResult.c)) {
            function1.invoke(obj);
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrElse-WpGqRn0, reason: not valid java name */
    public static final <T> T m1081getOrElseWpGqRn0(Object obj, Function1<? super Throwable, ? extends T> function1) {
        if (obj instanceof ChannelResult.c) {
            return function1.invoke(ChannelResult.m1089exceptionOrNullimpl(obj));
        }
        return obj;
    }

    /* renamed from: onClosed-WpGqRn0, reason: not valid java name */
    public static final <T> Object m1082onClosedWpGqRn0(Object obj, Function1<? super Throwable, Unit> function1) {
        if (obj instanceof ChannelResult.a) {
            function1.invoke(ChannelResult.m1089exceptionOrNullimpl(obj));
        }
        return obj;
    }

    /* renamed from: onFailure-WpGqRn0, reason: not valid java name */
    public static final <T> Object m1083onFailureWpGqRn0(Object obj, Function1<? super Throwable, Unit> function1) {
        if (obj instanceof ChannelResult.c) {
            function1.invoke(ChannelResult.m1089exceptionOrNullimpl(obj));
        }
        return obj;
    }

    public static /* synthetic */ Channel Channel$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return Channel(i);
    }

    public static final <E> Channel<E> Channel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        Channel<E> gVar;
        if (i != -2) {
            boolean z = false;
            if (i != -1) {
                if (i != 0) {
                    if (i != Integer.MAX_VALUE) {
                        if (bufferOverflow == BufferOverflow.SUSPEND) {
                            return new BufferedChannel(i, function1);
                        }
                        return new g(i, bufferOverflow, function1);
                    }
                    return new BufferedChannel(Integer.MAX_VALUE, function1);
                }
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    gVar = new BufferedChannel<>(0, function1);
                } else {
                    gVar = new g<>(1, bufferOverflow, function1);
                }
            } else {
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    z = true;
                }
                if (z) {
                    return new g(1, BufferOverflow.DROP_OLDEST, function1);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            gVar = new BufferedChannel<>(Channel.Factory.a(), function1);
        } else {
            gVar = new g<>(1, bufferOverflow, function1);
        }
        return gVar;
    }

    public static /* synthetic */ Channel Channel$default(int i, BufferOverflow bufferOverflow, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return Channel(i, bufferOverflow, function1);
    }
}
