package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAttendBookListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("attended_activity")
    public short attendedActivity;

    @SerializedName("image_fmt_list")
    public List<String> imageFmtList;

    @SerializedName("page_count")
    public long pageCount;

    @SerializedName("page_index")
    public long pageIndex;

    static {
        Covode.recordClassIndex(613034);
        fieldTypeClassRef = FieldType.class;
    }
}
