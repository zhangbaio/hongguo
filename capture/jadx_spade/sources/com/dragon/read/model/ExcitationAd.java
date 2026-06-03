package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ExcitationAd implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ab_test_version")
    public String abTestVersion;

    @SerializedName("actual_ecpm")
    public String actualEcpm;

    @SerializedName("ad_count")
    public int adCount;

    @SerializedName("ad_remains")
    public int adRemains;

    @SerializedName("completed_times")
    public int completedTimes;

    @SerializedName("continue_limit")
    public int continueLimit;

    @SerializedName("daily_limit")
    public int dailyLimit;

    @SerializedName("disable_reward")
    public boolean disableReward;

    @SerializedName("free_ad_time")
    public int freeAdTime;

    @SerializedName("inspire_time")
    public int inspireTime;

    @SerializedName("is_open")
    public boolean isOpen;

    @SerializedName("is_staged")
    public boolean isStaged;

    @SerializedName("listen_free_day_show_type")
    public int listenFreeDayShowType;

    @SerializedName("log_extra")
    public String logExtra;

    @SerializedName("max_exposed")
    public boolean maxExposed;

    @SerializedName("score_amount")
    public int scoreAmount;

    @SerializedName("stage_amounts")
    public List<Integer> stageAmounts;

    @SerializedName("task_event_param")
    public TaskEventParam taskEventParam;

    @SerializedName("task_key")
    public String taskKey;

    @SerializedName("total_times")
    public int totalTimes;

    @SerializedName("track_id")
    public String trackId;

    static {
        Covode.recordClassIndex(612086);
        fieldTypeClassRef = FieldType.class;
    }
}
