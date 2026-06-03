package com.xiaomi.mipush.sdk;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum d {
    ASSEMBLE_PUSH_HUAWEI(1),
    ASSEMBLE_PUSH_FCM(2),
    ASSEMBLE_PUSH_COS(3),
    ASSEMBLE_PUSH_FTOS(4);


    /* renamed from: a, reason: collision with other field name */
    private int f50a;

    static {
        Covode.recordClassIndex(655301);
    }

    d(int i) {
        this.f50a = i;
    }
}
