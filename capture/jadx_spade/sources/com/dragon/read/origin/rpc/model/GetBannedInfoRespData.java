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
public class GetBannedInfoRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_permission")
    @RpcField(FieldType.BODY)
    public BannedBookPermission bookPermission;

    @SerializedName("multiple_name_permission")
    @RpcField(FieldType.BODY)
    public List<BannedMultipleNamePermission> multipleNamePermission;

    @SerializedName("reputation_name_permission")
    @RpcField(FieldType.BODY)
    public BannedReputationNamePermission reputationNamePermission;

    static {
        Covode.recordClassIndex(613059);
        fieldTypeClassRef = FieldType.class;
    }
}
