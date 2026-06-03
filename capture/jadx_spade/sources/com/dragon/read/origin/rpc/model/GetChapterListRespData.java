package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetChapterListRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("adjust_status")
    public ChapterAdjustStatus adjustStatus;

    @SerializedName("book_extra_word_number")
    public long bookExtraWordNumber;

    @SerializedName("book_write_extra_permission")
    public short bookWriteExtraPermission;

    @SerializedName("creation_status")
    public CreationStatus creationStatus;

    @SerializedName("item_list")
    public List<ChapterList> itemList;

    @SerializedName("total_count")
    public int totalCount;

    static {
        Covode.recordClassIndex(613085);
        fieldTypeClassRef = FieldType.class;
    }
}
