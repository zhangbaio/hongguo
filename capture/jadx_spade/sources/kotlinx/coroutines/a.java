package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a<T> extends JobSupport implements Continuation<T>, CoroutineScope {
    private final CoroutineContext c;

    static {
        Covode.recordClassIndex(658885);
    }

    protected void G0(Throwable th, boolean z) {
    }

    protected void H0(T t) {
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.c;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.c;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public String y() {
        return b0.a(this) + " was cancelled";
    }

    @Override // kotlinx.coroutines.JobSupport
    public String f0() {
        String b = CoroutineContextKt.b(this.c);
        if (b == null) {
            return super.f0();
        }
        return '\"' + b + "\":" + super.f0();
    }

    protected void F0(Object obj) {
        p(obj);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void V(Throwable th) {
        z.a(this.c, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    protected final void m0(Object obj) {
        if (obj instanceof v) {
            v vVar = (v) obj;
            G0(vVar.a, vVar.a());
        } else {
            H0(obj);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object d0 = d0(x.d(obj, null, 1, null));
        if (d0 == g1.b) {
            return;
        }
        F0(d0);
    }

    public final <R> void I0(CoroutineStart coroutineStart, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        coroutineStart.invoke(function2, r, this);
    }

    public a(CoroutineContext coroutineContext, boolean z, boolean z2) {
        super(z2);
        if (z) {
            W((Job) coroutineContext.get(Job.Key));
        }
        this.c = coroutineContext.plus(this);
    }
}
