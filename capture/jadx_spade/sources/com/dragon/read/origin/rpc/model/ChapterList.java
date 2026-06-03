package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ChapterList implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("article_status")
    public short articleStatus;

    @SerializedName("AuthorSpeakAuditBlock")
    public boolean authorSpeakAuditBlock;

    @SerializedName("can_delete")
    public short canDelete;

    @SerializedName("correction_feedback_num")
    public int correctionFeedbackNum;

    @SerializedName("create_time")
    public String createTime;

    @SerializedName("display_status")
    public short displayStatus;
    public int index;

    @SerializedName("item_id")
    public String itemID;

    @SerializedName("mp_highlight_stage")
    public short mpHighlightStage;

    @SerializedName("sell_product_chapter")
    public short sellProductChapter;

    @SerializedName("speak_status")
    public SpeakStatus speakStatus;

    @SerializedName("timer_time")
    public String timerTime;
    public String title;

    @SerializedName("volume_id")
    public String volumeID;

    @SerializedName("word_number")
    public long wordNumber;

    static {
        Covode.recordClassIndex(612802);
        fieldTypeClassRef = FieldType.class;
    }
}
