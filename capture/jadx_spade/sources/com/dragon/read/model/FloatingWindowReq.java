package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FloatingWindowReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("client_style")
    public String clientStyle;

    static {
        Covode.recordClassIndex(612102);
        fieldTypeClassRef = FieldType.class;
    }
}
