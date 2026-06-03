package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReminderInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("extra_reward_amount")
    public int extraRewardAmount;

    @SerializedName("open_switch_can_get_reward")
    public boolean openSwitchCanGetReward;

    @SerializedName("reminder_location")
    public String reminderLocation;

    @SerializedName("reminder_status")
    public boolean reminderStatus;

    @SerializedName("reminder_time")
    public int reminderTime;

    @SerializedName("reminder_way")
    public String reminderWay;

    @SerializedName("today_have_extra_reward")
    public boolean todayHaveExtraReward;

    @SerializedName("tomorrow_have_extra_reward")
    public boolean tomorrowHaveExtraReward;

    static {
        Covode.recordClassIndex(612220);
        fieldTypeClassRef = FieldType.class;
    }
}
