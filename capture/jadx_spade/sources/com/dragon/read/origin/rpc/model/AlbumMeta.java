package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AlbumMeta implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("album_id")
    @RpcField(FieldType.BODY)
    public String albumID;

    @SerializedName("album_name")
    @RpcField(FieldType.BODY)
    public String albumName;

    @SerializedName("audit_info")
    @RpcField(FieldType.BODY)
    public AuditInfoData auditInfo;

    @RpcField(FieldType.BODY)
    public String desc;

    @SerializedName("play_times")
    @RpcField(FieldType.BODY)
    public String playTimes;

    @SerializedName("publish_time")
    @RpcField(FieldType.BODY)
    public String publishTime;

    @SerializedName("thumb_url")
    @RpcField(FieldType.BODY)
    public String thumbUrl;

    static {
        Covode.recordClassIndex(612730);
        fieldTypeClassRef = FieldType.class;
    }
}
