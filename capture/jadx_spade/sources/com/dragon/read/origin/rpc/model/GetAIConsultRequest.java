package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAIConsultRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("filter_sensitive")
    @RpcField(FieldType.QUERY)
    public boolean filterSensitive;

    @SerializedName("generate_id")
    @RpcField(FieldType.QUERY)
    public long generateID;

    @RpcField(FieldType.QUERY)
    public long offset;

    @SerializedName("reasoning_offset")
    @RpcField(FieldType.QUERY)
    public long reasoningOffset;

    static {
        Covode.recordClassIndex(612989);
        fieldTypeClassRef = FieldType.class;
    }
}
