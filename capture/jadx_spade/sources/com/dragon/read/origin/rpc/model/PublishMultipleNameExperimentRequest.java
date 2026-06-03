package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PublishMultipleNameExperimentRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("group_list")
    public String groupList;

    @SerializedName("record_id")
    public String recordID;

    static {
        Covode.recordClassIndex(613338);
        fieldTypeClassRef = FieldType.class;
    }
}
