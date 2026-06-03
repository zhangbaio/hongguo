package kotlin.properties;

import kotlin.reflect.KProperty;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ReadOnlyProperty<T, V> {
    V getValue(T t, KProperty<?> kProperty);
}
