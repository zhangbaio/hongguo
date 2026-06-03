package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GenerateTemplatePicRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public String arrParams;

    @RpcField(FieldType.BODY)
    public String params;

    @SerializedName("template_id")
    @RpcField(FieldType.BODY)
    public int templateID;

    static {
        Covode.recordClassIndex(612975);
        fieldTypeClassRef = FieldType.class;
    }
}
