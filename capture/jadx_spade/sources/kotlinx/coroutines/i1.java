package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class i1 extends r1 {
    private final Continuation<Unit> d;

    static {
        Covode.recordClassIndex(659013);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void n0() {
        ym6.a.b(this.d, this);
    }

    public i1(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, false);
        Continuation<Unit> createCoroutineUnintercepted;
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, this, this);
        this.d = createCoroutineUnintercepted;
    }
}
