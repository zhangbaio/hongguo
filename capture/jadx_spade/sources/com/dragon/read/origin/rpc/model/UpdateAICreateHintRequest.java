package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UpdateAICreateHintRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("change_content")
    public String changeContent;

    static {
        Covode.recordClassIndex(613538);
        fieldTypeClassRef = FieldType.class;
    }
}
