package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UploadPicRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Headers")
    public Map<String, List<String>> headers;

    @SerializedName("image_scene")
    public ImageScene imageScene;

    @SerializedName("RawBody")
    public ByteBuffer rawBody;

    static {
        Covode.recordClassIndex(613542);
        fieldTypeClassRef = FieldType.class;
    }
}
