package com.dragon.read.kmprpc.reader.saas.rpc;

import com.bytedance.multi.rpc.annotation.HttpMethod;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[HttpMethod.values().length];
        iArr[HttpMethod.GET.ordinal()] = 1;
        iArr[HttpMethod.POST.ordinal()] = 2;
        iArr[HttpMethod.FORM.ordinal()] = 3;
        iArr[HttpMethod.UNKNOWN.ordinal()] = 4;
        a = iArr;
    }
}
