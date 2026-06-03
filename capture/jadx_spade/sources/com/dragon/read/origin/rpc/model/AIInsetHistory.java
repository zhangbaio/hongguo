package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AIInsetHistory implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ai_generate_inset_list")
    @RpcField(FieldType.BODY)
    public List<AIGenerateInset> aIGenerateInsetList;

    @SerializedName("ai_inset_style")
    @RpcField(FieldType.BODY)
    public AIInsetStyle aIInsetStyle;

    @SerializedName("ai_inset_type")
    @RpcField(FieldType.BODY)
    public AIInsetType aIInsetType;

    @SerializedName("create_time")
    @RpcField(FieldType.BODY)
    public long createTime;

    @SerializedName("highlights_type")
    @RpcField(FieldType.BODY)
    public HighlightsType highlightsType;

    @RpcField(FieldType.BODY)
    public String prompt;

    @SerializedName("source_uri")
    @RpcField(FieldType.BODY)
    public String sourceURI;

    @SerializedName("source_url")
    @RpcField(FieldType.BODY)
    public String sourceURL;

    static {
        Covode.recordClassIndex(612687);
        fieldTypeClassRef = FieldType.class;
    }
}
