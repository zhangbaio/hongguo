package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaveChatRecordRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public String content;

    @SerializedName("message_type")
    @RpcField(FieldType.BODY)
    public ChatRecordMessageType messageType;

    @RpcField(FieldType.BODY)
    public short type;

    static {
        Covode.recordClassIndex(613393);
        fieldTypeClassRef = FieldType.class;
    }
}
