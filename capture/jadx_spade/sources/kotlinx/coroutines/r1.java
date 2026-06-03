package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class r1 extends a<Unit> {
    static {
        Covode.recordClassIndex(659027);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean U(Throwable th) {
        z.a(getContext(), th);
        return true;
    }

    public r1(CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, true, z);
    }
}
