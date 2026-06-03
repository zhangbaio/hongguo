package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class DonePowerUpData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("amount_type")
    public String amountType;
    public BroadcastInfo broadcast;

    @SerializedName("excitation_ad")
    public ExcitationAd excitationAd;

    @SerializedName("next_reward")
    public PowerUpNextReward nextReward;

    @SerializedName("status_extra")
    public String statusExtra;

    static {
        Covode.recordClassIndex(612070);
        fieldTypeClassRef = FieldType.class;
    }
}
