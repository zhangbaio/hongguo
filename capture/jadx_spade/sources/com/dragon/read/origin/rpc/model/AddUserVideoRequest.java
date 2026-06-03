package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AddUserVideoRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_name")
    @RpcField(FieldType.BODY)
    public String bookName;

    @RpcField(FieldType.BODY)
    public String desc;

    @RpcField(FieldType.BODY)
    public double duration;

    @SerializedName("is_ai_generated")
    @RpcField(FieldType.BODY)
    public boolean isAIGenerated;

    @SerializedName("thumb_uri")
    @RpcField(FieldType.BODY)
    public String thumbUri;

    @RpcField(FieldType.BODY)
    public String vid;

    static {
        Covode.recordClassIndex(612717);
        fieldTypeClassRef = FieldType.class;
    }
}
