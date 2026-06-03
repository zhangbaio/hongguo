package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class f1 extends LockFreeLinkedListNode implements z0, DisposableHandle, x0 {
    public JobSupport d;

    static {
        Covode.recordClassIndex(659004);
    }

    @Override // kotlinx.coroutines.x0
    public j1 a() {
        return null;
    }

    @Override // kotlinx.coroutines.x0
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        t().s0(this);
    }

    public final JobSupport t() {
        JobSupport jobSupport = this.d;
        if (jobSupport != null) {
            return jobSupport;
        }
        Intrinsics.throwUninitializedPropertyAccessException("job");
        return null;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return b0.a(this) + '@' + b0.b(this) + "[job@" + b0.b(t()) + ']';
    }
}
