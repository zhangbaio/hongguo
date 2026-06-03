package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e {
    static {
        Covode.recordClassIndex(659083);
    }

    public static final void b(ReceiveChannel<?> receiveChannel, Throwable th) {
        ChannelsKt__Channels_commonKt.a(receiveChannel, th);
    }

    public static final <E> Object u(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.c(receiveChannel, continuation);
    }

    public static final <E> Object w(SendChannel<? super E> sendChannel, E e) {
        return ChannelsKt__ChannelsKt.a(sendChannel, e);
    }

    public static final <E, C extends SendChannel<? super E>> Object s(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.s(receiveChannel, c, continuation);
    }

    public static final <E, C extends Collection<? super E>> Object t(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.t(receiveChannel, c, continuation);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> Object v(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        return ChannelsKt__DeprecatedKt.u(receiveChannel, m, continuation);
    }
}
