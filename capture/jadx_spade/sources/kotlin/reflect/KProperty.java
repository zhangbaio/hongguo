package kotlin.reflect;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface KProperty<V> extends KCallable<V> {

    public interface Accessor<V> {
        KProperty<V> getProperty();
    }

    public interface Getter<V> extends Accessor<V>, KFunction<V> {
    }

    Getter<V> getGetter();

    boolean isConst();

    boolean isLateinit();
}
