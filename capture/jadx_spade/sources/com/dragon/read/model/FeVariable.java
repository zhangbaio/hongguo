package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FeVariable implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<String> dependencies;

    @SerializedName("fe_decision")
    public String feDecision;

    @SerializedName("variable_key")
    public String variableKey;

    static {
        Covode.recordClassIndex(612099);
        fieldTypeClassRef = FieldType.class;
    }
}
