package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k<T> implements Sequence<IndexedValue<? extends T>> {
    private final Sequence<T> a;

    static {
        Covode.recordClassIndex(658717);
    }

    public static final class a implements Iterator<IndexedValue<? extends T>>, KMappedMarker {
        public final Iterator<T> a;
        public int b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public IndexedValue<T> next() {
            int i = this.b;
            this.b = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            return new IndexedValue<>(i, this.a.next());
        }

        a(k<T> kVar) {
            this.a = ((k) kVar).a.iterator();
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IndexedValue<T>> iterator() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.a = sequence;
    }
}
