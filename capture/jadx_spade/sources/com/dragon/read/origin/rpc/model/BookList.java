package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BookList implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID)
    public int activityID;

    @SerializedName("activity_name")
    public String activityName;
    public String author;

    @SerializedName("authorize_type")
    public AuthorizeType authorizeType;

    @SerializedName("book_flight_alias_name")
    public String bookFlightAliasName;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_intro")
    public BookIntro bookIntro;

    @SerializedName("book_name")
    public String bookName;

    @SerializedName("can_delete")
    public boolean canDelete;

    @SerializedName("can_join_activity")
    public boolean canJoinActivity;

    @SerializedName("can_join_activity_id")
    public String canJoinActivityID;

    @SerializedName("can_modify")
    public boolean canModify;

    @SerializedName("chapter_number")
    public short chapterNumber;

    @SerializedName("content_word_number")
    public long contentWordNumber;

    @SerializedName("create_time")
    public String createTime;

    @SerializedName("creation_status")
    public CreationStatus creationStatus;

    @SerializedName("default_thumb_url")
    public boolean defaultThumbURL;

    @SerializedName("editor_info")
    public EditorInfo editorInfo;

    @SerializedName("extra_word_number")
    public long extraWordNumber;

    @SerializedName("has_activity")
    public short hasActivity;

    @SerializedName("has_hide")
    public HasHideStatus hasHideStatus;

    @SerializedName("in_attend_activity")
    public short inAttendActivity;

    @SerializedName("is_cp")
    public short isCP;

    @SerializedName("last_chapter_id")
    public String lastChapterID;

    @SerializedName("last_chapter_time")
    public String lastChapterTime;

    @SerializedName("last_chapter_title")
    public String lastChapterTitle;

    @SerializedName("origin_app_level")
    public OriginAppLevel originAppLevel;

    @SerializedName("referral_traffic_permission")
    public ReferralTrafficPermission referralTrafficPermission;

    @SerializedName("referral_traffic_running_state")
    public ReferralTrafficRunningState referralTrafficRunningState;

    @SerializedName("security_auditor_status")
    public short securityAuditorStatus;

    @SerializedName("security_status")
    public SecurityStatus securityStatus;

    @SerializedName("set_top")
    public SetTopStatus setTopStatus;

    @SerializedName("sign_level_data")
    public SignLevelStatus signLevelData;

    @SerializedName("sign_progress")
    public SignProgress signProgress;

    @SerializedName("sign_remind_toast")
    public String signRemindToast;

    @SerializedName("sign_task_group")
    public String signTaskGroup;
    public String source;
    public BookStatus status;
    public String summary;

    @SerializedName("thumb_uri")
    public String thumbURI;

    @SerializedName("thumb_url_list")
    public List<ImageFormatInfo> thumbUrlList;

    @SerializedName("verify_status")
    public short verifyStatus;

    @SerializedName("weak_ending")
    public short weakEnding;

    @SerializedName("word_number")
    public long wordNumber;

    @SerializedName("write_extra_permission")
    public short writeExtraPermission;

    static {
        Covode.recordClassIndex(612777);
        fieldTypeClassRef = FieldType.class;
    }
}
