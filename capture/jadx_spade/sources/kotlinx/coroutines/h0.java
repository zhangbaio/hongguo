package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h0<T> extends kotlinx.coroutines.internal.b0<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater e;
    private volatile /* synthetic */ int _decision$volatile;

    static {
        Covode.recordClassIndex(658958);
        e = AtomicIntegerFieldUpdater.newUpdater(h0.class, "_decision$volatile");
    }

    public final Object J0() {
        Object coroutine_suspended;
        if (M0()) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended;
        }
        Object h = g1.h(R());
        if (!(h instanceof v)) {
            return h;
        }
        throw ((v) h).a;
    }

    private final boolean L0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = e;
        do {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean M0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = e;
        do {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!e.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // kotlinx.coroutines.internal.b0, kotlinx.coroutines.JobSupport
    protected void p(Object obj) {
        F0(obj);
    }

    @Override // kotlinx.coroutines.internal.b0, kotlinx.coroutines.a
    protected void F0(Object obj) {
        Continuation intercepted;
        if (L0()) {
            return;
        }
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.d);
        kotlinx.coroutines.internal.k.c(intercepted, x.a(obj, this.d), null, 2, null);
    }

    public h0(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }
}
