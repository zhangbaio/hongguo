package com.dragon.read.kmp.saas.reader.depend;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import m25.j0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements dm4.d {
    public static final c a;

    static {
        Covode.recordClassIndex(608724);
        a = new c();
    }

    private c() {
    }

    @Override // dm4.d
    public boolean a(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        return j0.b.a(bookId);
    }
}
