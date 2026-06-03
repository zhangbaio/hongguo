package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f<T> implements Sequence<T> {
    private final Sequence<T> a;
    private final Function1<T, Boolean> b;

    static {
        Covode.recordClassIndex(658711);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }

    public static final class a implements Iterator<T>, KMappedMarker {
        public final Iterator<T> a;
        public int b = -1;
        public T c;
        final /* synthetic */ f<T> d;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b == -1) {
                c();
            }
            if (this.b == 1 || this.a.hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.b == -1) {
                c();
            }
            if (this.b == 1) {
                T t = this.c;
                this.c = null;
                this.b = 0;
                return t;
            }
            return this.a.next();
        }

        private final void c() {
            while (this.a.hasNext()) {
                T next = this.a.next();
                if (!((Boolean) ((f) this.d).b.invoke(next)).booleanValue()) {
                    this.c = next;
                    this.b = 1;
                    return;
                }
            }
            this.b = 0;
        }

        a(f<T> fVar) {
            this.d = fVar;
            this.a = ((f) fVar).a.iterator();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.a = sequence;
        this.b = predicate;
    }
}
