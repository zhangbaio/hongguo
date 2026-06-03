package kotlin.properties;

import kotlin.reflect.KProperty;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ReadWriteProperty<T, V> extends ReadOnlyProperty<T, V> {
    @Override // kotlin.properties.ReadOnlyProperty
    V getValue(T t, KProperty<?> kProperty);

    void setValue(T t, KProperty<?> kProperty, V v);
}
