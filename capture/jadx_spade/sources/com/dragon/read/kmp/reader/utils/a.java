package com.dragon.read.kmp.reader.utils;

import com.bytedance.covode.number.Covode;
import com.dragon.read.reader.download.ChapterInfo;
import com.dragon.read.reader.utils.ChapterOriginalContentHelper;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(608648);
        a = new a();
    }

    private a() {
    }

    public final Object a(ChapterInfo chapterInfo, Continuation<? super Unit> continuation) {
        ChapterOriginalContentHelper.c.f(chapterInfo);
        return Unit.INSTANCE;
    }
}
