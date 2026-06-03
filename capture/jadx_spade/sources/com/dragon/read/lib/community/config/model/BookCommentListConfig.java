package com.dragon.read.lib.community.config.model;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookCommentListConfig {
    public static final int a;

    @SerializedName("comment_item_ui_style")
    public int commentItemUIStyle;

    @SerializedName("comment_content_support_expand")
    public boolean commentSupportExpand;

    @SerializedName("comment_tag_can_expand")
    public boolean commentTagCanExpand;

    @SerializedName("need_show_read_button")
    public boolean needShowReadButton;

    @SerializedName("opt_screen_performance")
    public boolean optScreenPerformance;

    @SerializedName("read_button_always_show")
    public boolean readButtonAlwaysShow;

    @SerializedName("is_enable_follow_floating_view")
    public boolean isEnableFollowFloatingView = true;

    @SerializedName("is_enable_comment_item_follow_entrance")
    public boolean isEnableCommentItemFollowEntrance = true;

    static {
        Covode.recordClassIndex(611346);
        a = 8;
    }

    public final boolean a() {
        if (this.commentItemUIStyle == 1) {
            return true;
        }
        return false;
    }
}
