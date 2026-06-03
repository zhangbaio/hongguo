package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FeRule implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("fe_decision")
    public String feDecision;

    @SerializedName("task_status")
    public String taskStatus;

    static {
        Covode.recordClassIndex(612097);
        fieldTypeClassRef = FieldType.class;
    }
}
