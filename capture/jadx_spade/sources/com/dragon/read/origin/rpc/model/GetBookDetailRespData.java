package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetBookDetailRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID)
    public int activityID;

    @SerializedName("activity_name")
    public String activityName;

    @SerializedName("attend_activity_title")
    public String attendActivityTitle;
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

    @SerializedName("can_modify")
    public boolean canModify;
    public List<CategoryMetaData> category;

    @SerializedName("chapter_number")
    @RpcField(FieldType.BODY)
    public short chapterNumber;

    @SerializedName("check_write_extra_permission")
    public boolean checkWriteExtraPermission;

    @SerializedName("completion_status")
    public short completionStatus;

    @SerializedName("copyright_plagiarism_info_group_by_problem")
    @RpcField(FieldType.BODY)
    public List<BookProblemMarkInfo> copyrightPlagiarismInfoGroupByProblem;

    @SerializedName("create_time")
    public String createTime;

    @SerializedName("creation_audit_status")
    public CreationAuditStatus creationAuditStatus;

    @SerializedName("creation_status")
    public CreationStatus creationStatus;

    @SerializedName("editor_info")
    public String editorInfo;

    @SerializedName("fail_chapter_records_group_by_problem")
    @RpcField(FieldType.BODY)
    public List<BookProblemMarkInfo> failChapterRecordsGroupByProblem;
    public Gender gender;
    public short genre;

    @SerializedName("gift_word")
    public String giftWord;

    @SerializedName("group_category")
    public GroupCategoryData groupCategory;

    @SerializedName("group_name")
    public String groupName;

    @SerializedName("has_activity")
    public short hasActivity;

    @SerializedName("has_hide")
    public HasHideStatus hasHideStatus;

    @SerializedName("has_real_editor")
    public boolean hasRealEditor;

    @SerializedName("hide_button_msg")
    public String hideButtonMsg;

    @SerializedName("in_attend_activity")
    public short inAttendActivity;

    @SerializedName("is_initial_default_book")
    @RpcField(FieldType.BODY)
    public boolean isInitialDefaultBook;

    @SerializedName("is_signing")
    public boolean isSigning;

    @SerializedName("origin_app_level")
    @RpcField(FieldType.BODY)
    public OriginAppLevel originAppLevel;

    @SerializedName("referral_traffic_permission")
    public ReferralTrafficPermission referralTrafficPermission;

    @SerializedName("referral_traffic_running_state")
    public ReferralTrafficRunningState referralTrafficRunningState;
    public List<String> roles;

    @SerializedName("safe_reaudit_status")
    public SafeReAuditStatus safeReAuditStatus;

    @SerializedName("safe_reaudit_time")
    public long safeReAuditTime;

    @SerializedName("security_status")
    public SecurityStatus securityStatus;

    @SerializedName("set_top")
    public SetTopStatus setTopStatus;

    @SerializedName("sign_progress")
    public short signProgress;
    public BookStatus status;
    public String summary;

    @SerializedName("thumb_uri")
    public String thumbURI;

    @SerializedName("thumb_url_list")
    public List<ImageFormatInfo> thumbUrlList;

    @SerializedName("top_button_msg")
    public String topButtonMsg;

    @SerializedName("verify_status")
    public short verifyStatus;

    @SerializedName("word_number")
    public long wordNumber;

    static {
        Covode.recordClassIndex(613062);
        fieldTypeClassRef = FieldType.class;
    }
}
