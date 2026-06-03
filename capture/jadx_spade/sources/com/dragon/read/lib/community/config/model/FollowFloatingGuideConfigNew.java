package com.dragon.read.lib.community.config.model;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FollowFloatingGuideConfigNew {
    public static final int a;

    @SerializedName("browse_detail_topic_post_time_sec")
    public int browseDetailTopicPostTimeSec = 3;

    @SerializedName("browse_detail_talk_post_time_sec")
    public int browseDetailTalkPostTimeSec = 6;

    @SerializedName("browse_detail_story_post_time_sec")
    public int browseDetailStoryPostTimeSec = 15;

    @SerializedName("browse_detail_book_comment_time_sec")
    public int browseDetailBookCommentTimeSec = 7;

    @SerializedName("browse_profile_page_time_sec")
    public int browseProfilePageTimeSec = 15;

    @SerializedName("interactive_actions_and_times")
    public String interactiveActionsAndTimes = "digg:1;comment:1;clickcard:1";

    @SerializedName("common_auto_close_time_sec")
    public int commonAutoCloseTimeSec = 5;

    @SerializedName("common_desc_in_detail_page")
    public String commonDescInDetailPage = "想看更多更新就关注我吧";

    @SerializedName("common_desc_in_profile_page")
    public String commonDescInProfilePage = "关注我，追踪更多的内容更新";

    @SerializedName("common_detail_page_fatigue_control")
    public int commonDetailPageFatigueControl = 3;

    @SerializedName("common_comment_page_fatigue_control")
    public int commonCommentPageFatigueControl = 5;

    @SerializedName("common_profile_page_fatigue_control")
    public int commonProfilePageFatigueControl = 1;

    @SerializedName("common_click_x_times_continuously_cool_y_days")
    public String commonClickXTimesContinuouslyCoolYDays = "2;3";

    @SerializedName("common_profile_click_x_times_continuously_cool_y_days")
    public String commonProfileClickXTimesContinuouslyCoolYDays = "2;3";

    @SerializedName("common_occurs_x_times_no_click_cool_y_days")
    public String commonOccursXTimesNoClickCoolYDays = "3;30";

    static {
        Covode.recordClassIndex(611353);
        a = 8;
    }
}
