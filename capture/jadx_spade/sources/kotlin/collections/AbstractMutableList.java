package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.markers.KMutableList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class AbstractMutableList<E> extends java.util.AbstractList<E> implements List<E>, KMutableList {
    static {
        Covode.recordClassIndex(658162);
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i, E e);

    public abstract int getSize();

    public abstract E removeAt(int i);

    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int i, E e);

    protected AbstractMutableList() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i) {
        return removeAt(i);
    }
}
