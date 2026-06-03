package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Unit;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SetsKt__SetsJVMKt {
    static {
        Covode.recordClassIndex(658221);
    }

    public static <E> Set<E> createSetBuilder() {
        return new SetBuilder();
    }

    public static <E> Set<E> build(Set<E> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((SetBuilder) builder).build();
    }

    public static <E> Set<E> createSetBuilder(int i) {
        return new SetBuilder(i);
    }

    public static <T> Set<T> setOf(T t) {
        Set<T> singleton = Collections.singleton(t);
        Intrinsics.checkNotNullExpressionValue(singleton, "singleton(...)");
        return singleton;
    }

    private static final <E> Set<E> buildSetInternal(Function1<? super Set<E>, Unit> builderAction) {
        Set createSetBuilder;
        Set<E> build;
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        createSetBuilder = createSetBuilder();
        builderAction.invoke(createSetBuilder);
        build = build(createSetBuilder);
        return build;
    }

    public static final <T> TreeSet<T> sortedSetOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (TreeSet) ArraysKt___ArraysKt.toCollection(elements, new TreeSet());
    }

    private static final <E> Set<E> buildSetInternal(int i, Function1<? super Set<E>, Unit> builderAction) {
        Set createSetBuilder;
        Set<E> build;
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        createSetBuilder = createSetBuilder(i);
        builderAction.invoke(createSetBuilder);
        build = build(createSetBuilder);
        return build;
    }

    public static <T> TreeSet<T> sortedSetOf(Comparator<? super T> comparator, T... elements) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (TreeSet) ArraysKt___ArraysKt.toCollection(elements, new TreeSet(comparator));
    }
}
