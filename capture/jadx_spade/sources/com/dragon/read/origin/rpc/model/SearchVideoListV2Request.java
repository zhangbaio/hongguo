package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SearchVideoListV2Request implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.QUERY)
    public short count;

    @SerializedName("current_album_id")
    @RpcField(FieldType.QUERY)
    public String currentAlbumID;

    @SerializedName("first_cursor")
    @RpcField(FieldType.QUERY)
    public long firstCursor;

    @SerializedName("key_word")
    @RpcField(FieldType.QUERY)
    public String keyWord;

    @SerializedName("last_cursor")
    @RpcField(FieldType.QUERY)
    public long lastCursor;

    @RpcField(FieldType.QUERY)
    public boolean reverse;

    static {
        Covode.recordClassIndex(613411);
        fieldTypeClassRef = FieldType.class;
    }
}
