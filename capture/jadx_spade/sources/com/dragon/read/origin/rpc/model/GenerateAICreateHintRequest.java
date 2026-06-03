package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GenerateAICreateHintRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("generate_number")
    public short generateNumber;

    @SerializedName("is_first")
    public boolean isFirst;

    @SerializedName("is_last")
    public boolean isLast;

    @SerializedName("item_id")
    public String itemID;

    @SerializedName("pre_id")
    public String preOutlineID;

    @SerializedName("session_key")
    public String sessionKey;
    public AIHintType structure;

    static {
        Covode.recordClassIndex(612949);
        fieldTypeClassRef = FieldType.class;
    }
}
