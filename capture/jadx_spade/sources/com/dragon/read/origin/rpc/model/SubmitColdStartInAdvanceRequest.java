package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SubmitColdStartInAdvanceRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    @RpcField(FieldType.BODY)
    public long bookID;

    @SerializedName("submit_type")
    @RpcField(FieldType.BODY)
    public SubmitColdStartInAdvanceType submitType;

    static {
        Covode.recordClassIndex(613464);
        fieldTypeClassRef = FieldType.class;
    }
}
