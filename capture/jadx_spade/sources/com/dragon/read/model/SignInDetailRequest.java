package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SignInDetailRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("skip_excitation")
    @RpcField(FieldType.QUERY)
    public int skipExcitation;

    static {
        Covode.recordClassIndex(612252);
        fieldTypeClassRef = FieldType.class;
    }
}
