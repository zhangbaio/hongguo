package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAnchorData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("anchor_map")
    public Map<String, AnchorData> anchorMap;

    @SerializedName("frequency_rules")
    public List<AnchorFrequencyRule> frequencyRules;

    static {
        Covode.recordClassIndex(612107);
        fieldTypeClassRef = FieldType.class;
    }
}
