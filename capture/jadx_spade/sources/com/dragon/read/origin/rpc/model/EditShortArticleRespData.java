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
public class EditShortArticleRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("activity_info")
    public ShortArticleActivity activityInfo;

    @SerializedName("audit_fail_infos")
    public List<ShortArticleAuditFailInfo> auditFailInfos;

    @SerializedName("authorize_type")
    public short authorizeType;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_thumb_uri")
    public String bookThumbURI;

    @SerializedName("book_thumb_url_list")
    public List<ImageFormatInfo> bookThumbUrlList;

    @SerializedName("can_delete")
    public boolean canDelete;

    @SerializedName("can_mark_problem")
    @RpcField(FieldType.BODY)
    public boolean canMarkProblem;

    @SerializedName("can_modify")
    public boolean canModify;

    @SerializedName("cant_delete_reason")
    public String cantDeleteReason;

    @SerializedName("cant_modify_reason")
    public String cantModifyReason;
    public List<CategoryMetaData> category;

    @SerializedName("category_max_count")
    @RpcField(FieldType.BODY)
    public int categoryMaxCount;
    public String content;

    @SerializedName("content_mark_problem")
    @RpcField(FieldType.BODY)
    public Map<Integer, ProblemMarkInfo> contentMarkProblem;

    @SerializedName("create_time")
    public String createTime;

    @SerializedName("display_status")
    public short displayStatus;

    @SerializedName("item_id")
    public String itemID;

    @SerializedName("latest_version")
    public int latestVersion;

    @SerializedName("modify_time")
    public String modifyTime;

    @SerializedName("mp_highlight_stage")
    @RpcField(FieldType.BODY)
    public short mpHighlightStage;

    @SerializedName("mp_highlight_surplus")
    @RpcField(FieldType.BODY)
    public short mpHighlightSurplus;

    @SerializedName("multi_title")
    public List<String> multiTitle;

    @SerializedName("picture_mark_problem")
    @RpcField(FieldType.BODY)
    public Map<Integer, PictureMarkInfo> pictureMarkProblem;

    @SerializedName("publish_status")
    public PublishStatus publishStatus;

    @SerializedName("refuse_reason_list")
    @RpcField(FieldType.BODY)
    public List<String> refuseReasonList;

    @SerializedName("sign_status")
    public ShortArticleSignStatus signStatus;

    @SerializedName("sign_type")
    public short signType;

    @SerializedName("story_origin_divided_chapters")
    @RpcField(FieldType.BODY)
    public short storyOriginDividedChapters;

    @SerializedName("thumb_mark_problem")
    @RpcField(FieldType.BODY)
    public Map<Integer, PictureMarkInfo> thumbMarkProblem;

    @SerializedName("thumb_uri")
    public String thumbURI;

    @SerializedName("thumb_url_list")
    public List<ImageFormatInfo> thumbUrlList;

    @SerializedName("title_problem")
    @RpcField(FieldType.BODY)
    public String titleProblem;

    @SerializedName("use_ai")
    @RpcField(FieldType.BODY)
    public short useAI;

    @SerializedName("word_number")
    public long wordNumber;

    static {
        Covode.recordClassIndex(612915);
        fieldTypeClassRef = FieldType.class;
    }
}
