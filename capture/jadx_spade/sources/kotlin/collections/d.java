package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import kotlin.jvm.internal.markers.KMutableCollection;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class d<E> extends java.util.AbstractCollection<E> implements Collection<E>, KMutableCollection {
    static {
        Covode.recordClassIndex(658161);
    }

    public abstract int a();

    protected d() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
