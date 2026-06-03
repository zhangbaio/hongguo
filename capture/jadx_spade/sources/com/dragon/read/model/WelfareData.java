package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class WelfareData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("cover_url")
    public String coverUrl;

    @SerializedName("gold_bubble")
    public Bubble goldBubble;

    @SerializedName("join_gold_donation")
    public boolean joinGoldDonation;

    @SerializedName("join_gold_donation_days")
    public int joinGoldDonationDays;

    @SerializedName("today_gold_donation_amount")
    public int todayGoldDonationAmount;

    static {
        Covode.recordClassIndex(612302);
        fieldTypeClassRef = FieldType.class;
    }
}
