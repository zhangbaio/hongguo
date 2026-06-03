package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PendantInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("cold_start_attribute_info")
    public ColdStartAttributeInfo coldStartAttributeInfo;

    @SerializedName("coupon_info")
    public PendantCouponInfo couponInfo;
    public String schema;
    public boolean show;
    public String type;

    static {
        Covode.recordClassIndex(612184);
        fieldTypeClassRef = FieldType.class;
    }
}
