package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ChapterData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("item_id")
    public String itemId;

    @SerializedName("item_order")
    public int itemOrder;

    static {
        Covode.recordClassIndex(612801);
        fieldTypeClassRef = FieldType.class;
    }
}
