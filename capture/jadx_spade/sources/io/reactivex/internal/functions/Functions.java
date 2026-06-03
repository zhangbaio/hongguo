package io.reactivex.internal.functions;

import com.bytedance.covode.number.Covode;
import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Functions {
    static final Predicate<Object> ALWAYS_FALSE;
    static final Predicate<Object> ALWAYS_TRUE;
    public static final Action EMPTY_ACTION;
    static final Consumer<Object> EMPTY_CONSUMER;
    public static final lm6.a EMPTY_LONG_CONSUMER;
    public static final Runnable EMPTY_RUNNABLE;
    public static final Consumer<Throwable> ERROR_CONSUMER;
    static final Function<Object, Object> IDENTITY;
    static final Comparator<Object> NATURAL_COMPARATOR;
    static final Callable<Object> NULL_SUPPLIER;
    public static final Consumer<Throwable> ON_ERROR_MISSING;
    public static final Consumer<Subscription> REQUEST_MAX;

    static final class e0 implements Callable<Object> {
        static {
            Covode.recordClassIndex(656340);
        }

        e0() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    static final class k0 implements Predicate<Object> {
        static {
            Covode.recordClassIndex(656346);
        }

        k0() {
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return true;
        }
    }

    static final class o implements Action {
        static {
            Covode.recordClassIndex(656322);
        }

        o() {
        }

        @Override // io.reactivex.functions.Action
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class p implements Consumer<Object> {
        static {
            Covode.recordClassIndex(656323);
        }

        p() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class q implements lm6.a {
        static {
            Covode.recordClassIndex(656324);
        }

        q() {
        }

        @Override // lm6.a
        public void accept(long j) {
        }
    }

    static final class r implements Runnable {
        static {
            Covode.recordClassIndex(656325);
        }

        r() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class u implements Predicate<Object> {
        static {
            Covode.recordClassIndex(656328);
        }

        u() {
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return false;
        }
    }

    static final class w implements Function<Object, Object> {
        static {
            Covode.recordClassIndex(656331);
        }

        w() {
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class x<T, U> implements Callable<U>, Function<T, U> {
        final U a;

        static {
            Covode.recordClassIndex(656332);
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.a;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T t) throws Exception {
            return this.a;
        }

        x(U u) {
            this.a = u;
        }
    }

    public static <T> Predicate<T> alwaysFalse() {
        return (Predicate<T>) ALWAYS_FALSE;
    }

    public static <T> Predicate<T> alwaysTrue() {
        return (Predicate<T>) ALWAYS_TRUE;
    }

    public static <T> Callable<Set<T>> createHashSet() {
        return HashSetCallable.INSTANCE;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return (Consumer<T>) EMPTY_CONSUMER;
    }

    public static <T> Function<T, T> identity() {
        return (Function<T, T>) IDENTITY;
    }

    public static <T> Comparator<T> naturalComparator() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Comparator<T> naturalOrder() {
        return (Comparator<T>) NATURAL_COMPARATOR;
    }

    public static <T> Callable<T> nullSupplier() {
        return (Callable<T>) NULL_SUPPLIER;
    }

    static final class v implements Action {
        final Future<?> a;

        static {
            Covode.recordClassIndex(656329);
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.a.get();
        }

        v(Future<?> future) {
            this.a = future;
        }
    }

    enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }

        static {
            Covode.recordClassIndex(656330);
        }
    }

    static final class b0<T> implements Action {
        final Consumer<? super Notification<T>> a;

        static {
            Covode.recordClassIndex(656337);
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.a.accept(Notification.createOnComplete());
        }

        b0(Consumer<? super Notification<T>> consumer) {
            this.a = consumer;
        }
    }

    static final class j<T> implements Callable<List<T>> {
        final int a;

        static {
            Covode.recordClassIndex(656317);
        }

        @Override // java.util.concurrent.Callable
        public List<T> call() throws Exception {
            return new ArrayList(this.a);
        }

        j(int i) {
            this.a = i;
        }
    }

    private Functions() {
        throw new IllegalStateException("No instances!");
    }

    enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        static {
            Covode.recordClassIndex(656335);
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static {
        Covode.recordClassIndex(656307);
        IDENTITY = new w();
        EMPTY_RUNNABLE = new r();
        EMPTY_ACTION = new o();
        EMPTY_CONSUMER = new p();
        ERROR_CONSUMER = new t();
        ON_ERROR_MISSING = new f0();
        EMPTY_LONG_CONSUMER = new q();
        ALWAYS_TRUE = new k0();
        ALWAYS_FALSE = new u();
        NULL_SUPPLIER = new e0();
        NATURAL_COMPARATOR = new a0();
        REQUEST_MAX = new z();
    }

    static final class t implements Consumer<Throwable> {
        static {
            Covode.recordClassIndex(656327);
        }

        t() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            RxJavaPlugins.onError(th);
        }
    }

    static final class a<T> implements Consumer<T> {
        final Action a;

        static {
            Covode.recordClassIndex(656308);
        }

        a(Action action) {
            this.a = action;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws Exception {
            this.a.run();
        }
    }

    static final class b<T1, T2, R> implements Function<Object[], R> {
        final BiFunction<? super T1, ? super T2, ? extends R> a;

        static {
            Covode.recordClassIndex(656309);
        }

        b(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.a = biFunction;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    static final class c<T1, T2, T3, R> implements Function<Object[], R> {
        final Function3<T1, T2, T3, R> a;

        static {
            Covode.recordClassIndex(656310);
        }

        c(Function3<T1, T2, T3, R> function3) {
            this.a = function3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return (R) this.a.apply(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    static final class c0<T> implements Consumer<Throwable> {
        final Consumer<? super Notification<T>> a;

        static {
            Covode.recordClassIndex(656338);
        }

        c0(Consumer<? super Notification<T>> consumer) {
            this.a = consumer;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.a.accept(Notification.createOnError(th));
        }
    }

    static final class d<T1, T2, T3, T4, R> implements Function<Object[], R> {
        final Function4<T1, T2, T3, T4, R> a;

        static {
            Covode.recordClassIndex(656311);
        }

        d(Function4<T1, T2, T3, T4, R> function4) {
            this.a = function4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return (R) this.a.apply(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    static final class d0<T> implements Consumer<T> {
        final Consumer<? super Notification<T>> a;

        static {
            Covode.recordClassIndex(656339);
        }

        d0(Consumer<? super Notification<T>> consumer) {
            this.a = consumer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws Exception {
            this.a.accept(Notification.createOnNext(t));
        }
    }

    static final class e<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {
        private final Function5<T1, T2, T3, T4, T5, R> a;

        static {
            Covode.recordClassIndex(656312);
        }

        e(Function5<T1, T2, T3, T4, T5, R> function5) {
            this.a = function5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 5) {
                return (R) this.a.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    static final class f<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {
        final Function6<T1, T2, T3, T4, T5, T6, R> a;

        static {
            Covode.recordClassIndex(656313);
        }

        f(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
            this.a = function6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 6) {
                return (R) this.a.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    static final class g<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {
        final Function7<T1, T2, T3, T4, T5, T6, T7, R> a;

        static {
            Covode.recordClassIndex(656314);
        }

        g(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
            this.a = function7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 7) {
                return (R) this.a.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {
        final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> a;

        static {
            Covode.recordClassIndex(656315);
        }

        h(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
            this.a = function8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 8) {
                return (R) this.a.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    static final class h0<K, T> implements BiConsumer<Map<K, T>, T> {
        private final Function<? super T, ? extends K> a;

        static {
            Covode.recordClassIndex(656343);
        }

        h0(Function<? super T, ? extends K> function) {
            this.a = function;
        }

        @Override // io.reactivex.functions.BiConsumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map<K, T> map, T t) throws Exception {
            map.put(this.a.apply(t), t);
        }
    }

    static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {
        final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a;

        static {
            Covode.recordClassIndex(656316);
        }

        i(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
            this.a = function9;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 9) {
                return (R) this.a.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    static final class k<T> implements Predicate<T> {
        final BooleanSupplier a;

        static {
            Covode.recordClassIndex(656318);
        }

        k(BooleanSupplier booleanSupplier) {
            this.a = booleanSupplier;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t) throws Exception {
            return !this.a.getAsBoolean();
        }
    }

    public static class l implements Consumer<Subscription> {
        final int a;

        static {
            Covode.recordClassIndex(656319);
        }

        l(int i) {
            this.a = i;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Subscription subscription) throws Exception {
            subscription.request(this.a);
        }
    }

    static final class m<T, U> implements Function<T, U> {
        final Class<U> a;

        static {
            Covode.recordClassIndex(656320);
        }

        m(Class<U> cls) {
            this.a = cls;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T t) throws Exception {
            return this.a.cast(t);
        }
    }

    static final class n<T, U> implements Predicate<T> {
        final Class<U> a;

        static {
            Covode.recordClassIndex(656321);
        }

        n(Class<U> cls) {
            this.a = cls;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t) throws Exception {
            return this.a.isInstance(t);
        }
    }

    static final class s<T> implements Predicate<T> {
        final T a;

        static {
            Covode.recordClassIndex(656326);
        }

        s(T t) {
            this.a = t;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t) throws Exception {
            return ObjectHelper.equals(t, this.a);
        }
    }

    static final class y<T> implements Function<List<T>, List<T>> {
        final Comparator<? super T> a;

        static {
            Covode.recordClassIndex(656333);
        }

        y(Comparator<? super T> comparator) {
            this.a = comparator;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.a);
            return list;
        }
    }

    public static <T> Consumer<T> actionConsumer(Action action) {
        return new a(action);
    }

    public static <T> Consumer<T> boundedConsumer(int i2) {
        return new l(i2);
    }

    public static <T, U> Function<T, U> castFunction(Class<U> cls) {
        return new m(cls);
    }

    public static <T> Callable<List<T>> createArrayList(int i2) {
        return new j(i2);
    }

    public static <T> Predicate<T> equalsWith(T t2) {
        return new s(t2);
    }

    public static Action futureAction(Future<?> future) {
        return new v(future);
    }

    public static <T, U> Predicate<T> isInstanceOf(Class<U> cls) {
        return new n(cls);
    }

    public static <T> Callable<T> justCallable(T t2) {
        return new x(t2);
    }

    public static <T, U> Function<T, U> justFunction(U u2) {
        return new x(u2);
    }

    public static <T> Function<List<T>, List<T>> listSorter(Comparator<? super T> comparator) {
        return new y(comparator);
    }

    public static <T> Action notificationOnComplete(Consumer<? super Notification<T>> consumer) {
        return new b0(consumer);
    }

    public static <T> Consumer<Throwable> notificationOnError(Consumer<? super Notification<T>> consumer) {
        return new c0(consumer);
    }

    public static <T> Consumer<T> notificationOnNext(Consumer<? super Notification<T>> consumer) {
        return new d0(consumer);
    }

    public static <T> Predicate<T> predicateReverseFor(BooleanSupplier booleanSupplier) {
        return new k(booleanSupplier);
    }

    public static <T, K> BiConsumer<Map<K, T>, T> toMapKeySelector(Function<? super T, ? extends K> function) {
        return new h0(function);
    }

    static final class f0 implements Consumer<Throwable> {
        static {
            Covode.recordClassIndex(656341);
        }

        f0() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            RxJavaPlugins.onError(new OnErrorNotImplementedException(th));
        }
    }

    static final class g0<T> implements Function<T, Timed<T>> {
        final TimeUnit a;
        final Scheduler b;

        static {
            Covode.recordClassIndex(656342);
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Timed<T> apply(T t) throws Exception {
            return new Timed<>(t, this.b.now(this.a), this.a);
        }

        g0(TimeUnit timeUnit, Scheduler scheduler) {
            this.a = timeUnit;
            this.b = scheduler;
        }
    }

    static final class z implements Consumer<Subscription> {
        static {
            Covode.recordClassIndex(656334);
        }

        z() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Subscription subscription) throws Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public static <T1, T2, R> Function<Object[], R> toFunction(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "f is null");
        return new b(biFunction);
    }

    public static <T1, T2, T3, R> Function<Object[], R> toFunction(Function3<T1, T2, T3, R> function3) {
        ObjectHelper.requireNonNull(function3, "f is null");
        return new c(function3);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> toFunction(Function4<T1, T2, T3, T4, R> function4) {
        ObjectHelper.requireNonNull(function4, "f is null");
        return new d(function4);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> toFunction(Function5<T1, T2, T3, T4, T5, R> function5) {
        ObjectHelper.requireNonNull(function5, "f is null");
        return new e(function5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> toFunction(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        ObjectHelper.requireNonNull(function6, "f is null");
        return new f(function6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> toFunction(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        ObjectHelper.requireNonNull(function7, "f is null");
        return new g(function7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> toFunction(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        ObjectHelper.requireNonNull(function8, "f is null");
        return new h(function8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> toFunction(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        ObjectHelper.requireNonNull(function9, "f is null");
        return new i(function9);
    }

    static final class a0 implements Comparator<Object> {
        static {
            Covode.recordClassIndex(656336);
        }

        a0() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class i0<K, V, T> implements BiConsumer<Map<K, V>, T> {
        private final Function<? super T, ? extends V> a;
        private final Function<? super T, ? extends K> b;

        static {
            Covode.recordClassIndex(656344);
        }

        i0(Function<? super T, ? extends V> function, Function<? super T, ? extends K> function2) {
            this.a = function;
            this.b = function2;
        }

        @Override // io.reactivex.functions.BiConsumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map<K, V> map, T t) throws Exception {
            map.put(this.b.apply(t), this.a.apply(t));
        }
    }

    public static <T> Function<T, Timed<T>> timestampWith(TimeUnit timeUnit, Scheduler scheduler) {
        return new g0(timeUnit, scheduler);
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> toMapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new i0(function2, function);
    }

    static final class j0<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {
        private final Function<? super K, ? extends Collection<? super V>> a;
        private final Function<? super T, ? extends V> b;
        private final Function<? super T, ? extends K> c;

        static {
            Covode.recordClassIndex(656345);
        }

        @Override // io.reactivex.functions.BiConsumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map<K, Collection<V>> map, T t) throws Exception {
            K apply = this.c.apply(t);
            Collection<? super V> collection = (Collection) map.get(apply);
            if (collection == null) {
                collection = this.a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.b.apply(t));
        }

        j0(Function<? super K, ? extends Collection<? super V>> function, Function<? super T, ? extends V> function2, Function<? super T, ? extends K> function3) {
            this.a = function;
            this.b = function2;
            this.c = function3;
        }
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> toMultimapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new j0(function3, function2, function);
    }
}
