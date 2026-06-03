package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.pages.bookshelf.model.BookType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l0 implements eo0.a {
    public static final l0 a;

    static {
        Covode.recordClassIndex(608876);
        a = new l0();
    }

    private l0() {
    }

    public boolean z0(String str) {
        return NsCommonDepend.IMPL.ugcBookListManager().b(str);
    }

    public boolean F0(String userId, String id, int i) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(id, "id");
        Object blockingFirst = NsCommonDepend.IMPL.bookshelfManager().isInBookshelf(userId, id, BookType.findByValue(i)).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "blockingFirst(...)");
        return ((Boolean) blockingFirst).booleanValue();
    }
}
