package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import java.util.NoSuchElementException;
import kotlin.collections.LongIterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i extends LongIterator {
    public final long a;
    private final long b;
    private boolean c;
    private long d;

    static {
        Covode.recordClassIndex(658635);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }

    @Override // kotlin.collections.LongIterator
    public long nextLong() {
        long j = this.d;
        if (j == this.b) {
            if (this.c) {
                this.c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.d = this.a + j;
        }
        return j;
    }

    public i(long j, long j2, long j3) {
        this.a = j3;
        this.b = j2;
        boolean z = true;
        if (j3 <= 0 ? j < j2 : j > j2) {
            z = false;
        }
        this.c = z;
        this.d = z ? j : j2;
    }
}
