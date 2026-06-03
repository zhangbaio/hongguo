package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UploadPicV1Request implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ai_label")
    @RpcField(FieldType.QUERY)
    public String aILabel;

    @SerializedName("blind_watermark")
    @RpcField(FieldType.QUERY)
    public String blindWatermark;

    @SerializedName("Headers")
    public Map<String, List<String>> headers;

    @SerializedName("image_scene")
    public ImageScene imageScene;

    @SerializedName("need_inner_url")
    @RpcField(FieldType.QUERY)
    public boolean needInnerURL;

    @SerializedName("need_public")
    @RpcField(FieldType.QUERY)
    public boolean needPublic;

    @SerializedName("RawBody")
    public ByteBuffer rawBody;

    @RpcField(FieldType.QUERY)
    public boolean watermark;

    static {
        Covode.recordClassIndex(613545);
        fieldTypeClassRef = FieldType.class;
    }
}
