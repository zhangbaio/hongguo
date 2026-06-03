package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class j<T> implements Sequence<T> {
    private final Function0<T> a;
    private final Function1<T, T> b;

    static {
        Covode.recordClassIndex(658716);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }

    public static final class a implements Iterator<T>, KMappedMarker {
        public T a;
        public int b = -2;
        final /* synthetic */ j<T> c;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b < 0) {
                c();
            }
            if (this.b == 1) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.b < 0) {
                c();
            }
            if (this.b != 0) {
                T t = this.a;
                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.b = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        private final void c() {
            T t;
            int i;
            if (this.b == -2) {
                t = (T) ((j) this.c).a.invoke();
            } else {
                Function1 function1 = ((j) this.c).b;
                T t2 = this.a;
                Intrinsics.checkNotNull(t2);
                t = (T) function1.invoke(t2);
            }
            this.a = t;
            if (t == null) {
                i = 0;
            } else {
                i = 1;
            }
            this.b = i;
        }

        a(j<T> jVar) {
            this.c = jVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function0<? extends T> getInitialValue, Function1<? super T, ? extends T> getNextValue) {
        Intrinsics.checkNotNullParameter(getInitialValue, "getInitialValue");
        Intrinsics.checkNotNullParameter(getNextValue, "getNextValue");
        this.a = getInitialValue;
        this.b = getNextValue;
    }
}
