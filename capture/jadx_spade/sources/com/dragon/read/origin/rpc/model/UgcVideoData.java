package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcVideoData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("album_info")
    @RpcField(FieldType.BODY)
    public AlbumInfoData albumInfoData;

    @SerializedName("audit_info")
    @RpcField(FieldType.BODY)
    public AuditInfoData auditInfo;

    @RpcField(FieldType.BODY)
    public VideoCommon common;

    @SerializedName("consumer_info")
    @RpcField(FieldType.BODY)
    public ConsumeInfoData consumeInfo;

    @RpcField(FieldType.BODY)
    public VideoExpand expand;

    @RpcField(FieldType.BODY)
    public VideoStat stat;

    @SerializedName("user_action")
    @RpcField(FieldType.BODY)
    public VideoUserAction userAction;

    @SerializedName("video_id")
    @RpcField(FieldType.BODY)
    public String videoID;

    static {
        Covode.recordClassIndex(613534);
        fieldTypeClassRef = FieldType.class;
    }
}
