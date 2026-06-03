package io.reactivex.subjects;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.Observer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class Subject<T> extends Observable<T> implements Observer<T> {
    static {
        Covode.recordClassIndex(657827);
    }

    public abstract Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasObservers();

    public abstract boolean hasThrowable();

    public final Subject<T> toSerialized() {
        if (this instanceof a) {
            return this;
        }
        return new a(this);
    }
}
