package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class OrderInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("end_element_order")
    public int endElementOrder;

    @SerializedName("start_element_order")
    public int startElementOrder;

    static {
        Covode.recordClassIndex(613270);
        fieldTypeClassRef = FieldType.class;
    }
}
