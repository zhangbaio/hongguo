package kotlinx.coroutines.debug.internal;

import com.bytedance.covode.number.Covode;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.internal.f0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b;
    private static final /* synthetic */ AtomicReferenceFieldUpdater c;
    private volatile /* synthetic */ int _size$volatile;
    private final ReferenceQueue<K> a;
    private volatile /* synthetic */ Object core$volatile;

    static {
        Covode.recordClassIndex(659108);
        b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size$volatile");
        c = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core$volatile");
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater g() {
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b<K, V> implements Map.Entry<K, V>, KMutableMap.a {
        private final K a;
        private final V b;

        static {
            Covode.recordClassIndex(659111);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            kotlinx.coroutines.debug.internal.a.e();
            throw new KotlinNothingValueException();
        }

        public b(K k, V v) {
            this.a = k;
            this.b = v;
        }
    }

    private final class c<E> extends AbstractMutableSet<E> {
        private final Function2<K, V, E> a;

        static {
            Covode.recordClassIndex(659112);
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return ((a) ConcurrentWeakMap.g().get(ConcurrentWeakMap.this)).j(this.a);
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            kotlinx.coroutines.debug.internal.a.e();
            throw new KotlinNothingValueException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super K, ? super V, ? extends E> function2) {
            this.a = function2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        b.decrementAndGet(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> getEntries() {
        return new c(new Function2<K, V, Map.Entry<K, V>>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((ConcurrentWeakMap$entries$1<K, V>) obj, obj2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Map.Entry<K, V> invoke(K k, V v) {
                return new ConcurrentWeakMap.b(k, v);
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> getKeys() {
        return new c(new Function2<K, V, K>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1
            @Override // kotlin.jvm.functions.Function2
            public final K invoke(K k, V v) {
                return k;
            }
        });
    }

    private final class a {
        private static final /* synthetic */ AtomicIntegerFieldUpdater g;
        private final int a;
        private final int b;
        private final int c;
        private final /* synthetic */ AtomicReferenceArray d;
        private final /* synthetic */ AtomicReferenceArray e;
        private volatile /* synthetic */ int load$volatile;

        static {
            Covode.recordClassIndex(659109);
            g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load$volatile");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final /* synthetic */ AtomicReferenceArray f() {
            return this.d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final /* synthetic */ AtomicReferenceArray h() {
            return this.e;
        }

        /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a, reason: collision with other inner class name */
        private final class C0209a<E> implements Iterator<E>, KMutableIterator {
            private final Function2<K, V, E> a;
            private int b = -1;
            private K c;
            private V d;

            static {
                Covode.recordClassIndex(659110);
            }

            @Override // java.util.Iterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Void remove() {
                kotlinx.coroutines.debug.internal.a.e();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.b < ((a) a.this).a) {
                    return true;
                }
                return false;
            }

            private final void c() {
                K k;
                while (true) {
                    int i = this.b + 1;
                    this.b = i;
                    if (i < ((a) a.this).a) {
                        d dVar = (d) a.this.f().get(this.b);
                        if (dVar != null && (k = (K) dVar.get()) != null) {
                            this.c = k;
                            Object obj = (V) a.this.h().get(this.b);
                            if (obj instanceof e) {
                                obj = (V) ((e) obj).a;
                            }
                            if (obj != null) {
                                this.d = (V) obj;
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.b < ((a) a.this).a) {
                    Function2<K, V, E> function2 = this.a;
                    K k = this.c;
                    if (k == false) {
                        Intrinsics.throwUninitializedPropertyAccessException("key");
                        k = (K) Unit.INSTANCE;
                    }
                    V v = this.d;
                    if (v == false) {
                        Intrinsics.throwUninitializedPropertyAccessException("value");
                        v = (V) Unit.INSTANCE;
                    }
                    E e = (E) function2.invoke(k, v);
                    c();
                    return e;
                }
                throw new NoSuchElementException();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C0209a(Function2<? super K, ? super V, ? extends E> function2) {
                this.a = function2;
                c();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ConcurrentWeakMap<K, V>.a m() {
            int coerceAtLeast;
            Object obj;
            Object obj2;
            f0 f0Var;
            e d;
            while (true) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(ConcurrentWeakMap.this.size(), 4);
                ConcurrentWeakMap<K, V>.a aVar = (ConcurrentWeakMap<K, V>.a) ConcurrentWeakMap.this.new a(Integer.highestOneBit(coerceAtLeast) * 4);
                int i = this.a;
                for (int i2 = 0; i2 < i; i2++) {
                    d dVar = (d) f().get(i2);
                    if (dVar != null) {
                        obj = dVar.get();
                    } else {
                        obj = null;
                    }
                    if (dVar != null && obj == null) {
                        n(i2);
                    }
                    while (true) {
                        obj2 = h().get(i2);
                        if (obj2 instanceof e) {
                            obj2 = ((e) obj2).a;
                            break;
                        }
                        AtomicReferenceArray h = h();
                        d = kotlinx.coroutines.debug.internal.a.d(obj2);
                        if (kotlinx.coroutines.channels.c.a(h, i2, obj2, d)) {
                            break;
                        }
                    }
                    if (obj != null && obj2 != null) {
                        Object k = aVar.k(obj, obj2, dVar);
                        f0Var = kotlinx.coroutines.debug.internal.a.a;
                        if (k != f0Var) {
                        }
                    }
                }
                return aVar;
            }
        }

        public final <E> Iterator<E> j(Function2<? super K, ? super V, ? extends E> function2) {
            return new C0209a(function2);
        }

        private final int i(int i) {
            return (i * (-1640531527)) >>> this.b;
        }

        public final void d(d<?> dVar) {
            int i = i(dVar.a);
            while (true) {
                d<?> dVar2 = (d) f().get(i);
                if (dVar2 == null) {
                    return;
                }
                if (dVar2 == dVar) {
                    n(i);
                    return;
                } else {
                    if (i == 0) {
                        i = this.a;
                    }
                    i--;
                }
            }
        }

        private final void n(int i) {
            Object obj;
            do {
                obj = h().get(i);
                if (obj == null || (obj instanceof e)) {
                    return;
                }
            } while (!kotlinx.coroutines.channels.c.a(h(), i, obj, null));
            ConcurrentWeakMap.this.f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final V e(K k) {
            int i = i(k.hashCode());
            while (true) {
                d dVar = (d) f().get(i);
                if (dVar == null) {
                    return null;
                }
                T t = dVar.get();
                if (Intrinsics.areEqual(k, t)) {
                    V v = (V) h().get(i);
                    if (v instanceof e) {
                        return (V) ((e) v).a;
                    }
                    return v;
                }
                if (t == 0) {
                    n(i);
                }
                if (i == 0) {
                    i = this.a;
                }
                i--;
            }
        }

        public a(int i) {
            this.a = i;
            this.b = Integer.numberOfLeadingZeros(i) + 1;
            this.c = (i * 2) / 3;
            this.d = new AtomicReferenceArray(i);
            this.e = new AtomicReferenceArray(i);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
        
            r6 = h().get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
        
            if ((r6 instanceof kotlinx.coroutines.debug.internal.e) == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
        
            if (kotlinx.coroutines.channels.c.a(h(), r0, r6, r7) == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        
            r6 = kotlinx.coroutines.debug.internal.a.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
        
            return r6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object k(K r6, V r7, kotlinx.coroutines.debug.internal.d<K> r8) {
            /*
                r5 = this;
                int r0 = r6.hashCode()
                int r0 = r5.i(r0)
                r1 = 0
            L9:
                java.util.concurrent.atomic.AtomicReferenceArray r2 = r5.f()
                java.lang.Object r2 = r2.get(r0)
                kotlinx.coroutines.debug.internal.d r2 = (kotlinx.coroutines.debug.internal.d) r2
                if (r2 != 0) goto L4d
                r2 = 0
                if (r7 != 0) goto L19
                return r2
            L19:
                if (r1 != 0) goto L35
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = g()
            L1f:
                int r1 = r3.get(r5)
                int r4 = r5.c
                if (r1 < r4) goto L2c
                kotlinx.coroutines.internal.f0 r6 = kotlinx.coroutines.debug.internal.a.a()
                return r6
            L2c:
                int r4 = r1 + 1
                boolean r1 = r3.compareAndSet(r5, r1, r4)
                if (r1 == 0) goto L1f
                r1 = 1
            L35:
                if (r8 != 0) goto L42
                kotlinx.coroutines.debug.internal.d r8 = new kotlinx.coroutines.debug.internal.d
                kotlinx.coroutines.debug.internal.ConcurrentWeakMap<K, V> r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this
                java.lang.ref.ReferenceQueue r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.d(r3)
                r8.<init>(r6, r3)
            L42:
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r5.f()
                boolean r2 = kotlinx.coroutines.channels.c.a(r3, r0, r2, r8)
                if (r2 != 0) goto L60
                goto L9
            L4d:
                java.lang.Object r2 = r2.get()
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r2)
                if (r3 == 0) goto L7c
                if (r1 == 0) goto L60
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = g()
                r6.decrementAndGet(r5)
            L60:
                java.util.concurrent.atomic.AtomicReferenceArray r6 = r5.h()
                java.lang.Object r6 = r6.get(r0)
                boolean r8 = r6 instanceof kotlinx.coroutines.debug.internal.e
                if (r8 == 0) goto L71
                kotlinx.coroutines.internal.f0 r6 = kotlinx.coroutines.debug.internal.a.a()
                return r6
            L71:
                java.util.concurrent.atomic.AtomicReferenceArray r8 = r5.h()
                boolean r8 = kotlinx.coroutines.channels.c.a(r8, r0, r6, r7)
                if (r8 == 0) goto L60
                return r6
            L7c:
                if (r2 != 0) goto L81
                r5.n(r0)
            L81:
                if (r0 != 0) goto L85
                int r0 = r5.a
            L85:
                int r0 = r0 + (-1)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.ConcurrentWeakMap.a.k(java.lang.Object, java.lang.Object, kotlinx.coroutines.debug.internal.d):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object l(a aVar, Object obj, Object obj2, d dVar, int i, Object obj3) {
            if ((i & 4) != 0) {
                dVar = null;
            }
            return aVar.k(obj, obj2, dVar);
        }
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return b.get(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it2 = keySet().iterator();
        while (it2.hasNext()) {
            remove(it2.next());
        }
    }

    public final void j() {
        boolean z;
        if (this.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                Reference<? extends K> remove = this.a.remove();
                Intrinsics.checkNotNull(remove, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                e((d) remove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    private final void e(d<?> dVar) {
        ((a) c.get(this)).d(dVar);
    }

    public ConcurrentWeakMap(boolean z) {
        ReferenceQueue<K> referenceQueue;
        this.core$volatile = new a(16);
        if (z) {
            referenceQueue = new ReferenceQueue<>();
        } else {
            referenceQueue = null;
        }
        this.a = referenceQueue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((a) c.get(this)).e(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f0 f0Var;
        if (obj == 0) {
            return null;
        }
        V v = (V) a.l((a) c.get(this), obj, null, null, 4, null);
        f0Var = kotlinx.coroutines.debug.internal.a.a;
        if (v == f0Var) {
            v = i(obj, null);
        }
        if (v != null) {
            b.decrementAndGet(this);
        }
        return v;
    }

    private final synchronized V i(K k, V v) {
        V v2;
        f0 f0Var;
        a aVar = (a) c.get(this);
        while (true) {
            v2 = (V) a.l(aVar, k, v, null, 4, null);
            f0Var = kotlinx.coroutines.debug.internal.a.a;
            if (v2 == f0Var) {
                aVar = aVar.m();
                c.set(this, aVar);
            }
        }
        return v2;
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        f0 f0Var;
        V v2 = (V) a.l((a) c.get(this), k, v, null, 4, null);
        f0Var = kotlinx.coroutines.debug.internal.a.a;
        if (v2 == f0Var) {
            v2 = i(k, v);
        }
        if (v2 == null) {
            b.incrementAndGet(this);
        }
        return v2;
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
