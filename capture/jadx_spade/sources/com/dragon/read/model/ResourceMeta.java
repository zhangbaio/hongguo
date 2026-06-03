package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ResourceMeta implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("landing_key")
    public String landingKey;

    @SerializedName("resource_key")
    public String resourceKey;

    @SerializedName("resource_type")
    public String resourceType;

    static {
        Covode.recordClassIndex(612230);
        fieldTypeClassRef = FieldType.class;
    }
}
