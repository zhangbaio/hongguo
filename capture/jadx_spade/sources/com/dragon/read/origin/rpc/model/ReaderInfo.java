package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReaderInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("chapter_data_list")
    public List<ChapterData> chapterDataList;

    @SerializedName("cur_item_order")
    public int curItemOrder;

    @SerializedName("serial_count")
    public int serialCount;

    static {
        Covode.recordClassIndex(613356);
        fieldTypeClassRef = FieldType.class;
    }
}
