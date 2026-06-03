package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CheckFrequencyRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("hit_create_book")
    @RpcField(FieldType.BODY)
    public boolean hitCreateBook;

    @SerializedName("hit_create_book_icon_text")
    @RpcField(FieldType.BODY)
    public String hitCreateBookIconText;

    @SerializedName("hit_create_book_icon_url")
    @RpcField(FieldType.BODY)
    public String hitCreateBookIconURL;

    @SerializedName("hit_create_book_message")
    @RpcField(FieldType.BODY)
    public String hitCreateBookMessage;

    static {
        Covode.recordClassIndex(612811);
        fieldTypeClassRef = FieldType.class;
    }
}
