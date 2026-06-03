package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class f extends IntIterator {
    private final int[] a;
    private int b;

    static {
        Covode.recordClassIndex(658491);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.b < this.a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        try {
            int[] iArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public f(int[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.a = array;
    }
}
