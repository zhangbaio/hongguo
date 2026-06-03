package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    static {
        Covode.recordClassIndex(658222);
    }

    public static <T> Set<T> emptySet() {
        return EmptySet.INSTANCE;
    }

    private static final <T> HashSet<T> hashSetOf() {
        return new HashSet<>();
    }

    private static final <T> LinkedHashSet<T> linkedSetOf() {
        return new LinkedHashSet<>();
    }

    private static final <T> Set<T> mutableSetOf() {
        return new LinkedHashSet();
    }

    private static final <T> Set<T> setOf() {
        Set<T> emptySet;
        emptySet = emptySet();
        return emptySet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Set<T> orEmpty(Set<? extends T> set) {
        Set<T> emptySet;
        if (set == 0) {
            emptySet = emptySet();
            return emptySet;
        }
        return set;
    }

    public static <T> Set<T> setOf(T... elements) {
        Set<T> set;
        Intrinsics.checkNotNullParameter(elements, "elements");
        set = ArraysKt___ArraysKt.toSet(elements);
        return set;
    }

    public static final <T> Set<T> setOfNotNull(T t) {
        Set<T> emptySet;
        Set<T> of;
        if (t != null) {
            of = SetsKt__SetsJVMKt.setOf(t);
            return of;
        }
        emptySet = emptySet();
        return emptySet;
    }

    public static <T> HashSet<T> hashSetOf(T... elements) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(elements.length);
        return (HashSet) ArraysKt___ArraysKt.toCollection(elements, new HashSet(mapCapacity));
    }

    public static final <T> LinkedHashSet<T> linkedSetOf(T... elements) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(elements.length);
        return (LinkedHashSet) ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(mapCapacity));
    }

    public static <T> Set<T> mutableSetOf(T... elements) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(elements.length);
        return (Set) ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(mapCapacity));
    }

    public static final <T> Set<T> setOfNotNull(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (Set) ArraysKt___ArraysKt.filterNotNullTo(elements, new LinkedHashSet());
    }

    private static final <E> Set<E> buildSet(Function1<? super Set<E>, Unit> builderAction) {
        Set createSetBuilder;
        Set<E> build;
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder();
        builderAction.invoke(createSetBuilder);
        build = SetsKt__SetsJVMKt.build(createSetBuilder);
        return build;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        Set<T> emptySet;
        Set<T> of;
        Intrinsics.checkNotNullParameter(set, "<this>");
        int size = set.size();
        if (size != 0) {
            if (size == 1) {
                of = SetsKt__SetsJVMKt.setOf(set.iterator().next());
                return of;
            }
            return set;
        }
        emptySet = emptySet();
        return emptySet;
    }

    private static final <E> Set<E> buildSet(int i, Function1<? super Set<E>, Unit> builderAction) {
        Set createSetBuilder;
        Set<E> build;
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder(i);
        builderAction.invoke(createSetBuilder);
        build = SetsKt__SetsJVMKt.build(createSetBuilder);
        return build;
    }
}
