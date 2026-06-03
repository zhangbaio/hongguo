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
public class GetAIConsultRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public String content;

    @SerializedName("content_item")
    @RpcField(FieldType.BODY)
    public AIContentItem contentItem;

    @RpcField(FieldType.BODY)
    public boolean finished;

    @SerializedName("hit_sensitive")
    @RpcField(FieldType.BODY)
    public boolean hitSensitive;

    @SerializedName("next_offset")
    @RpcField(FieldType.BODY)
    public long nextOffset;

    @SerializedName("reasoning_content_item")
    @RpcField(FieldType.BODY)
    public AIContentItem reasoningContentItem;

    @SerializedName("recommend_questions")
    @RpcField(FieldType.BODY)
    public List<String> recommendQuestions;

    static {
        Covode.recordClassIndex(612990);
        fieldTypeClassRef = FieldType.class;
    }
}
