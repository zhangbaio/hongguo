package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ModifyVideoRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("video_cover_url")
    @RpcField(FieldType.BODY)
    public String videoCoverURL;

    @SerializedName("video_id")
    @RpcField(FieldType.BODY)
    public String videoID;

    @SerializedName("video_name")
    @RpcField(FieldType.BODY)
    public String videoName;

    static {
        Covode.recordClassIndex(613241);
        fieldTypeClassRef = FieldType.class;
    }
}
