package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import java.util.NoSuchElementException;
import kotlin.collections.u;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b extends u {
    public final int a;
    private final int b;
    private boolean c;
    private int d;

    static {
        Covode.recordClassIndex(658617);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }

    @Override // kotlin.collections.u
    public char c() {
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
        return (char) i;
    }

    public b(char c, char c2, int i) {
        this.a = i;
        this.b = c2;
        boolean z = true;
        if (i <= 0 ? Intrinsics.compare((int) c, (int) c2) < 0 : Intrinsics.compare((int) c, (int) c2) > 0) {
            z = false;
        }
        this.c = z;
        this.d = z ? c : c2;
    }
}
