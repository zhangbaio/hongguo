package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class n implements Iterator<UInt>, KMappedMarker {
    private final int a;
    private boolean b;
    private final int c;
    private int d;

    static {
        Covode.recordClassIndex(658647);
    }

    public /* synthetic */ n(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
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
    public /* bridge */ /* synthetic */ UInt next() {
        return UInt.m784boximpl(c());
    }

    public int c() {
        int i = this.d;
        if (i == this.a) {
            if (this.b) {
                this.b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.d = UInt.m790constructorimpl(this.c + i);
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0014, code lost:
    
        if (r2 >= 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
    
        if (r2 <= 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private n(int r4, int r5, int r6) {
        /*
            r3 = this;
            r3.<init>()
            r3.a = r5
            r0 = 1
            r1 = 0
            if (r6 <= 0) goto L10
            int r2 = kotlin.k.a(r4, r5)
            if (r2 > 0) goto L17
            goto L18
        L10:
            int r2 = kotlin.k.a(r4, r5)
            if (r2 < 0) goto L17
            goto L18
        L17:
            r0 = 0
        L18:
            r3.b = r0
            int r6 = kotlin.UInt.m790constructorimpl(r6)
            r3.c = r6
            boolean r6 = r3.b
            if (r6 == 0) goto L25
            goto L26
        L25:
            r4 = r5
        L26:
            r3.d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.n.<init>(int, int, int):void");
    }
}
