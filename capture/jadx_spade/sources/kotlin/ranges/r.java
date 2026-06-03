package kotlin.ranges;

import androidx.collection.w;
import com.bytedance.covode.number.Covode;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class r extends p implements ClosedRange<ULong>, l<ULong> {
    public static final a e;
    private static final r f;

    public /* synthetic */ r(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    public long n() {
        return this.b;
    }

    public long o() {
        return this.a;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(658654);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final r a() {
            return r.f;
        }
    }

    @Override // kotlin.ranges.l
    public /* bridge */ /* synthetic */ ULong getEndExclusive() {
        return ULong.m844boximpl(j());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ ULong getEndInclusive() {
        return ULong.m844boximpl(n());
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.l
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return ULong.m844boximpl(o());
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (w.a(this.a, this.b) > 0) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(658653);
        e = new a(null);
        f = new r(-1L, 0L, null);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = this.a;
        int m850constructorimpl = ((int) ULong.m850constructorimpl(j ^ ULong.m850constructorimpl(j >>> 32))) * 31;
        long j2 = this.b;
        return ((int) ULong.m850constructorimpl(j2 ^ ULong.m850constructorimpl(j2 >>> 32))) + m850constructorimpl;
    }

    public long j() {
        long j = this.b;
        if (j != -1) {
            return ULong.m850constructorimpl(j + ULong.m850constructorimpl(1 & 4294967295L));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    public String toString() {
        return ((Object) ULong.m896toStringimpl(this.a)) + ".." + ((Object) ULong.m896toStringimpl(this.b));
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(ULong uLong) {
        return d(uLong.m902unboximpl());
    }

    public boolean d(long j) {
        if (w.a(this.a, j) <= 0 && w.a(j, this.b) <= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            if (!isEmpty() || !((r) obj).isEmpty()) {
                r rVar = (r) obj;
                if (this.a != rVar.a || this.b != rVar.b) {
                }
            }
            return true;
        }
        return false;
    }

    private r(long j, long j2) {
        super(j, j2, 1L, null);
    }
}
