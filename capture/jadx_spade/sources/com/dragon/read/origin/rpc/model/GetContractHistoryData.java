package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetContractHistoryData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("authorize_type")
    public short authorizeType;

    @SerializedName("contract_audit_status")
    public short contractAuditStatus;

    @SerializedName("contract_audit_time")
    public String contractAuditTime;

    @SerializedName("contract_order")
    public short contractOrder;

    @SerializedName("copy_safe_audit_status")
    public short copySafeAuditStatus;

    @SerializedName("editor_audit_status")
    public short editorAuditStatus;

    @SerializedName("editor_audit_time")
    public String editorAuditTime;

    @SerializedName("editor_info")
    public String editorInfo;

    @SerializedName("editor_qq")
    public String editorQQ;

    @SerializedName("guardian_audit_status")
    public short guardianAuditStatus;

    @SerializedName("is_final")
    public short isFinal;

    @SerializedName("is_under_age_sign")
    public short isUnderAgeSign;

    @SerializedName("last_fail_reason")
    public String lastFailReason;

    @SerializedName("last_fail_time")
    public String lastFailTime;

    @SerializedName("quality_audit_status")
    public short qualityAuditStatus;

    @SerializedName("security_auditor_status")
    public short securityAuditorStatus;

    @SerializedName("security_auditor_time")
    public String securityAuditorTime;

    @SerializedName("sign_apply_status")
    public short signApplyStatus;

    @SerializedName("sign_apply_time")
    public String signApplyTime;

    @SerializedName("sign_task_group")
    public String signTaskGroup;

    @SerializedName("supplementary_contract_sign_status")
    public short supplementaryContractSignStatus;

    @SerializedName("supplementary_contract_sign_time")
    public String supplementaryContractSignTime;

    static {
        Covode.recordClassIndex(613093);
        fieldTypeClassRef = FieldType.class;
    }
}
