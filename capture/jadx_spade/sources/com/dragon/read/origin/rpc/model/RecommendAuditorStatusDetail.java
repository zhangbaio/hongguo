package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class RecommendAuditorStatusDetail implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("copy_safe_result")
    public short copySafeResult;

    @SerializedName("quality_audit_result")
    public short qualityAuditResult;

    static {
        Covode.recordClassIndex(613360);
        fieldTypeClassRef = FieldType.class;
    }
}
