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
public final class h implements Collection<g>, KMappedMarker {
    private final byte[] a;

    static {
        Covode.recordClassIndex(658115);
    }

    public static String B(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    public static final /* synthetic */ h a(byte[] bArr) {
        return new h(bArr);
    }

    public static byte[] j(byte[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    public static boolean r(byte[] bArr, Object obj) {
        return (obj instanceof h) && Intrinsics.areEqual(bArr, ((h) obj).C());
    }

    public static int w(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public final /* synthetic */ byte[] C() {
        return this.a;
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(g gVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends g> collection) {
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
    public Iterator<g> iterator() {
        return z(this.a);
    }

    @Override // java.util.Collection
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int size() {
        return v(this.a);
    }

    private static final class a implements Iterator<g>, KMappedMarker {
        private final byte[] a;
        private int b;

        static {
            Covode.recordClassIndex(658116);
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
        public /* bridge */ /* synthetic */ g next() {
            return g.a(c());
        }

        public byte c() {
            int i = this.b;
            byte[] bArr = this.a;
            if (i < bArr.length) {
                this.b = i + 1;
                return g.b(bArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        public a(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.a = array;
        }
    }

    public static int v(byte[] bArr) {
        return bArr.length;
    }

    private /* synthetic */ h(byte[] bArr) {
        this.a = bArr;
    }

    public static byte[] d(int i) {
        return j(new byte[i]);
    }

    public static boolean y(byte[] bArr) {
        if (bArr.length == 0) {
            return true;
        }
        return false;
    }

    public static Iterator<g> z(byte[] bArr) {
        return new a(bArr);
    }

    public boolean n(byte b) {
        return o(this.a, b);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return q(this.a, elements);
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        return n(((g) obj).f());
    }

    public static boolean o(byte[] bArr, byte b) {
        return ArraysKt___ArraysKt.contains(bArr, b);
    }

    public static final byte s(byte[] bArr, int i) {
        return g.b(bArr[i]);
    }

    public static boolean q(byte[] bArr, Collection<g> elements) {
        boolean z;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<g> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if ((obj instanceof g) && ArraysKt___ArraysKt.contains(bArr, ((g) obj).f())) {
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

    public static final void A(byte[] bArr, int i, byte b) {
        bArr[i] = b;
    }
}
