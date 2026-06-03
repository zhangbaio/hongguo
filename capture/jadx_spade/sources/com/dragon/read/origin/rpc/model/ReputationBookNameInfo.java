package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReputationBookNameInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("audit_not_pass_reason")
    public String auditNotPassReason;

    @SerializedName("audit_status")
    public int auditStatus;

    @SerializedName("authorize_type")
    public short authorizeType;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_name")
    public String bookName;

    @SerializedName("can_modify")
    public int canModify;

    @SerializedName("chapter_number")
    public int chapterNumber;

    @SerializedName("reputation_book_name")
    public String reputationBookName;

    @SerializedName("reputation_thumb_uri")
    public String reputationThumbURI;

    @SerializedName("reputation_thumb_url_list")
    public List<ImageFormatInfo> reputationThumbURLList;

    @SerializedName("reverse_sync_reputation_name")
    public String reverseSyncReputationName;

    @SerializedName("reverse_sync_reputation_thumb_uri")
    public String reverseSyncReputationThumbURI;

    @SerializedName("reverse_sync_reputation_thumb_url_list")
    public List<ImageFormatInfo> reverseSyncReputationThumbURLList;
    public int status;

    @SerializedName("thumb_uri")
    public String thumbURI;

    @SerializedName("thumb_url_list")
    public List<ImageFormatInfo> thumbURLList;

    @SerializedName("word_number")
    public int wordNumber;

    static {
        Covode.recordClassIndex(613367);
        fieldTypeClassRef = FieldType.class;
    }
}
