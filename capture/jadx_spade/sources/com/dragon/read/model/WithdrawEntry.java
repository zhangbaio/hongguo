package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class WithdrawEntry implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("cash_amount")
    public int cashAmount;

    @SerializedName("cash_task_key")
    public String cashTaskKey;

    @SerializedName("take_cash_way")
    public int takeCashWay;
    public String url;

    static {
        Covode.recordClassIndex(612308);
        fieldTypeClassRef = FieldType.class;
    }
}
