package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class DetectAuthorInputRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("detect_content")
    @RpcField(FieldType.BODY)
    public String detectContent;

    @SerializedName("detect_type")
    @RpcField(FieldType.BODY)
    public AuditDetectType detectType;

    static {
        Covode.recordClassIndex(612887);
        fieldTypeClassRef = FieldType.class;
    }
}
