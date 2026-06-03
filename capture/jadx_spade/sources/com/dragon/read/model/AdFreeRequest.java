package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AdFreeRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ad_free_hours")
    public int adFreeHours;

    @SerializedName("inactive_type")
    public int inactiveType;

    @SerializedName("listen_ad_free_hours")
    public int listenAdFreeHours;

    @SerializedName("read_ad_free_hours")
    public int readAdFreeHours;

    @SerializedName("vip_present_hours")
    public int vipPresentHours;

    static {
        Covode.recordClassIndex(611999);
        fieldTypeClassRef = FieldType.class;
    }
}
