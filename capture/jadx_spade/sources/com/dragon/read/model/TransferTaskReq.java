package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TransferTaskReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("request_id")
    @RpcField(FieldType.QUERY)
    public String requestId;

    @RpcField(FieldType.QUERY)
    public String scene;

    @RpcField(FieldType.QUERY)
    public String token;

    @SerializedName("transfer_from")
    @RpcField(FieldType.QUERY)
    public String transferFrom;

    static {
        Covode.recordClassIndex(612282);
        fieldTypeClassRef = FieldType.class;
    }
}
