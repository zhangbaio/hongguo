package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c extends kotlin.ranges.a implements ClosedRange<Character>, l<Character> {
    public static final a e;
    private static final c f;

    public static final class a {
        static {
            Covode.recordClassIndex(658619);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return c.f;
        }
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Character getEndInclusive() {
        return Character.valueOf(this.b);
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.l
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Character getStart() {
        return Character.valueOf(this.a);
    }

    @Override // kotlin.ranges.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.a * 31) + this.b;
    }

    @Override // kotlin.ranges.a, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (Intrinsics.compare((int) this.a, (int) this.b) > 0) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(658618);
        e = new a(null);
        f = new c((char) 1, (char) 0);
    }

    @Override // kotlin.ranges.l
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Character getEndExclusive() {
        char c = this.b;
        if (c != 65535) {
            return Character.valueOf((char) (c + 1));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Override // kotlin.ranges.a
    public String toString() {
        return this.a + ".." + this.b;
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Character ch) {
        return j(ch.charValue());
    }

    public boolean j(char c) {
        if (Intrinsics.compare((int) this.a, (int) c) <= 0 && Intrinsics.compare((int) c, (int) this.b) <= 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (this.a != cVar.a || this.b != cVar.b) {
                }
            }
            return true;
        }
        return false;
    }

    public c(char c, char c2) {
        super(c, c2, 1);
    }
}
