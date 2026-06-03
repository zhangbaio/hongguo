package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.u1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class m0 {
    public final CoroutineContext a;
    private final Object[] b;
    private final u1<Object>[] c;
    private int d;

    static {
        Covode.recordClassIndex(659276);
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            u1<Object> u1Var = this.c[length];
            Intrinsics.checkNotNull(u1Var);
            u1Var.e(coroutineContext, this.b[length]);
            if (i >= 0) {
                length = i;
            } else {
                return;
            }
        }
    }

    public m0(CoroutineContext coroutineContext, int i) {
        this.a = coroutineContext;
        this.b = new Object[i];
        this.c = new u1[i];
    }

    public final void a(u1<?> u1Var, Object obj) {
        Object[] objArr = this.b;
        int i = this.d;
        objArr[i] = obj;
        u1<Object>[] u1VarArr = this.c;
        this.d = i + 1;
        Intrinsics.checkNotNull(u1Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        u1VarArr[i] = u1Var;
    }
}
