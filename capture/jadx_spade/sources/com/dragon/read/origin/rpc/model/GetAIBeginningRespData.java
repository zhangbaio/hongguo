package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAIBeginningRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public String content;

    @RpcField(FieldType.BODY)
    public boolean finished;

    @SerializedName("next_offset")
    @RpcField(FieldType.BODY)
    public long nextOffset;

    static {
        Covode.recordClassIndex(612978);
        fieldTypeClassRef = FieldType.class;
    }
}
