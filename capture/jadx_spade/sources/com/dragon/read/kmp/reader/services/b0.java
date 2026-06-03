package com.dragon.read.kmp.reader.services;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsReaderServiceApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b0 implements k {
    public static final b0 a;

    static {
        Covode.recordClassIndex(608558);
        a = new b0();
    }

    private b0() {
    }

    @Override // com.dragon.read.kmp.reader.services.k
    public Object g7(String str, String str2, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(NsReaderServiceApi.IMPL.readerChapterService().p(str, str2));
    }
}
