package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GenerateAIRewriteRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ai_rewrite_guide_type")
    public AIRewriteGuideType aIRewriteGuideType;

    @SerializedName("book_id")
    public long bookID;
    public String content;

    @SerializedName("custom_rewrite_guide")
    public String customRewriteGuide;

    @SerializedName("item_id")
    public long itemID;

    static {
        Covode.recordClassIndex(612972);
        fieldTypeClassRef = FieldType.class;
    }
}
