package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EditArticleV1RespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("author_speak")
    public AuthorSpeak authorSpeak;

    @SerializedName("AuthorSpeakAuditBlock")
    public boolean authorSpeakAuditBlock;

    @SerializedName("can_delete")
    public boolean canDelete;

    @SerializedName("can_modify")
    public boolean canModify;

    @SerializedName("cant_modify_reason")
    public String cantModifyReason;

    @SerializedName("column_data")
    public ColumnData columnData;
    public String content;

    @SerializedName("content_mark_problem")
    public Map<Integer, ProblemMarkInfo> contentMarkProblem;

    @SerializedName("create_time")
    public String createTime;

    @SerializedName("creation_status")
    public CreationStatus creationStatus;

    @SerializedName("display_status")
    public short displayStatus;

    @SerializedName("highlight_content")
    public String highlightContent;

    @SerializedName("hot_timer")
    public List<Integer> hotTimer;

    @SerializedName("is_initial_default_book")
    public boolean isInitialDefaultBook;

    @SerializedName("latest_publish_item_info")
    public ItemInfo latestPublishItemInfo;

    @SerializedName("latest_version")
    public int latestVersion;

    @SerializedName("mp_highlight_auto")
    public short mpHighlightAuto;

    @SerializedName("mp_highlight_stage")
    public short mpHighlightStage;

    @SerializedName("mp_highlight_surplus")
    public short mpHighlightSurplus;

    @SerializedName("order_greater_20")
    public boolean orderGreater20;

    @SerializedName("permission_switch")
    public short permissionSwitch;

    @SerializedName("pic_desc_mark_problem")
    public Map<Integer, PicDescMarkInfo> picDescMarkProblem;

    @SerializedName("picture_mark_problem")
    public Map<Integer, PictureMarkInfo> pictureMarkProblem;

    @SerializedName("pre_audit_info")
    @RpcField(FieldType.BODY)
    public PreAuditInfo preAuditInfo;

    @SerializedName("publish_status")
    public PublishStatus publishStatus;

    @SerializedName("real_order")
    public int realOrder;

    @SerializedName("refuse_reason_list")
    public List<String> refuseReasonList;

    @SerializedName("timer_chapter_preview")
    public TimerChapterPreviewMeta timerChapterPreview;

    @SerializedName("timer_status")
    public TimerStatus timerStatus;

    @SerializedName("timer_time")
    public String timerTime;
    public String title;

    @SerializedName("title_problem")
    public String titleProblem;

    @SerializedName("use_ai")
    public short useAI;

    @SerializedName("user_auth")
    public UserAuthStatus userAuth;

    @SerializedName("volume_data")
    public List<VolumeData> volumeData;

    @SerializedName("volume_id")
    public String volumeID;

    @SerializedName("word_number")
    public long wordNumber;

    static {
        Covode.recordClassIndex(612911);
        fieldTypeClassRef = FieldType.class;
    }
}
