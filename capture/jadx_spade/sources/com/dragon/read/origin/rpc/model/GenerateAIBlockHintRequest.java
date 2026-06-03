package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GenerateAIBlockHintRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;
    public String category;

    @SerializedName("is_first")
    public boolean isFirst;

    @SerializedName("more_setting")
    public String moreSetting;
    public String setting;

    static {
        Covode.recordClassIndex(612940);
        fieldTypeClassRef = FieldType.class;
    }
}
