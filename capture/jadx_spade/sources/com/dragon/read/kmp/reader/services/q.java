package com.dragon.read.kmp.reader.services;

import com.bytedance.covode.number.Covode;
import com.dragon.read.reader.depend.data.CatalogCache;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import t25.d1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q implements b {
    public static final q a;

    static {
        Covode.recordClassIndex(608549);
        a = new q();
    }

    private q() {
    }

    @Override // com.dragon.read.kmp.reader.services.b
    public com.dragon.read.kmp.reader.download.m pa(an4.c itemIdData) {
        Intrinsics.checkNotNullParameter(itemIdData, "itemIdData");
        CatalogCache c = t25.c0.c(itemIdData.a, new int[0]);
        List V = d1.d0().V(c.getChapterItemList(), itemIdData.a.bookInfo);
        int size = c.getChapterItemList().size();
        Intrinsics.checkNotNull(V);
        return new com.dragon.read.kmp.reader.download.m(size, V);
    }
}
