package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EditArticleV1Request implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("from_source")
    @RpcField(FieldType.QUERY)
    public EditArticleFromSource fromSource;

    @SerializedName("item_id")
    public long itemID;

    static {
        Covode.recordClassIndex(612910);
        fieldTypeClassRef = FieldType.class;
    }
}
