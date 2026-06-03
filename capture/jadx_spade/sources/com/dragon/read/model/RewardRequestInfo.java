package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class RewardRequestInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("amount_type")
    public String amountType;

    @SerializedName("request_id")
    public String requestId;

    @SerializedName("task_id")
    public int taskId;

    @SerializedName("task_key")
    public String taskKey;

    static {
        Covode.recordClassIndex(612236);
        fieldTypeClassRef = FieldType.class;
    }
}
