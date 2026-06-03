package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import java.util.NoSuchElementException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ClosedReceiveChannelException extends NoSuchElementException {
    static {
        Covode.recordClassIndex(659087);
    }

    public ClosedReceiveChannelException(String str) {
        super(str);
    }
}
