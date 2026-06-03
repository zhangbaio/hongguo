package com.dragon.read.kmp.saas.reader.depend;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import m25.i0;
import readersaas.com.dragon.read.saas.rpc.model.PubPayType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements dm4.c {
    public static final b a;

    static {
        Covode.recordClassIndex(608722);
        a = new b();
    }

    private b() {
    }

    @Override // dm4.c
    public boolean a(String bookId, boolean z, Integer num, String str, boolean z2, boolean z3) {
        PubPayType pubPayType;
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        i0 i0Var = i0.b;
        if (num != null) {
            pubPayType = PubPayType.findByValue(num.intValue());
        } else {
            pubPayType = null;
        }
        return i0Var.e(bookId, z, pubPayType, str, z2, z3);
    }
}
