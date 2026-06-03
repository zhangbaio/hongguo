package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PreAuditArticleFeedbackRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public short feedback;

    @SerializedName("item_id")
    @RpcField(FieldType.BODY)
    public long itemID;

    @RpcField(FieldType.BODY)
    public long order;

    @SerializedName("risk_text")
    @RpcField(FieldType.BODY)
    public String riskText;

    static {
        Covode.recordClassIndex(613314);
        fieldTypeClassRef = FieldType.class;
    }
}
