package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ResourceFieldValue implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("field_value")
    @RpcField(FieldType.BODY)
    public String fieldValue;

    @SerializedName("field_value_name")
    @RpcField(FieldType.BODY)
    public String fieldValueName;

    static {
        Covode.recordClassIndex(613370);
        fieldTypeClassRef = FieldType.class;
    }
}
