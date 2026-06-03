package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class IncomeAreaInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("cash_to_gold")
    public long cashToGold;

    @SerializedName("gold_merge")
    public long goldMerge;

    @SerializedName("income_style")
    public String incomeStyle;

    static {
        Covode.recordClassIndex(612124);
        fieldTypeClassRef = FieldType.class;
    }
}
