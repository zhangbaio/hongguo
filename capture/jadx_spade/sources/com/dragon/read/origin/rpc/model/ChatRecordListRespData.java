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
public class ChatRecordListRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("chat_record_list")
    @RpcField(FieldType.BODY)
    public List<ChatRecord> chatRecordList;

    @RpcField(FieldType.BODY)
    public int count;

    @SerializedName("has_more")
    @RpcField(FieldType.BODY)
    public boolean hasMore;

    static {
        Covode.recordClassIndex(612806);
        fieldTypeClassRef = FieldType.class;
    }
}
