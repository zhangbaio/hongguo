package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NewUserSignInRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("enter_from")
    @RpcField(FieldType.QUERY)
    public String enterFrom;

    @SerializedName("reactive_type")
    @RpcField(FieldType.QUERY)
    public String reactiveType;

    @SerializedName("skip_excitation")
    @RpcField(FieldType.QUERY)
    public int skipExcitation;

    @RpcField(FieldType.QUERY)
    public String source;

    @SerializedName("task_key")
    public String taskKey;

    static {
        Covode.recordClassIndex(612159);
        fieldTypeClassRef = FieldType.class;
    }
}
