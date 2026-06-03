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
public class BannedBookPermission implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("all_chapter_modify")
    @RpcField(FieldType.BODY)
    public boolean allChapterModify;

    @SerializedName("can_modify")
    @RpcField(FieldType.BODY)
    public short canModify;

    @RpcField(FieldType.BODY)
    public List<BannedModifyLocation> location;

    static {
        Covode.recordClassIndex(612764);
        fieldTypeClassRef = FieldType.class;
    }
}
