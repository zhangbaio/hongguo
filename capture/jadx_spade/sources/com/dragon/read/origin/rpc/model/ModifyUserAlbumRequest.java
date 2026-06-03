package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ModifyUserAlbumRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("album_id")
    @RpcField(FieldType.BODY)
    public String albumId;

    @SerializedName("album_name")
    @RpcField(FieldType.BODY)
    public String albumName;

    @SerializedName("ctx_uid")
    @RpcField(FieldType.BODY)
    public long ctxUid;

    @RpcField(FieldType.BODY)
    public String desc;

    @SerializedName("thumb_uri")
    @RpcField(FieldType.BODY)
    public String thumbUri;

    static {
        Covode.recordClassIndex(613237);
        fieldTypeClassRef = FieldType.class;
    }
}
