package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GenerateAIConsultRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("dialog_id")
    @RpcField(FieldType.BODY)
    public String dialogID;

    @SerializedName("generate_id")
    @RpcField(FieldType.BODY)
    public String generateID;

    @SerializedName("hit_other_tools")
    @RpcField(FieldType.BODY)
    public boolean hitOtherTools;

    static {
        Covode.recordClassIndex(612943);
        fieldTypeClassRef = FieldType.class;
    }
}
