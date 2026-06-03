package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InactiveInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("expire_time")
    public long expireTime;

    @SerializedName("first_read_popup")
    public boolean firstReadPopup;
    public int hours;

    @SerializedName("listen_ad_free_hours")
    public int listenAdFreeHours;

    @SerializedName("low_activity_popup")
    public boolean lowActivityPopup;
    public boolean popup;

    @SerializedName("read_ad_free_hours")
    public int readAdFreeHours;
    public int type;

    @SerializedName("vip_present")
    public VipPresentInfo vipPresent;

    static {
        Covode.recordClassIndex(612123);
        fieldTypeClassRef = FieldType.class;
    }
}
