package kotlinx.coroutines.sync;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.f0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a extends c0<a> {
    private final /* synthetic */ AtomicReferenceArray e;

    static {
        Covode.recordClassIndex(659372);
    }

    public final /* synthetic */ AtomicReferenceArray u() {
        return this.e;
    }

    @Override // kotlinx.coroutines.internal.c0
    public int q() {
        int i;
        i = SemaphoreKt.SEGMENT_SIZE;
        return i;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.c + ", hashCode=" + hashCode() + ']';
    }

    public a(long j, a aVar, int i) {
        super(j, aVar, i);
        int i2;
        i2 = SemaphoreKt.SEGMENT_SIZE;
        this.e = new AtomicReferenceArray(i2);
    }

    @Override // kotlinx.coroutines.internal.c0
    public void r(int i, Throwable th, CoroutineContext coroutineContext) {
        f0 f0Var;
        f0Var = SemaphoreKt.CANCELLED;
        u().set(i, f0Var);
        s();
    }
}
