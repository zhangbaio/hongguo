package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class c<F> {
    static {
        Covode.recordClassIndex(659184);
    }

    public abstract boolean a(F f);

    public abstract Continuation<Unit>[] b(F f);
}
