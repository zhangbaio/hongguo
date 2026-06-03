package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a<S extends c<?>> {
    public S[] a;
    public int b;
    private int c;
    private p d;

    static {
        Covode.recordClassIndex(659182);
    }

    protected abstract S e();

    protected abstract S[] f(int i);

    public final StateFlow<Integer> getSubscriptionCount() {
        p pVar;
        synchronized (this) {
            pVar = this.d;
            if (pVar == null) {
                pVar = new p(this.b);
                this.d = pVar;
            }
        }
        return pVar;
    }

    protected final S d() {
        S s;
        p pVar;
        synchronized (this) {
            S[] sArr = this.a;
            if (sArr == null) {
                sArr = f(2);
                this.a = sArr;
            } else if (this.b >= sArr.length) {
                Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                this.a = (S[]) ((c[]) copyOf);
                sArr = (S[]) ((c[]) copyOf);
            }
            int i = this.c;
            do {
                s = sArr[i];
                if (s == null) {
                    s = e();
                    sArr[i] = s;
                }
                i++;
                if (i >= sArr.length) {
                    i = 0;
                }
                Intrinsics.checkNotNull(s, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            } while (!s.a(this));
            this.c = i;
            this.b++;
            pVar = this.d;
        }
        if (pVar != null) {
            pVar.T(1);
        }
        return s;
    }

    protected final void g(S s) {
        p pVar;
        int i;
        Continuation<Unit>[] b;
        synchronized (this) {
            int i2 = this.b - 1;
            this.b = i2;
            pVar = this.d;
            if (i2 == 0) {
                this.c = 0;
            }
            Intrinsics.checkNotNull(s, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            b = s.b(this);
        }
        for (Continuation<Unit> continuation : b) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m773constructorimpl(Unit.INSTANCE));
            }
        }
        if (pVar != null) {
            pVar.T(-1);
        }
    }
}
