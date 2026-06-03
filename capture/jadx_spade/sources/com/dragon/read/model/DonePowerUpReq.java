package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class DonePowerUpReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("background_charging_increment")
    public int backgroundChargingIncrement;

    @SerializedName("collect_total_amount")
    public int collectTotalAmount;

    @SerializedName("done_event")
    public String doneEvent;

    @SerializedName("foreground_charging_increment")
    public int foregroundChargingIncrement;

    @SerializedName("increase_amount")
    public int increaseAmount;

    @SerializedName("other_charging_increment")
    public int otherChargingIncrement;

    static {
        Covode.recordClassIndex(612072);
        fieldTypeClassRef = FieldType.class;
    }
}
