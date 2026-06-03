package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PreAuditArticleRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public String content;

    @SerializedName("item_id")
    @RpcField(FieldType.BODY)
    public long itemID;

    @SerializedName("pre_audit_type")
    @RpcField(FieldType.BODY)
    public PreAuditType preAuditType;

    static {
        Covode.recordClassIndex(613316);
        fieldTypeClassRef = FieldType.class;
    }
}
