package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAIInsetHistoryRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ai_inset_type")
    @RpcField(FieldType.QUERY)
    public AIInsetType aIInsetType;

    @SerializedName("book_id")
    @RpcField(FieldType.QUERY)
    public long bookID;

    @SerializedName("page_count")
    @RpcField(FieldType.QUERY)
    public short pageCount;

    @SerializedName("page_index")
    @RpcField(FieldType.QUERY)
    public short pageIndex;

    @RpcField(FieldType.QUERY)
    public AIInsetScene scene;

    static {
        Covode.recordClassIndex(613016);
        fieldTypeClassRef = FieldType.class;
    }
}
