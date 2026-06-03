package kotlin.collections.builders;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E> {
    static {
        Covode.recordClassIndex(658231);
    }

    public abstract boolean d(Map.Entry<? extends K, ? extends V> entry);

    public abstract /* bridge */ boolean j(Map.Entry<?, ?> entry);

    public final boolean a(E element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return d(element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return a((Map.Entry) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return j((Map.Entry) obj);
    }
}
