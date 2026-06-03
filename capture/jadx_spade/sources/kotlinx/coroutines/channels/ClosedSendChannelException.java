package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ClosedSendChannelException extends IllegalStateException {
    static {
        Covode.recordClassIndex(659088);
    }

    public ClosedSendChannelException(String str) {
        super(str);
    }
}
