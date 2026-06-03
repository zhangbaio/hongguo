package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.brickservice.BsSeriesService;
import com.dragon.read.component.shortvideo.api.NsShortVideoApi;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HGSeriesSeriesServiceImpl implements BsSeriesService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588066);
    }

    public boolean enableIncreaseStoryTab() {
        return false;
    }

    public boolean showVideoTabInFanQie() {
        return false;
    }

    public boolean showVideoTabInHongGuo() {
        return true;
    }

    public boolean changeListenTabPosition() {
        return NsShortVideoApi.IMPL.changeHistoryListenTabPos();
    }

    public boolean enableGameOnHistoryTab() {
        return EggplantMyTabGame.a.a().enable;
    }
}
