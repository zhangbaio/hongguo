package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcStreamAudioFileDataLite implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("duration_ms")
    public long durationMS;

    @SerializedName("uri")
    public String uRI;

    @SerializedName("url")
    public String uRL;

    static {
        Covode.recordClassIndex(613525);
        fieldTypeClassRef = FieldType.class;
    }
}
