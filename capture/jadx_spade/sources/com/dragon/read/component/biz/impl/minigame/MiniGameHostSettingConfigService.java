package com.dragon.read.component.biz.impl.minigame;

import com.bytedance.covode.number.Covode;
import com.dragon.read.plugin.common.api.minigame.IMiniGameHostSettingConfigService;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MiniGameHostSettingConfigService implements IMiniGameHostSettingConfigService {
    public static final int $stable = 0;
    public static final MiniGameHostSettingConfigService INSTANCE;

    static {
        Covode.recordClassIndex(594687);
        INSTANCE = new MiniGameHostSettingConfigService();
    }

    private MiniGameHostSettingConfigService() {
    }

    public boolean isJumpOverCookieInit() {
        return true;
    }
}
