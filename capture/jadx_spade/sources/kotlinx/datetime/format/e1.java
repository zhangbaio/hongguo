package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.datetime.internal.format.ReducedIntFieldDirective;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class e1 extends ReducedIntFieldDirective<g> {
    public final int d;
    private final boolean e;

    static {
        Covode.recordClassIndex(659509);
    }

    public int hashCode() {
        return (this.d * 31) + androidx.compose.animation.m.a(this.e);
    }

    public boolean equals(Object obj) {
        if (obj instanceof e1) {
            e1 e1Var = (e1) obj;
            if (this.d == e1Var.d && this.e == e1Var.e) {
                return true;
            }
        }
        return false;
    }

    public e1(int i, boolean z) {
        super(DateFields.a.d(), 2, i);
        this.d = i;
        this.e = z;
    }

    public /* synthetic */ e1(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? false : z);
    }
}
