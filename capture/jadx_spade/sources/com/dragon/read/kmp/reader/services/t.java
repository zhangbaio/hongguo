package com.dragon.read.kmp.reader.services;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.AppUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t implements e {
    public static final t a;

    static {
        Covode.recordClassIndex(608552);
        a = new t();
    }

    private t() {
    }

    @Override // com.dragon.read.kmp.reader.services.e
    public String C9() {
        String absolutePath = AppUtils.context().getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }
}
