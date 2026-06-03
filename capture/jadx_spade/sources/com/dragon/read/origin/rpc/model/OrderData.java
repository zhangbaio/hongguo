package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class OrderData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Name")
    public String name;

    @SerializedName("Order")
    public Order order;

    static {
        Covode.recordClassIndex(613269);
        fieldTypeClassRef = FieldType.class;
    }
}
