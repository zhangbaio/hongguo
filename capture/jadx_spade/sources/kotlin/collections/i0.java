package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class i0<K, V> implements h0<K, V> {
    private final Map<K, V> a;
    private final Function1<K, V> b;

    static {
        Covode.recordClassIndex(658216);
    }

    @Override // kotlin.collections.h0, kotlin.collections.d0
    public Map<K, V> b() {
        return this.a;
    }

    @Override // java.util.Map
    public void clear() {
        b().clear();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return c();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return e();
    }

    public Set<Map.Entry<K, V>> a() {
        return b().entrySet();
    }

    public Set<K> c() {
        return b().keySet();
    }

    public int d() {
        return b().size();
    }

    public Collection<V> e() {
        return b().values();
    }

    @Override // java.util.Map
    public int hashCode() {
        return b().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return b().isEmpty();
    }

    public String toString() {
        return b().toString();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return b().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return b().containsValue(obj);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return b().equals(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return b().get(obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        b().putAll(from);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return b().remove(obj);
    }

    @Override // kotlin.collections.d0
    public V l(K k) {
        Map<K, V> b = b();
        V v = b.get(k);
        if (v == null && !b.containsKey(k)) {
            return this.b.invoke(k);
        }
        return v;
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        return b().put(k, v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i0(Map<K, V> map, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(function1, "default");
        this.a = map;
        this.b = function1;
    }
}
