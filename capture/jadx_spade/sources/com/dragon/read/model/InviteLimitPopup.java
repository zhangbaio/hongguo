package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InviteLimitPopup implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("end_time")
    public long endTime;
    public InvitePopInfo info;

    @SerializedName("reward_extra")
    public Reward rewardExtra;

    @SerializedName("reward_max")
    public Reward rewardMax;

    @SerializedName("reward_total")
    public Reward rewardTotal;

    @SerializedName("style_type")
    public int styleType;
    public String type;

    static {
        Covode.recordClassIndex(612130);
        fieldTypeClassRef = FieldType.class;
    }
}
