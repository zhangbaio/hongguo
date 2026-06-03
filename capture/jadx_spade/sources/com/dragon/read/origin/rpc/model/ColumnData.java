package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ColumnData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("article_status")
    public ChapterAuditStatus articleStatus;

    @SerializedName("attribution_type")
    public short attributionType;

    @SerializedName("audit_chapter")
    public AuditChapter auditChapter;

    @SerializedName("book_extra_word_number")
    public long bookExtraWordNumber;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_name")
    public String bookName;

    @SerializedName("chapter_ad_permission")
    public boolean chapterAdPermission;

    @SerializedName("chapter_passed_num")
    public int chapterPassedNum;

    @SerializedName("has_new_volume")
    public boolean hasNewVolume;

    @SerializedName("has_new_volume_tip")
    public String hasNewVolumeTip;

    @SerializedName("origin_chapter_ad_status")
    public short originChapterAdStatus;
    public short platform;

    @SerializedName("previous_chapter_title")
    public String previousChapterTitle;
    public BookStatus status;

    @SerializedName("verify_status")
    public BookAuditStatus verifyStatus;

    static {
        Covode.recordClassIndex(612830);
        fieldTypeClassRef = FieldType.class;
    }
}
