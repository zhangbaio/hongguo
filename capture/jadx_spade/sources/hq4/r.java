package hq4;

import androidx.compose.ui.graphics.l0;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;

    static {
        Covode.recordClassIndex(609670);
    }

    public /* synthetic */ r(long j, long j2, long j3, long j4, long j5, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return l0.p(this.a, rVar.a) && l0.p(this.b, rVar.b) && l0.p(this.c, rVar.c) && l0.p(this.d, rVar.d) && l0.p(this.e, rVar.e) && l0.p(this.f, rVar.f) && l0.p(this.g, rVar.g);
    }

    public int hashCode() {
        return (((((((((((l0.v(this.a) * 31) + l0.v(this.b)) * 31) + l0.v(this.c)) * 31) + l0.v(this.d)) * 31) + l0.v(this.e)) * 31) + l0.v(this.f)) * 31) + l0.v(this.g);
    }

    public String toString() {
        return "ConfirmDialogColors(backgroundColor=" + ((Object) l0.w(this.a)) + ", titleTextColor=" + ((Object) l0.w(this.b)) + ", messageTextColor=" + ((Object) l0.w(this.c)) + ", confirmTextColor=" + ((Object) l0.w(this.d)) + ", negativeTextColor=" + ((Object) l0.w(this.e)) + ", dividerColor=" + ((Object) l0.w(this.f)) + ", closeIconColor=" + ((Object) l0.w(this.g)) + ')';
    }

    private r(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
        this.g = j7;
    }
}
