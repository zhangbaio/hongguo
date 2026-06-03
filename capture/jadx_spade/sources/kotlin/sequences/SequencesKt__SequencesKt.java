package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SequencesKt__SequencesKt extends n {
    static {
        Covode.recordClassIndex(658725);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object flatten$lambda$3$SequencesKt__SequencesKt(Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object generateSequence$lambda$5$SequencesKt__SequencesKt(Object obj) {
        return obj;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements Sequence<T> {
        final /* synthetic */ Iterator a;

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return this.a;
        }

        public b(Iterator it2) {
            this.a = it2;
        }
    }

    public static <T> Sequence<T> emptySequence() {
        return g.a;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Sequence<T> {
        final /* synthetic */ Function0<Iterator<T>> a;

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return this.a.invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends Iterator<? extends T>> function0) {
            this.a = function0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Sequence<T> orEmpty(Sequence<? extends T> sequence) {
        if (sequence == 0) {
            return emptySequence();
        }
        return sequence;
    }

    private static final <T> Sequence<T> Sequence(Function0<? extends Iterator<? extends T>> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return new a(iterator);
    }

    public static <T> Sequence<T> asSequence(Iterator<? extends T> it2) {
        Sequence<T> constrainOnce;
        Intrinsics.checkNotNullParameter(it2, "<this>");
        constrainOnce = constrainOnce(new b(it2));
        return constrainOnce;
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten$SequencesKt__SequencesKt(sequence, new Function1() { // from class: kotlin.sequences.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Iterator flatten$lambda$1$SequencesKt__SequencesKt;
                flatten$lambda$1$SequencesKt__SequencesKt = SequencesKt__SequencesKt.flatten$lambda$1$SequencesKt__SequencesKt((Sequence) obj);
                return flatten$lambda$1$SequencesKt__SequencesKt;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator flatten$lambda$1$SequencesKt__SequencesKt(Sequence it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator flatten$lambda$2$SequencesKt__SequencesKt(Iterable it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.iterator();
    }

    public static final <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten$SequencesKt__SequencesKt(sequence, new Function1() { // from class: kotlin.sequences.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Iterator flatten$lambda$2$SequencesKt__SequencesKt;
                flatten$lambda$2$SequencesKt__SequencesKt = SequencesKt__SequencesKt.flatten$lambda$2$SequencesKt__SequencesKt((Iterable) obj);
                return flatten$lambda$2$SequencesKt__SequencesKt;
            }
        });
    }

    public static <T> Sequence<T> sequenceOf(T... elements) {
        Sequence<T> asSequence;
        Intrinsics.checkNotNullParameter(elements, "elements");
        asSequence = ArraysKt___ArraysKt.asSequence(elements);
        return asSequence;
    }

    public static final <T> Sequence<T> shuffled(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return shuffled(sequence, Random.Default);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Sequence<T> constrainOnce(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (!(sequence instanceof kotlin.sequences.a)) {
            return new kotlin.sequences.a(sequence);
        }
        return sequence;
    }

    public static final <T> Sequence<T> generateSequence(final Function0<? extends T> nextFunction) {
        Sequence<T> constrainOnce;
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        constrainOnce = constrainOnce(new j(nextFunction, new Function1() { // from class: kotlin.sequences.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object generateSequence$lambda$4$SequencesKt__SequencesKt;
                generateSequence$lambda$4$SequencesKt__SequencesKt = SequencesKt__SequencesKt.generateSequence$lambda$4$SequencesKt__SequencesKt(Function0.this, obj);
                return generateSequence$lambda$4$SequencesKt__SequencesKt;
            }
        }));
        return constrainOnce;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Sequence<? extends Pair<? extends T, ? extends R>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair<? extends T, ? extends R> pair : sequence) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }

    public static <T> Sequence<T> generateSequence(Function0<? extends T> seedFunction, Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(seedFunction, "seedFunction");
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return new j(seedFunction, nextFunction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object generateSequence$lambda$4$SequencesKt__SequencesKt(Function0 function0, Object it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return function0.invoke();
    }

    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        if (sequence instanceof n0) {
            return ((n0) sequence).e(function1);
        }
        return new i(sequence, new Function1() { // from class: kotlin.sequences.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object flatten$lambda$3$SequencesKt__SequencesKt;
                flatten$lambda$3$SequencesKt__SequencesKt = SequencesKt__SequencesKt.flatten$lambda$3$SequencesKt__SequencesKt(obj);
                return flatten$lambda$3$SequencesKt__SequencesKt;
            }
        }, function1);
    }

    public static <T> Sequence<T> generateSequence(final T t, Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        if (t == null) {
            return g.a;
        }
        return new j(new Function0() { // from class: kotlin.sequences.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object generateSequence$lambda$5$SequencesKt__SequencesKt;
                generateSequence$lambda$5$SequencesKt__SequencesKt = SequencesKt__SequencesKt.generateSequence$lambda$5$SequencesKt__SequencesKt(t);
                return generateSequence$lambda$5$SequencesKt__SequencesKt;
            }
        }, nextFunction);
    }

    public static final <T> Sequence<T> ifEmpty(Sequence<? extends T> sequence, Function0<? extends Sequence<? extends T>> defaultValue) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return SequencesKt__SequenceBuilderKt.sequence(new SequencesKt__SequencesKt$ifEmpty$1(sequence, defaultValue, null));
    }

    public static final <T> Sequence<T> shuffled(Sequence<? extends T> sequence, Random random) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        return SequencesKt__SequenceBuilderKt.sequence(new SequencesKt__SequencesKt$shuffled$1(sequence, random, null));
    }

    public static final <T, C, R> Sequence<R> flatMapIndexed(Sequence<? extends T> source, Function2<? super Integer, ? super T, ? extends C> transform, Function1<? super C, ? extends Iterator<? extends R>> iterator) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return SequencesKt__SequenceBuilderKt.sequence(new SequencesKt__SequencesKt$flatMapIndexed$1(source, transform, iterator, null));
    }
}
