package com.xiaomi.push.service;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.service.XMPushService;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class al implements XMPushService.n {
    private static a a;

    public interface a {
        void a();
    }

    static {
        Covode.recordClassIndex(655674);
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a */
    public void mo453a() {
        a aVar = a;
        if (aVar != null) {
            aVar.a();
        }
    }
}
