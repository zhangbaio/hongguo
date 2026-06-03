package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortArticleCheckPreMetaResp implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("check_type")
    @RpcField(FieldType.BODY)
    public ShortArticleCheckPreType checkType;

    @SerializedName("hit_message")
    @RpcField(FieldType.BODY)
    public String hitMessage;

    @SerializedName("is_hit")
    @RpcField(FieldType.BODY)
    public boolean isHit;

    static {
        Covode.recordClassIndex(613435);
        fieldTypeClassRef = FieldType.class;
    }
}
