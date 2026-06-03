package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.d;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesRecommendInfo extends AbsSeriesListInfo {
    private String sessionId;

    static {
        Covode.recordClassIndex(598795);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public SeriesRecommendInfo(List<? extends d> list, Long l, String sessionId, boolean z, int i) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.detailModels = list;
        this.nextOffset = l;
        this.sessionId = sessionId;
        this.videoPos = i;
        this.isHasMore = z;
    }
}
