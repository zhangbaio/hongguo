package kotlin;

import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@JvmInline
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class p implements Collection<o>, KMappedMarker {
    private final short[] a;

    static {
        Covode.recordClassIndex(658135);
    }

    public static String B(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public static final /* synthetic */ p a(short[] sArr) {
        return new p(sArr);
    }

    public static short[] j(short[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    public static boolean r(short[] sArr, Object obj) {
        return (obj instanceof p) && Intrinsics.areEqual(sArr, ((p) obj).C());
    }

    public static int w(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public final /* synthetic */ short[] C() {
        return this.a;
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(o oVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends o> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return r(this.a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return w(this.a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    public String toString() {
        return B(this.a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return y(this.a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<o> iterator() {
        return z(this.a);
    }

    @Override // java.util.Collection
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int size() {
        return v(this.a);
    }

    private static final class a implements Iterator<o>, KMappedMarker {
        private final short[] a;
        private int b;

        static {
            Covode.recordClassIndex(658136);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b < this.a.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ o next() {
            return o.a(c());
        }

        public short c() {
            int i = this.b;
            short[] sArr = this.a;
            if (i < sArr.length) {
                this.b = i + 1;
                return o.b(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        public a(short[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.a = array;
        }
    }

    public static int v(short[] sArr) {
        return sArr.length;
    }

    private /* synthetic */ p(short[] sArr) {
        this.a = sArr;
    }

    public static short[] d(int i) {
        return j(new short[i]);
    }

    public static boolean y(short[] sArr) {
        if (sArr.length == 0) {
            return true;
        }
        return false;
    }

    public static Iterator<o> z(short[] sArr) {
        return new a(sArr);
    }

    public boolean n(short s) {
        return o(this.a, s);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return q(this.a, elements);
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        return n(((o) obj).f());
    }

    public static boolean o(short[] sArr, short s) {
        return ArraysKt___ArraysKt.contains(sArr, s);
    }

    public static final short s(short[] sArr, int i) {
        return o.b(sArr[i]);
    }

    public static boolean q(short[] sArr, Collection<o> elements) {
        boolean z;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<o> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if ((obj instanceof o) && ArraysKt___ArraysKt.contains(sArr, ((o) obj).f())) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static final void A(short[] sArr, int i, short s) {
        sArr[i] = s;
    }
}
