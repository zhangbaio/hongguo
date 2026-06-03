package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class DeleteArticleRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("is_draft")
    @RpcField(FieldType.BODY)
    public int isDraft;

    @SerializedName("item_id")
    public long itemID;

    static {
        Covode.recordClassIndex(612870);
        fieldTypeClassRef = FieldType.class;
    }
}
