package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ResourceField implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public String field;

    @SerializedName("field_name")
    @RpcField(FieldType.BODY)
    public String fieldName;

    @SerializedName("field_type")
    @RpcField(FieldType.BODY)
    public String fieldType;

    @SerializedName("field_values")
    @RpcField(FieldType.BODY)
    public List<ResourceFieldValue> fieldValues;

    @RpcField(FieldType.BODY)
    public List<String> operators;

    static {
        Covode.recordClassIndex(613369);
        fieldTypeClassRef = FieldType.class;
    }
}
