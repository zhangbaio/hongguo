package com.dragon.read.kmp.story.impl.feeds.data;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.q6;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final int e;
    public final List<e> a;
    public final q6 b;
    public final boolean c;
    public final String d;

    static {
        Covode.recordClassIndex(609271);
        e = 8;
    }

    public g(List<e> dataList, q6 q6Var, boolean z, String str) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.a = dataList;
        this.b = q6Var;
        this.c = z;
        this.d = str;
    }
}
