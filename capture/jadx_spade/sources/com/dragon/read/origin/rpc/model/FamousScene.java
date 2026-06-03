package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FamousScene implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("comment_count")
    public int commentCount;

    @SerializedName("digged_count")
    public int diggedCount;

    @SerializedName("famous_scene_id")
    public String famousSceneID;

    @SerializedName("item_version")
    public String itemVersion;

    @SerializedName("para_content")
    public String paraContent;

    @SerializedName("position_info_v2")
    public PositionInfoV2 positionInfoV2;

    @SerializedName("user_digg")
    public boolean userDigg;

    static {
        Covode.recordClassIndex(612925);
        fieldTypeClassRef = FieldType.class;
    }
}
