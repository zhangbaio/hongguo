package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class WeakUserExpansion implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("expansion_coefficient")
    public double expansionCoefficient;

    @SerializedName("is_hit")
    public boolean isHit;

    @SerializedName("limit_day")
    public int limitDay;

    @SerializedName("today_expansion")
    public boolean todayExpansion;

    @SerializedName("tomorrow_expansion")
    public boolean tomorrowExpansion;

    static {
        Covode.recordClassIndex(612301);
        fieldTypeClassRef = FieldType.class;
    }
}
