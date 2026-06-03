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
public class GetAlbumVideoListRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("album_data")
    @RpcField(FieldType.BODY)
    public AlbumData albumData;

    @SerializedName("video_data_list")
    @RpcField(FieldType.BODY)
    public List<UgcVideoData> videoDataList;

    static {
        Covode.recordClassIndex(613029);
        fieldTypeClassRef = FieldType.class;
    }
}
