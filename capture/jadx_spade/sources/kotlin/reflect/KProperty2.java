package kotlin.reflect;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface KProperty2<D, E, V> extends KProperty<V>, Function2<D, E, V> {

    public interface Getter<D, E, V> extends KProperty.Getter<V>, Function2<D, E, V> {
    }

    V get(D d, E e);

    Object getDelegate(D d, E e);

    @Override // kotlin.reflect.KProperty
    Getter<D, E, V> getGetter();
}
