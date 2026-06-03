package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.z;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class a<E> extends b<E> implements ReceiveChannel {
    static {
        Covode.recordClassIndex(659054);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean U(Throwable th) {
        z.a(getContext(), th);
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void l0(Throwable th) {
        Channel<E> channel = this.d;
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = u0.a(b0.a(this) + " was cancelled", th);
            }
        }
        channel.cancel(cancellationException);
    }
}
