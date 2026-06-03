package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o extends m implements ClosedRange<UInt>, l<UInt> {
    public static final a e;
    private static final o f;

    public /* synthetic */ o(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    public int n() {
        return this.b;
    }

    public int o() {
        return this.a;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(658649);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final o a() {
            return o.f;
        }
    }

    @Override // kotlin.ranges.l
    public /* bridge */ /* synthetic */ UInt getEndExclusive() {
        return UInt.m784boximpl(j());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ UInt getEndInclusive() {
        return UInt.m784boximpl(n());
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.l
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return UInt.m784boximpl(o());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.a * 31) + this.b;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        int compare;
        compare = Integer.compare(this.a ^ Integer.MIN_VALUE, this.b ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(658648);
        DefaultConstructorMarker defaultConstructorMarker = null;
        e = new a(defaultConstructorMarker);
        f = new o(-1, 0, defaultConstructorMarker);
    }

    public int j() {
        int i = this.b;
        if (i != -1) {
            return UInt.m790constructorimpl(i + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    public String toString() {
        return ((Object) UInt.m836toStringimpl(this.a)) + ".." + ((Object) UInt.m836toStringimpl(this.b));
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(UInt uInt) {
        return d(uInt.m842unboximpl());
    }

    public boolean d(int i) {
        int compare;
        int compare2;
        compare = Integer.compare(this.a ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            compare2 = Integer.compare(i ^ Integer.MIN_VALUE, this.b ^ Integer.MIN_VALUE);
            if (compare2 <= 0) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof o) {
            if (!isEmpty() || !((o) obj).isEmpty()) {
                o oVar = (o) obj;
                if (this.a != oVar.a || this.b != oVar.b) {
                }
            }
            return true;
        }
        return false;
    }

    private o(int i, int i2) {
        super(i, i2, 1, null);
    }
}
