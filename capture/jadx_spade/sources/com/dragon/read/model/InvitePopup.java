package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InvitePopup implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("reward_invitee")
    public Reward rewardInvitee;

    @SerializedName("reward_inviter")
    public Reward rewardInviter;

    static {
        Covode.recordClassIndex(612133);
        fieldTypeClassRef = FieldType.class;
    }
}
