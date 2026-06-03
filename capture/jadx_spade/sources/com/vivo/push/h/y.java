package com.vivo.push.h;

import com.bytedance.covode.number.Covode;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class y extends ab {
    static {
        Covode.recordClassIndex(655079);
    }

    y(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        int e = ((com.vivo.push.b.r) vVar).e();
        PushMessageCallback pushMessageCallback = ((ab) this).b;
        if (pushMessageCallback != null) {
            pushMessageCallback.onNotifyGuideDialogResult(e);
        }
    }
}
