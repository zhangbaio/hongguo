package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetReputationBookNameListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("image_fmt_list")
    public List<String> imageFmtList;

    @SerializedName("page_count")
    public int pageCount;

    @SerializedName("page_index")
    public int pageIndex;

    static {
        Covode.recordClassIndex(613142);
        fieldTypeClassRef = FieldType.class;
    }
}
