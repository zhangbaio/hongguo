package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h<T> implements Sequence<T> {
    private final Sequence<T> a;
    private final boolean b;
    private final Function1<T, Boolean> c;

    static {
        Covode.recordClassIndex(658713);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }

    public static final class a implements Iterator<T>, KMappedMarker {
        public final Iterator<T> a;
        public int b = -1;
        public T c;
        final /* synthetic */ h<T> d;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b == -1) {
                c();
            }
            if (this.b == 1) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.b == -1) {
                c();
            }
            if (this.b != 0) {
                T t = this.c;
                this.c = null;
                this.b = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        private final void c() {
            while (this.a.hasNext()) {
                T next = this.a.next();
                if (((Boolean) ((h) this.d).c.invoke(next)).booleanValue() == ((h) this.d).b) {
                    this.c = next;
                    this.b = 1;
                    return;
                }
            }
            this.b = 0;
        }

        a(h<T> hVar) {
            this.d = hVar;
            this.a = ((h) hVar).a.iterator();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Sequence<? extends T> sequence, boolean z, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.a = sequence;
        this.b = z;
        this.c = predicate;
    }
}
