package com.dragon.read.component.shortvideo.data.saas.rpcmodel;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasVideoHighlight {
    public long a;

    @SerializedName("end_time_in_millisecond")
    public int endTimeInMillisecond;

    @SerializedName("highlight_type")
    public SaasVideoHighlightType highlightType;

    @SerializedName("hight_segment_id")
    public long hightSegmentId;

    @SerializedName("progress_bar_type")
    public SaasProgressBarType progressBarType;

    @SerializedName("start_time_in_millisecond")
    public int startTimeInMillisecond;

    static {
        Covode.recordClassIndex(599108);
    }
}
