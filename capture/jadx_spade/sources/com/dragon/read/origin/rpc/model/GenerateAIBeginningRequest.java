package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GenerateAIBeginningRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    @RpcField(FieldType.BODY)
    public long bookID;

    @RpcField(FieldType.BODY)
    public String category;

    @RpcField(FieldType.BODY)
    public String character;

    @SerializedName("item_id")
    @RpcField(FieldType.BODY)
    public long itemID;

    @RpcField(FieldType.BODY)
    public String outline;

    @RpcField(FieldType.BODY)
    public String setting;

    @RpcField(FieldType.BODY)
    public String summary;

    @RpcField(FieldType.BODY)
    public String synopsis;

    @RpcField(FieldType.BODY)
    public String worldview;

    static {
        Covode.recordClassIndex(612936);
        fieldTypeClassRef = FieldType.class;
    }
}
