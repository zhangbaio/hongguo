package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n0<T, R> implements Sequence<R> {
    private final Sequence<T> a;
    private final Function1<T, R> b;

    static {
        Covode.recordClassIndex(658732);
    }

    public static final class a implements Iterator<R>, KMappedMarker {
        public final Iterator<T> a;
        final /* synthetic */ n0<T, R> b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((n0) this.b).b.invoke(this.a.next());
        }

        a(n0<T, R> n0Var) {
            this.b = n0Var;
            this.a = ((n0) n0Var).a.iterator();
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new a(this);
    }

    public final <E> Sequence<E> e(Function1<? super R, ? extends Iterator<? extends E>> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return new i(this.a, this.b, iterator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n0(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transformer) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        this.a = sequence;
        this.b = transformer;
    }
}
