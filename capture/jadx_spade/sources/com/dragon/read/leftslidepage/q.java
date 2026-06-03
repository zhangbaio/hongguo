package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q {
    public static final int c;
    public final m a;
    public final List<p> b;

    static {
        Covode.recordClassIndex(611264);
        c = 8;
    }

    public q(m titleParams, List<p> functionItemList) {
        Intrinsics.checkNotNullParameter(titleParams, "titleParams");
        Intrinsics.checkNotNullParameter(functionItemList, "functionItemList");
        this.a = titleParams;
        this.b = functionItemList;
    }
}
