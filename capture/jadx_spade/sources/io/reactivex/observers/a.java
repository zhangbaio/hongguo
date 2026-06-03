package io.reactivex.observers;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a<T> implements Observer<T> {
    private Disposable a;

    static {
        Covode.recordClassIndex(657752);
    }

    protected void a() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (f.e(this.a, disposable, getClass())) {
            this.a = disposable;
            a();
        }
    }
}
