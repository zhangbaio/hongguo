package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PublishFlightGroup implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("alias_name")
    public String aliasName;

    @SerializedName("alias_thumb_uri")
    public String aliasThumbURI;

    static {
        Covode.recordClassIndex(613336);
        fieldTypeClassRef = FieldType.class;
    }
}
