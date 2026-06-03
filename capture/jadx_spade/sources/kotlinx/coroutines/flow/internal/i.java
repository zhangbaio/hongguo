package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface i<T> extends Flow<T> {
    Flow<T> a(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow);

    public static final class a {
        static {
            Covode.recordClassIndex(659199);
        }

        public static /* synthetic */ Flow a(i iVar, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    coroutineContext = EmptyCoroutineContext.INSTANCE;
                }
                if ((i2 & 2) != 0) {
                    i = -3;
                }
                if ((i2 & 4) != 0) {
                    bufferOverflow = BufferOverflow.SUSPEND;
                }
                return iVar.a(coroutineContext, i, bufferOverflow);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }
}
