package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class j0<T> extends AbstractMutableList<T> {
    private final List<T> a;

    static {
        Covode.recordClassIndex(658217);
    }

    public static final class a implements ListIterator<T>, KMutableListIterator {
        public final ListIterator<T> a;
        final /* synthetic */ j0<T> b;

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

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.a.remove();
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

        @Override // java.util.ListIterator
        public void set(T t) {
            this.a.set(t);
        }

        @Override // java.util.ListIterator
        public void add(T t) {
            this.a.add(t);
            this.a.previous();
        }

        a(j0<T> j0Var, int i) {
            int reversePositionIndex$CollectionsKt__ReversedViewsKt;
            this.b = j0Var;
            List list = ((j0) j0Var).a;
            reversePositionIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(j0Var, i);
            this.a = list.listIterator(reversePositionIndex$CollectionsKt__ReversedViewsKt);
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.a.clear();
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.a.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    public j0(List<T> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.a = delegate;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        int reverseElementIndex$CollectionsKt__ReversedViewsKt;
        List<T> list = this.a;
        reverseElementIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, i);
        return list.get(reverseElementIndex$CollectionsKt__ReversedViewsKt);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<T> listIterator(int i) {
        return new a(this, i);
    }

    @Override // kotlin.collections.AbstractMutableList
    public T removeAt(int i) {
        int reverseElementIndex$CollectionsKt__ReversedViewsKt;
        List<T> list = this.a;
        reverseElementIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, i);
        return list.remove(reverseElementIndex$CollectionsKt__ReversedViewsKt);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        int reversePositionIndex$CollectionsKt__ReversedViewsKt;
        List<T> list = this.a;
        reversePositionIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(this, i);
        list.add(reversePositionIndex$CollectionsKt__ReversedViewsKt, t);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        int reverseElementIndex$CollectionsKt__ReversedViewsKt;
        List<T> list = this.a;
        reverseElementIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, i);
        return list.set(reverseElementIndex$CollectionsKt__ReversedViewsKt, t);
    }
}
