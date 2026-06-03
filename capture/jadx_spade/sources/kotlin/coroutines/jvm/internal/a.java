package kotlin.coroutines.jvm.internal;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a implements Continuation<Object> {
    public static final a a;

    static {
        Covode.recordClassIndex(658317);
        a = new a();
    }

    private a() {
    }

    public String toString() {
        return "This continuation is already complete";
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }
}
