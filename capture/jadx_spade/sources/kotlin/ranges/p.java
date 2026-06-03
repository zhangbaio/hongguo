package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class p implements Iterable<ULong>, KMappedMarker {
    public static final a d;
    public final long a;
    public final long b;
    public final long c;

    public static final class a {
        static {
            Covode.recordClassIndex(658651);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(658650);
        d = new a(null);
    }

    public /* synthetic */ p(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    @Override // java.lang.Iterable
    public final Iterator<ULong> iterator() {
        return new q(this.a, this.b, this.c, null);
    }

    private p(long j, long j2, long j3) {
        if (j3 != 0) {
            if (j3 != Long.MIN_VALUE) {
                this.a = j;
                this.b = rm6.d.c(j, j2, j3);
                this.c = j3;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }
}
