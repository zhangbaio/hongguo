package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class l0<T> extends AbstractList<T> implements RandomAccess {
    private final Object[] a;
    private final int b;
    private int c;
    private int d;

    static {
        Covode.recordClassIndex(658219);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.d;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this);
    }

    public final boolean r() {
        if (size() == this.b) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public static final class a extends b<T> {
        private int c;
        private int d;
        final /* synthetic */ l0<T> e;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.b
        protected void c() {
            if (this.c == 0) {
                d();
                return;
            }
            e(((l0) this.e).a[this.d]);
            this.d = (this.d + 1) % ((l0) this.e).b;
            this.c--;
        }

        a(l0<T> l0Var) {
            this.e = l0Var;
            this.c = l0Var.size();
            this.d = ((l0) l0Var).c;
        }
    }

    public l0(int i) {
        this(new Object[i], 0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i) {
        AbstractList.Companion.b(i, size());
        return (T) this.a[(this.c + i) % this.b];
    }

    public final void o(T t) {
        if (!r()) {
            this.a[(this.c + size()) % this.b] = t;
            this.d = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final l0<T> q(int i) {
        int coerceAtMost;
        Object[] array;
        int i2 = this.b;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2 + (i2 >> 1) + 1, i);
        if (this.c == 0) {
            array = Arrays.copyOf(this.a, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(array, "copyOf(...)");
        } else {
            array = toArray(new Object[coerceAtMost]);
        }
        return new l0<>(array, size());
    }

    public final void s(int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i > size()) {
                z2 = false;
            }
            if (z2) {
                if (i > 0) {
                    int i2 = this.c;
                    int i3 = (i2 + i) % this.b;
                    if (i2 > i3) {
                        ArraysKt___ArraysJvmKt.fill(this.a, (Object) null, i2, this.b);
                        ArraysKt___ArraysJvmKt.fill(this.a, (Object) null, 0, i3);
                    } else {
                        ArraysKt___ArraysJvmKt.fill(this.a, (Object) null, i2, i3);
                    }
                    this.c = i3;
                    this.d = size() - i;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        Object[] objArr = array;
        if (length < size()) {
            Object[] objArr2 = (T[]) Arrays.copyOf(array, size());
            Intrinsics.checkNotNullExpressionValue(objArr2, "copyOf(...)");
            objArr = objArr2;
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.c; i2 < size && i3 < this.b; i3++) {
            objArr[i2] = this.a[i3];
            i2++;
        }
        while (i2 < size) {
            objArr[i2] = this.a[i];
            i2++;
            i++;
        }
        return (T[]) CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(size, objArr);
    }

    public l0(Object[] buffer, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.a = buffer;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i <= buffer.length) {
                this.b = buffer.length;
                this.d = i;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + buffer.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
    }
}
