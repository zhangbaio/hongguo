package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NewUserSignInData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("add_widget")
    public AddWidget addWidget;

    @SerializedName("bottom_text")
    public String bottomText;

    @SerializedName("cycle_num")
    public int cycleNum;

    @SerializedName("cycle_total_days")
    public int cycleTotalDays;

    @SerializedName("excitation_ad_info")
    public ExcitationAd excitationAdInfo;
    public String extra;

    @SerializedName("have_next_cycle")
    public boolean haveNextCycle;

    @SerializedName("is_cycle")
    public boolean isCycle;

    @SerializedName("is_double_increase")
    public boolean isDoubleIncrease;

    @SerializedName("is_last_day")
    public boolean isLastDay;

    @SerializedName("is_new_style")
    public boolean isNewStyle;

    @SerializedName("is_new_user")
    public boolean isNewUser;

    @SerializedName("is_open")
    public boolean isOpen;

    @SerializedName("is_total_last_day")
    public boolean isTotalLastDay;

    @SerializedName("main_title")
    public String mainTitle;

    @SerializedName("modal_type")
    public String modalType;

    @SerializedName("need_watch_ad_before_reward")
    public boolean needWatchAdBeforeReward;

    @SerializedName("open_calendar_task")
    public TaskInfo openCalendarTask;
    public String schema;

    @SerializedName("sign_bonus")
    public List<NewUserSignInReward> signBonus;

    @SerializedName("sign_in_type")
    public String signInType;

    @SerializedName("signed_days")
    public int signedDays;

    @SerializedName("task_start_time")
    public long taskStartTime;
    public String tips;
    public String title;

    @SerializedName("title_tips")
    public String titleTips;

    @SerializedName("today_signed")
    public boolean todaySigned;

    @SerializedName("ui_style")
    public String uiStyle;

    static {
        Covode.recordClassIndex(612158);
        fieldTypeClassRef = FieldType.class;
    }
}
