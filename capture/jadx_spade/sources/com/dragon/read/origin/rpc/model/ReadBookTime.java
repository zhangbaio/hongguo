package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReadBookTime implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    @RpcField(FieldType.BODY)
    public long bookId;

    @SerializedName("read_duration")
    @RpcField(FieldType.BODY)
    public long readDuration;

    @SerializedName("user_id")
    @RpcField(FieldType.BODY)
    public long userId;

    static {
        Covode.recordClassIndex(613354);
        fieldTypeClassRef = FieldType.class;
    }
}
