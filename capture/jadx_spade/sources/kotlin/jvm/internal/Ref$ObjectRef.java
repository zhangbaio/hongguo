package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Ref$ObjectRef<T> implements Serializable {
    public T element;

    static {
        Covode.recordClassIndex(658558);
    }

    public String toString() {
        return String.valueOf(this.element);
    }
}
