package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.report.PageRecorder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n0 {
    static {
        Covode.recordClassIndex(609560);
    }

    public static final Args a(ym4.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Args putAll = new Args().putAll(aVar.a);
        Intrinsics.checkNotNullExpressionValue(putAll, "putAll(...)");
        return putAll;
    }

    public static final Args b(ym4.k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Args putAll = new Args().putAll(kVar.i());
        Intrinsics.checkNotNullExpressionValue(putAll, "putAll(...)");
        return putAll;
    }

    public static final PageRecorder c(ym4.k kVar) {
        PageRecorder pageRecorder;
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        String str = kVar.a;
        String str2 = kVar.b;
        String str3 = kVar.c;
        ym4.k kVar2 = kVar.d;
        if (kVar2 != null) {
            pageRecorder = c(kVar2);
        } else {
            pageRecorder = null;
        }
        PageRecorder pageRecorder2 = new PageRecorder(str, str2, str3, pageRecorder);
        pageRecorder2.addParam(b(kVar));
        return pageRecorder2;
    }
}
