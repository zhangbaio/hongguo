package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AIPicWatermarkRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int height;

    @SerializedName("pic_uri")
    public String picUri;

    @SerializedName("pic_url")
    public String picUrl;
    public int width;

    static {
        Covode.recordClassIndex(612693);
        fieldTypeClassRef = FieldType.class;
    }
}
