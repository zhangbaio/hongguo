package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.CoroutineContext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c2 extends CoroutineDispatcher {
    public static final c2 a;

    static {
        Covode.recordClassIndex(659042);
        a = new c2();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Unconfined";
    }

    private c2() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int i) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        g2 g2Var = (g2) coroutineContext.get(g2.b);
        if (g2Var != null) {
            g2Var.a = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }
}
