package kotlin.reflect;

import kotlin.Unit;
import kotlin.reflect.KProperty;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface KMutableProperty<V> extends KProperty<V> {

    public interface Setter<V> extends KProperty.Accessor<V>, KFunction<Unit> {
    }

    Setter<V> getSetter();
}
