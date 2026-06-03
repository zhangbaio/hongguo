package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.z;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class h<E> extends b<E> implements ProducerScope<E> {
    static {
        Covode.recordClassIndex(659094);
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public /* bridge */ /* synthetic */ SendChannel getChannel() {
        return J0();
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public void H0(Unit unit) {
        SendChannel.DefaultImpls.close$default(this.d, null, 1, null);
    }

    public h(CoroutineContext coroutineContext, Channel<E> channel) {
        super(coroutineContext, channel, true, true);
    }

    @Override // kotlinx.coroutines.a
    protected void G0(Throwable th, boolean z) {
        if (!this.d.close(th) && !z) {
            z.a(getContext(), th);
        }
    }
}
