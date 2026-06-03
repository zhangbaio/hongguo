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
public class BannedMultipleNamePermission implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("can_modify")
    @RpcField(FieldType.BODY)
    public short canModify;

    @SerializedName("flight_id")
    @RpcField(FieldType.BODY)
    public String flightID;

    @SerializedName("name_list")
    @RpcField(FieldType.BODY)
    public List<MultipleNamePermissionMeta> nameList;

    static {
        Covode.recordClassIndex(612766);
        fieldTypeClassRef = FieldType.class;
    }
}
