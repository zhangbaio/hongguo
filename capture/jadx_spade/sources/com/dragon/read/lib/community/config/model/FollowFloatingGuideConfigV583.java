package com.dragon.read.lib.community.config.model;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FollowFloatingGuideConfigV583 {
    public static final int a;

    @SerializedName("interval_time_sec")
    public int intervalTimeSec = 600;

    @SerializedName("fatigue_control")
    public int fatigueControl = 3;

    @SerializedName("common_auto_close_time_sec")
    public int commonAutoCloseTimeSec = 5;

    @SerializedName("common_click_x_times_continuously_cool_y_days")
    public String commonClickXTimesContinuouslyCoolYDays = "1;3";

    static {
        Covode.recordClassIndex(611354);
        a = 8;
    }
}
