package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetPreSignBookListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("page_count")
    public short pageCount;

    @SerializedName("page_index")
    public short pageIndex;

    static {
        Covode.recordClassIndex(613136);
        fieldTypeClassRef = FieldType.class;
    }
}
