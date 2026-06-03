package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SignInDetailData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ab_info")
    public Map<String, String> abInfo;

    @SerializedName("add_widget")
    public AddWidget addWidget;

    @SerializedName("caijing_award_info")
    public BaseInfo caijingAwardInfo;

    @SerializedName("caijing_landing_page_task_info")
    public List<CaiJingLandingPageTaskInfo> caijingLandingPageTaskInfo;

    @SerializedName("calendar_bonus_finished")
    public boolean calendarBonusFinished;
    public int days;

    @SerializedName("excitation_ad")
    public ExcitationAd excitationAd;

    @SerializedName("excitation_ad_completed")
    public boolean excitationAdCompleted;

    @SerializedName("excitation_ad_extra_info")
    public ExcitationAdExtraInfo excitationAdExtraInfo;

    @SerializedName("excitation_ad_signin_completed")
    public boolean excitationAdSigninCompleted;

    @SerializedName("has_sign_in_invite")
    public boolean hasSignInInvite;

    @SerializedName("hide_reward_style")
    public String hideRewardStyle;

    @SerializedName("history_reward")
    public SignInHistoryReward historyReward;

    @SerializedName("invite_amount")
    public int inviteAmount;

    @SerializedName("is_broken_sign")
    public boolean isBrokenSign;

    @SerializedName("is_parallel")
    public boolean isParallel;

    @SerializedName("is_renew")
    public boolean isRenew;

    @SerializedName("is_sign_auto")
    public boolean isSignAuto;

    @SerializedName("is_sign_manual")
    public boolean isSignManual;

    @SerializedName("is_vip")
    public boolean isVip;

    @SerializedName("long_sign_bonus")
    public Map<Integer, Integer> longSignBonus;

    @SerializedName("need_op_before_renew")
    public boolean needOpBeforeRenew;

    @SerializedName("need_watch_ad_before_reward")
    public boolean needWatchAdBeforeReward;

    @SerializedName("next_round_show_amount")
    public int nextRoundShowAmount;

    @SerializedName("next_task_info")
    public NextTaskInfo nextTaskInfo;

    @SerializedName("open_push_permission_task_info")
    public OpenPushPermissionTaskInfo openPushPermissionTaskInfo;

    @SerializedName("reminder_info")
    public ReminderInfo reminderInfo;

    @SerializedName("renew_new_style")
    public boolean renewNewStyle;

    @SerializedName("round_increase")
    public RoundIncrease roundIncrease;

    @SerializedName("seven_day_sign_bonus")
    public List<Integer> sevenDaySignBonus;

    @SerializedName("show_third_day_reward")
    public boolean showThirdDayReward;

    @SerializedName("sign_bonus")
    public List<Integer> signBonus;

    @SerializedName("sign_bonus_tips_arr")
    public List<SignBonusTip> signBonusTipsArr;

    @SerializedName("sign_invite_popup_schema")
    public String signInvitePopupSchema;
    public String subtitle;

    @SerializedName("today_signed")
    public boolean todaySigned;

    @SerializedName("treasure_enable")
    public boolean treasureEnable;

    @SerializedName("weak_user_expansion")
    public WeakUserExpansion weakUserExpansion;

    static {
        Covode.recordClassIndex(612251);
        fieldTypeClassRef = FieldType.class;
    }
}
