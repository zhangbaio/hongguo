package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.util.NoSuchElementException;
import kotlin.collections.LongIterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class i extends LongIterator {
    private final long[] a;
    private int b;

    static {
        Covode.recordClassIndex(658495);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.b < this.a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.LongIterator
    public long nextLong() {
        try {
            long[] jArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public i(long[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.a = array;
    }
}
