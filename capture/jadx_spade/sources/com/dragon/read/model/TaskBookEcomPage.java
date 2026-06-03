package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TaskBookEcomPage implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("balance_coupon_module")
    public MallBalanceCouponData balanceCouponModule;

    @SerializedName("gold_box_data")
    public MallGoldBoxData goldBoxData;

    @SerializedName("task_bar")
    public MallTaskBar taskBar;
    public String title;

    static {
        Covode.recordClassIndex(612268);
        fieldTypeClassRef = FieldType.class;
    }
}
