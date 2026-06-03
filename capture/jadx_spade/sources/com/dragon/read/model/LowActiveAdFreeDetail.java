package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class LowActiveAdFreeDetail implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ad_free_hours")
    public int adFreeHours;

    @SerializedName("button_text")
    public String buttonText;

    @SerializedName("popup_type")
    public String popupType;

    @SerializedName("reward_type")
    public int rewardType;

    @SerializedName("sub_title")
    public String subTitle;
    public String title;

    static {
        Covode.recordClassIndex(612143);
        fieldTypeClassRef = FieldType.class;
    }
}
