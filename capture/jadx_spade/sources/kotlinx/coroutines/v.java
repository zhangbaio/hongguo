package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class v {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b;
    private volatile /* synthetic */ int _handled$volatile;
    public final Throwable a;

    static {
        Covode.recordClassIndex(658921);
        b = AtomicIntegerFieldUpdater.newUpdater(v.class, "_handled$volatile");
    }

    public final boolean a() {
        if (b.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        return b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return b0.a(this) + '[' + this.a + ']';
    }

    public v(Throwable th, boolean z) {
        this.a = th;
        this._handled$volatile = z ? 1 : 0;
    }

    public /* synthetic */ v(Throwable th, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? false : z);
    }
}
