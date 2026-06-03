package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class LoopReward implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("background_speed")
    public int backgroundSpeed;

    @SerializedName("box_increase_style")
    public String boxIncreaseStyle;

    @SerializedName("remind_increase_style")
    public String remindIncreaseStyle;
    public int speed;
    public String type;

    static {
        Covode.recordClassIndex(612142);
        fieldTypeClassRef = FieldType.class;
    }
}
