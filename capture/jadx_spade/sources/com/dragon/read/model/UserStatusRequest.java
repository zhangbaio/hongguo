package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UserStatusRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("is_lhft_active")
    public String isLhftActive;
    public String scene;

    @SerializedName("unit_id_rule")
    public String unitIdRule;

    static {
        Covode.recordClassIndex(612288);
        fieldTypeClassRef = FieldType.class;
    }
}
