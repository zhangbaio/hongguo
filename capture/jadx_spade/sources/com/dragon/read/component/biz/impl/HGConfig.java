package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.brickservice.BsVipConfigService;
import com.dragon.read.hybrid.WebUrlManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HGConfig implements BsVipConfigService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588059);
    }

    public String getLockChapterPayWallUrl() {
        return BsVipConfigService.b.b(this);
    }

    public String getVipPageUrlKey() {
        return BsVipConfigService.b.c(this);
    }

    public String getVipHalfPageUrl() {
        String vipHalfPageUrlHg = WebUrlManager.getInstance().getVipHalfPageUrlHg();
        Intrinsics.checkNotNullExpressionValue(vipHalfPageUrlHg, "getVipHalfPageUrlHg(...)");
        return vipHalfPageUrlHg;
    }

    public String getVipPageUrl() {
        String vipPageUrlHg = WebUrlManager.getInstance().getVipPageUrlHg();
        Intrinsics.checkNotNullExpressionValue(vipPageUrlHg, "getVipPageUrlHg(...)");
        return vipPageUrlHg;
    }

    public void reportReaderOrAudioFinish(String str, String str2) {
        BsVipConfigService.b.d(this, str, str2);
    }

    public String getChapterUnlockWords(long j, long j2) {
        return BsVipConfigService.b.a(this, j, j2);
    }
}
