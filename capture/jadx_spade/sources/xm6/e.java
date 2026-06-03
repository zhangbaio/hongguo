package xm6;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xm6.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e<T> {
    private static final a c;
    private static final AtomicReferenceFieldUpdater<e<?>, Object> d;
    public final f a;
    public volatile T b;

    private static final class a {
        static {
            Covode.recordClassIndex(658874);
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
        Covode.recordClassIndex(658873);
        c = new a(null);
        d = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "b");
    }

    public final void b(T t) {
        this.b = t;
        f fVar = this.a;
        if (fVar != f.a.a) {
            fVar.a("set(" + t + ')');
        }
    }

    public e(T t, f trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        this.a = trace;
        this.b = t;
    }

    public final boolean a(T t, T t2) {
        f fVar;
        boolean a2 = androidx.concurrent.futures.a.a(d, this, t, t2);
        if (a2 && (fVar = this.a) != f.a.a) {
            fVar.a("CAS(" + t + ", " + t2 + ')');
        }
        return a2;
    }
}
