package com.dragon.read.kmp.reader.download;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import t25.c0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;

    static {
        Covode.recordClassIndex(608405);
        a = new c();
    }

    private c() {
    }

    public final Object a(String str, an4.c cVar, Continuation<? super Unit> continuation) {
        new c0(str).s(cVar.a).blockingAwait();
        return Unit.INSTANCE;
    }
}
