package kotlin;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class InitializedLazyImpl<T> implements Lazy<T>, Serializable {
    private final T value;

    static {
        Covode.recordClassIndex(658058);
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return true;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(getValue());
    }

    public InitializedLazyImpl(T t) {
        this.value = t;
    }
}
