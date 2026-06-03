package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l<T1, T2, V> implements Sequence<V> {
    private final Sequence<T1> a;
    private final Sequence<T2> b;
    private final Function2<T1, T2, V> c;

    static {
        Covode.recordClassIndex(658718);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<V> iterator() {
        return new a(this);
    }

    public static final class a implements Iterator<V>, KMappedMarker {
        public final Iterator<T1> a;
        public final Iterator<T2> b;
        final /* synthetic */ l<T1, T2, V> c;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a.hasNext() && this.b.hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) ((l) this.c).c.invoke(this.a.next(), this.b.next());
        }

        a(l<T1, T2, V> lVar) {
            this.c = lVar;
            this.a = ((l) lVar).a.iterator();
            this.b = ((l) lVar).b.iterator();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Sequence<? extends T1> sequence1, Sequence<? extends T2> sequence2, Function2<? super T1, ? super T2, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sequence1, "sequence1");
        Intrinsics.checkNotNullParameter(sequence2, "sequence2");
        Intrinsics.checkNotNullParameter(transform, "transform");
        this.a = sequence1;
        this.b = sequence2;
        this.c = transform;
    }
}
