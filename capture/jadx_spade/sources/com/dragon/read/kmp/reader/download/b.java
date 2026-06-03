package com.dragon.read.kmp.reader.download;

import com.bytedance.covode.number.Covode;
import com.dragon.reader.lib.datalevel.model.ChapterItem;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import readersaas.com.dragon.read.saas.rpc.model.GetDirectoryForItemIdData;
import t25.b0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;

    static {
        Covode.recordClassIndex(608404);
        a = new b();
    }

    private b() {
    }

    public final Object a(String str, Continuation<? super an4.c> continuation) {
        GetDirectoryForItemIdData getDirectoryForItemIdData = (GetDirectoryForItemIdData) b0.j().h(str).blockingGet();
        Intrinsics.checkNotNull(getDirectoryForItemIdData);
        return new an4.c(getDirectoryForItemIdData);
    }

    public final Object b(String str, Continuation<? super List<ChapterItem>> continuation) {
        List list = (List) b0.j().i(str).blockingGet();
        Intrinsics.checkNotNull(list);
        return list;
    }
}
