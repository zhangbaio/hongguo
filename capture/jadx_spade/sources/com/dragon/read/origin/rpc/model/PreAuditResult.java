package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PreAuditResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("doc_version")
    public long docVersion;
    public long order;

    @SerializedName("risk_texts")
    public List<PreAuditRiskText> riskTexts;

    static {
        Covode.recordClassIndex(613320);
        fieldTypeClassRef = FieldType.class;
    }
}
