package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AddAlbumVideoOrderRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("album_id")
    @RpcField(FieldType.BODY)
    public String albumId;

    @SerializedName("ctx_uid")
    @RpcField(FieldType.BODY)
    public long ctxUid;

    @SerializedName("video_order")
    @RpcField(FieldType.BODY)
    public Map<Long, Integer> videoOrder;

    static {
        Covode.recordClassIndex(612703);
        fieldTypeClassRef = FieldType.class;
    }
}
