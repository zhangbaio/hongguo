package kotlinx.coroutines.selects;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    static {
        Covode.recordClassIndex(659339);
    }

    public static final <R> void b(SelectBuilder<? super R> selectBuilder, long j, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        a(selectBuilder, DelayKt.m1069toDelayMillisLRDsOJo(j), function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R> void a(SelectBuilder<? super R> selectBuilder, long j, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectBuilder.invoke(new OnTimeout(j).b(), (Function1<? super Continuation<? super Object>, ? extends Object>) function1);
    }
}
