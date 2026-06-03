package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ColdStartAttributeInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("attribute_type")
    public String attributeType;
    public String extra;
    public String operation;

    @SerializedName("product_id")
    public String productId;
    public int type;

    static {
        Covode.recordClassIndex(612057);
        fieldTypeClassRef = FieldType.class;
    }
}
