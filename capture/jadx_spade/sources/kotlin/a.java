package kotlin;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a<T, R> {
    public final Function3<c<T, R>, T, Continuation<? super R>, Object> a;

    static {
        Covode.recordClassIndex(658038);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function3<? super c<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.a = block;
    }
}
