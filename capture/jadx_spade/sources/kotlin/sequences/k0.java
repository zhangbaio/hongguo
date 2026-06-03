package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k0<T> implements Sequence<T>, e<T> {
    private final Sequence<T> a;
    private final int b;

    static {
        Covode.recordClassIndex(658729);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }

    public static final class a implements Iterator<T>, KMappedMarker {
        public int a;
        public final Iterator<T> b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a > 0 && this.b.hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.a;
            if (i != 0) {
                this.a = i - 1;
                return this.b.next();
            }
            throw new NoSuchElementException();
        }

        a(k0<T> k0Var) {
            this.a = ((k0) k0Var).b;
            this.b = ((k0) k0Var).a.iterator();
        }
    }

    @Override // kotlin.sequences.e
    public Sequence<T> a(int i) {
        if (i >= this.b) {
            return this;
        }
        return new k0(this.a, i);
    }

    @Override // kotlin.sequences.e
    public Sequence<T> b(int i) {
        if (i >= this.b) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new j0(this.a, i, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k0(Sequence<? extends T> sequence, int i) {
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
