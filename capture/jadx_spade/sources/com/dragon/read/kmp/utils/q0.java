package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import io.reactivex.disposables.Disposable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q0 {
    static {
        Covode.recordClassIndex(609563);
    }

    public static final void a(Disposable disposable) {
        boolean z = false;
        if (disposable != null && !disposable.isDisposed()) {
            z = true;
        }
        if (z) {
            disposable.dispose();
        }
    }
}
