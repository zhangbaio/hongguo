package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortArticleApplyModifyResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;

    @SerializedName("log_id")
    public String logID;
    public String message;

    @SerializedName("Bdturing-Verify")
    @RpcField(FieldType.HEADER)
    public String verifyDecision;

    static {
        Covode.recordClassIndex(613427);
        fieldTypeClassRef = FieldType.class;
    }
}
