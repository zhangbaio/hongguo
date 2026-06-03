package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class QuickAppParams implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("is_wechat")
    @RpcField(FieldType.QUERY)
    public boolean isWechat;

    @SerializedName("origin_app_id")
    @RpcField(FieldType.QUERY)
    public int originAppId;

    @SerializedName("origin_user_id")
    @RpcField(FieldType.QUERY)
    public long originUserId;

    @SerializedName("platform_app_id")
    @RpcField(FieldType.QUERY)
    public String platformAppId;

    @SerializedName("risk_token")
    @RpcField(FieldType.QUERY)
    public String riskToken;

    static {
        Covode.recordClassIndex(612202);
        fieldTypeClassRef = FieldType.class;
    }
}
