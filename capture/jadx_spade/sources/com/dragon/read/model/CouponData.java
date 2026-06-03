package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CouponData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("coupon_id")
    public String couponId;

    @SerializedName("end_time")
    public int endTime;

    @SerializedName("exchange_subtitle")
    public String exchangeSubtitle;

    @SerializedName("exchange_title")
    public String exchangeTitle;

    @SerializedName("fund_after_balance")
    public int fundAfterBalance;

    @SerializedName("fund_cost_amount")
    public int fundCostAmount;

    @SerializedName("fund_face_value")
    public int fundFaceValue;

    @SerializedName("fund_rebate_value")
    public int fundRebateValue;

    @SerializedName("is_received")
    public boolean isReceived;
    public String schema;

    @SerializedName("start_time")
    public int startTime;
    public String subtitle;
    public String title;

    static {
        Covode.recordClassIndex(612066);
        fieldTypeClassRef = FieldType.class;
    }
}
