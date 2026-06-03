package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GenerateAIInsetV1Request implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ai_inset_style")
    @RpcField(FieldType.QUERY)
    public AIInsetStyle aIInsetStyle;

    @SerializedName("ai_inset_type")
    @RpcField(FieldType.QUERY)
    public AIInsetType aIInsetType;

    @SerializedName("book_id")
    @RpcField(FieldType.QUERY)
    public long bookID;

    @RpcField(FieldType.QUERY)
    public String group;

    @RpcField(FieldType.QUERY)
    public int height;

    @SerializedName("highlights_type")
    @RpcField(FieldType.QUERY)
    public HighlightsType highlightsType;

    @SerializedName("item_id")
    @RpcField(FieldType.QUERY)
    public long itemID;

    @RpcField(FieldType.QUERY)
    public String prompt;

    @RpcField(FieldType.QUERY)
    public AIInsetScene scene;

    @SerializedName("source_uri")
    @RpcField(FieldType.QUERY)
    public String sourceURI;

    @SerializedName("use_sr")
    @RpcField(FieldType.QUERY)
    public boolean useSR;

    @RpcField(FieldType.QUERY)
    public int width;

    static {
        Covode.recordClassIndex(612966);
        fieldTypeClassRef = FieldType.class;
    }
}
