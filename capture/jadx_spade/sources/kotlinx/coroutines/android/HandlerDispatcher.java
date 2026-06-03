package kotlinx.coroutines.android;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.f0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements f0 {
    static {
        Covode.recordClassIndex(659052);
    }

    public /* synthetic */ HandlerDispatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public abstract HandlerDispatcher getImmediate();

    public abstract /* synthetic */ void scheduleResumeAfterDelay(long j, CancellableContinuation<? super Unit> cancellableContinuation);

    private HandlerDispatcher() {
    }

    public Object delay(long j, Continuation<? super Unit> continuation) {
        return f0.a.a(this, j, continuation);
    }

    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return f0.a.b(this, j, runnable, coroutineContext);
    }
}
