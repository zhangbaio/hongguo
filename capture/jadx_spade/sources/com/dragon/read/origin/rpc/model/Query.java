package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class Query implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public String field;

    @RpcField(FieldType.BODY)
    public String operator;

    @RpcField(FieldType.BODY)
    public List<Query> queries;

    @RpcField(FieldType.BODY)
    public String value;

    static {
        Covode.recordClassIndex(613350);
        fieldTypeClassRef = FieldType.class;
    }
}
