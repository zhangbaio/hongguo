package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.brickservice.BsPushGoogleConfigService;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HongguoGooglePushConfig extends HongguoPushConfig implements BsPushGoogleConfigService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588081);
    }

    @Override // com.dragon.read.component.biz.impl.HongguoPushConfig
    public boolean isPushEnable() {
        return BsPushGoogleConfigService.a.a(this);
    }

    @Override // com.dragon.read.component.biz.impl.HongguoPushConfig
    public boolean isSupportGoogleAlert() {
        return BsPushGoogleConfigService.a.b(this);
    }
}
