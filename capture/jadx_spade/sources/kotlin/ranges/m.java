package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class m implements Iterable<UInt>, KMappedMarker {
    public static final a d;
    public final int a;
    public final int b;
    public final int c;

    public static final class a {
        static {
            Covode.recordClassIndex(658646);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(658645);
        d = new a(null);
    }

    public /* synthetic */ m(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    @Override // java.lang.Iterable
    public final Iterator<UInt> iterator() {
        return new n(this.a, this.b, this.c, null);
    }

    private m(int i, int i2, int i3) {
        if (i3 != 0) {
            if (i3 != Integer.MIN_VALUE) {
                this.a = i;
                this.b = rm6.d.d(i, i2, i3);
                this.c = i3;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }
}
