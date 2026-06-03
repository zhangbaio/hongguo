package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SequencesKt___SequencesKt extends u {
    static {
        Covode.recordClassIndex(658727);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Sequence<T> asSequence(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return sequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object distinct$lambda$13$SequencesKt___SequencesKt(Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean filterNotNull$lambda$5$SequencesKt___SequencesKt(Object obj) {
        return obj == null;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterable<T>, KMappedMarker {
        final /* synthetic */ Sequence a;

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.a.iterator();
        }

        public a(Sequence sequence) {
            this.a = sequence;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    public static final class c<K, T> implements Grouping<T, K> {
        final /* synthetic */ Sequence<T> a;
        final /* synthetic */ Function1<T, K> b;

        @Override // kotlin.collections.Grouping
        public Iterator<T> sourceIterator() {
            return this.a.iterator();
        }

        @Override // kotlin.collections.Grouping
        public K keyOf(T t) {
            return this.b.invoke(t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
            this.a = sequence;
            this.b = function1;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class h<T> implements Sequence<T> {
        final /* synthetic */ Sequence<T> a;

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            List mutableList = SequencesKt___SequencesKt.toMutableList(this.a);
            CollectionsKt__MutableCollectionsJVMKt.sort(mutableList);
            return mutableList.iterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        h(Sequence<? extends T> sequence) {
            this.a = sequence;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class i<T> implements Sequence<T> {
        final /* synthetic */ Sequence<T> a;
        final /* synthetic */ Comparator<? super T> b;

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            List mutableList = SequencesKt___SequencesKt.toMutableList(this.a);
            CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, this.b);
            return mutableList.iterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        i(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
            this.a = sequence;
            this.b = comparator;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> implements Sequence<T> {
        final /* synthetic */ Sequence<T> a;
        final /* synthetic */ T b;

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            Sequence<T> sequence = this.a;
            final T t = this.b;
            return SequencesKt___SequencesKt.filter(sequence, new Function1() { // from class: kotlin.sequences.f0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean d;
                    d = SequencesKt___SequencesKt.d.d(Ref$BooleanRef.this, t, obj);
                    return Boolean.valueOf(d);
                }
            }).iterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        d(Sequence<? extends T> sequence, T t) {
            this.a = sequence;
            this.b = t;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(Ref$BooleanRef ref$BooleanRef, Object obj, Object obj2) {
            if (ref$BooleanRef.element || !Intrinsics.areEqual(obj2, obj)) {
                return true;
            }
            ref$BooleanRef.element = true;
            return false;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class e<T> implements Sequence<T> {
        final /* synthetic */ Sequence<T> a;
        final /* synthetic */ T[] b;

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            Sequence<T> sequence = this.a;
            final T[] tArr = this.b;
            return SequencesKt___SequencesKt.filterNot(sequence, new Function1() { // from class: kotlin.sequences.g0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean d;
                    d = SequencesKt___SequencesKt.e.d(tArr, obj);
                    return Boolean.valueOf(d);
                }
            }).iterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        e(Sequence<? extends T> sequence, T[] tArr) {
            this.a = sequence;
            this.b = tArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(Object[] objArr, Object obj) {
            return ArraysKt___ArraysKt.contains(objArr, obj);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class f<T> implements Sequence<T> {
        final /* synthetic */ Iterable<T> a;
        final /* synthetic */ Sequence<T> b;

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            final Collection convertToListIfNotCollection = CollectionsKt__MutableCollectionsKt.convertToListIfNotCollection(this.a);
            if (convertToListIfNotCollection.isEmpty()) {
                return this.b.iterator();
            }
            return SequencesKt___SequencesKt.filterNot(this.b, new Function1() { // from class: kotlin.sequences.h0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean d;
                    d = SequencesKt___SequencesKt.f.d(convertToListIfNotCollection, obj);
                    return Boolean.valueOf(d);
                }
            }).iterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        f(Iterable<? extends T> iterable, Sequence<? extends T> sequence) {
            this.a = iterable;
            this.b = sequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(Collection collection, Object obj) {
            return collection.contains(obj);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class g<T> implements Sequence<T> {
        final /* synthetic */ Sequence<T> a;
        final /* synthetic */ Sequence<T> b;

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            final List list = SequencesKt___SequencesKt.toList(this.a);
            if (list.isEmpty()) {
                return this.b.iterator();
            }
            return SequencesKt___SequencesKt.filterNot(this.b, new Function1() { // from class: kotlin.sequences.i0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean d;
                    d = SequencesKt___SequencesKt.g.d(list, obj);
                    return Boolean.valueOf(d);
                }
            }).iterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        g(Sequence<? extends T> sequence, Sequence<? extends T> sequence2) {
            this.a = sequence;
            this.b = sequence2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(List list, Object obj) {
            return list.contains(obj);
        }
    }

    public static final class b implements Function1<Object, Boolean> {
        public static final b a = new b();

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            Intrinsics.reifiedOperationMarker(3, "R");
            return Boolean.valueOf(obj instanceof Object);
        }
    }

    public static final <T> boolean any(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return sequence.iterator().hasNext();
    }

    public static <T> Iterable<T> asIterable(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return new a(sequence);
    }

    public static <T> Sequence<T> distinct(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return distinctBy(sequence, new Function1() { // from class: kotlin.sequences.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object distinct$lambda$13$SequencesKt___SequencesKt;
                distinct$lambda$13$SequencesKt___SequencesKt = SequencesKt___SequencesKt.distinct$lambda$13$SequencesKt___SequencesKt(obj);
                return distinct$lambda$13$SequencesKt___SequencesKt;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object filterIndexed$lambda$3$SequencesKt___SequencesKt(IndexedValue it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.getValue();
    }

    public static final <T> boolean none(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return !sequence.iterator().hasNext();
    }

    public static final <T> Sequence<T> requireNoNulls(final Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return map(sequence, new Function1() { // from class: kotlin.sequences.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object requireNoNulls$lambda$16$SequencesKt___SequencesKt;
                requireNoNulls$lambda$16$SequencesKt___SequencesKt = SequencesKt___SequencesKt.requireNoNulls$lambda$16$SequencesKt___SequencesKt(Sequence.this, obj);
                return requireNoNulls$lambda$16$SequencesKt___SequencesKt;
            }
        });
    }

    public static <T extends Comparable<? super T>> Sequence<T> sorted(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return new h(sequence);
    }

    public static final <T extends Comparable<? super T>> Sequence<T> sortedDescending(Sequence<? extends T> sequence) {
        Comparator reverseOrder;
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        reverseOrder = ComparisonsKt__ComparisonsKt.reverseOrder();
        return sortedWith(sequence, reverseOrder);
    }

    public static final <T> Sequence<IndexedValue<T>> withIndex(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return new k(sequence);
    }

    public static final <T> Sequence<Pair<T, T>> zipWithNext(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return zipWithNext(sequence, new Function2() { // from class: kotlin.sequences.c0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Pair pair;
                pair = TuplesKt.to(obj, obj2);
                return pair;
            }
        });
    }

    public static <T> int count(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            it2.next();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        return i2;
    }

    public static final /* synthetic */ <R> Sequence<R> filterIsInstance(Sequence<?> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.needClassReification();
        Sequence<R> filter = filter(sequence, b.a);
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return filter;
    }

    public static <T> Sequence<T> filterNotNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Sequence<T> filterNot = filterNot(sequence, new Function1() { // from class: kotlin.sequences.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean filterNotNull$lambda$5$SequencesKt___SequencesKt;
                filterNotNull$lambda$5$SequencesKt___SequencesKt = SequencesKt___SequencesKt.filterNotNull$lambda$5$SequencesKt___SequencesKt(obj);
                return Boolean.valueOf(filterNotNull$lambda$5$SequencesKt___SequencesKt);
            }
        });
        Intrinsics.checkNotNull(filterNot, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return filterNot;
    }

    public static <T> T first(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            return it2.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static <T> T firstOrNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        return it2.next();
    }

    public static final <T> T singleOrNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        if (it2.hasNext()) {
            return null;
        }
        return next;
    }

    public static final int sumOfByte(Sequence<Byte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Byte> it2 = sequence.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 += it2.next().byteValue();
        }
        return i2;
    }

    public static final double sumOfDouble(Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Double> it2 = sequence.iterator();
        double d2 = 0.0d;
        while (it2.hasNext()) {
            d2 += it2.next().doubleValue();
        }
        return d2;
    }

    public static final float sumOfFloat(Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Float> it2 = sequence.iterator();
        float f2 = 0.0f;
        while (it2.hasNext()) {
            f2 += it2.next().floatValue();
        }
        return f2;
    }

    public static final int sumOfInt(Sequence<Integer> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Integer> it2 = sequence.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 += it2.next().intValue();
        }
        return i2;
    }

    public static final long sumOfLong(Sequence<Long> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Long> it2 = sequence.iterator();
        long j = 0;
        while (it2.hasNext()) {
            j += it2.next().longValue();
        }
        return j;
    }

    public static final int sumOfShort(Sequence<Short> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Short> it2 = sequence.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 += it2.next().shortValue();
        }
        return i2;
    }

    public static final <T> HashSet<T> toHashSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (HashSet) toCollection(sequence, new HashSet());
    }

    public static final <T> List<T> toMutableList(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (List) toCollection(sequence, new ArrayList());
    }

    public static final <T> Set<T> toMutableSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(it2.next());
        }
        return linkedHashSet;
    }

    public static final double averageOfByte(Sequence<Byte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Byte> it2 = sequence.iterator();
        double d2 = 0.0d;
        int i2 = 0;
        while (it2.hasNext()) {
            d2 += it2.next().byteValue();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    public static final double averageOfDouble(Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Double> it2 = sequence.iterator();
        double d2 = 0.0d;
        int i2 = 0;
        while (it2.hasNext()) {
            d2 += it2.next().doubleValue();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    public static final double averageOfFloat(Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Float> it2 = sequence.iterator();
        double d2 = 0.0d;
        int i2 = 0;
        while (it2.hasNext()) {
            d2 += it2.next().floatValue();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    public static final double averageOfInt(Sequence<Integer> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Integer> it2 = sequence.iterator();
        double d2 = 0.0d;
        int i2 = 0;
        while (it2.hasNext()) {
            d2 += it2.next().intValue();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    public static final double averageOfLong(Sequence<Long> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Long> it2 = sequence.iterator();
        double d2 = 0.0d;
        int i2 = 0;
        while (it2.hasNext()) {
            d2 += it2.next().longValue();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    public static final double averageOfShort(Sequence<Short> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Short> it2 = sequence.iterator();
        double d2 = 0.0d;
        int i2 = 0;
        while (it2.hasNext()) {
            d2 += it2.next().shortValue();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    public static <T> T last(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            while (it2.hasNext()) {
                next = it2.next();
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static <T> T lastOrNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        while (it2.hasNext()) {
            next = it2.next();
        }
        return next;
    }

    public static <T extends Comparable<? super T>> T maxOrNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        while (it2.hasNext()) {
            T next2 = it2.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final double maxOrThrow(Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Double> it2 = sequence.iterator();
        if (it2.hasNext()) {
            double doubleValue = it2.next().doubleValue();
            while (it2.hasNext()) {
                doubleValue = Math.max(doubleValue, it2.next().doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    public static final <T extends Comparable<? super T>> T minOrNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        while (it2.hasNext()) {
            T next2 = it2.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final double minOrThrow(Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Double> it2 = sequence.iterator();
        if (it2.hasNext()) {
            double doubleValue = it2.next().doubleValue();
            while (it2.hasNext()) {
                doubleValue = Math.min(doubleValue, it2.next().doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    public static final <T> T single(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            if (!it2.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Sequence has more than one element.");
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static <T> List<T> toList(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        T next = it2.next();
        if (!it2.hasNext()) {
            return CollectionsKt__CollectionsJVMKt.listOf(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        return arrayList;
    }

    public static <T> Set<T> toSet(Sequence<? extends T> sequence) {
        Set<T> of;
        Set<T> emptySet;
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        T next = it2.next();
        if (!it2.hasNext()) {
            of = SetsKt__SetsJVMKt.setOf(next);
            return of;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(next);
        while (it2.hasNext()) {
            linkedHashSet.add(it2.next());
        }
        return linkedHashSet;
    }

    /* renamed from: maxOrNull, reason: collision with other method in class */
    public static final Double m1010maxOrNull(Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Double> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double doubleValue = it2.next().doubleValue();
        while (it2.hasNext()) {
            doubleValue = Math.max(doubleValue, it2.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: maxOrThrow, reason: collision with other method in class */
    public static final float m1012maxOrThrow(Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Float> it2 = sequence.iterator();
        if (it2.hasNext()) {
            float floatValue = it2.next().floatValue();
            while (it2.hasNext()) {
                floatValue = Math.max(floatValue, it2.next().floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: minOrNull, reason: collision with other method in class */
    public static final Double m1018minOrNull(Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Double> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double doubleValue = it2.next().doubleValue();
        while (it2.hasNext()) {
            doubleValue = Math.min(doubleValue, it2.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: minOrThrow, reason: collision with other method in class */
    public static final float m1020minOrThrow(Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Float> it2 = sequence.iterator();
        if (it2.hasNext()) {
            float floatValue = it2.next().floatValue();
            while (it2.hasNext()) {
                floatValue = Math.min(floatValue, it2.next().floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: maxOrNull, reason: collision with other method in class */
    public static final Float m1011maxOrNull(Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Float> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float floatValue = it2.next().floatValue();
        while (it2.hasNext()) {
            floatValue = Math.max(floatValue, it2.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: maxOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m1013maxOrThrow(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            while (it2.hasNext()) {
                T next2 = it2.next();
                if (next.compareTo(next2) < 0) {
                    next = next2;
                }
            }
            return next;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: minOrNull, reason: collision with other method in class */
    public static final Float m1019minOrNull(Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<Float> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float floatValue = it2.next().floatValue();
        while (it2.hasNext()) {
            floatValue = Math.min(floatValue, it2.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: minOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m1021minOrThrow(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            while (it2.hasNext()) {
                T next2 = it2.next();
                if (next.compareTo(next2) > 0) {
                    next = next2;
                }
            }
            return next;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onEach$lambda$14$SequencesKt___SequencesKt(Function1 function1, Object obj) {
        function1.invoke(obj);
        return obj;
    }

    public static final <T> Sequence<List<T>> chunked(Sequence<? extends T> sequence, int i2) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return windowed(sequence, i2, i2, true);
    }

    public static final <T> boolean contains(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (indexOf(sequence, t) >= 0) {
            return true;
        }
        return false;
    }

    public static <T, K> Sequence<T> distinctBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new kotlin.sequences.c(sequence, selector);
    }

    public static final <T> Sequence<T> dropWhile(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new kotlin.sequences.f(sequence, predicate);
    }

    public static final <T> T elementAt(Sequence<? extends T> sequence, final int i2) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (T) elementAtOrElse(sequence, i2, new Function1() { // from class: kotlin.sequences.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object elementAt$lambda$0$SequencesKt___SequencesKt;
                elementAt$lambda$0$SequencesKt___SequencesKt = SequencesKt___SequencesKt.elementAt$lambda$0$SequencesKt___SequencesKt(i2, ((Integer) obj).intValue());
                return elementAt$lambda$0$SequencesKt___SequencesKt;
            }
        });
    }

    public static final <T, K> Grouping<T, K> groupingBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        return new c(sequence, keySelector);
    }

    public static <T, R> Sequence<R> map(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new n0(sequence, transform);
    }

    public static final <T, R> Sequence<R> mapIndexed(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new m0(sequence, transform);
    }

    public static final <T> Sequence<T> minus(Sequence<? extends T> sequence, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return new f(elements, sequence);
    }

    private static final <T> Sequence<T> minusElement(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return minus(sequence, t);
    }

    private static final <T> Sequence<T> plusElement(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return plus(sequence, t);
    }

    public static <T> Sequence<T> sortedWith(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new i(sequence, comparator);
    }

    public static <T> Sequence<T> takeWhile(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new l0(sequence, predicate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object elementAt$lambda$0$SequencesKt___SequencesKt(int i2, int i3) {
        throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + i2 + '.');
    }

    public static final <T> T elementAtOrNull(Sequence<? extends T> sequence, int i2) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (i2 < 0) {
            return null;
        }
        int i3 = 0;
        for (T t : sequence) {
            int i4 = i3 + 1;
            if (i2 == i3) {
                return t;
            }
            i3 = i4;
        }
        return null;
    }

    public static <T> Sequence<T> filter(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new kotlin.sequences.h(sequence, true, predicate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean filterIndexed$lambda$2$SequencesKt___SequencesKt(Function2 function2, IndexedValue it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return ((Boolean) function2.invoke(Integer.valueOf(it2.getIndex()), it2.getValue())).booleanValue();
    }

    public static <T> Sequence<T> filterNot(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new kotlin.sequences.h(sequence, false, predicate);
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Sequence<? extends T> sequence, C destination) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t : sequence) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    public static <T, R> Sequence<R> flatMap(Sequence<? extends T> sequence, Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new kotlin.sequences.i(sequence, transform, SequencesKt___SequencesKt$flatMap$2.INSTANCE);
    }

    public static final <T, R> Sequence<R> flatMapIndexedIterable(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return SequencesKt__SequencesKt.flatMapIndexed(sequence, transform, SequencesKt___SequencesKt$flatMapIndexed$1.INSTANCE);
    }

    public static final <T, R> Sequence<R> flatMapIndexedSequence(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return SequencesKt__SequencesKt.flatMapIndexed(sequence, transform, SequencesKt___SequencesKt$flatMapIndexed$2.INSTANCE);
    }

    public static final <T, R> Sequence<R> flatMapIterable(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new kotlin.sequences.i(sequence, transform, SequencesKt___SequencesKt$flatMap$1.INSTANCE);
    }

    public static final <T> void forEach(Sequence<? extends T> sequence, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            action.invoke(it2.next());
        }
    }

    public static final <T, R> Sequence<R> mapIndexedNotNull(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return filterNotNull(new m0(sequence, transform));
    }

    public static <T, R> Sequence<R> mapNotNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return filterNotNull(new n0(sequence, transform));
    }

    public static final <T> Sequence<T> minus(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return new d(sequence, t);
    }

    public static final <T> Sequence<T> onEach(Sequence<? extends T> sequence, final Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        return map(sequence, new Function1() { // from class: kotlin.sequences.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object onEach$lambda$14$SequencesKt___SequencesKt;
                onEach$lambda$14$SequencesKt___SequencesKt = SequencesKt___SequencesKt.onEach$lambda$14$SequencesKt___SequencesKt(Function1.this, obj);
                return onEach$lambda$14$SequencesKt___SequencesKt;
            }
        });
    }

    public static final <T> Sequence<T> onEachIndexed(Sequence<? extends T> sequence, final Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        return mapIndexed(sequence, new Function2() { // from class: kotlin.sequences.w
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Object onEachIndexed$lambda$15$SequencesKt___SequencesKt;
                onEachIndexed$lambda$15$SequencesKt___SequencesKt = SequencesKt___SequencesKt.onEachIndexed$lambda$15$SequencesKt___SequencesKt(Function2.this, ((Integer) obj).intValue(), obj2);
                return onEachIndexed$lambda$15$SequencesKt___SequencesKt;
            }
        });
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf(sequence, CollectionsKt___CollectionsKt.asSequence(elements)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object requireNoNulls$lambda$16$SequencesKt___SequencesKt(Sequence sequence, Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException("null element found in " + sequence + '.');
    }

    public static final <S, T extends S> Sequence<S> runningReduce(Sequence<? extends T> sequence, Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return SequencesKt__SequenceBuilderKt.sequence(new SequencesKt___SequencesKt$runningReduce$1(sequence, operation, null));
    }

    public static final <S, T extends S> Sequence<S> runningReduceIndexed(Sequence<? extends T> sequence, Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return SequencesKt__SequenceBuilderKt.sequence(new SequencesKt___SequencesKt$runningReduceIndexed$1(sequence, operation, null));
    }

    public static final <T, R extends Comparable<? super R>> Sequence<T> sortedBy(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(sequence, new ComparisonsKt__ComparisonsKt.a(selector));
    }

    public static final <T, R extends Comparable<? super R>> Sequence<T> sortedByDescending(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(sequence, new ComparisonsKt__ComparisonsKt.c(selector));
    }

    public static <T, C extends Collection<? super T>> C toCollection(Sequence<? extends T> sequence, C destination) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            destination.add(it2.next());
        }
        return destination;
    }

    public static final <T, R> Sequence<Pair<T, R>> zip(Sequence<? extends T> sequence, Sequence<? extends R> other) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new l(sequence, other, new Function2() { // from class: kotlin.sequences.z
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Pair pair;
                pair = TuplesKt.to(obj, obj2);
                return pair;
            }
        });
    }

    public static final <T, R> Sequence<R> zipWithNext(Sequence<? extends T> sequence, Function2<? super T, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return SequencesKt__SequenceBuilderKt.sequence(new SequencesKt___SequencesKt$zipWithNext$2(sequence, transform, null));
    }

    public static final <T> boolean all(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            if (!predicate.invoke(it2.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            if (predicate.invoke(it2.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T, K, V> Map<K, V> associate(Sequence<? extends T> sequence, Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it2.next());
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <T, K> Map<K, T> associateBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : sequence) {
            linkedHashMap.put(keySelector.invoke(t), t);
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> associateWith(Sequence<? extends K> sequence, Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (K k : sequence) {
            linkedHashMap.put(k, valueSelector.invoke(k));
        }
        return linkedHashMap;
    }

    public static final <T> int count(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            if (predicate.invoke(it2.next()).booleanValue() && (i2 = i2 + 1) < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        return i2;
    }

    public static <T> Sequence<T> filterIndexed(Sequence<? extends T> sequence, final Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new n0(new kotlin.sequences.h(new k(sequence), true, new Function1() { // from class: kotlin.sequences.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean filterIndexed$lambda$2$SequencesKt___SequencesKt;
                filterIndexed$lambda$2$SequencesKt___SequencesKt = SequencesKt___SequencesKt.filterIndexed$lambda$2$SequencesKt___SequencesKt(Function2.this, (IndexedValue) obj);
                return Boolean.valueOf(filterIndexed$lambda$2$SequencesKt___SequencesKt);
            }
        }), new Function1() { // from class: kotlin.sequences.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object filterIndexed$lambda$3$SequencesKt___SequencesKt;
                filterIndexed$lambda$3$SequencesKt___SequencesKt = SequencesKt___SequencesKt.filterIndexed$lambda$3$SequencesKt___SequencesKt((IndexedValue) obj);
                return filterIndexed$lambda$3$SequencesKt___SequencesKt;
            }
        });
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Sequence<?> sequence, C destination) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (Object obj : sequence) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    private static final <T> T find(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : sequence) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    private static final <T> T findLast(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t = null;
        for (T t2 : sequence) {
            if (predicate.invoke(t2).booleanValue()) {
                t = t2;
            }
        }
        return t;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T first(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : sequence) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    private static final <T, R> R firstNotNullOf(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transform) {
        R r;
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (true) {
            if (it2.hasNext()) {
                r = transform.invoke(it2.next());
                if (r != null) {
                    break;
                }
            } else {
                r = null;
                break;
            }
        }
        if (r != null) {
            return r;
        }
        throw new NoSuchElementException("No element of the sequence was transformed to a non-null value.");
    }

    private static final <T, R> R firstNotNullOfOrNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            R invoke = transform.invoke(it2.next());
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T firstOrNull(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : sequence) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    public static final <T> void forEachIndexed(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int i2 = 0;
        for (T t : sequence) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i2), t);
            i2 = i3;
        }
    }

    public static final <T, K> Map<K, List<T>> groupBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : sequence) {
            K invoke = keySelector.invoke(t);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(t);
        }
        return linkedHashMap;
    }

    public static <T> int indexOf(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int i2 = 0;
        for (T t2 : sequence) {
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, t2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        for (T t : sequence) {
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (predicate.invoke(t).booleanValue()) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = -1;
        int i3 = 0;
        for (T t : sequence) {
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (predicate.invoke(t).booleanValue()) {
                i2 = i3;
            }
            i3++;
        }
        return i2;
    }

    public static final <T> int lastIndexOf(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int i2 = -1;
        int i3 = 0;
        for (T t2 : sequence) {
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, t2)) {
                i2 = i3;
            }
            i3++;
        }
        return i2;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    public static final <T, R extends Comparable<? super R>> T maxByOrNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        if (!it2.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it2.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it2.hasNext());
        return (T) next;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m1007maxOf(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            R invoke = selector.invoke(it2.next());
            while (it2.hasNext()) {
                R invoke2 = selector.invoke(it2.next());
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    private static final <T, R extends Comparable<? super R>> R maxOfOrNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R invoke = selector.invoke(it2.next());
        while (it2.hasNext()) {
            R invoke2 = selector.invoke(it2.next());
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T maxWithOrNull(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Object obj = (T) it2.next();
        while (it2.hasNext()) {
            Object obj2 = (T) it2.next();
            if (comparator.compare(obj, obj2) < 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T maxWithOrThrow(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            Object obj = (T) it2.next();
            while (it2.hasNext()) {
                Object obj2 = (T) it2.next();
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (T) obj2;
                }
            }
            return (T) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    public static final <T, R extends Comparable<? super R>> T minByOrNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        if (!it2.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it2.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it2.hasNext());
        return (T) next;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m1015minOf(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            R invoke = selector.invoke(it2.next());
            while (it2.hasNext()) {
                R invoke2 = selector.invoke(it2.next());
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    private static final <T, R extends Comparable<? super R>> R minOfOrNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R invoke = selector.invoke(it2.next());
        while (it2.hasNext()) {
            R invoke2 = selector.invoke(it2.next());
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T minWithOrNull(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Object obj = (T) it2.next();
        while (it2.hasNext()) {
            Object obj2 = (T) it2.next();
            if (comparator.compare(obj, obj2) > 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T minWithOrThrow(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            Object obj = (T) it2.next();
            while (it2.hasNext()) {
                Object obj2 = (T) it2.next();
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (T) obj2;
                }
            }
            return (T) obj;
        }
        throw new NoSuchElementException();
    }

    public static final <T> Sequence<T> minus(Sequence<? extends T> sequence, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return new g(elements, sequence);
    }

    public static final <T> boolean none(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            if (predicate.invoke(it2.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> Pair<List<T>, List<T>> partition(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : sequence) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static <T> Sequence<T> plus(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf(sequence, SequencesKt__SequencesKt.sequenceOf(t)));
    }

    public static final <S, T extends S> S reduce(Sequence<? extends T> sequence, Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            S next = it2.next();
            while (it2.hasNext()) {
                next = operation.invoke(next, it2.next());
            }
            return next;
        }
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(Sequence<? extends T> sequence, Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            S next = it2.next();
            int i2 = 1;
            while (it2.hasNext()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                next = operation.invoke(Integer.valueOf(i2), next, it2.next());
                i2 = i3;
            }
            return next;
        }
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexedOrNull(Sequence<? extends T> sequence, Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        S next = it2.next();
        int i2 = 1;
        while (it2.hasNext()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            next = operation.invoke(Integer.valueOf(i2), next, it2.next());
            i2 = i3;
        }
        return next;
    }

    public static final <S, T extends S> S reduceOrNull(Sequence<? extends T> sequence, Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        S next = it2.next();
        while (it2.hasNext()) {
            next = operation.invoke(next, it2.next());
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    public static final <T> T singleOrNull(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z = false;
        T t = null;
        for (T t2 : sequence) {
            if (predicate.invoke(t2).booleanValue()) {
                if (z) {
                    return null;
                }
                z = true;
                t = t2;
            }
        }
        if (!z) {
            return null;
        }
        return t;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> int sumBy(Sequence<? extends T> sequence, Function1<? super T, Integer> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 += selector.invoke(it2.next()).intValue();
        }
        return i2;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> double sumByDouble(Sequence<? extends T> sequence, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        double d2 = 0.0d;
        while (it2.hasNext()) {
            d2 += selector.invoke(it2.next()).doubleValue();
        }
        return d2;
    }

    private static final <T> double sumOfDouble(Sequence<? extends T> sequence, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        double d2 = 0.0d;
        while (it2.hasNext()) {
            d2 += selector.invoke(it2.next()).doubleValue();
        }
        return d2;
    }

    private static final <T> int sumOfInt(Sequence<? extends T> sequence, Function1<? super T, Integer> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 += selector.invoke(it2.next()).intValue();
        }
        return i2;
    }

    private static final <T> long sumOfLong(Sequence<? extends T> sequence, Function1<? super T, Long> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        long j = 0;
        while (it2.hasNext()) {
            j += selector.invoke(it2.next()).longValue();
        }
        return j;
    }

    private static final <T> int sumOfUInt(Sequence<? extends T> sequence, Function1<? super T, UInt> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int m790constructorimpl = UInt.m790constructorimpl(0);
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            m790constructorimpl = UInt.m790constructorimpl(m790constructorimpl + selector.invoke(it2.next()).m842unboximpl());
        }
        return m790constructorimpl;
    }

    private static final <T> long sumOfULong(Sequence<? extends T> sequence, Function1<? super T, ULong> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long m850constructorimpl = ULong.m850constructorimpl(0L);
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            m850constructorimpl = ULong.m850constructorimpl(m850constructorimpl + selector.invoke(it2.next()).m902unboximpl());
        }
        return m850constructorimpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> drop(Sequence<? extends T> sequence, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 != 0) {
                if (sequence instanceof kotlin.sequences.e) {
                    return ((kotlin.sequences.e) sequence).b(i2);
                }
                return new kotlin.sequences.d(sequence, i2);
            }
            return sequence;
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T last(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : sequence) {
            if (predicate.invoke(t2).booleanValue()) {
                z = true;
                t = t2;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    public static final <T> T lastOrNull(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t = null;
        for (T t2 : sequence) {
            if (predicate.invoke(t2).booleanValue()) {
                t = t2;
            }
        }
        return t;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    public static final <T, R extends Comparable<? super R>> T maxByOrThrow(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            if (!it2.hasNext()) {
                return next;
            }
            R invoke = selector.invoke(next);
            do {
                T next2 = it2.next();
                R invoke2 = selector.invoke(next2);
                next = next;
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                    next = next2;
                }
            } while (it2.hasNext());
            return (T) next;
        }
        throw new NoSuchElementException();
    }

    private static final <T> double maxOf(Sequence<? extends T> sequence, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            double doubleValue = selector.invoke(it2.next()).doubleValue();
            while (it2.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(it2.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Double m1008maxOfOrNull(Sequence<? extends T> sequence, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke(it2.next()).doubleValue();
        while (it2.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(it2.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    public static final <T, R extends Comparable<? super R>> T minByOrThrow(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            if (!it2.hasNext()) {
                return next;
            }
            R invoke = selector.invoke(next);
            do {
                T next2 = it2.next();
                R invoke2 = selector.invoke(next2);
                next = next;
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                    next = next2;
                }
            } while (it2.hasNext());
            return (T) next;
        }
        throw new NoSuchElementException();
    }

    private static final <T> double minOf(Sequence<? extends T> sequence, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            double doubleValue = selector.invoke(it2.next()).doubleValue();
            while (it2.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(it2.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Double m1016minOfOrNull(Sequence<? extends T> sequence, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke(it2.next()).doubleValue();
        while (it2.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(it2.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> minus(Sequence<? extends T> sequence, T[] elements) {
        boolean z;
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return sequence;
        }
        return new e(sequence, elements);
    }

    public static <T> Sequence<T> plus(Sequence<? extends T> sequence, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf(sequence, elements));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T single(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : sequence) {
            if (predicate.invoke(t2).booleanValue()) {
                if (!z) {
                    z = true;
                    t = t2;
                } else {
                    throw new IllegalArgumentException("Sequence contains more than one matching element.");
                }
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static <T> Sequence<T> take(Sequence<? extends T> sequence, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 == 0) {
                return SequencesKt__SequencesKt.emptySequence();
            }
            if (sequence instanceof kotlin.sequences.e) {
                return ((kotlin.sequences.e) sequence).a(i2);
            }
            return new k0(sequence, i2);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final <T> float m1006maxOf(Sequence<? extends T> sequence, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            float floatValue = selector.invoke(it2.next()).floatValue();
            while (it2.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(it2.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Float m1009maxOfOrNull(Sequence<? extends T> sequence, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke(it2.next()).floatValue();
        while (it2.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(it2.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final <T> float m1014minOf(Sequence<? extends T> sequence, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            float floatValue = selector.invoke(it2.next()).floatValue();
            while (it2.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(it2.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Float m1017minOfOrNull(Sequence<? extends T> sequence, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke(it2.next()).floatValue();
        while (it2.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(it2.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, T[] elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return plus((Sequence) sequence, (Iterable) ArraysKt___ArraysJvmKt.asList(elements));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onEachIndexed$lambda$15$SequencesKt___SequencesKt(Function2 function2, int i2, Object obj) {
        function2.invoke(Integer.valueOf(i2), obj);
        return obj;
    }

    public static final <T, R> Sequence<R> scan(Sequence<? extends T> sequence, R r, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return runningFold(sequence, r, operation);
    }

    public static final <T, R> Sequence<R> scanIndexed(Sequence<? extends T> sequence, R r, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return runningFoldIndexed(sequence, r, operation);
    }

    public static final <T, R> Sequence<R> chunked(Sequence<? extends T> sequence, int i2, Function1<? super List<? extends T>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return windowed(sequence, i2, i2, true, transform);
    }

    public static final <T, R> R fold(Sequence<? extends T> sequence, R r, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            r = operation.invoke(r, it2.next());
        }
        return r;
    }

    public static final <T, R> Sequence<R> runningFold(Sequence<? extends T> sequence, R r, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return SequencesKt__SequenceBuilderKt.sequence(new SequencesKt___SequencesKt$runningFold$1(r, sequence, operation, null));
    }

    public static final <T, R> Sequence<R> runningFoldIndexed(Sequence<? extends T> sequence, R r, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return SequencesKt__SequenceBuilderKt.sequence(new SequencesKt___SequencesKt$runningFoldIndexed$1(r, sequence, operation, null));
    }

    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(Sequence<? extends T> sequence, M destination, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t : sequence) {
            destination.put(keySelector.invoke(t), t);
        }
        return destination;
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(Sequence<? extends T> sequence, M destination, Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it2.next());
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(Sequence<? extends K> sequence, M destination, Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (K k : sequence) {
            destination.put(k, valueSelector.invoke(k));
        }
        return destination;
    }

    public static final <T> T elementAtOrElse(Sequence<? extends T> sequence, int i2, Function1<? super Integer, ? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (i2 < 0) {
            return defaultValue.invoke(Integer.valueOf(i2));
        }
        int i3 = 0;
        for (T t : sequence) {
            int i4 = i3 + 1;
            if (i2 == i3) {
                return t;
            }
            i3 = i4;
        }
        return defaultValue.invoke(Integer.valueOf(i2));
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(Sequence<? extends T> sequence, C destination, Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        for (T t : sequence) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (predicate.invoke(Integer.valueOf(i2), t).booleanValue()) {
                destination.add(t);
            }
            i2 = i3;
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(Sequence<? extends T> sequence, C destination, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : sequence) {
            if (!predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(Sequence<? extends T> sequence, C destination, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : sequence) {
            if (predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedIterableTo(Sequence<? extends T> sequence, C destination, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i2 = 0;
        for (T t : sequence) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i2), t));
            i2 = i3;
        }
        return destination;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedSequenceTo(Sequence<? extends T> sequence, C destination, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i2 = 0;
        for (T t : sequence) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i2), t));
            i2 = i3;
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapIterableTo(Sequence<? extends T> sequence, C destination, Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(it2.next()));
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(Sequence<? extends T> sequence, C destination, Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(it2.next()));
        }
        return destination;
    }

    public static final <T, R> R foldIndexed(Sequence<? extends T> sequence, R r, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 0;
        for (T t : sequence) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            r = operation.invoke(Integer.valueOf(i2), r, t);
            i2 = i3;
        }
        return r;
    }

    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(Sequence<? extends T> sequence, M destination, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t : sequence) {
            K invoke = keySelector.invoke(t);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(t);
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(Sequence<? extends T> sequence, C destination, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i2 = 0;
        for (T t : sequence) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            R invoke = transform.invoke(Integer.valueOf(i2), t);
            if (invoke != null) {
                destination.add(invoke);
            }
            i2 = i3;
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(Sequence<? extends T> sequence, C destination, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i2 = 0;
        for (T t : sequence) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            destination.add(transform.invoke(Integer.valueOf(i2), t));
            i2 = i3;
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(Sequence<? extends T> sequence, C destination, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            R invoke = transform.invoke(it2.next());
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(Sequence<? extends T> sequence, C destination, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            destination.add(transform.invoke(it2.next()));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, R> R maxOfWith(Sequence<? extends T> sequence, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            Object obj = (R) selector.invoke((T) it2.next());
            while (it2.hasNext()) {
                Object obj2 = (R) selector.invoke((T) it2.next());
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, R> R maxOfWithOrNull(Sequence<? extends T> sequence, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Object obj = (R) selector.invoke((T) it2.next());
        while (it2.hasNext()) {
            Object obj2 = (R) selector.invoke((T) it2.next());
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, R> R minOfWith(Sequence<? extends T> sequence, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            Object obj = (R) selector.invoke((T) it2.next());
            while (it2.hasNext()) {
                Object obj2 = (R) selector.invoke((T) it2.next());
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, R> R minOfWithOrNull(Sequence<? extends T> sequence, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Object obj = (R) selector.invoke((T) it2.next());
        while (it2.hasNext()) {
            Object obj2 = (R) selector.invoke((T) it2.next());
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    public static final <T, R, V> Sequence<V> zip(Sequence<? extends T> sequence, Sequence<? extends R> other, Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new l(sequence, other, transform);
    }

    public static final <T, K, V> Map<K, V> associateBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : sequence) {
            linkedHashMap.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    public static final <T, K, V> Map<K, List<V>> groupBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : sequence) {
            K invoke = keySelector.invoke(t);
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    public static final <T> Sequence<List<T>> windowed(Sequence<? extends T> sequence, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SlidingWindowKt.c(sequence, i2, i3, z, false);
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(Sequence<? extends T> sequence, M destination, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t : sequence) {
            destination.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(Sequence<? extends T> sequence, M destination, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t : sequence) {
            K invoke = keySelector.invoke(t);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(t));
        }
        return destination;
    }

    public static final <T, R> Sequence<R> windowed(Sequence<? extends T> sequence, int i2, int i3, boolean z, Function1<? super List<? extends T>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return map(SlidingWindowKt.c(sequence, i2, i3, z, true), transform);
    }

    public static /* synthetic */ Sequence windowed$default(Sequence sequence, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowed(sequence, i2, i3, z);
    }

    public static /* synthetic */ Sequence windowed$default(Sequence sequence, int i2, int i3, boolean z, Function1 function1, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowed(sequence, i2, i3, z, function1);
    }

    public static final <T> String joinToString(Sequence<? extends T> sequence, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(sequence, new StringBuilder(), separator, prefix, postfix, i2, truncated, function1)).toString();
    }

    public static final <T, A extends Appendable> A joinTo(Sequence<? extends T> sequence, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (T t : sequence) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            kotlin.text.m.appendElement(buffer, t, function1);
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ String joinToString$default(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        int i4;
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i3 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i3 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i3 & 8) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(sequence, charSequence, charSequence5, charSequence6, i4, charSequence7, function1);
    }

    public static /* synthetic */ Appendable joinTo$default(Sequence sequence, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i4;
        CharSequence charSequence7;
        Function1 function12;
        if ((i3 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i3 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i3 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i3 & 16) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i3 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return joinTo(sequence, appendable, charSequence5, charSequence6, charSequence8, i4, charSequence7, function12);
    }
}
