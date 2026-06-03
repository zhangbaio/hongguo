package ko4;

import androidx.compose.ui.graphics.l0;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final long a;
    public final long b;

    static {
        Covode.recordClassIndex(609072);
    }

    public /* synthetic */ a(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return l0.p(this.a, aVar.a) && l0.p(this.b, aVar.b);
    }

    public int hashCode() {
        return (l0.v(this.a) * 31) + l0.v(this.b);
    }

    public String toString() {
        return "BackgroundColor(bgColor=" + ((Object) l0.w(this.a)) + ", bgDarkColor=" + ((Object) l0.w(this.b)) + ')';
    }

    private a(long j, long j2) {
        this.a = j;
        this.b = j2;
    }
}
