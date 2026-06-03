package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ChatRecordListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.QUERY)
    public int limit;

    @SerializedName("max_chat_record_id")
    @RpcField(FieldType.QUERY)
    public long maxChatRecordID;

    static {
        Covode.recordClassIndex(612805);
        fieldTypeClassRef = FieldType.class;
    }
}
