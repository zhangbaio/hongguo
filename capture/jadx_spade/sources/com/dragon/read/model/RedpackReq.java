package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class RedpackReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("acquisition_source")
    @RpcField(FieldType.QUERY)
    public String acquisitionSource;

    static {
        Covode.recordClassIndex(612213);
        fieldTypeClassRef = FieldType.class;
    }
}
