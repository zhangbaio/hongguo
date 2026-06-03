package kotlinx.coroutines.rx2;

import com.bytedance.covode.number.Covode;
import io.reactivex.SingleEmitter;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.coroutines.CoroutineContext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class d<T> extends kotlinx.coroutines.a<T> {
    private final SingleEmitter<T> d;

    static {
        Covode.recordClassIndex(659312);
    }

    @Override // kotlinx.coroutines.a
    protected void H0(T t) {
        try {
            this.d.onSuccess(t);
        } catch (Throwable th) {
            b.a(th, getContext());
        }
    }

    public d(CoroutineContext coroutineContext, SingleEmitter<T> singleEmitter) {
        super(coroutineContext, false, true);
        this.d = singleEmitter;
    }

    @Override // kotlinx.coroutines.a
    protected void G0(Throwable th, boolean z) {
        try {
            if (this.d.tryOnError(th)) {
                return;
            }
        } catch (Throwable th2) {
            ExceptionsKt__ExceptionsKt.addSuppressed(th, th2);
        }
        b.a(th, getContext());
    }
}
