package com.dragon.read.kmp.reader.services;

import com.bytedance.covode.number.Covode;
import com.dragon.reader.lib.datalevel.model.ChapterItem;
import java.util.List;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a0 implements j {
    public static final a0 a;

    static {
        Covode.recordClassIndex(608557);
        a = new a0();
    }

    private a0() {
    }

    @Override // com.dragon.read.kmp.reader.services.j
    public Object a(String str, Continuation<? super an4.c> continuation) {
        return com.dragon.read.kmp.reader.download.b.a.a(str, continuation);
    }

    @Override // com.dragon.read.kmp.reader.services.j
    public Object b(String str, Continuation<? super List<ChapterItem>> continuation) {
        return com.dragon.read.kmp.reader.download.b.a.b(str, continuation);
    }
}
