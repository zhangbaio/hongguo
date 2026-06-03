package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class HandleArticleTimerPreviewRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    @RpcField(FieldType.BODY)
    public String bookID;

    @SerializedName("item_id")
    @RpcField(FieldType.BODY)
    public String itemID;

    @SerializedName("preview_content")
    @RpcField(FieldType.BODY)
    public String previewContent;

    @SerializedName("preview_type")
    @RpcField(FieldType.BODY)
    public short previewType;

    static {
        Covode.recordClassIndex(613181);
        fieldTypeClassRef = FieldType.class;
    }
}
