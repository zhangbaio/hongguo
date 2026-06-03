package xm6;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xm6.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    private static final a c;
    private static final AtomicLongFieldUpdater<d> d;
    public final f a;
    public volatile long b;

    private static final class a {
        static {
            Covode.recordClassIndex(658871);
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
        Covode.recordClassIndex(658870);
        c = new a(null);
        d = AtomicLongFieldUpdater.newUpdater(d.class, "b");
    }

    public final long c() {
        long incrementAndGet = d.incrementAndGet(this);
        f fVar = this.a;
        if (fVar != f.a.a) {
            fVar.a("incAndGet():" + incrementAndGet);
        }
        return incrementAndGet;
    }

    public final long a(long j) {
        long addAndGet = d.addAndGet(this, j);
        f fVar = this.a;
        if (fVar != f.a.a) {
            fVar.a("addAndGet(" + j + "):" + addAndGet);
        }
        return addAndGet;
    }

    public final long b(long j) {
        long andSet = d.getAndSet(this, j);
        f fVar = this.a;
        if (fVar != f.a.a) {
            fVar.a("getAndSet(" + j + "):" + andSet);
        }
        return andSet;
    }

    public final void d(long j) {
        this.b = j;
        f fVar = this.a;
        if (fVar != f.a.a) {
            fVar.a("set(" + j + ')');
        }
    }

    public d(long j, f trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        this.a = trace;
        this.b = j;
    }
}
