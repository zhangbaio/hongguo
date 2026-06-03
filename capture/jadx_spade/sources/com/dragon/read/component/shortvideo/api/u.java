package com.dragon.read.component.shortvideo.api;

import android.content.Context;
import com.dragon.read.base.Args;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface u {
    void a(q qVar);

    void b(q qVar);

    Disposable c(Context context, String str, Args args);

    Observable<com.dragon.read.component.shortvideo.model.a> d(String str);
}
