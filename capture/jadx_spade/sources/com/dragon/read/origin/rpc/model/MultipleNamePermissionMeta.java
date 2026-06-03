package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MultipleNamePermissionMeta implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_name")
    @RpcField(FieldType.BODY)
    public String bookName;

    @RpcField(FieldType.BODY)
    public List<BannedModifyLocation> location;

    @SerializedName("version_id")
    @RpcField(FieldType.BODY)
    public String versionID;

    static {
        Covode.recordClassIndex(613246);
        fieldTypeClassRef = FieldType.class;
    }
}
