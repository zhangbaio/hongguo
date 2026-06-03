package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EaApplyRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("apply_target")
    public short applyTarget;

    @SerializedName("book_id")
    public long bookID;

    static {
        Covode.recordClassIndex(612903);
        fieldTypeClassRef = FieldType.class;
    }
}
