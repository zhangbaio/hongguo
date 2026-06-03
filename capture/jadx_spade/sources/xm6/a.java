package xm6;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xm6.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private static final C0292a c;
    private static final AtomicIntegerFieldUpdater<a> d;
    public final f a;
    private volatile int b;

    /* renamed from: xm6.a$a, reason: collision with other inner class name */
    private static final class C0292a {
        static {
            Covode.recordClassIndex(658863);
        }

        private C0292a() {
        }

        public /* synthetic */ C0292a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean c() {
        if (this.b != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.valueOf(c());
    }

    static {
        Covode.recordClassIndex(658862);
        c = new C0292a(null);
        d = AtomicIntegerFieldUpdater.newUpdater(a.class, "b");
    }

    public final boolean b(boolean z) {
        int andSet = d.getAndSet(this, z ? 1 : 0);
        f fVar = this.a;
        if (fVar != f.a.a) {
            fVar.a("getAndSet(" + z + "):" + andSet);
        }
        if (andSet == 1) {
            return true;
        }
        return false;
    }

    public final void d(boolean z) {
        this.b = z ? 1 : 0;
        f fVar = this.a;
        if (fVar != f.a.a) {
            fVar.a("set(" + z + ')');
        }
    }

    public a(boolean z, f trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        this.a = trace;
        this.b = z ? 1 : 0;
    }

    public final boolean a(boolean z, boolean z2) {
        f fVar;
        boolean compareAndSet = d.compareAndSet(this, z ? 1 : 0, z2 ? 1 : 0);
        if (compareAndSet && (fVar = this.a) != f.a.a) {
            fVar.a("CAS(" + z + ", " + z2 + ')');
        }
        return compareAndSet;
    }
}
