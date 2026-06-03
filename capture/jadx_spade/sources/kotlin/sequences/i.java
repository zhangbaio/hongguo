package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i<T, R, E> implements Sequence<E> {
    private final Sequence<T> a;
    private final Function1<T, R> b;
    private final Function1<R, Iterator<E>> c;

    static {
        Covode.recordClassIndex(658714);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<E> iterator() {
        return new a(this);
    }

    public static final class a implements Iterator<E>, KMappedMarker {
        public final Iterator<T> a;
        public Iterator<? extends E> b;
        public int c;
        final /* synthetic */ i<T, R, E> d;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.c;
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return false;
            }
            return c();
        }

        @Override // java.util.Iterator
        public E next() {
            int i = this.c;
            if (i != 2) {
                if (i == 0 && !c()) {
                    throw new NoSuchElementException();
                }
                this.c = 0;
                Iterator<? extends E> it2 = this.b;
                Intrinsics.checkNotNull(it2);
                return it2.next();
            }
            throw new NoSuchElementException();
        }

        private final boolean c() {
            Iterator<? extends E> it2 = this.b;
            if (it2 != null && it2.hasNext()) {
                this.c = 1;
                return true;
            }
            while (this.a.hasNext()) {
                Iterator<? extends E> it4 = (Iterator) ((i) this.d).c.invoke(((i) this.d).b.invoke(this.a.next()));
                if (it4.hasNext()) {
                    this.b = it4;
                    this.c = 1;
                    return true;
                }
            }
            this.c = 2;
            this.b = null;
            return false;
        }

        a(i<T, R, E> iVar) {
            this.d = iVar;
            this.a = ((i) iVar).a.iterator();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transformer, Function1<? super R, ? extends Iterator<? extends E>> iterator) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        this.a = sequence;
        this.b = transformer;
        this.c = iterator;
    }
}
