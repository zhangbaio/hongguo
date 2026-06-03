package com.ss.ttvideoengine.utils;

import com.bytedance.covode.number.Covode;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ValueWeakReference<T> extends WeakReference<T> {
    static {
        Covode.recordClassIndex(652768);
    }

    public ValueWeakReference(T t) {
        super(t);
    }

    public boolean equals(Object obj) {
        T t;
        if (!(obj instanceof ValueWeakReference) || (t = get()) == null) {
            return false;
        }
        return t.equals(((ValueWeakReference) obj).get());
    }

    public ValueWeakReference(T t, ReferenceQueue<? super T> referenceQueue) {
        super(t, referenceQueue);
    }
}
