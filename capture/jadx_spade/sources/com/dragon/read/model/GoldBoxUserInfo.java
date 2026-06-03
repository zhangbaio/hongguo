package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GoldBoxUserInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ab_info")
    public String abInfo;

    @SerializedName("activate_title")
    public String activateTitle;

    @SerializedName("active_effect_times")
    public int activeEffectTimes;

    @SerializedName("bottom_bubble_text")
    public String bottomBubbleText;

    @SerializedName("click_action")
    public String clickAction;

    @SerializedName("comic_schema")
    public String comicSchema;

    @SerializedName("comics_data")
    public GoldBoxPageData comicsData;
    public boolean enable;

    @SerializedName("enable_ad_free_task")
    public boolean enableAdFreeTask;

    @SerializedName("expire_days")
    public int expireDays;
    public String extra;

    @SerializedName("game_data")
    public GameData gameData;

    @SerializedName("gold_box_page")
    public GoldBoxPageData goldBoxPage;

    @SerializedName("is_multi")
    public int isMulti;

    @SerializedName("is_show_listen_task")
    public boolean isShowListenTask;

    @SerializedName("is_show_listen_title")
    public boolean isShowListenTitle;

    @SerializedName("listen_data")
    public GoldBoxPageData listenData;

    @SerializedName("listen_schema")
    public String listenSchema;

    @SerializedName("listen_tab_title")
    public String listenTabTitle;

    @SerializedName("no_voice_broadcast")
    public boolean noVoiceBroadcast;

    @SerializedName("not_login_popup")
    public boolean notLoginPopup;

    @SerializedName("not_login_scene")
    public String notLoginScene;

    @SerializedName("notlogin_title")
    public String notloginTitle;

    @SerializedName("reader_data")
    public GoldBoxPageData readerData;

    @SerializedName("reader_schema")
    public String readerSchema;

    @SerializedName("reader_style")
    public String readerStyle;
    public String title;

    @SerializedName("trans_url")
    public String transUrl;
    public String type;

    @SerializedName("ui_style")
    public String uiStyle;

    @SerializedName("user_tag")
    public int userTag;

    @SerializedName("video_data")
    public GoldBoxPageData videoData;

    @SerializedName("video_schema")
    public String videoSchema;

    @SerializedName("wechat_url")
    public String wechatUrl;

    @SerializedName("wechat_withdraw_title")
    public String wechatWithdrawTitle;

    @SerializedName("welfare_data")
    public WelfareData welfareData;

    @SerializedName("writer_page_data")
    public GoldBoxPageData writerPageData;

    @SerializedName("writer_page_schema")
    public String writerPageSchema;

    static {
        Covode.recordClassIndex(612120);
        fieldTypeClassRef = FieldType.class;
    }
}
