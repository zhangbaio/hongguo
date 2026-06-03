package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class b<T> implements Iterator<T>, KMappedMarker {
    private int a;
    private T b;

    static {
        Covode.recordClassIndex(658153);
    }

    protected abstract void c();

    protected final void d() {
        this.a = 2;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private final boolean f() {
        this.a = 3;
        c();
        if (this.a == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i = this.a;
        if (i != 0) {
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return false;
            }
            throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
        }
        return f();
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.a;
        if (i == 1) {
            this.a = 0;
            return this.b;
        }
        if (i != 2 && f()) {
            this.a = 0;
            return this.b;
        }
        throw new NoSuchElementException();
    }

    protected final void e(T t) {
        this.b = t;
        this.a = 1;
    }
}
