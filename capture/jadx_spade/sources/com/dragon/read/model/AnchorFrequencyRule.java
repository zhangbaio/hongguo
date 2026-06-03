package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AnchorFrequencyRule implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("rule_type")
    public String ruleType;

    @SerializedName("rule_value")
    public int ruleValue;

    static {
        Covode.recordClassIndex(612007);
        fieldTypeClassRef = FieldType.class;
    }
}
