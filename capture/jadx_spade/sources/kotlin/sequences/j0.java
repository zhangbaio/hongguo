package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j0<T> implements Sequence<T>, e<T> {
    private final Sequence<T> a;
    private final int b;
    private final int c;

    static {
        Covode.recordClassIndex(658728);
    }

    private final int f() {
        return this.c - this.b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }

    public static final class a implements Iterator<T>, KMappedMarker {
        public final Iterator<T> a;
        public int b;
        final /* synthetic */ j0<T> c;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        private final void c() {
            while (this.b < ((j0) this.c).b && this.a.hasNext()) {
                this.a.next();
                this.b++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            c();
            if (this.b < ((j0) this.c).c && this.a.hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            c();
            if (this.b < ((j0) this.c).c) {
                this.b++;
                return this.a.next();
            }
            throw new NoSuchElementException();
        }

        a(j0<T> j0Var) {
            this.c = j0Var;
            this.a = ((j0) j0Var).a.iterator();
        }
    }

    @Override // kotlin.sequences.e
    public Sequence<T> a(int i) {
        if (i >= f()) {
            return this;
        }
        Sequence<T> sequence = this.a;
        int i2 = this.b;
        return new j0(sequence, i2, i + i2);
    }

    @Override // kotlin.sequences.e
    public Sequence<T> b(int i) {
        if (i >= f()) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new j0(this.a, this.b + i, this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j0(Sequence<? extends T> sequence, int i, int i2) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.a = sequence;
        this.b = i;
        this.c = i2;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (i2 >= i) {
                    return;
                }
                throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i2 + " < " + i).toString());
            }
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i2).toString());
        }
        throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i).toString());
    }
}
