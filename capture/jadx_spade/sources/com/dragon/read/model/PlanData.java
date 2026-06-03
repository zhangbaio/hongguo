package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PlanData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("event_key")
    public String eventKey;

    @SerializedName("plan_key")
    public String planKey;
    public List<ResourceWithPositioning> resources;
    public String type;

    static {
        Covode.recordClassIndex(612186);
        fieldTypeClassRef = FieldType.class;
    }
}
