package com.dragon.read.component.shortvideo.data.saas.video;

import java.util.List;
import seriessdk.com.dragon.read.saas.rpc.model.SeriesStatus;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {
    String getDetailId();

    int getEpisodeCnt();

    List<SaasVideoData> getEpisodeList();

    SeriesStatus getEpisodesStatus();

    String getSeriesCover();

    String getSeriesTitle();

    VideoContentType getVideoContentType();

    String recommendGroupId();

    String recommendInfo();
}
