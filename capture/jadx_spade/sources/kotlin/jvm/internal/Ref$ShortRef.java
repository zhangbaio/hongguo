package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Ref$ShortRef implements Serializable {
    public short element;

    static {
        Covode.recordClassIndex(658559);
    }

    public String toString() {
        return String.valueOf((int) this.element);
    }
}
