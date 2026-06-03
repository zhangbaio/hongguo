package kotlin.reflect;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KMutableProperty;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface KMutableProperty0<V> extends KProperty0<V>, KMutableProperty<V> {

    public interface Setter<V> extends KMutableProperty.Setter<V>, Function1<V, Unit> {
    }

    @Override // kotlin.reflect.KMutableProperty
    Setter<V> getSetter();

    void set(V v);
}
