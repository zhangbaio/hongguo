package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SignApplyRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("contract_order")
    public short contractOrder;

    @SerializedName("experience_info")
    public String experienceInfo;

    @SerializedName("experience_level")
    public short experienceLevel;

    @SerializedName("is_check")
    public short isCheck;

    static {
        Covode.recordClassIndex(613450);
        fieldTypeClassRef = FieldType.class;
    }
}
