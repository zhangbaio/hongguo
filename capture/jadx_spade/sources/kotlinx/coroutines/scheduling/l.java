package kotlinx.coroutines.scheduling;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.p;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class l extends CoroutineDispatcher {
    public static final l a;

    static {
        Covode.recordClassIndex(659335);
        a = new l();
    }

    private l() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int i) {
        p.a(i);
        if (i >= k.d) {
            return this;
        }
        return super.limitedParallelism(i);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        b.f.x(runnable, k.h, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        b.f.x(runnable, k.h, true);
    }
}
