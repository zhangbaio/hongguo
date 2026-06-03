package kotlin;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class c<T, R> {
    static {
        Covode.recordClassIndex(658040);
    }

    private c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Object a(T t, Continuation<? super R> continuation);
}
