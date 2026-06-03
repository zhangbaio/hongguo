package xm6;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xm6.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    private static final a c;
    private static final AtomicIntegerFieldUpdater<c> d;
    public final f a;
    public volatile int b;

    private static final class a {
        static {
            Covode.recordClassIndex(658868);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public String toString() {
        return String.valueOf(this.b);
    }

    static {
        Covode.recordClassIndex(658867);
        c = new a(null);
        d = AtomicIntegerFieldUpdater.newUpdater(c.class, "b");
    }

    public final int b() {
        int decrementAndGet = d.decrementAndGet(this);
        f fVar = this.a;
        if (fVar != f.a.a) {
            fVar.a("decAndGet():" + decrementAndGet);
        }
        return decrementAndGet;
    }

    public final int c() {
        int incrementAndGet = d.incrementAndGet(this);
        f fVar = this.a;
        if (fVar != f.a.a) {
            fVar.a("incAndGet():" + incrementAndGet);
        }
        return incrementAndGet;
    }

    public final void d(int i) {
        this.b = i;
        f fVar = this.a;
        if (fVar != f.a.a) {
            fVar.a("set(" + i + ')');
        }
    }

    public c(int i, f trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        this.a = trace;
        this.b = i;
    }

    public final boolean a(int i, int i2) {
        f fVar;
        boolean compareAndSet = d.compareAndSet(this, i, i2);
        if (compareAndSet && (fVar = this.a) != f.a.a) {
            fVar.a("CAS(" + i + ", " + i2 + ')');
        }
        return compareAndSet;
    }
}
