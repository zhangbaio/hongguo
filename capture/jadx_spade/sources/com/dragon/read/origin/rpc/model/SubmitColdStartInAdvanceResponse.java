package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SubmitColdStartInAdvanceResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public int code;

    @SerializedName("log_id")
    @RpcField(FieldType.BODY)
    public String logID;

    @RpcField(FieldType.BODY)
    public String message;

    static {
        Covode.recordClassIndex(613465);
        fieldTypeClassRef = FieldType.class;
    }
}
