package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortVideoAutoCollectReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ex_device_collect_times")
    public int exDeviceCollectTimes;

    @SerializedName("from_push")
    public int fromPush;

    @SerializedName("is_new_video")
    public boolean isNewVideo;

    @SerializedName("is_new_video_collect")
    public boolean isNewVideoCollect;

    @SerializedName("is_super_double")
    public boolean isSuperDouble;

    @SerializedName("series_id")
    public String seriesId;

    static {
        Covode.recordClassIndex(612247);
        fieldTypeClassRef = FieldType.class;
    }
}
