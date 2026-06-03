package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h {
    static {
        Covode.recordClassIndex(659197);
    }

    public static final void a(AbortFlowException abortFlowException, Object obj) {
        if (abortFlowException.owner == obj) {
        } else {
            throw abortFlowException;
        }
    }
}
