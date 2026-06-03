package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAIQualificationRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ai_consult_left_count")
    public int aIConsultLeftCount;

    @SerializedName("ai_consult_left_count_unlimited")
    public boolean aIConsultLeftCountUnlimited;

    @SerializedName("ai_consult_qualification")
    public short aIConsultQualification;

    @SerializedName("ai_continuation_qualification")
    public short aIContinuationQualification;

    @SerializedName("ai_cover_qualification")
    @RpcField(FieldType.BODY)
    public short aICoverQualification;

    @SerializedName("ai_describe_qualification")
    public short aIDescribeQualification;

    @SerializedName("ai_diagnose_entrance_switch")
    @RpcField(FieldType.BODY)
    public boolean aIDiagnoseEntranceSwitch;

    @SerializedName("ai_diagnose_left_count")
    @RpcField(FieldType.BODY)
    public int aIDiagnoseLeftCount;

    @SerializedName("ai_diagnose_qualification")
    @RpcField(FieldType.BODY)
    public short aIDiagnoseQualification;

    @SerializedName("ai_expand_qualification")
    public short aIExpandQualification;

    @SerializedName("ai_hint_qualification")
    public short aIHintQualification;

    @SerializedName("ai_naming_qualification")
    public short aINamingQualification;

    @SerializedName("confirmed_ai_agreement")
    public short confirmedAIAgreement;

    @SerializedName("has_extra_ai_consult_left_count")
    @RpcField(FieldType.BODY)
    public boolean hasExtraAIConsultLeftCount;

    static {
        Covode.recordClassIndex(613020);
        fieldTypeClassRef = FieldType.class;
    }
}
