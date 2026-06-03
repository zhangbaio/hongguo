package com.ss.ttvideoengine.metrics;

import android.os.Bundle;
import com.ss.ttvideoengine.log.VideoEventOnePlay;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IMediaMetrics {
    int getType();

    void logMetric(VideoEventOnePlay videoEventOnePlay);

    void logMetric(String str, float f);

    void logMetric(String str, int i);

    void logMetric(String str, String str2);

    void logMetric(String str, boolean z);

    boolean popMetricBoolean(String str);

    float popMetricFloat(String str);

    int popMetricInt(String str);

    long popMetricLong(String str);

    Bundle popMetrics();

    String printf();
}
