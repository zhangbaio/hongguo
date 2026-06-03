package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class k0<T> extends AbstractList<T> {
    private final List<T> a;

    static {
        Covode.recordClassIndex(658218);
    }

    public static final class a implements ListIterator<T>, KMappedMarker {
        public final ListIterator<T> a;
        final /* synthetic */ k0<T> b;

        @Override // java.util.ListIterator
        public void add(T t) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(T t) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.a.previous();
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.a.next();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            int reverseIteratorIndex$CollectionsKt__ReversedViewsKt;
            reverseIteratorIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reverseIteratorIndex$CollectionsKt__ReversedViewsKt(this.b, this.a.previousIndex());
            return reverseIteratorIndex$CollectionsKt__ReversedViewsKt;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            int reverseIteratorIndex$CollectionsKt__ReversedViewsKt;
            reverseIteratorIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reverseIteratorIndex$CollectionsKt__ReversedViewsKt(this.b, this.a.nextIndex());
            return reverseIteratorIndex$CollectionsKt__ReversedViewsKt;
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(k0<? extends T> k0Var, int i) {
            int reversePositionIndex$CollectionsKt__ReversedViewsKt;
            this.b = k0Var;
            List list = ((k0) k0Var).a;
            reversePositionIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(k0Var, i);
            this.a = list.listIterator(reversePositionIndex$CollectionsKt__ReversedViewsKt);
        }
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.a.size();
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k0(List<? extends T> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.a = delegate;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i) {
        int reverseElementIndex$CollectionsKt__ReversedViewsKt;
        List<T> list = this.a;
        reverseElementIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, i);
        return list.get(reverseElementIndex$CollectionsKt__ReversedViewsKt);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator<T> listIterator(int i) {
        return new a(this, i);
    }
}
