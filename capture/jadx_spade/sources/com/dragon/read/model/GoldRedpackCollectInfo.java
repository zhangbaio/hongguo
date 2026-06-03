package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GoldRedpackCollectInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("has_gold_redpack_short_video_limit")
    public boolean hasGoldRedpackShortVideoLimit;

    @SerializedName("hit_gold_redpack")
    public boolean hitGoldRedpack;

    @SerializedName("popup_schema")
    public String popupSchema;

    @SerializedName("video_list")
    public List<String> videoList;

    static {
        Covode.recordClassIndex(612121);
        fieldTypeClassRef = FieldType.class;
    }
}
