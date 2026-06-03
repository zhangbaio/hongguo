package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InviteInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("invite_type")
    public String inviteType;
    public UserAppearanceInfo inviter;

    @SerializedName("is_lynx_popup")
    public boolean isLynxPopup;

    @SerializedName("popup_schema")
    public String popupSchema;

    @SerializedName("reward_new")
    public Reward rewardNew;

    @SerializedName("reward_old")
    public Reward rewardOld;

    static {
        Covode.recordClassIndex(612127);
        fieldTypeClassRef = FieldType.class;
    }
}
