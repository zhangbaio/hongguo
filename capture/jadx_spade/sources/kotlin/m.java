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
public final class m implements Collection<ULong>, KMappedMarker {
    private final long[] a;

    static {
        Covode.recordClassIndex(658127);
    }

    public static String B(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public static final /* synthetic */ m a(long[] jArr) {
        return new m(jArr);
    }

    public static long[] j(long[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    public static boolean r(long[] jArr, Object obj) {
        return (obj instanceof m) && Intrinsics.areEqual(jArr, ((m) obj).C());
    }

    public static int w(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public final /* synthetic */ long[] C() {
        return this.a;
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends ULong> collection) {
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
    public Iterator<ULong> iterator() {
        return z(this.a);
    }

    @Override // java.util.Collection
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int size() {
        return v(this.a);
    }

    private static final class a implements Iterator<ULong>, KMappedMarker {
        private final long[] a;
        private int b;

        static {
            Covode.recordClassIndex(658128);
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
        public /* bridge */ /* synthetic */ ULong next() {
            return ULong.m844boximpl(c());
        }

        public long c() {
            int i = this.b;
            long[] jArr = this.a;
            if (i < jArr.length) {
                this.b = i + 1;
                return ULong.m850constructorimpl(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        public a(long[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.a = array;
        }
    }

    public static int v(long[] jArr) {
        return jArr.length;
    }

    private /* synthetic */ m(long[] jArr) {
        this.a = jArr;
    }

    public static long[] d(int i) {
        return j(new long[i]);
    }

    public static boolean y(long[] jArr) {
        if (jArr.length == 0) {
            return true;
        }
        return false;
    }

    public static Iterator<ULong> z(long[] jArr) {
        return new a(jArr);
    }

    public boolean n(long j) {
        return o(this.a, j);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return q(this.a, elements);
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ULong)) {
            return false;
        }
        return n(((ULong) obj).m902unboximpl());
    }

    public static boolean o(long[] jArr, long j) {
        return ArraysKt___ArraysKt.contains(jArr, j);
    }

    public static final long s(long[] jArr, int i) {
        return ULong.m850constructorimpl(jArr[i]);
    }

    public static boolean q(long[] jArr, Collection<ULong> elements) {
        boolean z;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<ULong> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if ((obj instanceof ULong) && ArraysKt___ArraysKt.contains(jArr, ((ULong) obj).m902unboximpl())) {
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

    public static final void A(long[] jArr, int i, long j) {
        jArr[i] = j;
    }
}
