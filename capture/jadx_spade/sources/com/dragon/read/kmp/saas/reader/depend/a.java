package com.dragon.read.kmp.saas.reader.depend;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import m25.h0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements dm4.b {
    public static final a a;

    static {
        Covode.recordClassIndex(608721);
        a = new a();
    }

    private a() {
    }

    @Override // dm4.b
    public Object a(String str, String str2, Continuation<? super Unit> continuation) {
        h0.b.a(str, str2).blockingAwait();
        return Unit.INSTANCE;
    }

    @Override // dm4.b
    public Object b(String str, String str2, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(h0.b.g(str, str2));
    }
}
