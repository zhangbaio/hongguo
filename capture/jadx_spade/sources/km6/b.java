package km6;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class b<K, T> extends Flowable<T> {
    public final K a;

    static {
        Covode.recordClassIndex(656280);
    }

    protected b(K k) {
        this.a = k;
    }
}
