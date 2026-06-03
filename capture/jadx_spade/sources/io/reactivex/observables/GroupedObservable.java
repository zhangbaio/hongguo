package io.reactivex.observables;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class GroupedObservable<K, T> extends Observable<T> {
    final K key;

    static {
        Covode.recordClassIndex(657749);
    }

    public K getKey() {
        return this.key;
    }

    protected GroupedObservable(K k) {
        this.key = k;
    }
}
