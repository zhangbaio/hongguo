package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BenefitsWidgetData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("cash_balance")
    public int cashBalance;

    @SerializedName("toady_earn")
    public int toadyEarn;
    public String trigger;

    static {
        Covode.recordClassIndex(612022);
        fieldTypeClassRef = FieldType.class;
    }
}
