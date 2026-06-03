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
public class GetAIInsetHistoryRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ai_inset_history_list")
    @RpcField(FieldType.BODY)
    public List<AIInsetHistory> aIInsetHistoryList;

    @RpcField(FieldType.BODY)
    public int total;

    static {
        Covode.recordClassIndex(613017);
        fieldTypeClassRef = FieldType.class;
    }
}
