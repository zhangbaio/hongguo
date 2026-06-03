package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.absettins.HistoryInitTabOptimize;
import com.dragon.read.component.biz.impl.brickservice.BsInitHistoryTabService;
import com.dragon.read.pages.record.model.RecordTabType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HGInitHistoryTabServiceImpl implements BsInitHistoryTabService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588062);
    }

    public RecordTabType getDefaultTabType() {
        return RecordTabType.VIDEO;
    }

    public boolean enableLandingConsumedHistoryTab() {
        if (HistoryInitTabOptimize.a.a().enable == 1) {
            return true;
        }
        return false;
    }
}
