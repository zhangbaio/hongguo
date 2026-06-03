package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetChapterListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("must_have_correction_feedback")
    public short mustHaveCorrectionFeedback;

    @SerializedName("need_correction_feedback_num")
    public short needCorrectionFeedbackNum;

    @SerializedName("page_count")
    public short pageCount;

    @SerializedName("page_index")
    public short pageIndex;

    @RpcField(FieldType.QUERY)
    public String sort;
    public ChapterAuditStatus status;

    @SerializedName("volume_id")
    public long volumeID;

    static {
        Covode.recordClassIndex(613084);
        fieldTypeClassRef = FieldType.class;
    }
}
