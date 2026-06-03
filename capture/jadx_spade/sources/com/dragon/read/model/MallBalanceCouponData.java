package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MallBalanceCouponData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("coupon_list")
    public List<CouponData> couponList;

    @SerializedName("task_event_param")
    public TaskEventParam taskEventParam;
    public String title;

    static {
        Covode.recordClassIndex(612148);
        fieldTypeClassRef = FieldType.class;
    }
}
