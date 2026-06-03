package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PreAuditInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("latest_pre_audit_result")
    @RpcField(FieldType.BODY)
    public PreAuditResult latestPreAuditResult;

    @SerializedName("pre_audit_current_status")
    @RpcField(FieldType.BODY)
    public long preAuditCurrentStatus;

    @SerializedName("pre_audit_left_count")
    @RpcField(FieldType.BODY)
    public long preAuditLeftCount;

    @SerializedName("pre_audit_switch_close")
    @RpcField(FieldType.BODY)
    public short preAuditSwitchClose;

    @SerializedName("pre_quality_audit_current_status")
    @RpcField(FieldType.BODY)
    public long preQualityAuditCurrentStatus;

    @SerializedName("pre_quality_audit_left_count")
    @RpcField(FieldType.BODY)
    public long preQualityAuditLeftCount;

    static {
        Covode.recordClassIndex(613319);
        fieldTypeClassRef = FieldType.class;
    }
}
