package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.util.NoSuchElementException;
import kotlin.collections.z;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class e extends z {
    private final float[] a;
    private int b;

    static {
        Covode.recordClassIndex(658490);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.b < this.a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.z
    public float c() {
        try {
            float[] fArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public e(float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.a = array;
    }
}
