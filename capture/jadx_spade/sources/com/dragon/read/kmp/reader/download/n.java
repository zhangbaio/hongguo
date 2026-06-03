package com.dragon.read.kmp.reader.download;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface n {
    void a(int i, int i2, float f);

    Object b(int i, int i2, float f, Continuation<? super Unit> continuation);

    void onCancel();

    void onError(Throwable th);

    void onStart();
}
