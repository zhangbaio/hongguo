package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GenerateAINamingRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ai_naming_type")
    public AINamingType aINamingType;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("custom_naming_type")
    public String customNamingType;

    @SerializedName("item_id")
    public long itemID;
    public String prompt;

    static {
        Covode.recordClassIndex(612969);
        fieldTypeClassRef = FieldType.class;
    }
}
