package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAIQualificationResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;
    public GetAIQualificationRespData data;

    @SerializedName("log_id")
    public String logID;
    public String message;

    static {
        Covode.recordClassIndex(613021);
        fieldTypeClassRef = FieldType.class;
    }
}
