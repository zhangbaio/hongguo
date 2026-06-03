package com.dragon.read.kmp.reader.download;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public static final int c;
    public final int a;
    public final List<String> b;

    static {
        Covode.recordClassIndex(608418);
        c = 8;
    }

    public m(int i, List<String> chapterIdList) {
        Intrinsics.checkNotNullParameter(chapterIdList, "chapterIdList");
        this.a = i;
        this.b = chapterIdList;
    }
}
