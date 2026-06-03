package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReportRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("report_derivation")
    public String reportDerivation;

    @SerializedName("report_type")
    public String reportType;

    static {
        Covode.recordClassIndex(612224);
        fieldTypeClassRef = FieldType.class;
    }
}
