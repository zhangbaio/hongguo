package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.l1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class HandlerContext extends HandlerDispatcher {
    private final Handler a;
    private final String b;
    private final boolean c;
    public final HandlerContext d;

    static {
        Covode.recordClassIndex(659051);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public /* bridge */ /* synthetic */ MainCoroutineDispatcher getImmediate() {
        return this.d;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.MainCoroutineDispatcher
    public /* bridge */ /* synthetic */ HandlerDispatcher getImmediate() {
        return this.d;
    }

    public static final class a implements Runnable {
        final /* synthetic */ CancellableContinuation a;
        final /* synthetic */ HandlerContext b;

        public a(CancellableContinuation cancellableContinuation, HandlerContext handlerContext) {
            this.a = cancellableContinuation;
            this.b = handlerContext;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.resumeUndispatched(this.b, Unit.INSTANCE);
        }
    }

    public int hashCode() {
        int i;
        int identityHashCode = System.identityHashCode(this.a);
        if (this.c) {
            i = 1231;
        } else {
            i = 1237;
        }
        return identityHashCode ^ i;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl == null) {
            String str = this.b;
            if (str == null) {
                str = this.a.toString();
            }
            if (this.c) {
                return str + ".immediate";
            }
            return str;
        }
        return stringInternalImpl;
    }

    public boolean equals(Object obj) {
        if (obj instanceof HandlerContext) {
            HandlerContext handlerContext = (HandlerContext) obj;
            if (handlerContext.a == this.a && handlerContext.c == this.c) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        if (this.c && Intrinsics.areEqual(Looper.myLooper(), this.a.getLooper())) {
            return false;
        }
        return true;
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.a.removeCallbacks(runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (!this.a.post(runnable)) {
            z(coroutineContext, runnable);
        }
    }

    private final void z(CoroutineContext coroutineContext, Runnable runnable) {
        JobKt.cancel(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.getIO().dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.f0
    public void scheduleResumeAfterDelay(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        long coerceAtMost;
        final a aVar = new a(cancellableContinuation, this);
        Handler handler = this.a;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(j, 4611686018427387903L);
        if (handler.postDelayed(aVar, coerceAtMost)) {
            cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Handler handler2;
                    handler2 = HandlerContext.this.a;
                    handler2.removeCallbacks(aVar);
                }
            });
        } else {
            z(cancellableContinuation.getContext(), aVar);
        }
    }

    private HandlerContext(Handler handler, String str, boolean z) {
        super(null);
        HandlerContext handlerContext;
        this.a = handler;
        this.b = str;
        this.c = z;
        if (z) {
            handlerContext = this;
        } else {
            handlerContext = new HandlerContext(handler, str, true);
        }
        this.d = handlerContext;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.f0
    public DisposableHandle invokeOnTimeout(long j, final Runnable runnable, CoroutineContext coroutineContext) {
        long coerceAtMost;
        Handler handler = this.a;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(j, 4611686018427387903L);
        if (handler.postDelayed(runnable, coerceAtMost)) {
            return new DisposableHandle() { // from class: kotlinx.coroutines.android.c
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    HandlerContext.A(HandlerContext.this, runnable);
                }
            };
        }
        z(coroutineContext, runnable);
        return l1.a;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i & 2) != 0 ? null : str);
    }
}
