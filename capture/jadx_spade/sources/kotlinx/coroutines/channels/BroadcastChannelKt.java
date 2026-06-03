package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlinx.coroutines.internal.f0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class BroadcastChannelKt {
    private static final f0 NO_ELEMENT;

    static {
        Covode.recordClassIndex(659063);
        NO_ELEMENT = new f0("NO_ELEMENT");
    }

    public static final <E> BroadcastChannel<E> BroadcastChannel(int i) {
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i != Integer.MAX_VALUE) {
                        return new BroadcastChannelImpl(i);
                    }
                    throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
                }
                throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
            }
            return new f();
        }
        return new BroadcastChannelImpl(Channel.Factory.a());
    }
}
