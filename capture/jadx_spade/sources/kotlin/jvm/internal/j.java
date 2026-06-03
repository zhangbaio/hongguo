package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.util.NoSuchElementException;
import kotlin.collections.m0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class j extends m0 {
    private final short[] a;
    private int b;

    static {
        Covode.recordClassIndex(658496);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.b < this.a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.m0
    public short c() {
        try {
            short[] sArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public j(short[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.a = array;
    }
}
