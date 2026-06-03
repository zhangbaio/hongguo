package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VideoCommon implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public String cover;

    @SerializedName("create_timestamp")
    @RpcField(FieldType.BODY)
    public long createTimestamp;

    @RpcField(FieldType.BODY)
    public String duration;

    @RpcField(FieldType.BODY)
    public String title;

    @SerializedName("user_info")
    @RpcField(FieldType.BODY)
    public UgcUserInfo userInfo;

    @SerializedName("video_type")
    @RpcField(FieldType.BODY)
    public VideoType videoType;

    static {
        Covode.recordClassIndex(613567);
        fieldTypeClassRef = FieldType.class;
    }
}
