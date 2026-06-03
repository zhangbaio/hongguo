package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UploadPicV1RespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int height;

    @SerializedName("inner_public_url")
    @RpcField(FieldType.BODY)
    public String innerPublicURL;

    @SerializedName("pic_uri")
    public String picUri;

    @SerializedName("pic_url")
    public String picUrl;

    @RpcField(FieldType.BODY)
    public String type;
    public int width;

    static {
        Covode.recordClassIndex(613546);
        fieldTypeClassRef = FieldType.class;
    }
}
