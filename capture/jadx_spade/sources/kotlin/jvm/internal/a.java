package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.util.NoSuchElementException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a extends kotlin.collections.s {
    private final boolean[] a;
    private int b;

    static {
        Covode.recordClassIndex(658486);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.b < this.a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.s
    public boolean c() {
        try {
            boolean[] zArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public a(boolean[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.a = array;
    }
}
