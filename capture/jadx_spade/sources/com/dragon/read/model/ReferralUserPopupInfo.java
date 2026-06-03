package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReferralUserPopupInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("is_pop")
    public boolean isPop;

    @SerializedName("lynx_schema")
    public String lynxSchema;

    static {
        Covode.recordClassIndex(612217);
        fieldTypeClassRef = FieldType.class;
    }
}
