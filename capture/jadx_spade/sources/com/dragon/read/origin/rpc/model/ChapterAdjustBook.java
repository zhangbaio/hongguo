package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ChapterAdjustBook implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("adjust_status")
    public ChapterAdjustStatus adjustStatus;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_name")
    public String bookName;

    @SerializedName("reject_reason")
    public String rejectReason;

    @SerializedName("thumb_url_list")
    public List<ImageFormatInfo> thumbURLList;

    @SerializedName("word_number")
    public int wordNumber;

    static {
        Covode.recordClassIndex(612793);
        fieldTypeClassRef = FieldType.class;
    }
}
