package com.ss.ttvideoengine.metrics;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.log.VideoEventOnePlay;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class MetricsFactory {
    static {
        Covode.recordClassIndex(652524);
    }

    private MetricsFactory() {
    }

    public static IMediaMetrics createMetrics(int i, VideoEventOnePlay videoEventOnePlay) {
        FirstFrameMetrics firstFrameMetrics;
        if (i != 0) {
            firstFrameMetrics = null;
        } else {
            firstFrameMetrics = new FirstFrameMetrics(i);
        }
        if (firstFrameMetrics != null) {
            firstFrameMetrics.logMetric(videoEventOnePlay);
        }
        return firstFrameMetrics;
    }
}
