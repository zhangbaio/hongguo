package xi6;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    private static final int d;
    private static final int e;
    public static final a f;
    public int a;
    public g b;
    public final List<g> c;

    public static final class a {
        static {
            Covode.recordClassIndex(652776);
        }

        private a() {
        }

        public final int a() {
            return d.d;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean c() {
        if (this.a == 0) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(652775);
        f = new a(null);
        d = -1;
        e = -2;
    }

    public String toString() {
        return "AIPredictResult{status=" + this.a + ", predic=" + this.b.b + ", confid=" + this.b.d + '}';
    }

    public d(int i) {
        this.a = i;
        this.b = g.f.a();
        this.c = new ArrayList();
    }

    public final void b(g state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (Intrinsics.areEqual(this.b, g.f.a()) || state.d > this.b.d) {
            this.b = state;
        }
        this.c.add(state);
    }

    public /* synthetic */ d(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
