package com.dragon.read.kmprpc.reader.saas.rpc;

import com.bytedance.multi.rpc.annotation.ContentType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final /* synthetic */ class n {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[ContentType.values().length];
        iArr[ContentType.JSON.ordinal()] = 1;
        iArr[ContentType.PB.ordinal()] = 2;
        a = iArr;
    }
}
