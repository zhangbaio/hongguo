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
public final class l implements Collection<UInt>, KMappedMarker {
    private final int[] a;

    static {
        Covode.recordClassIndex(658121);
    }

    public static String B(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public static final /* synthetic */ l a(int[] iArr) {
        return new l(iArr);
    }

    public static int[] j(int[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    public static boolean r(int[] iArr, Object obj) {
        return (obj instanceof l) && Intrinsics.areEqual(iArr, ((l) obj).C());
    }

    public static int w(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public final /* synthetic */ int[] C() {
        return this.a;
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> collection) {
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
    public Iterator<UInt> iterator() {
        return z(this.a);
    }

    @Override // java.util.Collection
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int size() {
        return v(this.a);
    }

    private static final class a implements Iterator<UInt>, KMappedMarker {
        private final int[] a;
        private int b;

        static {
            Covode.recordClassIndex(658122);
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
        public /* bridge */ /* synthetic */ UInt next() {
            return UInt.m784boximpl(c());
        }

        public int c() {
            int i = this.b;
            int[] iArr = this.a;
            if (i < iArr.length) {
                this.b = i + 1;
                return UInt.m790constructorimpl(iArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        public a(int[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.a = array;
        }
    }

    public static int v(int[] iArr) {
        return iArr.length;
    }

    private /* synthetic */ l(int[] iArr) {
        this.a = iArr;
    }

    public static int[] d(int i) {
        return j(new int[i]);
    }

    public static boolean y(int[] iArr) {
        if (iArr.length == 0) {
            return true;
        }
        return false;
    }

    public static Iterator<UInt> z(int[] iArr) {
        return new a(iArr);
    }

    public boolean n(int i) {
        return o(this.a, i);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return q(this.a, elements);
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UInt)) {
            return false;
        }
        return n(((UInt) obj).m842unboximpl());
    }

    public static boolean o(int[] iArr, int i) {
        return ArraysKt___ArraysKt.contains(iArr, i);
    }

    public static final int s(int[] iArr, int i) {
        return UInt.m790constructorimpl(iArr[i]);
    }

    public static boolean q(int[] iArr, Collection<UInt> elements) {
        boolean z;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<UInt> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if ((obj instanceof UInt) && ArraysKt___ArraysKt.contains(iArr, ((UInt) obj).m842unboximpl())) {
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

    public static final void A(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }
}
