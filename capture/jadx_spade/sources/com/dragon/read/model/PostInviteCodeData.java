package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PostInviteCodeData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("amount_type")
    public String amountType;

    @SerializedName("invite_reward")
    public Reward inviteReward;

    @SerializedName("invite_type")
    public String inviteType;

    @SerializedName("invitees_reward")
    public InviteesReward inviteesReward;
    public UserAppearanceInfo inviter;

    @SerializedName("is_lynx_popup")
    public boolean isLynxPopup;

    @SerializedName("is_new")
    public boolean isNew;

    @SerializedName("popup_schema")
    public String popupSchema;
    public String res;

    static {
        Covode.recordClassIndex(612195);
        fieldTypeClassRef = FieldType.class;
    }
}
