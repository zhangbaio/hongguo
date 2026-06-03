package kotlin;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private static final Object a;

    static {
        Object coroutine_suspended;
        Covode.recordClassIndex(658039);
        Result.Companion companion = Result.Companion;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        a = Result.m773constructorimpl(coroutine_suspended);
    }

    public static final <T, R> R b(a<T, R> aVar, T t) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return (R) new d(aVar.a, t).b();
    }
}
