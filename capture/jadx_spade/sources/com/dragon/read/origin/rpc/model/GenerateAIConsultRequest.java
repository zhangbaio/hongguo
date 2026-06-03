package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GenerateAIConsultRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("dialog_id")
    @RpcField(FieldType.BODY)
    public long dialogID;

    @SerializedName("history_messages")
    @RpcField(FieldType.BODY)
    public String historyMessages;

    @SerializedName("need_recommend_questions")
    @RpcField(FieldType.BODY)
    public boolean needRecommendQuestions;

    @SerializedName("need_thinking")
    @RpcField(FieldType.BODY)
    public boolean needThinking;

    @RpcField(FieldType.BODY)
    public String prompt;

    static {
        Covode.recordClassIndex(612942);
        fieldTypeClassRef = FieldType.class;
    }
}
