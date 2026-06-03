package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlinx.coroutines.channels.ChannelResult;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final /* synthetic */ class ChannelsKt__ChannelsKt {
    static {
        Covode.recordClassIndex(659084);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> Object a(SendChannel<? super E> sendChannel, E e) {
        Object b;
        Object mo1078trySendJP2dKIU = sendChannel.mo1078trySendJP2dKIU(e);
        if (!(mo1078trySendJP2dKIU instanceof ChannelResult.c)) {
            return ChannelResult.Companion.c(Unit.INSTANCE);
        }
        b = kotlinx.coroutines.h.b(null, new ChannelsKt__ChannelsKt$trySendBlocking$2(sendChannel, e, null), 1, null);
        return ((ChannelResult) b).m1097unboximpl();
    }
}
