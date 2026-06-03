package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class m0<T, R> implements Sequence<R> {
    private final Sequence<T> a;
    private final Function2<Integer, T, R> b;

    static {
        Covode.recordClassIndex(658731);
    }

    public static final class a implements Iterator<R>, KMappedMarker {
        public final Iterator<T> a;
        public int b;
        final /* synthetic */ m0<T, R> c;

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
            Function2 function2 = ((m0) this.c).b;
            int i = this.b;
            this.b = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            return (R) function2.invoke(Integer.valueOf(i), this.a.next());
        }

        a(m0<T, R> m0Var) {
            this.c = m0Var;
            this.a = ((m0) m0Var).a.iterator();
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m0(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends R> transformer) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        this.a = sequence;
        this.b = transformer;
    }
}
