package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GenerateAIInsetSimplifiedRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    @RpcField(FieldType.BODY)
    public long bookID;

    @SerializedName("category_name")
    @RpcField(FieldType.BODY)
    public String categoryName;

    @RpcField(FieldType.BODY)
    public String content;

    @RpcField(FieldType.BODY)
    public int height;

    @SerializedName("item_id")
    @RpcField(FieldType.BODY)
    public long itemID;

    @RpcField(FieldType.BODY)
    public String title;

    @RpcField(FieldType.BODY)
    public int width;

    static {
        Covode.recordClassIndex(612963);
        fieldTypeClassRef = FieldType.class;
    }
}
