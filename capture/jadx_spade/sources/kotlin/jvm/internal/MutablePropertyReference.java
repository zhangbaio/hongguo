package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import kotlin.reflect.KMutableProperty;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class MutablePropertyReference extends PropertyReference implements KMutableProperty {
    static {
        Covode.recordClassIndex(658534);
    }

    public MutablePropertyReference() {
    }

    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
