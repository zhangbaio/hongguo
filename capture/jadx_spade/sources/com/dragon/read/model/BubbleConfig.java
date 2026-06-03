package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BubbleConfig implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bubble_life_times")
    public int bubbleLifeTimes;
    public boolean clickable;
    public String content;
    public int duration;

    @SerializedName("min_show_interval_days")
    public int minShowIntervalDays;

    @SerializedName("need_redirect")
    public boolean needRedirect;

    @SerializedName("not_click_exit_days")
    public int notClickExitDays;

    @SerializedName("not_click_expire_days")
    public int notClickExpireDays;

    @SerializedName("reward_type")
    public String rewardType;
    public String scene;
    public int seconds;
    public int style;

    static {
        Covode.recordClassIndex(612046);
        fieldTypeClassRef = FieldType.class;
    }
}
