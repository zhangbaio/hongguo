package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import kotlin.collections.u;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a implements Iterable<Character>, KMappedMarker {
    public static final C0206a d;
    public final char a;
    public final char b;
    public final int c;

    static {
        Covode.recordClassIndex(658615);
        d = new C0206a(null);
    }

    @Override // java.lang.Iterable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public u iterator() {
        return new b(this.a, this.b, this.c);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        if (this.c > 0) {
            if (Intrinsics.compare((int) this.a, (int) this.b) > 0) {
                return true;
            }
        } else if (Intrinsics.compare((int) this.a, (int) this.b) < 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i = -this.c;
        }
        sb.append(i);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.a != aVar.a || this.b != aVar.b || this.c != aVar.c) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: kotlin.ranges.a$a, reason: collision with other inner class name */
    public static final class C0206a {
        static {
            Covode.recordClassIndex(658616);
        }

        private C0206a() {
        }

        public /* synthetic */ C0206a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(char c, char c2, int i) {
            return new a(c, c2, i);
        }
    }

    public a(char c, char c2, int i) {
        if (i != 0) {
            if (i != Integer.MIN_VALUE) {
                this.a = c;
                this.b = (char) rm6.c.c(c, c2, i);
                this.c = i;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }
}
