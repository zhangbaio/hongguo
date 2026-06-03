package rq3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final boolean a;
    private volatile boolean b;

    static {
        Covode.recordClassIndex(598609);
    }

    public final void b() {
        this.b = true;
    }

    public final boolean a() {
        if (!this.a && !this.b) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "FirstPlayConfig(firstAutoPlay=" + this.a + ", resetFirstAutoPlayTag=" + this.b + ')';
    }

    public a(boolean z) {
        this.a = z;
    }

    public /* synthetic */ a(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }
}
