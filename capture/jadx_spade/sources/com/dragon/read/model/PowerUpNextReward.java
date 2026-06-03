package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PowerUpNextReward implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public long amount;

    @SerializedName("condition_info")
    public PowerUpCondition conditionInfo;

    @SerializedName("max_amount")
    public long maxAmount;

    static {
        Covode.recordClassIndex(612199);
        fieldTypeClassRef = FieldType.class;
    }
}
