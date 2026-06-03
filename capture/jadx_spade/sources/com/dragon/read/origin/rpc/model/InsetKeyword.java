package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InsetKeyword implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public List<InsetKeyword> children;

    @RpcField(FieldType.BODY)
    public short level;

    @RpcField(FieldType.BODY)
    public String name;

    @RpcField(FieldType.BODY)
    public short sampling;

    @RpcField(FieldType.BODY)
    public String type;

    static {
        Covode.recordClassIndex(613197);
        fieldTypeClassRef = FieldType.class;
    }
}
