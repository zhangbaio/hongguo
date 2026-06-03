package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class OperateBookRecommendRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("confirm_status")
    public ConfirmStatus confirmStatus;

    @SerializedName("operate_type")
    public OperateBookRecommendType operateType;

    static {
        Covode.recordClassIndex(613262);
        fieldTypeClassRef = FieldType.class;
    }
}
