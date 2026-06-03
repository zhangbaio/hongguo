package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h extends IntIterator {
    public final int a;
    private final int b;
    private boolean c;
    private int d;

    static {
        Covode.recordClassIndex(658630);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        int i = this.d;
        if (i == this.b) {
            if (this.c) {
                this.c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.d = this.a + i;
        }
        return i;
    }

    public h(int i, int i2, int i3) {
        this.a = i3;
        this.b = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.c = z;
        this.d = z ? i : i2;
    }
}
