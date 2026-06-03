package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SlidingWindowKt {
    static {
        Covode.recordClassIndex(658225);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Sequence<List<? extends T>> {
        final /* synthetic */ Sequence a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean d;
        final /* synthetic */ boolean e;

        @Override // kotlin.sequences.Sequence
        public Iterator<List<? extends T>> iterator() {
            return SlidingWindowKt.b(this.a.iterator(), this.b, this.c, this.d, this.e);
        }

        public a(Sequence sequence, int i, int i2, boolean z, boolean z2) {
            this.a = sequence;
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = z2;
        }
    }

    public static final void a(int i, int i2) {
        boolean z;
        String str;
        if (i > 0 && i2 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (i != i2) {
                str = "Both size " + i + " and step " + i2 + " must be greater than zero.";
            } else {
                str = "size " + i + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public static final <T> Iterator<List<T>> b(Iterator<? extends T> iterator, int i, int i2, boolean z, boolean z2) {
        Iterator<List<T>> it2;
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        if (!iterator.hasNext()) {
            return y.a;
        }
        it2 = SequencesKt__SequenceBuilderKt.iterator(new SlidingWindowKt$windowedIterator$1(i, i2, iterator, z2, z, null));
        return it2;
    }

    public static final <T> Sequence<List<T>> c(Sequence<? extends T> sequence, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        a(i, i2);
        return new a(sequence, i, i2, z, z2);
    }
}
