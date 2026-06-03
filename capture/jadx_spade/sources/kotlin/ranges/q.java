package kotlin.ranges;

import androidx.collection.w;
import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class q implements Iterator<ULong>, KMappedMarker {
    private final long a;
    private boolean b;
    private final long c;
    private long d;

    static {
        Covode.recordClassIndex(658652);
    }

    public /* synthetic */ q(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ ULong next() {
        return ULong.m844boximpl(c());
    }

    public long c() {
        long j = this.d;
        if (j == this.a) {
            if (this.b) {
                this.b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.d = ULong.m850constructorimpl(this.c + j);
        }
        return j;
    }

    private q(long j, long j2, long j3) {
        this.a = j2;
        boolean z = true;
        if (j3 <= 0 ? w.a(j, j2) < 0 : w.a(j, j2) > 0) {
            z = false;
        }
        this.b = z;
        this.c = ULong.m850constructorimpl(j3);
        this.d = this.b ? j : j2;
    }
}
