package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FileData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public ByteBuffer binary;
    public String name;
    public String type;

    @SerializedName("uri")
    public String uRI;

    @SerializedName("url")
    public String uRL;

    static {
        Covode.recordClassIndex(612929);
        fieldTypeClassRef = FieldType.class;
    }
}
