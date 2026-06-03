package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<T> implements Sequence<T>, e<T> {
    private final Sequence<T> a;
    private final int b;

    static {
        Covode.recordClassIndex(658709);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }

    public static final class a implements Iterator<T>, KMappedMarker {
        public final Iterator<T> a;
        public int b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            c();
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            c();
            return this.a.next();
        }

        private final void c() {
            while (this.b > 0 && this.a.hasNext()) {
                this.a.next();
                this.b--;
            }
        }

        a(d<T> dVar) {
            this.a = ((d) dVar).a.iterator();
            this.b = ((d) dVar).b;
        }
    }

    @Override // kotlin.sequences.e
    public Sequence<T> a(int i) {
        int i2 = this.b + i;
        if (i2 < 0) {
            return new k0(this, i);
        }
        return new j0(this.a, this.b, i2);
    }

    @Override // kotlin.sequences.e
    public Sequence<T> b(int i) {
        int i2 = this.b + i;
        if (i2 < 0) {
            return new d(this, i);
        }
        return new d(this.a, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Sequence<? extends T> sequence, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.a = sequence;
        this.b = i;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }
}
