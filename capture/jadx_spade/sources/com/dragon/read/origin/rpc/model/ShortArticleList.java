package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortArticleList implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ai_contract_status")
    @RpcField(FieldType.BODY)
    public short aIContractStatus;

    @SerializedName("activity_info")
    public ShortArticleActivity activityInfo;

    @SerializedName("authorize_type")
    public short authorizeType;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_status")
    public short bookStatus;

    @SerializedName("book_thumb_uri")
    @RpcField(FieldType.BODY)
    public String bookThumbURI;

    @SerializedName("book_thumb_url_list")
    @RpcField(FieldType.BODY)
    public List<ImageFormatInfo> bookThumbUrlList;

    @SerializedName("can_delete")
    public boolean canDelete;

    @SerializedName("can_join_activity")
    public ShortArticleActivity canJoinActivity;

    @SerializedName("can_mark_problem")
    @RpcField(FieldType.BODY)
    public boolean canMarkProblem;

    @SerializedName("can_modify")
    public boolean canModify;

    @SerializedName("can_modify_sign")
    public boolean canModifySign;
    public List<CategoryMetaData> category;

    @SerializedName("create_time")
    public String createTime;

    @SerializedName("digg_count")
    public int diggCount;

    @SerializedName("digg_count_str")
    public String diggCountStr;

    @SerializedName("display_status")
    public short displayStatus;

    @SerializedName("is_data_show")
    @RpcField(FieldType.BODY)
    public short isDataShow;

    @SerializedName("item_id")
    public String itemID;

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

    @SerializedName("purchase_read_count")
    public int purchaseReadCount;

    @SerializedName("purchase_read_count_str")
    public String purchaseReadCountStr;

    @SerializedName("read_count")
    @RpcField(FieldType.BODY)
    public String readCount;

    @SerializedName("sign_create_time")
    public String signCreateTime;

    @SerializedName("sign_status")
    public ShortArticleSignStatus signStatus;

    @SerializedName("sign_status_text")
    public String signStatusText;

    @SerializedName("sign_type")
    public short signType;

    @SerializedName("thumb_uri")
    public String thumbURI;

    @SerializedName("thumb_url_list")
    public List<ImageFormatInfo> thumbUrlList;

    @SerializedName("word_number")
    public long wordNumber;

    static {
        Covode.recordClassIndex(613447);
        fieldTypeClassRef = FieldType.class;
    }
}
