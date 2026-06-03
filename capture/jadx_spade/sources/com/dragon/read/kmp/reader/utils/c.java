package com.dragon.read.kmp.reader.utils;

import com.bytedance.covode.number.Covode;
import com.dragon.read.reader.DecryptKey;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    static {
        Covode.recordClassIndex(608650);
    }

    public static final Object a(String str, Continuation<? super DecryptKey> continuation) {
        Object blockingGet = rs5.i.F(str).blockingGet();
        Intrinsics.checkNotNullExpressionValue(blockingGet, "blockingGet(...)");
        return blockingGet;
    }
}
