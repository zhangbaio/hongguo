package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortVideoAutoCollectResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("amount_to_be_receive")
    public int amountToBeReceive;

    @SerializedName("amount_type")
    public String amountType;

    @SerializedName("award_list")
    public List<AwardNode> awardList;

    @SerializedName("box_increase_style")
    public String boxIncreaseStyle;

    @SerializedName("can_new_video_collect")
    public boolean canNewVideoCollect;

    @SerializedName("can_super_double")
    public boolean canSuperDouble;

    @SerializedName("device_collect_times")
    public int deviceCollectTimes;

    @SerializedName("gold_redpack_collect_info")
    public GoldRedpackCollectInfo goldRedpackCollectInfo;

    @SerializedName("init_speed_rate")
    public double initSpeedRate;

    @SerializedName("next_loop_reward")
    public Reward nextLoopReward;

    @SerializedName("next_loop_speed")
    public int nextLoopSpeed;

    @SerializedName("remind_increase_style")
    public String remindIncreaseStyle;

    @SerializedName("total_completed")
    public boolean totalCompleted;

    static {
        Covode.recordClassIndex(612249);
        fieldTypeClassRef = FieldType.class;
    }
}
