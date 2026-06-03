package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class p1 extends f1 {
    private final Continuation<Unit> e;

    static {
        Covode.recordClassIndex(659023);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p1(Continuation<? super Unit> continuation) {
        this.e = continuation;
    }

    @Override // kotlinx.coroutines.z0
    public void invoke(Throwable th) {
        Continuation<Unit> continuation = this.e;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m773constructorimpl(Unit.INSTANCE));
    }
}
