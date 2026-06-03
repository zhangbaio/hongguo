package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AIGCVideoData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String description;
    public Map<String, String> extra;
    public String title;

    @SerializedName("video_detail")
    public UgcVideoDetail videoDetail;

    @SerializedName("video_type")
    public AIGCVideoType videoType;

    static {
        Covode.recordClassIndex(612681);
        fieldTypeClassRef = FieldType.class;
    }
}
