package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class IncomeDataHexiaoInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("latest_hexiao_cash_amount")
    public int latestHexiaoCashAmount;

    @SerializedName("latest_hexiao_date")
    public String latestHexiaoDate;

    @SerializedName("latest_hexiao_score_amount")
    public int latestHexiaoScoreAmount;

    static {
        Covode.recordClassIndex(612125);
        fieldTypeClassRef = FieldType.class;
    }
}
