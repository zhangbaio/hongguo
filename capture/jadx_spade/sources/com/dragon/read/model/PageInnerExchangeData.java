package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PageInnerExchangeData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("action_text")
    public String actionText;

    @SerializedName("allow_gold_amount")
    public int allowGoldAmount;

    @SerializedName("auto_exchange_open")
    public boolean autoExchangeOpen;

    @SerializedName("condition_info")
    public ExchangeConditionInfo conditionInfo;

    @SerializedName("frequency_info")
    public ExchangeFrequencyInfo frequencyInfo;
    public long timestamp;

    static {
        Covode.recordClassIndex(612176);
        fieldTypeClassRef = FieldType.class;
    }
}
