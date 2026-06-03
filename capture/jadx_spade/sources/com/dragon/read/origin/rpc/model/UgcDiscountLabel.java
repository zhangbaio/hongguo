package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcDiscountLabel implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;

    @SerializedName("label_header")
    public String labelHeader;

    static {
        Covode.recordClassIndex(613506);
        fieldTypeClassRef = FieldType.class;
    }
}
