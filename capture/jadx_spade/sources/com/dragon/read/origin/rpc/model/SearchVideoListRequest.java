package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SearchVideoListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("current_album_id")
    @RpcField(FieldType.QUERY)
    public String currentAlbumID;

    @SerializedName("key_word")
    @RpcField(FieldType.QUERY)
    public String keyWord;

    static {
        Covode.recordClassIndex(613408);
        fieldTypeClassRef = FieldType.class;
    }
}
