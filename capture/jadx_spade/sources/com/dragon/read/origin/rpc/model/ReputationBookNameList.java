package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReputationBookNameList implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("item_list")
    public List<ReputationBookNameInfo> itemList;

    @SerializedName("total_count")
    public int totalCount;

    static {
        Covode.recordClassIndex(613368);
        fieldTypeClassRef = FieldType.class;
    }
}
