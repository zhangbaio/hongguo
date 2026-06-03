package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GenerateAIContinuationRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;
    public String content;

    @SerializedName("current_item_content")
    @RpcField(FieldType.BODY)
    public String currentItemContent;

    @SerializedName("following_summary")
    @RpcField(FieldType.BODY)
    public String followingSummary;

    @SerializedName("item_id")
    public long itemID;
    public String recap;

    static {
        Covode.recordClassIndex(612945);
        fieldTypeClassRef = FieldType.class;
    }
}
