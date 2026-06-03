package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ChatRecord implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("chat_record_id")
    @RpcField(FieldType.BODY)
    public String chatRecordID;

    @RpcField(FieldType.BODY)
    public String content;

    @SerializedName("message_type")
    @RpcField(FieldType.BODY)
    public ChatRecordMessageType messageType;

    @SerializedName("send_time")
    @RpcField(FieldType.BODY)
    public long sendTime;

    @RpcField(FieldType.BODY)
    public short type;

    static {
        Covode.recordClassIndex(612804);
        fieldTypeClassRef = FieldType.class;
    }
}
