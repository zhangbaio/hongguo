package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MuyeCommonParam implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Referer")
    @RpcField(FieldType.HEADER)
    public String referer;

    @SerializedName("SerialUUID")
    public String serialUUID;

    @SerializedName("SerialWebID")
    public String serialWebID;

    @SerializedName("TTWebID")
    public String tTWebID;

    @SerializedName("web_ms_token")
    @RpcField(FieldType.HEADER)
    public String webMSToken;

    @SerializedName("web_sign_res")
    @RpcField(FieldType.HEADER)
    public String webSignRes;

    static {
        Covode.recordClassIndex(613247);
        fieldTypeClassRef = FieldType.class;
    }
}
