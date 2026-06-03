package kotlin.comparisons;

import com.bytedance.covode.number.Covode;
import java.util.Comparator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ComparisonsKt__ComparisonsKt {
    static {
        Covode.recordClassIndex(658259);
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        kotlin.comparisons.f fVar = kotlin.comparisons.f.a;
        Intrinsics.checkNotNull(fVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>");
        return fVar;
    }

    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        kotlin.comparisons.g gVar = kotlin.comparisons.g.a;
        Intrinsics.checkNotNull(gVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>");
        return gVar;
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return nullsFirst(naturalOrder());
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return nullsLast(naturalOrder());
    }

    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new a(selector);
    }

    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new c(selector);
    }

    public static final <T> Comparator<T> nullsFirst(final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new Comparator() { // from class: kotlin.comparisons.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt;
                nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt = ComparisonsKt__ComparisonsKt.nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(comparator, obj, obj2);
                return nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt;
            }
        };
    }

    public static final <T> Comparator<T> nullsLast(final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new Comparator() { // from class: kotlin.comparisons.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int nullsLast$lambda$4$ComparisonsKt__ComparisonsKt;
                nullsLast$lambda$4$ComparisonsKt__ComparisonsKt = ComparisonsKt__ComparisonsKt.nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(comparator, obj, obj2);
                return nullsLast$lambda$4$ComparisonsKt__ComparisonsKt;
            }
        };
    }

    public static <T> Comparator<T> compareBy(final Function1<? super T, ? extends Comparable<?>>... selectors) {
        boolean z;
        Intrinsics.checkNotNullParameter(selectors, "selectors");
        if (selectors.length > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new Comparator() { // from class: kotlin.comparisons.b
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int compareBy$lambda$0$ComparisonsKt__ComparisonsKt;
                    compareBy$lambda$0$ComparisonsKt__ComparisonsKt = ComparisonsKt__ComparisonsKt.compareBy$lambda$0$ComparisonsKt__ComparisonsKt(selectors, obj, obj2);
                    return compareBy$lambda$0$ComparisonsKt__ComparisonsKt;
                }
            };
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final <T> Comparator<T> reversed(Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        if (comparator instanceof kotlin.comparisons.h) {
            return ((kotlin.comparisons.h) comparator).a;
        }
        Comparator<T> comparator2 = kotlin.comparisons.f.a;
        if (Intrinsics.areEqual(comparator, comparator2)) {
            kotlin.comparisons.g gVar = kotlin.comparisons.g.a;
            Intrinsics.checkNotNull(gVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>");
            return gVar;
        }
        if (Intrinsics.areEqual(comparator, kotlin.comparisons.g.a)) {
            Intrinsics.checkNotNull(comparator2, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>");
        } else {
            comparator2 = new kotlin.comparisons.h<>(comparator);
        }
        return comparator2;
    }

    private static final <T, K> Comparator<T> compareBy(Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new b(comparator, selector);
    }

    private static final <T, K> Comparator<T> compareByDescending(Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new d(comparator, selector);
    }

    public static final <T> Comparator<T> then(final Comparator<T> comparator, final Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new Comparator() { // from class: kotlin.comparisons.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int then$lambda$1$ComparisonsKt__ComparisonsKt;
                then$lambda$1$ComparisonsKt__ComparisonsKt = ComparisonsKt__ComparisonsKt.then$lambda$1$ComparisonsKt__ComparisonsKt(comparator, comparator2, obj, obj2);
                return then$lambda$1$ComparisonsKt__ComparisonsKt;
            }
        };
    }

    private static final <T> Comparator<T> thenBy(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new e(comparator, selector);
    }

    private static final <T> Comparator<T> thenByDescending(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new g(comparator, selector);
    }

    private static final <T> Comparator<T> thenComparator(Comparator<T> comparator, Function2<? super T, ? super T, Integer> comparison) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparison, "comparison");
        return new i(comparator, comparison);
    }

    public static final <T> Comparator<T> thenDescending(final Comparator<T> comparator, final Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new Comparator() { // from class: kotlin.comparisons.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int thenDescending$lambda$2$ComparisonsKt__ComparisonsKt;
                thenDescending$lambda$2$ComparisonsKt__ComparisonsKt = ComparisonsKt__ComparisonsKt.thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(comparator, comparator2, obj, obj2);
                return thenDescending$lambda$2$ComparisonsKt__ComparisonsKt;
            }
        };
    }

    public static final class a<T> implements Comparator {
        final /* synthetic */ Function1<T, Comparable<?>> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super T, ? extends Comparable<?>> function1) {
            this.a = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compareValues;
            Function1<T, Comparable<?>> function1 = this.a;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(function1.invoke(t), function1.invoke(t2));
            return compareValues;
        }
    }

    public static final class b<T> implements Comparator {
        final /* synthetic */ Comparator<? super K> a;
        final /* synthetic */ Function1<T, K> b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
            this.a = comparator;
            this.b = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Comparator<? super K> comparator = this.a;
            Function1<T, K> function1 = this.b;
            return comparator.compare(function1.invoke(t), function1.invoke(t2));
        }
    }

    public static final class c<T> implements Comparator {
        final /* synthetic */ Function1<T, Comparable<?>> a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super T, ? extends Comparable<?>> function1) {
            this.a = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compareValues;
            Function1<T, Comparable<?>> function1 = this.a;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(function1.invoke(t2), function1.invoke(t));
            return compareValues;
        }
    }

    public static final class d<T> implements Comparator {
        final /* synthetic */ Comparator<? super K> a;
        final /* synthetic */ Function1<T, K> b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
            this.a = comparator;
            this.b = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Comparator<? super K> comparator = this.a;
            Function1<T, K> function1 = this.b;
            return comparator.compare(function1.invoke(t2), function1.invoke(t));
        }
    }

    public static final class e<T> implements Comparator {
        final /* synthetic */ Comparator<T> a;
        final /* synthetic */ Function1<T, Comparable<?>> b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> function1) {
            this.a = comparator;
            this.b = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compareValues;
            int compare = this.a.compare(t, t2);
            if (compare == 0) {
                Function1<T, Comparable<?>> function1 = this.b;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(function1.invoke(t), function1.invoke(t2));
                return compareValues;
            }
            return compare;
        }
    }

    public static final class f<T> implements Comparator {
        final /* synthetic */ Comparator<T> a;
        final /* synthetic */ Comparator<? super K> b;
        final /* synthetic */ Function1<T, K> c;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> function1) {
            this.a = comparator;
            this.b = comparator2;
            this.c = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.a.compare(t, t2);
            if (compare == 0) {
                Comparator<? super K> comparator = this.b;
                Function1<T, K> function1 = this.c;
                return comparator.compare(function1.invoke(t), function1.invoke(t2));
            }
            return compare;
        }
    }

    public static final class g<T> implements Comparator {
        final /* synthetic */ Comparator<T> a;
        final /* synthetic */ Function1<T, Comparable<?>> b;

        /* JADX WARN: Multi-variable type inference failed */
        public g(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> function1) {
            this.a = comparator;
            this.b = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compareValues;
            int compare = this.a.compare(t, t2);
            if (compare == 0) {
                Function1<T, Comparable<?>> function1 = this.b;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(function1.invoke(t2), function1.invoke(t));
                return compareValues;
            }
            return compare;
        }
    }

    public static final class h<T> implements Comparator {
        final /* synthetic */ Comparator<T> a;
        final /* synthetic */ Comparator<? super K> b;
        final /* synthetic */ Function1<T, K> c;

        /* JADX WARN: Multi-variable type inference failed */
        public h(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> function1) {
            this.a = comparator;
            this.b = comparator2;
            this.c = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.a.compare(t, t2);
            if (compare == 0) {
                Comparator<? super K> comparator = this.b;
                Function1<T, K> function1 = this.c;
                return comparator.compare(function1.invoke(t2), function1.invoke(t));
            }
            return compare;
        }
    }

    public static final class i<T> implements Comparator {
        final /* synthetic */ Comparator<T> a;
        final /* synthetic */ Function2<T, T, Integer> b;

        /* JADX WARN: Multi-variable type inference failed */
        public i(Comparator<T> comparator, Function2<? super T, ? super T, Integer> function2) {
            this.a = comparator;
            this.b = function2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.a.compare(t, t2);
            if (compare == 0) {
                return this.b.invoke(t, t2).intValue();
            }
            return compare;
        }
    }

    public static <T extends Comparable<?>> int compareValues(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int compareBy$lambda$0$ComparisonsKt__ComparisonsKt(Function1[] function1Arr, Object obj, Object obj2) {
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(obj, obj2, function1Arr);
    }

    private static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T t, T t2, Function1<? super T, ? extends Comparable<?>>[] function1Arr) {
        int compareValues;
        for (Function1<? super T, ? extends Comparable<?>> function1 : function1Arr) {
            compareValues = compareValues(function1.invoke(t), function1.invoke(t2));
            if (compareValues != 0) {
                return compareValues;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(Comparator comparator, Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return comparator.compare(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(Comparator comparator, Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return comparator.compare(obj, obj2);
    }

    private static final <T, K> Comparator<T> thenBy(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new f(comparator, comparator2, selector);
    }

    private static final <T, K> Comparator<T> thenByDescending(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new h(comparator, comparator2, selector);
    }

    private static final <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>> selector) {
        int compareValues;
        Intrinsics.checkNotNullParameter(selector, "selector");
        compareValues = compareValues(selector.invoke(t), selector.invoke(t2));
        return compareValues;
    }

    public static <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>>... selectors) {
        boolean z;
        Intrinsics.checkNotNullParameter(selectors, "selectors");
        if (selectors.length > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return compareValuesByImpl$ComparisonsKt__ComparisonsKt(t, t2, selectors);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int then$lambda$1$ComparisonsKt__ComparisonsKt(Comparator comparator, Comparator comparator2, Object obj, Object obj2) {
        int compare = comparator.compare(obj, obj2);
        if (compare == 0) {
            return comparator2.compare(obj, obj2);
        }
        return compare;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(Comparator comparator, Comparator comparator2, Object obj, Object obj2) {
        int compare = comparator.compare(obj, obj2);
        if (compare == 0) {
            return comparator2.compare(obj2, obj);
        }
        return compare;
    }

    private static final <T, K> int compareValuesBy(T t, T t2, Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return comparator.compare(selector.invoke(t), selector.invoke(t2));
    }
}
