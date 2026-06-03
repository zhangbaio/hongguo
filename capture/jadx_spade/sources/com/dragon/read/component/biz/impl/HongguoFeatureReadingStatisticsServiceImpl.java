package com.dragon.read.component.biz.impl;

import ah4.a;
import android.content.Intent;
import bm3.f;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.brickservice.BsFeatureReadingStatisticsService;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HongguoFeatureReadingStatisticsServiceImpl implements BsFeatureReadingStatisticsService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588080);
    }

    public f getReadingStatisticEntryInfo() {
        BsFeatureReadingStatisticsService.b.d(this);
        return null;
    }

    public int getRecentSignedDate() {
        return BsFeatureReadingStatisticsService.b.e(this);
    }

    public long getTodayReadTime() {
        return BsFeatureReadingStatisticsService.b.f(this);
    }

    public void setRecentSignedDate(int i) {
        BsFeatureReadingStatisticsService.b.g(this, i);
    }

    public a getKmpContent(Intent intent) {
        BsFeatureReadingStatisticsService.b.c(this, intent);
        return null;
    }

    public void debugModifyTime(int i, long j) {
        BsFeatureReadingStatisticsService.b.b(this, i, j);
    }

    public void addReadTime(String str, String str2, long j) {
        BsFeatureReadingStatisticsService.b.a(this, str, str2, j);
    }
}
