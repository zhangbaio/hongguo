package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class Page implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("page_no")
    @RpcField(FieldType.BODY)
    public int pageNo;

    @SerializedName("page_size")
    @RpcField(FieldType.BODY)
    public int pageSize;

    static {
        Covode.recordClassIndex(613274);
        fieldTypeClassRef = FieldType.class;
    }
}
