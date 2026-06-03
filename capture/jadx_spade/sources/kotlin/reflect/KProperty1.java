package kotlin.reflect;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface KProperty1<T, V> extends KProperty<V>, Function1<T, V> {

    public interface Getter<T, V> extends KProperty.Getter<V>, Function1<T, V> {
    }

    V get(T t);

    Object getDelegate(T t);

    @Override // kotlin.reflect.KProperty
    Getter<T, V> getGetter();
}
