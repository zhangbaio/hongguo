package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetChapterAdjustBookListRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_list")
    public List<ChapterAdjustBook> bookList;

    @SerializedName("total_count")
    public int totalCount;

    static {
        Covode.recordClassIndex(613079);
        fieldTypeClassRef = FieldType.class;
    }
}
