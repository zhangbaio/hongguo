package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d2<T> extends kotlinx.coroutines.internal.b0<T> {
    private final ThreadLocal<Pair<CoroutineContext, Object>> e;
    private volatile boolean threadLocalIsSet;

    static {
        Covode.recordClassIndex(659043);
    }

    public final boolean J0() {
        boolean z;
        if (this.threadLocalIsSet && this.e.get() == null) {
            z = true;
        } else {
            z = false;
        }
        this.e.remove();
        return !z;
    }

    @Override // kotlinx.coroutines.internal.b0, kotlinx.coroutines.a
    protected void F0(Object obj) {
        if (this.threadLocalIsSet) {
            Pair<CoroutineContext, Object> pair = this.e.get();
            if (pair != null) {
                ThreadContextKt.a(pair.component1(), pair.component2());
            }
            this.e.remove();
        }
        Object a = x.a(obj, this.d);
        Continuation<T> continuation = this.d;
        CoroutineContext context = continuation.getContext();
        d2<?> d2Var = null;
        Object c = ThreadContextKt.c(context, null);
        if (c != ThreadContextKt.a) {
            d2Var = CoroutineContextKt.g(continuation, context, c);
        }
        try {
            this.d.resumeWith(a);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (d2Var == null || d2Var.J0()) {
                ThreadContextKt.a(context, c);
            }
        }
    }

    public final void K0(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.e.set(TuplesKt.to(coroutineContext, obj));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d2(kotlin.coroutines.CoroutineContext r3, kotlin.coroutines.Continuation<? super T> r4) {
        /*
            r2 = this;
            kotlinx.coroutines.e2 r0 = kotlinx.coroutines.e2.a
            kotlin.coroutines.CoroutineContext$Element r1 = r3.get(r0)
            if (r1 != 0) goto Ld
            kotlin.coroutines.CoroutineContext r0 = r3.plus(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.e = r0
            kotlin.coroutines.CoroutineContext r4 = r4.getContext()
            kotlin.coroutines.ContinuationInterceptor$b r0 = kotlin.coroutines.ContinuationInterceptor.Key
            kotlin.coroutines.CoroutineContext$Element r4 = r4.get(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.CoroutineDispatcher
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r4)
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r4)
            r2.K0(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.d2.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):void");
    }
}
