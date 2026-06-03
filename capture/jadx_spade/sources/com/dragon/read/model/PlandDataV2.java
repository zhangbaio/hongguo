package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PlandDataV2 implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("landing_data")
    public LandingDataV2 landingData;

    @SerializedName("plan_data")
    public Map<String, Map<String, PlanData>> planData;

    static {
        Covode.recordClassIndex(612191);
        fieldTypeClassRef = FieldType.class;
    }
}
