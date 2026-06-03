package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InsetSuperResolutionRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public int height;

    @SerializedName("pic_uri")
    @RpcField(FieldType.BODY)
    public String picURI;

    @SerializedName("pic_url")
    @RpcField(FieldType.BODY)
    public String picURL;

    @RpcField(FieldType.BODY)
    public int width;

    static {
        Covode.recordClassIndex(613199);
        fieldTypeClassRef = FieldType.class;
    }
}
