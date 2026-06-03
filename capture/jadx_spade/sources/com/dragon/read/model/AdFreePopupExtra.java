package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AdFreePopupExtra implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("exchange_text")
    public String exchangeText;

    @SerializedName("fund_cost_amount")
    public int fundCostAmount;

    static {
        Covode.recordClassIndex(611997);
        fieldTypeClassRef = FieldType.class;
    }
}
